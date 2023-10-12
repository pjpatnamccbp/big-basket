package com.virtusa.orderservice.service;

import com.virtusa.orderservice.dto.OrderDetails;
import com.virtusa.orderservice.dto.OrderRequest;
import com.virtusa.orderservice.dto.OrderResponse;

import java.util.List;

/**
 * @author hp ON 29-09-2023
 * @Description
 **/
public interface IOrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);

    List<OrderDetails> myOrders();

    OrderResponse cancelOrder(Long orderId);


    OrderResponse updateOrder(Long orderId,OrderRequest orderRequest);
}
