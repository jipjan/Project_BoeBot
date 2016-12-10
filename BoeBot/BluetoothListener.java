import TI.*;
import java.nio.charset.*;
public class BluetoothListener
{
    static byte[] writeOk = "Ok".getBytes(StandardCharsets.US_ASCII);
    static SerialConnection conn = new SerialConnection(115200);
    
    public static void start()
    {
        while(true)
        {
            if (conn.available()>0)
            {
                int data = conn.readByte();
                conn.writeByte(data);
                switch(data)
                {
                    case 119: Engines.setSpeed(Speed.MAX); break; 
                    case 97: Engines.setSpeed(Speed.LEFT); break;
                    case 115: Engines.setSpeed(Speed.MAX_REVERSE); break;
                    case 100: Engines.setSpeed(Speed.RIGHT); break;
                    case 32: Engines.breakBot(); break;
                }
                System.out.println("Received: " + data);
            }
            BoeBot.wait(10);
        }
        //w : 119
        //a : 97
        //s : 115
        //d : 100
        //Spatie : 32
    }

    private static void ok()
    {
        for (int i = 0; i < writeOk.length; i++)
            conn.writeByte(writeOk[i]);
    }
}
