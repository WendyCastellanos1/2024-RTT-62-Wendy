package org.example.database.dao;

import org.example.database.entity.Employee;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    //2010 start of this design pattern

    public Employee findById(Integer id) {

        Session session = factory.openSession();

        // JPA Query
        String hql = "select e from Employee e where e.id = :id";

        // how hibernate knows what kind of object to fill up with the query results
        TypedQuery<Employee> query = session.createQuery(hql, Employee.class);

        // this is similar to the prepared statement. we are going to set the value in the query:id
        // to the value passed into the function
        query.setParameter("id", id);

        // w// turn on and off as needed for debug preference
        // when we know we are getting 0 or more records we use getResultList
        try {
            Employee result = query.getSingleResult();
            return result;
        }catch (Exception e){ // hibernate returns null if no record found
            return null;
        }finally {
            // finally we close the hibernate session so it can release the resources its holding
            //specifically the connection pool and close the transaction
            session.close();
        }
    }

    public List<Employee> findByFirstName(String firstName) {

       Session session = factory.openSession();

       // JPA Query - the syntax is slightly different than regular SQL
        //this is where code goes to execute the query
        String hql = "select e from Employee e where e.firstname = :firstName";

        // this typed query is how hibernate knows what kind of object of fill up with the query results
        TypedQuery<Employee> query = session.createQuery(hql, Employee.class);

        // this is similar to the prepared statement. we are going to set the value in the query:firstname
        // to the value passed into the function
        query.setParameter("firstName", firstName);

        // will toggle on and off as needed for debug comfort
        // when we know we are getting 0 or more records we use getResultList
        List<Employee> result = query.getResultList();

        // finally, we lose the hibernate session so it can release the resources its holding
        // specifically the connection pool and close the transaction
        session.close();
        return result;
    }

    public void insert(Employee employee) {
        // prepare the hibernate session for use
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(employee);                  // save

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public void update(Employee employee) {

        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(employee);            // merge
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Employee employee) {

        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(employee);             // delete
        session.getTransaction().commit();
        session.close();
    }
}


