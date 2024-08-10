package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.onion_parameter.better;

// the most immediate dependency of SchedulingTaskPane is SchedulingTask . If we can 
// create a fake SchedulingTask , we can create a SchedulingTaskPane .
public class SchedulingTaskPane extends SchedulerPane {

    private SchedulingTask task;

    public SchedulingTaskPane(SchedulingTask task) {
        this.task = task;
    }
}
