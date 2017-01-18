import TI.*;
import java.util.List;
import java.awt.Point;

/**
 * Startup start de bot.
 * @author Groep B1
 */
public class Startup // is de main klass en roept de volgende klasses aan.
{
    public static void main(String[] args)
    {
        BluetoothListener.start();
        CollisionDetection.start();

         //PathCalculator MOET ALTIJD WORDEN GEÏNITALISEERD AAN EEN RAND, dus of x of y 0.
        
        while (true)
          RemoteListener.startReading();        
    }
}