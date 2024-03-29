package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.Category;
import com.perscholas.twistntreats.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface ProductDAO extends JpaRepository<Product, Long> {

    public Product findById(Integer id);

    List<Product> findByCategoryId(Integer categoryId);

    @Query("Select p from Product p WHERE p.status='A'")
    List<Product> findProducts();

    @Query("Select p from Product p WHERE p.status='A' AND p.productName LIKE :productName")
    List<Product> findProductSuggestions(String productName);
    //To view Product List
    @Query(value = "SELECT p.id 'Id' ,p.product_name 'productName',p.product_description 'productDescription',\n" +
            "            p.price  'price',p.category_id 'categoryId',p.product_url 'productUrl',\n" +
            "            p.created_by 'createdBy', p.status 'status'\n" +
            "            FROM  products p  \n" +
            "            INNER JOIN categories c ON c.id=p.category_id\n" +
            "            WHERE p.status='A' AND  product_name LIKE :productName AND c.status='A' ORDER BY c.id,p.product_name", nativeQuery = true)
    List<Map<String, Object>> findProductsForCategory(@Param("productName") String productName);

    @Query(value = "SELECT p.id 'productId' ,p.product_name 'productName',p.product_description 'productDescription',\n" +
            "p.price  'price',p.product_url 'productUrl',c.id 'categoryId',\n" +
            "p.created_by 'createdBy', p.status 'status',c.category_name 'categoryName'\n" +
            "FROM  products p  \n" +
            "INNER JOIN categories c ON c.id=p.category_id\n" +
            "WHERE p.status='A' AND p.product_name LIKE ?1 AND c.status='A' ORDER BY c.id,p.product_name ASC", nativeQuery = true)
    List<Map<String, Object>> findByProductName(String productName);

    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    @Modifying
    @Query("UPDATE Product p SET p.status='D' WHERE p.id=?1 ")
    int deleteById(Integer id);
}
