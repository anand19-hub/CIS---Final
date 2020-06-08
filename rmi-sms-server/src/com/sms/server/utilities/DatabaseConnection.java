package com.sms.server.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*  GROUP 1 - UoB Feb 2020
 *  Rajeenthiran Thangenthiran  - 1940909 - Student
 *  Anand Sripathmathasan       - 1939890 - Teacher
 *  Miluckshan Jalangan         - 1940857 - Admin
 */

public class DatabaseConnection {
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException{
        if (connection == null || connection.isClosed()) {
            try { 
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?serverTimezone=UTC", "root", "");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }
}
