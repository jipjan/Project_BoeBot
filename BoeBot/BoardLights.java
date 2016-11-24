import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/**
 * BoardLight handler
 * 
 * @author Groep B1
 */
public class BoardLights
{   
    private static ScheduledFuture<?> _lights;    
    private static boolean _on = true;

    public static void alarmLights()
    {
        stop();
        _lights = TimerHandler.Timer.scheduleWithFixedDelay(() -> 
            {
                if (_on) reset();
                else
                {
                    BoeBot.rgbSet(0, 255, 0, 0);
                    BoeBot.rgbSet(2, 255, 0, 0);
                    BoeBot.rgbSet(3, 255, 0, 0);
                    BoeBot.rgbSet(5, 255, 0, 0);
                    BoeBot.rgbShow();
                }
                _on = !_on;
            }, 0, 500, MILLISECONDS);
    }

    public static void rightLights()
    {
        stop();
        _lights = TimerHandler.Timer.scheduleWithFixedDelay(() -> 
            {
                if (_on) reset();
                else
                {
                    BoeBot.rgbSet(0, 255, 165, 0);
                    BoeBot.rgbSet(5, 255, 165, 0);
                    BoeBot.rgbShow();
                }
                _on = !_on;
            }, 0, 500, MILLISECONDS);
    }

    public static void leftLights()
    {
        stop();
        _lights = TimerHandler.Timer.scheduleWithFixedDelay(() -> 
            {
                if (_on) reset();
                else
                {
                    BoeBot.rgbSet(2, 255, 165, 0);
                    BoeBot.rgbSet(3, 255, 165, 0);
                    BoeBot.rgbShow();
                }
                _on = !_on;
            }, 0, 500, MILLISECONDS);
    }

    public static void stop()
    {
        if (_lights != null) _lights.cancel(true);        
        reset();
        _on = false;
    }

    private static void reset()
    {
        BoeBot.rgbSet(0, 0, 0, 0);
        BoeBot.rgbSet(1, 0, 0, 0);
        BoeBot.rgbSet(2, 0, 0, 0);
        BoeBot.rgbSet(3, 0, 0, 0);
        BoeBot.rgbSet(4, 0, 0, 0);
        BoeBot.rgbSet(5, 0, 0, 0);
        BoeBot.rgbShow();
    }
}
