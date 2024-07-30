package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDetailDAO;
import com.example.springboot.database.entity.OrderDetail;
import com.example.springboot.database.entity.Product;
import com.example.springboot.database.dao.ProductDAO;

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
@RequestMapping("/order-detail")    // the directory
public class OrderDetailController {

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    // listens on url: localhost:8080/order/list
    @GetMapping("/list")
    public ModelAndView list() {

        ModelAndView response = new ModelAndView("order-detail/list");
        List<OrderDetail> orderDetails = orderDetailDAO.findAll();
        response.addObject("orderDetailsKey", orderDetails);

        return response;
    }

    // listens on url: localhost:8080/order-detail/{id}        for   order detail id
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {

        ModelAndView response = new ModelAndView("order/detail");   //
        log.debug("The user wants the orderDetail with order detail id:  " +  id);

        OrderDetail orderDetail = orderDetailDAO.findById(id);
        response.addObject("orderDetailKey", orderDetail);

        return response;
    }

    // listens on url: localhost:8080/order-detail/list-by-order?id=
    // for when  customer's list...someone clicks on orders link to see orders list for that customer
    @GetMapping("/list-by-order")
    public ModelAndView listByOrderId(@RequestParam Integer id) {

        ModelAndView response = new ModelAndView("order-detail/list-by-order");
        log.debug("The user wants the order detail row(s) for order id:  " +  id);
        // response.addObject("orderIdKey", Integer.valueOf(orderId));
        response.addObject("orderIdKey", id);

        List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(id);
        response.addObject("orderDetailsKey", orderDetails);



        return response;
    }

}
