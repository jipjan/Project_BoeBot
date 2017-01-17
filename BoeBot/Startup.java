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

        // 1 point scenarios
        p = new PathCalculator(0, 3, 8, 8);
        printPath(p.calcPath(new Point(0, 6)), 1, 1);
        System.out.println("Expected: LEFT, UP, UP\n");

        p = new PathCalculator(0, 6, 8, 8);
        printPath(p.calcPath(new Point(5, 3)), 1, 2);
        System.out.println("Expected: UP, UP, UP, UP, UP, RIGHT, UP, UP\n");

        p = new PathCalculator(5, 0, 8, 8);
        printPath(p.calcPath(new Point(3, 1)), 1, 3);
        System.out.println("Expected: LEFT, UP, RIGHT\n");

        p = new PathCalculator(2, 0, 8, 8);
        printPath(p.calcPath(new Point(0, 0)), 1, 4);
        System.out.println("Expected: LEFT, UP\n");

        // 2 point scenarios
        p = new PathCalculator(0, 3, 8, 8);        
        printPath(p.calcPath(new Point (3,3), new Point(5, 6)), 2, 1);
        System.out.println("Expected: UP, UP, UP, UP, UP, LEFT, UP, UP\n");        

        p = new PathCalculator(0, 2, 8, 8);        
        printPath(p.calcPath(new Point (1, 1), new Point(4, 4)), 2, 2);
        System.out.println("Expected: UP, RIGHT, LEFT, UP, UP, LEFT, UP, UP\n");        

        p = new PathCalculator(5, 0, 8, 8);        
        printPath(p.calcPath(new Point (6, 6), new Point(2, 2)), 2, 3);
        System.out.println("Expected: RIGHT, LEFT, UP, UP, UP, UP, UP, LEFT, UP, UP, UP, LEFT, UP, UP, UP\n");        

        p = new PathCalculator(2, 0, 8, 8);        
        printPath(p.calcPath(new Point (4, 0), new Point(0, 4)), 2, 4);
        System.out.println("Expected: RIGHT, UP, LEFT, UP, UP, UP, LEFT, UP, UP, UP\n");

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
            }
        }
        System.out.println("");
    }
}