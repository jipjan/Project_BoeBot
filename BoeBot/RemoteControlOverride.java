
public class RemoteControlOverride
{

    public static void drive()
    {
        int input = RemoteControl.getRemoteInput();        

        if (!CollisionDetection.hasCollided())
        {
            Engines.breakBot();
            switch (input)
            {            
                case 0:            
                Engines.setSpeed(Speed.HALF_LEFT);
                BoardLights.leftLights();
                break;

                case 1: 
                Engines.setSpeed(Speed.MAX);
                break;

                case 2:            
                Engines.setSpeed(Speed.HALF_RIGHT);
                BoardLights.rightLights();
                break;
            }
        }

        switch (input)
        {
            case 3:             
            Engines.setSpeed(Speed.LEFT);
            BoardLights.leftLights();
            break;

            case 4:            
            Engines.breakBot();
            break;

            case 5:            
            Engines.setSpeed(Speed.RIGHT);
            BoardLights.rightLights();
            break;

            case 6:            
            Engines.setSpeed(Speed.HALF_LEFT_REVERSE);
            BoardLights.leftLights();
            SpeakerPatern.reverse();
            break;

            case 7: 
            Engines.setSpeed(Speed.MAX_REVERSE);
            SpeakerPatern.reverse();
            break;

            case 8:            
            Engines.setSpeed(Speed.HALF_RIGHT_REVERSE);
            BoardLights.rightLights();
            SpeakerPatern.reverse();
            break;

            case 29:
            DrivePatern.square();
            break;

            case 9:
            Engines.turnDegrees(180);            
            break;

            case 23:
            DrivePatern.infinite();
            break;

            case 18:
            Engines.turnDegrees(-90);
            break;

            case 19:
            Engines.turnDegrees(90);
            break;
        }
    }
}
