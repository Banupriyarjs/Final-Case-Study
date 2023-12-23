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

        User user = authenticatedUserService.loadCurrentUser();

        Order orderExists = orderDAO.findById(form.getId());

        System.out.println(user.getId() + "User ID");
        Integer OrderId = form.getId();

        System.out.println(odform.getQuantity() + "quantity");

        //OrderDetailFormBean odform=new OrderDetailFormBean();
        OrderDetail orderProductExists = orderDetailDAO.findProductsExsistForOrder(form.getId(), productId);


        Product product = productDAO.findById(productId);
        Category category = categoryDAO.findById(categoryId);


        if (orderProductExists == null && product != null && category != null) {

            Order order = new Order();
            order.setUser(user);
            order.setStatus("CART");
            order.setOrderDate(new Date());


            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            orderDetail.setCategory(category);
            orderDetail.setStatus("A");
            orderDetail.setQuantity(quantity);
            orderDetail.setTotalPrice(quantity * price);
            orderDetail.setCreatedDate(new Date());

            orderDAO.save(order);
            orderDetailDAO.save(orderDetail);
            ModelAndView response = new ModelAndView();
            response.setViewName("redirect:/cart/viewcart");
        }

    }
}
