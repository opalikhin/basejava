package com.opalikhin.webapp.model;

public class StringSection extends AbstractSection {
    private final String value;

    public StringSection(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "    " + value;
    }
}
