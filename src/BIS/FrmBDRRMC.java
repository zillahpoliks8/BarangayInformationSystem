/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIS;

import static BIS.SQLite.conn;
import static BIS.SQLite.url;
import com.itextpdf.text.Chunk;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Rectangle;
import java.util.logging.FileHandler;

/**
 *
 * @author user
 */
public class FrmBDRRMC extends javax.swing.JFrame {
Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
DefaultTableModel dm;
    /**
     * Creates new form frmBDRRMC
     */
    public FrmBDRRMC() throws SQLException, ClassNotFoundException {
        initComponents();
        ComboboxDate();
//        ComboboxBaranggay();
        ComboboxDistrict();
//        CreateColumns();
        show_BDRRMC();
        this.setLocationRelativeTo(null);     
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        txtDate.setText(dateFormat.format(date));
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat ("hh:mm:ss a");
        txtTime.setText(s.format(d));
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblBDRRMC");
            String[] column = {"BDC Resolution No.","BDRRMC","Composition of the BDRRMC","Name","Contact Number","Position in the Barangay","No BDRRMC","District","Barangay","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblBDRRMC1.setModel(model);
            SQLite.closeDB();
        }
           if(SQLite.openDB()){
            String[][] data = SQLite.read("tblDOC");
            String[] column = {"ID","DOC","24/7 Operation Center","Others","Location","Name","Land Area","Contact","ContactNumber","Utilities Available","Name", "Personnel-in-Charge","District","Barangay","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblDOC1.setModel(model);
            SQLite.closeDB();
        }
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblAreas");
            String[] column = {"ID","Hazard","Location","No. of Families to be affected per purok","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblAreas1.setModel(model);
            SQLite.closeDB();
        }
           if(SQLite.openDB()){
            String[][] data = SQLite.read("tblCondition");
            String[] column = {"ID","Condition","Location","Sitio","District","Barangay", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblConditions1.setModel(model);
            SQLite.closeDB();
        }               
           if(SQLite.openDB()){
            String[][] data = SQLite.read("tblInfrastracture");
            String[] column = {"ID","Infrastracture","Location","Sitio","District","Barangay", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblInfrastracture1.setModel(model);
            SQLite.closeDB();
        }
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblHazard");
            String[] column = {"ID","Flood Hazard Map","Coastal & Island Map","LandSlide Hazard Map","Riverbanks & Waterways Map","Fire Hazard Map","District","Barangay", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblLocal1.setModel(model);
            SQLite.closeDB();
        }
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblServices");
            String[] column = {"ID","Type","others","Location","Units","District","Barangay","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblServices1.setModel(model);
            SQLite.closeDB();
        }
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblEcenters");
            String[] column = {"ID","Type","Location","Capacity","Suitability","Availability","District","Barangay", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblEcenters1.setModel(model);
            SQLite.closeDB();
        }
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblSignage");
            String[] column = {"ID","Type","Location","Units","Material_used","District","Barangay","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblSignage1.setModel(model);
            SQLite.closeDB();
        }
                if(SQLite.openDB()){
            String[][] data = SQLite.read("tblSector");
            String[] column = {"ID","Sitio","Farmers","Farm_land","Fish_farmers","Land_area","Livestock","Type_of_livestock","District", "Barangay"," date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblSector1.setModel(model);
            SQLite.closeDB();
        }
            }
        

    public void close(){
        int x =JOptionPane.showConfirmDialog(null,  "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
         if (x==0){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         }
    }
   
    public void show_BDRRMC() throws SQLException, ClassNotFoundException{
         ArrayList<BDRRMC> list = BDRRMCList();
        DefaultTableModel model = (DefaultTableModel)tblBDRRMC1.getModel();
        Object [] row = new Object [10];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getChoices();
            row[2] = list.get(i).getComposition_of_BDRRMC();
            row[3] = list.get(i).getComposition();
            row[4] = list.get(i).getContactNo();
            row[5] = list.get(i).getPosition();
            row[6] = list.get(i).getNo();
            row[7] = list.get(i).getDistrict();
            row[8] = list.get(i).getBaranggay();          
            row[9] = list.get(i).getDate();
            model.addRow(row);
        }
    }
    
    public ArrayList <BDRRMC> BDRRMCList() throws SQLException, ClassNotFoundException{
       ArrayList<BDRRMC> BDRRMCList = new ArrayList<>();
        try{
            Class.forName("org.sqlite.JDBC");
//             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
             conn = java.sql.DriverManager.getConnection(url);
             String query = "Select * from tblBDRRMC";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             BDRRMC bdrrmc;
             while(rs.next()){
                 bdrrmc = new BDRRMC (rs.getInt("ID"),rs.getString("choices"),rs.getString("Composition_of_BDRRMC"),rs.getString("Composition"),rs.getString("ContactNo"),rs.getString("Position"),rs.getString("No"),rs.getString("District"),rs.getString("Baranggay"),rs.getString("Date"));
                 BDRRMCList.add(bdrrmc);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return BDRRMCList;
    }

    
   
    
        public void show_Areas() throws SQLException, ClassNotFoundException{
         ArrayList<FamilieslivingInproneAreas> list = AreasList();
        DefaultTableModel model = (DefaultTableModel)tblAreas1.getModel();
        Object [] row = new Object [5];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getHazard();
            row[2] = list.get(i).getLocation();
            row[3] = list.get(i).getSitio(); 
            row[4] = list.get(i).getDate();
            model.addRow(row);          
        }
    }
    
    public ArrayList <FamilieslivingInproneAreas> AreasList() throws SQLException, ClassNotFoundException{
          ArrayList<FamilieslivingInproneAreas> AreasList = new ArrayList<>();
         try{
             Class.forName("org.sqlite.JDBC");
//             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
             conn = java.sql.DriverManager.getConnection(url);
             String query = "Select * from tblAreas";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             FamilieslivingInproneAreas areas;
             while(rs.next()){
                 areas = new FamilieslivingInproneAreas (rs.getInt("ID"),rs.getString("Hazard"),rs.getString("Location"),rs.getInt("Sitio"),rs.getString("Date"));
                 AreasList.add(areas);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return AreasList;
    }
            public void executeSQLQuery(String query,String message) throws SQLException
            {
                conn = java.sql.DriverManager.getConnection(url);
                Statement st;
                try{
                    st = conn.createStatement();
                    if(st.executeUpdate(query) == 1)
                    {
                        JOptionPane.showMessageDialog(null, "Data " +message+"Succesfully");                      
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Not " +message);     
                            }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            
        public void show_Condition() throws SQLException, ClassNotFoundException{
        ArrayList<FamilieslivingInConditions> list = ConditionsList();
        DefaultTableModel model = (DefaultTableModel)tblConditions1.getModel();
       Object [] row = new Object [7];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getCondition();
            row[2] = list.get(i).getLocation();
            row[3] = list.get(i).getSitio();   
            row[4] = list.get(i).getBaranggay();
            row[5] = list.get(i).getDistrict();
            row[6] = list.get(i).getDate();
            model.addRow(row);           
        }
    }
    
    public ArrayList <FamilieslivingInConditions> ConditionsList() throws SQLException, ClassNotFoundException{
         ArrayList<FamilieslivingInConditions> ConditionsList = new ArrayList<>();
             try{
             Class.forName("org.sqlite.JDBC");
//             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
             conn = java.sql.DriverManager.getConnection(url);
             String query = "Select * from tblCondition";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             FamilieslivingInConditions conditions;
             while(rs.next()){
                 conditions = new FamilieslivingInConditions (rs.getInt("ID"),rs.getString("Condition"),rs.getString("Location"),rs.getInt("Sitio"),rs.getString("Baranggay"),rs.getString("District"),rs.getString("Date"));
                 ConditionsList.add(conditions);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return ConditionsList;
    }
          public void show_Local() throws SQLException, ClassNotFoundException{ ///////#1
        ArrayList<LocalHazardandVulnerability> list = LocalList();
        DefaultTableModel model = (DefaultTableModel)tblLocal1.getModel();
        Object [] row = new Object [8];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getChoice1();
            row[2] = list.get(i).getChoice2();
            row[3] = list.get(i).getChoice3();
            row[4] = list.get(i).getChoice4();
            row[5] = list.get(i).getChoice5();
            row[7] = list.get(i).getDate();
            model.addRow(row);          
        }
    }
    

      public ArrayList <LocalHazardandVulnerability> LocalList() throws SQLException, ClassNotFoundException{ /////#2
         ArrayList<LocalHazardandVulnerability> LocalList = new ArrayList<>();
         try{
             Class.forName("org.sqlite.JDBC");
//             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
             conn = java.sql.DriverManager.getConnection(url);
             String query = "Select * from tblHazard";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             LocalHazardandVulnerability local;
             while(rs.next()){
                 local = new LocalHazardandVulnerability (rs.getInt("ID"),rs.getString("Choice1"),rs.getString("Choice2"),rs.getString("Choice3"),rs.getString("Choice4"),rs.getString("Choice5"),rs.getString("Baranggay"),rs.getString("District"),rs.getString("Date"));
                 LocalList.add(local);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return LocalList;
    }
      
      
      
      
      
       public void show_Ecenters() throws SQLException, ClassNotFoundException{
        ArrayList<EvacuationCenters> list = EcentersList();
        DefaultTableModel model = (DefaultTableModel)tblEcenters1.getModel();
        Object [] row = new Object [9];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getType();
            row[2] = list.get(i).getLocation();
            row[3] = list.get(i).getCapacity();   
            row[4] = list.get(i).getSuitability();
            row[5] = list.get(i).getAvailability();
            row[6] = list.get(i).getBaranggay();
            row[7] = list.get(i).getDistrict();   
            row[8] = list.get(i).getDate();
            model.addRow(row);          
        }
    }
    
    public ArrayList <EvacuationCenters> EcentersList() throws SQLException, ClassNotFoundException{
         ArrayList<EvacuationCenters> EcentersList = new ArrayList<>();
         try{
             Class.forName("org.sqlite.JDBC");
//             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
             conn = java.sql.DriverManager.getConnection(url);
             String query = "Select * from tblEcenters";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             EvacuationCenters centers;
             while(rs.next()){
                 centers = new EvacuationCenters (rs.getInt("ID"),rs.getString("Type"),rs.getString("Location"),rs.getInt("Capacity"),rs.getString("Suitability"),rs.getString("Availability"),rs.getString("Baranggay"),rs.getString("District"),rs.getString("Date"));
                 EcentersList.add(centers);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return EcentersList;
    }
      public void show_Signage() throws SQLException, ClassNotFoundException{ ///////#1
        ArrayList<Signage> list = SignageList();
        DefaultTableModel model = (DefaultTableModel)tblSignage1.getModel();
        Object [] row = new Object [8];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getType();
            row[2] = list.get(i).getLocation();
            row[3] = list.get(i).getUnits();
            row[4] = list.get(i).getMaterial_used();
            row[5] = list.get(i).getBaranggay();
            row[6] = list.get(i).getDistrict();        
            row[7] = list.get(i).getDate();
            model.addRow(row);          
        }
    }
    
    public ArrayList <Signage> SignageList() throws SQLException, ClassNotFoundException{ /////#2
         ArrayList<Signage> SignageList = new ArrayList<>();
         try{
             Class.forName("org.sqlite.JDBC");
//             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
             conn = java.sql.DriverManager.getConnection(url);
             String query = "Select * from tblServices";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             Signage signage;
             while(rs.next()){
                 signage = new Signage (rs.getInt("ID"),rs.getString("Type"),rs.getString("Location"),rs.getInt("Units"),rs.getString("Material_used"),rs.getString("Baranggay"),rs.getString("District"),rs.getString("Date"));
                 SignageList.add(signage);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return SignageList;
    }
   
    
        public void show_Infrastructure() throws SQLException, ClassNotFoundException{
        ArrayList<GovernmentInfrastracture> list = InfrastractureList();
        DefaultTableModel model = (DefaultTableModel)tblInfrastracture1.getModel();
        Object [] row = new Object [7];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getInfrastructure();
            row[2] = list.get(i).getLocation();
            row[3] = list.get(i).getSitio();   
            row[4] = list.get(i).getBaranggay();
            row[5] = list.get(i).getDistrict();
            row[6] = list.get(i).getDate();
            model.addRow(row);          
        }
    }
    
    public ArrayList <GovernmentInfrastracture> InfrastractureList() throws SQLException, ClassNotFoundException{
         ArrayList<GovernmentInfrastracture> InfrastractureList = new ArrayList<>();
         try{
             Class.forName("org.sqlite.JDBC");
//             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
             conn = java.sql.DriverManager.getConnection(url);
             String query = "Select * from tblInfrastracture";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             GovernmentInfrastracture Infrastracture;
             while(rs.next()){
                 Infrastracture = new GovernmentInfrastracture (rs.getInt("ID"),rs.getString("Infrastracture"),rs.getString("Location"),rs.getInt("Sitio"),rs.getString("Baranggay"),rs.getString("District"),rs.getString("Date"));
                 InfrastractureList.add(Infrastracture);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return InfrastractureList;
    }
      
     public void show_Service() throws SQLException, ClassNotFoundException{ ///////#1
        ArrayList<ServiceInArea> list = ServiceList();
        DefaultTableModel model = (DefaultTableModel)tblServices1.getModel();
        Object [] row = new Object [8];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getType();
            row[2] = list.get(i).getOthers();
            row[3] = list.get(i).getLocation();
            row[4] = list.get(i).getUnits();
            row[5] = list.get(i).getBaranggay();
            row[6] = list.get(i).getDistrict();        
            row[7] = list.get(i).getDate();
            model.addRow(row);          
        }
    }
    
    public ArrayList <ServiceInArea> ServiceList() throws SQLException, ClassNotFoundException{ /////#2
         ArrayList<ServiceInArea> ServiceList = new ArrayList<>();
         try{
             Class.forName("org.sqlite.JDBC");
//             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
             conn = java.sql.DriverManager.getConnection(url);
             String query = "Select * from tblServices";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             ServiceInArea service;
             while(rs.next()){
                 service = new ServiceInArea (rs.getInt("ID"),rs.getString("Type"),rs.getString("others"),rs.getString("Location"),rs.getInt("Units"),rs.getString("Baranggay"),rs.getString("District"),rs.getString("Date"));
                 ServiceList.add(service);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return ServiceList;
    }
           public void show_DOC() throws SQLException, ClassNotFoundException{
        ArrayList<DisasterOperationsCenter> list = DOCList();
        DefaultTableModel model = (DefaultTableModel)tblDOC1.getModel();
        Object [] row = new Object [15];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getChoice(); 
            row[2] = list.get(i).getTxt();
            row[3] = list.get(i).getTxt2();
            row[4] = list.get(i).getLocation();
            row[5] = list.get(i).getLocation1();
            row[6] = list.get(i).getArea();
            row[7] = list.get(i).getContactNo();
            row[8] = list.get(i).getContactNo1();
            row[9] = list.get(i).getUtilities();
            row[10] = list.get(i).getUtilities1();
            row[11] = list.get(i).getPersonal();  
            row[12] = list.get(i).getBaranggay(); 
            row[13] = list.get(i).getDistrict(); 
            row[14] = list.get(i).getDate();
            model.addRow(row);          
        }
    }
    
    public ArrayList <DisasterOperationsCenter> DOCList() throws SQLException, ClassNotFoundException{
         ArrayList<DisasterOperationsCenter> DOCList = new ArrayList<>();
         try{
             Class.forName("org.sqlite.JDBC");
//             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
             conn = java.sql.DriverManager.getConnection(url);
             String query = "Select * from tblDOC";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             DisasterOperationsCenter doc;
             while(rs.next()){
                 doc = new DisasterOperationsCenter (rs.getInt("ID"),rs.getString("Choice"),rs.getString("txt"),rs.getString("txt2"),rs.getString("Location"),rs.getString("Location1"),rs.getString("Area"),rs.getString("ContactNo"),rs.getString("ContactNo1"),rs.getString("Utilities"),rs.getString("Utilities1"),rs.getString("Personal"),rs.getString("Baranggay"),rs.getString("District"),rs.getString("Date"));
                 DOCList.add(doc);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return DOCList;
    }
     
          public void show_Sector() throws SQLException, ClassNotFoundException{ ///////#1
        ArrayList<AgriculturalSector> list = SectorList();
        DefaultTableModel model = (DefaultTableModel)tblSector1.getModel();
        Object [] row = new Object [11];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getSitio();
            row[2] = list.get(i).getFarmers();
            row[3] = list.get(i).getFarm_land();
            row[4] = list.get(i).getFish_farmers();
            row[5] = list.get(i).getLand_area();
            row[6] = list.get(i).getLivestock();
            row[7] = list.get(i).getType_of_livestock();
            row[8] = list.get(i).getBaranggay();
            row[9] = list.get(i).getDistrict();        
            row[10] = list.get(i).getDate();
            model.addRow(row);          
        }
    }
    
    public ArrayList <AgriculturalSector> SectorList() throws SQLException, ClassNotFoundException{ /////#2
         ArrayList<AgriculturalSector> SectorList = new ArrayList<>();
         try{
             Class.forName("org.sqlite.JDBC");
//             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
             conn = java.sql.DriverManager.getConnection(url);
             String query = "Select * from tblSector";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             AgriculturalSector sector;
             while(rs.next()){
                 sector = new AgriculturalSector (rs.getInt("ID"),rs.getString("Sitio"),rs.getInt("Farmers"),rs.getInt("Farm_land"),rs.getInt("Fish_farmers"),rs.getInt("Land_area"),rs.getInt("Livestock"),rs.getInt("Type_of_livestock"),rs.getString("Baranggay"),rs.getString("District"),rs.getString("Date"));
                 SectorList.add(sector);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return SectorList;
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        LocalHazard = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblBDRRMC1 = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblDOC1 = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        txtID1 = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAreas1 = new javax.swing.JTable();
        txtID2 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtID3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblConditions1 = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtID4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblInfrastracture1 = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txt12 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblServices1 = new javax.swing.JTable();
        jButton22 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtActiveUser = new javax.swing.JLabel();
        ComboBoxDate = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtB = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txt13 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblSector1 = new javax.swing.JTable();
        jButton27 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txt14 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tblLocal1 = new javax.swing.JTable();
        jButton31 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txt15 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tblEcenters1 = new javax.swing.JTable();
        jButton35 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txt16 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        tblSignage1 = new javax.swing.JTable();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxBarangay = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MAIN");

        LocalHazard.setBackground(new java.awt.Color(0, 0, 0));

        tblBDRRMC1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblBDRRMC1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tblBDRRMC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBDRRMC1MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblBDRRMC1);

        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel33.setText("ID");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(878, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane11))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        LocalHazard.addTab("BDRRMC", jPanel1);

        tblDOC1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDOC1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tblDOC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDOC1MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblDOC1);

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel30.setText("ID");

        txtID1.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton34.setText("Add");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton36.setText("Delete");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton36)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton34)
                    .addComponent(jButton36))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        LocalHazard.addTab("Disaster Operations Center", jPanel2);

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel11.setText("ID");

        tblAreas1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAreas1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tblAreas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAreas1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblAreas1);

        txtID2.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton12.setText("Delete");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton12))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton12))
                .addGap(38, 38, 38))
        );

        LocalHazard.addTab("Prone Areas", jPanel3);

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel14.setText("ID");

        txtID3.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N

        tblConditions1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblConditions1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tblConditions1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConditions1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblConditions1);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton14.setText("Add");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton16.setText("Delete");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtID3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton16)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtID3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14)
                    .addComponent(jButton16))
                .addGap(38, 38, 38))
        );

        LocalHazard.addTab("Conditions", jPanel6);

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel17.setText("ID");

        txtID4.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N

        tblInfrastracture1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblInfrastracture1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tblInfrastracture1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInfrastracture1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblInfrastracture1);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton18.setText("Add");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton20.setText("Delete");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtID4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton20))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17))
                    .addComponent(txtID4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton20))
                .addGap(14, 14, 14))
        );

        LocalHazard.addTab("Government Infrastracture", jPanel7);

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel20.setText("ID");

        txt12.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N

        tblServices1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblServices1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tblServices1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServices1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblServices1);

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton22.setText("Add");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton24.setText("Delete");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(txt12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(841, Short.MAX_VALUE)
                        .addComponent(jButton22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton24))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txt12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton22)
                    .addComponent(jButton24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LocalHazard.addTab("Service Within Area", jPanel8);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Adobe Hebrew", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BARANGAY RISK MANAGEMENT SYSTEM");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Person.png"))); // NOI18N
        jLabel6.setText("Active User");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Date.png"))); // NOI18N
        jLabel7.setText("Date Today");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Time.png"))); // NOI18N
        jLabel2.setText("Time");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtActiveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(462, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtActiveUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6))
                    .addComponent(txtTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        ComboBoxDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxDateItemStateChanged(evt);
            }
        });
        ComboBoxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxDateActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Date.png"))); // NOI18N
        jLabel4.setText("Year");

        txtB.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel27.setText("ID");

        txt13.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N

        tblSector1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSector1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tblSector1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSector1MouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tblSector1);

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton27.setText("Add");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton29.setText("Delete");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton29))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27)
                    .addComponent(jButton29)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("Agricultural Sector", jPanel17);

        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel32.setText("ID");

        txt14.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N

        tblLocal1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLocal1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tblLocal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLocal1MouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(tblLocal1);

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton31.setText("Add");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton33.setText("Delete");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(841, Short.MAX_VALUE)
                .addComponent(jButton31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton33)
                .addContainerGap())
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane24)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel32)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 923, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton33)
                    .addComponent(jButton31))
                .addGap(27, 27, 27))
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("LocalHazard", jPanel18);

        jLabel35.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel35.setText("ID");

        txt15.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N

        tblEcenters1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEcenters1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tblEcenters1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEcenters1MouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(tblEcenters1);

        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton35.setText("Add");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton37.setText("Delete");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(840, Short.MAX_VALUE)
                .addComponent(jButton35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton37)
                .addGap(11, 11, 11))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel35)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton35)
                    .addComponent(jButton37))
                .addContainerGap())
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel35)
                        .addComponent(txt15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Evacuation Centers", jPanel19);

        jLabel37.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel37.setText("ID");

        txt16.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N

        tblSignage1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSignage1.setSelectionBackground(new java.awt.Color(51, 51, 255));
        tblSignage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSignage1MouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(tblSignage1);

        jButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton38.setText("Add");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton39.setText("Delete");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGap(0, 831, Short.MAX_VALUE)
                        .addComponent(jButton38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton39))
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jLabel37)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txt16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(918, Short.MAX_VALUE)))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton38)
                    .addComponent(jButton39))
                .addContainerGap())
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37))
                    .addContainerGap(200, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Signage", jPanel20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/View.png"))); // NOI18N
        jButton1.setText("Preview");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Location.png"))); // NOI18N
        jLabel5.setText("Barangay");

        ComboBoxBarangay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxBarangayActionPerformed(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Home.png"))); // NOI18N
        jMenu1.setText("Home");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxBarangay, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(305, 305, 305)
                        .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jButton1))
                    .addComponent(LocalHazard, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(ComboBoxBarangay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)))
                .addComponent(LocalHazard, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      FrmLogin regFace = null;
        regFace = new FrmLogin();
        regFace.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     FrmAbout o = new FrmAbout();
     o.setVisible(true);
    
    }//GEN-LAST:event_jMenuItem2ActionPerformed

  
    public void ComboboxDate(){
    try{
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          conn = java.sql.DriverManager.getConnection(url);
          SQLite.openDB();
          String query = "Select * from (select tblAreas.Date from tblAreas order by tblAreas.ID DESC)\n" +
"union\n" +
"Select * from (select tblDOC.Date from tblDOC order by tblDOC.ID DESC)\n" +
"union\n" +
"Select * from (select tblBDRRMC.Date from tblBDRRMC order by tblBDRRMC.ID DESC)\n" +
"union\n" +
"Select * from (select tblCondition.Date from tblCondition order by tblCondition.ID DESC)\n" +
"union\n" +        
"Select * from (select tblInfrastracture.Date from tblInfrastracture order by tblInfrastracture.ID DESC)";                  
          java.sql.ResultSet rs = null;
          java.sql.PreparedStatement pstmt = null;
          pstmt = conn.prepareStatement(query);
          rs = pstmt.executeQuery();
          while(rs.next()){
              String Position = rs.getString("date");
              ComboBoxDate.addItem(Position);
          }
          SQLite.closeDB();
      }
      catch(Exception e){
          System.out.println("Date Error: " + e.getMessage());
      }}
    
