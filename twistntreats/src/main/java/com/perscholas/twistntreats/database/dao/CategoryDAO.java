package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface CategoryDAO extends JpaRepository<Category,Long> {
    //To fetch Category by id
    public Category findById(Integer id);

    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    @Modifying
    @Query("UPDATE Category c SET c.status='D' WHERE c.id=?1 ")
    int deleteById(Integer id);
    @Query("SELECT c FROM Category c WHERE c.status='A' AND c.categoryName LIKE:categoryName")
    List<Category>  findByCategoryName(String categoryName);

    // To fetch all categories
    @Query("Select c from Category c WHERE status='A'")
    List<Category> findCategories();

    //To view Product List
    @Query(value ="  SELECT c.id 'Id',c.category_name 'categoryName' \n" +
            "            FROM  categories c INNER JOIN products p on p.category_id=c.id \n" +
            "            WHERE c.status='A' AND p.status='A' AND p.product_name LIKE '%lemon%' \n" +
            "            ORDER BY c.id" ,nativeQuery = true)
    List<Map<String, Object>> findCategoryForProduct( String productName);

    @Query(value = "SELECT c.id 'categoryId',category_name 'categoryName',p.id 'productId', p.product_name 'productName',p.product_url 'productUrl'" +
            "FROM  categories c INNER JOIN products p on p.category_id=c.id " +
            "WHERE c.status='A' AND p.status='A' " +
            "ORDER BY c.id",nativeQuery = true)
    List<Map<String, Object>> findProductDetails();
}
