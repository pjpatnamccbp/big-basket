package com.virtusa.orderservice.service;

import com.virtusa.orderservice.builder.OrderRequestBuilder;
import com.virtusa.orderservice.builder.OrderResponseBuilder;
import com.virtusa.orderservice.dao.IOrderRepository;
import com.virtusa.orderservice.dto.GroceryResponse;
import com.virtusa.orderservice.dto.OrderDetails;
import com.virtusa.orderservice.dto.OrderRequest;
import com.virtusa.orderservice.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * @author hp ON 29-09-2023
 * @Description
 **/
@Component
public class OrderServiceImpl implements IOrderService{
    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private OrderRequestBuilder orderRequestBuilder;

    @Autowired
    private OrderResponseBuilder orderResponseBuilder;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        String groceriesURL = "http://localhost:8080/groceries/"+orderRequest.getItemName();
        GroceryResponse groceryResponse = restTemplate.getForObject(groceriesURL, GroceryResponse.class);

        OrderDetails savedOrderDetails = orderRepository.save(orderRequestBuilder.buildOrderDetails(orderRequest,groceryResponse));

        return orderResponseBuilder.buildOrderResponse(savedOrderDetails);
    }

    @Override
    public List<OrderDetails> myOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderResponse cancelOrder(Long orderId) {
        orderRepository.deleteById(orderId);

        return orderResponseBuilder.buildOrderResponse(orderId);
    }

    @Override
    public OrderResponse updateOrder(Long orderId,OrderRequest orderRequest) {
        Optional<OrderDetails> optionalOrderDetails = orderRepository.findById(orderId);
        OrderDetails orderDetails = null;
        if(optionalOrderDetails.isPresent()){
            orderDetails = optionalOrderDetails.get();
        }

        OrderDetails savedOrderDetails = orderRepository.save(orderRequestBuilder.buildOrderDetails(orderDetails,orderRequest));

        return orderResponseBuilder.buildOrderResponse(savedOrderDetails);

    }
}
