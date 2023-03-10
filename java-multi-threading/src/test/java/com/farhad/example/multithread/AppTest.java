package com.farhad.example.multithread;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AppTest {
    
    @Test
    public void test() {

        ( new Thread() ).run();
        
        ( new Thread() ).start();

        List<Runnable> tasks = new ArrayList<>();
        ( new Thread( () -> {
                for (Runnable task : tasks) {
                    task.run();
                }            
        })).start();


        ( new Thread( () -> {
                while ( true ) {
                    // process of logic
                    if( Thread.currentThread().isInterrupted() ) {
                        // handle exiting
                        break;
                    }
                }   

        })).start();

        ( new Thread( () -> {
                try {
                  // working with resource  
                } finally{
                  // resource.close();
                  // might won't work because finally if deamon been interrupted  
                }
        })).start();

    }
}
