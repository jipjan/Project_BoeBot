import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;
/**
 * De Engines class bevat alle methoden om de boebot te laten rijden.
 * 
 * @author Groep B1 
 * @version 0.2
 */
public class Engines
{   
    private static Speed _currentSpeed = Speed.STOP;
    private static Servo _left = new Servo(Constants.SERVO_LEFT);
    private static Servo _right = new Servo(Constants.SERVO_RIGHT);
    private static ScheduledFuture<?> _speedTimer;
    
    private static int _cLeft, _cRight = 0;

    /*
     * Zet de speed van beide motoren naar de ingevulde waarde.
     * @param speed     Set speed of bot, domain -200 - 200
     */
    public static void setSpeed(Speed speed)
    {
        BoardLights.stop();
        if (_speedTimer != null) _speedTimer.cancel(true);
        _speedTimer = TimerHandler.Timer.scheduleAtFixedRate(() ->           
                timerSetSpeed(speed), 0, 10, MILLISECONDS);        
    }

    private static void timerSetSpeed(Speed speed)
    {      
        if (_cLeft == speed.Left && _cRight == speed.Right) 
        {
            _currentSpeed = speed;
            _speedTimer.cancel(true);            
            return;
        }
        
        _cLeft += calcDiff(_cLeft, speed.Left);
        _cRight += calcDiff(_cRight, speed.Right); 
        leftSpeed(_cLeft);
        rightSpeed(_cRight);        
    }

    public static Speed getCurrentSpeed()
    {        
        return _currentSpeed;
    }

    /*
     * Zet de bot abrupt stil
     */
    public static void breakBot()
    {        
        if (_speedTimer != null) _speedTimer.cancel(true);
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
        _cLeft = speed;
        System.out.println("Left: " + _cLeft);
        _left.update(1500 - speed);
    } 

    /*
     * Zet snelheid van rechter wiel.
     * @param speed     Snelheid
     */
    public static void rightSpeed(int speed)
    {
        _cRight = speed;
        System.out.println("Right: " + _cRight);
        _right.update(1500 + speed);
    }

    private static int calcDiff(int cSpeed, int newSpeed)
    {
        if (cSpeed > newSpeed)
            return -5;
        else if (cSpeed < newSpeed)
            return 5;
        else
            return 0;
    }
}
