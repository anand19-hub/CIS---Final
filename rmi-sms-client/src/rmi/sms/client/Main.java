/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.sms.client;

import com.sms.api.entity.Admin;
import com.sms.api.services.Services;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.time.Month;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Harry
 */
public class Main extends Application {
    private Services services;
    @Override
    public void start(Stage stage) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 6710);
        services = (Services) registry.lookup("service");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        LoginController controller = loader.getController();
        controller.setMain(this);
        stage.setScene(new Scene(root));
        stage.show(); 
    }
    
    public Services getServices(){
        return services;    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
