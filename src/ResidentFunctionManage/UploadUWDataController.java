/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResidentFunctionManage;

import MongoDBManage.MongoDB;
import MongoDBManage.MongoResidentWaterData;
import MongoDBManage.MongoUser;
import UserManage.User;
import com.mongodb.client.MongoCollection;
import flintwater.FlintWater;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.bson.Document;

/**
 * FXML Controller class
 *
 * @author Bingnan Dong
 */
public class UploadUWDataController implements Initializable {
     private static User loginUser;
    @FXML private Label userStatus;
    
    @FXML private TextField STNameField;
   
    @FXML private TextField ZipCodeField;
    @FXML private DatePicker testDate;
    
    @FXML private TextField Lead250Field;
    @FXML private TextField Lead750Field;
    @FXML private TextField Lead1000Field;

    @FXML private TextField Copper250Field;
    @FXML private TextField Copper750Field;
    @FXML private TextField Copper1000Field;
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void userSet(User user){
        this.loginUser =user;
    }
    
     public void  handleReset(ActionEvent event) throws IOException{
         testDate.setValue(null);
         STNameField.setText("");
         
         ZipCodeField.setText("");
         Lead250Field.setText("");
         Lead750Field.setText("");
         Lead1000Field.setText("");
         
         Copper250Field.setText("");
         Copper750Field.setText("");
         Copper1000Field.setText("");
         
    }
     
     public Boolean checkUserInput(){
        Boolean check = false;
        if (testDate.getValue() == null){
         userStatus.setText("Date can not be null.");
            return check;
       }
        
        if(STNameField.getText().length()==0){
          
            userStatus.setText("Street Name can not be null.");
            return check;
        }
         
         
        if( ZipCodeField.getText().length()==0){
          
            userStatus.setText("Zipcode can not be null.");
            return check;
        }
       
        int count = 0;
        if(Lead250Field.getText().length()==0)
          count = count + 1;
        if(Lead750Field.getText().length()==0)
          count = count + 1;
        if(Lead1000Field.getText().length()==0)
          count = count + 1;    
             
         if(Copper250Field.getText().length()==0)
          count = count + 1;
        if(Copper750Field.getText().length()==0)
          count = count + 1;
        if(Copper1000Field.getText().length()==0)
          count = count + 1;    
          
        if(count == 6){
             userStatus.setText("At least input one value.");
            return check;
        }
        

      check = true;
      return check;
    }
     
      public void  handleBack(ActionEvent event) throws IOException{
      Parent root = FXMLLoader.load(getClass().getResource("/UserManage/ResidentUI.fxml"));
       FlintWater.stage.setScene(new Scene(root));
       FlintWater.stage.setTitle("ResidentDashboard");
    }
      
      
       public void  handleUpload(ActionEvent event) throws IOException, ParseException{
        if(!checkUserInput())
            return;
         System.out.println("count1:"+checkUserInput());
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateOftest = testDate.getValue().format(formatters);
        String STName = STNameField.getText();
        
        String Zip =  ZipCodeField.getText();
        
        String Lead250 =   Lead250Field.getText();
        String Lead750 =   Lead750Field.getText();
        String Lead1000 =   Lead1000Field.getText();
        
        String Copper250 =   Copper250Field.getText();
        String Copper750 =   Copper750Field.getText();
        String Copper1000 =   Copper1000Field.getText();
        
         MongoResidentWaterData mongo_ResidentWaterData= new MongoResidentWaterData();
         MongoCollection<Document> collectionResidentWaterData =mongo_ResidentWaterData.createCollection(MongoDB.mongoDatabase);
         mongo_ResidentWaterData.insertResidentWaterData(collectionResidentWaterData, 
                 loginUser.getUsername(),dateOftest,STName,Zip,
                 Lead250,Lead750,Lead1000,
                 Copper250,Copper750,Copper1000
                 );
    }
    
}
