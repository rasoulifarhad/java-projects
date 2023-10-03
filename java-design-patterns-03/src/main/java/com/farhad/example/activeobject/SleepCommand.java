package com.farhad.example.activeobject;

public class SleepCommand  implements Command{

    private Command wakeupCommand = null;
    private ActiveObjectEngine engine = null;
    private long sleepTime = 0;
    private long startTime = 0;
    private boolean started = false;

    

    public SleepCommand(long millseconds, 
                        ActiveObjectEngine engine, 
                        Command wakeupCommand) {
        this.sleepTime = millseconds;
        this.engine = engine;
        this.wakeupCommand = wakeupCommand;
    }



    @Override
    public void execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if(!started) {
            started = true;
            startTime = currentTime;
            engine.addCommand(this);
        } else if ((currentTime - startTime) < sleepTime ) {
            engine.addCommand(this);
        } else {
            engine.addCommand(wakeupCommand);
        }
    }
    
}
