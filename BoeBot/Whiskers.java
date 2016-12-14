import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/**
 * Detectie van de voelsprieten.
 * 
 * @author Groep B1
 */
public class Whiskers
{
    protected static boolean _collided;
    protected static ScheduledFuture<?> _timer;
    
    /*
     * Start de detectie van een botsing met de voelsprieten.
     */
    public static void startDetection()
    {
         System.out.println("Starting " + "Whiskers" + " Collision Detection...");        
        if (_timer != null && !_timer.isDone())        
            System.out.println("Already running, returning..");            
        else
            _timer = TimerHandler.Timer.scheduleWithFixedDelay(() -> {
                collisionCheck(
                    !BoeBot.digitalRead(Constants.WHISKER_LEFT_PIN),
                    !BoeBot.digitalRead(Constants.WHISKER_RIGHT_PIN)
                );
            }, 0, 100, MILLISECONDS); 
    }

    /*
     * Controleer wat voor soort botsing er is.
     */
    private static void collisionCheck(boolean left, boolean right)
    {
        if (left && right)
            collided(_collided);        
        else if (left)                 
            collided(_collided);        
        else if (right) 
            collided(_collided);        
        else if (_collided)
        {  
            _collided = false;
            BoardLights.stop();
        }
    }   

    protected static void collided(boolean collided)
    {
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
}
