package tddmicroexercises.telemetrysystem;

import java.util.Random;

import tddmicroexercises.Client;

public class TelemetryClient implements Client {

    private boolean onlineStatus;

    private final Random connectionEventsSimulator = new Random(42);

    @Override
    public boolean getOnlineStatus() {
        return onlineStatus;
    }

    @Override
    public void connect(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString)) {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        boolean success = connectionEventsSimulator.nextInt(10) <= 8;

        this.onlineStatus = success;
    }

    @Override
    public void disconnect() {
        this.onlineStatus = false;
    }
}
