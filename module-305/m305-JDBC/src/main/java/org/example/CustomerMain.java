ackage org.example;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.OrderDAO;
import org.example.database.entity.Customer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.example.database.dao.CustomerDAO;
import org.example.database.dao.CustomerDAO;
import org.example.database.entity.Customer;
import org.example.database.entity.Order;

public class CustomerMain {
    // want to be able to search for a customer
    //    1) be able to prompt user for a customer id (number)
    //    2)     use  findByCustomerId to get the orders for that customer
    //    2.2) print the orders
    //    2.5  user enters an order id
    //    3)   query the order by the order id
    //    4)     update the comment on the order to be whatever you want
    //    5) save the order to the database

    private CustomerDAO customerDAO = new CustomerDAO();
    private OrderDAO orderDAO = new OrderDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {

        // prompt the user to enter a  customer id
        int  customerId = promptCustomerId();

        //fetch the list of orders
        List<Order> orders = OrderDAO.findByCustomerId(customerId); //TODO write this function in customerdao

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

        String comment = promptComment();  //TODO write this function
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
                System.out.println("Enter the customer id (numeric): ");
                int id = scanner.nextInt();
                return id;
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid number for customer id: ");
            }
        }
    }

    public void printOrders(List<Order> orders){
        //print
        System.out.println("Order ID | some field | some other field | some other field | some other field ");
        System.out.println("==========================================================");
        for ( Order order: orders ) {           //TODO put real field headers above.  and real gets below
            System.out.println(order.getId() + " | "  + order.getProductName() + " | " + order.getQuantityInStock());
        }
        System.out.println("\n");
    }
    public int promptForOrderId() {
        // validate for non-numeric or invalid numeric id, like not in db
        while ( true ) {
            try {
                System.out.print("/n Enter the order id to modify: ");
                int id = scanner.nextInt();
                return id;
            } catch (Exception e) {
                System.out.println("Please enter a valid number for order id: ");
                scanner.nextLine();  //  SBA: to consume the  NEWLINE character SBA!!!!!!!!!!!!!!!!!!! .nextInt doesn't consume it!
            }
        }
    }

    public static void main(String[] args) {
        org.example.ProductMain pm = new org.example.ProductMain();
        pm.run();
    }
}
