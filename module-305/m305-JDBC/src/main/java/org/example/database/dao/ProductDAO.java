package org.example.database.dao;

import org.example.database.entity.Product;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {

    public void insert(Product product) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(product);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public void update(Product product) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.merge(product);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public void delete(Product product) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.delete(product);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public Product findById(Integer id) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        String hql = "select p from Product p where p.id = :id";

        // this typed query is how hibernate knows what kind of object to fill up with the query results
        TypedQuery<Product> query = session.createQuery(hql, Product.class);

        // this is similar to the prepared statement. we are going to set the value in the query:id
        // to the value passed into the function
        query.setParameter("id", id);

        // will toggle on and off as needed for debug comfort
        // when we know we are getting 0 or more records we use getResultList
        try {
            Product result = query.getSingleResult();
            return result;
        }catch (Exception e){ // hibernate returns null if no record found
            return null;
        }finally {
            // finally we close the hibernate session so it can release the resources its holding
            //specifically the connection pool and close the transaction
            session.close();
        }
    }

    public Product findByName(String productName){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "select p from Product p where p.productName = :productName";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("productName", productName);

        try {
            Product result = query.getSingleResult();
            return result;
        }catch (Exception e){ // hibernate returns null if no record found
            return null;
        }finally {
            // close the connection pool and the transaction
            session.close();
        }
    }

    public Product findByCode(String productCode){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String hql = "select p from Product p where p.productCode = :productCode";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("productCode", productCode);

        try {
            Product result = query.getSingleResult();
            return result;
        }catch (Exception e){ // hibernate returns null if no record found
            return null;
        }finally {
            // close the connection pool and the transaction
            session.close();
        }
    }
}
