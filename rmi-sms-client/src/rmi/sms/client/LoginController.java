/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.sms.client;

import com.sms.api.services.Services;
import com.sun.prism.Image;

import charts.*;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Harry
 */

public class LoginController implements Initializable {

	@FXML
    private Label lblErrors;
	
	@FXML
    private Label lblJokeQ;
	
	@FXML
    private Label lblJokeA;
	
	@FXML
    private Label lblTime;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnSignin;
    
    @FXML
    private ImageView imgView;
    
    @FXML
    private Image imageAdd;

    ResultSet resultSet = null;
    public String msg = "" + Math.random();
    public String result = "" + Math.random();
    private Main main;
    private Services services;

    @FXML
    public void handleButtonAction(MouseEvent event) throws IOException {

        if (event.getSource() == btnSignin) {
            //login here
            if (!logIn().equals("Wrong credentials")) {
                try {

                    //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();

                    //stage.setMaximized(true);
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                    Parent root = loader.load();
                    DashboardController controller = loader.getController();
                    controller.setMain(main);
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            } else {
                setLblError(Color.TOMATO, "wrong username or passowrd");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
try {
         	
   			JSONArray json;
   			json = readJsonFromUrlImg("https://picsum.photos/v2/list");
   			int array[]={0,1,10,100,1000,1024,1025};
   			int rnd = new Random().nextInt(array.length);
   			
   			String image=(json.getJSONObject(array[rnd]).get("download_url")+".jpg");
   			System.out.println(image);
   			imgView.setImage(new javafx.scene.image.Image(image));
         	
   		} catch (JSONException | IOException e) {
   			// TODO Auto-generated catch block
   			System.out.println("error on url"+e);
   		}
    }

    public LoginController() {

    }

    private String logIn() throws IOException {
        String status = "Success";
        String email = txtUsername.getText();
        String password = txtPassword.getText();
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 6710);
            services = (Services) registry.lookup("service");
            result = services.login(email, password);
            if (email.isEmpty() || password.isEmpty()) {
                setLblError(Color.TOMATO, "Empty credentials");
                status = "Error";
            } else {
                msg = services.rememberMe(result);
                setLblError(Color.TOMATO, msg);
                return result;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;

    }

    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }

    public void setMain(Main main) {
        this.main = main;
        this.services = main.getServices();
        JSONObject json;
        JSONObject json2;
		try {
			json = readJsonFromUrl("https://official-joke-api.appspot.com/random_joke");
			json2 = readJsonFromUrl("http://worldtimeapi.org/api/timezone/Asia/Colombo");
			lblJokeQ.setText((String) json.get("setup"));
			lblJokeA.setText((String) json.get("punchline"));
			lblTime.setText((String) json2.get("datetime"));
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
      }

      public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          JSONObject json = new JSONObject(jsonText);
          return json;
        } finally {
          is.close();
        }
      }
      
      public static JSONArray readJsonFromUrlImg(String url) throws IOException, JSONException {
          java.io.InputStream is = new URL(url).openStream();
          try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
          } finally {
            is.close();
          }
        }
      
      

}
