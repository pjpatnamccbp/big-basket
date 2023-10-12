package com.virtusa.groceryservice.validator;

import com.virtusa.groceryservice.dto.Groceries;
import com.virtusa.groceryservice.dto.GroceryRequest;
import com.virtusa.groceryservice.exception.RequestInvalidException;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 12-09-2023
 * @Description
 **/
@Component
public class GroceryValidator {
    public void validateRequest(Groceries groceries) throws RequestInvalidException {
        if(groceries == null){
            throw new RequestInvalidException("G000","invalid request");
        }
        if(groceries.getItemName() == null || groceries.getItemName().equals("")){
            throw new RequestInvalidException("G001","invalid Item name");
        }
        if(groceries.getItemCategory() == null || groceries.getItemCategory().equals("")){
            throw new RequestInvalidException("G002","invalid Item Category");
        }
        if(groceries.getMRP().equals(0.0) || groceries.getMRP() < 1){
            throw new RequestInvalidException("G003","invalid MRP");
        }
        if(groceries.getAvailableQuantity().equals(0.0) || groceries.getAvailableQuantity() < 1){
            throw new RequestInvalidException("G004","invalid Quantity");
        }
    }
}
