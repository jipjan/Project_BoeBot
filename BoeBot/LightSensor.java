import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

public class LightSensor
{
    private static ScheduledFuture<?> _sensor;

    public static void startAutoDrive()
    {
        System.out.println("Starting automatic driving base on light...");

        if (_sensor != null && !_sensor.isDone())
        {
            System.out.println("Already running, returning");
            return;
        }

        _sensor = TimerHandler.Timer.scheduleWithFixedDelay(() ->
            {
                boolean left = isBlack(BoeBot.analogRead(Constants.LIGHT_SENSOR_LEFT));
                boolean center = isBlack(BoeBot.analogRead(Constants.LIGHT_SENSOR_CENTER));
                boolean right = isBlack(BoeBot.analogRead(Constants.LIGHT_SENSOR_RIGHT));

                Speed speed = Engines.getCurrentSpeed();
                if (center)
                {
                    if (!left && !right)
                        speed = Speed.HALF;
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

                Engines.setSpeed(speed);
            }, 0, 15, MILLISECONDS);
    }

    private static boolean isBlack(int input)
    {
        return input > 1200;
    }
}
