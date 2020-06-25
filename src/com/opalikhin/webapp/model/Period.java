package com.opalikhin.webapp.model;

public class Period {
    private final String fromDate;
    private final String toDate;
    private final String title;
    private final String description;

    public Period(String fromDate, String toDate, String title, String description) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.title = title;
        this.description = description;
    }
}
