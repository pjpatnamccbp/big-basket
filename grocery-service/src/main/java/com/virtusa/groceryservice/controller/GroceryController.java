package com.virtusa.groceryservice.controller;

import com.virtusa.groceryservice.dto.Groceries;
import com.virtusa.groceryservice.dto.GroceryResponse;
import com.virtusa.groceryservice.exception.RequestInvalidException;

import com.virtusa.groceryservice.service.IGroceryService;
import com.virtusa.groceryservice.validator.GroceryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hp ON 12-09-2023
 * @Description
 **/
@RestController
@RequestMapping("/groceries")
public class GroceryController {
    @Autowired
    private GroceryValidator groceryValidator;
    @Autowired
    private IGroceryService groceryService;

    @PostMapping("/items/add")
    public String addItems(@RequestBody Groceries groceries) throws RequestInvalidException {
        groceryValidator.validateRequest(groceries);
        return groceryService.addItems(groceries);
    }

    @GetMapping
    public List<Groceries> getAllItems(){
        return groceryService.getAllItems();
    }

    @GetMapping("/{itemName}")
    public GroceryResponse getItemByName(@PathVariable String itemName){
        return groceryService.getItemByName(itemName);
    }
}
