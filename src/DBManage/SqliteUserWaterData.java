/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManage;
import DataManage.OfficialData;
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
import org.bson.Document;
import org.bson.conversions.Bson;
/**
 *
 * @author Bingnan Dong
 */
public class SqliteUserWaterData {
    public MongoCollection createCollection(MongoDatabase mongoDatabase){
          // 连接到集合
       MongoCollection<Document> collection = mongoDatabase.getCollection("UserWaterData");
       System.out.println("Create collection UserWaterData successfully");
       return  collection;
     }
    
   
}
