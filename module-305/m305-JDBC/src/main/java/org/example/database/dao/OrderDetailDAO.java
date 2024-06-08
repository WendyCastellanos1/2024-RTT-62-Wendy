package org.example.database.dao;

import org.example.database.entity.OrderDetail;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OrderDetailDAO {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void insert(OrderDetail orderDetail) {
        // prepare the hibernate session for use
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(orderDetail);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public void update(OrderDetail orderDetail) {
        // prepare the hibernate session for use
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.merge(orderDetail);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public void delete(OrderDetail orderDetail) {
        // prepare the hibernate session for use
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.delete(orderDetail);

        // commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();
    }

    public OrderDetail findById(Integer id) {

        Session session = factory.openSession();

        // JPA Query - the syntax is slightly different than regular SQL
        String hql = "select od from OrderDetail od where od.id = :id";

        // this typed query is how hibernate knows what kind of object to fill up with the query results
        TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);

        // this is similar to the prepared statement. we are going to set the value in the query:id
        // to the value passed into the function
        query.setParameter("id", id);

        // will toggle on and off as needed for debug comfort
        // when we know we are getting 0 or more records we use getResultList
        try {
            OrderDetail result = query.getSingleResult();
            return result;
        }catch (Exception e){ // hibernate returns null if no record found
            return null;
        }finally {
            // finally we close the hibernate session so it can release the resources its holding
            //specifically the connection pool and close the transaction
            session.close();
        }
    }

    public List<OrderDetail> findByOrderId(int orderId){

        Session session = factory.openSession();

        String hql = "select od from OrderDetail  od where od.orderId = :orderId";
        TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
        query.setParameter("orderId", orderId);

        List<OrderDetail> result = query.getResultList();
        session.close();
        return result;
    }
    public List<OrderDetail> findByProductId(int productId) {

        Session session = factory.openSession();

        String hql = "select od from OrderDetail  od where od.productId = :productId";
        TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
        query.setParameter("productId", productId);

        List<OrderDetail> result = query.getResultList();
        session.close();
        return result;
    }
    public OrderDetail findByOrderIdAndProductId(Integer orderId, Integer productId) {
        Session session = factory.openSession();

        String hql = "SELECT od FROM OrderDetail od where od.product.id = :productId and od.order.id = :orderId";

        TypedQuery<OrderDetail> query = session.createQuery(hql,OrderDetail.class);
        query.setParameter("orderId", orderId);
        query.setParameter("productId", productId);

        try {
            OrderDetail result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
            return null;
        } finally {
            session.close();
        }
    }
}
