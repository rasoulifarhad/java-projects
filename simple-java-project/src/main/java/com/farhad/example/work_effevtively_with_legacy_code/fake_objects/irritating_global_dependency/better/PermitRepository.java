package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.irritating_global_dependency.better;

public class PermitRepository {

    private static PermitRepository instance = null;
    
    private PermitRepository() {

    }

    public static void setTestingInstance(PermitRepository newInstance) {
        instance = newInstance;
    }
    public static PermitRepository getInstance() {
        if(instance == null) {
            instance = new PermitRepository();
        }
        return instance;
    }

    public Permit findAssociatedPermit(PermitNotice notice) {
        // open  permit database
        // ...

        // select using values in notice
        // ...

        // verify we have only one matching permit, if not report error
        // ...

        // return the matching permit
        //...
        
        return null;
    }

}
