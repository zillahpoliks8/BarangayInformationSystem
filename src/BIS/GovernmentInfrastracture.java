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
public class GovernmentInfrastracture {
    private int id;
    private String Infrastructure;
    private String Location;
    private int Sitio;
   
  
    public GovernmentInfrastracture(int id,String Infrastructure,String Location,int Sitio)
    {
    this.id = id;
    this.Infrastructure = Infrastructure;
    this.Location = Location;
    this.Sitio = Sitio;
    }
    
    public int getid()
    {
        return id;
    }
    
    public String getInfrastructure()
    {
        return Infrastructure;
    }
    
     public String getLocation()
    {
        return Location;
    }
    public int getSitio()
    {
        return Sitio;
    }
    
}
