package com.bartendingfeature.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Drinks {

    @JsonProperty("drinks")
    private List<Drink> drinks;

    public Drinks(){

    }

    public List<Drink> getDrinks() {
        return drinks;
    }
}
