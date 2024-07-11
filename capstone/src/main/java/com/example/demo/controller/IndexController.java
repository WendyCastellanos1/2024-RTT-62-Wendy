package com.example.demo.controller;

import com.example.demo.database.dao.ProductDAO;
import com.example.demo.database.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller     // listens to a specific url
public class IndexController {

    @Autowired
    private ProductDAO productDao;

    @GetMapping("/")
    public ModelAndView index(@RequestParam Integer id) {
        // this function is for the home page of the website which is express as just a plain slash "/"
        ModelAndView response = new ModelAndView("index");

        Product product = productDao.findById(id);
        response.addObject("productKey", product);


        response.addObject("message", "Hello World!");

        return response;
    }
}
