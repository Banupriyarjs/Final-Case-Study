package com.perscholas.twistntreats.controller;

import com.perscholas.twistntreats.database.dao.CategoryDAO;
import com.perscholas.twistntreats.database.dao.ProductDAO;
import com.perscholas.twistntreats.database.entity.Category;
import com.perscholas.twistntreats.database.entity.Product;
import com.perscholas.twistntreats.formbean.CategoryFormBean;
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
import java.util.Map;
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
    public ModelAndView createProduct() {
        ModelAndView response = new ModelAndView();
        log.debug("In create Product with no args - log.debug");
        response.setViewName("product/create");

        //Load Categories
        List<Category> categoryList = categoryDao.findCategories();
        response.addObject("categoryList", categoryList);

        return response;
    }

    @PostMapping("/product/createSubmit")
    public ModelAndView saveProduct(@Valid ProductFormBean form, BindingResult bindingResult,
                                    @RequestParam("file") MultipartFile file) {

        String fileUrl = null;
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

        fileUrl = "/pub/images/" + file.getOriginalFilename();

        Product product = productService.createProduct(form, fileUrl);

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/product/create");
        return response;
    }

    @GetMapping("/product/viewproductlist")
    public ModelAndView viewProductList() {
        Integer categoryId = null;
        ModelAndView response = new ModelAndView();
        response.setViewName("product/viewproductlist");

        List<Object[]> productCount = categoryDao.findProductCount();

        System.out.println(productCount.size() + "product count");
        for (Object[] p : productCount) {
            Integer count = (Integer) p[0];
            String name = (String) p[1];
            System.out.println(count + " " + name);
            System.out.println(p[0]);

        }


        List<Category> categoryList = categoryDao.findCategories();
        response.addObject("categoryList", categoryList);
        System.out.println(categoryList.size());

        List<Product> productList = productDAO.findAll();
        response.addObject("productList", productList);
        System.out.println(productList.size());
        return response;
    }

    @RequestMapping("/product/detail")
    public ModelAndView viewProductDetails(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/detail");
        Product product = productDAO.findById(id);

        response.addObject("product", product);
        return response;
    }

    @GetMapping("/product/search")
    public ModelAndView searchProduct(String productname) {
        //We are setting this to empty string to pull up the category list during intial page load
        if (productname == null)
            productname = "";
        ModelAndView response = new ModelAndView("product/search");
        log.debug("In Search Product ModelAndView");
        List<Map<String, Object>> products = productDAO.findByProductName("%" + productname + "%");
        response.addObject("products", products);
        response.addObject("productname", productname);
        System.out.println(products.size());
        return response;
    }

    @GetMapping("/product/edit/{id}")
    public ModelAndView editProduct(@PathVariable int id) {
        ModelAndView response = new ModelAndView("product/create");
        Product product = productDAO.findById(id);

        ProductFormBean form = new ProductFormBean();

        if (product != null) {
            System.out.println(product.getId());
            form.setId(product.getId());
            form.setProductName(product.getProductName());
            form.setProductDescription(product.getProductDescription());
            form.setCategoryId(product.getCategoryId());
            form.setPrice(product.getPrice());
            form.setProductUrl(product.getProductUrl());

        } else {
            log.warn("Product is not found ! ");
        }
        //Load Categories
        List<Category> categoryList = categoryDao.findCategories();
        response.addObject("categoryList", categoryList);
        response.addObject("form", form);
        return response;
    }

    @GetMapping("/product/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id) {
        ModelAndView response = new ModelAndView("product/search");
        int value = productDAO.deleteById(id);
        System.out.println(value);
        if (value == 1) {
            response.setViewName("redirect:/product/search");
        } else {
            response.setViewName("error/404");
        }
        return response;
    }
}


