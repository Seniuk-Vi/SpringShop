package com.epam.springshop.model.enums;

public enum RoleEnum {
    USER("User"),
    ADMIN("Admin");
    private final String status;

    public boolean equalsStatus(String otherName) {
        return status.equals(otherName);
    }

    RoleEnum(String created) {
        status = created;
    }

    public String toString() {
        return this.status;
    }
}
