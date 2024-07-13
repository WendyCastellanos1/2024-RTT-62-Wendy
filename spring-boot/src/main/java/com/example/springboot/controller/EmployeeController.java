package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.entity.Employee;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/employee/")    // ???? the directory?
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    // listens on url: localhost:8080/employee/list
    @GetMapping("/list")
    public ModelAndView list() {

        ModelAndView response = new ModelAndView("/employee/list");
        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employeesToken", employees);

        return response;
    }

    // listens on url: localhost:8080/employee/detail
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {

        ModelAndView response = new ModelAndView("/employee/detail");
        log.debug("The user wants the employee with id:  " +  id);

        Employee employee = employeeDAO.findById(id);
        response.addObject("employeeToken", employee);

        return response;
    }

    // listens on url: localhost:8080/employee/search
    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required=false) String userInput) {

        ModelAndView response = new ModelAndView("/employee/search");
        log.debug("The user searched for the term: " + userInput);

        // Add the user input back to the model so that we can display the search term in the input field
        response.addObject("searchToken", userInput);

        List<Employee> employees = employeeDAO.findByFirstOrLastNameOrJobTitle(userInput);
        response.addObject("employeesToken", employees);

        return response;
    }
}