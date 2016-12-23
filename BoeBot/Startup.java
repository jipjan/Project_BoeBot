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
        // Senario 1
        printPath(new PathCalculator(2, 0, 5, 5).calcPath(new Point(1, 3)), 1);

        // Senario 2
        printPath(new PathCalculator(0, 1, 5, 5).calcPath(new Point(2, 3)), 2);

        // Senario 3
        printPath(new PathCalculator(1, 0, 5, 5).calcPath(new Point(2, 2)), 3);
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