import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/**
 * Detectie voor de ultrasoon sensor.
 * 
 * @author Groep B1
 */
public class Ultrasoon
{
    private static boolean _collided;
    private static ScheduledFuture<?> _timer;
    
    /*
     * Start de detectie met de ultrasoon sensor.
     */
    public static void startDetection()
    {      
        System.out.println("Starting " + "Ultrasoon" + " Collision Detection...");        
        if (_timer != null && !_timer.isDone())        
            System.out.println("Already running, returning..");            
        else
            _timer = TimerHandler.Timer.scheduleWithFixedDelay(() -> 
            {
                BoeBot.digitalWrite(Constants.ULTRASOON_IN_PIN, true);
                BoeBot.wait(1);
                BoeBot.digitalWrite(Constants.ULTRASOON_IN_PIN, false);

                collisionCheck(BoeBot.pulseIn(Constants.ULTRASOON_OUT_PIN, true, 10000));     
            }
            , 0, 100, MILLISECONDS);                 
    }

    /*
     * Controleer of er een object te dichtbij aan het komen is en stop eventueel.
     */
    private static void collisionCheck(int pulse)
    {
        if (pulse == -2)
            System.out.println("Ultrasoon not connected, or is experiencing issues...");
        else
        {
            if (pulse < Constants.ULTRASOON_DISTANCE)
                collided(_collided);
            else if (_collided)
            {  
                _collided = false;
                BoardLights.stop();
            }
        }
    }
    
    protected static void collided(boolean collided)
    {
        if (!collided)
        {
            collided = true;
            System.out.println("Collision Imminent, stopping...");  
            Engines.breakBot();
            BoardLights.alarmLights();
        }
    }

}
