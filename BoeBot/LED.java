import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/**
 * Class om LEDs aan te sturen op de boebot.
 * 
 * @author Groep B1
 */
public class LED
{
    private int _pin;
    private ScheduledFuture<?> _blinker;

    public LED(int pin)
    {
        _pin = pin;
    }

    public void switchLed()
    {
        BoeBot.digitalWrite(_pin, !BoeBot.digitalRead(_pin));
    }

    public void startBlink(int timeout)
    {
        _blinker = TimerHandler.Timer.scheduleWithFixedDelay(() -> switchLed(), 0, timeout, MILLISECONDS);
    }
    
    public void cancelBlink()
    {
        _blinker.cancel(true);
    }
}
