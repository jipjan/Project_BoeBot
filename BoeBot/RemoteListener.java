import TI.*;
public class RemoteListener
{    
    public static void startReading()
    {
        int input = RemoteControl.getRemoteInput();        
        LightSensor.stopAutoDrive();
        if (!CollisionDetection.hasCollided())
        {

            switch (input)
            {            
                case 0:            
                Engines.setSpeed(Speed.HALF_LEFT);
                BoardLights.leftLights();
                break;

                case 1:
                if (Engines.getCurrentSpeed() == Speed.HALF)
                    Engines.setSpeed(Speed.MAX);
                else
                    Engines.setSpeed(Speed.HALF);
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
            break;

            case 7:
            if (Engines.getCurrentSpeed() == Speed.HALF_REVERSE)
                Engines.setSpeed(Speed.MAX_REVERSE);
            else
                Engines.setSpeed(Speed.HALF_REVERSE);
            break;

            case 8:            
            Engines.setSpeed(Speed.HALF_RIGHT_REVERSE);
            BoardLights.rightLights();
            break;


            case 9:
            Engines.turnDegrees(180);            
            break;

            case 18:
            Engines.turnDegrees(-90);
            break;

            case 19:
            Engines.turnDegrees(90);
            break;

            case 21:
            LightSensor.startAutoDrive();
            break;


        }
        BoeBot.wait(50);
    }
}
