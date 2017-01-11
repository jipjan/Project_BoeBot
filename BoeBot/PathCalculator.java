import java.util.ArrayList;
import java.awt.Point;

public class PathCalculator
{    
    Point _current;
    int _width, _height;    
    Look _currentLook;
    Look _calcLook;

    public PathCalculator(int xStart, int yStart, int width, int height)
    {
        if (yStart > 0)
            _currentLook = _calcLook = Look.RIGHT;
        else
            _currentLook = _calcLook = Look.UP;

        _current = new Point(xStart, yStart);
        _width = width;
        _height = height;
    }

    private LookAndPath turnCalc(Look turnDirection)
    {
        if (turnDirection == _calcLook) return null;
        if (turnDirection == Look.RIGHT)
        {
            if (_calcLook == Look.UP)            
                return new LookAndPath(turnDirection, PathItem.RIGHT);            
            if (_calcLook == Look.DOWN)
                return new LookAndPath(turnDirection, PathItem.LEFT);
        }
        else if (turnDirection == Look.UP)
        {
            if (_calcLook == Look.LEFT)            
                return new LookAndPath(turnDirection, PathItem.RIGHT);            
            if (_calcLook == Look.RIGHT)
                return new LookAndPath(turnDirection, PathItem.LEFT);
        }
        else if (turnDirection == Look.LEFT)
        {
            if (_calcLook == Look.UP)            
                return new LookAndPath(turnDirection, PathItem.LEFT);            
            if (_calcLook == Look.DOWN)
                return new LookAndPath(turnDirection, PathItem.RIGHT);
        }
        else if (turnDirection == Look.DOWN)
        {
            if (_calcLook == Look.LEFT)            
                return new LookAndPath(turnDirection, PathItem.LEFT);            
            if (_calcLook == Look.RIGHT)
                return new LookAndPath(turnDirection, PathItem.RIGHT);
        }
        return null;
    }

    private int turn(Look turnDirection, ArrayList<LookAndPath> list)
    {
        LookAndPath _lPCalc = turnCalc(turnDirection);
        if (_lPCalc != null)
        {
            _calcLook = _lPCalc.getLook();
            list.add(_lPCalc);
            return -1;
        }
        return 0;
    }

    public ArrayList<LookAndPath> calcPath(Point... end)
    {        
        ArrayList<LookAndPath> toReturn = new ArrayList<LookAndPath>();
        LookAndPath _lPCalc;
        for (Point p : end)
        {   
            int offset = 0;
            if (p.x > _current.x)             
            {
                offset = turn(Look.RIGHT, toReturn);
                for (int x = _current.x; x < p.x + offset; x++)
                    toReturn.add(new LookAndPath(Look.EMPTY, PathItem.UP));         
            }
            else if (p.x < _current.x)
            {
                offset = turn(Look.LEFT, toReturn);
                for (int x = _current.x; x + offset > p.x ; x--)
                    toReturn.add(new LookAndPath(Look.EMPTY, PathItem.UP));
            }

            if (p.y > _current.y)            
            {
                offset = turn(Look.UP, toReturn);
                for (int y = _current.y; y < p.y + offset; y++)
                    toReturn.add(new LookAndPath(Look.EMPTY, PathItem.UP));            
            }
            else if (p.y < _current.y)                           
            {
                offset = turn(Look.DOWN, toReturn);
                for (int y = _current.y; y + offset > p.y; y--)
                    toReturn.add(new LookAndPath(Look.EMPTY, PathItem.UP));            
            }
        }
        return toReturn;
    }

    public Look getCurrentLook()
    {
        return _currentLook;
    }

    public void setLook(Look l)
    {
        _currentLook = l;
    }

    /*
    private LookAndPath turn(Look wayToLook)
    {
    if (wayToLook == Look.UP)
    {
    if (_look == Look.RIGHT)
    }
    }
     */

    public Point CurrentLocation()
    {
        return _current;
    } 
}
