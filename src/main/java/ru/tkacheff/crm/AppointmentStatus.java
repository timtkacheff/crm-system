package ru.tkacheff.crm;

public enum AppointmentStatus {
    PAYMENT("payment"),
    IN_PROGRESS("in_progress"),
    FAILED("failed"),
    FINISHED("finished");

    AppointmentStatus(String value) {

    }
}
