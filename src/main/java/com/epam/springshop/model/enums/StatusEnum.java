package com.epam.springshop.model.enums;

public enum StatusEnum {
    CREATED("Created"),
    PAYED("Payed"),
    FINISHED("Finished");
    private final String status;

    public boolean equalsStatus(String otherName) {
        return status.equals(otherName);
    }

    StatusEnum(String created) {
        status = created;
    }

    public String toString() {
        return this.status;
    }
}
