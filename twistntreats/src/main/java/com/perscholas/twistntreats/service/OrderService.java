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

   /* public void createOrderDetail(Integer orderID,Order order)
    {
       OrderDetailFormBean form=new OrderDetailFormBean();
       OrderDetail productExists= orderDetailDAO.findProductsExsistForOrder(orderID,form.getProductId());
       Product product=productDAO.findById(form.getProductId());
       Category category=categoryDAO.findById(form.getCategoryId());
       if(productExists==null)
       {
           OrderDetail orderDetail=new OrderDetail();
           orderDetail.setOrder(order);
           orderDetail.setProduct(product);
           orderDetail.setCategory(category);
           orderDetail.setStatus("A");
           orderDetail.setQuantity(form.getQuantity());
           orderDetail.setTotalPrice(form.getQuantity()* form.getTotalPrice());
           orderDetail.setCreatedDate(new Date());
       }

    }
*/

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
                orderDetail.setCategory(category);
                orderDetail.setStatus("A");
                orderDetail.setCreatedDate(new Date());
                orderDetail.setQuantity(quantity);
                orderDAO.save(order);
                orderDetailDAO.save(orderDetail);
                ModelAndView response = new ModelAndView();
                response.setViewName("redirect:/cart/viewcart");
            } else {

                orderProductExists.setQuantity(orderProductExists.getQuantity() + quantity);
                orderDetailDAO.save(orderProductExists);
            }
        }

    }

    public void updateOrder(Integer orderId) {
        User user = authenticatedUserService.loadCurrentUser();
        Order order = orderDAO.findCartList(user.getId());


        if (user != null && order != null) {
            order.setStatus("processed");
            order.setOrderDate(new Date());
        }
    }
}
