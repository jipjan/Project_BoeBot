import TI.*;
/**
 * De Engines class bevat alle methoden om de boebot te laten rijden.
 * 
 * @author Groep B1 
 * @version 0.2
 */
public class Engines
{
    private static int _currentSpeed = 0;
    private static Servo _left = new Servo(12);
    private static Servo _right = new Servo(13); 

    /*
     * Zet de speed van beide motoren naar de ingevulde waarde.
     * @param speed     Set speed of bot, domain -200 - 200
     */
    public static void setSpeed(Speed speed)
    {
        leftSpeed(speed.Left);
        rightSpeed(speed.Right);
    }

    /*
     * Zet de bot abrupt stil
     */
    public static void breakBot()
    {
        setSpeed(Speed.STOP);
    }

    /*
     * Draai de bot, positief is naar rechts, negatief naar links
     */
    public static void turn(Turn spinSpeed)
    {
        leftSpeed(spinSpeed.Left);
        rightSpeed(spinSpeed.Right);
    }

    /*
     * Draai een aantal graden met de ingevoerde snelheid
     * @param degrees       Graden om te draaien
     * @param speed         Snelheid om mee te draaien
     */
    public static void turnDegrees(int degrees)
    {
        if (degrees == 0) return;
        turn(Turn.LEFT);        
        BoeBot.wait(calcWaitTime(degrees));
        breakBot();
    }
    
    public static int calcWaitTime(int degrees)
    {
        return 25 + (int) (340 * (degrees/90d));
    }

    /*
     * Zet snelheid van linker wiel.
     * @param speed     Snelheid
     */
    public static void leftSpeed(int speed)
    {    
        _left.update(1500 - speed);
    }

    /*
     * Zet snelheid van rechter wiel.
     * @param speed     Snelheid
     */
    public static void rightSpeed(int speed)
    {
        _right.update(1500 + speed);
    }
}
