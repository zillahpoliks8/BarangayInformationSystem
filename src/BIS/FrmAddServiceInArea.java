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
public class FrmAddServiceInArea extends javax.swing.JFrame {

    /**
     * Creates new form FrmAddServiceInArea
     */
    public FrmAddServiceInArea() throws SQLException, ClassNotFoundException {
        initComponents();
        ComboboxDate();
        show_Service();
        this.setLocationRelativeTo(null);
         if(SQLite.openDB()){
            String[][] data = SQLite.read("tblServices");
            String[] column = {"ID","Type","others","Location","Units","Baranggay","District","Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblServices1.setModel(model);
            SQLite.closeDB();
        }
    }

    
     public void ComboboxDate(){ //#5
     try{
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          conn = java.sql.DriverManager.getConnection(url);
          SQLite.openDB();
          String query = "Select DISTINCT Date from tblServices ORDER BY ID DESC";
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
            txtOthers.setText("");
            txtLocation.setText("");
            txtUnits.setText("");
     
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
        jPanel2 = new javax.swing.JPanel();
        ComboBoxType = new javax.swing.JComboBox<>();
        txtOthers = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUnits = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServices1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        JComboPob = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxDate = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboDist = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Service Within Area");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Service Within Area"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Type"));

        ComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Health Centers", "Day Care Centers", "Baranggay Hall", "Schools", "Religious Structure", "Others" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(ComboBoxType, 0, 116, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtOthers, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOthers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Location.png"))); // NOI18N
        jLabel1.setText("Location (Pls. Specify");

        jLabel2.setText("No. of units");

