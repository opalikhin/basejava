package com.opalikhin.webapp.model;

import java.util.List;

public class ListSection extends AbstractSection{
    private final List<String> list;

    public ListSection(SectionType type, List<String> list) {
        super(type);
        this.list = list;
    }
}
