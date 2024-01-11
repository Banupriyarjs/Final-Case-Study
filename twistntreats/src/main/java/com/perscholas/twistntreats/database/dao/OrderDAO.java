package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

    public Order findById(Integer id);

    @Query("SELECT o FROM Order o WHERE o.status='CART' AND o.user.id=:userId")
    public Order findCartList(Integer userId);

    @Query(value = "SELECT o.id  'orderId', o.order_date 'orderDate', sum(od.quantity*p.price) 'totalPrice'\n" +
            "FROM orders o\n" +
            "INNER JOIN order_details od ON o.id=od.order_id AND od.status='A'\n" +
            "INNER JOIN products p ON p.id=od.product_id\n" +
            "WHERE o.status='PROCESSED' AND o.customer_id =?1 \n" +
            "GROUP BY o.id\n" +
            "ORDER BY o.order_date", nativeQuery = true)
    public List<Map<String, Object>> findOrderSummary(Integer userId);

}
