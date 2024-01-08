package com.perscholas.twistntreatsproject.service;

import com.perscholas.twistntreatsproject.database.dao.ProductDAO;
import com.perscholas.twistntreatsproject.database.entity.Product;
import com.perscholas.twistntreatsproject.database.entity.User;
import com.perscholas.twistntreatsproject.formbean.ProductFormBean;
import com.perscholas.twistntreatsproject.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    public Product createProduct(ProductFormBean form, String imageUrl)
    {
        Product product = productDAO.findById(form.getId());

        User user = authenticatedUserService.loadCurrentUser();
        if (product == null) {

            product = new Product();

        }


        product.setProductName(form.getProductName());
        product.setProductDescription(form.getProductDescription());
        product.setCategoryId(form.getCategoryId());
        product.setPrice(form.getPrice());
        product.setCreatedDate(new Date());
        product.setCreatedBy(user.getId());
        if(imageUrl!=null) {
            product.setProductUrl(imageUrl);
        }
        product.setStatus("A");


        return productDAO.save(product);

    }

}
