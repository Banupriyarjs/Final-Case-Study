package com.perscholas.twistntreats.database.dao;
import com.perscholas.twistntreats.database.entity.Category;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryDAOTest {

    @Autowired
    private CategoryDAO categoryDAO;

    @Test
    @Order(1)
    public void createCategoryTest() {

        //given
        Category category = new Category();
        category.setCategoryName("Test Smoothies");
        category.setCategoryDescription("Test Description");
        category.setCreatedBy(1);
        //category.setCreatedDate(date);
        category.setStatus("A");

        //when
        category = categoryDAO.save(category);

        //then
        Assertions.assertNotNull(category.getId());
        Assertions.assertEquals("Test Smoothies", category.getCategoryName());
        Assertions.assertEquals("Test Description", category.getCategoryDescription());
        Assertions.assertEquals(1, category.getCreatedBy());
        Assertions.assertEquals("A", category.getStatus());

    }

    @Test
    @Order(2)
    public void findCategoryTest() {
        String categoryName = "Test Smoothies";

        List<Category> categories = categoryDAO.findByCategoryName(categoryName);

        Assertions.assertEquals(1, categories.size());

        System.out.println(categories.size());

        Category category = categories.get(0);
        Assertions.assertNotNull(category.getId());
        Assertions.assertEquals("Test Smoothies", category.getCategoryName());
        Assertions.assertEquals("Test Description", category.getCategoryDescription());
        Assertions.assertEquals(1, category.getCreatedBy());
        Assertions.assertEquals("A", category.getStatus());

    }

    @Test
    @Order(3)
    public void deleteCategoryTest() {
        //search for the Category to disable

        String categoryName = "Test Smoothies";

        List<Category> categories = categoryDAO.findByCategoryName(categoryName);

        Assertions.assertEquals(1, categories.size());

        Category categoryList = categories.get(0);


        //Disabling the status of the category to 'D'
        int categoryId = categoryList.getId();

        int deleted = categoryDAO.deleteById(categoryId);


        //Testing to check whether the given category is disabled or not
        Assertions.assertEquals(1, deleted);

        Category category = categoryDAO.findById(categoryId);

        Assertions.assertNotNull(category.getId());
        Assertions.assertEquals("Test Smoothies", category.getCategoryName());
        Assertions.assertEquals("Test Description", category.getCategoryDescription());
        Assertions.assertEquals("D", category.getStatus());

    }

}
