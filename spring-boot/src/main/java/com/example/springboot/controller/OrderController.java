package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDetailDAO;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Order;
import com.example.springboot.database.dao.OrderDAO;

import com.example.springboot.database.entity.OrderDetail;
import com.example.springboot.database.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/order/")    // directory
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private OrderDetailDAO orderDetailDAO;

    // listens on url: localhost:8080/order/list
    @GetMapping("/list")
    public ModelAndView listAll() {

        ModelAndView response = new ModelAndView("/order/list");
        List<Order> orders = orderDAO.findAll();
        response.addObject("ordersKey", orders);

        return response;
    }

    // listens on url: localhost:8080/order/{id}        for   order id
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {

        ModelAndView response = new ModelAndView("/order/detail");   // summary in this case
        log.debug("The user wants the order with id:  " +  id);

        Order order = orderDAO.findById(id);
        response.addObject("orderKey", order);

        List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(id);
        response.addObject("orderDetailsKey", orderDetails);

//        Product product = productDAO.findById(order.);
            
        return response;
    }

    // listens on url: localhost:8080/order/list-by-customer        ?????????
    // for when  customer's list...someone clicks on orders link to see orders list for that customer
    @GetMapping("/list-by-customer")
    public ModelAndView listByCustomerId(@RequestParam String id,
                                         @RequestParam(required=false) String name) {

        ModelAndView response = new ModelAndView("/order/list-by-customer");
        log.debug("The user wants the order(s) for customer id:  " +  id + " and customer name:  " + name);
        response.addObject("customerId", id);
        response.addObject("customerName", name);

        List<Order> orders = orderDAO.findByCustomerId(Integer.valueOf(id));
        response.addObject("ordersKey", orders);

        return response;
    }

    // listens on url: localhost:8080/order/search
    @GetMapping("/search")
    public ModelAndView searchByCustomerName(@RequestParam(required=false) String search) {

        ModelAndView response = new ModelAndView("/order/search");
        log.debug("The user wants the order for this customer name:  " +  search);

        List<Order> orders = orderDAO.findByCustomerName(search);
        response.addObject("ordersKey", orders);

        return response;
    }

    @GetMapping("/orderdetail")
    public ModelAndView orderDetail(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("/order/orderdetail");

        List<Map<String, Object>> orderDetails = orderDAO.getOrderDetails(orderId);
        response.addObject("orderDetailsKey", orderDetails);
        response.addObject("orderIdKey", orderId);

        return response;
    }
}
