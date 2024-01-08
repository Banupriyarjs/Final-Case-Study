package com.perscholas.twistntreatsproject.database.dao;

import com.perscholas.twistntreatsproject.database.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

    @Query("SELECT  od FROM OrderDetail od WHERE od.order.id=:orderId AND od.product.id=:productId AND od.status='A' ")
    public OrderDetail findProductsExsistForOrder(Integer orderId, Integer productId);

    @Query(value = "SELECT o.id 'orderId',o.customer_id 'userId',p.id 'productId',p.product_url 'productUrl',p.product_name 'productName',\n" +
            "od.quantity 'quantity', p.price 'price', (od.quantity*p.price) 'totalPrice'\n" +
            "FROM\n" +
            "orders o \n" +
            "INNER JOIN order_details od ON o.id=od.order_id\n" +
            "INNER JOIN products p ON  p.id=od.product_id\n" +
            "INNER JOIN categories c ON c.id=od.category_id\n" +
            "INNER JOIN users u ON u.id=o.customer_id\n" +
            "WHERE o.status='CART' AND od.status='A' AND o.customer_id=?1 ORDER BY order_date", nativeQuery = true)
    List<Map<String, Object>> FetchCartList(Integer userId);

}
