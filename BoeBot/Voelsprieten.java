import TI.*;

/**
 * Write a description of class Voelsprieten here.
 * 
 * @author Zwen van Erkelens 
 * @version (a version number or a date)
 */
public class Voelsprieten
{
    private boolean _left;
    private boolean _right;
    private boolean _collision;
    private int _leftPin;
    private int _rightPin;
    
    /**
     * Constructor for objects of class Voelsprieten
     */
    public Voelsprieten(int pinLeft, int pinRight)
    {
        _leftPin = pinLeft;
        _rightPin = pinRight;
    }
    
    public void collisionLeft()
    {
        while(true)
        {
            _left = BoeBot.digitalRead(_leftPin);
            
            if(_left == false)
            {
                System.out.println(_left);
            }
        }
    }
    
    public void collisionRight()
    {
        while(true)
        {
            _right = BoeBot.digitalRead(_rightPin);
            
            if(_right == false)
            {
                System.out.println(_right);
            }
        }
    }
    
    public void collisionBoth()
    {
        while(true)
        {
            _left = BoeBot.digitalRead(_leftPin);
            _right = BoeBot.digitalRead(_rightPin);
            
            if(_left == false && _right == false)
            {
                System.out.println(_left);
            }
        }
    }
}
