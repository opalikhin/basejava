package com.opalikhin.webapp.model;

public class StringSection extends AbstractSection{
    private final String value;

    public StringSection(SectionType type, String value) {
        super(type);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
