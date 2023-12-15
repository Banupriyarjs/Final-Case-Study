package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product,Long> {

 public Product findById(Integer id) ;

 List<Product> findByCategoryId(Integer categoryId);;
}
