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
        BluetoothListener.start();
        
        
        
        
        /*
        // Senario 1.1
        printPath(new PathCalculator(3, 3, 8, 8).calcPath(new Point(2, 5)), 1);
        LightPath.setPath(new PathCalculator(3, 3, 8, 8).calcPath(new Point(2, 5)));
       UP,LEFT,UP klopt niet hij wilt niet omdraaien ingeval de coordianten er onder liggen.
        
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
        
        while (true)
            RemoteListener.startReading();
        //LightSensor.startAutoDrive();
    }

    private static void printPath(List<PathItem> list, int s)
    {
        System.out.println("Senario: " + s);
        for (PathItem i : list)
        {
            switch (i)
            {
                case UP:
                System.out.println("UP");
                break;

                case LEFT:
                System.out.println("LEFT");
                break;

                case RIGHT:
                System.out.println("RIGHT");
                break;
            }
        }
        System.out.println("");
    }
}