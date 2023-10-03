package com.farhad.example.activeobject;

public class DelayedTyper implements Command {

    private long itsDelay;
    private char itsCahr;
    private static ActiveObjectEngine engine = new ActiveObjectEngine();
    private static boolean stop =false;

    

    public DelayedTyper(long itsDelay, char itsCahr) {
        this.itsDelay = itsDelay;
        this.itsCahr = itsCahr;
    }
    @Override
    public void execute() throws Exception {
        System.out.print(itsCahr);
        if (!stop) {
            delayAndRepeat();
        }
    }
    private void delayAndRepeat() {
        engine.addCommand(new SleepCommand(itsDelay, engine, this));
    }

    public static void main(String[] args) throws Exception {

        engine.addCommand(new DelayedTyper(100, '1'));
        engine.addCommand(new DelayedTyper(300, '3'));
        engine.addCommand(new DelayedTyper(500, '5'));
        engine.addCommand(new DelayedTyper(700, '7'));

        Command stopCommand = new Command() {

            @Override
            public void execute() throws Exception {
                stop = true;
            }
            
        };

        engine.addCommand(
            new SleepCommand(2000, engine, stopCommand));
        engine.run();
    }

    
}
