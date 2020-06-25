package com.opalikhin.webapp.model;

public abstract class AbstractSection {
    private final SectionType type;

    protected AbstractSection(SectionType type) {
        this.type = type;
    }
}
