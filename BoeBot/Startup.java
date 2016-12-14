import TI.*;

/**
 * Startup start de bot.
 * @author Groep B1
 */
public class Startup
{
    public static void main(String[] args)
    {
        LightPath.defaultPath();
        LightSensor.startAutoDrive();
        while (true)
        {
            System.out.println(LightSensor.getValuesAsString());
            BoeBot.wait(500);
        }
        /*
        CollisionDetection.start();
        BluetoothListener.start();
        LightSensor.startAutoDrive();
        while(true)
            RemoteListener.startReading();
            */
    }
}