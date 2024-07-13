package com.example.springboot.controller;

import com.example.springboot.database.entity.Order;
import com.example.springboot.database.dao.OrderDAO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/order")    // ????
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    // listens on url: localhost:8080/order/list
    @GetMapping("/order/list")
    public ModelAndView list() {

        ModelAndView response = new ModelAndView("list");
        List<Order> orders = orderDAO.findAll();
        response.addObject("ordersToken", orders);

        return response;
    }

    // listens on url: localhost:8080/order/detail
    @GetMapping("/order/{id}")
    public ModelAndView detail(@PathVariable Integer id) {

        ModelAndView response = new ModelAndView("detail");
        log.debug("The user wants the order with id:  " +  id);

        Order order = orderDAO.findById(id);
        response.addObject("orderToken", order);

        return response;
    }

    // listens on url: localhost:8080/order/search
    @GetMapping("/order/search")
    public ModelAndView search(@RequestParam(required=false) String userInput) {

        ModelAndView response = new ModelAndView("search");
        log.debug("The user wants the order with this customer id:  " +  userInput);

        List<Order> orders = orderDAO.findByCustomerName(userInput);
        response.addObject("ordersToken", orders);

        return response;
    }
}
