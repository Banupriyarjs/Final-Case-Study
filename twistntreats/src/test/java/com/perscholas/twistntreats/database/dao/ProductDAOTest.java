package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.Category;
import com.perscholas.twistntreats.database.entity.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDAOTest {
    @Autowired
    private ProductDAO productDAO;

    @Test
    @Order(1)
    public void createProductTest() {
        //setting the created date
        LocalDateTime localDateTime = LocalDateTime.of(2024, 1, 7, 14, 26, 20);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        //given
        Product product = new Product();
        product.setProductName("Test Glazed Donuts");
        product.setProductDescription("Test Glazed Product Description");
        product.setCategoryId(11);
        product.setPrice(2.99);
        product.setCreatedBy(1);
        product.setStatus("A");
        product.setProductUrl("/pub/images/ChoclateDonut.jpg");
        product.setCreatedDate(date);
        //when
        product = productDAO.save(product);

        //then
        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals("Test Glazed Donuts", product.getProductName());
        Assertions.assertEquals("Test Glazed Product Description", product.getProductDescription());
        Assertions.assertEquals(11, product.getCategoryId());
        Assertions.assertEquals(2.99, product.getPrice());
        Assertions.assertEquals("A", product.getStatus());
        Assertions.assertEquals(1, product.getCreatedBy());
        Assertions.assertEquals("/pub/images/ChoclateDonut.jpg", product.getProductUrl());
        Assertions.assertEquals(date, product.getCreatedDate());

    }

    @Test
    @Order(2)
    public void findProductByNameTest() {
        String productName = "Test Glazed Donuts";

        List<Map<String, Object>> products = productDAO.findByProductName(productName);

        Assertions.assertEquals(1, products.size());

        // Ensure that the list is not null and has one product
        Assertions.assertNotNull(products);
        Assertions.assertEquals(1, products.size());

        System.out.println(products.size());

        // Get the first product from the list
        Map<String, Object> product = products.get(0);

        // Print the entries for debugging
        for (Map.Entry<String, Object> entry : product.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


        Assertions.assertNotNull(product.get("productId"));
        Assertions.assertEquals("Test Glazed Donuts", product.get("productName"));
        Assertions.assertEquals("Test Glazed Product Description", product.get("productDescription"));
        Assertions.assertEquals(11, product.get("categoryId"));
        Assertions.assertEquals(1, product.get("createdBy"));
        Assertions.assertEquals("A", product.get("status"));
        Assertions.assertEquals("/pub/images/ChoclateDonut.jpg", product.get("productUrl"));

    }

    @Test
    @Order(3)
    public void deleteByProductIdTest() {
        //search for the Category to disable

        String productName = "Test Glazed Donuts";

        List<Map<String, Object>> products = productDAO.findByProductName(productName);

        Assertions.assertEquals(1, products.size());

        Map<String, Object> product = products.get(0);


        //Disabling the status of the product status to 'D'
        Object productIdObj = product.get("productId");
        int productId = (Integer) productIdObj;

        int deleted = productDAO.deleteById(productId);


        //Testing to check whether the given product id is disabled or not
        Assertions.assertEquals(1, deleted);

        Product productDeleted = productDAO.findById(productId);

        Assertions.assertNotNull(productDeleted.getId());
        Assertions.assertEquals("Test Glazed Donuts", productDeleted.getProductName());
        Assertions.assertEquals("Test Glazed Product Description", productDeleted.getProductDescription());
        Assertions.assertEquals(11, productDeleted.getCategoryId());
        Assertions.assertEquals(2.99, productDeleted.getPrice());
        Assertions.assertEquals("D", productDeleted.getStatus());
        Assertions.assertEquals(1, productDeleted.getCreatedBy());
        Assertions.assertEquals("/pub/images/ChoclateDonut.jpg", productDeleted.getProductUrl());


    }
}
