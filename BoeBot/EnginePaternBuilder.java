import java.util.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class EnginePaternBuilder
{
    private ArrayList<EngineStep> _stepsToRun = new ArrayList<EngineStep>();
    private int _currentStep = 0;
    private ScheduledExecutorService _timer = Executors.newScheduledThreadPool(1);
    
    public void addStep(EngineStep step)
    {
        _stepsToRun.add(step);
    }
    
    public void clear()
    {
        _stepsToRun.clear();
    }
    
    public void run()
    {
        EngineStep step = _stepsToRun.get(_currentStep);
        Engines.setSpeed(step.Speed);
        _timer.schedule(() ->
        {
            _currentStep++;
            if (_stepsToRun.size() < _currentStep)
                run();
            else
                Engines.setSpeed(Speed.STOP);
        }, step.Duration, MILLISECONDS);
    }
}


