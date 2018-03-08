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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jdk.nashorn.internal.runtime.Debug.id;
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
        Fillcombo();
//        FillRadio();
        this.setLocationRelativeTo(null);
        if(SQLite.openDB()){
            String[][] data = SQLite.read("tblBDRRMC");
            String[] column = {"ID","BDRRMC","Composition","Composition","ContactNo","Position","No BDRRMC","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblBDRRMC1.setModel(model);
            SQLite.closeDB();
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
            txtComposition.setText("");
            txtContactNo.setText("");
            txtPosition.setText("");
            ComboBox.setSelectedIndex(0);
        }
         public void ComboboxDate(){
     try{
          Class.forName("org.sqlite.JDBC");
          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
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
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBDRRMC1 = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ryes = new javax.swing.JRadioButton();
        rno = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtComposition = new javax.swing.JTextField();
        ComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        ComboBoxDate = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add New BDRRMC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
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

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("New");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Date");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Is there a BDRRMC organized within the barangay?");

        ryes.setBackground(new java.awt.Color(102, 0, 51));
        buttonGroup6.add(ryes);
        ryes.setForeground(new java.awt.Color(255, 255, 255));
        ryes.setText("Yes");
        ryes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ryesActionPerformed(evt);
            }
        });

        rno.setBackground(new java.awt.Color(102, 0, 51));
        buttonGroup6.add(rno);
        rno.setForeground(new java.awt.Color(255, 255, 255));
        rno.setText("No");
        rno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(102, 0, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "If yes pls fill up *Do not leave blank spaces", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(102, 0, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact Number and Position in Barangay", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Contact Number");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Position");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(txtPosition))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Composition of the BDRRMC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        txtComposition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompositionActionPerformed(evt);
            }
        });

        ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BDRRM Officer", "Administration & Training Unit", "Researh & Planning Unit", "Operations & Warning Unit" }));
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(txtComposition, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComposition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("If No BDRRMC yet,please justify why?");

        txtNo.setColumns(20);
        txtNo.setRows(5);
        jScrollPane2.setViewportView(txtNo);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date");

        ComboBoxDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxDateItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addComponent(ryes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rno))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(0, 250, Short.MAX_VALUE)
                            .addComponent(btnClear)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnUpdate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnDelete))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2))))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ryes)
                    .addComponent(rno))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear))
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addGap(28, 28, 28))
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

    private void txtCompositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompositionActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    try {
          Class.forName("org.sqlite.JDBC");
          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          conn = java.sql.DriverManager.getConnection(url);    
          String query ="Insert into tblBDRRMC(choices, Composition_of_BDRRMC, Composition, ContactNo, Position, No, date)values(?,?,?,?,?,?,?)";
          PreparedStatement pst = null;  
          pst = conn.prepareStatement(query);      
          ryes.setActionCommand("Yes");
          rno.setActionCommand("No");
          String choices;
          choices = buttonGroup6.getSelection().getActionCommand();
          String Composition_of_BDRRM;
          Composition_of_BDRRM = ComboBox.getSelectedItem().toString();  
          SimpleDateFormat dFormat = new SimpleDateFormat("yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
          pst.setString(1, choices);
          pst.setString(2, Composition_of_BDRRM); 
          pst.setString(3, txtComposition.getText());
          pst.setString(4, txtContactNo.getText()); 
          pst.setString(5, txtPosition.getText());
          pst.setString(6, txtNo.getText());
          pst.setString(7, date);
      
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
    dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
        clear();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }  
        }      
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    private void tblBDRRMC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBDRRMC1MouseClicked
        int index = tblBDRRMC1.getSelectedRow();
        TableModel model = tblBDRRMC1.getModel();
