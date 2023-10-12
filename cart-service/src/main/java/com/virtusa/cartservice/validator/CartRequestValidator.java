package com.virtusa.cartservice.validator;

import com.virtusa.cartservice.dto.CartRequest;
import com.virtusa.cartservice.exception.RequestInvalidException;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 15-09-2023
 * @Description
 **/
@Component
public class CartRequestValidator {
    public void validateRequest(CartRequest cartRequest) throws RequestInvalidException {
        if(cartRequest == null){
            throw new RequestInvalidException("C001","invalid request object");
        }
        if(cartRequest.getItemName() == null || cartRequest.getItemName().equals("")
                || cartRequest.getItemName().length() < 3){
            throw new RequestInvalidException("C002","invalid Item name");
        }
        if(cartRequest.getRequiredQuantity() == 0 || cartRequest.getRequiredQuantity() < 1){
            throw new RequestInvalidException("C003","invalid quantity");
        }
    }
}
