import TI.*;

/**
 * Write a description of class Speaker here.
 * 
 * @author Zwen van Erkelens 
 * @version (a version number or a date)
 */
public class Speaker
{
    private int _pin;
    private int _time;
    private int _freq;
    
    public Speaker(int pin, int freq, int time)
    {
        _pin = pin;
        _freq = freq;
        _time = time;
    }
    
    public void beep()
    {
        while(true)
        {
            BoeBot.freqOut(_pin, _freq, _time);
            BoeBot.wait(_time);
        }
    }
    
    public void reverseBeep()
    {
        Speaker reverse = new Speaker(_pin, 5000, 500);
        reverse.beep();
    }
}
