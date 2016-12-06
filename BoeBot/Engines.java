import TI.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

/* De Engines class bevat alle methoden om de boebot te laten rijden.
 * 
 * @author Groep B1 
 * @version 0.2
 */
public class Engines
{   
    private static Speed _currentSpeed = Speed.STOP;
    private static Servo _left = new Servo(Constants.SERVO_LEFT);
    private static Servo _right = new Servo(Constants.SERVO_RIGHT);
    private static ScheduledFuture<?> _timer;

    /*
     * Zet de speed van beide motoren naar de ingevulde waarde.
     * @param speed     Set speed of bot, domain -200 - 200
     */
    public static void setSpeed(Speed speed)
    {        
        BoardLights.stop();
        if (_timer != null) _timer.cancel(true);
        if (speed.equals(_currentSpeed)) return;        
        switch (speed)
        {
            case STOP:
            while (!_currentSpeed.equals(0,0))
            {                
                if (_currentSpeed.Left != 0) _currentSpeed.Left += _currentSpeed.compareLeft(speed.Left);
                if (_currentSpeed.Right != 0) _currentSpeed.Right += _currentSpeed.compareRight(speed.Right);
                leftSpeed(_currentSpeed.Left);
                rightSpeed(_currentSpeed.Right);
                System.out.println("Current Left: " + _currentSpeed.Left + "Current Right: " + _currentSpeed.Right);
                BoeBot.wait(10);                
            }
            break;

            default:
            leftSpeed(speed.Left);
            rightSpeed(speed.Right);
            _currentSpeed = speed;
            break;
        }
        //leftSpeed(speed.Left);
        //rightSpeed(speed.Right);
        //slowSpeedUp(speed.Left, speed.Right);        
    }

    private static void slowSpeedUp(int left, int right)
    {
        if (_currentSpeed.equals(left, right)) return;        
        _timer = TimerHandler.Timer.schedule(() ->
            {  
                int comp = _currentSpeed.compare(left, right);                  
                System.out.println("Left: " + comp + " Right: " + comp);
                _currentSpeed.Left = left + comp;
                _currentSpeed.Right = right + comp;
                leftSpeed(_currentSpeed.Left);
                rightSpeed(_currentSpeed.Right);
                System.out.println("Current Left: " + _currentSpeed.Left + "Current Right: " + _currentSpeed.Right);
                slowSpeedUp(_currentSpeed.Left, _currentSpeed.Right);
            }, 10, MILLISECONDS);
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
        if (_timer != null) _timer.cancel(true);
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
