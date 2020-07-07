package com.opalikhin.webapp.model;

import java.util.Objects;

public class StringSection extends AbstractSection {
    private final String value;

    public StringSection(String value) {
        Objects.requireNonNull(value, "value must not be null");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "    " + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringSection that = (StringSection) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
