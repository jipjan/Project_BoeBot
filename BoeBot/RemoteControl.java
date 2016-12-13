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
                    values[i] = BoeBot.pulseIn(Constants.IFR_PIN, false, 20000);
                if (verifyHwd(values))   
                    return convertToInt(values);
                else
                    return -1;
            }            
            BoeBot.wait(20);
        }
    }

    private static Boolean toBit(int value)
    {
        return value > 1000;
    }

    private static boolean verifyHwd(int[] values)
    {
        int[] compare = Constants.IFR_HWID;
        for (int i = 7; i < 11; i++)        
            if (!(values[i] > compare[i-7] - 200 && values[i] < compare[i-7] + 200))
                return false;        
        return true;
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
        System.out.println(toReturn);
        return toReturn;
    }
}