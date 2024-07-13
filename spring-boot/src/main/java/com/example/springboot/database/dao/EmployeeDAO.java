package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    // get ONE employee....by id    (this is a magic query in that .... spring data JPA is able to use the method name to generate the query)
    Employee findById(Integer id);

    // get LIST of employees... by first name, last name, or job title  (this is a JPA query just like we did in the Hibernate module)
    @Query("select e from Employee e " +
            "where e.firstName like concat('%', :name, '%') " +
            " or e.lastName like concat('%', :name, '%') " +
            "or e.jobTitle like concat('%', :name, '%')")
    List<Employee> findByFirstOrLastNameOrJobTitle(String name);
}
