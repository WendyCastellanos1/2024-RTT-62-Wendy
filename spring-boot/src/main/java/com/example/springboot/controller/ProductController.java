package com.example.springboot.controller;

import com.example.springboot.database.entity.Product;
import com.example.springboot.database.dao.ProductDAO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/products")
    public ModelAndView products() {

        ModelAndView response = new ModelAndView("products");
        List<Product> products = productDAO.findAll();
        // Page<Product> products = (Page<Product>) productDAO.findAll();
        response.addObject("products", products);

        return response;
    }

    @GetMapping("/product/{id}")
    public ModelAndView productPathVar(@PathVariable Integer id){

        ModelAndView response = new ModelAndView("product");
        Product product = productDAO.findById(id);
        response.addObject("productKey", product);
        return response;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required=false) String search) {

        ModelAndView response = new ModelAndView("search");
        log.debug("The user searched for the term: " + search);

        // Add the user input back to the model so that we can display the search term in the input field
        response.addObject("search", search);

        List<Product> products = productDAO.findByNameOrCode(search);
        response.addObject("products", products);

        return response;
    }

}
