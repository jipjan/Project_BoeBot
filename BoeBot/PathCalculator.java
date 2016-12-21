import java.util.ArrayList;
import java.awt.Point;

public class PathCalculator
{    
    Point _current;
    int _width, _height;    
    Look _look;

    public PathCalculator(int xStart, int yStart, int width, int height)
    {
        if (xStart > 0)
            _look = Look.UP;
        else
            _look = Look.RIGHT;
        _current = new Point(xStart, yStart);
        _width = width;
        _height = height;
    }    

    public ArrayList<PathItem> calcPath(Point... end)
    {
        /*
        if (end.x < 0 || end.y < 0) return null;
        
        ArrayList<PathItem> toReturn = new ArrayList<PathItem>();
                       
        if (end.y >= _current.y && _look == Look.UP)        
            toReturn.add(PathItem.DOWN);
        else if (xEnd >= _x && _look == Look.RIGHT)
            toReturn.add(PathItem.DOWN);

             if (_y != yEnd)
        {         
            for (int i = 0; i < Math.abs(_y - yEnd); i++)
                toReturn.add(PathItem.UP);                              
        }
        if (_x != xEnd)
        {
            //for (int i = 0; 
        }
        */
        return null;
    }
    
    
}
