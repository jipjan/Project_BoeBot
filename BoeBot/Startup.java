import TI.*;

/**
 * Startup start de bot. * 
 * @author Groep B1
 */
public class Startup
{
    public static void main(String[] args)
    {
        LightSensor.startAutoDrive();
        
        /*
        while (true)
        {
            System.out.println("Left: " + BoeBot.analogRead(0));
             System.out.println("Center: " + BoeBot.analogRead(1));
              System.out.println("Right: " + BoeBot.analogRead(2));
              System.out.println("");
              BoeBot.wait(1000);
        }
        */        
    }
}

