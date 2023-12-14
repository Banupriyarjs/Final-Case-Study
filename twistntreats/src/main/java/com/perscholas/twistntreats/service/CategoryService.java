package com.perscholas.twistntreats.service;

import com.perscholas.twistntreats.database.dao.CategoryDAO;
import com.perscholas.twistntreats.database.entity.Category;
import com.perscholas.twistntreats.database.entity.User;
import com.perscholas.twistntreats.formbean.CategoryFormBean;
import com.perscholas.twistntreats.security.AuthenticatedUserService;
import com.perscholas.twistntreats.security.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Slf4j
@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDao;
    @Autowired
    private AuthenticatedUserService authenticatedUserService;
      public void createCategory(CategoryFormBean form)
    {
        log.debug("id "+form.getId());
        log.debug("Category Name "+form.getCategoryName());
        log.debug("Category Description "+form.getCategoryDescription());
        //log.debug("Created By "+form.getCreatedBy());

      User user=authenticatedUserService.loadCurrentUser();

        Category category= new Category();
        category.setCategoryName(form.getCategoryName());
        category.setCategoryDescription(form.getCategoryDescription());
        category.setCreatedBy(user.getId());
        category.setCreatedDate(new Date());

        categoryDao.save(category);

    }

}
