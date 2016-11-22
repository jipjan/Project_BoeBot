public class DrivePatern
{ 
    private static EnginePaternBuilder _builder = EnginePaternBuilder.getInstance();    
    
    public static void square()
    {
        _builder.clear();
        _builder.addStep(new EngineStep(Speed.MAX, 1000));
        _builder.addStep(new EngineStep(Speed.LEFT, Engines.calcWaitTime(90)));
        _builder.run(true);
    }
}