//      public void ComboboxBaranggay(){
//    try{
//          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
//          conn = java.sql.DriverManager.getConnection(url);
//          SQLite.openDB();
//          String query = "Select * from (select tblCondition.Baranggay from tblCondition order by tblCondition.ID DESC)\n" +
//"union\n" +
//"Select * from (select tblInfrastracture.Baranggay from tblInfrastracture order by tblInfrastracture.ID DESC)";
//          java.sql.ResultSet rs = null;
//          java.sql.PreparedStatement pstmt = null;
//          pstmt = conn.prepareStatement(query);
//          rs = pstmt.executeQuery();
//          while(rs.next()){
//              String Position = rs.getString("baranggay");
//              ComboBoxBaranggay.addItem(Position);
//          }
//          SQLite.closeDB();
//      }
//      catch(Exception e){
//          System.out.println("Date Error: " + e.getMessage());
//      }}
//    
      public void ComboboxDistrict(){
    try{
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          conn = java.sql.DriverManager.getConnection(url);
          SQLite.openDB();
          String query = "Select * from (select tblCondition.District from tblCondition order by tblCondition.ID DESC)\n" +
"union\n" +
"Select * from (select tblInfrastracture.District from tblInfrastracture order by tblInfrastracture.ID DESC)\n" +
"union\n" +
"Select * from (select tblBDRRMC.District from tblBDRRMC order by tblBDRRMC.ID DESC)\n" +
"union\n" +
"Select * from (select tblDOC.District from tblDOC order by tblDOC.ID DESC)\n" +
"union\n" +
"Select * from (select tblServices.District from tblServices order by tblServices.ID DESC)\n" +
"union\n" +
"Select * from (select tblSector.District from tblSector order by tblSector.ID DESC)\n" +
"union\n" +
"Select * from (select tblHazard.District from tblHazard order by tblHazard.ID DESC)\n" +
"union\n" +
"Select * from (select tblEcenters.District from tblEcenters order by tblEcenters.ID DESC)\n" +
"union\n" +
"Select * from (select tblSignage.District from tblSignage order by tblSignage.ID DESC)\n" +
"";
          java.sql.ResultSet rs = null;
          java.sql.PreparedStatement pstmt = null;
          pstmt = conn.prepareStatement(query);
          rs = pstmt.executeQuery();
          while(rs.next()){
              String Position = rs.getString("District");
              ComboBoxBarangay.addItem(Position);
          }
          SQLite.closeDB();
      }
      catch(Exception e){
          System.out.println("Date Error: " + e.getMessage());
      }}
   
    private void ComboBoxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxDateActionPerformed
      

    }//GEN-LAST:event_ComboBoxDateActionPerformed

 
    
    
    private void ComboBoxDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxDateItemStateChanged
