package com.virtusa.groceryservice.service;

import com.virtusa.groceryservice.dto.*;

import java.util.List;

/**
 * @author hp ON 12-09-2023
 * @Description
 **/
public interface IGroceryService {
//    GroceryResponse order(GroceryRequest groceryRequest) throws OutOfStockException;

    String addItems(Groceries groceries);

    List<Groceries> getAllItems();

    GroceryResponse getItemByName(String itemName);
}
