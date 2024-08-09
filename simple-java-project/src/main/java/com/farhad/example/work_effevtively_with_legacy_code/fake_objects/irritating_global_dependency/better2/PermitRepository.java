package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.irritating_global_dependency.better2;

public class PermitRepository implements IPermitRepository {

    private static IPermitRepository instance = null;
    
    protected PermitRepository() {

    }

    public static void setTestingInstance(IPermitRepository newInstance) {
        instance = newInstance;
    }
    public static IPermitRepository getInstance() {
        if(instance == null) {
            instance = new PermitRepository();
        }
        return instance;
    }

    @Override
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
