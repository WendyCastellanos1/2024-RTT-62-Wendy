package com.example.springboot.controller;

import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.dao.CustomerDAO;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/customer/")    // ???? the directory?
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    // listens for url: localhost:8080/customer/list
    @GetMapping("/list")
    public ModelAndView list() {

        ModelAndView response = new ModelAndView("/customer/list");
        List<Customer> customers = customerDAO.findAll();
        response.addObject("customersToken", customers);

        return response;
    }

    // listens for url: localhost:8080/customer/detail
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {

        ModelAndView response = new ModelAndView("/customer/detail");
        Customer customer = customerDAO.findById(id);
        response.addObject("customerToken", customer);

        return response;
    }

    // listens for url: localhost:8080/customer/search
    @GetMapping("/search")
    public ModelAndView search(String userInput) {

        ModelAndView response = new ModelAndView("/customer/search");
        log.debug("The user searched for: " + userInput);
        response.addObject("searchToken", userInput);

        List<Customer> customers = customerDAO.findByCustomerName(userInput);
        response.addObject("customersToken", customers);

        return response;
    }
}

