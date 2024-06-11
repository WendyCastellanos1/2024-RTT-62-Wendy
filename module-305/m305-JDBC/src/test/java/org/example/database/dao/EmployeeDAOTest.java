package org.example.database.dao;

import java.util.List;
import org.example.database.entity.Employee;
import org.example.database.dao.EmployeeDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EmployeeDAOTest {

    // for  testing public Employee findById(Integer id) {
    private static EmployeeDAO employeeDAO = new EmployeeDAO();

    // know this can be done, when appropriate
    @ParameterizedTest
    @CsvSource({
            "Leslie",
            "Tom",
    })

    // know this can be done, when appropriate; the value we're looking for, and the NUMBER of them we expect back
    @ParameterizedTest
    @CsvSource({
            "Leslie, 2",
            "Tom, 1",
    })

    // know this can be done, when appropriate; the value we're looking for, and the NUMBER of them we expect back
    @ParameterizedTest
    @CsvSource({
            "Leslie, true",
            "Tom, false",
    })

    @BeforeAll
    public static void beforeAll() {

//        // create employee
//        Employee employee = new Employee();
//
//        // fill up employee
//
//        // insert a record to use for the test
//        employeeDAO.insert(employee);

    }
    @AfterAll
    public static void afterAll() {

        // delete the records I inserted by testing
        List<Employee> employees = employeeDAO.findByFirstName("DragonLadyCreature");
        for (Employee employee : employees) {
            employeeDAO.delete(employee);
        }
    }

    @Test
    public void findByIdTest() {

        // given
        Integer userid = 1088; //TODO change the number

        // when
        Employee employee = employeeDAO.findById(userid);

        // then
        Assertions.assertNotNull(employee);
        Assertions.assertEquals(userid, employee.getId());
        Assertions.assertEquals("Julie", employee.getFirstname());
        Assertions.assertEquals("Firelli", employee.getLastname());
        Assertions.assertEquals("Sales Rep", employee.getJobTitle());
    }

    @Test
    public void findByInvalidIdTest() {

        //given
        Integer userid = 105033;

        // when
        Employee employee = employeeDAO.findById(userid);

        //then
        Assertions.assertNull(employee);
    }

    public void findByFirstName() {

        // given
        String firstName = "Julie";

        // when
        List<Employee> employees = employeeDAO.findByFirstName(firstName);

        // then
        Assertions.assertNotNull(employees);
        Assertions.assertTrue(employees.size()>0 );
        for ( Employee e: employees ) {
            Assertions.assertEquals(firstName, e.getFirstname());
        }
    }
    public void findByInvalidFirstName(){

        // given
        String firstName = "Dragonladycreature";

        // when
        List<Employee> employees = employeeDAO.findByFirstName(firstName);

        // then
        Assertions.assertNotNull(employees);
        Assertions.assertTrue(employees.size() > 0);
    }

    @Test   //maybe too much for a *single* test, but this shows things we COULD do
    public void createNewEmployee(){

        //given
        Employee given = new Employee();
        given.setOfficeId(3);
        given.setLastname("ElApellido");
        given.setFirstname("TestEmployee");
        given.setExtension("x3333");
        given.setEmail("test@test.com");
        given.setReportsTo(1143);
        given.setJobTitle("Pro Surfer");
        given.setVacationHours(44);
        given.setProfileImageUrl("/myFolder");

        // when
        employeeDAO.insert(given); // after this, *given* now has an id

        // then
        Employee actual = employeeDAO.findById(given.getId()); // get the *actual* from the db via id
        Assertions.assertEquals(given.getFirstname(), actual.getFirstname());
        Assertions.assertEquals(given.getLastname(), actual.getLastname());
        // .... add all the rest of the assertions here to validate the object is the same

        //now let's delete the record from the database
        employeeDAO.delete(given);
        // verify it's gone from db
        Employee delete = employeeDAO.findById((given.getId()));

    }
}
