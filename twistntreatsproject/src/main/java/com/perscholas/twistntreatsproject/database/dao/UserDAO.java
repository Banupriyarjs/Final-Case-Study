package com.perscholas.twistntreatsproject.database.dao;

import com.perscholas.twistntreatsproject.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {

   public User findById(Integer id);
    public User findByEmailIgnoreCase(String email);
}
