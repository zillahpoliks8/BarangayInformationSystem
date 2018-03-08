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
public class FamilieslivingInproneAreas {
    private int id;
    private String Hazard;
    private String Location;
    private int Sitio;
    private String Date;
   
  
    public FamilieslivingInproneAreas(int id,String Hazard,String Location,int Sitio, String Date)
    {
    this.id = id;
    this.Hazard = Hazard;
    this.Location = Location;
    this.Sitio = Sitio;
    this.Date = Date;
    }
    
    public int getid()
    {
        return id;
    }
    
    public String getHazard()
    {
        return Hazard;
    }
    
     public String getLocation()
    {
        return Location;
    }
    public int getSitio()
    {
        return Sitio;
    }
    public String getDate()
    {
        return Date;
    }
    
}
