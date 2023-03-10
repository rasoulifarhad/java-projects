**Life cycle of a thread**

                                                ┌─────────┐
                                                │  Start  │
                                                └────┬────┘
                                                     │         
                                                   start           
                                                     │  
                                                     V      
                                                ┌──────────┐          
                   ┌──────lock acquired────────>│ Runnable │<─────────notify/resume────┐
                   │                            └────┬─────┘                           │
                   │                                 │                                 │
                   │                             scheduled                             │
                   │                                 │                                 │
                   │                                 V                                 │ 
              ┌────┴────┐                       ┌─────────┐                       ┌────┴────┐
              │ Blocked │<────wait for lock─────┤ Running ├───────sleep/wait─────>│ Waiting │
              └─────────┘                       └────┬────┘                       └─────────┘
                                                     │        
                                                  stop/exit            
                                                     │        
                                                     V        
                                               ┌────────────┐
                                               │ Terminated │
                                               └────────────┘
