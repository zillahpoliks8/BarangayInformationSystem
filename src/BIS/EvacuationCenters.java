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
public class EvacuationCenters {
    private int id;
    private String Type;
    private String Location;
    private int Capacity ;
    private String Suitability;
    private String Availability;
    private String Baranggay;
    private String District;
    private String Date;
  
    public EvacuationCenters(int id, String Type, String Location,int Capacity,String Suitability,String Availability,String Baranggay, String District, String Date)
    {
    this.id = id;
    this.Type = Type;
    this.Location = Location;
    this.Capacity = Capacity;
    this.Suitability = Suitability;
    this.Availability = Availability;
    this.Baranggay = Baranggay;
    this.District = District;  
    this.Date= Date;
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
    public int getCapacity()
    {
        return Capacity;
    }
    public String getSuitability()
    {
        return Suitability;
    }
   
    public String getAvailability()
     {
        return Availability;
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
