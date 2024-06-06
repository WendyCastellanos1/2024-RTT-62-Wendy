package org.example.database.dao;

import org.example.database.entity.Order;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDAO {

    public void insert(Order order) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(order);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public void update(Order order) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.merge(order);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public void delete(Order order) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.delete(order);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public Order findById(Integer id) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        String hql = "select o from Order o where o.id = :id";

        // this typed query is how hibernate knows what kind of object to fill up with the query results
        TypedQuery<Order> query = session.createQuery(hql, Order.class);

        // this is similar to the prepared statement. we are going to set the value in the query:id
        // to the value passed into the function
        query.setParameter("id", id);

        // will toggle on and off as needed for debug comfort
        // when we know we are getting 0 or more records we use getResultList
        try {
            Order result = query.getSingleResult();
            return result;
        }catch (Exception e){ // hibernate returns null if no record found
            return null;
        }finally {
            // finally we close the hibernate session so it can release the resources its holding
            //specifically the connection pool and close the transaction
            session.close();
        }
    }

    public Order findByCustomerId(int customerId){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "select o from Order  o where o.customer_id = :customerId";
        TypedQuery<Order> query = session.createQuery(hql, Order.class);
        query.setParameter("customerId", customerId);

        try {
            Order result = query.getSingleResult();
            return result;
        }catch (Exception e){ // hibernate returns null if no record found
            return null;
        }finally {
            // close the connection pool and the transaction
            session.close();
        }
    }
}
