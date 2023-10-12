package com.virtusa.cartservice.builder;

import com.virtusa.cartservice.dto.CartDetails;
import com.virtusa.cartservice.dto.CartResponse;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 15-09-2023
 * @Description
 **/
@Component
public class CartResponseBuilder {
    public CartResponse buildCartResponse(CartDetails cartDetails) {
        CartResponse cartResponse = new CartResponse();
        cartResponse.setCartId(cartDetails.getCartId());
        cartResponse.setResponseMessage(String.format("%s added to cart successfully",cartDetails.getItemName()));
        cartResponse.setResponseCode("C111");
        return cartResponse;
    }
    public CartResponse buildCartResponse(Long cartId) {
        CartResponse cartResponse = new CartResponse();
        cartResponse.setResponseCode("C100");
        cartResponse.setResponseMessage(String.format("%s removed from cart successfully",cartId));

        return cartResponse;
    }
}
