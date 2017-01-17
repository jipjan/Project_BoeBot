import java.util.ArrayList;
import java.awt.Point;
import java.util.Stack;

public class PathCalculator
{    
    public static ArrayList<LookPathLocation> CurrentPath = new ArrayList<LookPathLocation>();
    static Point _current;
    Point _calcCurrent;
    int _width, _height;    
    static Look _currentLook;
    Look _calcLook;  

    public PathCalculator(int xStart, int yStart, int width, int height)
    {
        if (yStart > 0)
            _currentLook = _calcLook = Look.RIGHT;
        else
            _currentLook = _calcLook = Look.UP;

        _current = _calcCurrent = new Point(xStart, yStart);
        _width = width;
        _height = height;
    }

    private ArrayList<LookPathLocation> turnCalc(Look turnDirection, Point location)
    {
        ArrayList<LookPathLocation> toReturn = new ArrayList<LookPathLocation>();
        if (turnDirection == _calcLook) return null;
        if (turnDirection == Look.RIGHT)
        {
            if (_calcLook == Look.UP)            
                toReturn.add(new LookPathLocation(turnDirection, PathItem.RIGHT, location));            
            else if (_calcLook == Look.DOWN)
                toReturn.add(new LookPathLocation(turnDirection, PathItem.LEFT, location));
        }
        else if (turnDirection == Look.UP)
        {
            if (_calcLook == Look.LEFT)            
                toReturn.add(new LookPathLocation(turnDirection, PathItem.RIGHT, location));            
            else if (_calcLook == Look.RIGHT)
                toReturn.add(new LookPathLocation(turnDirection, PathItem.LEFT, location));
        }
        else if (turnDirection == Look.LEFT)
        {
            if (_calcLook == Look.UP)            
                toReturn.add(new LookPathLocation(turnDirection, PathItem.LEFT, location));            
            else if (_calcLook == Look.DOWN)
                toReturn.add(new LookPathLocation(turnDirection, PathItem.RIGHT, location));
        }
        else if (turnDirection == Look.DOWN)
        {
            if (_calcLook == Look.LEFT)            
                toReturn.add(new LookPathLocation(turnDirection, PathItem.LEFT, location));            
            else if (_calcLook == Look.RIGHT)
                toReturn.add(new LookPathLocation(turnDirection, PathItem.RIGHT, location));
        }
        if (toReturn.size() == 0)
            return null;
        return toReturn;
    }

    private Point calcLoc(Point p, int x, int y)
    {
        return new Point(p.x + x, p.y + y);
    }

    private int turn(Look turnDirection, ArrayList<LookPathLocation> list, Point location)
    {
        ArrayList<LookPathLocation> _lPCalc = turnCalc(turnDirection, location);        
        if (_lPCalc != null)
        {            
            for (LookPathLocation i : _lPCalc)
            {
                _calcLook = i.getLook();
                _calcCurrent = i.getLocation();
                list.add(i);                
            }
            return -_lPCalc.size();
        }
        return 0;
    }

    public ArrayList<LookPathLocation> calcPath(Point... end)
    {        
        ArrayList<LookPathLocation> toReturn = new ArrayList<LookPathLocation>();
        LookPathLocation _lPCalc;
        _calcCurrent = _current;
        for (Point p : end)        
        {   
            int offset = 0;         

            if (p.x > _calcCurrent.x)             
            {
                offset = turn(Look.RIGHT, toReturn, _calcCurrent);
                for (int x = _calcCurrent.x; x < p.x + offset; x++)
                    if (_calcLook == Look.RIGHT)
                        toReturn.add(new LookPathLocation(Look.EMPTY, PathItem.UP, new Point(x, _calcCurrent.y)));         
                    else
                        toReturn.add(new LookPathLocation(Look.EMPTY, PathItem.DOWN, new Point(x, _calcCurrent.y)));                             
            }
            else if (p.x < _calcCurrent.x)
            {
                offset = turn(Look.LEFT, toReturn, _calcCurrent);
                for (int x = _calcCurrent.x; x + offset > p.x ; x--)
                    if (_calcLook == Look.LEFT)
                        toReturn.add(new LookPathLocation(Look.EMPTY, PathItem.UP, new Point(x, _calcCurrent.y)));
                    else
                        toReturn.add(new LookPathLocation(Look.EMPTY, PathItem.DOWN, new Point(x, _calcCurrent.y)));
            }

            if (p.y > _calcCurrent.y)            
            {
                offset = turn(Look.UP, toReturn, _calcCurrent);
                for (int y = _calcCurrent.y; y < p.y + offset; y++)
                    if (_calcLook == Look.UP)
                        toReturn.add(new LookPathLocation(Look.EMPTY, PathItem.UP, new Point(_calcCurrent.x, y)));            
                    else
                        toReturn.add(new LookPathLocation(Look.EMPTY, PathItem.DOWN, new Point(_calcCurrent.x, y)));            
            }
            else if (p.y < _calcCurrent.y)                           
            {
                offset = turn(Look.DOWN, toReturn, _calcCurrent);
                for (int y = _calcCurrent.y; y + offset > p.y; y--)                        
                    if (_calcLook == Look.DOWN)
                        toReturn.add(new LookPathLocation(Look.EMPTY, PathItem.UP, new Point(_calcCurrent.x, y)));            
                    else
                        toReturn.add(new LookPathLocation(Look.EMPTY, PathItem.DOWN, new Point(_calcCurrent.x, y)));                                 
            }
            _calcCurrent = p;
        }
        CurrentPath = toReturn;
        return toReturn;
    }

    private void checkPoints()
    {

    }

    public static Stack<LookPathLocation> getPathAsLookSpeedStack(ArrayList<LookPathLocation> list)
    {
        Stack<LookPathLocation> s = new Stack<LookPathLocation>();
        for (int i = list.size() - 1; i >= 0; i--)        
            s.push(list.get(i));
        return s;
    }

    public static void jukeMeister(Point locToAvoid, Point locToDriveTo)
    {
    }    

    public static Look getCurrentLook()
    {
        return _currentLook;
    }

    public static void setLook(Look l)
    {
        _currentLook = l;
    }

    public static Point getCurrentLocation()
    {
        return _current;
    } 

    public static void setCurrentLocation(Point p)
    {
        _current = p;
    }

    public static String pathToString()
    {
        String s = "";
        for (LookPathLocation i : CurrentPath)
            s += i.getPath().Value;
        return s;
    }
}
