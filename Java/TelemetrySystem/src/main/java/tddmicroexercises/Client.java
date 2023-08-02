package tddmicroexercises;

public interface Client {

    boolean getOnlineStatus();

    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    void connect(String telemetryServerConnectionString);

    void disconnect();
}
