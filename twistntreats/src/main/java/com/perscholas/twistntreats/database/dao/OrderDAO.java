package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order,Long> {

    public Order findById(Integer id);

    //Create a query on the order table where the user_id is the logged in user and the status = 'cart'   ::::: select * from order o where o.user_id = :userId and status = 'cart';
    //if the query returns null then you create a new order with status cart
    //and save it to the database

   @Query("SELECT o FROM Order o WHERE o.status='CART' AND o.user.id=:userId")
    public Order findCartList(Integer userId);

}
