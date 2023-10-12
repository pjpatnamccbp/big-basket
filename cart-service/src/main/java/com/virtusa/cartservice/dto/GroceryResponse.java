package com.virtusa.cartservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author hp ON 12-09-2023
 * @Description
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroceryResponse {
    private String itemName;
    private Double MRP;
    private Double itemPrice;
    private String status;
    private Double totalBill;
    private String responseCode;
    private String responseMessage;
}
