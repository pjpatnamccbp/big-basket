package com.virtusa.cartservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author hp ON 15-09-2023
 * @Description
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartResponse {
    private String responseMessage;
    private Long cartId;
    private String responseCode;
}
