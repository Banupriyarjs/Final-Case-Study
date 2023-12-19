package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

}
