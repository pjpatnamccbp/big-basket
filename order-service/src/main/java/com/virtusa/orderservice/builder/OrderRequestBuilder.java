package com.virtusa.orderservice.builder;

import com.virtusa.orderservice.dto.GroceryResponse;
import com.virtusa.orderservice.dto.OrderDetails;
import com.virtusa.orderservice.dto.OrderRequest;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 29-09-2023
 * @Description
 **/
@Component
public class OrderRequestBuilder {
    public OrderDetails buildOrderDetails(OrderRequest orderRequest, GroceryResponse groceryResponse) {
        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setItemName(orderRequest.getItemName());
        orderDetails.setQuantity(orderRequest.getQuantity());
        orderDetails.setItemPrice(groceryResponse.getItemPrice()*0.77);
        orderDetails.setMRP(groceryResponse.getMRP());
        orderDetails.setTotalBill(orderRequest.getQuantity() * orderDetails.getItemPrice());
        orderDetails.setDeliveryAddress(orderRequest.getDeliveryAddress());
        orderDetails.setStatus("Ordered!!!");

        return orderDetails;
    }

    public OrderDetails buildOrderDetails(OrderDetails savedOrderDetails,OrderRequest orderRequest) {
        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setItemName(orderRequest.getItemName());
        orderDetails.setQuantity(orderRequest.getQuantity());
        orderDetails.setItemPrice(savedOrderDetails.getItemPrice()*0.77);
        orderDetails.setMRP(savedOrderDetails.getMRP());
        orderDetails.setTotalBill(orderRequest.getQuantity() * orderDetails.getItemPrice());
        orderDetails.setDeliveryAddress(orderRequest.getDeliveryAddress());
        orderDetails.setStatus("Order Updated!!!");

        return orderDetails;
    }
}
