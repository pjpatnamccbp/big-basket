package com.virtusa.cartservice.exception;

import lombok.Getter;

/**
 * @author hp ON 29-09-2023
 * @Description
 **/
@Getter
public class ItemNotAvailableException extends Exception{
    private String errorCode;
    private String errorMessage;

    public ItemNotAvailableException(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
