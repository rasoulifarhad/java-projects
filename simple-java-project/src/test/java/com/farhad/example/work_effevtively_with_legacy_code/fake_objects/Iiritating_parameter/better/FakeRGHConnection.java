package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.Iiritating_parameter.better;

public class FakeRGHConnection implements IRGHConnection {

    public RFIDReport report;

    @Override
    public void connect() {
    }

    @Override
    public void disconnect() {
    }

    private void retry() {
    }

    @Override
    public RFIDReport RFDIReportFor(int id) {
        return report;
    }

    @Override
    public ACTIOReport ACTIOReportFor(int customerId) {
        return null;
    }

}
