package com.farhad.example.work_effevtively_with_legacy_code.fake_objects.Iiritating_parameter;

import java.io.IOException;

// When an RGHConnection is constructed, it connects with a server. The connection 
// uses that server to get all of the reports it needs to validate a customer’s credit.
public class RGHConnection {

    private int port;
    private String name;
    private String passwd;

    public RGHConnection(int port, String name, String passwd) throws IOException {
        this.port = port;
        this.name = name;
        this.passwd = passwd;
    }
}
