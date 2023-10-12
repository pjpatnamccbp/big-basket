package com.virtusa.orderservice.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author hp ON 29-09-2023
 * @Description
 **/
@Entity
@Data
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String itemName;
    private String status;
    private String deliveryAddress;
    private Double itemPrice;
    private Double MRP;

    private Double quantity;
    private Double totalBill;
}
