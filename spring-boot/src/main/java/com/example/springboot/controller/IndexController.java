package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/")
    public ModelAndView index(@RequestParam(required=false) Integer id) {  //required=false allows object to be null, still render web page without error, just w/o data
        // this function is for the home page of the website which is express as just a plain slash "/"
       ModelAndView response = new ModelAndView("index");

       Product product = productDAO.findById(id);  // hard-coded product id
       response.addObject("productKey", product);
       response.addObject("message", "Hello World");
       return response;
    }

    @GetMapping("/index/{id}")
    public ModelAndView indexPathVar(@PathVariable Integer id){

        ModelAndView response = new ModelAndView("index");
        Product product = productDAO.findById(id);
        response.addObject("productKey", product);
        return response;
    }

    @GetMapping("/page-url")
    public ModelAndView canBeAnyFunctionNameYouWant() {
        ModelAndView response = new ModelAndView("another-page");
        return response;
    }
}
