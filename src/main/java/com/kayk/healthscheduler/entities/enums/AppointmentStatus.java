package com.kayk.healthscheduler.entities.enums;

public enum AppointmentStatus {
    PENDING(1),
    CONFIRMED(2),
    CANCELED(3),
    COMPLETED(4),
    NO_SHOW(5);

    private int code;

    private AppointmentStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AppointmentStatus valueOf(int code) {
        for(AppointmentStatus value : AppointmentStatus.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid AppointmentStatus code");
    }
}
