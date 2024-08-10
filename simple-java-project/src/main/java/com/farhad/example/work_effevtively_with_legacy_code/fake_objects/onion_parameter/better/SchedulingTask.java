package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.onion_parameter.better;

public class SchedulingTask extends SerialTask implements ISchedulingTask {

    private Scheduler scheduler;
    private MeetingResolver resolver;

    public SchedulingTask(Scheduler scheduler, MeetingResolver resolver) {
        this.scheduler = scheduler;
        this.resolver = resolver;
    }
}
