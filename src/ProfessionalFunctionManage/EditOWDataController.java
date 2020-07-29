/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfessionalFunctionManage;

import DataManage.ProfessionalWaterData;
import MongoDBManage.MongoDB;
import MongoDBManage.MongoProfessionalWaterData;
import UserManage.User;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.currentDate;
import static com.mongodb.client.model.Updates.set;
import flintwater.FlintWater;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * FXML Controller class
 *
 * @author Bingnan Dong
 */
public class EditOWDataController implements Initializable {
   private static User loginUser;
   private static ProfessionalWaterData professionalWaterData;
    @FXML private TextField STNameField;
    @FXML private TextField CityField;
    @FXML private TextField STNumField;
    @FXML private TextField ZipCodeField;
    @FXML private DatePicker testDate;
    @FXML private TextField Lead2BK250Field;
    @FXML private TextField Lead2BK750Field;
    @FXML private TextField Lead2BK1000Field;
    @FXML private TextField Lead1BK250Field;
    @FXML private TextField Lead1BK750Field;
    @FXML private TextField Lead1BK1000Field;
    @FXML private TextField Copper2BK250Field;
    @FXML private TextField Copper2BK750Field;
    @FXML private TextField Copper2BK1000Field;
    @FXML private TextField Copper1BK250Field;
    @FXML private TextField Copper1BK750Field;
    @FXML private TextField Copper1BK1000Field;;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        STNameField.setText(professionalWaterData.getStreetName());
        CityField.setText(professionalWaterData.getCityName());
        STNumField.setText(professionalWaterData.getStreetNum());
        ZipCodeField.setText(professionalWaterData.getZipCode());
      
       DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
       LocalDate dateoftest =  LocalDate.parse(professionalWaterData.getTestDate(), fmt); 
       
       testDate.setValue(dateoftest);
       //testDate.setValue(dateoftest);
       
       if(professionalWaterData.getLead2k250() == null){
            Lead2BK250Field.setText("");
        }
        else
            Lead2BK250Field.setText(professionalWaterData.getLead2k250().toString());
       
        if(professionalWaterData.getLead2k750() == null){
            Lead2BK750Field.setText("");
        }
        else
            Lead2BK750Field.setText(professionalWaterData.getLead2k750().toString());
       
        if(professionalWaterData.getLead2k1000() == null){
            Lead2BK1000Field.setText("");
        }
        else
            Lead2BK1000Field.setText(professionalWaterData.getLead2k1000().toString());
        
         if(professionalWaterData.getLead1k250() == null){
            Lead1BK250Field.setText("");
        }
        else
            Lead1BK250Field.setText(professionalWaterData.getLead1k250().toString());
       
        if(professionalWaterData.getLead1k750() == null){
            Lead1BK750Field.setText("");
        }
        else
            Lead1BK750Field.setText(professionalWaterData.getLead1k750().toString());
       
        if(professionalWaterData.getLead1k1000() == null){
            Lead1BK1000Field.setText("");
        }
        else
            Lead1BK1000Field.setText(professionalWaterData.getLead1k1000().toString());
       
        if(professionalWaterData.getCopper2k250() == null){
            Copper2BK250Field.setText("");
        }
        else
            Copper2BK250Field.setText(professionalWaterData.getCopper2k250().toString());
       
        if(professionalWaterData.getCopper2k750() == null){
            Copper2BK750Field.setText("");
        }
        else
            Copper2BK750Field.setText(professionalWaterData.getCopper2k750().toString());
       
        if(professionalWaterData.getCopper2k1000() == null){
            Copper2BK1000Field.setText("");
        }
        else
            Copper2BK1000Field.setText(professionalWaterData.getCopper2k1000().toString());
        
        
         if(professionalWaterData.getCopper1k250() == null){
            Copper1BK250Field.setText("");
        }
        else
            Copper1BK250Field.setText(professionalWaterData.getCopper1k250().toString());
       
        if(professionalWaterData.getCopper1k750() == null){
            Copper1BK750Field.setText("");
        }
        else
            Copper1BK750Field.setText(professionalWaterData.getCopper1k750().toString()); 
        
