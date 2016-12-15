public class CollisionDetection
{
    static Ultrasoon _t;
    static Whiskers _w;
    
    public static void start()
    {
        _t = Ultrasoon.Instance;
        _w = Whiskers.Instance;
    }
    
    public static void stop()
    {
        _t.stop();
        _w.stop();
    }
    
    public static boolean hasCollided()
    {
        return Ultrasoon.Instance.hasCollided() || Whiskers.Instance.hasCollided();
    }
}
