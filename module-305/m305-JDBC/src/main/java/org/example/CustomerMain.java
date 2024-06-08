package org.example;

import org.example.database.dao.OrderDAO;
import org.example.database.entity.Order;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerMain {
    //
    //    1) be able to prompt user for a customer id (number)
    //    2)     use  findByCustomerId to get the orders for that customer
    //    2.2) print the orders
    //    2.5  user enters an order id
    //    3)   query the order by the order id
    //    4)     update the comment on the order to be whatever you want
    //    5) save the order to the database

    private OrderDAO orderDAO = new OrderDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {

        // prompt the user to enter a  customer id
        int  customerId = promptCustomerId();

        //fetch the list of orders
        List<Order> orders = orderDAO.findByCustomerId(customerId);

        // print our orders menu
        printOrders(orders);

        // now validate the user enters a proper order id
        Order  selectedOrder = null;
        while (selectedOrder == null) {
            //#2 print the list of orders
            int orderId = promptForOrderId();

            //  2.5
            selectedOrder = orderDAO.findById(orderId);
            if (selectedOrder == null) {
                System.out.println("You have entered an invalid order id");
            }
        }

        String comment = promptComment();
        System.out.println(comment);

        //save the order to the database
        updateComment(selectedOrder, comment);
    }

    public void updateComment(Order order, String comment){
        order.setComments(comment);
        orderDAO.update(order);
    }

    public int promptCustomerId(){
        while (true){
            try {
                System.out.println("Enter the customer id so I can find the orders : ");
                int id = scanner.nextInt();
                return id;
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid customer id: ");
            }
        }
    }

    public String promptComment(){
        while (true){
            try {
                System.out.println("Enter the new comment for the order : ");
                String comment = scanner.nextLine();
                return comment;
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid comment for the order: ");
            }
        }
    }

    public void printOrders(List<Order> orders){
        //print
        System.out.println("Order_Id | Customer_id | Order_Date | Required_Date | Shipped_Date | Status | Comments ");
        System.out.println("=========================================================================================");
        for ( Order order: orders ) {
            System.out.println( order.getId() + " | "  + order.getCustomer_id() + " | " + order.getOrderDate()
                    + " | " + order.getRequiredDate() + " | " + order.getShippedDate() + " | "
                    + order.getStatus() + " | ");  // + order.getCustomer() );
        }

    }

    public int promptForOrderId() {
        // validate for non-numeric or invalid numeric id, like not in db
        while ( true ) {
            try {
                System.out.println("Enter the order id to modify: ");
                // int id = Integer.parseInt(scanner.nextLine());
                 int id = scanner.nextInt();
                scanner.nextLine();  // try
            } catch (Exception e) {
                System.out.println("Please enter a valid number for order id: ");
                scanner.nextLine();  //  SBA: to consume the  NEWLINE character SBA!!!!!!!!!!!!!!!!!!! .nextInt doesn't consume it!
            }
        }
    }

    public static void main(String[] args) {
        CustomerMain cm = new CustomerMain();
        cm.run();
    }
}
