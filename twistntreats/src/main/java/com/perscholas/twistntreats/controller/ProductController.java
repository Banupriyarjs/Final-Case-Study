package com.perscholas.twistntreats.controller;

import com.perscholas.twistntreats.database.dao.CategoryDAO;
import com.perscholas.twistntreats.database.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class ProductController {
@Autowired
private CategoryDAO categoryDao;
    @GetMapping("/product/create")
    public ModelAndView createProduct()
    {
        ModelAndView response=new ModelAndView();
        log.debug("In create Product with no args - log.debug");
        response.setViewName("product/create");

        //Load Categories
        List<Category> categoryList =categoryDao.findCategories();
        response.addObject("categoryList",categoryList);
        System.out.println("Length: "+categoryList.size());
        return response;
    }

}

