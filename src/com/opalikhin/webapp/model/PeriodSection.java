package com.opalikhin.webapp.model;

import java.util.List;

public class PeriodSection extends AbstractSection{
    private final List<Place> places;

    public PeriodSection(SectionType type, List<Place> places) {
        super(type);
        this.places = places;
    }
}
