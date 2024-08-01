package com.example.springboot.service;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component  // or @Service  means this component can be auto-wired anywhere bc of this annotation
public class EmployeeService {

    @Autowired                  // auto wired requires @Component
    private EmployeeDAO employeeDAO;

    @Autowired
    private OfficeDAO officeDAO;

    public Employee createEmployee(CreateEmployeeFormBean form) {
        log.debug(form.toString());

        // variable name
        Employee employee = employeeDAO.findById(form.getId());
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
        employee.setProfileImageUrl("/public/images/"+ form.getFile().getOriginalFilename());

        // employee.setOfficeId(form.getOfficeId());        // won't work bc not nullable, etc.
        Office office = officeDAO.findById(form.getOfficeId());
        employee.setOffice(office);

        // when we save to the db, it will autoincrement to give us a new id
        //the new Id is available in the return from the save method.
        //basically returns the same object ...after its been inserted into the db
        employee = employeeDAO.save(employee); //want this bc has next Id number in it

        return employee;
    }
}
