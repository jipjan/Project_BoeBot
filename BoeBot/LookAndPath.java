public class LookAndPath
{
    public Look _look;
    public PathItem _path;
    public LookAndPath(Look l, PathItem p)
    {
        _look = l;
        _path = p;
    }
    
    public Look getLook()
    {
        return _look;
    }
    
    public PathItem getPath()
    {
        return _path;
    }
}