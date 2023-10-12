package com.virtusa.groceryservice.controller;

import com.virtusa.groceryservice.dto.GroceryResponse;
import com.virtusa.groceryservice.exception.RequestInvalidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hp ON 12-09-2023
 * @Description
 **/
@ControllerAdvice
public class GroceryControllerAdvice {
    @ExceptionHandler(RequestInvalidException.class)
    @ResponseBody
    public GroceryResponse handleRequestInvalidException(RequestInvalidException exception){
        return buildGroceryResponse(exception.getErrorCode(),exception.getErrorMessage());
    }


    private GroceryResponse buildGroceryResponse(String errorCode, String errorMessage) {
        GroceryResponse groceryResponse = new GroceryResponse();
        groceryResponse.setResponseCode(errorCode);
        groceryResponse.setResponseMessage(errorMessage);
        return groceryResponse;
    }
}