//        String query = ComboBoxDate.getSelectedItem().toString();
//        if(query!= "None")
//            {
//            pstt.setRowFilter(RowFilter.regexFilter(query));
//            }else
        try{
            String query = "Select * from tblBDRRMC where Date = ?";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rs=pst.executeQuery();
            
            String query1 = "Select * from tblAreas where Date = ?";
            PreparedStatement pstt=conn.prepareStatement(query1);
            pstt.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rss=pstt.executeQuery();
            
            String query2 = "Select * from tblDOC where Date = ?";
            PreparedStatement psttt=conn.prepareStatement(query2);
            psttt.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rsss=psttt.executeQuery();
            
            String query3 = "Select * from tblCondition where Date = ?";
            PreparedStatement pstttt=conn.prepareStatement(query3);
            pstttt.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rssss=pstttt.executeQuery();
             
            String query4 = "Select * from tblInfrastracture where Date = ?";
            PreparedStatement psttttt=conn.prepareStatement(query4);
            psttttt.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rsssss=psttttt.executeQuery();
            
            String query5 = "Select * from tblSignage where Date = ?";
            PreparedStatement pstttttt=conn.prepareStatement(query5);
            pstttttt.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rssssss=pstttttt.executeQuery();
            
            String query6 = "Select * from tblHazard where Date = ?";
            PreparedStatement psttttttt=conn.prepareStatement(query6);
            psttttttt.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rsssssss=psttttttt.executeQuery();
            
            String query7 = "Select * from tblEcenters where Date = ?";
            PreparedStatement pstttttttt=conn.prepareStatement(query7);
            pstttttttt.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rssssssss=pstttttttt.executeQuery();
            
            String query8 = "Select * from tblSector where Date = ?";
            PreparedStatement psttttttttt=conn.prepareStatement(query8);
            psttttttttt.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rsssssssss=psttttttttt.executeQuery();
            
            String query9 = "Select * from tblServices where Date = ?";
            PreparedStatement pstttttttttt=conn.prepareStatement(query9);
            pstttttttttt.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rssssssssss=pstttttttttt.executeQuery();
                       
//            String querya ="Select District from tblBDRRMC where Date = ?";
//            PreparedStatement pss=conn.prepareStatement(querya);
//            pss.setString(9, (String) ComboBoxDate.getSelectedItem());
//            ResultSet sett=pss.executeQuery();
//            txtD.setText(sett.getString("District")); 
//
//            String queryb ="Select Baranggay from tblBDRRMC where Date = ?";
//            PreparedStatement ps=conn.prepareStatement(queryb);
//            ps.setString(8, (String) ComboBoxDate.getSelectedItem());
//            ResultSet set=ps.executeQuery();
//            txtB.setText(set.getString("Baranggay")); 

            tblBDRRMC1.setModel(DbUtils.resultSetToTableModel(rs));
            tblServices1.setModel(DbUtils.resultSetToTableModel(rssssssssss));
            tblSector1.setModel(DbUtils.resultSetToTableModel(rsssssssss));
            tblEcenters1.setModel(DbUtils.resultSetToTableModel(rssssssss));
            tblSignage1.setModel(DbUtils.resultSetToTableModel(rsssssss));
            tblLocal1.setModel(DbUtils.resultSetToTableModel(rssssss));
            tblAreas1.setModel(DbUtils.resultSetToTableModel(rss));
            tblDOC1.setModel(DbUtils.resultSetToTableModel(rsss));
            tblConditions1.setModel(DbUtils.resultSetToTableModel(rssss));
            tblInfrastracture1.setModel(DbUtils.resultSetToTableModel(rsssss));

                       
            pst.close();
            pstt.close();
            psttt.close();
            pstttt.close();
            psttttt.close();
          
        }
        catch (Exception ex){
            ex.printStackTrace();
            
        }
        
        


