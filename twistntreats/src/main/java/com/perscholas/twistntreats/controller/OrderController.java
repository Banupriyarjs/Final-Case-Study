package com.perscholas.twistntreats.controller;

import com.perscholas.twistntreats.database.dao.OrderDAO;
import com.perscholas.twistntreats.database.dao.OrderDetailDAO;
import com.perscholas.twistntreats.database.entity.User;
import com.perscholas.twistntreats.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class OrderController {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;


    @GetMapping("/order/ordersummary")
    public ModelAndView viewOrderSummary() {
        log.info("**********In View Order Summary ***********************");
        ModelAndView response = new ModelAndView("order/ordersummary");
        User user = authenticatedUserService.loadCurrentUser();
        List<Map<String, Object>> orderSummary = orderDAO.findOrderSummary(user.getId());
        response.addObject("ordersummary", orderSummary);
        response.addObject("userId", user.getId());
        System.out.println(orderSummary.size());
        return response;
    }

    @GetMapping("/order/orderdetail/{orderId}")
    public ModelAndView viewOrderDetail(@PathVariable int orderId) {
        log.info("**********In View Order Detail ***********************");
        ModelAndView response = new ModelAndView("order/orderdetail");
        User user = authenticatedUserService.loadCurrentUser();
        List<Map<String, Object>> orderDetails = orderDetailDAO.fetchOrderDetails(orderId);
        response.addObject("orderdetails", orderDetails);
        response.addObject("orderId", orderId);
        System.out.println(orderDetails.size());
        return response;
    }
}
