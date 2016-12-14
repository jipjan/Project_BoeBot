import TI.*;

/**
 * Startup start de bot.
 * @author Groep B1
 */
public class Startup
{
    public static void main(String[] args)
    {
        //CollisionDetection.start();
        //BluetoothListener.start();
        //LightSensor.startAutoDrive();
        Whiskers.startDetection();
        Ultrasoon.startDetection();
        while(true)
            RemoteListener.startReading();
    }
}