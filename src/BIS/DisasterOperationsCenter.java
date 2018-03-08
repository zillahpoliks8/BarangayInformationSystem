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
public class DisasterOperationsCenter {
    private int id;
    private String Choice;
    private String txt;
    private String txt2;
    private String Location;
    private String Location1;
    private String Area;
    private String ContactNo;
    private String ContactNo1;
    private String Utilities;
    private String Utilities1;
    private String Personal;
    private String Date;
    
    public DisasterOperationsCenter(int id, String Choice, String txt, String txt2,String Location,String Location1,String Area,String ContactNo,String ContactNo1,String Utilities,String Utilities1,String Personal, String Date)
    {
    this.id = id;
    this.Choice = Choice;
    this.txt = txt;
    this.txt2 = txt2;
    this.Location = Location;
    this.Location1 = Location1;
    this.Area = Area;
    this.ContactNo = ContactNo;
    this.ContactNo1 = ContactNo1;
    this.Utilities = Utilities;
    this.Utilities1 = Utilities1;
    this.Personal = Personal;
    this.Date = Date;
    }
    
    public int getid()
    {
        return id;
    }
    
    public String getChoice()
    {
        return Choice;
    }
    
    public String getTxt()
    {
        return txt;
    }
    
    public String getTxt2()
    {
        return txt2;
    }
    public String getLocation()
    {
        return Location;
    }
    
     public String getLocation1()
    {
        return Location1;
    }
    public String getArea()
    {
        return Area;
    }
    
   public String getContactNo()
    {
        return ContactNo;
    }
   
    public String getContactNo1()
    {
        return ContactNo1;
    }
    
     public String getUtilities()
    {
        return Utilities;
    }
     
    public String getUtilities1()
    {
        return Utilities1;
    }
     
    public String getPersonal()
    {
        return Personal;
    }
    
    public String getDate()
    {
        return Date;
    }
}
