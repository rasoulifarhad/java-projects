package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.Iiritating_parameter.better;

import java.io.IOException;

// When an RGHConnection is constructed, it connects with a server. The connection 
// uses that server to get all of the reports it needs to validate a customer’s credit.
public class RGHConnection implements IRGHConnection {

    private int port;
    private String name;
    private String passwd;

    public RGHConnection(int port, String name, String passwd) throws IOException {
        this.port = port;
        this.name = name;
        this.passwd = passwd;
    }

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
        RFIDReport rfidReport = new RFIDReport();
        //
        //
        return rfidReport;
    }

    @Override
    public ACTIOReport ACTIOReportFor(int customerId) {
        ACTIOReport actioReport = new ACTIOReport();
        //
        //
        return actioReport;
    }

    private RFPacket formPacket() {
        RFPacket rfPacket = new RFPacket();
        //
        //
        return rfPacket;

    }
}
