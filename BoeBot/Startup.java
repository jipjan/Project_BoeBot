import TI.*;

/**
 * Startup start de bot. * 
 * @author Groep B1
 */
public class Startup
{
    public static void main(String[] args)
    {
        DriveHandler handler = new DriveHandler();

        while (true) 
        {
            handler.turn(200);
        }
    }
}
