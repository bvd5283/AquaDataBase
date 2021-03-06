/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManage;

import flintwater.FlintWater;
import flintwater.Navigation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import ResidentFunctionManage.UploadUWDataController;

/**
 * FXML Controller class
 *
 * @author Bingnan Dong
 */
public class ResidentUIController implements Initializable {
    @FXML private Text  helloTxt;
    @FXML private Label Status;
    @FXML private Text birthDate;
    @FXML private Text email;
             
    private  static User loginUser;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
                 helloTxt.setText("Welcome, " +  loginUser.getUsername() +"   ");
                 birthDate.setText("BirthDate: " +  loginUser.getDateOfBirth() +"   ");
                 email.setText("Welcome: " +  loginUser.getEmailaddress() +"   ");



    }  
    
     public void userSet(User user){
        this.loginUser = user;
    }
       /**
     * Display user interface to login
     */
    public void handleLogOut(ActionEvent event) throws IOException{
        Navigation navigation = new  Navigation();
        navigation.handleLogOut();
    }
     /**
     * Display user OfficalData
     */
    public void  HandleOfficalData(ActionEvent event) throws IOException{
        Navigation navigation = new  Navigation();
        navigation.HandleOfficalData();
    }
    
    public void  HandleResidentDataUpload(ActionEvent event) throws IOException{
        
       UploadUWDataController  uploadUWDataController  = new UploadUWDataController();
       uploadUWDataController.userSet(loginUser);
       Parent root = FXMLLoader.load(getClass().getResource("/ResidentFunctionManage/UploadUWData.fxml"));
       FlintWater.stage.setScene(new Scene(root));
       FlintWater.stage.setTitle("UploadYourData");
    }
    
}