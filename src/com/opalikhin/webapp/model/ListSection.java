package com.opalikhin.webapp.model;

import java.util.List;
import java.util.stream.Collectors;

public class ListSection extends AbstractSection{
    private final List<String> list;

    public ListSection(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        return list.stream()
                   .map(s -> "    - " + s)
                   .collect(Collectors.joining("\n"));
    }
}
