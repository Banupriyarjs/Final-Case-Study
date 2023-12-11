package com.perscholas.twistntreats.controller;

import com.perscholas.twistntreats.database.entity.Category;
import com.perscholas.twistntreats.formbean.CategoryFormBean;
import com.perscholas.twistntreats.service.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Controller
public class CategoryController {
@Autowired
public CategoryService categoryService;
    @GetMapping("/category/create")
    public ModelAndView viewCategory() {
        log.debug("In Mapping method");
        ModelAndView response = new ModelAndView("category/create");
        return response;
    }
    @GetMapping("/category/createSubmit")
    public ModelAndView createCategory(CategoryFormBean form)
    {
        ModelAndView response = new ModelAndView("/category/create");

        categoryService.createCategory(form);
        log.debug("Create Category - create submit ");
        response.setViewName("redirect:/category/create");
        return response;

    }
}
