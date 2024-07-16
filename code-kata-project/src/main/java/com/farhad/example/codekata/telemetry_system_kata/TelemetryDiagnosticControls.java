package com.farhad.example.codekata.telemetry_system_kata;

import lombok.Getter;
import lombok.Setter;

public class TelemetryDiagnosticControls {

    private final String diagnosticChannelConnectionString = "111#";
    private final TelemetryClient telemetryClient;
    
    @Getter
    @Setter
    private String diagnosticInfo = "";
    
    public TelemetryDiagnosticControls() {
        telemetryClient = new TelemetryClient();
    }

    public void checkTransmission() throws Exception {

        diagnosticInfo = "";
        telemetryClient.disconnect();

        int retryLeft = 3;
        while (telemetryClient.isOnlineStatus() == false && retryLeft > 0) {
            telemetryClient.connect(diagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if(telemetryClient.isOnlineStatus() == false) {
            throw new Exception("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }


    

}
