package com.bartendingfeature.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;


public class Drink {

    private  HashMap<String, String> ingredientsMap = new HashMap<>();



    private String drinkName;

    private String drinkInstructions;

    private String image;

    private String ingredient;

    public Drink() {

    }

    public HashMap<String, String> getIngredientsMap() {
        return ingredientsMap;
    }


    public void setIngredientsMap(HashMap<String, String> ingredientsMap) {
        this.ingredientsMap = ingredientsMap;
    }


    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkInstructions() {
        return drinkInstructions;
    }

    public void setDrinkInstructions(String drinkInstructions) {
        this.drinkInstructions = drinkInstructions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString(){
        return this.drinkName + " i have " + ingredientsMap.size() + " ingrediants";
    }
}
