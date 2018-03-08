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
    private String Location;
    private int Units;
   
  
    public ServiceInArea(int id,String Type,String Location,int Units)
    {
    this.id = id;
    this.Type = Type;
    this.Location = Location;
    this.Units = Units;
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
}
