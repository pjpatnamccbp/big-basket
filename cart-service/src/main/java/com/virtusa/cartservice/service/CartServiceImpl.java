package com.virtusa.cartservice.service;

import com.virtusa.cartservice.builder.CartResponseBuilder;

import com.virtusa.cartservice.builder.CartRequestBuilder;
import com.virtusa.cartservice.dao.ICartRepository;
import com.virtusa.cartservice.dto.*;
import com.virtusa.cartservice.exception.ItemNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * @author hp ON 15-09-2023
 * @Description
 **/
@Component
public class CartServiceImpl implements ICartService{

    @Autowired
    private ICartRepository cartRepository;
    @Autowired
    private CartRequestBuilder cartRequestBuilder;
    @Autowired
    private CartResponseBuilder cartResponseBuilder;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public CartResponse addToCart(CartRequest cartRequest) {
        CartDetails savedCartDetails = cartRepository.save(cartRequestBuilder.buildCartDetails(cartRequest));

        return cartResponseBuilder.buildCartResponse(savedCartDetails);
    }

    @Override
    //@Cacheable(value = "CartDetails")
    public List<CartDetails> getAllCartItems() {
        System.out.println("calling db.....");
        return cartRepository.findAll();
    }

    @Override
    public OrderResponse order(OrderRequest orderRequest) throws ItemNotAvailableException {

        /*Optional<CartDetails> optionalCartDetails = cartRepository.findById(orderRequest.);

        CartDetails cartDetails = null;
        if(optionalCartDetails.isPresent()){
            cartDetails = optionalCartDetails.get();
        }else{
            throw new ItemNotAvailableException("C005","item not available");
        }*/

        System.out.println("Before accessing order-service");
        String orderUrl = "http://localhost:8082/orders/place-order";

        /*OrderRequest orderRequest = new OrderRequest();

        orderRequest.setItemName(cartDetails.getItemName());
        orderRequest.setQuantity(cartDetails.getRequiredQuantity());*/

        OrderResponse orderResponse = restTemplate.postForObject(orderUrl,orderRequest, OrderResponse.class);
        System.out.println("after accessing order-service");

        return orderResponse;
    }

    @Override
    //@CacheEvict("CartDetails")
    public CartResponse removeFromCart(Long cartId) throws ItemNotAvailableException {
        /*if(!cartRepository.findById(cartId).isPresent()){
            throw new ItemNotAvailableException("C022","item Not found in cart");
        }
*/
        CartDetails cartDetails = cartRepository.findById(cartId).orElseThrow(() -> new ItemNotAvailableException("C022","item Not found in cart"));
        cartRepository.deleteById(cartId);
        return cartResponseBuilder.buildCartResponse(cartId);
    }
}
