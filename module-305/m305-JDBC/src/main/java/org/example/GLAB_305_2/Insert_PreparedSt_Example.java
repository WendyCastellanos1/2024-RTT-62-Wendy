//package org.example.GLAB_305_2;
//
//import java.sql.*;
//
//public class Insert_PreparedSt_Example {
//
//    public static void main(String[] args){
//        Connection con = null;
//        PreparedStatement prepStmt = null;
//        ResultSet rs = null;
//        String dbur1 = "jdbc:mysql://localhost:3306/classicmodels";
//        String user = "root";
//        String password = "password";
//        try {
//            con = DriverManager.getConnection(dburl, user, pasword);
//            System.out.println("Connection established successfully!");
//            // let's insert one record using a prepared statement
//            String sqlQuery = "insert into employees (officeCode, firstName, lastName, email, extension, reportsTo, vacationHours, employeeNUmber, jobTitle)  values (?,?,?,?,?,?,?,?,?)";
//            prepStmt = con.prepareStatement(sqlQuery);
//            prepStmt.setInt(1,6);
//            prepStmt.setString(2, "Jamil");
//            prepStmt.setString();
//            prepStmt.setString();
//            prepStmt.setString();
//            prepStmt.setInt();
//            prepStmt.setInt();
//            prepStmt.setInt();
//            prepStmt.setString();
//            int affectedRows = prepStmt.executeUpdate();
//            System.out.println(affectedRows + " row(s) affected !!");
//            /* Let's pull data from the database for an inserted record */
//        // Query which needs parameters
//        prepStmt = con.prepareStatement("select * from employees where employeeNumber = ? ");
//                   prepStmt.setInt(1, 0003);
//                   //execute select query
//                   rs = prepStmt.executeQuery();
//                   //Display function to show the Resultset
//                   while(rs.next()) {
//                      System.out.println(rs.getString("firstName"));
//                      System.out.println(rs.getString("lastName"));
//                      System.out.println(rs.getString("email"));
//                      System.out.println(rs.getString("officeCode"));
//                   }
//        }
//        catch(SQLException e)
//        {
//            e.printStackTrace();
//        }
//        try {
//            prepStmt.close();
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
