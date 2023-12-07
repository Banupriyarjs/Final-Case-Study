package com.perscholas.twistntreats.database.dao;

import com.perscholas.twistntreats.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Long> {

    public User findByEmailIgnoreCase(String email);
}
