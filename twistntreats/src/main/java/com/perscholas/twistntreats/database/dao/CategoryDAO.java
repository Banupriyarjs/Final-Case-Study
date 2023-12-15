package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDAO extends JpaRepository<Category,Long> {
    //To fetch Category by id
    public Category findById(Integer id);

    // To fetch all categories
    @Query("Select c from Category c")
    List<Category> findCategories();

}
