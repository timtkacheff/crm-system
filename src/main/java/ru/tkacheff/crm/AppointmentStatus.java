package ru.tkacheff.crm;

public enum AppointmentStatus {

    PAYMENT("PAYMENT"),
    IN_PROGRESS("IN_PROGRESS"),
    FAILED("FAILED"),
    FINISHED("FINISHED");


    private final String status;
    AppointmentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
