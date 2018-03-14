package BIS;


public class BDRRMC {
    
    private int id;
    private String choices;
    private String Composition_of_BDRRMC;
    private String Composition;
    private String ContactNo;
    private String Position;
    private String No;
    private String Baranggay;
    private String District;
    private String Date;
  
    public BDRRMC(int id, String choices,String Composition_of_BDRRMC,String Composition,String ContactNo,String Position,String No, String Branggay, String District, String Date)
    {
    this.id = id;
    this.choices = choices;
    this.Composition_of_BDRRMC = Composition_of_BDRRMC;
    this.Composition = Composition;
    this.ContactNo = ContactNo;
    this.Position = Position;
    this.No = No;
    this.Baranggay = Baranggay;
    this.District = District;  
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




      
