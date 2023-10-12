package com.virtusa.orderservice.controller;

import com.virtusa.orderservice.dto.OrderDetails;
import com.virtusa.orderservice.dto.OrderRequest;
import com.virtusa.orderservice.dto.OrderResponse;
import com.virtusa.orderservice.exception.InvalidRequestException;
import com.virtusa.orderservice.service.IOrderService;
import com.virtusa.orderservice.validator.OrderRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hp ON 29-09-2023
 * @Description
 **/
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private OrderRequestValidator orderRequestValidator;
    @PostMapping("/place-order")
    public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) throws InvalidRequestException {

        orderRequestValidator.validateOrderRequest(orderRequest);

        return orderService.placeOrder(orderRequest);
    }

    @GetMapping("/all")
    public List<OrderDetails> myOrders(){
        return orderService.myOrders();
    }

    @DeleteMapping("/cancel/{orderId}")
    public OrderResponse cancelOrder(@PathVariable Long orderId){
        return orderService.cancelOrder(orderId);
    }

    @PutMapping("/update/{orderId}")
    public OrderResponse updateOrder(@PathVariable Long orderId,
                                     @RequestBody OrderRequest orderRequest) throws InvalidRequestException {
        orderRequestValidator.validateOrderRequest(orderRequest);
        return orderService.updateOrder(orderId,orderRequest);

    }

}
