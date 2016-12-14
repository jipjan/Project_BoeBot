import java.util.*;

public class LightPath
{
    private static List<PathItem> _path = new ArrayList<PathItem>();

    public static void defaultPath()
    {
        _path.clear();
        _path.add(PathItem.UP);
        _path.add(PathItem.RIGHT);
        _path.add(PathItem.UP);
        _path.add(PathItem.UP);
        _path.add(PathItem.LEFT);
        _path.add(PathItem.UP);
        _path.add(PathItem.LEFT);
        _path.add(PathItem.UP);
        _path.add(PathItem.LEFT);
        _path.add(PathItem.UP);
        _path.add(PathItem.UP);
        _path.add(PathItem.RIGHT);
        _path.add(PathItem.UP);
    }   

    public static List<PathItem> getPathList()
    {
        return _path;
    }

    public static Queue<Speed> getPathListAsSpeedQueue()
    {
        Queue<Speed> q = new LinkedList<Speed>();
        for (PathItem i : _path)
            switch(i)
            {
                case UP: q.add(Speed.MAX); break;
                case LEFT: q.add(Speed.CROSS_LEFT); break;
                case RIGHT: q.add(Speed.CROSS_RIGHT); break;
            }
        return q;
    }

    public static String pathAsString()
    {
        String toReturn = "";
        for(PathItem i : _path)
            toReturn += i.Value;
        return toReturn;
    }
}
