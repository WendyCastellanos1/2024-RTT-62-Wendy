package com.example.springboot.controller;

import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.dao.CustomerDAO;

import com.example.springboot.database.entity.Order;
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
        response.addObject("customersKey", customers);

        return response;
    }

    // listens for url: localhost:8080/customer/{id}
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {

        ModelAndView response = new ModelAndView("/customer/detail");
        Customer customer = customerDAO.findById(id);
        response.addObject("customerKey", customer);

        List<Order> orders = customer.getOrders();
        response.addObject("ordersKey", orders);

        return response;
    }

    // listens for url: localhost:8080/customer/search
    @GetMapping("/search")
    public ModelAndView searchByCustomerName(String search) {

        ModelAndView response = new ModelAndView("/customer/search");
        log.debug("The user searched for: " + search);
        response.addObject("searchKey", search);

        List<Customer> customers = customerDAO.findByCustomerName(search);
        response.addObject("customersKey", customers);

        return response;
    }

    // listens on url: localhost:8080/customer/list-by-employee
    // gets employee's list of customers...someone clicks on customers link to see customers list for that employee
    @GetMapping("/list-by-employee")
    public ModelAndView listByEmployeeId(@RequestParam String id,
                                         @RequestParam(required=false) String name) {

        ModelAndView response = new ModelAndView("/customer/list-by-employee");
        log.debug("The user wants the customer(s) for employee id:  " +  id + " and employee name:  " + name);
        response.addObject("employeeId", id);
        response.addObject("employeeName", name);

        List<Customer> customers = customerDAO.findByEmployeeId(Integer.valueOf(id));
        response.addObject("customersKey", customers);

        return response;
    }

}

