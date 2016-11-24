import TI.*;

public class RemoteControl
{
    public static int getRemoteInput()
    {
        System.out.println("Listening...");
        while(true)
        {
            int pulseLen = BoeBot.pulseIn(Constants.IFR_PIN, false, 6000);
            if (pulseLen > 2000)
            {
                int values[] = new int[12];
                for(int i = 0; i < 12; i++)
                    values[i] = BoeBot.pulseIn(Constants.IFR_PIN, false,20000);
                return convertToInt(values);
            }            
            BoeBot.wait(10);
        }
    }
    
    private static Boolean toBit(int value)
    {
        return value > 1000;
    }

    private static int convertToInt(int[] values)
    {
        int toReturn = 0;
        for (int i = 6; i >= 0; i--)
        {
            if (values[i] < 0) return -1;
            toReturn = toReturn << 1;
            if (toBit(values[i])) toReturn |= 1;            
        }
        return toReturn;
    }
}