package com.virtusa.orderservice.builder;

import com.virtusa.orderservice.dto.OrderDetails;
import com.virtusa.orderservice.dto.OrderResponse;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 29-09-2023
 * @Description
 **/
@Component
public class OrderResponseBuilder {
    public OrderResponse buildOrderResponse(OrderDetails savedOrderDetails) {
        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setResponseMessage(String.format("item %s has ordered successfully",savedOrderDetails.getItemName()));
        orderResponse.setQuantity(savedOrderDetails.getQuantity());
        orderResponse.setItemPrice(savedOrderDetails.getItemPrice());
        orderResponse.setTotalBill(savedOrderDetails.getTotalBill());
        orderResponse.setStatus(String.format("order placed for %s  address", savedOrderDetails.getDeliveryAddress()));
        orderResponse.setResponseCode("B111");
        return orderResponse;
    }
    public OrderResponse buildOrderResponse(Long orderId) {
        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setResponseMessage(String.format("item %d has order cancelled successfully",orderId));

        orderResponse.setStatus(String.format("cancelled!!!"));
        orderResponse.setResponseCode("B112");
        return orderResponse;
    }
}
