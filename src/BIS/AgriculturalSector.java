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
public class AgriculturalSector {
    private int id;
    private String Sitio;
    private int Farmers;
    private int Farm_land;
    private int Fish_farmers;
    private int Land_area;
    private int Livestock;
    private int Type_of_livestock;
    private String Baranggay;
    private String District;
    private String Date;
     
    public AgriculturalSector(int id, String Sitio, int Farmers, int Farm_land, int Fish_farmers, int Land_area, int Livestock, int Type_of_livestock, String Baranggay, String District, String Date)
    {
    this.id = id;
    this.Sitio = Sitio;
    this.Farmers = Farmers;
    this.Farm_land = Farm_land;
    this.Fish_farmers = Fish_farmers;
    this.Land_area = Land_area;
    this.Livestock = Livestock;
    this.Type_of_livestock = Type_of_livestock;
    this.Baranggay= Baranggay;
    this.District= District;
    this.Date= Date;
    }
    
    public int getid()
    {
        return id;
    }
    
    public String getSitio()
    {
        return Sitio;
    }
    
     public int getFarmers()
    {
        return Farmers;
    }
    public int getFarm_land()
    {
        return Farm_land;
    }
    public int getFish_farmers()
    {
        return Fish_farmers;
    }
    public int getLand_area()
    {
        return Land_area;
    }
    public int getLivestock()
    {
        return Livestock;
    }
    public int getType_of_livestock()
    {
        return Type_of_livestock;
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
