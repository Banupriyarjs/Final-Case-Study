package com.perscholas.twistntreats.controller;

import com.perscholas.twistntreats.database.dao.CategoryDAO;
import com.perscholas.twistntreats.database.dao.ProductDAO;
import com.perscholas.twistntreats.database.entity.Category;
import com.perscholas.twistntreats.database.entity.Product;
import com.perscholas.twistntreats.formbean.ProductFormBean;
import com.perscholas.twistntreats.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ProductController {
@Autowired
private CategoryDAO categoryDao;

@Autowired
private ProductDAO productDAO;
@Autowired
private ProductService productService;
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

    @PostMapping("/product/createSubmit")
    public ModelAndView saveProduct(@Valid ProductFormBean form, BindingResult bindingResult,
                                    @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            log.info("***** In Create Submit - has errors ************************");
            ModelAndView response = new ModelAndView("product/create");
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("error: " + error.getDefaultMessage());
            }
            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }
        log.info("***** In Create Submit - no errors found ************************");

       File f = new File("./src/main/webapp/pub/images/" + file.getOriginalFilename());
        try (OutputStream outputStream = new FileOutputStream(f.getAbsolutePath())) {
            IOUtils.copy(file.getInputStream(), outputStream);
        } catch (Exception e) {


            e.printStackTrace();
        }
        String fileUrl="/pub/images/"+file.getOriginalFilename();
        Product product = productService.createProduct(form,fileUrl);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/product/create");
        return response;
    }
    @GetMapping("/product/viewproductlist")
    public ModelAndView viewProductList()
    {
        Integer categoryId=null;
        ModelAndView response = new ModelAndView();
        response.setViewName("product/viewproductlist");

        List<Object[]> productCount=categoryDao.findProductCount();

        System.out.println(productCount.size()+"product count");
       for(Object[] p :productCount)
        {
           Integer count=(Integer)p[0];
            String name=(String)p[1];
            System.out.println(count+" "+name);
            System.out.println(p[0]);

        }



        List<Category> categoryList=categoryDao.findCategories();
        response.addObject("categoryList",categoryList);
        System.out.println(categoryList.size());

        List<Product> productList=productDAO.findAll();
        response.addObject("productList",productList);
        System.out.println(productList.size());
                return response;
    }
    @RequestMapping("/product/detail")
    public ModelAndView viewProductDetails(@RequestParam Integer id)
    {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/detail");
        Product product=productDAO.findById(id);

       response.addObject("product",product);
     /*   ProductFormBean form=new ProductFormBean();

        if(product!=null)
        {
            form.setProductName(product.getProductName());
            form.setProductDescription(product.getProductDescription());
            form.setProductUrl(product.getProductUrl());
            form.setPrice(product.getPrice());
        }*/
        return response;
    }
}


