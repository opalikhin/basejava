package com.opalikhin.webapp.model;

public class Organization {
    private final String title;
    private final String titleUrl;
    private final String fromDate;
    private final String toDate;
    private final String description;

    public Organization(String title, String titleUrl, String fromDate, String toDate, String description) {
        this.title = title;
        this.titleUrl = titleUrl;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return title + ' ' + titleUrl + '\n' +
                "      " + fromDate + " - " + toDate + ' ' + description;
    }
}