       if(professionalWaterData.getCopper1k1000() == null){
            Copper1BK1000Field.setText("");
        }
        else
            Copper1BK1000Field.setText(professionalWaterData.getCopper1k1000().toString());
        
    }    
    /**
     * Sets the username of login
     * @param user Sets the the username of login
     */
    public void userSet(User user){
        this.loginUser =user;
    }
    
       /**
     * Sets the professionalWaterData of login user
     * @param professionalWaterData Sets the the username of login
     */
    public void professionalWaterDataSet(ProfessionalWaterData professionalWaterData){
        this.professionalWaterData = professionalWaterData;
    }
    
     public void  handleBack(ActionEvent event) throws IOException{
      Parent root = FXMLLoader.load(getClass().getResource("ViewOWData.fxml"));
       FlintWater.stage.setScene(new Scene(root));
       FlintWater.stage.setTitle("ProfessionData");
    }
     
      public void  handleUpdate(ActionEvent event) throws IOException{
          String aa=null;
          
         
           MongoProfessionalWaterData mongo_professionalWaterData= new MongoProfessionalWaterData();
         MongoCollection<Document> collectionProfessionalWaterData =mongo_professionalWaterData.createCollection(MongoDB.mongoDatabase);
         collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                combine(set("StreetName",STNameField.getText()), set("StreetNum", STNumField.getText()),set("CityName", CityField.getText()),set("ZipCode", ZipCodeField.getText())));
          
         if (Lead2BK250Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead2BK250", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead2BK250", Integer.parseInt(Lead2BK250Field.getText())));
         
         if (Lead2BK750Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead2BK750", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead2BK750", Integer.parseInt(Lead2BK750Field.getText())));
         
         if (Lead2BK1000Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead2BK1000", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead2BK1000", Integer.parseInt(Lead2BK1000Field.getText())));
         
         if (Lead1BK250Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead1BK250", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead1BK250", Integer.parseInt(Lead1BK250Field.getText())));
         
         if (Lead1BK750Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead1BK750", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead1BK750", Integer.parseInt(Lead1BK750Field.getText())));
         
         if (Lead1BK1000Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead1BK1000", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Lead1BK1000", Integer.parseInt(Lead1BK1000Field.getText())));
         
         if (Copper2BK250Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper2BK250", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper2BK250", Integer.parseInt(Copper2BK250Field.getText())));
         
         if (Copper2BK750Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper2BK750", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper2BK750", Integer.parseInt(Copper2BK750Field.getText())));
         
         if (Copper2BK1000Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper2BK1000", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper2BK1000", Integer.parseInt(Copper2BK1000Field.getText())));
         
         if (Copper1BK250Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper1BK250", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper1BK250", Integer.parseInt(Copper1BK250Field.getText())));
         
         if (Copper1BK750Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper1BK750", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper1BK750", Integer.parseInt(Copper1BK750Field.getText())));
         
         if (Copper1BK1000Field.getText().length()==0)
             collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper1BK1000", null));
          else    
              collectionProfessionalWaterData.updateOne(
                eq("_id", new ObjectId(professionalWaterData.getId())),
                set("Copper1BK1000", Integer.parseInt(Copper1BK1000Field.getText())));
           
          
          
      }
      
      public void  handleReset(ActionEvent event) throws IOException{
        STNameField.setText("");
        CityField.setText("");
        STNumField.setText("");
        ZipCodeField.setText("");
        testDate.setValue(null);
        Lead2BK250Field.setText("");
        Lead2BK750Field.setText("");
        Lead2BK1000Field.setText("");
        Lead1BK250Field.setText("");
        Lead1BK750Field.setText("");
        Lead1BK1000Field.setText("");
        Copper2BK250Field.setText("");
        Copper2BK750Field.setText("");
        Copper2BK1000Field.setText("");
        Copper1BK250Field.setText("");
        Copper1BK750Field.setText("");
        Copper1BK1000Field.setText("");
      
      }
    
    
}
