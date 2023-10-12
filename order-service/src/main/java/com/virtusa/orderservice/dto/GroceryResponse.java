package com.virtusa.orderservice.dto;

import lombok.Data;

/**
 * @author hp ON 29-09-2023
 * @Description
 **/
@Data
public class GroceryResponse {
    private String itemName;
    private Double MRP;
    private Double itemPrice;
    private String status;
    private Double availableQuantity;
}
