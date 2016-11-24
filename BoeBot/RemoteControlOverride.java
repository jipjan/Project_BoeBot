

public class RemoteControlOverride
{
   
    public static void driveLikeAMofo()
    {
        switch (RemoteControl.getRemoteInput())
        {
            case 0:
            Engines.setSpeed(Speed.HALF_LEFT);
            break;
            
            case 1: 
            Engines.setSpeed(Speed.MAX);
            break;
            
            case 2:
            Engines.setSpeed(Speed.HALF_RIGHT);
            break;
            
            case 3: 
            Engines.setSpeed(Speed.LEFT);
            break;
            
            case 4: 
            Engines.breakBot();
            break;
            
            case 5:
            Engines.setSpeed(Speed.RIGHT);
            break;
            
            case 6:
            Engines.setSpeed(Speed.HALF_LEFT_REVERSE);
            break;
            
            case 7: 
            Engines.setSpeed(Speed.MAX_REVERSE);
            break;
            
            case 8:
            Engines.setSpeed(Speed.HALF_RIGHT_REVERSE);
            break;
            
            case 29:
            DrivePatern.square();
            break;
            
            case 9:
            DrivePatern.infinite();
            break;
            
            case 23:
            Engines.turnDegrees(180);
            break;
        }
    }
}
