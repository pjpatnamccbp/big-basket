package com.virtusa.orderservice.dto;

import lombok.Data;

/**
 * @author hp ON 29-09-2023
 * @Description
 **/
@Data
public class OrderRequest {
    private String itemName;
    private Double quantity;
    private String deliveryAddress;
}
