package org.example;

import org.example.database.entity.Customer;
import org.example.database.dao.CustomerDAO;
import org.example.database.entity.Product;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Order;
import org.example.database.dao.OrderDAO;
import org.example.database.entity.OrderDetail;
import org.example.database.dao.OrderDetailDAO;

public class AddProductToOrder {

    // 1) Load an order from the database by id
    // 2) Load a product from the database by id
    // 3) Create a new OrderDetail object and add the order and the product
    // 4) Save the OrderDetail object to the database

    private OrderDAO orderDAO = new OrderDAO();
    private ProductDAO productDAO = new ProductDAO();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    private CustomerDAO customerDAO = new CustomerDAO();

    public void run(){
       //read the order from the datbase
        Order order = orderDAO.findById(77);
        System.out.println(order);

        //TODO add the comments later from ERic's
        Customer customer = order.getCustomer();
        //System.out.println("This order is for customer with an if = " + customer.getId() + " and name = " + customer.getCustomerName());

        //lets print out the products
        for (OrderDetail od : order.getOrderDetails() ) {
            System.out.println(od.getProduct().getProductName() + " | " + od.getQuantityOrdered() + "|" + od.getPriceEach());
        }
        // read the product from the database
        Product product = productDAO.findById(77);
        System.out.println(product);
        //System.out.println("This order is for customer with an id = " + order.getCustomer().getId() + " and name = " + order.getCustomer().getCustomerName());

        // set up the order details object with the values I want to save to the database
        OrderDetail orderDetail = new OrderDetail();

        // we can just set the product and order objects we just queried on the order detail
        orderDetail.setProduct(product);
        orderDetail.setOrder(order);
        orderDetail.setQuantityOrdered(100);
        orderDetail.setPriceEach(product.getMsrp());
        orderDetail.setOrderLineNumber(10);

        //we can just set th
        orderDetailDAO.insert(orderDetail);
    }

    public static void main(String[] args) {
        AddProductToOrder apto = new AddProductToOrder();
        apto.run();
    }
}
