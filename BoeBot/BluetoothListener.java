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
                char data = (char) conn.readByte();                
                if (data == ';')
                {
                    
                }
                else
                {
                    switch(data)
                    {
                        case 'w': Engines.setSpeed(Speed.MAX); break; 
                        case 'a': Engines.setSpeed(Speed.LEFT); break;
                        case 's': Engines.setSpeed(Speed.MAX_REVERSE); break;
                        case 'd': Engines.setSpeed(Speed.RIGHT); break;
                        case 'q': Engines.setSpeed(Speed.HALF_LEFT); break;
                        case 'e': Engines.setSpeed(Speed.HALF_RIGHT); break;
                        case 'z': Engines.setSpeed(Speed.HALF_LEFT_REVERSE); break;
                        case 'c': Engines.setSpeed(Speed.HALF_RIGHT_REVERSE); break;
                        case ' ': Engines.breakBot(); break;
                        
                        case '1': DrivePatern.infinite(); break;
                    }
                }
                conn.writeByte(data);
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
