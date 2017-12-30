package com.bartendingfeature.demo.service;

import com.bartendingfeature.demo.model.Drink;
import com.bartendingfeature.demo.model.Drinks;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DrinkService {

//    String api    http://www.thecocktaildb.com/api/json/v1/1/search.php?s=

//    private Logger logger = LoggerFactory.getLogger(BartenderApp.class);

    @Autowired
    RestTemplate restTemplate;

    public Drinks getDrinksByName(String drinkName){
        Drinks drinks = restTemplate.getForObject("http://www.thecocktaildb.com/api/json/v1/1/search.php?s="+drinkName, Drinks.class);
        return drinks;
    }

    public ArrayList<Drink> getDrinksByNameMapper(String drinkName) throws IOException{
        ArrayList<Drink> drinkList = new ArrayList<>();
        ResponseEntity<String> response = restTemplate.getForEntity("http://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + drinkName, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode drinks = root.get("drinks");
        for (JsonNode drinkNode: drinks) {
            Drink drink = new Drink();
            drink.setDrinkName( drinkNode.get("strDrink").textValue());
            HashMap<String, String> ingrediants = new HashMap<>();
            for(int x = 1; x <=15; x++){
                String currentKey = "strIngredient"+x;
                String currentValue = drinkNode.get(currentKey).textValue();
                if (!currentValue.equals("")) {
                    ingrediants.put(currentKey, currentValue);
                }
            }
            drink.setIngredientsMap(ingrediants);
            drinkList.add(drink);
        }
        return drinkList;
    }



}
