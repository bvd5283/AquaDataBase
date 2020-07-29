/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoDBManage;
import DataManage.ResidentWaterData;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
/**
 *
 * @author Bingnan Dong
 */
public class MongoResidentWaterData {
    public MongoCollection createCollection(MongoDatabase mongoDatabase){
          // 连接到集合
       MongoCollection<Document> collection = mongoDatabase.getCollection("ResidentWaterData");
       System.out.println("Create collection ResidentWaterData successfully");
       return  collection;
     }
    
    public ArrayList<ResidentWaterData> findResidentWaterData(MongoCollection collection, String UserName){
        ArrayList<ResidentWaterData> rwData = new ArrayList<>();
         FindIterable<Document> findIterable = collection.find(Filters.eq("username", UserName));
          MongoCursor<Document> mongoCursor = findIterable.iterator();  
        
        
         while(mongoCursor.hasNext()){  
            
            Document document = mongoCursor.next();
          
             String  rwID = document.getString("RWDataID");
             String  username = document.getString("username");
              
             Date  dateBirth = (Date) document.get("testDate");
             String sdf = new SimpleDateFormat("MM/dd/yyyy").format(dateBirth);
             int lead250 = document.getInteger("Lead250");
             int lead750 = document.getInteger("Lead750");
             int lead1000 = document.getInteger("Lead1000");
             
             int copper250 = document.getInteger("Copper250");
             int copper750 = document.getInteger("Copper750");
             int copper1000 = document.getInteger("Copper1000");
             
             String streetname = document.getString("StreetName");
             String zipcode = document.getString("ZipCode");
            
             DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            // LocalDate.parse(sdf, DateTimeFormatter.ISO_DATE);
             rwData.add(new ResidentWaterData(rwID, username,sdf,lead250,lead750,lead1000,copper250,copper750,copper1000,streetname,zipcode));
             //System.out.println("aaa3:"+  sdf);
         }
         return rwData;
    }
    
    
    public  void insertResidentWaterData(MongoCollection collection,ResidentWaterData rwData) throws ParseException{
        Document document = new Document("RWDataID", rwData.getRWDataID()). 
         append("username", rwData.getUserName()).
         append("TestDate", rwData.getTestDate()). 
         append("Lead250",  rwData.getLead250()).
         append("Lead750",  rwData.getLead750()).
         append("Lead1000",  rwData.getLead1000()).
         append("Copper250",  rwData.getCopper250()).
         append("Copper750",  rwData.getCopper750()). 
         append("Copper1000",  rwData.getCopper1000()).
         append("StreetName",  rwData.getStreetName()).
         append("ZipCode",  rwData.getZipCode());
        
         List<Document> documents = new ArrayList<Document>();  
         documents.add(document);  
         collection.insertMany(documents);  
         System.out.println("Insert ResidentWaterData successfully ");
    }
}
