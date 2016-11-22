import TI.*;

/**
 * Write a description of class Ultrasoon here.
 * 
 * @author Zwen van Erkelens 
 * @version (a version number or a date)
 */
public class Ultrasoon
{
    public static void main(String[] args)
    {
        System.out.println("Starting..");
        while(true)
        {
            BoeBot.digitalWrite(0, true);
            BoeBot.wait(1);
            BoeBot.digitalWrite(0, false);
            
            int pulse = BoeBot.pulseIn(1, true, 10000);
            System.out.println("Pulse: " + pulse);
            BoeBot.wait(50);
        }
    }
}
