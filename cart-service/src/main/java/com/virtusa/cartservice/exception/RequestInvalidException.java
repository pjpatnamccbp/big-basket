package com.virtusa.cartservice.exception;

import lombok.Getter;

/**
 * @author hp ON 02-10-2023
 * @Description
 **/
@Getter
public class RequestInvalidException extends Exception{
    private String errorCode;
    private String errorMessage;

    public RequestInvalidException(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
