import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;
import java.util.Queue;

public class LightSensor
{
    private static ScheduledFuture<?> _sensor;
    private static Queue<Speed> _speedQueue;

    public static void startAutoDrive()
    {
        System.out.println("Starting automatic driving base on light...");

        if (_sensor != null && !_sensor.isDone())
        {
            System.out.println("Already running, returning");
            return;
        }

        _speedQueue = LightPath.getPathListAsSpeedQueue();
        Engines.setSpeed(Speed.MAX);
        _sensor = TimerHandler.Timer.scheduleWithFixedDelay(() ->
            {
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
                        crossRoad();
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

    public static String getValuesAsString()
    {
        return "Left: " + BoeBot.analogRead(Constants.LIGHT_SENSOR_LEFT) + ", Center: " + BoeBot.analogRead(Constants.LIGHT_SENSOR_CENTER) + ", Right: " + BoeBot.analogRead(Constants.LIGHT_SENSOR_RIGHT);
    }

    private static void crossRoad()
    {
        System.out.println("Triggered!");
        if (_speedQueue.peek() == null)
        {
            stopAutoDrive();
            Engines.setSpeed(Speed.STOP);
        }
        else
            Engines.setSpeed(_speedQueue.poll(), true);
        BoeBot.wait(1000);
    }

    private static boolean isBlack(int input)
    {
        return input > Constants.TRIGGER_BLACK;
    }

    public static void stopAutoDrive()
    {
        if (_sensor != null) _sensor.cancel(true);
        if (_speedQueue != null) _speedQueue.clear();
    }
}
