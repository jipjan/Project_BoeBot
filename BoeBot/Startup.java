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

        // PathCalculator MOET ALTIJD WORDEN GEÏNITALISEERD AAN EEN RAND, dus of x of y 0.
        PathCalculator p; 

        p = new PathCalculator(2, 0, 8, 8);        
        printPath(p.calcPath(new Point (2, 4), new Point(2, 2)), 2, 5);
        System.out.println("Expected: UP, UP, UP, UP, LEFT, LEFT, LEFT, RIGHT\n");
        
        
        
        
        
        
        
        
        
        
        
        
         p = new PathCalculator(4, 0, 8, 8);        
        printPath(p.calcPath(new Point (2, 4), new Point(2, 2), new Point(5,5)), 3, 1);
        System.out.println("Expected: \n");
        /*
        Senario bugg 1
        printPath(new PathCalculator(6, 6, 8, 8).calcPath(new Point(4, 4)), 1);
        LightPath.setPath(new PathCalculator(6, 6, 8, 8).calcPath(new Point(4, 4)));
        in dit geval gaat hij van de laaste coordinaten naar de eerste, dus(4,4)=>(6,6) UP UP LEFT UP
        hier door kan hij niet "omkeren"of 3x links en 1x rechtom enzo te draaien.
        zijn begint punt ziet hij dus als zijn laagste coordinaat

        /* Senario bugg 2
         *hij kan niet achteruit lijnvolgen indien er een obstakel zich bevindt in de route, kan er ook nog niet langs.

         *Senario bugg 3
         *GUI scherm en bluetooth werken de knoppen nog niet, of ze vesturen geen informatie?
         *daar moet nog naar gekeken worden
         *
         */

        //while (true)
        //    RemoteListener.startReading();
        //LightSensor.startAutoDrive();
    }

    private static void printPath(List<LookPathLocation> list, int s, int n)
    {
        System.out.println("Senario: " + s + "." + n);
        for (LookPathLocation i : list)
        {
            switch (i.getPath())
            {
                case UP:
                System.out.print("UP, ");
                break;

                case LEFT:
                System.out.print("LEFT, ");
                break;

                case RIGHT:
                System.out.print("RIGHT, ");
                break;
                
                case DOWN:
                System.out.print("DOWN, ");
                break;
            }
        }
        System.out.println("");
    }
}