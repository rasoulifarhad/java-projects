package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.aliased_parameter.better;

public class Permit {

    private PermitNotice notice;

    public Permit(PermitNotice notice) {
        this.notice = notice;
    }

    public boolean isValid() {
        return false;
    }

    public void validate() {
    }

}