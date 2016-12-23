import java.util.ArrayList;
import java.awt.Point;

public class PathCalculator
{    
    Point _current;
    int _width, _height;    
    Look _look;

    public PathCalculator(int xStart, int yStart, int width, int height)
    {
        if (yStart > 0)
            _look = Look.RIGHT;
        else
            _look = Look.UP;

        _current = new Point(xStart, yStart);
        _width = width;
        _height = height;
    }    

    public ArrayList<PathItem> calcPath(Point... end)
    {        
        ArrayList<PathItem> toReturn = new ArrayList<PathItem>();

        for (Point p : end)
        {            
            int offset;
            if (p.x > _current.x)
            {
                offset = 0;
                if (_look == Look.UP)
                {
                    offset--;
                    _look = Look.RIGHT;
                    toReturn.add(PathItem.RIGHT);
                }

                for (int x = _current.x; x < p.x + offset; x++)
                    toReturn.add(PathItem.UP);
            }
            else if (p.x <_current.x)
            {
                offset = 0;
                if (_look == Look.UP)
                {
                    offset--;
                    _look = Look.LEFT;
                    toReturn.add(PathItem.LEFT);
                }

                for (int x = _current.x; x + offset > p.x ; x--)
                    toReturn.add(PathItem.UP);
            }

            if (p.y > _current.y)
            {
                offset = 0;
                if (_look == Look.LEFT)
                {
                    offset--;
                    _look = Look.UP;
                    toReturn.add(PathItem.RIGHT);
                }
                else if (_look == Look.RIGHT)
                {
                    offset--;
                    _look = Look.UP;
                    toReturn.add(PathItem.LEFT);
                }

                for (int y = _current.y; y < p.y + offset; y++)
                    toReturn.add(PathItem.UP);
            }
            else if (p.y < _current.y)
            {
                offset = 0;
                if (_look == Look.LEFT)
                {
                    offset--;
                    _look = Look.DOWN;
                    toReturn.add(PathItem.LEFT);
                }
                else if (_look == Look.RIGHT)
                {
                    offset--;
                    _look = Look.UP;
                    toReturn.add(PathItem.LEFT);
                }

                for (int y = _current.y; y + offset > p.y; y--)
                    toReturn.add(PathItem.UP);
            }
        }

        return toReturn;
    }

    public void updateX()
    {

    }

    public void updateY()
    {

    }

    public Point CurrentLocation()
    {
        return _current;
    } 
}
