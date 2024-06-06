package org.example;

import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Employee;
import org.example.database.dao.CustomerDAO;
import org.example.database.entity.Customer;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;
import java.util.Scanner;

public class FirstHibernateDemo {

    public static void main(String[] args) {

        // let's create a new customer in the database
        CustomerDAO customerDAO = new CustomerDAO();
        Customer newCustomer = new Customer();

        newCustomer.setCustomer_name("Belen");
        newCustomer.setContact_lastName("Salcedo");
        newCustomer.setContact_firstName("Betsy");
        newCustomer.setPhone("3614485566");
        newCustomer.setAddress_line1("101 North Shore Dr");
        newCustomer.setAddress_line2("Apt 5");
        newCustomer.setCity("Honolulu");
        newCustomer.setState("Hawaii");
        newCustomer.setPostal_code("77844");
        newCustomer.setCountry("United States");
        newCustomer.setSales_rep_employee_id(1);
        newCustomer.setCredit_limit(50000);

        customerDAO.insert(newCustomer);

        // find this customer now
        Customer myCustomer = new Customer();
        myCustomer = customerDAO.findById(5); // note: hard-coded ID - change

        System.out.println(myCustomer);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new last name ");

        myCustomer.setContact_lastName(scanner.nextLine());
        System.out.println("Enter the new first name ");

        myCustomer.setContact_firstName(scanner.nextLine());

        customerDAO.update(myCustomer);


        // let's create a new employee in the database
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee newEmployee = new Employee();

        newEmployee.setFirstname("Jimmy");
        newEmployee.setLastname("Zacara");
        newEmployee.setEmail("jimmyskater@email.com");
        newEmployee.setJobTitle("lawyer");
        newEmployee.setExtension("x85576");
        newEmployee.setOfficeId(3);
        newEmployee.setVacationHours(4);

        employeeDAO.insert(newEmployee);

//       List<Employee> employees = employeeDAO.findByFirstName("Leslie");
//
//        for ( Employee employee : employees ) {
//            //System.out.println(employee.getId() + " | " + employee.getFirstname() + " " + employee.getLastname() + " | "
//            //        + employee.getEmail() + " | " + employee.getJobTitle());
//            System.out.println(employee);  // by adding the @ToString from Lombok in the entity class, this is available
//        }

        // this emp exists, will return a record
        Employee employee1  = employeeDAO.findById(1060);
        System.out.println(employee1);

        // emp id NOT exists in db, will return NULL
        Employee employee2  = employeeDAO.findById(5);
        System.out.println(employee2);
    }
}
