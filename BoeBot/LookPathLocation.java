import java.awt.Point;

public class LookPathLocation
{
    private Look _look;
    private PathItem _path;
    private Point _loc;

    public LookPathLocation(Look l, PathItem p, Point loc)
    {
        _look = l;
        _path = p;
        _loc = loc;
    }

    public Look getLook()
    {
        return _look;
    }

    public PathItem getPath()
    {
        return _path;
    }

    public Point getLocation()
    {
        return _loc;
    }

    public Speed getSpeed()
    {
        switch(_path)
        {
            case UP: return Speed.MAX;
            case LEFT: return Speed.CROSS_LEFT;
            case RIGHT: return Speed.CROSS_RIGHT;
            case DOWN: return Speed.MAX_REVERSE;
            default: return Speed.STOP;
        }
    }    
}