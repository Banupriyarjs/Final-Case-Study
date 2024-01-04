package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @ParameterizedTest
    @Order(1)
    @CsvSource({
            "BANU@GMAIL.COM",
            "b@GMAIL.com",
            "aRjUn@gmail.com",
            "Test@gMaiL.COM"
    })
    public void findByEmailIgnoreCaseTest(String username) {

        int count = 0;
        //Inputting username in lower and upper cases to test the method.
        User user = userDAO.findByEmailIgnoreCase(username);


        //If the user is not null then we are setting the count to 1
        if (user != null)
            count = 1;


        Assertions.assertEquals(1, count);


    }

    @Test
    @Order(2)
    public void findByIdTest() {
        //Checking the user data for the userId 2 in the database
        Integer userId = 2;

        User user = userDAO.findById(userId);

        Assertions.assertEquals(2, user.getId());
        Assertions.assertEquals("test@gmail.com", user.getEmail());
        Assertions.assertEquals("Test First", user.getFirstName());
        Assertions.assertEquals("Test Last", user.getLastName());
        Assertions.assertEquals("Test Address", user.getAddress());
        Assertions.assertEquals("10001", user.getAreaCode());
        Assertions.assertEquals("Test City", user.getCity());
        Assertions.assertEquals("111-111-1111", user.getPhone());
    }
}
