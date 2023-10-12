package com.virtusa.groceryservice.dao;

import com.virtusa.groceryservice.dto.Groceries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author hp ON 12-09-2023
 * @Description
 **/
@Repository
public interface IGroceryRepository extends JpaRepository<Groceries,Long> {

    //Optional<Groceries> findByItemNameAndId(String itemName);
    Groceries findByItemName(String itemName);
}
