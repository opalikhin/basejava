package com.opalikhin.webapp.model;

import java.util.List;

public class Place {
    private final String title;
    private final String titleUrl;
    private final List<Period> periods;

    public Place(String title, String titleUrl, List<Period> periods) {
        this.title = title;
        this.titleUrl = titleUrl;
        this.periods = periods;
    }
}
