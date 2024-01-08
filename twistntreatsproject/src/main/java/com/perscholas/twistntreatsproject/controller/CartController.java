package com.perscholas.twistntreatsproject.controller;

import com.perscholas.twistntreatsproject.database.dao.OrderDetailDAO;
import com.perscholas.twistntreatsproject.database.entity.User;
import com.perscholas.twistntreatsproject.formbean.OrderDetailFormBean;
import com.perscholas.twistntreatsproject.formbean.OrderFormBean;
import com.perscholas.twistntreatsproject.security.AuthenticatedUserService;
import com.perscholas.twistntreatsproject.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


      /*  for(Object o:cartList)
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
        }*/



        return response;
    }
   @RequestMapping("/cart/placeorder")
    public ModelAndView saveOrder(@RequestParam Integer userId)
    {
        ModelAndView response = new ModelAndView("cart/view");
        orderService.updateOrder(userId);
        return null;
    }

    @RequestMapping("/cart/delete")
    public ModelAndView deleteItems(@RequestParam Integer orderId,@RequestParam Integer productId)
    {
        log.info("########In Delete Cart #########");
        ModelAndView response = new ModelAndView("cart/view");
        orderService.deleteCartItems(orderId,productId);
        return null;
    }
}
