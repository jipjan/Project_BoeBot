import TI.*;

/**
 * Startup start de bot. * 
 * @author Groep B1
 */
public class Startup
{
    public static void main(String[] args)
    {
        /*
        EnginePaternBuilder b = EnginePaternBuilder.getInstance();
        b.addSteps(
            new EngineStep(Speed.MAX, 1000),
            new EngineStep(Speed.MAX_REVERSE, 1000),
            new EngineStep(Speed.LEFT, 1000),
            new EngineStep(Speed.RIGHT, 1000)
        );
        b.run(true);
        */
        /*
        while (true)
        {
        RemoteControlOverride.driveLikeAMofo();
        BoeBot.wait(200);
        }
         */
        
        while (true)
            RemoteControlOverride.drive();        
            
           
           /*
        EnginePaternBuilder b = EnginePaternBuilder.getInstance();
        b.addSteps(new EngineStep(Speed.MAX, 1000), new EngineStep(Speed.MAX_REVERSE, 1000));
        b.run(false);
        BoeBot.wait(500);
        b.stop();
        */
    }
}
