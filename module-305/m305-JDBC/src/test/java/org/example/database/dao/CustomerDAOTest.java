package org.example.database.dao;

import org.example.database.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class CustomerDAOTest {

    // for  testing public Customer findById(Integer id) {
    private static CustomerDAO customerDAO = new CustomerDAO();

    @AfterAll
    @BeforeAll
    public static void beforeAll(){
    // default mode  does .... ? static...but Eric turns it off
        //we could write some code to delete any customer from the db that has the name "Test Customer" as the name

        // if we were doing an old-school jdbc connection, we could create an actual connection to db here
        //so that all the methods in the test case have a db conn  they could use.

        //in AfterAll , close the db conn and release the resources

    }

    @Test
    public void findByIdTest(){
        // given
        Integer userid = 103;

        // when
        Customer customer = customerDAO.findById(userid);

        // then
        Assertions.assertNotNull(customer);
        Assertions.assertEquals(userid, customer.getId());
        Assertions.assertEquals("Atelier graphique", customer.getCustomerName());
        Assertions.assertEquals("asdf",  customer.getContact_firstName());
        Assertions.assertEquals("asdf", customer.getContact_lastName());
    }
    @Test
    public void findByInvalidIdTest(){

        //given
        Integer userid = 103033;

        // when
        Customer customer = customerDAO.findById(userid);

        //then
        Assertions.assertNull(customer);
    }
    @Test
    public void createNewCustomer(){
        //given
        Customer given = new Customer();

        given.setCustomer_name("Test Customer");
        given.setContact_firstName("Firstname");
        given.setContact_lastName("Lastname");
        given.setAddress_line1("address 1");
        given.setCity("swomwhere");
        given.setCountry("Sweden");
        given.setPhone("1234567894");

        // when
        customerDAO.insert(given);

        // then
        Customer actual = customerDAO.findById(given.getId());
        Assertions.assertEquals(given.getCustomerName(), actual.getCustomerName());

        //@AfterAll would normall delete whoe db and re-create before @BeforeAll

    }
}
