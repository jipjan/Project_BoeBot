import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

public class BaseCollision
{
    protected boolean _collided;
    protected ScheduledFuture<?> _timer;
    protected Runnable _task;

    public BaseCollision(String name, int delay)
    {
        System.out.println("Starting " + name + " Collision Detection...");        
        if (_timer != null && !_timer.isDone())        
            System.out.println("Already running, returning..");            
        else
            _timer = TimerHandler.Timer.scheduleWithFixedDelay(() -> {
                    if(_task != null)
                        _task.run();
                },0, 100, MILLISECONDS); 
    }

    protected void setTask(Runnable task)
    {
        _task = task;
    }

    protected void collided(boolean collided)
    {
        if (!_collided)
        {
            _collided = true;
            System.out.println("Collision Imminent, stopping...");  
            Engines.breakBot();
            BoardLights.alarmLights();
        }
    }

    public boolean hasCollided()
    {
        return _collided;
    }

    public void stop()
    {
        if(_timer != null && !_timer.isDone())
            _timer.cancel(true);
    }

}
