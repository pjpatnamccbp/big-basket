package com.virtusa.groceryservice.dto;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hp ON 12-09-2023
 * @Description
 **/
@Data
@Entity
public class Groceries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private String itemCategory;
    private Double MRP;
    private Double availableQuantity;


}
