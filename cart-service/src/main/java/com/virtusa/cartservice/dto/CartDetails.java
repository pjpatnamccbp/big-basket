package com.virtusa.cartservice.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author hp ON 15-09-2023
 * @Description
 **/
@Data
@Entity
public class CartDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String itemName;
    private Double requiredQuantity;
}
