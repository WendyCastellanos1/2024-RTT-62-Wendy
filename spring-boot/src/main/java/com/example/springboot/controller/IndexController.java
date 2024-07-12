package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
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

        // by default the logging level is set to info so the debug message will not be printed in the terminal
        log.debug("Debug level");
        log.info("Info level");
        log.warn("Warn level");
        log.error("Error level");
        // now, prohibited, forbidden    System.out.println("This is forbidden at all times)

       response.addObject("message", "We sell model cars, boats, and other items.");
       return response;
    }

    @GetMapping("/index/{id}")
    public ModelAndView indexPathVar(@PathVariable Integer id){

        ModelAndView response = new ModelAndView("index");
        Product product = productDAO.findById(id);
        response.addObject("productKey", product);
        return response;
    }

    @GetMapping("/about")
    public ModelAndView canBeAnyFunctionNameYouWant() {
        ModelAndView response = new ModelAndView("about");
        return response;
    }
    @GetMapping("/search")
    public ModelAndView search() {

        ModelAndView response = new ModelAndView("search");
        List<Product> products = productDAO.findAll();
        response.addObject("products", products);

        return response;
    }
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

    @GetMapping("/homework")
    public ModelAndView homework(@RequestParam(required=false) String topic) {  // required=false allows object to be null, still render web page without error, just w/o data

        ModelAndView response = new ModelAndView("homework");
        response.addObject("message",  topic);

        return response;
    }

}
