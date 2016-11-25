public class CollisionDetection
{
    public static void start()
    {
        //Whiskers.startDetection();
        Ultrasoon.startDetection();
    }
    
    public static boolean hasCollided()
    {
        return Ultrasoon.hasCollided();
    }
}
