package com.virtusa.cartservice.builder;

import com.virtusa.cartservice.dto.CartDetails;
import com.virtusa.cartservice.dto.CartRequest;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 15-09-2023
 * @Description
 **/
@Component
public class CartRequestBuilder {
    public CartDetails buildCartDetails(CartRequest cartRequest) {
        CartDetails cartDetails = new CartDetails();

        cartDetails.setItemName(cartRequest.getItemName());
        cartDetails.setRequiredQuantity(cartRequest.getRequiredQuantity());
        return cartDetails;
    }
}
