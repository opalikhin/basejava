package com.opalikhin.webapp.model;

public class Contact {
    private final ContactType type;

    private final String value;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }
}
