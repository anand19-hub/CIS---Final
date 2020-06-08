package com.sms.server;

import com.sms.server.service.ServicesImpl;
import com.sms.server.utilities.DatabaseConnection;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.application.Application;
import javafx.stage.Stage;

/*  GROUP 1 - UoB Feb 2020
 *  Rajeenthiran Thangenthiran  - 1940909 - Student
 *  Anand Sripathmathasan       - 1939890 - Teacher
 *  Miluckshan Jalangan         - 1940857 - Admin
 */

public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        DatabaseConnection.getConnection();
        Registry registry = LocateRegistry.createRegistry(6710);
        ServicesImpl servicesImpl = new ServicesImpl();
        registry.rebind("service", servicesImpl);
        System.out.println("Server");  
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
        
    }
}
