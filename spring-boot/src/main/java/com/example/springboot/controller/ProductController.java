package com.example.springboot.controller;

import com.example.springboot.database.entity.Product;
import com.example.springboot.database.dao.ProductDAO;

import com.example.springboot.form.CreateProductFormBean;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
    public ModelAndView listAll() {

        ModelAndView response = new ModelAndView("/product/list");
        List<Product> products = productDAO.findAll();
        response.addObject("productsKey", products);

        return response;
    }

    // listens on url: localhost:8080/product/{id}
    @GetMapping("/{id}")
    public ModelAndView showDetail(@PathVariable Integer id){

        ModelAndView response = new ModelAndView("/product/detail");
        Product product = productDAO.findById(id);
        response.addObject("productKey", product);

        return response;
    }

    // listens on url: localhost:8080/product/search
    @GetMapping("/search")
    public ModelAndView searchByNameorCode(@RequestParam(required=false) String search) {

        ModelAndView response = new ModelAndView("/product/search");
        log.debug("The user searched for the term: " + search);

        // Add the user input back to the model so that we can display the search term in the input field
        response.addObject("search", search);

        List<Product> products = productDAO.findByNameOrCode(search);
        response.addObject("productsKey", products);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {

        // this method is setting up the view for rendering
        ModelAndView response = new ModelAndView("/product/create");

        return response;
    }

    @GetMapping("/createSubmit")

    public ModelAndView createSubmit(@Valid CreateProductFormBean form, BindingResult bindingResult) {

        ModelAndView response = new ModelAndView();
        log.debug(form.toString());     // prints the form data to the console using the CreateCustomerFormBean form

        //this is a pattern
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult); // error has occurred;, use on jsp page to show user the errors

            response.setViewName("product/create");

            response.addObject("form", form);

            return response;

        } else {
            // log the incoming variables that are in the CreateProductFormBean
            log.debug(form.toString());

            // variable name
            Product product = productDAO.findById(form.getId());

            if (product == null) {
                // this means it was not found in the db so we are going to consider this a create
                product = new Product();
            }

            // get product data from form to load up product object
            product.setProductName(form.getProductName());
            product.setProductCode(form.getProductCode());
            product.setProductDescription(form.getProductDescription());
            product.setBuyPrice(form.getBuyPrice());
            product.setMsrp(form.getMsrp());
            product.setProductLineId(form.getProductLineId());
            product.setProductScale(form.getProductScale());
            product.setProductVendor(form.getProductVendor());
            product.setQuantityInStock(form.getQuantityInStock());

            product = productDAO.save(product);     // want this bc it has the next Id number in it

            // this is a URL, NOT a view name
            // in some ways this is overriding the behavior of the setViewName to use a URL rather than a JSP file location
            //redirecting to the product detail page, but usually you'd go to fully populated EDIT page, take emp id on url and use it to populate all the fields before rendering
            response.setViewName("redirect:/product/" + product.getId());

            return response;
        }
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam (required = false) Integer id) {

        // by setting required = false on the incoming parameter we allow
        ModelAndView response = new ModelAndView("/product/create");

        // load the product from the database and set the form bean with all the product values
        // this is because the form bean is on the JSP page and we need to pre-populate the form with the product data
        if ( id != null) {
            // we only do this code if we found a product in the db
            Product product = productDAO.findById(id);

            if (product != null) {
                CreateProductFormBean form = new CreateProductFormBean();

                form.setId(product.getId());  // **********************************************************
                form.setProductCode(product.getProductCode());
                form.setProductDescription(product.getProductDescription());
                form.setProductName(product.getProductName());
                form.setBuyPrice(product.getBuyPrice());
                form.setMsrp(product.getMsrp());
                form.setProductLineId(product.getProductLineId());
                form.setProductVendor(product.getProductVendor());
                form.setProductScale(product.getProductScale());
                form.setQuantityInStock((product.getQuantityInStock()));

                response.addObject("form", form);
            }
        }else{
            response.addObject("messageKey", "The product was not found in the database.");
        }

        return response;
    }

}
