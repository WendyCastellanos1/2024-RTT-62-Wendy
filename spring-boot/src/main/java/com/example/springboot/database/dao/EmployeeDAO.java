package com.example.springboot.database.dao;


import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    // this is a magic query in that .... spring data JPA is able to use the method name to generate the query
    Employee findById(Integer id);

    // this is a JPA query just like we did in the hibernate module
    @Query("select e from Employee e " +
            "where e.firstName like concat('%', :name, '%') " +
            " or e.lastName like concat('%', :name, '%') " +
            "or e.jobTitle like concat('%', :name, '%')")
    List<Employee> findByFirstOrLastNameOrJobTitle(String name);
}
