package com.example.springboot.database.dao;

import com.example.springboot.database.entity.*;
import org.springframework.data.jpa.repository.*;

public interface UserDAO extends JpaRepository<User, Long> {

    // select * from employee where lower(email) = lower(:email)
    User findByEmailIgnoreCase(String email);


}
