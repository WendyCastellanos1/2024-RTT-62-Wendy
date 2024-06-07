package org.example.database.dao;

import org.example.database.entity.Customer;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomerDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void insert(Customer customer) {
        // prepare the hibernate session for use
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(customer);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public void update(Customer customer) {
        // prepare the hibernate session for use
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.merge(customer);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public void delete(Customer customer) {
        // prepare the hibernate session for use
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.delete(customer);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public Customer findById(Integer id) {

        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        String hql = "select c from Customer c where c.id = :id";

        // this typed query is how hibernate knows what kind of object to fill up with the query results
        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);

        // this is similar to the prepared statement. we are going to set the value in the query:id
        // to the value passed into the function
        query.setParameter("id", id);

        // will toggle on and off as needed for debug comfort
        // when we know we are getting 0 or more records we use getResultList
        try {
            Customer result = query.getSingleResult();
            return result;
        }catch (Exception e){ // hibernate returns null if no record found
            return null;
        }finally {
            // finally we close the hibernate session so it can release the resources its holding
            //specifically the connection pool and close the transaction
            session.close();
        }
    }

    public List<Customer>  findByCustomerName(String customerName){

        Session session = factory.openSession();

        String hql = "select c from Customer c where c.customer_name = :customerName";
        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("customerName", customerName);

        List<Customer> result = query.getResultList();
        session.close();
        return result;
    }

    public List<Customer> findByContactFirstName(String contact_firstName){

        Session session = factory.openSession();

        String hql = "select c from Customer c where c.contact_firstName = :contact_firstName";
        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("contact_firstName", contact_firstName);

        List<Customer> result = query.getResultList();
        session.close();
        return result;
    }
}
