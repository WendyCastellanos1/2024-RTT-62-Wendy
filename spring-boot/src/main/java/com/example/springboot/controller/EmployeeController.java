package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.entity.Employee;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/search-employees")
    public ModelAndView search(@RequestParam(required=false) String search) {

        ModelAndView response = new ModelAndView("search-employees");
        log.debug("The user searched for the term: " + search);

        // Add the user input back to the model so that we can display the search term in the input field
        response.addObject("search", search);

        List<Employee> employees = employeeDAO.findByFirstOrLastNameOrJobTitle(search);
        response.addObject("employees", employees);

        return response;
    }

    @GetMapping("/employees")
    public ModelAndView employees() {

        ModelAndView response = new ModelAndView("employees");
        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employees", employees);

        return response;

    }

    @GetMapping("/employee")
    public ModelAndView search(@RequestParam(required=false) Integer id) {

        ModelAndView response = new ModelAndView("employee");
        log.debug("The user wants the employee with id:  " +  id);

        Employee employee = employeeDAO.findById(id);
        response.addObject("employeeKey", employee);

        return response;
    }
}
