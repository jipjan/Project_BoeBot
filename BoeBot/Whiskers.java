import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/**
 * Write a description of class Voelsprieten here.
 * 
 * @author Zwen van Erkelens 
 * @version (a version number or a date)
 */
public class Whiskers
{
    private static ScheduledFuture<?> _whiskers;
    private static boolean _collided = false;

    public static void startDetection()
    {
        System.out.println("Starting Whisker Collision Detection..");

        if (_whiskers != null && !_whiskers.isDone())
        {
            System.out.println("Already running, returning..");            
            return;
        }      

        _whiskers = TimerHandler.Timer.scheduleWithFixedDelay(() -> 
                collisionCheck(
                    !BoeBot.digitalRead(Constants.WHISKER_LEFT_PIN),
                    !BoeBot.digitalRead(Constants.WHISKER_RIGHT_PIN)
                ), 0, 100, MILLISECONDS);
    }

    private static void collisionCheck(boolean left, boolean right)
    {
        if (left && right)
            collided("Collision Center");        
        else if (left)                 
            collided("Collision Left");        
        else if (right) 
            collided("Collision Right");        
        else if (_collided)
        {  
            _collided = false;
            BoardLights.stop();
        }
    }

    private static void collided(String print)
    {
        System.out.println(print);
        if (!_collided)
        {
            _collided = true;
            System.out.println("Collision Imminent, stopping...");               
            Engines.breakBot();
            BoardLights.alarmLights();
        }
    }

    public static boolean hasCollided()
    {
        return _collided;
    }
   

    public static void stopDetection()
    {
        if (_whiskers != null) _whiskers.cancel(true);
    }

}
