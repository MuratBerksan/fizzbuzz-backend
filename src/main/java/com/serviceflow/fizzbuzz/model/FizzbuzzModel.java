package com.serviceflow.fizzbuzz.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FizzbuzzModel {

    @JsonProperty
    private String fizzBuzz;

    public String getFizzBuzz() {
        return fizzBuzz;
    }

    public void setFizzBuzz(String fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }
}
