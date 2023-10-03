package com.farhad.example.activeobject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppTest {

    private boolean commandExecuted = false;

    @Test
    public void testSleep() throws Exception {

        Command wakeup = new Command() {

            @Override
            public void execute() throws Exception {
                commandExecuted = true;
            }
            
        };
        ActiveObjectEngine activeObjectEngine = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand(1000, activeObjectEngine, wakeup);
        activeObjectEngine.addCommand(c);
        long start = System.currentTimeMillis();
        activeObjectEngine.run();
        long stop = System.currentTimeMillis();
        long sleepTime = stop - start;
        assertTrue(sleepTime >= 1000, "SleepTime " + sleepTime + " expected > 1000");
        assertTrue(sleepTime < 1100, "SleepTime " + sleepTime + " expected < 1100");
        assertTrue(commandExecuted, "Command executed");
    }
}
