import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;
import java.awt.*;

/**
 * BoardLight handler
 * 
 * @author Groep B1
 */
public class BoardLights 
/*
     * Laat de Boebot zijn LED lampjes branden bij verschillende acties.
*/
{   
    private static ScheduledFuture<?> _lights;    
    private static boolean _on = true;

    public static void alarmLights()
    { //knipperend rood voor stop.
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
    {   // knipperent geel als de Boebot naar rechts rijd.
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
    {   // knipperent geel als de Boebot naar links rijd.
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

    private static float cycle = 0;

    public static void cycle()
    {
        stop();
        _lights = TimerHandler.Timer.scheduleWithFixedDelay(() ->
            {
                setColorOnAll(Color.getHSBColor(cycle, 1, 1));
                cycle += 0.01f;
            }, 0, 10, MILLISECONDS);
    }

    public static void stop()
    {
        if (_lights != null) _lights.cancel(true);        
        reset();
        _on = false;
    }

    private static void reset()
    {
        setColorOnAll(new Color(0,0,0));
    }

    private static void setColorOnAll(Color color)
    {
        for (int i = 0; i < 6; i++)
            BoeBot.rgbSet(i, color.getRed(), color.getGreen(), color.getBlue());        
        BoeBot.rgbShow();
    }
}
