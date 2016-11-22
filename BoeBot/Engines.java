import TI.*;
/**
 * De Engines class bevat alle methoden om de boebot te laten rijden.
 * 
 * @author Groep B1 
 * @version 0.2
 */
public class Engines
{
    private int _currentSpeed;
    private Servo _left;
    private Servo _right; 
    
    public Engines()
    {
        _currentSpeed = 0;
        _left = new Servo(12);
        _right = new Servo(13);
    }    

    /*
     * Zet de speed van beide motoren naar de ingevulde waarde.
     * @param speed     Set speed of bot, domain -200 - 200
     */
    public void setSpeed(Speed speed)
    {
        leftSpeed(speed.Left);
        rightSpeed(speed.Right);
    }

    /*
     * Zet de bot abrupt stil
     */
    public void breakBot()
    {
        setSpeed(Speed.STOP);
    }

    /*
     * Draai de bot, positief is naar rechts, negatief naar links
     */
    public void turn(Speed spinSpeed)
    {
        leftSpeed(-spinSpeed.Left);
        rightSpeed(spinSpeed.Right);
    }

    /*
     * Draai een aantal graden met de ingevoerde snelheid
     * @param degrees       Graden om te draaien
     * @param speed         Snelheid om mee te draaien
     */
    public void turnDegrees(int degrees, Speed speed)
    {
        if (speed == Speed.STOP || degrees == 0) return;
        double waitTime = (degrees / 90d) * (100000d/speed.Left);
        turn(speed);        
        BoeBot.wait((int) waitTime);
        breakBot();
    }

    /*
     * Zet snelheid van linker wiel.
     * @param speed     Snelheid
     */
    public void leftSpeed(int speed)
    {    
        _left.update(1500 - speed);
    }

    /*
     * Zet snelheid van rechter wiel.
     * @param speed     Snelheid
     */
    public void rightSpeed(int speed)
    {
        _right.update(1500 + speed);
    }
}
