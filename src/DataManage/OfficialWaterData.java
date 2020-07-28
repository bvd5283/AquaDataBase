/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManage;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import UserManage.Professional;
/**
 *
 * @author Bingnan Dong
 */
public class OfficialWaterData {
    private Integer OWDataID;
    private String ProfessionalID;
    private LocalDate TestDate;
    private String SampleNum;
    private Integer Lead2k250;
    private Integer Lead2k750;
    private Integer Lead2k1000;
    private Integer Lead1k1000;
    private Integer Copper2k250;
    private Integer Copper2k750;
    private Integer Copper2k1000;
    private Integer Copper1k1000;
    private Integer StreetNum;
    private String StreetName;
    private String CityName;
    private String ZipCode;
    
     /**
     * This creates an OfficialWaterData for an organization
     * @param ProfessionalID Set ProfessionalID for the OfficialWaterData 
     * @param LocalDate Set date for the OfficialWaterData
     * @param SampleNum Set Sample Number for the OfficialWaterData
     * @param Lead2k250 Set 2 Bottle Kits 250 ml lead testing result for the OfficialWaterData
     * @param Lead2k750 Set 2 Bottle Kits 750 ml lead testing result for the OfficialWaterData
     * @param Lead2k1000 Set 2 Bottle Kits 1000 ml lead testing result for the OfficialWaterData
     * @param Lead1k1000 Set 1 Bottle Kits 1000 ml lead testing result for the OfficialWaterData
     * @param Copper2k250 Set 2 Bottle Kits 250 ml copper testing result for the OfficialWaterData
     * @param Copper2k750 Set 2 Bottle Kits 750 ml copper testing result for the OfficialWaterData
     * @param Copper2k1000 Set 2 Bottle Kits 1000 ml copper testing result for the OfficialWaterData
     * @param Copper1k1000 Set 1 Bottle Kits 1000 ml copper testing result for the OfficialWaterData
     * @param StreetNum Set Street Number for the OfficialWaterData
     * @param StreetName Set Street Name for the OfficialWaterData
     * @param CityName Set City Name for the OfficialWaterData
     * @param ZipCode Set zip code for the OfficialWaterData
     */
    
    public OfficialWaterData(String ProfessionalID, LocalDate TestDate, String SampleNum, Integer Lead2k250, 
            Integer Lead2k750, Integer Lead2k1000, Integer Lead1k1000, Integer Copper2k250, 
            Integer Copper2k750, Integer Copper2k1000, Integer Copper1k1000, Integer StreetNum, 
            String StreetName, String CityName, String ZipCode ){
        this.ProfessionalID= ProfessionalID;
        this.TestDate = TestDate;
        this.SampleNum = SampleNum;
        this.Lead2k250 = Lead2k250;
        this.Lead2k750 = Lead2k750;
        this.Lead2k1000 = Lead2k1000;
        this.Lead1k1000 = Lead1k1000;
        this.Copper2k250 = Copper2k250;
        this.Copper2k750 = Copper2k750;
        this.Copper2k1000 = Copper2k1000;
        this.Copper1k1000 = Copper1k1000;
        this.StreetNum = StreetNum;
        this.StreetName = StreetName;
        this.CityName = CityName;
        this.ZipCode = ZipCode;
        
    }
    
     /**
     * This creates an OfficialWaterData for an organization
     * @param OWDataID Set OWDataID for the OfficialWaterData
     * @param ProfessionalID Set ProfessionalID for the OfficialWaterData 
     * @param TestDate Set date for the OfficialWaterData
     * @param SampleNum Set Sample Number for the OfficialWaterData
     * @param Lead2k250 Set 2 Bottle Kits 250 ml lead testing result for the OfficialWaterData
     * @param Lead2k750 Set 2 Bottle Kits 750 ml lead testing result for the OfficialWaterData
     * @param Lead2k1000 Set 2 Bottle Kits 1000 ml lead testing result for the OfficialWaterData
     * @param Lead1k1000 Set 1 Bottle Kits 1000 ml lead testing result for the OfficialWaterData
     * @param Copper2k250 Set 2 Bottle Kits 250 ml copper testing result for the OfficialWaterData
     * @param Copper2k750 Set 2 Bottle Kits 750 ml copper testing result for the OfficialWaterData
     * @param Copper2k1000 Set 2 Bottle Kits 1000 ml copper testing result for the OfficialWaterData
     * @param Copper1k1000 Set 1 Bottle Kits 1000 ml copper testing result for the OfficialWaterData
     * @param StreetNum Set Street Number for the OfficialWaterData
     * @param StreetName Set Street Name for the OfficialWaterData
     * @param CityName Set City Name for the OfficialWaterData
     * @param ZipCode Set zip code for the OfficialWaterData
     */
    
