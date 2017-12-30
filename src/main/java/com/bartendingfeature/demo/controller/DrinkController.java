package com.bartendingfeature.demo.controller;

import com.bartendingfeature.demo.model.Drink;
import com.bartendingfeature.demo.model.Drinks;
import com.bartendingfeature.demo.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/drinks")
@CrossOrigin(origins = "http://localhost:4200")
public class DrinkController {

    @Autowired
    DrinkService drinkService;

    @GetMapping("/{drinkName}")
    public ResponseEntity<ArrayList<Drink>>getDrinkByName(@PathVariable String drinkName){
        ArrayList<Drink> drinkList = new ArrayList<>();
        try {
            drinkList = drinkService.getDrinksByNameMapper(drinkName);
        } catch (IOException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(drinkList, HttpStatus.OK);
    }

}
