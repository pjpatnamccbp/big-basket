package com.virtusa.cartservice.dao;

import com.virtusa.cartservice.dto.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 15-09-2023
 * @Description
 **/
@Component
public interface ICartRepository extends JpaRepository<CartDetails,Long> {
}
