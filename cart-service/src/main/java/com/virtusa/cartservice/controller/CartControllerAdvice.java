package com.virtusa.cartservice.controller;

import com.virtusa.cartservice.dto.CartResponse;
import com.virtusa.cartservice.exception.ItemNotAvailableException;
import com.virtusa.cartservice.exception.RequestInvalidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hp ON 02-10-2023
 * @Description
 **/
@ControllerAdvice
public class CartControllerAdvice {
    @ExceptionHandler(RequestInvalidException.class)
    @ResponseBody
    public CartResponse handleRequestInvalidException(RequestInvalidException ex){
        return buildCartResponse(ex.getErrorCode(),ex.getErrorMessage());
    }


    @ExceptionHandler(ItemNotAvailableException.class)
    @ResponseBody
    public CartResponse handleItemNotAvailableException(ItemNotAvailableException exception){
        return buildCartResponse(exception.getErrorCode(), exception.getErrorMessage());
    }

    private CartResponse buildCartResponse(String errorCode, String errorMessage) {
        CartResponse cartResponse = new CartResponse();
        cartResponse.setResponseCode(errorCode);
        cartResponse.setResponseMessage(errorMessage);
        return cartResponse;
    }
}