        txtUnits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitsActionPerformed(evt);
            }
        });

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
        tblServices1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServices1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblServices1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Back.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Update User.png"))); // NOI18N
        jButton2.setText("Update");
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

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Save.png"))); // NOI18N
        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Date.png"))); // NOI18N
        jLabel3.setText("Date");

        jLabel4.setText("Baranggay");

        JComboPob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Poblacion", "Talomo ", "Agdao", "Buhangin", "Bunawan", "Paquibato", "Baguio ", "Calinan ", "Marilog ", "Toril", "Tugbok" }));

        jLabel5.setText("Year");

        ComboBoxDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxDateItemStateChanged(evt);
            }
        });

        jLabel6.setText("District");

        jComboDist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-A", "2-A", "3-A", "4-A", "5-A", "6-A", "7-A", "8-A", "9-A", "10-A", "11-B", "12-B", "13-B", "14-B", "15-B", "16-B", "17-B", "18-B", "19-B", "20-B", "21-C", "22-C", "23-C", "24-C", "25-C", "26-C", "27-C", "28-C", "29-C", "30-C", "31-D", "32-D", "33-D", "34-D", "35-D", "36-D", "37-D", "38-D", "39-D", "40-D", "Bago Aplaya", "Bago Gallera", "Baliok", "Bucana", "Catalunan Grande", "Catalunan Pequeño", "Dumoy", "Langub", "Ma-a", "Magtuod", "Matina Aplaya", "Matina Crossing", "Matina Pangi", "Talomo Proper", "Agdao Proper", "Centro (San Juan)", "Gov. Paciano Bangoy", "Gov. Vicente Duterte", "Kap. Tomas Monteverde, Sr.", "Lapu-Lapu", "Leon Garcia", "Rafael Castillo", "San Antonio", "Ubalde", "Wilfredo Aquino", "Acacia", "Alfonso Angliongto Sr.a", "Buhangin Proper", "Cabantian", "Callawa", "Communal", "Indangan", "Mandug", "Pampanga", "Sasa", "Tigatto", "Vicente Hizon Sr.a", "Waan", "Alejandra Navarro (Lasang)", "Bunawan Proper", "Gatungan", "Ilang", "Mahayag", "Mudiang", "Panacan", "San Isidro (Licanan)", "Tibungco", "Colosas", "Fatima (Benowang)", "Lumiad", "Mabuhay", "Malabog", "Mapula", "Panalum", "Pandaitan", "Paquibato Proper", "Paradise Embak", "Salapawan", "Sumimao", "Tapak", "Baguio Proper", "Cadalian", "Carmen", "Gumalang", "Malagos", "Tambubong", "Tawan-Tawan", "Wines", "Biao Joaquin", "Calinan Proper", "Cawayan", "Dacudao", "Dalagdag", "Dominga", "Inayangan", "Lacson", "Lamanan", "Lampianao", "Megkawayan", "Pangyan", "Riverside", "Saloy", "Sirib", "Subasta", "Talomo River", "Tamayong", "Wangan", "Baganihan", "Bantol", "Buda", "Dalag", "Datu Salumay", "Gumitan", "Magsaysay", "Malamba", "Marilog Proper", "Salaysay", "Suawan (Tuli)", "Tamugan", "Alambre", "Atan-Awe", "Bangkas Heights", "Baracatan", "Bato", "Bayabas", "Binugao", "Camansi", "Catigan", "Crossing Bayabas", "Daliao", "Daliaon Plantation", "Eden", "Kilate", "Lizada", "Lubogan", "Marapangi", "Mulig", "Sibulan", "Sirawan", "Tagluno", "Tagurano", "Tibuloy", "Toril Proper", "Tungkalan", "Angalan", "Bago Oshiro", "Balengaeng", "Biao Escuela", "Biao Guianga", "Los Amigos", "Manambulan", "Manuel Guianga", "Matina Biao", "Mintal", "New Carmen", "New Valencia", "Santo Niño", "Tacunan", "Tagakpan", "Talandang", "Tugbok Proper", "Ula" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtUnits, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(126, 126, 126))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(14, 14, 14)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel6))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(JComboPob, 0, 114, Short.MAX_VALUE)
                                                .addComponent(jComboDist, 0, 1, Short.MAX_VALUE)))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JComboPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2)
                            .addComponent(jButton4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    try {
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          conn = java.sql.DriverManager.getConnection(url);    
          String query ="Insert into tblServices(Type,others,Location,Units,Baranggay, District, date)values(?,?,?,?,?,?,?)";
          PreparedStatement pst = null;  
          pst = conn.prepareStatement(query);      
           SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
          String Baranggay;
          Baranggay = JComboPob.getSelectedItem().toString(); 
          String District;
          District = jComboDist.getSelectedItem().toString(); 
          String type;
          type = ComboBoxType.getSelectedItem().toString();     
          pst.setString(1, type); 
          pst.setString(2, txtOthers.getText());
          pst.setString(3, txtLocation.getText()); 
          pst.setString(4, txtUnits.getText()); 
          pst.setString(5, Baranggay); 
          pst.setString(6, District); 
          pst.setString(7, date);
         
         pst.executeUpdate(); 
          DefaultTableModel model = (DefaultTableModel)tblServices1.getModel();
          model.setRowCount(1);
          show_Service();
          JOptionPane.showMessageDialog(null, "Added Successfully");
          clear();
          }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
          }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtUnitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitsActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear ();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         int p =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p==0){
        try {
        Class.forName("org.sqlite.JDBC");
//        url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
        conn = java.sql.DriverManager.getConnection(url);    
        int row = tblServices1.getSelectedRow();
        String value = (tblServices1.getModel().getValueAt(row, 0).toString());
        String query ="DELETE FROM tblServices where ID = "+value;
        PreparedStatement pst = conn.prepareStatement(query);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)tblServices1.getModel();
        model.setRowCount(0);
        show_Service();
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
        clear();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }  
        }      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblServices1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServices1MouseClicked
           
        int index = tblServices1.getSelectedRow();
        TableModel model = tblServices1.getModel();
        
        
         String Type= model.getValueAt (index, 1).toString();
            switch(Type){
        
            case "Health Centers":
            ComboBoxType.setSelectedIndex(0);
            break;
            
            case "Day Care Centers":
            ComboBoxType.setSelectedIndex(1);
            break;
            
            case "Baranggay Hall":
            ComboBoxType.setSelectedIndex(2);
            break;
            
            case "Schools":
            ComboBoxType.setSelectedIndex(3);
            break;
           
            case "Religious Structure":
            ComboBoxType.setSelectedIndex(4);
            break;
            
            case "Others":
            ComboBoxType.setSelectedIndex(5);
            break;
            
                }
            
            txtOthers.setText(model.getValueAt(index, 2).toString());
            txtLocation.setText(model.getValueAt(index, 3).toString());
            txtUnits.setText(model.getValueAt(index, 4).toString());
          
        Date date = null;
        try {
        date = new SimpleDateFormat("mm/dd/yyyy").parse(model.getValueAt(index, 7).toString());
           } catch (ParseException ex) {
               Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
           }
        jDateChooser1.setDate(date);
        
     
         String Baranggay = model.getValueAt (index, 5).toString();
            switch(Baranggay){
        
            case "Poblacion":
            JComboPob.setSelectedIndex(0);
            break;
            
            case "Talomo":
            JComboPob.setSelectedIndex(1);
            break;
            
            case "Agdao":
            JComboPob.setSelectedIndex(2);
            break;
            
            case "Buhangin":
            JComboPob.setSelectedIndex(3);
            break;
            
            case "Bunawan":
            JComboPob.setSelectedIndex(4);
            break;
            
            case "Paquibato":
            JComboPob.setSelectedIndex(5);
            break;
            
            case "Baguio":
            JComboPob.setSelectedIndex(6);
            break;
            
            case "Calinan":
            JComboPob.setSelectedIndex(7);
            break;
                    
            case "Marilog":
            JComboPob.setSelectedIndex(8);
            break;
            
            case "Toril":
            JComboPob.setSelectedIndex(9);
            break;
            
            case "Tugbok":
            JComboPob.setSelectedIndex(10);
            break;
            
                }
        
          String District = model.getValueAt (index, 6).toString();
            switch(District){
        
            case "1-A":
            jComboDist.setSelectedIndex(0);
            break;
            
            case "2-A":
            jComboDist.setSelectedIndex(1);
            break;
            
            case "3-A":
            jComboDist.setSelectedIndex(2);
            break;
            
            case "4-A":
            jComboDist.setSelectedIndex(3);
            break;
            
            case "5-A":
            jComboDist.setSelectedIndex(4);
            break;
            
            case "6-A":
            jComboDist.setSelectedIndex(5);
            break;
            
            case "7-A":
            jComboDist.setSelectedIndex(6);
            break;
            
            case "8-A":
            jComboDist.setSelectedIndex(7);
            break;
                    
            case "9-A":
            jComboDist.setSelectedIndex(8);
            break;
            
            case "10-A":
            jComboDist.setSelectedIndex(9);
            break;
            
            case "11-B":
            jComboDist.setSelectedIndex(10);
            break;
            
            case "12-B":
            jComboDist.setSelectedIndex(11);
            break;
            
            case "13-B":
            jComboDist.setSelectedIndex(12);
            break;
            
            case "14-B":
            jComboDist.setSelectedIndex(13);
            break;
            
            case "15-B":
            jComboDist.setSelectedIndex(14);
            break;
            
            case "16-B":
            jComboDist.setSelectedIndex(15);
            break;
            
            case "17-B":
            jComboDist.setSelectedIndex(16);
            break;
            
            case "18-B":
            jComboDist.setSelectedIndex(17);
            break;
            
            case "19-B":
            jComboDist.setSelectedIndex(18);
            break;
            
            case "20-B":
            jComboDist.setSelectedIndex(19);
            break;
            
            case "21-C":
            jComboDist.setSelectedIndex(20);
            break;
            
            case "22-C":
            jComboDist.setSelectedIndex(21);
            break;
            
            case "23-C":
            jComboDist.setSelectedIndex(22);
            break;
            
            case "24-C":
            jComboDist.setSelectedIndex(23);
            break;
            
            case "25-C":
            jComboDist.setSelectedIndex(24);
            break;
            
            case "26-C":
            jComboDist.setSelectedIndex(25);
            break;
            
            case "27-C":
            jComboDist.setSelectedIndex(26);
            break;
            
            case "28-C":
            jComboDist.setSelectedIndex(27);
            break;
            
            case "29-C":
            jComboDist.setSelectedIndex(28);
            break;
            
            case "30-C":
            jComboDist.setSelectedIndex(29);
            break;
            
            case "31-D":
            jComboDist.setSelectedIndex(30);
            break;
            
            case "32-D":
            jComboDist.setSelectedIndex(31);
            break;
            
            case "33-D":
            jComboDist.setSelectedIndex(32);
            break;
            
            case "34-D":
            jComboDist.setSelectedIndex(33);
            break;
            
            case "35-D":
            jComboDist.setSelectedIndex(34);
            break;
            
            case "36-D":
            jComboDist.setSelectedIndex(35);
            break;
            
            case "37-D":
            jComboDist.setSelectedIndex(36);
            break;
            
            case "38-D":
            jComboDist.setSelectedIndex(37);
            break;
            
            case "39-D":
            jComboDist.setSelectedIndex(38);
            break;
            
            case "40-D":
            jComboDist.setSelectedIndex(39); 
            break;
            
            case "Bago Aplaya":
            jComboDist.setSelectedIndex(40); //------------------------40
            break;
            
            case "Bago Gallera":
            jComboDist.setSelectedIndex(41);
            break;
            
            case "Baliok":
            jComboDist.setSelectedIndex(42);
            break;
            
            case "Bucana":
            jComboDist.setSelectedIndex(43);
            break;
            
            case "Catalunan Grande":
            jComboDist.setSelectedIndex(44);
            break;
            
            case "Catalunan Pequeño":
            jComboDist.setSelectedIndex(45);
            break;
            
            case "Dumoy":
            jComboDist.setSelectedIndex(46);
            break;
            
            case "Langub":
            jComboDist.setSelectedIndex(47);
            break;
            
            case "Ma-a":
            jComboDist.setSelectedIndex(48);
            break;
            
            case "Magtuod":
            jComboDist.setSelectedIndex(49);
            break;
            
            case "Matina Aplaya":
            jComboDist.setSelectedIndex(50); //------------------------50
            break;
            
            case "Matina Crossing":
            jComboDist.setSelectedIndex(51);
            break;
            
            case "Matina Pangi":
            jComboDist.setSelectedIndex(52);
            break;
            
            case "Talomo Proper":
            jComboDist.setSelectedIndex(53);
            break;
            
            case "Agdao Proper":
            jComboDist.setSelectedIndex(54);
            break;
            
            case "Centro (San Juan)":
            jComboDist.setSelectedIndex(55);
            break;
            
            case "Gov. Paciano Bangoy":
            jComboDist.setSelectedIndex(56);
            break;
            
            case "Gov. Vicente Duterte":
            jComboDist.setSelectedIndex(57);
            break;
            
            case "Kap. Tomas Monteverde, Sr.":
            jComboDist.setSelectedIndex(58);
            break;
            
            case "Lapu-Lapu":
            jComboDist.setSelectedIndex(59); 
            break;
            
            case "Leon Garcia":
            jComboDist.setSelectedIndex(60); //-------------------------------------------60
            break;
            
            case "Rafael Castillo":
            jComboDist.setSelectedIndex(61);
            break;
            
            case "San Antonio":
            jComboDist.setSelectedIndex(62);
            break;
            
            case "Ubalde":
            jComboDist.setSelectedIndex(63);
            break;
            
            case "Wilfredo Aquino":
            jComboDist.setSelectedIndex(64);
            break;
            
            case "Acacia":
            jComboDist.setSelectedIndex(65);
            break;
            
            case "Alfonso Angliongto Sr.a":
            jComboDist.setSelectedIndex(66);
            break;
            
            case "Buhangin Proper":
            jComboDist.setSelectedIndex(67);
            break;
            
            case "Cabantian":
            jComboDist.setSelectedIndex(68);
            break;
            
            case "Callawa":
            jComboDist.setSelectedIndex(69);
            break;
            
            case "Communal":
            jComboDist.setSelectedIndex(70); //-----------------------------------70
            break;
            
            case "Indangan":
            jComboDist.setSelectedIndex(71);
            break;
            
            case "Mandug":
            jComboDist.setSelectedIndex(72);
            break;
            
            case "Pampanga":
            jComboDist.setSelectedIndex(73);
            break;
            
            case "Sasa":
            jComboDist.setSelectedIndex(74);
            break;
            
            case "Tigatto":
            jComboDist.setSelectedIndex(75);
            break;
            
            case "Vicente Hizon Sr.a":
            jComboDist.setSelectedIndex(76);
            break;
            
            case "Waan":
            jComboDist.setSelectedIndex(77);
            break;
            
            case "Alejandra Navarro (Lasang)":
            jComboDist.setSelectedIndex(78);
            break;
            
            case "Bunawan Proper":
            jComboDist.setSelectedIndex(79);
            break;
            
            case "Gatungan":
            jComboDist.setSelectedIndex(80); //------------------------------> 80
            break;
            
            case "Ilang":
            jComboDist.setSelectedIndex(81);
            break;
            
            case "Mahayag":
            jComboDist.setSelectedIndex(82);
            break;
            
            case "Mudiang":
            jComboDist.setSelectedIndex(83);
            break;
            
            case "Panacan":
            jComboDist.setSelectedIndex(84);
            break;
            
            case "San Isidro (Licanan)":
            jComboDist.setSelectedIndex(85);
            break;           
            
            case "Tibungco":
            jComboDist.setSelectedIndex(86);
            break;
            
            case "Colosas":
            jComboDist.setSelectedIndex(87);
            break;
            
            case "Fatima (Benowang)":
            jComboDist.setSelectedIndex(88);
            break;
            
            case "Lumiad":
            jComboDist.setSelectedIndex(89);
            break;
            
            case "Mabuhay":
            jComboDist.setSelectedIndex(90); //----------------------------->90
            break;
            
            case "Malabog":
            jComboDist.setSelectedIndex(91);
            break;
            
            case "Mapula":
            jComboDist.setSelectedIndex(92);
            break;
            
            case "Panalum":
            jComboDist.setSelectedIndex(93);
            break;
            
            case "Pandaitan":
            jComboDist.setSelectedIndex(94);
            break;
            
            case "Paquibato Proper":
            jComboDist.setSelectedIndex(95);
            break;
            
            case "Paradise Embak":
            jComboDist.setSelectedIndex(96);
            break;
            
            case "Salapawan":
            jComboDist.setSelectedIndex(97);
            break;
            
            case "Sumimao":
            jComboDist.setSelectedIndex(98);
            break;
            
            case "Tapak":
            jComboDist.setSelectedIndex(99);
            break;
            
            case "Baguio Proper":
            jComboDist.setSelectedIndex(100); //----------------------------->100
            break;
            
            case "Cadalian":
            jComboDist.setSelectedIndex(101);
            break;
            
            case "Carmen":
            jComboDist.setSelectedIndex(102);
            break;
            
            case "Gumalang":
            jComboDist.setSelectedIndex(103);
            break;            
            
            case "Malagos":
            jComboDist.setSelectedIndex(104);
            break;
            
            case "Tambubong":
            jComboDist.setSelectedIndex(105);
            break;
            
            case "Tawan-Tawan":
            jComboDist.setSelectedIndex(106);
            break;
            
            case "Wines":
            jComboDist.setSelectedIndex(107);
            break;
            
            case "Biao Joaquin":
            jComboDist.setSelectedIndex(108);
            break;
            
            case "Calinan Proper":
            jComboDist.setSelectedIndex(109);
            break;
            
            case "Cawayan":
            jComboDist.setSelectedIndex(110);
            break;
            
            case "Dacudao":
            jComboDist.setSelectedIndex(111);
            break;
            
            case "Dalagdag":
            jComboDist.setSelectedIndex(112);
            break;
            
            case "Dominga":
            jComboDist.setSelectedIndex(113);
            break;
            
            case "Inayangan":
            jComboDist.setSelectedIndex(114);
            break;
            
            case "Lacson":
            jComboDist.setSelectedIndex(115);
            break;
            
            case "Lamanan":
            jComboDist.setSelectedIndex(116);
            break;
            
            case "Lampianao":
            jComboDist.setSelectedIndex(117);
            break;
            
            case "Megkawayan":
            jComboDist.setSelectedIndex(118);
            break;
            
            case "Pangyan":
            jComboDist.setSelectedIndex(119);
            break;
            
            case "Riverside":
            jComboDist.setSelectedIndex(120); //-------------------------------------120
            break;
            
            case "Saloy":
            jComboDist.setSelectedIndex(121);
            break;
            
            case "Sirib":
            jComboDist.setSelectedIndex(122);
            break;
            
            case "Subasta":
            jComboDist.setSelectedIndex(123);
            break;
            
            case "Talomo River":
            jComboDist.setSelectedIndex(124);
            break;
            
            case "Tamayong":
            jComboDist.setSelectedIndex(125);
            break;
            
            case "Wangan":
            jComboDist.setSelectedIndex(126);
            break;
            
            case "Baganihan":
            jComboDist.setSelectedIndex(127);
            break;
            
            case "Bantol":
            jComboDist.setSelectedIndex(128);
            break;
            
            case "Buda":
            jComboDist.setSelectedIndex(129);
            break;
            
            
            case "Dalag":
            jComboDist.setSelectedIndex(130); //--------------------------------------130
            break;
            
            case "Datu Salumay":
            jComboDist.setSelectedIndex(131);
            break;
            
            case "Gumitan":
            jComboDist.setSelectedIndex(132);
            break;
            
            
            case "Magsaysay":
            jComboDist.setSelectedIndex(133);
            break;
            
            case "Malamba":
            jComboDist.setSelectedIndex(134);
            break;
            
            case "Marilog Proper":
            jComboDist.setSelectedIndex(135);
            break;
            
            case "Salaysay":
            jComboDist.setSelectedIndex(136);
            break;
            
            case "Suawan (Tuli)":
            jComboDist.setSelectedIndex(137);
            break;
            
            case "Tamugan":
            jComboDist.setSelectedIndex(138);
            break;
            
            case "Alambre":
            jComboDist.setSelectedIndex(139);
            break;
            
            case "Atan-Awe":
            jComboDist.setSelectedIndex(140);
            break;
            
            case "Bangkas Heights":
            jComboDist.setSelectedIndex(141);
            break;
            
            case "Baracatan":
            jComboDist.setSelectedIndex(142);
            break;
            
            case "Bato":
            jComboDist.setSelectedIndex(143);
            break;
            
            case "Bayabas":
            jComboDist.setSelectedIndex(144);
            break;
            
            case "Binugao":
            jComboDist.setSelectedIndex(145);
            break;
            
            case "Camansi":
            jComboDist.setSelectedIndex(146);
            break;
            
            case "Catigan":
            jComboDist.setSelectedIndex(147);
            break;
            
            case "Crossing Bayabas":
            jComboDist.setSelectedIndex(148);
            break;
            
            case "Daliao":
            jComboDist.setSelectedIndex(149);
            break;
            
            case "Daliaon Plantation":
            jComboDist.setSelectedIndex(150);
            break;
            
            case "Eden":
            jComboDist.setSelectedIndex(151);
            break;
            
            case "Kilate":
            jComboDist.setSelectedIndex(152);
            break;
            
            case "Lizada":
            jComboDist.setSelectedIndex(153);
            break;
            
            case "Lubogan":
            jComboDist.setSelectedIndex(154);
            break;
            
            case "Marapangi":
            jComboDist.setSelectedIndex(155);
            break;
            
            case "Mulig":
            jComboDist.setSelectedIndex(156);
            break;
           
            case "Sibulan":
            jComboDist.setSelectedIndex(157);
            break;
            
            case "Sirawan":
            jComboDist.setSelectedIndex(158);
            break;
            
            case "Tagluno":
            jComboDist.setSelectedIndex(159);
            break;
            
            case "Tagurano":
            jComboDist.setSelectedIndex(160); //------------------------------------------------>160
            break;
            
            case "Tibuloy":
            jComboDist.setSelectedIndex(161); //--------61
            break;
            
            case "Toril Proper":
            jComboDist.setSelectedIndex(162); //------62
            break;
            
            case "Tungkalan":
            jComboDist.setSelectedIndex(163); //-------------63
            break;
            
            case "Angalan":
            jComboDist.setSelectedIndex(164); //--------64
            break;
            
            case "Bago Oshiro":
            jComboDist.setSelectedIndex(165); //------------65
            break;
            
            case "Balengaeng": //--------66
            jComboDist.setSelectedIndex(166);
            break;
            
            case "Biao Escuela": //--------66
            jComboDist.setSelectedIndex(167);
            break;
            
            case "Biao Guianga": //-------67
            jComboDist.setSelectedIndex(168);
            break;
            
            case "Los Amigos":
            jComboDist.setSelectedIndex(169);
            break;
            
            case "Manambulan":
            jComboDist.setSelectedIndex(170);
            break;
            
            case "Manuel Guianga":
            jComboDist.setSelectedIndex(171);
            break;
            
            case "Matina Biao":
            jComboDist.setSelectedIndex(172);
            break;
            
            case "Mintal":
            jComboDist.setSelectedIndex(173);
            break;
            
            case "New Carmen":
            jComboDist.setSelectedIndex(174);
            break;
            
            case "New Valencia":
            jComboDist.setSelectedIndex(175);
            break;
            
            case "Santo Niño":
            jComboDist.setSelectedIndex(176);
            break;
            
            case "Tacunan":
            jComboDist.setSelectedIndex(177);
            break;
            
            case "Tagakpan":
            jComboDist.setSelectedIndex(178);
            break;
            
            case "Talandang":
            jComboDist.setSelectedIndex(179);
            break;
            
            case "Tugbok Proper":
            jComboDist.setSelectedIndex(180);
            break;
            
            case "Ulas":
            jComboDist.setSelectedIndex(181); //--------------------------->181
            break;
                               
                }
    }//GEN-LAST:event_tblServices1MouseClicked

    private void ComboBoxDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxDateItemStateChanged
          try{
            String query = "Select * from tblServices where Date=?";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1, (String) ComboBoxDate.getSelectedItem());
            ResultSet rs=pst.executeQuery();
            
            tblServices1.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
            
        }
    }//GEN-LAST:event_ComboBoxDateItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      try {
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          Connection conn = DriverManager.getConnection(url);
          int row = tblServices1.getSelectedRow();
          String value = (tblServices1.getModel().getValueAt(row, 0).toString());
          String query ="Update tblServices set Type = ?, others = ?,Location = ? , Units = ?, Baranggay = ?, District = ?, Date = ? where ID ="+value;
          PreparedStatement pst = conn.prepareStatement(query);
    
          SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
          String Baranggay;
          Baranggay = JComboPob.getSelectedItem().toString(); 
          String District;
          District = jComboDist.getSelectedItem().toString(); 
          String type;
          type = ComboBoxType.getSelectedItem().toString();     
          pst.setString(1, type); 
          pst.setString(2, txtOthers.getText());
          pst.setString(3, txtLocation.getText()); 
          pst.setString(4, txtUnits.getText()); 
          pst.setString(5, Baranggay); 
          pst.setString(6, District); 
          pst.setString(7, date);
          pst.executeUpdate(); 
          DefaultTableModel model = (DefaultTableModel)tblServices1.getModel();
          model.setRowCount(1);
          show_Service();
          JOptionPane.showMessageDialog(null, "Update Successfully");
          clear();                                  
            }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
          } 
     
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAddServiceInArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddServiceInArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddServiceInArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddServiceInArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmAddServiceInArea().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmAddServiceInArea.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmAddServiceInArea.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxDate;
    private javax.swing.JComboBox<String> ComboBoxType;
    private javax.swing.JComboBox<String> JComboPob;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboDist;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServices1;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtOthers;
    private javax.swing.JTextField txtUnits;
    // End of variables declaration//GEN-END:variables
}
