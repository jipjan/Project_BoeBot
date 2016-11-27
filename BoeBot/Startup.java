import TI.*;

/**
 * Startup start de bot. * 
 * @author Groep B1
 */
public class Startup
{
    public static void main(String[] args)
    {
        CollisionDetection.start();
        while (true)
            RemoteControlOverride.drive();
    }
}

