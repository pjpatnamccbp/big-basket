package com.virtusa.orderservice.dao;

import com.virtusa.orderservice.dto.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hp ON 29-09-2023
 * @Description
 **/
@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails,Long> {
}
