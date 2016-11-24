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
        EnginePaternBuilder b = new EnginePaternBuilder();
        b.addStep(new EngineStep(Speed.MAX, 1000));
        b.addStep(new EngineStep(Speed.MAX_REVERSE, 1000));
        b.addStep(new EngineStep(Speed.LEFT, 1000));
        b.addStep(new EngineStep(Speed.RIGHT, 1000));
        b.run();
         */
        /*
        while (true)
        {
        RemoteControlOverride.driveLikeAMofo();
        BoeBot.wait(200);
        }
         */
        while (true)
            RemoteControlOverride.driveLikeAMofo();
    }
}
