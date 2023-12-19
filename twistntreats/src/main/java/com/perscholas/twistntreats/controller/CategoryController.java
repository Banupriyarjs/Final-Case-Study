package com.perscholas.twistntreats.controller;

import com.perscholas.twistntreats.database.dao.CategoryDAO;
import com.perscholas.twistntreats.database.entity.Category;
import com.perscholas.twistntreats.formbean.CategoryFormBean;
import com.perscholas.twistntreats.security.AuthenticatedUserService;
import com.perscholas.twistntreats.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class CategoryController {
        @Autowired
        private CategoryService categoryService;
        @Autowired
        private CategoryDAO categoryDao;

        @GetMapping("/category/create")
            public ModelAndView createCategory() {
                log.debug("In Mapping method");
                ModelAndView response = new ModelAndView("category/create");
                return response;
            }
            @GetMapping("/category/View")
            public ModelAndView viewCategory() {
                log.debug("In Mapping method");
                ModelAndView response = new ModelAndView("category/view");
                return response;
            }
            @GetMapping("/category/createSubmit")
            public ModelAndView createCategory(CategoryFormBean form)
            {
                ModelAndView response = new ModelAndView("/category/create");

                categoryService.createCategory(form);
                log.debug("Create Category - create submit ");
                response.setViewName("redirect:/category/search");
                return response;

            }
            @GetMapping("category/search")
            public ModelAndView searchCategory(String categoryName)
            {
                ModelAndView response= new ModelAndView("category/search");
                log.debug("In Search Category ModelAndView");
              /*  List<Category> categories=categoryDao.findByCategoryName(categoryName+"%");
                response.addObject("category",categories);
                response.addObject("categoryname",categoryName);*/
                List<Category> categoryList=categoryDao.findCategories();
                response.addObject("categoryList",categoryList);
                System.out.println(categoryList.size());
                return response;
    }
}
