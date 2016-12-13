import TI.*;
import java.nio.charset.*;
import java.util.List;

public class BluetoothListener extends BaseListener
{
    static SerialConnection conn = new SerialConnection(115200);

    public static void start()
    {
        start("Bluetooth", () -> 
            {
                if (conn.available() <= 0) return;
                char data = (char) conn.readByte();                
                if (data == Constants.BEGIN_END_PATH_CHAR)
                    pathHandling(data);
                else
                    driveHandling(data);
            }, 20);
    }

    private static void pathHandling(char data)
    {
        data = (char) conn.readByte();
        List<PathItem> list = LightPath.getPathList();
        list.clear();
        do 
        {
            switch (data)
            {
                case 'w': list.add(PathItem.UP); break;
                case 'a': list.add(PathItem.LEFT); break;
                case 'd': list.add(PathItem.RIGHT); break;
            }
            data = (char) conn.readByte();
        } while (data != Constants.BEGIN_END_PATH_CHAR);
        System.out.println("Path Received: " + LightPath.pathAsString());
    }

    private static void driveHandling(char data)
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
        System.out.println("Received: " + data);
    }
}
