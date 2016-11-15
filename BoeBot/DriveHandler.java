import TI.*;
/**
 * De drivehandler class bevat alle methoden om de boebot te laten rijden.
 * 
 * @author Groep B1 
 * @version 0.1
 */
public class DriveHandler
{
    private int _currentSpeed;
    private Servo _left;
    private Servo _right;

    public DriveHandler()
    {
        _currentSpeed = 0;
        _left = new Servo(12);
        _right = new Servo(13);
    }    

    /*
     * Zet de speed van beide motoren naar de ingevulde waarde.
     * @param speed     Set speed of bot, domain -200 - 200
     */
    public void setSpeed(int speed)
    {      
        // TODO: make casual
        leftSpeed(speed);
        rightSpeed(speed);
    }

    /*
     * Zet de bot abrupt stil
     */
    public void breakBot()
    {
        leftSpeed(0);
        rightSpeed(0);
    }

    /*
     * Draai de bot, positief is naar rechts, negatief naar links
     */
    public void turn(int spinSpeed)
    {
        leftSpeed(-spinSpeed);
        rightSpeed(spinSpeed);
    }

    /*
     * Draai een aantal graden met de ingevoerde snelheid
     * @param degrees       Graden om te draaien
     * @param speed         Snelheid om mee te draaien
     */
    public void turnDegrees(int degrees, int speed)
    {
        if (speed == 0 || degrees == 0) return;
        double waitTime = (degrees / 90d) * (100000d/speed);
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
        speed = correctSpeed(speed);       
        _left.update(1500 - speed);
    }

    /*
     * Zet snelheid van rechter wiel.
     * @param speed     Snelheid
     */
    public void rightSpeed(int speed)
    {
        speed = correctSpeed(speed);
        _right.update(1500 + speed);
    }
    
    /*
     * Corrigeer speed voor als deze buiten domein ligt.
     * @param speed     Input speed.
     */
    private int correctSpeed(int speed)
    {
        if (speed > 200) return 200;
        else if (speed < -200) return -200;
        else return speed;
    }
}
