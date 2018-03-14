/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIS;

/**
 *
 * @author user
 */
public class ServiceInArea {
    private int id;
    private String Type;
    private String others;
    private String Location;
    private int Units;
    private String Baranggay;
    private String District;
    private String Date;
   
  
    public ServiceInArea(int id,String Type,String others,String Location,int Units,String Baranggay, String District, String Date)
    {
    this.id = id;
    this.Type = Type;
    this.others = others;
    this.Location = Location;
    this.Units = Units;
    this.Baranggay = Baranggay;
    this.District = District;
    this.Date = Date;
    }
    
    public int getid()
    {
        return id;
    }
    
    public String getType()
    {
        return Type;
    }
    
    public String getOthers()
    {
        return others;
    }
        
     public String getLocation()
    {
        return Location;
    }
    public int getUnits()
    {
        return Units;
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
