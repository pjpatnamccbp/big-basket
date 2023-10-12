package com.virtusa.groceryservice.builder;

import com.virtusa.groceryservice.dto.Groceries;
import com.virtusa.groceryservice.dto.GroceryResponse;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 13-09-2023
 * @Description
 **/
@Component
public class ResponseBuilder {
    public GroceryResponse buildGroceryResponse(Groceries groceries) {
        GroceryResponse groceryResponse = new GroceryResponse();
        groceryResponse.setItemName(groceries.getItemName());
        groceryResponse.setStatus("Available");
        groceryResponse.setItemPrice(groceries.getMRP()*0.77);
        groceryResponse.setAvailableQuantity(groceries.getAvailableQuantity());
        groceryResponse.setMRP(groceries.getMRP());
        return groceryResponse;
    }
}
