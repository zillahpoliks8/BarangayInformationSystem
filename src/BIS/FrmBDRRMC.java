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
            String[] column = {"ID","BDRRMC","Composition_of_BDRRMC","Composition","ContactNo","Position","No BDRRMC","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblBDRRMC1.setModel(model);
            SQLite.closeDB();
        }
           if(SQLite.openDB()){
            String[][] data = SQLite.read("tblDOC");
            String[] column = {"ID","Choice","txt","txt2","Location1","Location","Area","Contact","ContactInfo","Utilities1","Utilities", "Personal","Date"};
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
            String[] column = {"ID","Condition","Location","Sitio", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblConditions1.setModel(model);
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
        Object [] row = new Object [8];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getChoices();
            row[2] = list.get(i).getComposition_of_BDRRMC();
            row[3] = list.get(i).getComposition();
            row[4] = list.get(i).getContactNo();
            row[5] = list.get(i).getPosition();
            row[6] = list.get(i).getNo();
            row[7] = list.get(i).getDate();
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
                 bdrrmc = new BDRRMC (rs.getInt("ID"),rs.getString("choices"),rs.getString("Composition_of_BDRRMC"),rs.getString("Composition"),rs.getString("ContactNo"),rs.getString("Position"),rs.getString("No"),rs.getString("Date"));
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
       Object [] row = new Object [5];
        for (int i = 1; i < list.size();i++){
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getCondition();
            row[2] = list.get(i).getLocation();
            row[3] = list.get(i).getSitio();   
            row[4] = list.get(i).getDate();
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
                 conditions = new FamilieslivingInConditions (rs.getInt("ID"),rs.getString("Condition"),rs.getString("Location"),rs.getInt("Sitio"),rs.getString("Date"));
                 ConditionsList.add(conditions);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return ConditionsList;
    }
         
    private void filter (String query)
    {
          
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
        tblBDRRMC1.setRowSorter(tr);
        tblAreas1.setRowSorter(tr);
        
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
        tblFacilities1 = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton22 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton26 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtActiveUser = new javax.swing.JLabel();
        ComboBoxDate = new javax.swing.JComboBox<>();
        jButton41 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MAIN");

        LocalHazard.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(102, 0, 51));

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
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
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
        txtID.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete))
                .addGap(30, 30, 30))
        );

        LocalHazard.addTab("BDRRMC", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

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
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("ID");

        txtID1.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        txtID1.setForeground(new java.awt.Color(255, 255, 255));

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
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton34)
                    .addComponent(jButton36))
                .addGap(38, 38, 38))
        );

        LocalHazard.addTab("Disaster Operations Center", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
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
        txtID2.setForeground(new java.awt.Color(255, 255, 255));
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
                        .addGap(18, 18, 18)
                        .addComponent(jButton12))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton12))
                .addGap(38, 38, 38))
        );

        LocalHazard.addTab("Prone Areas", jPanel3);

        jPanel6.setBackground(new java.awt.Color(51, 51, 0));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ID");

        txtID3.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        txtID3.setForeground(new java.awt.Color(255, 255, 255));
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
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(jButton16))
                .addGap(38, 38, 38))
        );

        LocalHazard.addTab("Conditions", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("ID");

        txtID4.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        txtID4.setForeground(new java.awt.Color(255, 255, 255));
        txtID4.setText("0");

        tblFacilities1.setBackground(new java.awt.Color(240, 240, 240));
        tblFacilities1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tblFacilities1);

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
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE))
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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton20))
                .addGap(38, 38, 38))
        );

        LocalHazard.addTab("Government Infrastracture", jPanel7);

        jPanel8.setBackground(new java.awt.Color(102, 0, 0));

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ID");

        jLabel21.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("0");

        jTable6.setBackground(new java.awt.Color(240, 240, 240));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable6);

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
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton24))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22)
                    .addComponent(jButton24))
                .addGap(38, 38, 38))
        );

        LocalHazard.addTab("Service Within Area", jPanel8);

        jPanel9.setBackground(new java.awt.Color(102, 0, 102));

        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("ID");

        jLabel24.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("0");

        jTable7.setBackground(new java.awt.Color(240, 240, 240));
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable7);

        jButton26.setText("Edit");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton28.setText("Delete");

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Grand Total");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(33, 33, 33)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton28))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton26)
                    .addComponent(jButton28)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(38, 38, 38))
        );

        LocalHazard.addTab("Agricultural Sector", jPanel9);

        jPanel10.setBackground(new java.awt.Color(0, 102, 153));

        jTable8.setBackground(new java.awt.Color(240, 240, 240));
        jTable8.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(jTable8);

        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("ID");

        jLabel26.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("0");

        jButton30.setText("Edit");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton32.setText("Delete");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton30)
                        .addGap(18, 18, 18)
                        .addComponent(jButton32)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton30)
                    .addComponent(jButton32))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        LocalHazard.addTab("LocalHazard", jPanel10);

        jTable9.setBackground(new java.awt.Color(240, 240, 240));
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(jTable9);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        LocalHazard.addTab("Evacuation Centers", jPanel11);

        jTable10.setBackground(new java.awt.Color(240, 240, 240));
        jTable10.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane13.setViewportView(jTable10);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        LocalHazard.addTab("Signage", jPanel12);

        jTable11.setBackground(new java.awt.Color(240, 240, 240));
        jTable11.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(jTable11);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        LocalHazard.addTab("List Of Equipment", jPanel13);

        jTable12.setBackground(new java.awt.Color(240, 240, 240));
        jTable12.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane15.setViewportView(jTable12);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        LocalHazard.addTab("Early Warning Device", jPanel14);

        jTable13.setBackground(new java.awt.Color(240, 240, 240));
        jTable13.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane16.setViewportView(jTable13);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        LocalHazard.addTab("Training & Drills", jPanel15);

        jTable14.setBackground(new java.awt.Color(240, 240, 240));
        jTable14.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane17.setViewportView(jTable14);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        LocalHazard.addTab("Emergency Kit", jPanel16);

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

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Year");

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
                .addGap(46, 46, 46)
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
                .addContainerGap(22, Short.MAX_VALUE)
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

        jButton41.setText("Print");

        jMenu1.setText("Home");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("History");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(328, 328, 328)
                        .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(LocalHazard, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41))
                .addGap(18, 18, 18)
                .addComponent(LocalHazard, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    close();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     FrmHistoryofdata o = new FrmHistoryofdata();
     o.setVisible(true);
   
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     FrmAbout o = new FrmAbout();
     o.setVisible(true);
    
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void show_DOC() throws SQLException, ClassNotFoundException{
        ArrayList<DisasterOperationsCenter> list = DOCList();
        DefaultTableModel model = (DefaultTableModel)tblDOC1.getModel();
        Object [] row = new Object [13];
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
            row[12] = list.get(i).getDate();
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
                 doc = new DisasterOperationsCenter (rs.getInt("ID"),rs.getString("Choice"),rs.getString("txt"),rs.getString("txt2"),rs.getString("Location"),rs.getString("Location1"),rs.getString("Area"),rs.getString("ContactNo"),rs.getString("ContactNo1"),rs.getString("Utilities"),rs.getString("Utilities1"),rs.getString("Personal"),rs.getString("Date"));
                 DOCList.add(doc);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return DOCList;
    }
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
"Select * from (select tblCondition.Date from tblCondition order by tblCondition.ID DESC)";
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
    
   
    private void ComboBoxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxDateActionPerformed
      

    }//GEN-LAST:event_ComboBoxDateActionPerformed

 
    
    
    private void ComboBoxDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxDateItemStateChanged
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
             
            tblBDRRMC1.setModel(DbUtils.resultSetToTableModel(rs));
            tblAreas1.setModel(DbUtils.resultSetToTableModel(rss));
            tblDOC1.setModel(DbUtils.resultSetToTableModel(rsss));
            tblConditions1.setModel(DbUtils.resultSetToTableModel(rssss));
            pst.close();
            pstt.close();
            psttt.close();
            pstttt.close();
            
        }
        catch (Exception ex){
            ex.printStackTrace();
            
        }
        
        


//        String query = ComboBoxDate.getSelectedItem().toString();
//
//        filter(query);
    }//GEN-LAST:event_ComboBoxDateItemStateChanged

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        FrmAddLocalHazardandVulnerabilityMaps o = new FrmAddLocalHazardandVulnerabilityMaps();
        o.setVisible(true);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        FrmAddAgriculturalSector o = new FrmAddAgriculturalSector();
        o.setVisible(true);

    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        FrmAddServiceInArea o = new FrmAddServiceInArea();
        o.setVisible(true);

    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed

    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        FrmAddGovernmentInsfrastracture o = new FrmAddGovernmentInsfrastracture();
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
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton41;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable14;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTable tblAreas1;
    private javax.swing.JTable tblBDRRMC1;
    private javax.swing.JTable tblConditions1;
    private javax.swing.JTable tblDOC1;
    private javax.swing.JTable tblFacilities1;
    public static javax.swing.JLabel txtActiveUser;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtID1;
    private javax.swing.JLabel txtID2;
    private javax.swing.JLabel txtID3;
    private javax.swing.JLabel txtID4;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables
}
