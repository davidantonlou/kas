package com.example.kas.model;

import java.util.List;

public class Result {
    private List<Package> results;

    public Result(){}

    public Result(List<Package> results) {
        this.results = results;
    }

    public List<Package> getResults() {
        return results;
    }

    public void setResults(List<Package> results) {
        this.results = results;
    }
}