    public OfficialWaterData(Integer OWDataID, String ProfessionalID, LocalDate TestDate, String SampleNum, Integer Lead2k250, 
            Integer Lead2k750, Integer Lead2k1000, Integer Lead1k1000, Integer Copper2k250, 
            Integer Copper2k750, Integer Copper2k1000, Integer Copper1k1000, Integer StreetNum, 
            String StreetName, String CityName, String ZipCode ){
        this.OWDataID = OWDataID;
        this.ProfessionalID= ProfessionalID;
        this.TestDate = TestDate;
        this.SampleNum = SampleNum;
        this.Lead2k250 = Lead2k250;
        this.Lead2k750 = Lead2k750;
        this.Lead2k1000 = Lead2k1000;
        this.Lead1k1000 = Lead1k1000;
        this.Copper2k250 = Copper2k250;
        this.Copper2k750 = Copper2k750;
        this.Copper2k1000 = Copper2k1000;
        this.Copper1k1000 = Copper1k1000;
        this.StreetNum = StreetNum;
        this.StreetName = StreetName;
        this.CityName = CityName;
        this.ZipCode = ZipCode;
        
    }
    
         /**
     * Returns the OfficialWaterDataID of an OfficialWaterData
     * @return  An integer representing the OfficialWaterData ID of an OfficialWaterData
     */
    
    public Integer getOWDataID(){
      
       return OWDataID;
    }   
    
             /**
     * Returns the ProfessionalID of an OfficialWaterData
     * @return  A String representing the ProfessionalID of an OfficialWaterData
     */
    
    public String getProfessionalID(){
      
       return ProfessionalID;
    }  
    
                 /**
     * Returns the TestDate of an OfficialWaterData
     * @return  A LocalDate representing the TestDate of an OfficialWaterData
     */
    
    public LocalDate getTestDate(){
      
       return TestDate;
    } 
    
                     /**
     * Returns the SampleNum of an OfficialWaterData
     * @return  A String representing the SampleNum of an OfficialWaterData
     */
    
    public String getSampleNum(){
      
       return SampleNum;
    }  
    
    
             /**
     * Returns the Lead2k250 of an OfficialWaterData
     * @return  An integer representing the Lead2k250 of an OfficialWaterData
     */
    
    public Integer getLead2k250(){
      
       return Lead2k250;
    }   
    
                 /**
     * Returns the Lead2k750 of an OfficialWaterData
     * @return  An integer representing the Lead2k750 of an OfficialWaterData
     */
    
    public Integer getLead2k750(){
      
       return Lead2k750;
    } 
    
                 /**
     * Returns the Lead2k1000 of an OfficialWaterData
     * @return  An integer representing the Lead2k1000 of an OfficialWaterData
     */
    
    public Integer getLead2k1000(){
      
       return Lead2k1000;
    } 
    
                 /**
     * Returns the Lead1k1000 of an OfficialWaterData
     * @return  An integer representing the Lead1k1000 of an OfficialWaterData
     */
    
    public Integer getLead1k1000(){
      
       return Lead1k1000;
    } 
    
                 /**
     * Returns the Copper2k250 of an OfficialWaterData
     * @return  An integer representing the Copper2k250 of an OfficialWaterData
     */
    
    public Integer getCopper2k250(){
      
       return Copper2k250;
    } 
    
                    /**
     * Returns the Copper2k750 of an OfficialWaterData
     * @return  An integer representing the Copper2k750 of an OfficialWaterData
     */
    
    public Integer getCopper2k750(){
      
       return Copper2k750;
    } 
    
                    /**
     * Returns the Copper2k1000 of an OfficialWaterData
     * @return  An integer representing the Copper2k1000 of an OfficialWaterData
     */
    
    public Integer getCopper2k1000(){
      
       return Copper2k1000;
    } 
    
                        /**
     * Returns the Copper1k1000 of an OfficialWaterData
     * @return  An integer representing the Copper1k1000 of an OfficialWaterData
     */
    
    public Integer getCopper1k1000(){
      
       return Copper1k1000;
    } 
    
                           /**
     * Returns the StreetNum of an OfficialWaterData
     * @return  An integer representing the StreetNum of an OfficialWaterData
     */
    
    public Integer getStreetNum(){
      
       return StreetNum;
    } 
    
                               /**
     * Returns the StreetName of an OfficialWaterData
     * @return  A String representing the StreetName of an OfficialWaterData
     */
    
    public String getStreetName(){
      
       return StreetName;
    } 
    
                                   /**
     * Return the CityName of an OfficialWaterData
     * @return  A String representing the CityName of an OfficialWaterData
     */
    
    public String getCityName(){
      
       return CityName;
    } 
    
   
    
    
    
    
    
}
