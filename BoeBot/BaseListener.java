import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;
/**
 * Abstract class BaseListener - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public class BaseListener
{
    protected static ScheduledFuture<?> _timer;
    
    /*
     * De inwendige methode waarmee de listener wordt gestart.
     * @param   name    De naam van de sensor, mag alles zijn, is voor debugging.
     * @param   task    De methode die moet worden uitgevoerd voor het controleren van input.
     * @param   delay   De interval waarmee moet worden gekeken voor input.
     */
    public static void start(String name, Runnable task, int delay)
    {
        System.out.println("Starting listening on " + name);        
        if (_timer != null && !_timer.isDone())        
            System.out.println("Already listening, returning..");            
        else
            _timer = TimerHandler.Timer.scheduleWithFixedDelay(task, 0, delay, MILLISECONDS);
    }    
    
    /*
     * Stop listening.
     */
    public static void stop()
    {
        if (_timer != null) _timer.cancel(true);
    }
}
