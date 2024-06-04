package org.example;
import java.sql.*;
import java.util.Scanner;

public class JBDCDEMO {
    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://localhost:3306/classic_models";
        String user = "dev";
        String password = "my password here";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first name of the employee you want to search for: ");
            String input = scanner.nextLine();

            String selectSQL = "Select * from employees where firstname = ? or lastname = ?";
            //newer from firstname = :fname  , but not used here for lesson

            String lastnameInput = scanner.nextLine();
            //String selectSQL = "Select * from employees where firstname = '" + input + "'";

            //Statement stmt = connection.createStatement();
            PreparedStatement stmt = connection.prepareStatement(selectSQL);
            stmt.setString(1, input);
            stmt.setString(2, lastnameInput);  //"Doe"  // use proper data type int for int if called for

            ResultSet result =  stmt.executeQuery();

            while(result.next()) {
                String EmployeeID  = result.getString("id");
                String fname = result.getString("firstname");
                String lname  = result.getString("lastname");
                System.out.println(EmployeeID +" | " + fname + "|"+ lname );
            }
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    /*  Interview: how to prevent SQL Injection attack
    “By using prepared statements
    you can force the user input to be handled
    as the content of a parameter 
    (and not as a part of the SQL command)”
     */

}
