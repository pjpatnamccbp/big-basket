package com.virtusa.groceryservice.dto;

import lombok.Data;

/**
 * @author hp ON 12-09-2023
 * @Description
 **/
@Data
public class GroceryRequest {
    private String itemName;
    private Double quantity;
}
