package BIS;


public class BDRRMC {
    
    private int id;
    private String choices;
    private String Composition_of_BDRRMC;
    private String Composition;
    private String ContactNo;
    private String Position;
    private String No;
    private String Date;
  
    public BDRRMC(int id, String choices,String Composition_of_BDRRMC,String Composition,String ContactNo,String Position,String No, String Date)
    {
    this.id = id;
    this.choices = choices;
    this.Composition_of_BDRRMC = Composition_of_BDRRMC;
    this.Composition = Composition;
    this.ContactNo = ContactNo;
    this.Position = Position;
    this.No = No;
    this.Date= Date;
    }
    
    public int getid()
    {
        return id;
    }
    
    public String getChoices()
    {
        return choices;
    }
    public String getComposition_of_BDRRMC()
    {
        return Composition_of_BDRRMC;
    }
    public String getComposition()
    {
        return Composition;
    }
    
   public String getContactNo()
    {
        return ContactNo;
    }
   public String getPosition()
    {
        return Position;
    }
    public String getNo()
   {
       return No;
   }
   public String getDate()
   {
       return Date;
   }
}




      
