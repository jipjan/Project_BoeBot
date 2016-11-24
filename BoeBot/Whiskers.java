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
                ), 0, 250, MILLISECONDS);
    }

    private static void collisionCheck(boolean left, boolean right)
    {
        if (left && right)
            System.out.println("Collision Center");
        else if (left)
            System.out.println("Collision Left");                  
        else if (right)
            System.out.println("Collision Right");      
    }

    public static void stopDetection()
    {
        if (_whiskers != null) _whiskers.cancel(true);
    }

}
