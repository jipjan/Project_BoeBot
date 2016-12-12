import TI.*;

/**
 * Startup start de bot. * 
 * @author Groep B1
 */
public class Startup
{
    public static void main(String[] args)
    {
        //CollisionDetection.start();
        //LightSensor.startAutoDrive();             

        while (true)
            RemoteControlOverride.startReading();
    }
}

