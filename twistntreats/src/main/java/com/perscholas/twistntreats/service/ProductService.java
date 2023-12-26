package com.perscholas.twistntreats.service;

import com.perscholas.twistntreats.database.dao.ProductDAO;
import com.perscholas.twistntreats.database.entity.Category;
import com.perscholas.twistntreats.database.entity.Product;
import com.perscholas.twistntreats.database.entity.User;
import com.perscholas.twistntreats.formbean.ProductFormBean;
import com.perscholas.twistntreats.security.AuthenticatedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
        product.setProductUrl(imageUrl);
        product.setStatus("A");


        return productDAO.save(product);

    }

}