//      txtID.setText(model.getValueAt(index, 0).toString());     
        txtComposition.setText(model.getValueAt(index, 3).toString());
        txtContactNo.setText(model.getValueAt(index, 4).toString());
        txtPosition.setText(model.getValueAt(index, 5).toString());
        txtNo.setText(model.getValueAt(index, 6).toString());
        Date date = null;
        try {
        date = new SimpleDateFormat("yyyy").parse(model.getValueAt(index, 7).toString());
           } catch (ParseException ex) {
               Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
           }
        jDateChooser1.setDate(date);
        
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
       ComboBox.setEnabled(true);
       ComboBox.setBackground(Color.WHITE);
       txtNo.setText("");
            }
        else{
       rno.setSelected(true);
       txtNo.setEnabled(true);
       txtNo.setBackground(Color.WHITE); 
       txtComposition.setEnabled(false);
       txtComposition.setBackground(Color.GRAY);
       txtContactNo.setEnabled(false);
       txtContactNo.setBackground(Color.GRAY);
       txtPosition.setEnabled(false);
       txtPosition.setBackground(Color.GRAY);
       ComboBox.setEnabled(false);
       ComboBox.setBackground(Color.GRAY);
       txtComposition.setText("");
       txtContactNo.setText("");
       txtPosition.setText("");
            }
        
        String Composition_of_BDRRMC = model.getValueAt (index, 2).toString();
            switch(Composition_of_BDRRMC){
        
            case "BDRRM Officer":
            ComboBox.setSelectedIndex(0);
            break;
            
            case "Administration & Training Unit":
            ComboBox.setSelectedIndex(1);
            break;
            
            case "Researh & Planning Unit":
            ComboBox.setSelectedIndex(2);
            break;
            
            case "Operations & Warning Unit":
            ComboBox.setSelectedIndex(3);
            break;
        
                }
        
    }//GEN-LAST:event_tblBDRRMC1MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    try {   
        Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
        String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
    try {
        conn = java.sql.DriverManager.getConnection(url);
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
        int row = tblBDRRMC1.getSelectedRow();
        String value = (tblBDRRMC1.getModel().getValueAt(row, 0).toString());
        String query ="Update tblBDRRMC set choices = ?, Composition_of_BDRRMC = ?,Composition = ? , ContactNo = ?,Position = ?, No = ?, Date = ? where ID ="+value;
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
        String Composition_of_BDRRM;
        Composition_of_BDRRM = ComboBox.getSelectedItem().toString();
        pst.setString(2, Composition_of_BDRRM);
//        pst.setString(1, (String) ComboBox.getSelectedItem());
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        pst.setString(3, txtComposition.getText());
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
   try {
        pst.setString(4, txtContactNo.getText());
    } catch (SQLException ex) {
        Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        pst.setString(5, txtPosition.getText());
        pst.setString(6, txtNo.getText());
   
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy");
        String date = dFormat.format(jDateChooser1.getDate());
        pst.setString(7,date);
        
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

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       txtComposition.setText("");
       txtContactNo.setText("");
       txtPosition.setText(""); 
       txtNo.setText("");
       ComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void rnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rnoActionPerformed
       txtNo.setEnabled(true);
       txtNo.setBackground(Color.WHITE); 
       txtComposition.setEnabled(false);
       txtComposition.setBackground(Color.GRAY);
       txtContactNo.setEnabled(false);
       txtContactNo.setBackground(Color.GRAY);
       txtPosition.setEnabled(false);
       txtPosition.setBackground(Color.GRAY);
       ComboBox.setEnabled(false);
       ComboBox.setBackground(Color.GRAY);
       txtComposition.setText("");
       txtContactNo.setText("");
       txtPosition.setText("");
    }//GEN-LAST:event_rnoActionPerformed

    private void ryesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ryesActionPerformed
       txtNo.setEnabled(false);
       txtNo.setBackground(Color.GRAY);  
       txtComposition.setEnabled(true);
       txtComposition.setBackground(Color.WHITE);
       txtContactNo.setEnabled(true);
       txtContactNo.setBackground(Color.WHITE);
       txtPosition.setEnabled(true);
       txtPosition.setBackground(Color.WHITE);
       ComboBox.setEnabled(true);
       ComboBox.setBackground(Color.WHITE);
       txtNo.setText("");
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
        
    
 
   
    /**
     * @param args the command line arguments
     */
    public void Fillcombo() throws SQLException{
        try{
            String sql = "Select * from tblBDRRMC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String Composition_of_BDRRMC = rs.getString("Composition_of_BDRRMC");
                ComboBox.addItem(Composition_of_BDRRMC);
       
            }
    } catch(Exception e){
    
    JOptionPane.showMessageDialog(null, e);
    }
    }
    
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
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JComboBox<String> ComboBoxDate;
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rno;
    private javax.swing.JRadioButton ryes;
    private javax.swing.JTable tblBDRRMC1;
    private javax.swing.JTextField txtComposition;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextArea txtNo;
    private javax.swing.JTextField txtPosition;
    // End of variables declaration//GEN-END:variables

    private void Switch(String Composition_of_BDRRMC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
