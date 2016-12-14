import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/*
 * Basis class voor alle boetsing sensoren.
 * @author Groep B1
 */
public class BaseCollider
{
    protected static boolean _collided;
    protected static ScheduledFuture<?> _timer;

    /*
     * De inwendige methode waarmee de detectie wordt gestart.
     * @param   sensorName  De naam van de sensor, mag alles zijn, is voor debugging.
     * @param   task        De methode die moet worden uitgevoerd voor het controleren op botsing.
     * @param   delay       De interval waarmee moet worden gecontroleerd.
     */
    protected static void startDetection(String sensorName, Runnable task, int delay)
    {
        System.out.println("Starting " + sensorName + " Collision Detection...");        
        if (_timer != null && !_timer.isDone())        
            System.out.println("Already running, returning..");            
        else
            _timer = TimerHandler.Timer.scheduleWithFixedDelay(task, 0, delay, MILLISECONDS);        
    }    

    /*
     * Interne methode om te kijken of er een botsing is geweest.
     * @param   collided    De variabele voor het controleren of de botsing nog steeds bezig is, of niet is.
     */
    protected static void collided(boolean collided)
    {
        if (!collided)
        {
            collided = true;
            System.out.println("Collision Imminent, stopping...");  
            Engines.breakBot();
            BoardLights.alarmLights();
        }
    }

    /*
     * Publieke methode om te controleren of er een botsing is geweest.
     */
    public static boolean hasCollided()
    {
        return _collided;
    }
    
    /*
     * Stop de detectie van botsingen met deze sensor.
     */
    public static void stopDetection()
    {
        if (_timer != null) _timer.cancel(true);
    }
}
