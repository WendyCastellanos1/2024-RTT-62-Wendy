package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.OrderDetail;
import com.example.springboot.database.dao.OrderDetailDAO;

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
//@RequestMapping("/order-detail")    // ???? the directory?
public class OrderDetailController {

    @Autowired
    private OrderDetailDAO orderDetailDAO;






}