//        String query = ComboBoxDate.getSelectedItem().toString();
//
//        filter(query);
    }//GEN-LAST:event_ComboBoxDateItemStateChanged

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        FrmAddServiceInArea o = null;
    try {
        o = new FrmAddServiceInArea();
    } catch (SQLException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
        o.setVisible(true);

    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
   int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
            try {
                Class.forName("org.sqlite.JDBC");
//                url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
                conn = java.sql.DriverManager.getConnection(url);
                int row = tblInfrastracture1.getSelectedRow();
                String value = (tblInfrastracture1.getModel().getValueAt(row, 0).toString());
                String query ="DELETE FROM tblInfrastracture where ID = "+value;
                pst = conn.prepareStatement(query);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel)tblInfrastracture1.getModel();
                model.setRowCount(0);
                show_BDRRMC();
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
      FrmAddGovernmentInsfrastracture o = null;
    try {
        o = new FrmAddGovernmentInsfrastracture();
    } catch (SQLException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
        o.setVisible(true);

    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        int s =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (s==0){
            try {
                Class.forName("org.sqlite.JDBC");
//                url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
                conn = java.sql.DriverManager.getConnection(url);
                int row = tblConditions1.getSelectedRow();
                String value = (tblConditions1.getModel().getValueAt(row, 0).toString());
                String query ="DELETE FROM tblCondition where ID = "+value;
                PreparedStatement pst = conn.prepareStatement(query);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel)tblConditions1.getModel();
                model.setRowCount(0);
                show_Condition();
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }SQLite.closeDB();
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        FrmAddConditions o = null;
        try {
            o = new FrmAddConditions();
        } catch (SQLException ex) {
            Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
        }
        o.setVisible(true);

    }//GEN-LAST:event_jButton14ActionPerformed

    private void tblConditions1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConditions1MouseClicked
        int index = tblConditions1.getSelectedRow();
        TableModel model = tblConditions1.getModel();
        txtID3.setText(model.getValueAt(index, 0).toString());
     
    }//GEN-LAST:event_tblConditions1MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
            try {
                Class.forName("org.sqlite.JDBC");
//                url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
                conn = java.sql.DriverManager.getConnection(url);
                int row = tblAreas1.getSelectedRow();
                String value = (tblAreas1.getModel().getValueAt(row, 0).toString());
                String query ="DELETE FROM tblAreas where ID = "+value;
                PreparedStatement pst = conn.prepareStatement(query);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel)tblAreas1.getModel();
                model.setRowCount(0);
                show_Areas();
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        FrmAddFamilieslivinInproneAreas o = null;
        try {
            o = new FrmAddFamilieslivinInproneAreas();
        } catch (SQLException ex) {
            Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
        }
        o.setVisible(true);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void tblAreas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAreas1MouseClicked
        int index = tblAreas1.getSelectedRow();
        TableModel model = tblAreas1.getModel();
        txtID2.setText(model.getValueAt(index, 0).toString());
    }//GEN-LAST:event_tblAreas1MouseClicked

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        int a =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (a==0){
            try {
                Class.forName("org.sqlite.JDBC");
//                url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
                conn = java.sql.DriverManager.getConnection(url);
                int row = tblDOC1.getSelectedRow();
                String value = (tblDOC1.getModel().getValueAt(row, 0).toString());
                String query ="DELETE FROM tblDOC where ID = "+value;
                pst = conn.prepareStatement(query);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel)tblDOC1.getModel();
                model.setRowCount(0);
                show_DOC();
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        FrmAddDisasterOperationsCenter o = null;
        try {
            o = new FrmAddDisasterOperationsCenter();
        } catch (SQLException ex) {
            Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
        }
        o.setVisible(true);

    }//GEN-LAST:event_jButton34ActionPerformed

    private void tblDOC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDOC1MouseClicked
        int index = tblDOC1.getSelectedRow();
        TableModel model = tblDOC1.getModel();
        txtID1.setText(model.getValueAt(index, 0).toString());
    }//GEN-LAST:event_tblDOC1MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            FrmAddBDRRMC o = new FrmAddBDRRMC();
            o.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
            try {
                Class.forName("org.sqlite.JDBC");
//                url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
                conn = java.sql.DriverManager.getConnection(url);
                int row = tblBDRRMC1.getSelectedRow();
                String value = (tblBDRRMC1.getModel().getValueAt(row, 0).toString());
                String query ="DELETE FROM tblBDRRMC where ID = "+value;
                pst = conn.prepareStatement(query);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel)tblBDRRMC1.getModel();
                model.setRowCount(0);
                show_BDRRMC();
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblBDRRMC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBDRRMC1MouseClicked
        int index = tblBDRRMC1.getSelectedRow();
        TableModel model = tblBDRRMC1.getModel();
        txtID.setText(model.getValueAt(index, 0).toString());
        
    }//GEN-LAST:event_tblBDRRMC1MouseClicked

    private void tblInfrastracture1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInfrastracture1MouseClicked
        int index = tblInfrastracture1.getSelectedRow();
        TableModel model = tblInfrastracture1.getModel();
        txtID4.setText(model.getValueAt(index, 0).toString());

    }//GEN-LAST:event_tblInfrastracture1MouseClicked

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
         FrmAddAgriculturalSector o = null;
    try {
        o = new FrmAddAgriculturalSector();
    } catch (SQLException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
        o.setVisible(true);

    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        FrmAddLocalHazardandVulnerabilityMaps o = null;
    try {
        o = new FrmAddLocalHazardandVulnerabilityMaps();
    } catch (SQLException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
        o.setVisible(true);

    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
            FrmAddEvacuationCenters o = null;
    try {
        o = new FrmAddEvacuationCenters();
    } catch (SQLException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
        o.setVisible(true);

    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
              FrmAddSignage o = null;
    try {
        o = new FrmAddSignage();
    } catch (SQLException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
        o.setVisible(true);

    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try{
            String date = javax.swing.JOptionPane.showInputDialog("Please input Date and Barangay ");
            if(SQLite.openDB()){
                 String query = "SELECT * FROM tblDOC WHERE Date = "+date+"";
                 java.sql.ResultSet rs = null;
                 java.sql.PreparedStatement pstmt = null;             
                 pstmt = conn.prepareStatement(query); 
                 rs = pstmt.executeQuery();
                  if(rs.next()){
                        int Date = rs.getInt("Date");
    
              
                      
                      
                      
                      
                      
                      
               javax.swing.JFileChooser dialog = new javax.swing.JFileChooser();
               
                
                String reportName = "src\\BIS\\reportProd.jrxml";
                UIC.Report.viewReport(reportName);
                //UIC.Report.viewReport(jspReport, reportName);
                SQLite.closeDB();
            }

                      
                    }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }           // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboBoxBarangayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxBarangayActionPerformed
         try{
            String query = "Select * from tblBDRRMC where District = ?";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1, (String) ComboBoxBarangay.getSelectedItem());
            ResultSet rs=pst.executeQuery();
            
//            String query1 = "Select District from tblAreas where Date = ?";
//            PreparedStatement pstt=conn.prepareStatement(query1);
//            pstt.setString(1, (String) ComboBoxDate.getSelectedItem());
//            ResultSet rss=pstt.executeQuery();
//            
            String query2 = "Select * from tblDOC where District = ?";
            PreparedStatement psttt=conn.prepareStatement(query2);
            psttt.setString(1, (String) ComboBoxBarangay.getSelectedItem());
            ResultSet rsss=psttt.executeQuery();
            
            String query3 = "Select * from tblCondition where District = ?";
            PreparedStatement pstttt=conn.prepareStatement(query3);
            pstttt.setString(1, (String) ComboBoxBarangay.getSelectedItem());
            ResultSet rssss=pstttt.executeQuery();
             
            String query4 = "Select * from tblInfrastracture where District = ?";
            PreparedStatement psttttt=conn.prepareStatement(query4);
            psttttt.setString(1, (String) ComboBoxBarangay.getSelectedItem());
            ResultSet rsssss=psttttt.executeQuery();
            
            String query5 = "Select * from tblSignage where District = ?";
            PreparedStatement pstttttt=conn.prepareStatement(query5);
            pstttttt.setString(1, (String) ComboBoxBarangay.getSelectedItem());
            ResultSet rssssss=pstttttt.executeQuery();
            
            String query6 = "Select * from tblHazard where District = ?";
            PreparedStatement psttttttt=conn.prepareStatement(query6);
            psttttttt.setString(1, (String) ComboBoxBarangay.getSelectedItem());
            ResultSet rsssssss=psttttttt.executeQuery();
            
            String query7 = "Select * from tblEcenters where District = ?";
            PreparedStatement pstttttttt=conn.prepareStatement(query7);
            pstttttttt.setString(1, (String) ComboBoxBarangay.getSelectedItem());
            ResultSet rssssssss=pstttttttt.executeQuery();
            
            String query8 = "Select * from tblSector where District = ?";
            PreparedStatement psttttttttt=conn.prepareStatement(query8);
            psttttttttt.setString(1, (String) ComboBoxBarangay.getSelectedItem());
            ResultSet rsssssssss=psttttttttt.executeQuery();
            
            String query9 = "Select * from tblServices where District = ?";
            PreparedStatement pstttttttttt=conn.prepareStatement(query9);
            pstttttttttt.setString(1, (String) ComboBoxBarangay.getSelectedItem());
            ResultSet rssssssssss=pstttttttttt.executeQuery();
                       

            tblBDRRMC1.setModel(DbUtils.resultSetToTableModel(rs));
            tblServices1.setModel(DbUtils.resultSetToTableModel(rssssssssss));
            tblSector1.setModel(DbUtils.resultSetToTableModel(rsssssssss));
            tblEcenters1.setModel(DbUtils.resultSetToTableModel(rssssssss));
            tblSignage1.setModel(DbUtils.resultSetToTableModel(rsssssss));
            tblLocal1.setModel(DbUtils.resultSetToTableModel(rssssss));
//            tblAreas1.setModel(DbUtils.resultSetToTableModel(rss));
            tblDOC1.setModel(DbUtils.resultSetToTableModel(rsss));
            tblConditions1.setModel(DbUtils.resultSetToTableModel(rssss));
            tblInfrastracture1.setModel(DbUtils.resultSetToTableModel(rsssss));

                       
            pst.close();
     
            psttt.close();
            pstttt.close();
            psttttt.close();
          
        }
        catch (Exception ex){
            ex.printStackTrace();
            
        }
    }//GEN-LAST:event_ComboBoxBarangayActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        
        int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
        try {
        Class.forName("org.sqlite.JDBC");
//        url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
        conn = java.sql.DriverManager.getConnection(url);    
        int row = tblServices1.getSelectedRow();
        String value = (tblServices1.getModel().getValueAt(row, 0).toString());
        String query ="DELETE FROM tblServices where ID = "+value;
        pst = conn.prepareStatement(query);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)tblServices1.getModel();
        model.setRowCount(0);
        show_BDRRMC();
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }  
        }      
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
       
        int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
        try {
        Class.forName("org.sqlite.JDBC");
//        url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
        conn = java.sql.DriverManager.getConnection(url);    
        int row = tblSector1.getSelectedRow();
        String value = (tblSector1.getModel().getValueAt(row, 0).toString());
        String query ="DELETE FROM tblSector where ID = "+value;
        pst = conn.prepareStatement(query);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)tblSector1.getModel();
        model.setRowCount(0);
        show_BDRRMC();
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }  
        }      
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed

        int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
        try {
        Class.forName("org.sqlite.JDBC");
//        url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
        conn = java.sql.DriverManager.getConnection(url);    
        int row = tblLocal1.getSelectedRow();
        String value = (tblLocal1.getModel().getValueAt(row, 0).toString());
        String query ="DELETE FROM tblLocal where ID = "+value;
        pst = conn.prepareStatement(query);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)tblLocal1.getModel();
        model.setRowCount(0);
        show_BDRRMC();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }  
        }   
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed

        int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
        try {
        Class.forName("org.sqlite.JDBC");
//        url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
        conn = java.sql.DriverManager.getConnection(url);    
        int row = tblEcenters1.getSelectedRow();
        String value = (tblEcenters1.getModel().getValueAt(row, 0).toString());
        String query ="DELETE FROM tblEcenters where ID = "+value;
        pst = conn.prepareStatement(query);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)tblEcenters1.getModel();
        model.setRowCount(0);
        show_BDRRMC();
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }  
        }         
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
       int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
        try {
        Class.forName("org.sqlite.JDBC");
        conn = java.sql.DriverManager.getConnection(url);    
        int row = tblSignage1.getSelectedRow();
        String value = (tblSignage1.getModel().getValueAt(row, 0).toString());
        String query ="DELETE FROM tblSignage where ID = "+value;
        pst = conn.prepareStatement(query);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)tblSignage1.getModel();
        model.setRowCount(0);
        show_BDRRMC();
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }  
        }      
    }//GEN-LAST:event_jButton39ActionPerformed

    private void tblServices1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServices1MouseClicked
        int index = tblServices1.getSelectedRow();
        TableModel model = tblServices1.getModel();
        txt12.setText(model.getValueAt(index, 0).toString());      
    }//GEN-LAST:event_tblServices1MouseClicked

    private void tblSector1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSector1MouseClicked
        int index = tblSector1.getSelectedRow();
        TableModel model = tblSector1.getModel();
        txt13.setText(model.getValueAt(index, 0).toString());      
    }//GEN-LAST:event_tblSector1MouseClicked

    private void tblLocal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLocal1MouseClicked
        int index = tblLocal1.getSelectedRow();
        TableModel model = tblLocal1.getModel();
        txt14.setText(model.getValueAt(index, 0).toString());    
    }//GEN-LAST:event_tblLocal1MouseClicked

    private void tblEcenters1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEcenters1MouseClicked
        int index = tblEcenters1.getSelectedRow();
        TableModel model = tblEcenters1.getModel();
        txt15.setText(model.getValueAt(index, 0).toString());    
    }//GEN-LAST:event_tblEcenters1MouseClicked

    private void tblSignage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSignage1MouseClicked
        int index = tblSignage1.getSelectedRow();
        TableModel model = tblSignage1.getModel();
        txt16.setText(model.getValueAt(index, 0).toString());    
    }//GEN-LAST:event_tblSignage1MouseClicked
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBDRRMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBDRRMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBDRRMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBDRRMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmBDRRMC().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxBarangay;
    private javax.swing.JComboBox<String> ComboBoxDate;
    private javax.swing.JTabbedPane LocalHazard;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tblAreas1;
    private javax.swing.JTable tblBDRRMC1;
    private javax.swing.JTable tblConditions1;
    private javax.swing.JTable tblDOC1;
    private javax.swing.JTable tblEcenters1;
    private javax.swing.JTable tblInfrastracture1;
    private javax.swing.JTable tblLocal1;
    private javax.swing.JTable tblSector1;
    private javax.swing.JTable tblServices1;
    private javax.swing.JTable tblSignage1;
    private javax.swing.JLabel txt12;
    private javax.swing.JLabel txt13;
    private javax.swing.JLabel txt14;
    private javax.swing.JLabel txt15;
    private javax.swing.JLabel txt16;
    public static javax.swing.JLabel txtActiveUser;
    private javax.swing.JLabel txtB;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtID1;
    private javax.swing.JLabel txtID2;
    private javax.swing.JLabel txtID3;
    private javax.swing.JLabel txtID4;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables

    private PdfPCell getCell(Paragraph namefield, int ALIGN_CENTER) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
