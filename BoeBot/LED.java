import TI.*;

/**
 * Write a description of class LED here.
 * 
 * @author Zwen van Erkelens 
 * @version (a version number or a date)
 */
public class LED
{
    private int _pin;
    private int _time;
    private boolean _status;

    public LED(int pin, int time)
    {
        _pin = pin;
        _status = false;
        _time = time;
    }

    public void switchLED()
    {
        _status = !_status;
        BoeBot.digitalWrite(_pin, _status);
    }

    public void blinkLED()
    {
        while(true)
        {
            switchLED();
            BoeBot.wait(_time);
        }
    }
}
