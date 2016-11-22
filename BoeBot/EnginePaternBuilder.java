import java.util.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class EnginePaternBuilder
{
    private static EnginePaternBuilder _instance;   

    private ArrayList<EngineStep> _stepsToRun = new ArrayList<EngineStep>();
    private int _currentStep = 0;
    private ScheduledExecutorService _timer = Executors.newScheduledThreadPool(1);
    private boolean _stop = false;

    private EnginePaternBuilder() { }

    public static EnginePaternBuilder getInstance()
    {
        if (_instance == null) _instance = new EnginePaternBuilder();
        return _instance;
    }

    public void addStep(EngineStep step)
    {
        _stepsToRun.add(step);
    }

    public void clear()
    {
        _stepsToRun.clear();
    }

    public void stop()
    {
        _stop = true;
        _currentStep = 0;
        _timer.shutdown();
        Engines.setSpeed(Speed.STOP);
    }

    public void run(boolean repeat)
    {
        _stop = false;
        runStep(repeat);
    }

    private void runStep(boolean repeat)
    {        
        EngineStep step = _stepsToRun.get(_currentStep);
        Engines.setSpeed(step.Speed);
        _timer.schedule(() ->
            {
                if (_stop) return;
                _currentStep++;
                if (_currentStep < _stepsToRun.size())
                    run(repeat);
                else
                if (repeat)
                {
                    _currentStep = 0;
                    run(repeat);
                }
                else
                    Engines.setSpeed(Speed.STOP);
            }, step.Duration, MILLISECONDS);
    }
}

