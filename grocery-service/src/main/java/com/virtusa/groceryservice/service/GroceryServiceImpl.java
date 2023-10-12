package com.virtusa.groceryservice.service;

import com.virtusa.groceryservice.builder.RequestBuilder;
import com.virtusa.groceryservice.builder.ResponseBuilder;
import com.virtusa.groceryservice.dao.IGroceryRepository;
import com.virtusa.groceryservice.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hp ON 12-09-2023
 * @Description
 **/
@Service
public class GroceryServiceImpl implements IGroceryService {

    @Autowired
    private ResponseBuilder responseBuilder;
    @Autowired
    private RequestBuilder requestBuilder;
    @Autowired
    private IGroceryRepository groceryRepository;

    @Override
    public String addItems(Groceries groceries) {
        groceryRepository.save(groceries);
        return String.format("%s has added to the branch",groceries.getItemName());
    }

    @Override
    public List<Groceries> getAllItems() {
        return groceryRepository.findAll();
    }

    @Override
    public GroceryResponse getItemByName(String itemName) {
        Groceries groceries = groceryRepository.findByItemName(itemName);
        return responseBuilder.buildGroceryResponse(groceries);

    }

}
