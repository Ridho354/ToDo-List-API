package com.enigma.ToDo.constant;

public enum Status {
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");
    
    private final String value;
    
    Status(String value) {
        this.value = value;
    }

    public static Status fromValue(String value) {
        for (Status Status : values()) {
            if (Status.value.equalsIgnoreCase(value)) {
                return Status;
            }
        }
        return null;
    }
}
