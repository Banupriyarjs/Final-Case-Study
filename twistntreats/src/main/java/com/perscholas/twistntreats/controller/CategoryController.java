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
import org.springframework.web.bind.annotation.PathVariable;
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
    public ModelAndView createCategory(CategoryFormBean form) {
        ModelAndView response = new ModelAndView("/category/create");

        categoryService.createCategory(form);
        log.debug("Create Category - create submit ");
        response.setViewName("redirect:/category/search");
        return response;

    }

    @GetMapping("category/search")
    public ModelAndView searchCategory(String categoryname) {
        //We are setting this to empty string to pull up the category list during intial page load
        if (categoryname == null)
            categoryname = "";
        ModelAndView response = new ModelAndView("category/search");
        log.debug("In Search Category ModelAndView");
        List<Category> categories = categoryDao.findByCategoryName(categoryname + "%");
        response.addObject("categories", categories);
        response.addObject("categoryname", categoryname);

        return response;
    }
    @GetMapping("/category/edit/{id}")
    public ModelAndView editCategory(@PathVariable int id)
    {
        ModelAndView response=new ModelAndView("category/create");
        Category category=categoryDao.findById(id);

        CategoryFormBean form=new CategoryFormBean();

        if(category!=null)
        {
            System.out.println(category.getId());
            form.setId(category.getId());
            form.setCategoryName(category.getCategoryName());
            form.setCategoryDescription(category.getCategoryDescription());

        }
        else
        {
            log.warn("Category is not found ! ");
        }
        response.addObject("form",form);
        return response;
    }
    @GetMapping("/category/delete/{id}")
    public ModelAndView deleteCategory(@PathVariable int id)
    {
        ModelAndView response=new ModelAndView("category/search");
        int value =categoryDao.deleteById(id);
        System.out.println(value);
        if(value==1) {
            response.setViewName("redirect:/category/search");
        }
        else
        {
            response.setViewName("error/404");
        }
         return response;
    }

}
