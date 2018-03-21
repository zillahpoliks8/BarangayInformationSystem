/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIS;

import static BIS.SQLite.conn;
import static BIS.SQLite.url;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class FrmAddDisasterOperationsCenter extends javax.swing.JFrame {

    /**
     * Creates new form frmDisasterOperationsCenter
     */
    public FrmAddDisasterOperationsCenter() throws SQLException, ClassNotFoundException {
        initComponents();
        ComboboxDate();
        show_DOC();
//        Fillcombo();
        this.setLocationRelativeTo(null);
         if(SQLite.openDB()){
            String[][] data = SQLite.read("tblDOC");
            String[] column = {"ID","DOC","24/7 Operation Center","Others","Location","Name","Land Area","Contact","ContactNumber","Utilities Available","Name", "Personnel-in-Charge","District","Barangay","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblDOC1.setModel(model);
            SQLite.closeDB();
        }
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
        public void clear (){
            txtLocation.setText("");
            txtArea.setText("");
            txtContactNo.setText("");
            txtUtilities.setText("");
            txtPersonal.setText("");
            jText.setText("");
            jText2.setText("");         
        }
        
        public void ComboboxDate(){
     try{
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          conn = java.sql.DriverManager.getConnection(url);
          SQLite.openDB();
          String query = "Select DISTINCT Date from tblDOC";
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
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDOC1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtPersonal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        ComboBoxDate = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jText2 = new javax.swing.JTextField();
        rno = new javax.swing.JRadioButton();
        ryes = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ComboBoxNo = new javax.swing.JComboBox<>();
        txtContactNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtUtilities = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ComboBoxUtilities = new javax.swing.JComboBox<>();
        txtLocation = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ComboBoxLocation = new javax.swing.JComboBox<>();
        txtDist = new javax.swing.JTextField();
        txtPob = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Disaster Operations Center");
        setBackground(new java.awt.Color(0, 153, 153));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Disaster Operations Center"));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Date.png"))); // NOI18N
        jLabel2.setText("Date");

        txtArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaActionPerformed(evt);
            }
        });

        jLabel5.setText("Land/Floor area");

        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

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
        jScrollPane1.setViewportView(tblDOC1);

        jLabel3.setText("Personal-in-charge");

        txtPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonalActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Back.png"))); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Update User.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        btnClear.setText("New");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Year");

        ComboBoxDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxDateItemStateChanged(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("If Yes"));

        jLabel4.setText("24/7 Operation");

        jLabel1.setText("Others (Pls Specify)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jText, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jText2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        buttonGroup1.add(rno);
        rno.setText("No");
        rno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnoActionPerformed(evt);
            }
        });

        buttonGroup1.add(ryes);
        ryes.setText("Yes");
        ryes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ryesActionPerformed(evt);
            }
        });

        jLabel6.setText("Disaster/Emergency Operations Center:");

        jLabel8.setText("Barangay");

        jLabel9.setText("District");

        ComboBoxNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Land line", "Mobile", "Frequency No", "Fax Machine", "Email Address" }));

        txtContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactNoActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Contact.png"))); // NOI18N
        jLabel11.setText("Contact Number");

        jLabel10.setText("Utilities Available");

        ComboBoxUtilities.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electricity", "Water" }));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Location.png"))); // NOI18N
        jLabel12.setText("Location");

        ComboBoxLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Main", "Alternate" }));
        ComboBoxLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxLocationActionPerformed(evt);
            }
        });

        txtDist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(25, 25, 25)
                                .addComponent(ryes)
                                .addGap(18, 18, 18)
                                .addComponent(rno))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(txtPob, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboBoxLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ComboBoxNo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(9, 9, 9)
                                .addComponent(ComboBoxUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtUtilities, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPersonal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDist, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(302, 302, 302)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ryes)
                            .addComponent(rno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton2)
                    .addComponent(btnClear)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addGap(125, 125, 125)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtLocation.setText("");
        txtArea.setText("");
        txtContactNo.setText("");
        txtUtilities.setText("");
        txtPersonal.setText("");
        jText.setText("");
        jText2.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            Class.forName("org.sqlite.JDBC");
//            url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
            conn = java.sql.DriverManager.getConnection(url);
            int row = tblDOC1.getSelectedRow();
            String value = (tblDOC1.getModel().getValueAt(row, 0).toString());
            String query ="Update tblDOC set Choice = ?, txt = ?, txt2 = ?, Location = ?,Location1 = ?,Area = ?,ContactNo = ?,ContactNo1 = ?,Utilities = ?,Utilities1 = ?, Personal = ?, Baranggay = ?, District =?, Date = ? where ID = "+value;
            PreparedStatement pst = null;
            pst = conn.prepareStatement(query);
         ryes.setActionCommand("Yes");
            rno.setActionCommand("No");
            String choices;
            choices = buttonGroup1.getSelection().getActionCommand();
            String Location;
            Location = ComboBoxLocation.getSelectedItem().toString();
//            String Baranggay;
//            Baranggay = JComboPob.getSelectedItem().toString(); 
//            String District;
//            District = jComboDist.getSelectedItem().toString();
            pst.setString(4, Location);
            pst.setString(1, choices);
            pst.setString(2, jText.getText());
            pst.setString(3, jText2.getText());
            pst.setString(5, txtLocation.getText());
            pst.setString(6, txtArea.getText());
            String ContactNo;
            ContactNo = ComboBoxNo.getSelectedItem().toString();
            pst.setString(7, ContactNo);
            pst.setString(8, txtContactNo.getText());
            String Utilities;
            Utilities = ComboBoxUtilities.getSelectedItem().toString();
            pst.setString(9,Utilities);
            pst.setString(10, txtUtilities.getText());
            pst.setString(11, txtPersonal.getText());
            pst.setString(12, txtPob.getText());
            pst.setString(13, txtDist.getText());
//            pst.setString(12,Baranggay);
//            pst.setString(13,District);
            SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
            String date = dFormat.format(jDateChooser1.getDate());
            pst.setString(14, date);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)tblDOC1.getModel();
            model.setRowCount(1);
            show_DOC();
            JOptionPane.showMessageDialog(null, "Updated Successfully");
            clear();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  
        FrmBDRRMC o = null;
    try {
        o = new FrmBDRRMC();
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
     o.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
            try {
                Class.forName("org.sqlite.JDBC");
//                url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
                conn = java.sql.DriverManager.getConnection(url);
                int row = tblDOC1.getSelectedRow();
                String value = (tblDOC1.getModel().getValueAt(row, 0).toString());
                String query ="DELETE FROM tblDOC where ID = "+value;
                PreparedStatement pst = conn.prepareStatement(query);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel)tblDOC1.getModel();
                model.setRowCount(0);
                show_DOC();
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
                clear();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Class.forName("org.sqlite.JDBC");
//            url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
            conn = java.sql.DriverManager.getConnection(url);
            String query ="Insert into tblDOC(Choice,txt,txt2,Location,Location1,Area,ContactNo,ContactNo1,Utilities,Utilities1, Personal,Baranggay,District,Date)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = null;
            pst = conn.prepareStatement(query);
            ryes.setActionCommand("Yes");
            rno.setActionCommand("No");
            String choices;
            choices = buttonGroup1.getSelection().getActionCommand();
            String Location;
            Location = ComboBoxLocation.getSelectedItem().toString();
//            String Baranggay;
//            Baranggay = JComboPob.getSelectedItem().toString(); 
//            String District;
//            District = jComboDist.getSelectedItem().toString();
            pst.setString(4, Location);
            pst.setString(1, choices);
            pst.setString(2, jText.getText());
            pst.setString(3, jText2.getText());
            pst.setString(5, txtLocation.getText());
            pst.setString(6, txtArea.getText());
            String ContactNo;
            ContactNo = ComboBoxNo.getSelectedItem().toString();
            pst.setString(7, ContactNo);
            pst.setString(8, txtContactNo.getText());
            String Utilities;
            Utilities = ComboBoxUtilities.getSelectedItem().toString();
            pst.setString(9,Utilities);
            pst.setString(10, txtUtilities.getText());
            pst.setString(11, txtPersonal.getText());
            pst.setString(12, txtPob.getText());
            pst.setString(13, txtDist.getText());
//            pst.setString(12,Baranggay);
//            pst.setString(13,District);
            SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
            String date = dFormat.format(jDateChooser1.getDate());
            pst.setString(14, date);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)tblDOC1.getModel();
            model.setRowCount(1);
            show_DOC();
            JOptionPane.showMessageDialog(null, "Added Successfully");
            clear();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblDOC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDOC1MouseClicked

        int index = tblDOC1.getSelectedRow();
        TableModel model = tblDOC1.getModel();
        //      txtID.setText(model.getValueAt(index, 0).toString());
        txtLocation.setText(model.getValueAt(index, 5).toString());
        Date date = null;
        try {
        date = new SimpleDateFormat("yyyy").parse(model.getValueAt(index, 14).toString());
           } catch (ParseException ex) {
               Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
           }
        jDateChooser1.setDate(date);
              String buttonGroup6 = model.getValueAt (index, 1).toString();
        if(buttonGroup6.equals("Yes"))
        {
        ryes.setSelected(true);
         jText2.setEnabled(true);
         jText2.setBackground(Color.WHITE); 
         jText.setEnabled(true);
         jText.setBackground(Color.WHITE);
            }
        else{
       rno.setSelected(true);
        jText2.setEnabled(false);
        jText2.setBackground(Color.GRAY); 
        jText.setEnabled(false);
        jText.setBackground(Color.GRAY);
        jText.setText("");
        jText2.setText("");
            }
        jText.setText(model.getValueAt(index,2).toString());
        jText2.setText(model.getValueAt(index,3).toString());
        String Location = model.getValueAt (index, 4).toString();
        switch(Location){

            case "Main":
            ComboBoxLocation.setSelectedIndex(0);
            break;

            case "Alternate":
            ComboBoxLocation.setSelectedIndex(1);
            break;

        }

        txtArea.setText(model.getValueAt(index, 6).toString());

        txtContactNo.setText(model.getValueAt(index, 8).toString());

        String ContactNo = model.getValueAt (index, 7).toString();
        switch(ContactNo){

            case "Land line":
            ComboBoxNo.setSelectedIndex(0);
            break;

            case "Mobile":
            ComboBoxNo.setSelectedIndex(1);
            break;

            case "Frequency No":
            ComboBoxNo.setSelectedIndex(2);
            break;

            case "Fax Machine":
            ComboBoxNo.setSelectedIndex(3);
            break;

            case "Email Address":
            ComboBoxNo.setSelectedIndex(4);
            break;

        }

        txtUtilities.setText(model.getValueAt(index, 10).toString());

        String Utilities = model.getValueAt (index, 9).toString();
        switch(Utilities){

            case "Electricity":
            ComboBoxNo.setSelectedIndex(0);
            break;

            case "Water":
            ComboBoxNo.setSelectedIndex(1);
            break;
        }
        txtPersonal.setText(model.getValueAt(index, 11).toString());
        
        txtPob.setText(model.getValueAt(index, 12).toString());
        txtDist.setText(model.getValueAt(index, 13).toString());
