import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/**
 * Detectie van de voelsprieten.
 * 
 * @author Groep B1
 */
public class Whiskers extends BaseCollider
{
    /*
     * Start de detectie van een botsing met de voelsprieten.
     */
    public static void startDetection()
    {
        startDetection("Whiskers", () -> 
                collisionCheck(
                    !BoeBot.digitalRead(Constants.WHISKER_LEFT_PIN),
                    !BoeBot.digitalRead(Constants.WHISKER_RIGHT_PIN)
                ), 100);
    }

    /*
     * Controleer wat voor soort botsing er is.
     */
    private static void collisionCheck(boolean left, boolean right)
    {
        if (left && right)
            collided(_collided);        
        else if (left)                 
            collided(_collided);        
        else if (right) 
            collided(_collided);        
        else if (_collided)
        {  
            _collided = false;
            BoardLights.stop();
        }
    }   

}
