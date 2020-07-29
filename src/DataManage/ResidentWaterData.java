/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManage;
import UserManage.Resident;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Bingnan Dong
 */
public class ResidentWaterData {
    private String RWDataID;
    private String username;
    private String TestDate;
    
    private Integer Lead250;
    private Integer Lead750;
    private Integer Lead1000;
    
    private Integer Copper250;
    private Integer Copper750;
    private Integer Copper1000;
    
    
    private String StreetName;
    
    private String ZipCode;
    
    
    public ResidentWaterData(String RWDataID,String username, String TestDate,  Integer Lead250, Integer Lead750, Integer Lead1000, Integer Copper250, 
            Integer Copper750, Integer Copper1000, String StreetName,String ZipCode ){
        this.RWDataID = RWDataID;
        this.username= username;
        this.TestDate = TestDate;
        
        this.Lead250 = Lead250;
        this.Lead750 = Lead750;
        this.Lead1000 = Lead1000;
        
        this.Copper250 = Copper250;
        this.Copper750 = Copper750;
        this.Copper1000 = Copper1000;
        
        this.StreetName = StreetName;
        this.ZipCode = ZipCode;
        
    }
    
     public String getRWDataID(){
      
       return RWDataID;
    }   
     
     
     public String getUserName(){
      
       return username;
    } 
     
     public String getTestDate(){
      
       return TestDate;
    } 
     
     public Integer getLead250(){
      
       return Lead250;
    }   
    
                 /**
     * Returns the Lead2k750 of an OfficialWaterData
     * @return  An integer representing the Lead2k750 of an OfficialWaterData
     */
    
    public Integer getLead750(){
      
       return Lead750;
    } 
    
                 /**
     * Returns the Lead2k1000 of an OfficialWaterData
     * @return  An integer representing the Lead2k1000 of an OfficialWaterData
     */
    
    public Integer getLead1000(){
      
       return Lead1000;
    } 
    
    public Integer getCopper250(){
      
       return Copper250;
    } 
    
                    /**
     * Returns the Copper2k750 of an OfficialWaterData
     * @return  An integer representing the Copper2k750 of an OfficialWaterData
     */
    
    public Integer getCopper750(){
      
       return Copper750;
    } 
    
                    /**
     * Returns the Copper2k1000 of an OfficialWaterData
     * @return  An integer representing the Copper2k1000 of an OfficialWaterData
     */
    
    public Integer getCopper1000(){
      
       return Copper1000;
    } 
    
    public String getStreetName(){
      
       return StreetName;
    } 
    
     public String getZipCode(){
      
       return ZipCode;
    } 
    
    
    
    
    
    
    
    
}