//         String Baranggay = model.getValueAt (index, 12).toString();
//            switch(Baranggay){
//        
//            case "Poblacion":
//            JComboPob.setSelectedIndex(0);
//            break;
//            
//            case "Talomo":
//            JComboPob.setSelectedIndex(1);
//            break;
//            
//            case "Agdao":
//            JComboPob.setSelectedIndex(2);
//            break;
//            
//            case "Buhangin":
//            JComboPob.setSelectedIndex(3);
//            break;
//            
//            case "Bunawan":
//            JComboPob.setSelectedIndex(4);
//            break;
//            
//            case "Paquibato":
//            JComboPob.setSelectedIndex(5);
//            break;
//            
//            case "Baguio":
//            JComboPob.setSelectedIndex(6);
//            break;
//            
//            case "Calinan":
//            JComboPob.setSelectedIndex(7);
//            break;
//                    
//            case "Marilog":
//            JComboPob.setSelectedIndex(8);
//            break;
//            
//            case "Toril":
//            JComboPob.setSelectedIndex(9);
//            break;
//            
//            case "Tugbok":
//            JComboPob.setSelectedIndex(10);
//            break;
//            
//                }
//        
//          String District = model.getValueAt (index, 13).toString();
//            switch(District){
//        
//            case "1-A":
//            jComboDist.setSelectedIndex(0);
//            break;
//            
//            case "2-A":
//            jComboDist.setSelectedIndex(1);
//            break;
//            
//            case "3-A":
//            jComboDist.setSelectedIndex(2);
//            break;
//            
//            case "4-A":
//            jComboDist.setSelectedIndex(3);
//            break;
//            
//            case "5-A":
//            jComboDist.setSelectedIndex(4);
//            break;
//            
//            case "6-A":
//            jComboDist.setSelectedIndex(5);
//            break;
//            
//            case "7-A":
//            jComboDist.setSelectedIndex(6);
//            break;
//            
//            case "8-A":
//            jComboDist.setSelectedIndex(7);
//            break;
//                    
//            case "9-A":
//            jComboDist.setSelectedIndex(8);
//            break;
//            
//            case "10-A":
//            jComboDist.setSelectedIndex(9);
//            break;
//            
//            case "11-B":
//            jComboDist.setSelectedIndex(10);
//            break;
//            
//            case "12-B":
//            jComboDist.setSelectedIndex(11);
//            break;
//            
//            case "13-B":
//            jComboDist.setSelectedIndex(12);
//            break;
//            
//            case "14-B":
//            jComboDist.setSelectedIndex(13);
//            break;
//            
//            case "15-B":
//            jComboDist.setSelectedIndex(14);
//            break;
//            
//            case "16-B":
//            jComboDist.setSelectedIndex(15);
//            break;
//            
//            case "17-B":
//            jComboDist.setSelectedIndex(16);
//            break;
//            
//            case "18-B":
//            jComboDist.setSelectedIndex(17);
//            break;
//            
//            case "19-B":
//            jComboDist.setSelectedIndex(18);
//            break;
//            
//            case "20-B":
//            jComboDist.setSelectedIndex(19);
//            break;
//            
//            case "21-C":
//            jComboDist.setSelectedIndex(20);
//            break;
//            
//            case "22-C":
//            jComboDist.setSelectedIndex(21);
//            break;
//            
//            case "23-C":
//            jComboDist.setSelectedIndex(22);
//            break;
//            
//            case "24-C":
//            jComboDist.setSelectedIndex(23);
//            break;
//            
//            case "25-C":
//            jComboDist.setSelectedIndex(24);
//            break;
//            
//            case "26-C":
//            jComboDist.setSelectedIndex(25);
//            break;
//            
//            case "27-C":
//            jComboDist.setSelectedIndex(26);
//            break;
//            
//            case "28-C":
//            jComboDist.setSelectedIndex(27);
//            break;
//            
//            case "29-C":
//            jComboDist.setSelectedIndex(28);
//            break;
//            
//            case "30-C":
//            jComboDist.setSelectedIndex(29);
//            break;
//            
//            case "31-D":
//            jComboDist.setSelectedIndex(30);
//            break;
//            
//            case "32-D":
//            jComboDist.setSelectedIndex(31);
//            break;
//            
//            case "33-D":
//            jComboDist.setSelectedIndex(32);
//            break;
//            
//            case "34-D":
//            jComboDist.setSelectedIndex(33);
//            break;
//            
//            case "35-D":
//            jComboDist.setSelectedIndex(34);
//            break;
//            
//            case "36-D":
//            jComboDist.setSelectedIndex(35);
//            break;
//            
//            case "37-D":
//            jComboDist.setSelectedIndex(36);
//            break;
//            
//            case "38-D":
//            jComboDist.setSelectedIndex(37);
//            break;
//            
//            case "39-D":
//            jComboDist.setSelectedIndex(38);
//            break;
//            
//            case "40-D":
//            jComboDist.setSelectedIndex(39); 
//            break;
//            
//            case "Bago Aplaya":
//            jComboDist.setSelectedIndex(40); //------------------------40
//            break;
//            
//            case "Bago Gallera":
//            jComboDist.setSelectedIndex(41);
//            break;
//            
//            case "Baliok":
//            jComboDist.setSelectedIndex(42);
//            break;
//            
//            case "Bucana":
//            jComboDist.setSelectedIndex(43);
//            break;
//            
//            case "Catalunan Grande":
//            jComboDist.setSelectedIndex(44);
//            break;
//            
//            case "Catalunan Pequeño":
//            jComboDist.setSelectedIndex(45);
//            break;
//            
//            case "Dumoy":
//            jComboDist.setSelectedIndex(46);
//            break;
//            
//            case "Langub":
//            jComboDist.setSelectedIndex(47);
//            break;
//            
//            case "Ma-a":
//            jComboDist.setSelectedIndex(48);
//            break;
//            
//            case "Magtuod":
//            jComboDist.setSelectedIndex(49);
//            break;
//            
//            case "Matina Aplaya":
//            jComboDist.setSelectedIndex(50); //------------------------50
//            break;
//            
//            case "Matina Crossing":
//            jComboDist.setSelectedIndex(51);
//            break;
//            
//            case "Matina Pangi":
//            jComboDist.setSelectedIndex(52);
//            break;
//            
//            case "Talomo Proper":
//            jComboDist.setSelectedIndex(53);
//            break;
//            
//            case "Agdao Proper":
//            jComboDist.setSelectedIndex(54);
//            break;
//            
//            case "Centro (San Juan)":
//            jComboDist.setSelectedIndex(55);
//            break;
//            
//            case "Gov. Paciano Bangoy":
//            jComboDist.setSelectedIndex(56);
//            break;
//            
//            case "Gov. Vicente Duterte":
//            jComboDist.setSelectedIndex(57);
//            break;
//            
//            case "Kap. Tomas Monteverde, Sr.":
//            jComboDist.setSelectedIndex(58);
//            break;
//            
//            case "Lapu-Lapu":
//            jComboDist.setSelectedIndex(59); 
//            break;
//            
//            case "Leon Garcia":
//            jComboDist.setSelectedIndex(60); //-------------------------------------------60
//            break;
//            
//            case "Rafael Castillo":
//            jComboDist.setSelectedIndex(61);
//            break;
//            
//            case "San Antonio":
//            jComboDist.setSelectedIndex(62);
//            break;
//            
//            case "Ubalde":
//            jComboDist.setSelectedIndex(63);
//            break;
//            
//            case "Wilfredo Aquino":
//            jComboDist.setSelectedIndex(64);
//            break;
//            
//            case "Acacia":
//            jComboDist.setSelectedIndex(65);
//            break;
//            
//            case "Alfonso Angliongto Sr.a":
//            jComboDist.setSelectedIndex(66);
//            break;
//            
//            case "Buhangin Proper":
//            jComboDist.setSelectedIndex(67);
//            break;
//            
//            case "Cabantian":
//            jComboDist.setSelectedIndex(68);
//            break;
//            
//            case "Callawa":
//            jComboDist.setSelectedIndex(69);
//            break;
//            
//            case "Communal":
//            jComboDist.setSelectedIndex(70); //-----------------------------------70
//            break;
//            
//            case "Indangan":
//            jComboDist.setSelectedIndex(71);
//            break;
//            
//            case "Mandug":
//            jComboDist.setSelectedIndex(72);
//            break;
//            
//            case "Pampanga":
//            jComboDist.setSelectedIndex(73);
//            break;
//            
//            case "Sasa":
//            jComboDist.setSelectedIndex(74);
//            break;
//            
//            case "Tigatto":
//            jComboDist.setSelectedIndex(75);
//            break;
//            
//            case "Vicente Hizon Sr.a":
//            jComboDist.setSelectedIndex(76);
//            break;
//            
//            case "Waan":
//            jComboDist.setSelectedIndex(77);
//            break;
//            
//            case "Alejandra Navarro (Lasang)":
//            jComboDist.setSelectedIndex(78);
//            break;
//            
//            case "Bunawan Proper":
//            jComboDist.setSelectedIndex(79);
//            break;
//            
//            case "Gatungan":
//            jComboDist.setSelectedIndex(80); //------------------------------> 80
//            break;
//            
//            case "Ilang":
//            jComboDist.setSelectedIndex(81);
//            break;
//            
//            case "Mahayag":
//            jComboDist.setSelectedIndex(82);
//            break;
//            
//            case "Mudiang":
//            jComboDist.setSelectedIndex(83);
//            break;
//            
//            case "Panacan":
//            jComboDist.setSelectedIndex(84);
//            break;
//            
//            case "San Isidro (Licanan)":
//            jComboDist.setSelectedIndex(85);
//            break;           
//            
//            case "Tibungco":
//            jComboDist.setSelectedIndex(86);
//            break;
//            
//            case "Colosas":
//            jComboDist.setSelectedIndex(87);
//            break;
//            
//            case "Fatima (Benowang)":
//            jComboDist.setSelectedIndex(88);
//            break;
//            
//            case "Lumiad":
//            jComboDist.setSelectedIndex(89);
//            break;
//            
//            case "Mabuhay":
//            jComboDist.setSelectedIndex(90); //----------------------------->90
//            break;
//            
//            case "Malabog":
//            jComboDist.setSelectedIndex(91);
//            break;
//            
//            case "Mapula":
//            jComboDist.setSelectedIndex(92);
//            break;
//            
//            case "Panalum":
//            jComboDist.setSelectedIndex(93);
//            break;
//            
//            case "Pandaitan":
//            jComboDist.setSelectedIndex(94);
//            break;
//            
//            case "Paquibato Proper":
//            jComboDist.setSelectedIndex(95);
//            break;
//            
//            case "Paradise Embak":
//            jComboDist.setSelectedIndex(96);
//            break;
//            
//            case "Salapawan":
//            jComboDist.setSelectedIndex(97);
//            break;
//            
//            case "Sumimao":
//            jComboDist.setSelectedIndex(98);
//            break;
//            
//            case "Tapak":
//            jComboDist.setSelectedIndex(99);
//            break;
//            
//            case "Baguio Proper":
//            jComboDist.setSelectedIndex(100); //----------------------------->100
//            break;
//            
//            case "Cadalian":
//            jComboDist.setSelectedIndex(101);
//            break;
//            
//            case "Carmen":
//            jComboDist.setSelectedIndex(102);
//            break;
//            
//            case "Gumalang":
//            jComboDist.setSelectedIndex(103);
//            break;            
//            
//            case "Malagos":
//            jComboDist.setSelectedIndex(104);
//            break;
//            
//            case "Tambubong":
//            jComboDist.setSelectedIndex(105);
//            break;
//            
//            case "Tawan-Tawan":
//            jComboDist.setSelectedIndex(106);
//            break;
//            
//            case "Wines":
//            jComboDist.setSelectedIndex(107);
//            break;
//            
//            case "Biao Joaquin":
//            jComboDist.setSelectedIndex(108);
//            break;
//            
//            case "Calinan Proper":
//            jComboDist.setSelectedIndex(109);
//            break;
//            
//            case "Cawayan":
//            jComboDist.setSelectedIndex(110);
//            break;
//            
//            case "Dacudao":
//            jComboDist.setSelectedIndex(111);
//            break;
//            
//            case "Dalagdag":
//            jComboDist.setSelectedIndex(112);
//            break;
//            
//            case "Dominga":
//            jComboDist.setSelectedIndex(113);
//            break;
//            
//            case "Inayangan":
//            jComboDist.setSelectedIndex(114);
//            break;
//            
//            case "Lacson":
//            jComboDist.setSelectedIndex(115);
//            break;
//            
//            case "Lamanan":
//            jComboDist.setSelectedIndex(116);
//            break;
//            
//            case "Lampianao":
//            jComboDist.setSelectedIndex(117);
//            break;
//            
//            case "Megkawayan":
//            jComboDist.setSelectedIndex(118);
//            break;
//            
//            case "Pangyan":
//            jComboDist.setSelectedIndex(119);
//            break;
//            
//            case "Riverside":
//            jComboDist.setSelectedIndex(120); //-------------------------------------120
//            break;
//            
//            case "Saloy":
//            jComboDist.setSelectedIndex(121);
//            break;
//            
//            case "Sirib":
//            jComboDist.setSelectedIndex(122);
//            break;
//            
//            case "Subasta":
//            jComboDist.setSelectedIndex(123);
//            break;
//            
//            case "Talomo River":
//            jComboDist.setSelectedIndex(124);
//            break;
//            
//            case "Tamayong":
//            jComboDist.setSelectedIndex(125);
//            break;
//            
//            case "Wangan":
//            jComboDist.setSelectedIndex(126);
//            break;
//            
//            case "Baganihan":
//            jComboDist.setSelectedIndex(127);
//            break;
//            
//            case "Bantol":
//            jComboDist.setSelectedIndex(128);
//            break;
//            
//            case "Buda":
//            jComboDist.setSelectedIndex(129);
//            break;
//            
//            
//            case "Dalag":
//            jComboDist.setSelectedIndex(130); //--------------------------------------130
//            break;
//            
//            case "Datu Salumay":
//            jComboDist.setSelectedIndex(131);
//            break;
//            
//            case "Gumitan":
//            jComboDist.setSelectedIndex(132);
//            break;
//            
//            
//            case "Magsaysay":
//            jComboDist.setSelectedIndex(133);
//            break;
//            
//            case "Malamba":
//            jComboDist.setSelectedIndex(134);
//            break;
//            
//            case "Marilog Proper":
//            jComboDist.setSelectedIndex(135);
//            break;
//            
//            case "Salaysay":
//            jComboDist.setSelectedIndex(136);
//            break;
//            
//            case "Suawan (Tuli)":
//            jComboDist.setSelectedIndex(137);
//            break;
//            
//            case "Tamugan":
//            jComboDist.setSelectedIndex(138);
//            break;
//            
//            case "Alambre":
//            jComboDist.setSelectedIndex(139);
//            break;
//            
//            case "Atan-Awe":
//            jComboDist.setSelectedIndex(140);
//            break;
//            
//            case "Bangkas Heights":
//            jComboDist.setSelectedIndex(141);
//            break;
//            
//            case "Baracatan":
//            jComboDist.setSelectedIndex(142);
//            break;
//            
//            case "Bato":
//            jComboDist.setSelectedIndex(143);
//            break;
//            
//            case "Bayabas":
//            jComboDist.setSelectedIndex(144);
//            break;
//            
//            case "Binugao":
//            jComboDist.setSelectedIndex(145);
//            break;
//            
//            case "Camansi":
//            jComboDist.setSelectedIndex(146);
//            break;
//            
//            case "Catigan":
//            jComboDist.setSelectedIndex(147);
//            break;
//            
//            case "Crossing Bayabas":
//            jComboDist.setSelectedIndex(148);
//            break;
//            
//            case "Daliao":
//            jComboDist.setSelectedIndex(149);
//            break;
//            
//            case "Daliaon Plantation":
//            jComboDist.setSelectedIndex(150);
//            break;
//            
//            case "Eden":
//            jComboDist.setSelectedIndex(151);
//            break;
//            
//            case "Kilate":
//            jComboDist.setSelectedIndex(152);
//            break;
//            
//            case "Lizada":
//            jComboDist.setSelectedIndex(153);
//            break;
//            
//            case "Lubogan":
//            jComboDist.setSelectedIndex(154);
//            break;
//            
//            case "Marapangi":
//            jComboDist.setSelectedIndex(155);
//            break;
//            
//            case "Mulig":
//            jComboDist.setSelectedIndex(156);
//            break;
//           
//            case "Sibulan":
//            jComboDist.setSelectedIndex(157);
//            break;
//            
//            case "Sirawan":
//            jComboDist.setSelectedIndex(158);
//            break;
//            
//            case "Tagluno":
//            jComboDist.setSelectedIndex(159);
//            break;
//            
//            case "Tagurano":
//            jComboDist.setSelectedIndex(160); //------------------------------------------------>160
//            break;
//            
//            case "Tibuloy":
//            jComboDist.setSelectedIndex(161); //--------61
//            break;
//            
//            case "Toril Proper":
//            jComboDist.setSelectedIndex(162); //------62
//            break;
//            
//            case "Tungkalan":
//            jComboDist.setSelectedIndex(163); //-------------63
//            break;
//            
//            case "Angalan":
//            jComboDist.setSelectedIndex(164); //--------64
//            break;
//            
//            case "Bago Oshiro":
//            jComboDist.setSelectedIndex(165); //------------65
//            break;
//            
//            case "Balengaeng": //--------66
//            jComboDist.setSelectedIndex(166);
//            break;
//            
//            case "Biao Escuela": //--------66
//            jComboDist.setSelectedIndex(167);
//            break;
//            
//            case "Biao Guianga": //-------67
//            jComboDist.setSelectedIndex(168);
//            break;
//            
//            case "Los Amigos":
//            jComboDist.setSelectedIndex(169);
//            break;
//            
//            case "Manambulan":
//            jComboDist.setSelectedIndex(170);
//            break;
//            
//            case "Manuel Guianga":
//            jComboDist.setSelectedIndex(171);
//            break;
//            
//            case "Matina Biao":
//            jComboDist.setSelectedIndex(172);
//            break;
//            
//            case "Mintal":
//            jComboDist.setSelectedIndex(173);
//            break;
//            
//            case "New Carmen":
//            jComboDist.setSelectedIndex(174);
//            break;
//            
//            case "New Valencia":
//            jComboDist.setSelectedIndex(175);
//            break;
//            
//            case "Santo Niño":
//            jComboDist.setSelectedIndex(176);
//            break;
//            
//            case "Tacunan":
//            jComboDist.setSelectedIndex(177);
//            break;
//            
//            case "Tagakpan":
//            jComboDist.setSelectedIndex(178);
//            break;
//            
//            case "Talandang":
//            jComboDist.setSelectedIndex(179);
//            break;
//            
//            case "Tugbok Proper":
//            jComboDist.setSelectedIndex(180);
//            break;
//            
//            case "Ulas":
//            jComboDist.setSelectedIndex(181); //--------------------------->181
//            break;
//                               
//                }
    }//GEN-LAST:event_tblDOC1MouseClicked

    private void txtAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaActionPerformed

    private void ComboBoxLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxLocationActionPerformed

    private void rnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rnoActionPerformed
    jText2.setEnabled(false);
    jText2.setBackground(Color.GRAY); 
    jText.setEnabled(false);
    jText.setBackground(Color.GRAY);
    jText.setText("");
    jText2.setText("");
    }//GEN-LAST:event_rnoActionPerformed

    private void txtPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonalActionPerformed

    private void ryesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ryesActionPerformed
    jText2.setEnabled(true);
    jText2.setBackground(Color.WHITE); 
    jText.setEnabled(true);
    jText.setBackground(Color.WHITE);
    }//GEN-LAST:event_ryesActionPerformed

    private void ComboBoxDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxDateItemStateChanged
       try{
           Connection conn = DriverManager.getConnection(url);
            String query = "Select * from tblDOC where Date=?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
               pst.setString(1, (String) ComboBoxDate.getSelectedItem());
               ResultSet rs=pst.executeQuery();
               
               tblDOC1.setModel(DbUtils.resultSetToTableModel(rs));
           }
        }
        catch (Exception ex){
            ex.printStackTrace();
            
        }
    }//GEN-LAST:event_ComboBoxDateItemStateChanged

    private void txtContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactNoActionPerformed

    private void txtDistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDistActionPerformed
    
    public void Fillcombo() throws SQLException{
        try{
            String sql = "Select * from tblDOC";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
             
                String Location = rs.getString("Location");
                ComboBoxLocation.addItem(Location);
                String ContactNo = rs.getString("ContactNo");
                ComboBoxNo.addItem(ContactNo);
                String Utilities = rs.getString("Utilities");
                ComboBoxUtilities.addItem(Utilities);
            }
            
            
    } catch(Exception e){
    
    JOptionPane.showMessageDialog(null, e);
    }
    }
 
           
   
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
            java.util.logging.Logger.getLogger(FrmAddDisasterOperationsCenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddDisasterOperationsCenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddDisasterOperationsCenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddDisasterOperationsCenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmAddDisasterOperationsCenter().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmAddDisasterOperationsCenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmAddDisasterOperationsCenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxDate;
    private javax.swing.JComboBox<String> ComboBoxLocation;
    private javax.swing.JComboBox<String> ComboBoxNo;
    private javax.swing.JComboBox<String> ComboBoxUtilities;
    private javax.swing.JButton btnClear;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jText;
    private javax.swing.JTextField jText2;
    private javax.swing.JRadioButton rno;
    private javax.swing.JRadioButton ryes;
    private javax.swing.JTable tblDOC1;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtDist;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtPersonal;
    private javax.swing.JTextField txtPob;
    private javax.swing.JTextField txtUtilities;
    // End of variables declaration//GEN-END:variables
}
