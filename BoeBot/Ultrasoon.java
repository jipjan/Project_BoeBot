import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/**
 * Collision Detection Class
 * 
 * @author Zwen van Erkelens 
 * @version (a version number or a date)
 */
public class Ultrasoon
{
    private static ScheduledFuture<?> _ultrasoon;

    public static void startDetection()
    {      
        System.out.println("Starting Ultrasoon Sensor..");

        if (_ultrasoon != null && !_ultrasoon.isDone())
        {
            System.out.println("Already running, returning..");            
            return;
        }

        _ultrasoon = TimerHandler.Timer.scheduleWithFixedDelay(
            () -> 
            {
                BoeBot.digitalWrite(Constants.ULTRASOON_IN_PIN, true);
                BoeBot.wait(1);
                BoeBot.digitalWrite(Constants.ULTRASOON_IN_PIN, false);

                collisionCheck(BoeBot.pulseIn(Constants.ULTRASOON_OUT_PIN, true, 10000));                
            }, 0, 100, MILLISECONDS);     
    }
    
    private static void collisionCheck(int pulse)
    {
        if (pulse < Constants.ULTRASOON_DISTANCE)
        {
            System.out.println("Collision Imminent, stopping...");
            Engines.breakBot();
        }        
    }

    public static void stopDetection()
    {
        if (_ultrasoon != null) _ultrasoon.cancel(true);
    }
}