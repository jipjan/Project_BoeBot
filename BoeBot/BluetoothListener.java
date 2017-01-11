import TI.*;
import java.nio.charset.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;

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
                else if (data == Constants.BEGIN_END_COORDINATE_CHAR)
                    pointHandling(data);
                else
                    driveHandling(data);
            }, 20);
    }

    private static void pathHandling(char data)
    {
        data = (char) conn.readByte();
        List<LookPathLocation> list = PathCalculator.CurrentPath;
        list.clear();
        // Rewrite dis shiet
        
        /*
        do 
        {
            switch (data)
            {
                case 'w': list.add(new LookPathLocation(Look.EMPTY, PathItem.UP)); break;
                case 'a': list.add(new LookPathLocation(Look.EMPTY, PathItem.LEFT)); break;
                case 'd': list.add(new LookPathLocation(Look.EMPTY, PathItem.RIGHT)); break;
            }
            data = (char) conn.readByte();
        } while (data != Constants.BEGIN_END_PATH_CHAR);
        */
       
        System.out.println("Path Received: " + PathCalculator.pathToString());
        LightSensor.stopAutoDrive();
        LightSensor.startAutoDrive();
    }

    private static void driveHandling(char data)
    {
        LightSensor.stopAutoDrive();
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

            case 'r':
            LightSensor.startAutoDrive();
            break;

        }
        System.out.println("Received: " + data);
    }

    private static void pointHandling(char data)
    {
        LightSensor.stopAutoDrive();
        int xS = conn.readByte() - 48;
        int yS = conn.readByte() - 48;
        List<Point> points = new ArrayList<Point>();
        data = (char) conn.readByte();
        do 
        {
            int xE = data - 48;
            int yE = conn.readByte() - 48;
            points.add(new Point(xE, yE));
            data = (char) conn.readByte();
        } while (data != Constants.BEGIN_END_PATH_CHAR);
        PathCalculator p = new PathCalculator(xS, yS, 6, 8);
        p.calcPath(points.toArray(new Point[points.size()]));
        LightSensor.stopAutoDrive();
        LightSensor.startAutoDrive();
    }
}
