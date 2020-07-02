package com.opalikhin.webapp.model;

public class Contact {
    private final String value;

    public Contact(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
