package com.opalikhin.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final List<Position> positions = new ArrayList<>();

    public Organization(String name, String url) {
        this.homePage = new Link(name, url);
    }

    public Organization(String name, String url, LocalDate fromDate, LocalDate toDate, String title, String description) {
        this.homePage = new Link(name, url);
        this.positions.add(new Position(fromDate, toDate, title, description));
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return homePage.getName() + ' ' + homePage.getUrl() + '\n' +
                positions.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return homePage.equals(that.homePage) &&
                positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, positions);
    }
}
