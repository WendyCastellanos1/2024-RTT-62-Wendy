package com.example.springboot.controller;

import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.entity.Order;
import com.example.springboot.form.CreateCustomerFormBean;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.data.domain.Page;


import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/customer/")   // the directory?
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    // listens for url: localhost:8080/customer/list
    @GetMapping("/list")
    public ModelAndView list() {

        ModelAndView response = new ModelAndView("/customer/list");
        List<Customer> customers = customerDAO.findAll();
        response.addObject("customersKey", customers);

        return response;
    }

    // listens for url: localhost:8080/customer/{id}
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {

        ModelAndView response = new ModelAndView("/customer/detail");
        Customer customer = customerDAO.findById(id);
        response.addObject("customerKey", customer);

        List<Order> orders = customer.getOrders();
        response.addObject("ordersKey", orders);

        return response;
    }

    // listens for url: localhost:8080/customer/search
    @GetMapping("/search")
    public ModelAndView searchByCustomerName(String search) {

        ModelAndView response = new ModelAndView("/customer/search");
        log.debug("The user searched for: " + search);
        response.addObject("searchKey", search);

        List<Customer> customers = customerDAO.findByCustomerName(search);
        response.addObject("customersKey", customers);

        return response;
    }

    // listens on url: localhost:8080/customer/list-by-employee
    // gets employee's list of customers...someone clicks on customers link to see customers list for that employee
    @GetMapping("/list-by-employee")
    public ModelAndView listByEmployeeId(@RequestParam String id,
                                         @RequestParam(required = false) String name) {

        ModelAndView response = new ModelAndView("/customer/list-by-employee");
        log.debug("The user wants the customer(s) for employee id:  " + id + " and employee name:  " + name);
        response.addObject("employeeId", id);
        response.addObject("employeeName", name);

        List<Customer> customers = customerDAO.findByEmployeeId(Integer.valueOf(id));
        response.addObject("customersKey", customers);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {

        // this method is setting up the view for rendering
        ModelAndView response = new ModelAndView("/customer/create");

        // this list of employees is used in the dropdown to list all the employees
        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employeesKey", employees);  // TODO: filter for sales reps?, order by name asc

        return response;
    }

    @GetMapping("/createSubmit")

    public ModelAndView createSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) {

        ModelAndView response = new ModelAndView();
        log.debug(form.toString());     // prints the form data to the console using the CreateCustomerFormBean form



        //this is a pattern
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult); // error has occurred;, use on jsp page to show user the errors

            // this list of employees is used in the Reports To dropdown to list all the employees
            List<Employee> reportsToEmployees = employeeDAO.findAll();
            response.addObject("employeesKey", reportsToEmployees);

            response.setViewName("customer/create");

            response.addObject("form", form);

            return response;

        } else {
            // log the incoming variables that are in the CreateCustomerForm Bean
            log.debug(form.toString());

            // variable name
            Customer customer = customerDAO.findById(form.getId());
            if (customer == null){
                // this means it was not found in the db so we are going to consider this a create
                customer = new Customer();
            }

            // get customer data from form to load up customer object
            customer.setCustomerName(form.getCustomerName());
            customer.setContactFirstName(form.getContactFirstName());
            customer.setContactLastName(form.getContactLastName());
            customer.setPhone(form.getPhone());
            customer.setAddressLine1(form.getAddressLine1());
            customer.setAddressLine2(form.getAddressLine2());
            customer.setCity(form.getCity());
            customer.setState(form.getState());
            customer.setPostalCode(form.getPostalCode());
            customer.setCountry(form.getCountry());
            customer.setCreditLimit(form.getCreditLimit());
            customer.setSalesRepEmployeeId(form.getSalesRepEmployeeId());

            Employee employee = employeeDAO.findById(form.getSalesRepEmployeeId());
            customer.setEmployee(employee);

            customer = customerDAO.save(customer);  // want this bc has next Id number in it

            // this is a URL, NOT a view name
            // in some ways this is overriding the behavior of the setViewName to use a URL rather than a JSP file location
            // redirecting to the customer detail page, but usually you'd go to fully populated EDIT page, take emp id on url and use it to populate all the fields before rendering
            response.setViewName("redirect:/customer/" + customer.getId());

            return response;
        }
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam (required = false) Integer id) {

        // by setting required = false on the incoming parameter we allow
        ModelAndView response = new ModelAndView("/customer/create");

        // re-duplicated code here, could be factored into a method
        // this list of employees to be used in the Sale Rep Employee Id dropdown to list all the employees
        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employeesKey", employees);

        // load the customer from the database and set the form bean with all the customer values
        // this is because the form bean is on the JSP page and we need to pre-populate the form with the customer data
        if ( id != null) {
            // we only do this code if we found an emp in the db
            Customer customer = customerDAO.findById(id);

            if (customer != null) {

                CreateCustomerFormBean form = new CreateCustomerFormBean();
                form.setId(customer.getId());  // **********************************************************
                form.setCustomerName(customer.getCustomerName());
                form.setContactFirstName(customer.getContactFirstName());
                form.setContactLastName(customer.getContactLastName());
                form.setPhone(customer.getPhone());
                form.setAddressLine1(customer.getAddressLine1());
                form.setAddressLine2(customer.getAddressLine2());
                form.setCity(customer.getCity());
                form.setState(customer.getState());
                form.setPostalCode(customer.getPostalCode());
                form.setCountry(customer.getCountry());
                form.setCreditLimit(customer.getCreditLimit());
                form.setSalesRepEmployeeId(customer.getSalesRepEmployeeId());
                response.addObject("form", form);
            }
        }else{
            response.addObject("message", "The employee was not found in the database.");
        }

        return response;
    }
}