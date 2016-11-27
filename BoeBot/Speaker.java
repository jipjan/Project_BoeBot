import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/**
 * Hardware class voor de speaker/buzzer
 * 
 * @author Groep B1
 */

public class Speaker
{
    private static ScheduledFuture<?> _beep;
    
    public static void beepOnce(int frequency, int duration)
    {    
        stop();
        BoeBot.freqOut(Constants.BUZZER_PIN, frequency, duration);        
    }
    
    public static void beepContinuous(int frequency, int duration, int timeout)
    {
        stop();
        _beep = TimerHandler.Timer.scheduleWithFixedDelay(() ->
               BoeBot.freqOut(Constants.BUZZER_PIN, frequency, duration) 
            , 0, timeout, MILLISECONDS);
    }
    
    public static void stop()
    {
        if (_beep != null) _beep.cancel(true);
    }
}
