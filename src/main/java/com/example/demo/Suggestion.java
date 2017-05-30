package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Suggestion {

    private String label;
    private String language;
    private String countryCode;
    private String locationId;
    private Address address;
    private String matchLevel;

    public Suggestion() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMatchLevel() {
        return matchLevel;
    }

    public void setMatchLevel(String matchLevel) {
        this.matchLevel = matchLevel;
    }

    @Override
    public String toString() {
        return "{" +
                "label=" + label +
                ", language='" + language + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", locationId='" + locationId + '\'' +
                ", address='" + address + '\'' +
                ", matchLevel='" + matchLevel + '\'' +
                '}';
    }
}
