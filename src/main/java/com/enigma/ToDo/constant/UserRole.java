package com.enigma.ToDo.constant;

public enum UserRole {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public static UserRole fromValue(String value) {
        for (UserRole userRole : values()) {
            if (userRole.value.equalsIgnoreCase(value)) {
                return userRole;
            }
        }
        return null;
    }
}
