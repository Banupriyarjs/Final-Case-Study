package com.perscholas.twistntreats.service;

import com.perscholas.twistntreats.database.dao.*;
import com.perscholas.twistntreats.database.entity.*;
import com.perscholas.twistntreats.formbean.OrderDetailFormBean;
import com.perscholas.twistntreats.formbean.OrderFormBean;
import com.perscholas.twistntreats.security.AuthenticatedUserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Slf4j
@Service
@Transactional
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderDetailDAO orderDetailDAO;
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    ProductDAO productDAO;
    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    public void createOrder(OrderFormBean form, OrderDetailFormBean odform, Integer productId, Integer categoryId, Integer quantity, Double price) {

        Integer orderId = null;
        User user = authenticatedUserService.loadCurrentUser();

        Order order = orderDAO.findCartList(user.getId());
        if (order != null) {
            orderId = order.getId();
        }
        OrderDetail orderProductExists = orderDetailDAO.findProductsExsistForOrder(orderId, productId);

        Product product = productDAO.findById(productId);

        Category category = categoryDAO.findById(categoryId);


        if (user != null && product != null && category != null) {


            if (order == null) {
                order = new Order();
                order.setUser(user);
                order.setStatus("CART");
                order.setOrderDate(new Date());
            }

            if (orderProductExists == null) {

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrder(order);
                orderDetail.setProduct(product);
                orderDetail.setCategoryId(categoryId);
                orderDetail.setStatus("A");
                orderDetail.setCreatedDate(new Date());
                orderDetail.setQuantity(quantity);
                orderDAO.save(order);
                orderDetailDAO.save(orderDetail);

            } else {

                orderProductExists.setQuantity(orderProductExists.getQuantity() + quantity);
                orderDetailDAO.save(orderProductExists);
            }

        }

    }

    public void updateOrder(Integer customerId) {

        Order order = orderDAO.findCartList(customerId);


        if (order != null) {
            order.setStatus("PROCESSED");
            order.setOrderDate(new Date());
            orderDAO.save(order);
        }
    }

    public void deleteCartItems(Integer orderId,Integer productId)
    {
        OrderDetail orderProductExists = orderDetailDAO.findProductsExsistForOrder(orderId, productId);
          System.out.println(orderId);
          System.out.println(productId);
        if(orderProductExists!=null)
        {
            System.out.println(orderId);
            System.out.println(productId);
            orderProductExists.setStatus("D");
            orderProductExists.setCreatedDate(new Date());
            orderDetailDAO.save(orderProductExists);
        }

    }
}
