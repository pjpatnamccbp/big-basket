package com.virtusa.cartservice.service;

import com.virtusa.cartservice.dto.*;
import com.virtusa.cartservice.exception.ItemNotAvailableException;

import java.util.List;

/**
 * @author hp ON 15-09-2023
 * @Description
 **/

public interface ICartService {

    CartResponse addToCart(CartRequest cartRequest);

    List<CartDetails> getAllCartItems();

    OrderResponse order(OrderRequest orderRequest) throws ItemNotAvailableException;

    CartResponse removeFromCart(Long cartId) throws ItemNotAvailableException;
}
