package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.onion_parameter.better;

// the most immediate dependency of SchedulingTaskPane is SchedulingTask . If we can 
// create a fake SchedulingTask , we can create a SchedulingTaskPane .
//
// Unfortunately, SchedulingTask inherits from a class named SerialTask , and all
// it does is override some protected methods. All of the public methods are in
// SerialTask .
public class SchedulingTaskPane extends SchedulerPane {

    private ISchedulingTask task;

    public SchedulingTaskPane(ISchedulingTask task) {
        this.task = task;
    }
}
