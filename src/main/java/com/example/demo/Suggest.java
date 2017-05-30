package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Suggest {

    private List<Suggestion> suggestions = new ArrayList<Suggestion>();

    public Suggest() {
    }

    public List<Suggestion> getSuggestion() {
        return suggestions;
    }

    public void setSuggestion(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return "Suggest{" +
                "suggestions=" + suggestions +
                '}';
    }
}
