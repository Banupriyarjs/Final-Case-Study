package com.perscholas.twistntreats.service;

import com.perscholas.twistntreats.database.dao.CategoryDAO;
import com.perscholas.twistntreats.database.entity.Category;
import com.perscholas.twistntreats.formbean.CategoryFormBean;
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

    public void createCategory(CategoryFormBean form)
    {
        log.debug("id "+form.getId());
        log.debug("Category Name "+form.getCategoryName());
        log.debug("Category Description "+form.getCategoryDescription());
     //   log.debug("Created By "+form.getCreatedBy());
     //   log.debug("Created On: "+form.getCreatedOn());
        LocalDate date = LocalDate.parse("2020-01-08");
        Category category= new Category();
        category.setCategoryName(form.getCategoryName());
        category.setCategoryDescription(form.getCategoryDescription());
       // category.setCreatedBy(1);
        category.setCreatedOn(form.getCreatedOn());

        categoryDao.save(category);

    }

}
