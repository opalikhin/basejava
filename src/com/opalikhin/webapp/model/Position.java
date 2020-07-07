package com.opalikhin.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Position {
    private final LocalDate fromDate;
    private final LocalDate toDate;
    private final String title;
    private final String description;

    public Position(LocalDate fromDate, LocalDate toDate, String title, String description) {
        Objects.requireNonNull(fromDate, "fromDate must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return fromDate.equals(position.fromDate) &&
                Objects.equals(toDate, position.toDate) &&
                title.equals(position.title) &&
                Objects.equals(description, position.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromDate, toDate, title, description);
    }

    @Override
    public String toString() {
        return "      " + fromDate + " - " + toDate + ' ' + title + '\n' +
                description + '\n';
    }
}
