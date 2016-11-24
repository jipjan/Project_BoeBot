import java.util.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

public class EnginePaternBuilder
{
    private static EnginePaternBuilder _instance;   

    private ArrayList<EngineStep> _stepsToRun;
    private ScheduledStep _currentStep;
    private ScheduledExecutorService _timer;

    private EnginePaternBuilder()
    {
        _stepsToRun = new ArrayList<EngineStep>();
        _currentStep = new ScheduledStep();
        _timer = Executors.newScheduledThreadPool(1);
    }

    public static EnginePaternBuilder getInstance()
    {
        if (_instance == null) _instance = new EnginePaternBuilder();
        return _instance;
    }

    public void addSteps(EngineStep... steps)
    {
        for (int i = 0; i < steps.length; i++)
            _stepsToRun.add(steps[i]);
    }

    public void clear()
    {
        stop();
        _stepsToRun.clear();
    }

    public void stop()
    {     
        if (_currentStep.ScheduledStep != null)
            _currentStep.ScheduledStep.cancel(true);
        _currentStep.Step = 0;
    }

    public void run(boolean repeat)
    {   
        EngineStep step = _stepsToRun.get(_currentStep.Step);
        // Set Speed for current step
        Engines.setSpeed(step.Speed);

        _currentStep.Step++;

        _currentStep.ScheduledStep = _timer.schedule(() ->
            {   
                if (_currentStep.Step < _stepsToRun.size())
                    run(repeat);
                else
                {
                    if (repeat)
                    {
                        _currentStep.Step = 0;
                        run(repeat);
                    }
                    else
                        stop();

                }
            }, step.Duration, MILLISECONDS);
    }
}

