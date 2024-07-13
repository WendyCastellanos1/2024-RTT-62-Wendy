package com.example.springboot.controller;

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
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    // listens on url: localhost:8080/product/list
    @GetMapping("/list")
    public ModelAndView list() {

        ModelAndView response = new ModelAndView("/product/list");
        List<Product> products = productDAO.findAll();
        response.addObject("productsKey", products);

        return response;
    }

    // listens on url: localhost:8080/product/{id}
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id){

        ModelAndView response = new ModelAndView("/product/detail");
        Product product = productDAO.findById(id);
        response.addObject("productKey", product);

        return response;
    }

    // listens on url: localhost:8080/product/search
    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required=false) String search) {

        ModelAndView response = new ModelAndView("/product/search");
        log.debug("The user searched for the term: " + search);

        // Add the user input back to the model so that we can display the search term in the input field
        response.addObject("search", search);

        List<Product> products = productDAO.findByNameOrCode(search);
        response.addObject("productsKey", products);

        return response;
    }
}
