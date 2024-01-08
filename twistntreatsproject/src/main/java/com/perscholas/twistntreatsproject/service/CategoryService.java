package com.perscholas.twistntreatsproject.service;

import com.perscholas.twistntreatsproject.database.dao.CategoryDAO;
import com.perscholas.twistntreatsproject.database.entity.Category;
import com.perscholas.twistntreatsproject.database.entity.User;
import com.perscholas.twistntreatsproject.formbean.CategoryFormBean;
import com.perscholas.twistntreatsproject.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDao;
    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    public void createCategory(CategoryFormBean form) {
        log.debug("id " + form.getId());
        log.debug("Category Name " + form.getCategoryName());
        log.debug("Category Description " + form.getCategoryDescription());
        //log.debug("Created By "+form.getCreatedBy());
        Category category = categoryDao.findById(form.getId());
        if (category == null) {
            User user = authenticatedUserService.loadCurrentUser();
            category = new Category();
          //  if(user!=null) {
                category.setCreatedBy(user.getId());
            //}

        }
        category.setCategoryName(form.getCategoryName());
        category.setCategoryDescription(form.getCategoryDescription());
        category.setCreatedDate(new Date());
        category.setStatus("A");

        categoryDao.save(category);

    }

}
