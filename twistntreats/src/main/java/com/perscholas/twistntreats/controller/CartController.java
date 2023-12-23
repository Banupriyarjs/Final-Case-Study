package com.perscholas.twistntreats.controller;

import com.perscholas.twistntreats.database.dao.OrderDAO;
import com.perscholas.twistntreats.database.dao.OrderDetailDAO;
import com.perscholas.twistntreats.database.entity.Order;
import com.perscholas.twistntreats.database.entity.OrderDetail;
import com.perscholas.twistntreats.database.entity.User;
import com.perscholas.twistntreats.formbean.OrderDetailFormBean;
import com.perscholas.twistntreats.formbean.OrderFormBean;
import com.perscholas.twistntreats.security.AuthenticatedUserService;
import com.perscholas.twistntreats.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class CartController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailDAO orderDetailDAO;
    @Autowired
    private AuthenticatedUserService authenticatedUserService;
    @RequestMapping("/cart/addtocart")
    public void addToCart(@Valid OrderFormBean form, @Valid OrderDetailFormBean odform, BindingResult bindingResult, @RequestParam Integer prodid, @RequestParam Integer catid, @RequestParam Integer quantity, @RequestParam Double price) {

        if (bindingResult.hasErrors()) {
            log.info("########In Add To Cart -Submit - has erros##########");
            ModelAndView response = new ModelAndView("order/addtocart");
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("error : " + error.getDefaultMessage());
            }
            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            //return response;
        }
        log.info("########In Add To Cart -Submit-no error found##########");
        orderService.createOrder(form, odform, prodid, catid, quantity, price);

    }

    @GetMapping("/cart/viewcart")
    public ModelAndView viewCartItems()
    {
        ModelAndView response= new ModelAndView("cart/view");
        User user = authenticatedUserService.loadCurrentUser();
        List<Map<String,Object>> cartList=orderDetailDAO.FetchCartList(user.getId());
        response.addObject("cartlist",cartList);
        response.addObject("userId",user.getId());


        for(Object o:cartList)
        {
            System.out.println(o.toString());
        }

        for (Map<String, Object> map : cartList) {
            System.out.print("{");

            // Iterate over each entry in the map and print key-value pairs
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.print(entry.getKey() + ": " + entry.getValue() + ", ");

            }

            System.out.println("}");
        }



        return response;
    }


}
