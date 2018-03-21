/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIS;

import static BIS.SQLite.url;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class FrmAddBDRRMC extends javax.swing.JFrame {
Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;
    /**
     * Creates new form frmAddBDRRMC
     */
    public FrmAddBDRRMC() throws SQLException, ClassNotFoundException {
        initComponents();
        ComboboxDate();
        show_BDRRMC();
//        Fillcombo();
//        FillRadio();
        this.setLocationRelativeTo(null);
        if(SQLite.openDB()){
            String[][] data = SQLite.read("tblBDRRMC");
            String[] column = {"BDC Resolution No.","BDRRMC","Composition of the BDRRMC","Name","Contact Number","Position in the Barangay","No BDRRMC","District","Barangay","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblBDRRMC1.setModel(model);
            SQLite.closeDB();
        }
    }

    public void show_BDRRMC() throws SQLException, ClassNotFoundException{ ///////#1
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
    
    public ArrayList <BDRRMC> BDRRMCList() throws SQLException, ClassNotFoundException{ /////#2
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
                 bdrrmc = new BDRRMC (rs.getInt("ID"),rs.getString("choices"),rs.getString("Composition_of_BDRRMC"),rs.getString("Composition"),rs.getString("ContactNo"),rs.getString("Position"),rs.getString("No"),rs.getString("Baranggay"),rs.getString("District"),rs.getString("Date"));
                 BDRRMCList.add(bdrrmc);
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return BDRRMCList;
    }
            public void executeSQLQuery(String query,String message) throws SQLException ////#3
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
        public void clear (){  //#4
            txtComposition.setText("");
            txtContactNo.setText("");
            txtPosition.setText("");
//            ComboBox.setSelectedIndex(0);
        }
         public void ComboboxDate(){ //#5
     try{
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          conn = java.sql.DriverManager.getConnection(url);
          SQLite.openDB();
          String query = "Select DISTINCT Date from tblBDRRMC ORDER BY ID DESC";
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
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBDRRMC1 = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ryes = new javax.swing.JRadioButton();
        rno = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        ComboBoxDate = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtComposition = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDist = new javax.swing.JTextField();
        txtPob = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add New BDRRMC"));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tblBDRRMC1);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Back.png"))); // NOI18N
        btnCancel.setText("Back");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Update User.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        btnClear.setText("New");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Date.png"))); // NOI18N
        jLabel1.setText("Date");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Is there a BDRRMC organized within the barangay?");

        buttonGroup6.add(ryes);
        ryes.setText("Yes");
        ryes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ryesActionPerformed(evt);
            }
        });

        buttonGroup6.add(rno);
        rno.setText("No");
        rno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnoActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("If No BDRRMC yet,please justify why?");

        txtNo.setColumns(20);
        txtNo.setRows(5);
        jScrollPane2.setViewportView(txtNo);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Year");

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

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Barangay ");

        jLabel6.setText("District");

        jLabel7.setText("If yes pls fill up *Do not leave blank spaces");

        txtComposition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompositionActionPerformed(evt);
            }
        });

        jLabel8.setText("Composition of the BDRRMC");

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Contact Number");

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Position");

        jLabel9.setText("Contact Number and Position in Barangay");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldActionPerformed(evt);
            }
        });

        jLabel10.setText("Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)))
                .addComponent(txtComposition, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComposition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addGap(1, 1, 1)
                                        .addComponent(txtPob, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDist, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(ryes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rno)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(txtDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ryes)
                    .addComponent(rno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    try {
          SQLite.openDB();
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          conn = java.sql.DriverManager.getConnection(url);    
          String query ="Insert into tblBDRRMC(choices, Composition_of_BDRRMC, Composition, ContactNo, Position, No, Baranggay, District, date)values(?,?,?,?,?,?,?,?,?)";
          PreparedStatement pst = null;  
          pst = conn.prepareStatement(query);      
          ryes.setActionCommand("Yes");
          rno.setActionCommand("No");
          String choices;
          choices = buttonGroup6.getSelection().getActionCommand();
//          String Composition_of_BDRRM;
//          Composition_of_BDRRM = ComboBox.getSelectedItem().toString();  
//          String Operation;
//          Operation = ComboBox2.getSelectedItem().toString();
//          String Baranggay;
//          Baranggay = JComboPob.getSelectedItem().toString();
//          String District;
//          District = jComboDist.getSelectedItem().toString();
          SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
          pst.setString(1, choices);
//          pst.setString(2, Composition_of_BDRRM); 
          pst.setString(2, TextField.getText());
//          pst.setString(2, Operation);
          pst.setString(3, txtComposition.getText());
          pst.setString(4, txtContactNo.getText()); 
          pst.setString(5, txtPosition.getText());
          pst.setString(6, txtNo.getText());
          pst.setString(8, txtPob.getText());
          pst.setString(7, txtDist.getText());
          pst.setString(9, date);
      
          pst.executeUpdate(); 
          DefaultTableModel model = (DefaultTableModel)tblBDRRMC1.getModel();
          model.setRowCount(1);
          show_BDRRMC();
          JOptionPane.showMessageDialog(null, "Added Successfully");
          clear();
          }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
         }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

         FrmBDRRMC o = null;
    try {
        o = new FrmBDRRMC();
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
     o.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
        try {
        Class.forName("org.sqlite.JDBC");
//        url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
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
        clear();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }  
        }      
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    private void tblBDRRMC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBDRRMC1MouseClicked
        
        int index = tblBDRRMC1.getSelectedRow();
        TableModel model = tblBDRRMC1.getModel();
        
          String buttonGroup6 = model.getValueAt (index, 1).toString();
        if(buttonGroup6.equals("Yes"))
        {
       ryes.setSelected(true);
       txtNo.setEnabled(false);
       txtNo.setBackground(Color.GRAY);  
       txtComposition.setEnabled(true);
       txtComposition.setBackground(Color.WHITE);
       txtContactNo.setEnabled(true);
       txtContactNo.setBackground(Color.WHITE);
       txtPosition.setEnabled(true);
       txtPosition.setBackground(Color.WHITE);
//       ComboBox.setEnabled(true);
//       ComboBox.setBackground(Color.WHITE);
       txtNo.setText("");
       TextField.setEnabled(true);
       TextField.setBackground(Color.WHITE);
//       txtContactNo.hide();
            }
        else{
       rno.setSelected(true);
       txtNo.setEnabled(true);
       txtNo.setBackground(Color.WHITE); 
       txtComposition.setEnabled(false);
       txtComposition.setBackground(Color.GRAY);
       txtContactNo.setEnabled(false);
       txtContactNo.setBackground(Color.GRAY);
       TextField.setEnabled(false);
       TextField.setBackground(Color.GRAY);
       txtPosition.setEnabled(false);
       txtPosition.setBackground(Color.GRAY);
//       ComboBox.setEnabled(false);
//       ComboBox.setBackground(Color.GRAY);
       txtComposition.setText("");
       txtContactNo.setText("");
       txtPosition.setText("");
       TextField.setText("");
//       txtContactNo.hide();
            }
            TextField.setText(model.getValueAt(index, 2).toString());
//         String Composition_of_BDRRMC = model.getValueAt (index, 2).toString();
//            switch(Composition_of_BDRRMC){
//        
//            case "BDRRM Officer":
//            ComboBox.setSelectedIndex(0);
//            break;
//            
//            case "Administration & Training Unit":
//            ComboBox.setSelectedIndex(1);
//            break;
//            
//            case "Researh & Planning Unit":
//            ComboBox.setSelectedIndex(2);
//            break;
//            
//            case "Operations & Warning Unit":
//            ComboBox.setSelectedIndex(3);
//            break;
//        
//                }
//         String Operation = model.getValueAt (index, 2).toString();
//            switch(Operation){
//        
//            case "Early Warning & Evacuation":
//            ComboBox2.setSelectedIndex(0);
//            break;
//            
//            case "Search & Rescue":
//            ComboBox2.setSelectedIndex(1);
//            break;
//            
//            case "Food & Non Food":
//            ComboBox2.setSelectedIndex(2);
//            break;
//            
//            case "Wash & Health":
//            ComboBox2.setSelectedIndex(3);
//            break;
//            
//            case "Security":
//            ComboBox2.setSelectedIndex(4);
//            break;
//        
//            case "DANA & Early Recovery":
//            ComboBox2.setSelectedIndex(5);
//            break;
//        
//                }    
//            
//   
        txtComposition.setText(model.getValueAt(index, 3).toString());
        txtContactNo.setText(model.getValueAt(index, 4).toString());
        txtPosition.setText(model.getValueAt(index, 5).toString());
        txtNo.setText(model.getValueAt(index, 6).toString());
        Date date = null;
        try {
        date = new SimpleDateFormat("mm/dd/yyyy").parse(model.getValueAt(index, 9).toString());
           } catch (ParseException ex) {
               Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
           }
        jDateChooser1.setDate(date);
        
     
//         String Baranggay = model.getValueAt (index, 7).toString();
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
          txtPob.setText(model.getValueAt(index, 7).toString());
          txtDist.setText(model.getValueAt(index, 8).toString());
//          String District = model.getValueAt (index, 8).toString();
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
    }//GEN-LAST:event_tblBDRRMC1MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    try {   
        Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
//        String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
    try {
        conn = java.sql.DriverManager.getConnection(url);
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
        int row = tblBDRRMC1.getSelectedRow();
        String value = (tblBDRRMC1.getModel().getValueAt(row, 0).toString());
        String query ="Update tblBDRRMC set choices = ?, Composition_of_BDRRMC = ?,Composition = ? , ContactNo = ?,Position = ?, No = ?, Baranggay = ?, District = ?, Date = ? where ID ="+value;
        PreparedStatement pst = null;
    try {
        pst = conn.prepareStatement(query);
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
    
          String choices;
          choices = buttonGroup6.getSelection().getActionCommand();
    try {
        pst.setString(1, choices);
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
         pst.setString(2, TextField.getText());
//        String Composition_of_BDRRM;
//        Composition_of_BDRRM = ComboBox.getSelectedItem().toString();
//        pst.setString(2, Composition_of_BDRRM);
//        pst.setString(1, (String) ComboBox.getSelectedItem());
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        pst.setString(3, txtComposition.getText());
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
//        String Operation;
//        Operation = ComboBox2.getSelectedItem().toString();       
//    try {
//        pst.setString(2, Operation);
//    } catch (SQLException ex) {
//        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
//    }
//        
   try {
        pst.setString(4, txtContactNo.getText());
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        pst.setString(5, txtPosition.getText());
        pst.setString(6, txtNo.getText());
//        
//        String Baranggay;
//        Baranggay = JComboPob.getSelectedItem().toString();       
        pst.setString(8, txtPob.getText());
        
//        String District;
//        District = jComboDist.getSelectedItem().toString();       
        pst.setString(7, txtDist.getText());
        
        SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
        String date = dFormat.format(jDateChooser1.getDate());
        pst.setString(9,date);
    
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)tblBDRRMC1.getModel();
        model.setRowCount(1);
        show_BDRRMC();
        JOptionPane.showMessageDialog(null, "Updated Successfully");
        clear();
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    //    try {
        //        String query = "Update 'tblBDRRMC' set 'ID' = '"+Integer.parseInt(this.txtID.getText())+"','Composition_of_BDRRMC' = '"+(String)ComboBox.getSelectedItem()+"','Composition' = '"+txtComposition.getText()+"','ContactNo' = '"+txtContactNo.getText()+"','Position' = '"+txtPosition.getText()+" where 'ID' = "+Integer.parseInt(this.txtID.getText());
//        Class.forName("org.sqlite.JDBC");
//    } catch (ClassNotFoundException ex) {
//        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
//    }
        //         try {
//            executeSQLQuery(query, "Added");
//         } catch (SQLException ex) {
//           Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
//             }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       txtComposition.setText("");
       txtContactNo.setText("");
       txtPosition.setText(""); 
       txtNo.setText("");
//       ComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void rnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rnoActionPerformed
       txtNo.setEnabled(true);
       txtNo.setBackground(Color.WHITE); 
       txtComposition.setEnabled(false);
       txtComposition.setBackground(Color.GRAY);
       txtContactNo.setEnabled(false);
       txtContactNo.setBackground(Color.GRAY);
//       txtContactNo.hide();
       txtPosition.setEnabled(false);
       txtPosition.setBackground(Color.GRAY);
//       ComboBox.setEnabled(false);
//       ComboBox.setBackground(Color.GRAY);
       txtComposition.setText("");
       txtContactNo.setText("");
       txtPosition.setText("");
       TextField.setEnabled(false);
       TextField.setBackground(Color.GRAY);
//       ComboBox2.setEnabled(false);
//       ComboBox2.setBackground(Color.GRAY);
    }//GEN-LAST:event_rnoActionPerformed

    private void ryesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ryesActionPerformed
       txtNo.setEnabled(false);
       txtNo.setBackground(Color.GRAY);  
       txtComposition.setEnabled(true);
       txtComposition.setBackground(Color.WHITE);
       txtContactNo.setEnabled(true);
       txtContactNo.setBackground(Color.WHITE);
//       txtContactNo.show();
       txtPosition.setEnabled(true);
       txtPosition.setBackground(Color.WHITE);
//       ComboBox.setEnabled(true);
//       ComboBox.setBackground(Color.WHITE);
       txtNo.setText("");
       TextField.setEnabled(true);
       TextField.setBackground(Color.WHITE);
//       ComboBox2.setEnabled(true);
//       ComboBox2.setBackground(Color.WHITE);
    }//GEN-LAST:event_ryesActionPerformed

    private void ComboBoxDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxDateItemStateChanged
       try{
            String query = "Select * from tblBDRRMC where Date=?";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rs=pst.executeQuery();
            
            tblBDRRMC1.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
            
        }
    }//GEN-LAST:event_ComboBoxDateItemStateChanged

    private void ComboBoxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxDateActionPerformed

    private void txtCompositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompositionActionPerformed

    private void TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldActionPerformed
        
    
 
   
    /**
     * @param args the command line arguments
     */
//    public void Fillcombo() throws SQLException{
//        try{
//            String sql = "Select * from tblBDRRMC";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            
//            while(rs.next()){
//                String Composition_of_BDRRMC = rs.getString("Composition_of_BDRRMC");
//                ComboBox.addItem(Composition_of_BDRRMC);
//       
//            }
//    } catch(Exception e){
//    
//    JOptionPane.showMessageDialog(null, e);
//    }
//    }
    
//    public void FillRadio(){
//         try{
//            String sql = "Select * from tblBDRRMC";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            
//            while(rs.next()){
//                String choices = rs.getString("choices");
//                buttonGroup6.add(rno);
//            }
//    } catch(Exception e){
//    
//    JOptionPane.showMessageDialog(null, e);
//    }
//    }
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
            java.util.logging.Logger.getLogger(FrmAddBDRRMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddBDRRMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddBDRRMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddBDRRMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmAddBDRRMC().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxDate;
    private javax.swing.JTextField TextField;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rno;
    private javax.swing.JRadioButton ryes;
    private javax.swing.JTable tblBDRRMC1;
    private javax.swing.JTextField txtComposition;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtDist;
    private javax.swing.JTextArea txtNo;
    private javax.swing.JTextField txtPob;
    private javax.swing.JTextField txtPosition;
    // End of variables declaration//GEN-END:variables

    private void Switch(String Composition_of_BDRRMC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
