package com.virtusa.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

/**
 * @author hp ON 29-09-2023
 * @Description
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {
    private String status;
    private String responseMessage;
    private Double itemPrice;
    private Double quantity;
    private Double totalBill;
    private String responseCode;
}
