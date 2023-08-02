package tddmicroexercises;

public interface TelemetryTransmissionControl {
    void send(String message);

    String receive();
}
