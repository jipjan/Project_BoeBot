public class CollisionDetection
{/*
    Ultrasoon&Whiskers worden geactiveerd.
    Als ze botsen dan stoppen ze.
 */
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
