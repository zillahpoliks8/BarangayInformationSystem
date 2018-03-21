/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIS;

import static BIS.SQLite.conn;
import static BIS.SQLite.url;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class FrmAddAgriculturalSector extends javax.swing.JFrame {

    /**
     * Creates new form FrmAddAgriculturalSector
     */
    public FrmAddAgriculturalSector() throws SQLException, ClassNotFoundException {
        initComponents();
        ComboboxDate();
         this.setLocationRelativeTo(null);
        show_Sector();
         if(SQLite.openDB()){
            String[][] data = SQLite.read("tblSector");
            String[] column = {"ID","Sitio","Farmers","Farm_land","Fish_farmers","Land_area","Livestock","Type_of_livestock","District", "Baranggay"," date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblSector1.setModel(model);
            SQLite.closeDB();
        }
    }

     public void ComboboxDate(){ //#5
     try{
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          conn = java.sql.DriverManager.getConnection(url);
          SQLite.openDB();
          String query = "Select DISTINCT Date from tblSector ORDER BY ID DESC";
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
            txtSitio.setText("");
            txtFarmers.setText("");
            txtFarm_land.setText("");
            txtFish_farmers.setText("");
            txtLand_area.setText("");
            txtLivestock.setText("");
            txtType_of_livestock.setText("");
     
        }
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSector1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSitio = new javax.swing.JTextField();
        txtFarmers = new javax.swing.JTextField();
        txtFish_farmers = new javax.swing.JTextField();
        txtLand_area = new javax.swing.JTextField();
        txtLivestock = new javax.swing.JTextField();
        txtType_of_livestock = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        ComboBoxDate = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtFarm_land = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPob = new javax.swing.JTextField();
        txtDist = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agricultural Sector");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Agricultural Sector"));

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
        tblSector1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSector1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSector1);

        jLabel1.setText("Purok/Sitio");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Back.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Total No. Of Farmers");

        jLabel3.setText("Total Area of Farm Land");

        jLabel4.setText("Total No. of Fish Farmers");

        jLabel5.setText("Total Land Area");

        jLabel6.setText("Total No. of Livestock Breeder");

        jLabel7.setText("Type of Livestock Breed");

        txtSitio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSitioActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Save.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setText("Year");

        ComboBoxDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxDateItemStateChanged(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Date.png"))); // NOI18N
        jLabel10.setText("Date");

        jLabel11.setText("Baranggay");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Update User.png"))); // NOI18N
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton5.setText("New");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setText("District");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addGap(39, 39, 39))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addGap(11, 11, 11)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(10, 10, 10)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSitio)
                                            .addComponent(txtPob))
                                        .addGap(330, 330, 330)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel5)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtLand_area)
                                            .addComponent(txtLivestock, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFish_farmers, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(601, 601, 601))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFarm_land, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtType_of_livestock, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(txtFarmers)
                                    .addComponent(txtDist))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(202, 202, 202))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addGap(400, 400, 400)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(31, 31, 31)
                                        .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(txtPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSitio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtFarmers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtLand_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtLivestock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFarm_land, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtType_of_livestock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFish_farmers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4)
                                    .addComponent(jButton5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton1)))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSitioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSitioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSitioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
    try {
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          conn = java.sql.DriverManager.getConnection(url);    
          String query ="Insert into tblSector(Sitio,Farmers,Farm_land,Fish_farmers,Land_area,Livestock,Type_of_livestock,Baranggay, District, date)values(?,?,?,?,?,?,?,?,?,?)";
          PreparedStatement pst = null;  
          pst = conn.prepareStatement(query);      
           SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
//          String Baranggay;
//          Baranggay = JComboPob.getSelectedItem().toString(); 
//          String District;
//          District = jComboDist.getSelectedItem().toString(); 
          pst.setString(1, txtSitio.getText());
          pst.setString(2, txtFarmers.getText());
          pst.setString(3, txtFarm_land.getText());
          pst.setString(4, txtFish_farmers.getText()); 
          pst.setString(5, txtLand_area.getText()); 
          pst.setString(6, txtLivestock.getText()); 
          pst.setString(7, txtType_of_livestock.getText()); 
          pst.setString(8, txtPob.getText()); 
          pst.setString(9, txtDist.getText()); 
          pst.setString(10, date);
         
          pst.executeUpdate(); 
          DefaultTableModel model = (DefaultTableModel)tblSector1.getModel();
          model.setRowCount(1);
          show_Sector();
          JOptionPane.showMessageDialog(null, "Added Successfully");
          clear();
          }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
          }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
        try {
        Class.forName("org.sqlite.JDBC");
//        url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
        conn = java.sql.DriverManager.getConnection(url);    
        int row = tblSector1.getSelectedRow();
        String value = (tblSector1.getModel().getValueAt(row, 0).toString());
        String query ="DELETE FROM tblSector where ID = "+value;
        PreparedStatement pst = conn.prepareStatement(query);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)tblSector1.getModel();
        model.setRowCount(0);
        show_Sector();
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
        clear();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }  
        }      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       try {
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          Connection conn = DriverManager.getConnection(url);
          int row = tblSector1.getSelectedRow();
          String value = (tblSector1.getModel().getValueAt(row, 0).toString());
          String query ="Update tblSector set Sitio = ?,Farmers = ?,Farm_land = ?,Fish_farmers = ?,Land_area =?,Livestock =?,Type_of_livestock =?,Baranggay=?, District=?, date = ? where ID ="+value;
          PreparedStatement pst = conn.prepareStatement(query);
          SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
//          String Baranggay;
//          Baranggay = JComboPob.getSelectedItem().toString(); 
//          String District;
//          District = jComboDist.getSelectedItem().toString(); 
          pst.setString(1, txtSitio.getText());
          pst.setString(2, txtFarmers.getText());
          pst.setString(3, txtFarm_land.getText());
          pst.setString(4, txtFish_farmers.getText()); 
          pst.setString(5, txtLand_area.getText()); 
          pst.setString(6, txtLivestock.getText()); 
          pst.setString(7, txtType_of_livestock.getText()); 
          pst.setString(8, txtPob.getText()); 
          pst.setString(9, txtDist.getText()); 
          pst.setString(10, date);
         
          pst.executeUpdate(); 
          DefaultTableModel model = (DefaultTableModel)tblSector1.getModel();
          model.setRowCount(1);
          show_Sector();
          JOptionPane.showMessageDialog(null, "Update Successfully");
          clear();                                  
            }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
          } 
     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          clear ();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ComboBoxDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxDateItemStateChanged
        try{
            String query = "Select * from tblSector where Date=?";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rs=pst.executeQuery();
            
            tblSector1.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
            
        }
    }//GEN-LAST:event_ComboBoxDateItemStateChanged

    private void tblSector1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSector1MouseClicked
      int index = tblSector1.getSelectedRow();
        TableModel model = tblSector1.getModel();
        
        
            txtSitio.setText(model.getValueAt(index, 1).toString());
            txtFarmers.setText(model.getValueAt(index, 2).toString());
            txtFarm_land.setText(model.getValueAt(index, 3).toString());
            txtFish_farmers.setText(model.getValueAt(index, 4).toString());
            txtLand_area.setText(model.getValueAt(index, 5).toString());
            txtLivestock.setText(model.getValueAt(index, 6).toString());
            txtType_of_livestock.setText(model.getValueAt(index, 7).toString());
            txtPob.setText(model.getValueAt(index, 8).toString());
            txtDist.setText(model.getValueAt(index, 9).toString());
          
        Date date = null;
        try {
        date = new SimpleDateFormat("mm/dd/yyyy").parse(model.getValueAt(index, 10).toString());
           } catch (ParseException ex) {
               Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
           }
        jDateChooser1.setDate(date);
        
//     
//         String Baranggay = model.getValueAt (index, 8).toString();
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
//          String District = model.getValueAt (index, 9).toString();
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
    }//GEN-LAST:event_tblSector1MouseClicked

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
            java.util.logging.Logger.getLogger(FrmAddAgriculturalSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddAgriculturalSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddAgriculturalSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddAgriculturalSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmAddAgriculturalSector().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmAddAgriculturalSector.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmAddAgriculturalSector.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSector1;
    private javax.swing.JTextField txtDist;
    private javax.swing.JTextField txtFarm_land;
    private javax.swing.JTextField txtFarmers;
    private javax.swing.JTextField txtFish_farmers;
    private javax.swing.JTextField txtLand_area;
    private javax.swing.JTextField txtLivestock;
    private javax.swing.JTextField txtPob;
    private javax.swing.JTextField txtSitio;
    private javax.swing.JTextField txtType_of_livestock;
    // End of variables declaration//GEN-END:variables
}
