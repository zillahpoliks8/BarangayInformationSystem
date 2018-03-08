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
        Fillcombo();
        this.setLocationRelativeTo(null);
        if(SQLite.openDB()){
            String[][] data = SQLite.read("tblDOC");
            String[] column = {"ID","Choice","txt","txt2","Location","Location","Area","Contact","ContactInfo","Utilities","Utilities", "Personal","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblDOC1.setModel(model);
            SQLite.closeDB();
        }
    }
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
                 doc = new DisasterOperationsCenter (rs.getInt("ID"),rs.getString("Choice"),rs.getString("txt"),rs.getString("txt2"),rs.getString("Location"),rs.getString("Location1"),rs.getString("Area"),rs.getString("ContactNo"),rs.getString("ContactNo1"),rs.getString("Utilities"),rs.getString("Utilities1"),rs.getString("Personal"),rs.getString("Date"));
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
          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
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
        jPanel2 = new javax.swing.JPanel();
        ComboBoxLocation = new javax.swing.JComboBox<>();
        txtLocation = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ComboBoxNo = new javax.swing.JComboBox<>();
        txtContactNo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        ComboBoxUtilities = new javax.swing.JComboBox<>();
        txtUtilities = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Disaster Operations Center");
        setBackground(new java.awt.Color(0, 153, 153));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Disaster Operations Center", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        ComboBoxLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Main", "Alternate" }));
        ComboBoxLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBoxLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        txtArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Land/Floor area");

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact Number", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));

        ComboBoxNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Land line", "Mobile", "Frequency No", "Fax Machine", "Email Address" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBoxNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Utilities Available", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        ComboBoxUtilities.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electricity", "Water" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBoxUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Personal-in-charge");

        txtPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonalActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnClear.setText("New");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Date");

        ComboBoxDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxDateItemStateChanged(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "If Yes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("24/7 Operation");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rno.setBackground(new java.awt.Color(0, 153, 153));
        buttonGroup1.add(rno);
        rno.setForeground(new java.awt.Color(255, 255, 255));
        rno.setText("No");
        rno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnoActionPerformed(evt);
            }
        });

        ryes.setBackground(new java.awt.Color(0, 153, 153));
        buttonGroup1.add(ryes);
        ryes.setForeground(new java.awt.Color(255, 255, 255));
        ryes.setText("Yes");
        ryes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ryesActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Disaster/Emergency Operations Center:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(27, 27, 27))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(17, 17, 17)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(183, 183, 183)
                                        .addComponent(btnClear)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(ryes)
                        .addGap(18, 18, 18)
                        .addComponent(rno)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ryes)
                    .addComponent(rno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
            conn = java.sql.DriverManager.getConnection(url);
            int row = tblDOC1.getSelectedRow();
            String value = (tblDOC1.getModel().getValueAt(row, 0).toString());
            String query ="Update tblDOC set Choice = ?, txt = ?, txt2 = ?, Location = ?,Location1 = ?,Area = ?,ContactNo = ?,ContactNo1 = ?,Utilities = ?,Utilities1 = ?, Personal = ?, Date = ? where ID = "+value;
            PreparedStatement pst = null;
            pst = conn.prepareStatement(query);
            String Location;
            Location = ComboBoxLocation.getSelectedItem().toString();
            pst.setString(4, Location);
            String choices;
            choices = buttonGroup1.getSelection().getActionCommand();
            pst.setString(1, choices);
            pst.setString(2, jText.getText());
            pst.setString(3, jText2.getText());
            pst.setString(5, txtLocation.getText());
            pst.setString(6, txtArea.getText());

            String ContactNumber;
            ContactNumber = ComboBoxNo.getSelectedItem().toString();
            pst.setString(7, ContactNumber);

            pst.setString(8, txtContactNo.getText());

            String Utilitiess;
            Utilitiess = ComboBoxUtilities.getSelectedItem().toString();
            pst.setString(9,Utilitiess);

            pst.setString(10, txtUtilities.getText());
            pst.setString(11, txtPersonal.getText());
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy");
            String date = dFormat.format(jDateChooser1.getDate());
            pst.setString(12, date);
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
                url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
            url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
            conn = java.sql.DriverManager.getConnection(url);
            String query ="Insert into tblDOC(Choice,txt,txt2,Location,Location1,Area,ContactNo,ContactNo1,Utilities,Utilities1, Personal,Date)values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = null;
            pst = conn.prepareStatement(query);
            ryes.setActionCommand("Yes");
            rno.setActionCommand("No");
            String choices;
            choices = buttonGroup1.getSelection().getActionCommand();
            String Location;
            Location = ComboBoxLocation.getSelectedItem().toString();
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
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy");
            String date = dFormat.format(jDateChooser1.getDate());
            pst.setString(12, date);
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
        date = new SimpleDateFormat("yyyy").parse(model.getValueAt(index, 12).toString());
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtPersonal;
    private javax.swing.JTextField txtUtilities;
    // End of variables declaration//GEN-END:variables
}
