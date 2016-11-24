public class DrivePatern
{ 
    private static EnginePaternBuilder _builder = EnginePaternBuilder.getInstance();    
    
   
    public static void square()
    {
        _builder.clear();
        _builder.addSteps(
            new EngineStep(Speed.MAX, 1000),
            new EngineStep(Speed.LEFT, Engines.calcWaitTime(90))
        );
        _builder.run(true);
    }

    public static void infinite()
    {
        _builder.clear();
        _builder.addSteps(
            new EngineStep(Speed.HALF_LEFT, 4500),
            new EngineStep(Speed.MAX, 1000),
            new EngineStep(Speed.HALF_RIGHT, 4500),
            new EngineStep(Speed.MAX, 1000)
        );
        _builder.run(true);
    }
}
