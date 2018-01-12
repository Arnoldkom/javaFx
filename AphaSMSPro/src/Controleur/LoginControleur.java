/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 *
 * @author Arnoldkom
 */
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginControleur implements Initializable{

    
    @FXML
     private JFXTextField user;
    @FXML
     private JFXPasswordField pass;
//    @FXML
//     private JFXButton valide4;
//    @FXML
//     private JFXButton cancel4;
//     @FXML
//     private JFXButton close4;
     @FXML
     private Pane panelogin;
    public double x =0;
public double y = 0;
public static Stage themeWindow;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    
    }
    
    
    @FXML
    public void btn_close4(ActionEvent event){
        System.out.println("la fermeture de la fenetre fonctionne bien");
        System.exit(0);
    }
    
    @FXML
    public void btn_valide4(ActionEvent event){
        if(user.getText().equalsIgnoreCase("smspro") && pass.getText().equalsIgnoreCase("smspro")){
            System.out.println("Mode connecté");
      
        Parent root = null;
         try {
             root = FXMLLoader.load(getClass().getResource("/Vue/accueil.fxml"));
            themeWindow = new Stage();
            themeWindow.setScene(new Scene(root));
           // themeWindow.setFullScreen(true);
            
            
        } catch (IOException ex) {
            Logger.getLogger(AbonneController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
          root.setOnMousePressed(new EventHandler<MouseEvent>(){
           
            @Override
            public void handle(MouseEvent event) {
            x = event.getSceneX();
                y = event.getSceneY();
            }
            
        });
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
           themeWindow.setX(event.getScreenX() - x);
           themeWindow.setY(event.getScreenY() - y);
            }
            
            
        });
        panelogin.setVisible(false);
       
          themeWindow.initStyle(StageStyle.UNDECORATED);
         themeWindow.show();
        
         
        
        
        
        }else {
            System.out.println("ERREUR");
        }
    }
    
    @FXML
    public void btn_annuler4(ActionEvent event){
        user.setText("");
        pass.setText("");
    }
    
    
}
