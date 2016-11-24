import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/**
 * Write a description of class Ultrasoon here.
 * 
 * @author Zwen van Erkelens 
 * @version (a version number or a date)
 */
public class Ultrasoon
{
    private static ScheduledFuture<?> _blinker;

    public static void startDetection()
    {      
        System.out.println("Starting Ultrasoon Sensor..");

        if (_blinker != null && !_blinker.isDone())
        {
            System.out.println("Already running, returning..");            
            return;
        }

        _blinker = TimerHandler.Timer.scheduleWithFixedDelay(
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
        if (_blinker != null) _blinker.cancel(true);
    }
}
