import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/**
 * Detectie voor de ultrasoon sensor.
 * 
 * @author Groep B1
 */
public class Ultrasoon extends BaseCollision
{
    public static final Ultrasoon Instance = new Ultrasoon();
    
    /*
     * Start de detectie met de ultrasoon sensor.
     */
    private Ultrasoon()
    {      
        super("Ultrasoon",100);
        setTask(() -> 
            {
                BoeBot.digitalWrite(Constants.ULTRASOON_IN_PIN, true);
                BoeBot.wait(1);
                BoeBot.digitalWrite(Constants.ULTRASOON_IN_PIN, false);

                collisionCheck(BoeBot.pulseIn(Constants.ULTRASOON_OUT_PIN, true, 10000));     
            });
    }

    /*
     * Controleer of er een object te dichtbij aan het komen is en stop eventueel.
     */
    private void collisionCheck(int pulse)
    {
        if (pulse == -2)
            System.out.println("Ultrasoon not connected, or is experiencing issues...");
        else
        {
            if (pulse < Constants.ULTRASOON_DISTANCE)
                collided(_collided);
            else if (_collided)
            {  
                _collided = false;
                BoardLights.stop();
            }
        }
    }
}
