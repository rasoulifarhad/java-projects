package com.farhad.example.jobruner;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.storage.InMemoryStorageProvider;

public class JobRunrFactory {
    
    public static JobScheduler initializeJobRuner() {
        return JobRunr.configure()
                    .useStorageProvider(new InMemoryStorageProvider())
                    .useBackgroundJobServer()
                    .initialize()
                    .getJobScheduler();
    }
}
