package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail,Long> {

    @Query("SELECT  od FROM OrderDetail od WHERE od.order.id=:orderId AND od.product.id=:productId AND od.status='A' ")
    public OrderDetail findProductsExsistForOrder(Integer orderId,Integer productId);
}
