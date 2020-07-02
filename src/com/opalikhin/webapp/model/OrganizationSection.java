package com.opalikhin.webapp.model;

import java.util.List;
import java.util.stream.Collectors;

public class OrganizationSection extends AbstractSection {
    private final List<Organization> organizations;

    public OrganizationSection(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public String toString() {
        return organizations.stream()
                .map(s -> "    - " + s.toString())
                .collect(Collectors.joining("\n"));
    }
}
