/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIS;

import static BIS.SQLite.conn;
import static BIS.SQLite.url;
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
//        ComboboxDistrict();
        CreateColumns();
        this.setLocationRelativeTo(null);     
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        txtDate.setText(dateFormat.format(date));
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat ("hh:mm:ss a");
        txtTime.setText(s.format(d));
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblBDRRMC");
            String[] column = {"ID","BDRRMC","Composition","Composition","ContactNo","Position","No BDRRMC","Baranggay","District","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblBDRRMC1.setModel(model);
            SQLite.closeDB();
        }
           if(SQLite.openDB()){
            String[][] data = SQLite.read("tblDOC");
            String[] column = {"ID","Choice","txt","txt2","Location1","Location","Area","Contact","ContactInfo","Utilities1","Utilities", "Personal","Baranggay","District","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblDOC1.setModel(model);
            SQLite.closeDB();
        }
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblAreas");
            String[] column = {"ID","Hazard","Location","Sitio","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblAreas1.setModel(model);
            SQLite.closeDB();
        }
           if(SQLite.openDB()){
            String[][] data = SQLite.read("tblCondition");
            String[] column = {"ID","Condition","Location","Sitio","Baranggay","District", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblConditions1.setModel(model);
            SQLite.closeDB();
        }               
           if(SQLite.openDB()){
            String[][] data = SQLite.read("tblInfrastracture");
            String[] column = {"ID","Infrastracture","Location","Sitio","Baranggay","District", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblInfrastracture1.setModel(model);
            SQLite.closeDB();
        }
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblHazard");
            String[] column = {"ID","Flood Hazard Map","Coastal & Island Map","LandSlide Hazard Map","Riverbanks & Waterways Map","Fire Hazard Map","Baranggay","District", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblLocal1.setModel(model);
            SQLite.closeDB();
        }
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblServices");
            String[] column = {"ID","Type","others","Location","Units","Baranggay","District","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblServices1.setModel(model);
            SQLite.closeDB();
        }
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblEcenters");
            String[] column = {"ID","Type","Location","Capacity","Suitability","Availability","Baranggay","District", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblEcenters1.setModel(model);
            SQLite.closeDB();
        }
            if(SQLite.openDB()){
            String[][] data = SQLite.read("tblSignage");
            String[] column = {"ID","Type","Location","Units","Material_used","Baranggay","District","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblSignage1.setModel(model);
            SQLite.closeDB();
        }
              if(SQLite.openDB()){
            String[][] data = SQLite.read("tblSector");
            String[] column = {"ID","Sitio","Farmers","Farm_land","Fish_farmers","Land_area","Livestock","Type_of_livestock","Baranggay", "District"," date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblSector1.setModel(model);
            SQLite.closeDB();
        }
            }
         
    private void CreateColumns()
    {
        dm=(DefaultTableModel) tblBDRRMC1.getModel();
        dm.addColumn("ID");
        dm.addColumn("Composition_of_BDRRMC");
        dm.addColumn("Composition");
        dm.addColumn("ContactNo");
        dm.addColumn("Position");
    }
    
//    private void Populate(Int ID, String Composition_of_BDRRMC, String Composition, String ContactNo, String Position)
//    {
//        String[] rowData={ID,Composition_of_BDRRMC,Composition, ContactNo,Position};
//        dm.addRow(rowData);
//    }

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
            row[7] = list.get(i).getBaranggay();
            row[8] = list.get(i).getDistrict();
            row[9] = list.get(i).getDate();
            model.addRow(row);
        }
    }
    
    public ArrayList <BDRRMC> BDRRMCList() throws SQLException, ClassNotFoundException{
       ArrayList<BDRRMC> BDRRMCList = new ArrayList<>();
        try{
            Class.forName("org.sqlite.JDBC");
             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
             conn = java.sql.DriverManager.getConnection(url);
             String query = "Select * from tblBDRRMC";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             BDRRMC bdrrmc;
             while(rs.next()){
                 bdrrmc = new BDRRMC (rs.getInt("ID"),rs.getString("choices"),rs.getString("Composition_of_BDRRMC"),rs.getString("Composition"),rs.getString("ContactNo"),rs.getString("Position"),rs.getString("No"),rs.getString("Baranggay"),rs.getString("District"),rs.getString("Date"));
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
             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
    
//    private void filter (String query)
//    {
//         
//        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
//        tblBDRRMC1.setRowSorter(tr);
//        tblAreas1.setRowSorter(tr);
//        tblInfrastracture1.setRowSorter(tr);
//        tblDOC1.setRowSorter(tr);
//        tblConditions1.setRowSorter(tr);
//        if(query != "All year") {
//        tr.setRowFilter(RowFilter.regexFilter(query));
//        }else
//        {
//        tblInfrastracture1.setRowSorter(tr);
//        tblBDRRMC1.setRowSorter(tr);
//        tblAreas1.setRowSorter(tr);
//        tblDOC1.setRowSorter(tr);
//        tblConditions1.setRowSorter(tr);
//        }
//    }
    
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
             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
        jLabel21 = new javax.swing.JLabel();
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
        jButton41 = new javax.swing.JButton();
        ComboBoxDate = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtB = new javax.swing.JLabel();
        txtD = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblSector1 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tblLocal1 = new javax.swing.JTable();
        jButton31 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tblEcenters1 = new javax.swing.JTable();
        jButton35 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        tblSignage1 = new javax.swing.JTable();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        jTable21 = new javax.swing.JTable();
        jButton40 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        jTable22 = new javax.swing.JTable();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        jTable23 = new javax.swing.JTable();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane30 = new javax.swing.JScrollPane();
        jTable24 = new javax.swing.JTable();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
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

        tblBDRRMC1.setBackground(new java.awt.Color(240, 240, 240));
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
        tblBDRRMC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBDRRMC1MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblBDRRMC1);

        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel33.setText("ID");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Edit");
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
                .addContainerGap(809, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LocalHazard.addTab("BDRRMC", jPanel1);

        tblDOC1.setBackground(new java.awt.Color(240, 240, 240));
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

        jButton34.setText("Edit");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton34)
                .addGap(18, 18, 18)
                .addComponent(jButton36)
                .addGap(12, 12, 12))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton34)
                    .addComponent(jButton36))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LocalHazard.addTab("Disaster Operations Center", jPanel2);

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel11.setText("ID");

        tblAreas1.setBackground(new java.awt.Color(240, 240, 240));
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
        tblAreas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAreas1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblAreas1);

        txtID2.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        txtID2.setText("0");

        jButton10.setText("Edit");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtID2))
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
        txtID3.setText("0");

        tblConditions1.setBackground(new java.awt.Color(240, 240, 240));
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
        tblConditions1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConditions1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblConditions1);

        jButton14.setText("Edit");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtID3)
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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtID3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14)
                    .addComponent(jButton16))
                .addGap(38, 38, 38))
        );

        LocalHazard.addTab("Conditions", jPanel6);

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel17.setText("ID");

        txtID4.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        txtID4.setText("0");

        tblInfrastracture1.setBackground(new java.awt.Color(240, 240, 240));
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
        tblInfrastracture1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInfrastracture1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblInfrastracture1);

        jButton18.setText("Edit");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

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
                        .addComponent(txtID4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton20))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtID4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton20))
                .addGap(38, 38, 38))
        );

        LocalHazard.addTab("Government Infrastracture", jPanel7);

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel20.setText("ID");

        jLabel21.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel21.setText("0");

        tblServices1.setBackground(new java.awt.Color(240, 240, 240));
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
        jScrollPane7.setViewportView(tblServices1);

        jButton22.setText("Edit");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton24.setText("Delete");

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
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(812, Short.MAX_VALUE)
                        .addComponent(jButton22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton24))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton22)
                    .addComponent(jButton24))
                .addGap(60, 60, 60))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Active User");

        jLabel7.setText("Date Today");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jButton41.setText("Print");

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
        jLabel4.setText("Year");

        txtB.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        txtD.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel27.setText("ID");

        jLabel28.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel28.setText("0");

        tblSector1.setBackground(new java.awt.Color(240, 240, 240));
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
        jScrollPane18.setViewportView(tblSector1);

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel31.setText("Grand Total");

        jButton27.setText("Edit");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton29.setText("Delete");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton29))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27)
                    .addComponent(jButton29)
                    .addComponent(jLabel31)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("Agricultural Sector", jPanel17);

        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel32.setText("ID");

        jLabel34.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel34.setText("0");

        tblLocal1.setBackground(new java.awt.Color(240, 240, 240));
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
        jScrollPane24.setViewportView(tblLocal1);

        jButton31.setText("Edit");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton33.setText("Delete");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 952, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane24)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel18Layout.createSequentialGroup()
                                    .addGap(812, 812, 812)
                                    .addComponent(jButton31)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton33))
                                .addGroup(jPanel18Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel32)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel34)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(jLabel32))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton31)
                        .addComponent(jButton33))
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("LocalHazard", jPanel18);

        jLabel35.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel35.setText("ID");

        jLabel36.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel36.setText("0");

        tblEcenters1.setBackground(new java.awt.Color(240, 240, 240));
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
        jScrollPane25.setViewportView(tblEcenters1);

        jButton35.setText("Edit");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton37.setText("Delete");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(811, Short.MAX_VALUE)
                .addComponent(jButton35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton37)
                .addGap(11, 11, 11))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane25)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel35)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel36)
                            .addGap(0, 869, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton35)
                    .addComponent(jButton37))
                .addContainerGap())
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(jLabel35))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(57, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Evacuation Centers", jPanel19);

        jLabel37.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel37.setText("ID");

        jLabel38.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel38.setText("0");

        tblSignage1.setBackground(new java.awt.Color(240, 240, 240));
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
        jScrollPane26.setViewportView(tblSignage1);

        jButton38.setText("Edit");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setText("Delete");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 952, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane26)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel20Layout.createSequentialGroup()
                                    .addGap(812, 812, 812)
                                    .addComponent(jButton38)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton39))
                                .addGroup(jPanel20Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel37)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel38)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(jLabel37))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton38)
                        .addComponent(jButton39))
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Signage", jPanel20);

        jLabel39.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel39.setText("ID");

        jLabel40.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel40.setText("0");

        jTable21.setBackground(new java.awt.Color(240, 240, 240));
        jTable21.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane27.setViewportView(jTable21);

        jButton40.setText("Edit");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton42.setText("Delete");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 952, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane27)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addGap(812, 812, 812)
                                    .addComponent(jButton40)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton42))
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel39)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel40)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(jLabel39))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton40)
                        .addComponent(jButton42))
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("List Of Equipment", jPanel21);

        jLabel41.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel41.setText("ID");

        jLabel42.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel42.setText("0");

        jTable22.setBackground(new java.awt.Color(240, 240, 240));
        jTable22.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane28.setViewportView(jTable22);

        jButton43.setText("Edit");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.setText("Delete");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 952, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane28)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel22Layout.createSequentialGroup()
                                    .addGap(812, 812, 812)
                                    .addComponent(jButton43)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton44))
                                .addGroup(jPanel22Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel41)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel42)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(jLabel41))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton43)
                        .addComponent(jButton44))
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Early Warning Device", jPanel22);

        jLabel43.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel43.setText("ID");

        jLabel44.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel44.setText("0");

        jTable23.setBackground(new java.awt.Color(240, 240, 240));
        jTable23.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane29.setViewportView(jTable23);

        jButton45.setText("Edit");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton46.setText("Delete");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 952, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane29)
                        .addGroup(jPanel23Layout.createSequentialGroup()
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel23Layout.createSequentialGroup()
                                    .addGap(812, 812, 812)
                                    .addComponent(jButton45)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton46))
                                .addGroup(jPanel23Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel43)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel44)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel44)
                        .addComponent(jLabel43))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton45)
                        .addComponent(jButton46))
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Traning & Drills", jPanel23);

        jLabel45.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel45.setText("ID");

        jLabel46.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel46.setText("0");

        jTable24.setBackground(new java.awt.Color(240, 240, 240));
        jTable24.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane30.setViewportView(jTable24);

        jButton47.setText("Edit");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton48.setText("Delete");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 952, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane30)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel24Layout.createSequentialGroup()
                                    .addGap(812, 812, 812)
                                    .addComponent(jButton47)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton48))
                                .addGroup(jPanel24Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel45)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel46)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(jLabel45))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton47)
                        .addComponent(jButton48))
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Emergency Kit", jPanel24);

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
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(249, 249, 249)
                        .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LocalHazard, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton41)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LocalHazard, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    close();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     FrmAbout o = new FrmAbout();
     o.setVisible(true);
    
    }//GEN-LAST:event_jMenuItem2ActionPerformed

  
    public void ComboboxDate(){
    try{
          Class.forName("org.sqlite.JDBC");
          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
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
//      public void ComboboxDistrict(){
//    try{
//          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
//          conn = java.sql.DriverManager.getConnection(url);
//          SQLite.openDB();
//          String query = "Select * from (select tblCondition.District from tblCondition order by tblCondition.ID DESC)\n" +
//"union\n" +
//"Select * from (select tblInfrastracture.District from tblInfrastracture order by tblInfrastracture.ID DESC)";
//          java.sql.ResultSet rs = null;
//          java.sql.PreparedStatement pstmt = null;
//          pstmt = conn.prepareStatement(query);
//          rs = pstmt.executeQuery();
//          while(rs.next()){
//              String Position = rs.getString("District");
//              ComboBoxDistrict.addItem(Position);
//          }
//          SQLite.closeDB();
//      }
//      catch(Exception e){
//          System.out.println("Date Error: " + e.getMessage());
//      }}
//   
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
                url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
            }
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
                url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
                url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
                url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton47ActionPerformed
    
    
    
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
    private javax.swing.JComboBox<String> ComboBoxDate;
    private javax.swing.JTabbedPane LocalHazard;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
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
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
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
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
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
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable21;
    private javax.swing.JTable jTable22;
    private javax.swing.JTable jTable23;
    private javax.swing.JTable jTable24;
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
    public static javax.swing.JLabel txtActiveUser;
    private javax.swing.JLabel txtB;
    private javax.swing.JLabel txtD;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtID1;
    private javax.swing.JLabel txtID2;
    private javax.swing.JLabel txtID3;
    private javax.swing.JLabel txtID4;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables
}
