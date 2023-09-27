package com.farhad.example.completable_future.demo03;

public class LongTaskService {
    
    public String longTask(int taskId){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return taskId + "-"+ "task";
    } 
}
