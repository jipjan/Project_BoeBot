import TI.*;
import java.util.List;
import java.awt.Point;

/**
 * Startup start de bot.
 * @author Groep B1
 */
public class Startup
{
    public static void main(String[] args)
    {
        //BluetoothListener.start();
        //CollisionDetection.start();

         //PathCalculator MOET ALTIJD WORDEN GEÏNITALISEERD AAN EEN RAND, dus of x of y 0.
        PathCalculator p = new PathCalculator(0, 1, 5, 8);
        p.calcPath(new Point(3, 1), new Point(3,3), new Point(3,1));
        LightSensor.startAutoDrive();
        while (true)
          RemoteListener.startReading();        
    }
}