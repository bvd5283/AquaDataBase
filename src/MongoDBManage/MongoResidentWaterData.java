/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoDBManage;
import DataManage.ResidentWaterData;
import DataManage.ProfessionalWaterData;
import UserManage.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
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
         FindIterable<Document> findIterable = collection.find(eq("username", UserName));
          MongoCursor<Document> mongoCursor = findIterable.iterator();  
        
        
         while(mongoCursor.hasNext()){  
            
            Document document = mongoCursor.next();
          
             String  rwID = document.getString("RWDataID");
             String  username = document.getString("username");
              
            Date  DateSubmitted =  document.getDate("TestDate");
             String sdf = new SimpleDateFormat("MM/dd/yyyy").format( DateSubmitted); 
             int lead250 = document.getInteger("Lead250");
             int lead750 = document.getInteger("Lead750");
             int lead1000 = document.getInteger("Lead1000");
             
             int copper250 = document.getInteger("Copper250");
             int copper750 = document.getInteger("Copper750");
             int copper1000 = document.getInteger("Copper1000");
             
             String streetname = document.getString("StreetName");
             String zipcode = document.getString("ZipCode");
            
         
             rwData.add(new ResidentWaterData(rwID, username,sdf,lead250,lead750,lead1000,copper250,copper750,copper1000,streetname,zipcode));
             //System.out.println("aaa3:"+  sdf);
         }
         return rwData;
    }
    
    
    public  void insertResidentWaterData(MongoCollection collection, String username,String dateOftest,String streetname,String zipcode,String lead250, String lead750, String lead1000, 
            String copper250, String copper750, String copper1000)throws ParseException{
        Document document = new Document("username", username);
         SimpleDateFormat formatoutput = new SimpleDateFormat("MM/dd/yyyy");
         Date TestDate =  formatoutput.parse(dateOftest);
        
        
        document.append("TestDate", TestDate). 

         append("StreetName",  streetname).
         append("ZipCode",  zipcode);
        
        if(lead250.length()>0)
                document.append("Lead250",Integer.parseInt(lead250)) ;
         else
                document.append("Lead250", null) ;
         if(lead750.length()>0)
                document.append("Lead750",Integer.parseInt(lead750)) ;
         else
                document.append("Lead750",null) ;
          if(lead1000.length()>0)
                document.append("Lead1000",Integer.parseInt(lead1000)) ;
          else
                document.append("Lead1000",null) ;
          
          if(copper250.length()>0)
                document.append("Copper250",Integer.parseInt(copper250)) ;
         else
                document.append("Copper250",null) ;
         if(copper750.length()>0)
                document.append("Copper750",Integer.parseInt(copper750)) ;
         else
                document.append("Copper750",null) ;
          if(copper1000.length()>0)
                document.append("Copper1000",Integer.parseInt(copper1000)) ;
         else
                document.append("Copper1000",null) ;
        
         List<Document> documents = new ArrayList<Document>();  
         documents.add(document);  
         collection.insertMany(documents);  
         System.out.println("Insert ResidentWaterData successfully ");
    }
}
