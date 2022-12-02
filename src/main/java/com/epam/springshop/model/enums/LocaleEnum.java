package com.epam.springshop.model.enums;

public enum LocaleEnum {
    UK("Ukrainian"),
    EN("English");
    private final String locale;

    public boolean equalsLocale(String otherLocale) {
        return locale.equals(otherLocale);
    }

    LocaleEnum(String created) {
        locale = created;
    }

    public String toString() {
        return this.locale;
    }
}
