package com.virtusa.cartservice.dto;

import lombok.Data;

/**
 * @author hp ON 15-09-2023
 * @Description
 **/
@Data
public class CartRequest {
    private String itemName;
    private Double requiredQuantity;
}
