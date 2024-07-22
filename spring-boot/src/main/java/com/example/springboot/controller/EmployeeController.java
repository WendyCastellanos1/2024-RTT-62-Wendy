package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;

import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/employee/")    // the directory
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private OfficeDAO officeDAO;

    // listens on url: localhost:8080/employee/list
    @GetMapping("/list")
    public ModelAndView findAll() {

        ModelAndView response = new ModelAndView("/employee/list");
        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employeesKey", employees);

        return response;
    }

    // listens on url: localhost:8080/employee/{id}  ????
    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable Integer id) {

        ModelAndView response = new ModelAndView("/employee/detail");
        log.debug("The user wants the employee with id:  " +  id);

        Employee employee = employeeDAO.findById(id);
        response.addObject("employeeKey", employee);

        List<Customer> customers = employee.getCustomers();
        response.addObject("customersKey", customers);

        return response;
    }

    // listens on url: localhost:8080/employee/search
    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {

        ModelAndView response = new ModelAndView("/employee/search");
        log.debug("The user searched for the term: " + search);

        // Add the user input back to the model so that we can display the search term in the input field
        response.addObject("searchKey", search);

        List<Employee> employees = employeeDAO.findByFirstOrLastNameOrJobTitle(search);
        response.addObject("employeesKey", employees);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {

        // this method is setting up the view for rendering
        ModelAndView response = new ModelAndView("/employee/create");

        loadDropdowns(response);

        return response;
    }

    @GetMapping("/createSubmit")
    public  ModelAndView createSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {

        ModelAndView response = new ModelAndView();
        log.debug(form.toString());     // prints the form data to the console using the CreateEmployeeForm Bean form

        // we want to validate the email doesn't exist in the db, but also check if it's a create
        // when doing a manual check in the controller, we want this before the binding result.haErrrors check so that it will fall into that block of code
        // if this is a create:
        if(form.getId() == null) {
            Employee e = employeeDAO.findByEmailIgnoreCase(form.getEmail());

            if ( e != null){
                bindingResult.rejectValue("email", "email", "This email is already in use. Manual check.");
            }
        }

        //this is a pattern
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult); // error has occurred;, use on jsp page to show user the errors

            loadDropdowns(response);

            response.setViewName("employee/create");

            response.addObject("form", form);

            return response;

        } else {
            // log out the incoming variable that are in the CreateEmployerForm Bean
            log.debug(form.toString());

            // variable name
            Employee  employee = employeeDAO.findById(form.getId());
            if (employee == null){
                // this means it was not found in the db so we are going to consider this a create
                employee = new Employee();
            }
            employee.setEmail(form.getEmail());
            employee.setFirstName(form.getFirstName());
            employee.setLastName(form.getLastName());

            employee.setReportsTo(form.getReportsTo());

            //employee.setExtension(form.getExtension());       // add field to  the form
            employee.setExtension("x357");

            //employee.setJobTitle(form.getJobTitle());         // add field to the form
            employee.setJobTitle("SomeJob");

            employee.setVacationHours(form.getVacationHours());
            employee.setProfileImageUrl(form.getProfileImageUrl());

            // employee.setOfficeId(form.getOfficeId());        // won't work bc not nullable, etc.
            Office office = officeDAO.findById(form.getOfficeId());
            employee.setOffice(office);

            // when we save to the db, it will autoincrement to give us a new id
            //the new Id is available in the return from the save method.
            //basically returns the same object ...after its been inserted into the db
           employee = employeeDAO.save(employee); //want this bc has next Id number in it

            // this is a URL, NOT a view name
            // in some ways this is overriding the behavior of the setViewName to use a URL rather than a JSP file location
            //redirecting to the employee detail page, but usually you'd go to fully populated EDIT page, take emp id on url and use it to populate all the fields before rendering
            response.setViewName("redirect:/employee/" + employee.getId());

            return response;
        }
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam (required = false) Integer id) {

        // by setting required = false on the incoming parameter we allow
        ModelAndView response = new ModelAndView("/employee/create");

        loadDropdowns(response);

        // load the employee from the database and set the form bean with all the employee values
        // this is because the form bean is on the JSP page and we need to pre-populate the form with the employeee data
        if ( id != null) {
            // we only do this code if we found an emp in the db
            Employee employee = employeeDAO.findById(id);
            if (employee != null) {
                CreateEmployeeFormBean form = new CreateEmployeeFormBean();
                form.setId(employee.getId());
                form.setEmail(employee.getEmail());
                form.setFirstName(employee.getFirstName());
                form.setLastName(employee.getLastName());
                form.setReportsTo(employee.getReportsTo());
                form.setOfficeId(employee.getOffice().getId());
                // form.setExtension(employee.getExtension());
                // form.setJobTitle(employee.getJobTitle());
                // form.setVacationHours(employee.getVacationHours());

                response.addObject("form", form);
                }
        }

        return response;
    }

    private void loadDropdowns(ModelAndView response){
        // this list of employees is used in the Reports To dropdown to list all the employees
        List<Employee> reportsToEmployees = employeeDAO.findAll();
        response.addObject("employeesKey", reportsToEmployees);

        // add your office query to get all offices and add it to the model
        List<Office> offices = officeDAO.findAll();
        response.addObject("officesKey", offices);
    }
}
