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
public class Signage {
    private int id;
    private String Type;
    private String Location;
    private int Units;
    private String Material_used;
    private String Baranggay;
    private String District;
    private String Date;
   
  
    public Signage(int id,String Type,String Location,int Units,String Material_used,String Baranggay, String District, String Date)
    {
    this.id = id;
    this.Type = Type;
    this.Location = Location;
    this.Units = Units;
    this.Material_used = Material_used;
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
    
    public String getLocation()
    {
        return Location;
    }
        
     public int getUnits()
    {
        return Units;
    }
    public String getMaterial_used()
    {
        return Material_used;
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
