package com.virtusa.orderservice.controller;

import com.virtusa.orderservice.dto.OrderResponse;
import com.virtusa.orderservice.exception.InvalidRequestException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hp ON 02-10-2023
 * @Description
 **/
@ControllerAdvice
public class OrderControllerAdvice {
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseBody
    public OrderResponse handleRequestInvalidException(InvalidRequestException exception){
        return buildOrderResponse(exception.getErrorCode(),exception.getErrorMessage());
    }

    private OrderResponse buildOrderResponse(String errorCode, String errorMessage) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setResponseMessage(errorMessage);
        orderResponse.setResponseMessage(errorCode);
        return orderResponse;
    }
}
