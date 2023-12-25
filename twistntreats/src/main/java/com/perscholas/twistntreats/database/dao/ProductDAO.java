package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ProductDAO extends JpaRepository<Product,Long> {

 public Product findById(Integer id) ;

 List<Product> findByCategoryId(Integer categoryId);;


 @Query(value="SELECT p.id 'productId' ,p.product_name 'productName',p.product_description 'productDescription',\n" +
         "p.price  'price',p.product_url 'productUrl',\n" +
         "c.category_name 'categoryName'\n" +
         "FROM  products p  \n" +
         "INNER JOIN categories c ON c.id=p.category_id\n" +
         "WHERE p.status='A' AND p.product_name LIKE ?1 AND c.status='A'",nativeQuery = true)
 List<Map<String, Object>> findByProductName(String productName);


}
