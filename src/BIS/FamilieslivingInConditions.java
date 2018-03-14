/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIS;

/**
 *
 * @author Rannie Claire
 */
public class FamilieslivingInConditions {
    private int id;
    private String Condition;
    private String Location;
    private int Sitio;
    private String Baranggay;
    private String District;
    private String Date;
   
  
    public FamilieslivingInConditions(int id,String Condition,String Location,int Sitio,String Baranggay, String District, String Date)
    {
    this.id = id;
    this.Condition = Condition;
    this.Location = Location;
    this.Sitio = Sitio;
    this.Baranggay = Baranggay;
    this.District = District;
    this.Date = Date;
    }
    
    public int getid()
    {
        return id;
    }
    
    public String getCondition()
    {
        return Condition;
    }
    
     public String getLocation()
    {
        return Location;
    }
    public int getSitio()
    {
        return Sitio;
    }
    
    public String getBaranggay()
    {
        return Baranggay;
    }
       
    public String getDistrict()
    {
        return District;
    }
    public String getDate()
    {
        return Date;
    }
    
}
