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
        
        CollisionDetection.start();
        BluetoothListener.start();
        LightSensor.startAutoDrive();
        while(true)
            RemoteListener.startReading();
    }
}