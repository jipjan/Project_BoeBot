import java.awt.Point;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PathTests.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PathTests
{
    PathCalculator p;

    @Test
    public void scenario11()
    {
        p = new PathCalculator(0, 3, 8, 8);
        p.calcPath(new Point(0, 6));
        assertEquals("aww", PathCalculator.pathToString());
    }
    
    @Test
    public void scenario12()
    {
        p = new PathCalculator(0, 6, 8, 8);
        p.calcPath(new Point(5, 3));
        assertEquals("wwwwwdww", PathCalculator.pathToString());
    }
    
    @Test
    public void scenario13()
    {
        p = new PathCalculator(5, 0, 8, 8);
        p.calcPath(new Point(3, 1));
        assertEquals("awd", PathCalculator.pathToString());
    }
    
    @Test
    public void scenario14()
    {
        p = new PathCalculator(2, 0, 8, 8);
        p.calcPath(new Point(0, 0));
        assertEquals("aw", PathCalculator.pathToString());
    }
    
    @Test
    public void scenario21()
    {
        p = new PathCalculator(0, 3, 8, 8);
        p.calcPath(new Point(3, 3), new Point(5,6));
        assertEquals("wwwwwaww", PathCalculator.pathToString());
    }
    
    @Test
    public void scenario22()
    {
        p = new PathCalculator(0, 2, 8, 8);
        p.calcPath(new Point(1, 1), new Point(4, 4));
        assertEquals("wdawwaww", PathCalculator.pathToString());
    }
    
    @Test
    public void scenario23()
    {
        p = new PathCalculator(5, 0, 8, 8);
        p.calcPath(new Point (6, 6), new Point(2, 2));
        assertEquals("dawwwwwawwwawww", PathCalculator.pathToString());
    }
    
    @Test
    public void scenario24()
    {
        p = new PathCalculator(2, 0, 8, 8);
        p.calcPath(new Point (4, 0), new Point(0, 4));
        assertEquals("dwssssawww", PathCalculator.pathToString());
    }
    
    @Test
    public void scenario25()
    {
        p = new PathCalculator(2, 0, 8, 8);
        p.calcPath(new Point (2, 4), new Point(2, 2));
        assertEquals("wwwwss", PathCalculator.pathToString());
    }
}
