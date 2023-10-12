package com.virtusa.cartservice.controller;

import com.virtusa.cartservice.dto.*;
import com.virtusa.cartservice.exception.ItemNotAvailableException;
import com.virtusa.cartservice.exception.RequestInvalidException;
import com.virtusa.cartservice.service.ICartService;
import com.virtusa.cartservice.validator.CartRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hp ON 15-09-2023
 * @Description
 **/
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRequestValidator cartRequestValidator;

    @Autowired
    private ICartService cartService;

    @PostMapping("/add")
    public CartResponse addToCart(@RequestBody CartRequest cartRequest) throws RequestInvalidException {
        cartRequestValidator.validateRequest(cartRequest);
        return cartService.addToCart(cartRequest);
    }

    @GetMapping("/show-all")
    @ResponseBody
    public List<CartDetails> getAllCartItems(){
        return cartService.getAllCartItems();
    }

    @PostMapping("/order")
    public OrderResponse order(@RequestBody OrderRequest orderRequest) throws ItemNotAvailableException {
        return cartService.order(orderRequest);
    }

    @DeleteMapping("/remove/{cartId}")
    public CartResponse removeFromCart(@PathVariable Long cartId) throws ItemNotAvailableException {
        return cartService.removeFromCart(cartId);}
}
