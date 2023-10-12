package com.virtusa.orderservice.validator;

import com.virtusa.orderservice.dto.OrderRequest;
import com.virtusa.orderservice.exception.InvalidRequestException;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 02-10-2023
 * @Description
 **/
@Component
public class OrderRequestValidator {

    public void validateOrderRequest(OrderRequest orderRequest) throws InvalidRequestException {
        if(orderRequest == null){
            throw new InvalidRequestException("B000","invalid request object");
        }
        if(orderRequest.getItemName() == null || orderRequest.getItemName().equals("")){
            throw new InvalidRequestException("B000","invalid item name");
        }
        if(orderRequest.getQuantity() == null || orderRequest.getQuantity().equals(0.0)){
            throw new InvalidRequestException("B002","invalid item quantity");
        }
        if(orderRequest.getDeliveryAddress() == null || orderRequest.getDeliveryAddress().equals("") ||
            orderRequest.getDeliveryAddress().length() < 2 ){
            throw new InvalidRequestException("B003","invalid delivery address");
        }
    }
}
