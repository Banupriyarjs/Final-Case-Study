package com.perscholas.twistntreatsproject.service;

import com.perscholas.twistntreatsproject.database.dao.UserDAO;
import com.perscholas.twistntreatsproject.database.entity.User;
import com.perscholas.twistntreatsproject.formbean.RegisterUserFormBean;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDAO userDa0;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createNewUser(RegisterUserFormBean form)
    {
        User user= new User();

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setAddress(form.getAddress());
        user.setAreaCode(form.getAreaCode());
        user.setCity(form.getCity());
        user.setPhone(form.getPhone());
        user.setCreatedDate(new Date());
        user.setEmail(form.getEmail().toLowerCase());

        String encodedPwd=passwordEncoder.encode(form.getPassword());
        log.debug("Encoded password: "+encodedPwd);
        user.setPassword(encodedPwd);

      // System.out.println(user.getId()+"ID");
        return userDa0.save(user);

    }

}
