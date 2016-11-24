import TI.*;
/**
 * De Engines class bevat alle methoden om de boebot te laten rijden.
 * 
 * @author Groep B1 
 * @version 0.2
 */
public class Engines
{   
    private static Servo _left = new Servo(Constants.SERVO_LEFT);
    private static Servo _right = new Servo(Constants.SERVO_RIGHT); 

    /*
     * Zet de speed van beide motoren naar de ingevulde waarde.
     * @param speed     Set speed of bot, domain -200 - 200
     */
    public static void setSpeed(Speed speed)
    {        
        BoardLights.stop();
        leftSpeed(speed.Left);
        rightSpeed(speed.Right);
    }

    /*
     * Zet de bot abrupt stil
     */
    public static void breakBot()
    {
        EnginePaternBuilder.getInstance().stop();
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
        
        if (degrees > 0)
            turn(Turn.LEFT);
        else
            turn(Turn.RIGHT);
            
        BoeBot.wait(calcWaitTime(Math.abs(degrees)));
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
