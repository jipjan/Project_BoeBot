import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;
import java.util.Stack;
import java.awt.Point;

public class LightSensor
{
    private static ScheduledFuture<?> _sensor;
    public static Stack<LookPathLocation> SpeedStack;
    private static boolean _pause = false;

    public static void startAutoDrive()
    {
        resume();
        System.out.println("Starting automatic driving base on light...");

        if (_sensor != null && !_sensor.isDone())
        {
            System.out.println("Already running, returning");
            return;
        }

        SpeedStack = PathCalculator.getPathAsLookSpeedStack(PathCalculator.CurrentPath);
        Engines.setSpeed(Speed.MAX);
        _sensor = TimerHandler.Timer.scheduleWithFixedDelay(() ->
            {
                if (_pause) return;
                boolean left = isBlack(BoeBot.analogRead(Constants.LIGHT_SENSOR_LEFT));
                boolean center = isBlack(BoeBot.analogRead(Constants.LIGHT_SENSOR_CENTER));
                boolean right = isBlack(BoeBot.analogRead(Constants.LIGHT_SENSOR_RIGHT));               

                Speed speed = Engines.getCurrentSpeed();
                if (!center && !left && !right)
                    speed = Speed.MAX;             
                else if (center)
                {
                    if (!left && !right)
                        speed = Speed.MAX;
                    else if (left && right)
                    {
                        crossRoad(); 
                        return;
                    }
                    else if (left)
                        speed = Speed.HALF_LEFT;
                    else if (right)
                        speed = Speed.HALF_RIGHT;                    
                }
                else
                {
                    if (left)
                        speed = Speed.LINE_LEFT;
                    else if (right)
                        speed = Speed.LINE_RIGHT; 
                }

                Engines.setSpeed(speed, true);
            }, 0, 15, MILLISECONDS);
    }
    
    public static void setSpeedWithLine(Speed speed)
    {
        
    }

    public static String getValuesAsString()
    {
        return "Left: " + BoeBot.analogRead(Constants.LIGHT_SENSOR_LEFT) + ", Center: " + BoeBot.analogRead(Constants.LIGHT_SENSOR_CENTER) + ", Right: " + BoeBot.analogRead(Constants.LIGHT_SENSOR_RIGHT);
    }

    private static void crossRoad()
    {
        System.out.println("Triggered!");
        if (SpeedStack.empty()){
            System.out.println("done");
            //stopAutoDrive();
            Engines.breakBot();  
        }else
        {
            LookPathLocation ls = SpeedStack.pop();
            Engines.setSpeed(ls.getSpeed(), true);
            PathCalculator.setLook(ls.getLook());
            PathCalculator.setCurrentLocation(ls.getLocation());
            if (ls.getPath() == PathItem.REVERSE)
                BoeBot.wait(200);
            BoeBot.wait(450);
        }
    }

    private static boolean isBlack(int input)
    {
        return input > Constants.TRIGGER_BLACK;
    }
    
    public static void pause()
    {
        _pause = true;
    }
    
    public static void resume()
    {
        _pause = false;
    }    
    
    public static void stopAutoDrive()
    {
        if (_sensor != null) _sensor.cancel(true);
        if (SpeedStack != null) SpeedStack.clear();
    }
}
