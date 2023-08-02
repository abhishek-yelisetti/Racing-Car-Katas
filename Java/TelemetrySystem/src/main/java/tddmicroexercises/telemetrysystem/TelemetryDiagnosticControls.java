package tddmicroexercises.telemetrysystem;

import tddmicroexercises.*;

public class TelemetryDiagnosticControls {
    private final String DiagnosticChannelConnectionString = "*111#";
    private String diagnosticInfo;

    private final Client telemetryClient;
    private final TelemetryTransmissionControl telemetryTransmissionControl;

    public TelemetryDiagnosticControls(Client client, TelemetryTransmissionControl telemetryTransmissionControl) {
        diagnosticInfo = "";
        this.telemetryClient = client;
        this.telemetryTransmissionControl = telemetryTransmissionControl;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        telemetryClient.disconnect();

        int retryLeft = 3;
        while (telemetryClient.getOnlineStatus() == false && retryLeft > 0) {
            telemetryClient.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (telemetryClient.getOnlineStatus() == false) {
            throw new Exception("Unable to connect.");
        }

        telemetryTransmissionControl.send(Client.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryTransmissionControl.receive();
    }
}
