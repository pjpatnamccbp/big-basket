package com.virtusa.orderservice.exception;

import lombok.Getter;

/**
 * @author hp ON 02-10-2023
 * @Description
 **/
@Getter
public class InvalidRequestException extends Throwable {
    private String errorCode;
    private String errorMessage;
    public InvalidRequestException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
