import java.util.*;

public class LightPath
{
    private static List<PathItem> _path = new ArrayList<PathItem>();

    public static void defaultPath()
    {
        _path.add(PathItem.LEFT);
    }

    public static List<PathItem> getPathList()
    {
        return _path;
    }

    public static String pathAsString()
    {
        String toReturn = "";
        for(PathItem i : _path)
            toReturn += i.Value;
        return toReturn;
    }
}
