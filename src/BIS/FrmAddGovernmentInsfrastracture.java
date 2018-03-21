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
public class FrmAddGovernmentInsfrastracture extends javax.swing.JFrame {

    /**
     * Creates new form FrmAddGovernmentInsfrastracture
     */
    public FrmAddGovernmentInsfrastracture() throws SQLException, ClassNotFoundException{
         initComponents();
         show_Infrastructure();
         ComboboxDate();
//         Fillcombo();
        this.setLocationRelativeTo(null);
        if(SQLite.openDB()){
            String[][] data = SQLite.read("tblInfrastracture");
            String[] column = {"ID","Infrastracture","Location","Sitio","Baranggay","District", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblInfrastracture1.setModel(model);
            SQLite.closeDB();
        }
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
            txtSitio.setText("");    
        }
        
        public void Fillcombo() throws SQLException{
        try{
            String sql = "Select * from tblInfrastracture";
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                String Condition = rs.getString("Infrastracture");
                ComboBoxInfrastracture.addItem(Condition);
                String Baranggay = rs.getString("Baranggay");
                JComboPob.addItem(Baranggay);
                String District = rs.getString("District");
                jComboDist.addItem(District);
            }
    } catch(Exception e){
    
    JOptionPane.showMessageDialog(null, e);
    }
    }
        public void ComboboxDate(){
     try{
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          Connection conn = DriverManager.getConnection(url);
          SQLite.openDB();
          String query = "Select DISTINCT Date from tblInfrastracture";
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ComboBoxInfrastracture = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSitio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInfrastracture1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        JComboPob = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxDate = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboDist = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Government Infrastructure");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Government Infrastracture"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Government Infrastracture"));

        ComboBoxInfrastracture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roads", "Bridges", "Water", "Covered Courts", "Gym", "Drainage System", "Evacuation Centers", "Multi-purpose Bldgs." }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBoxInfrastracture, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(ComboBoxInfrastracture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Location.png"))); // NOI18N
        jLabel1.setText("Location");

        jLabel2.setText("No. of units");

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
        jScrollPane1.setViewportView(tblInfrastracture1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Delete.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Back.png"))); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Date.png"))); // NOI18N
        jLabel3.setText("Date");

        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Update User.png"))); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Baranggay ");

        JComboPob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Poblacion", "Talomo ", "Agdao", "Buhangin", "Bunawan", "Paquibato", "Baguio ", "Calinan ", "Marilog ", "Toril", "Tugbok" }));

        jLabel5.setText("Year");

        ComboBoxDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxDateItemStateChanged(evt);
            }
        });

        jLabel6.setText("District");

        jComboDist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-A", "2-A", "3-A", "4-A", "5-A", "6-A", "7-A", "8-A", "9-A", "10-A", "11-B", "12-B", "13-B", "14-B", "15-B", "16-B", "17-B", "18-B", "19-B", "20-B", "21-C", "22-C", "23-C", "24-C", "25-C", "26-C", "27-C", "28-C", "29-C", "30-C", "31-D", "32-D", "33-D", "34-D", "35-D", "36-D", "37-D", "38-D", "39-D", "40-D", "Bago Aplaya", "Bago Gallera", "Baliok", "Bucana", "Catalunan Grande", "Catalunan Pequeño", "Dumoy", "Langub", "Ma-a", "Magtuod", "Matina Aplaya", "Matina Crossing", "Matina Pangi", "Talomo Proper", "Agdao Proper", "Centro (San Juan)", "Gov. Paciano Bangoy", "Gov. Vicente Duterte", "Kap. Tomas Monteverde, Sr.", "Lapu-Lapu", "Leon Garcia", "Rafael Castillo", "San Antonio", "Ubalde", "Wilfredo Aquino", "Acacia", "Alfonso Angliongto Sr.a", "Buhangin Proper", "Cabantian", "Callawa", "Communal", "Indangan", "Mandug", "Pampanga", "Sasa", "Tigatto", "Vicente Hizon Sr.a", "Waan", "Alejandra Navarro (Lasang)", "Bunawan Proper", "Gatungan", "Ilang", "Mahayag", "Mudiang", "Panacan", "San Isidro (Licanan)", "Tibungco", "Colosas", "Fatima (Benowang)", "Lumiad", "Mabuhay", "Malabog", "Mapula", "Panalum", "Pandaitan", "Paquibato Proper", "Paradise Embak", "Salapawan", "Sumimao", "Tapak", "Baguio Proper", "Cadalian", "Carmen", "Gumalang", "Malagos", "Tambubong", "Tawan-Tawan", "Wines", "Biao Joaquin", "Calinan Proper", "Cawayan", "Dacudao", "Dalagdag", "Dominga", "Inayangan", "Lacson", "Lamanan", "Lampianao", "Megkawayan", "Pangyan", "Riverside", "Saloy", "Sirib", "Subasta", "Talomo River", "Tamayong", "Wangan", "Baganihan", "Bantol", "Buda", "Dalag", "Datu Salumay", "Gumitan", "Magsaysay", "Malamba", "Marilog Proper", "Salaysay", "Suawan (Tuli)", "Tamugan", "Alambre", "Atan-Awe", "Bangkas Heights", "Baracatan", "Bato", "Bayabas", "Binugao", "Camansi", "Catigan", "Crossing Bayabas", "Daliao", "Daliaon Plantation", "Eden", "Kilate", "Lizada", "Lubogan", "Marapangi", "Mulig", "Sibulan", "Sirawan", "Tagluno", "Tagurano", "Tibuloy", "Toril Proper", "Tungkalan", "Angalan", "Bago Oshiro", "Balengaeng", "Biao Escuela", "Biao Guianga", "Los Amigos", "Manambulan", "Manuel Guianga", "Matina Biao", "Mintal", "New Carmen", "New Valencia", "Santo Niño", "Tacunan", "Tagakpan", "Talandang", "Tugbok Proper", "Ula" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSitio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addComponent(txtLocation, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JComboPob, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboDist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JComboPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSitio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(Update)
                            .addComponent(jButton2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton1))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblInfrastracture1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInfrastracture1MouseClicked
  int index = tblInfrastracture1.getSelectedRow();
        TableModel model = tblInfrastracture1.getModel();
//      txtID.setText(model.getValueAt(index, 0).toString());
        txtLocation.setText(model.getValueAt(index, 2).toString());
        txtSitio.setText(model.getValueAt(index, 3).toString());
          Date date = null;
        try {
        date = new SimpleDateFormat("mm/dd/yyyy").parse(model.getValueAt(index, 6).toString());
           } catch (ParseException ex) {
               Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
           }
        jDateChooser1.setDate(date);
   
 
        String Infrastracture = model.getValueAt (index, 1).toString();
            switch(Infrastracture){
        
            case "Roads":
            ComboBoxInfrastracture.setSelectedIndex(0);
            break;
            
            case "Bridges":
            ComboBoxInfrastracture.setSelectedIndex(1);
            break;
            
            case "Water":
            ComboBoxInfrastracture.setSelectedIndex(2);
            break;
            
            case "Covered Courts":
            ComboBoxInfrastracture.setSelectedIndex(3);
            break;
            
             case "Gym":
            ComboBoxInfrastracture.setSelectedIndex(4);
            break;
            
             case "Drainage System":
            ComboBoxInfrastracture.setSelectedIndex(5);
            break;
            
             case "Multi-purpose Bldgs.":
            ComboBoxInfrastracture.setSelectedIndex(6);
            break;
                    
                }
        String Baranggay = model.getValueAt (index, 4).toString();
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
        
          String District = model.getValueAt (index, 5).toString();
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
    }//GEN-LAST:event_tblInfrastracture1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     txtLocation.setText("");
     txtSitio.setText("");        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   try {
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          Connection conn = DriverManager.getConnection(url);
          String query ="Insert into tblInfrastracture(Infrastracture, Location, Sitio, Baranggay, District, Date)values(?,?,?,?,?,?)";
          PreparedStatement pst = null;  
          pst = conn.prepareStatement(query);     
          SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
          String Baranggay;
          Baranggay = JComboPob.getSelectedItem().toString(); 
          String District;
          District = jComboDist.getSelectedItem().toString(); 
          String Infrastracture;
          Infrastracture = ComboBoxInfrastracture.getSelectedItem().toString();     
          pst.setString(1, Infrastracture); 
          pst.setString(2, txtLocation.getText());
          pst.setString(3, txtSitio.getText()); 
          pst.setString(4, Baranggay); 
          pst.setString(5, District); 
          pst.setString(6, date);
          pst.executeUpdate(); 
          DefaultTableModel model = (DefaultTableModel)tblInfrastracture1.getModel();
          model.setRowCount(1);
          show_Infrastructure();
          JOptionPane.showMessageDialog(null, "Added Successfully");
          clear();                                  
            }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
          }      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int s =JOptionPane.showConfirmDialog(null,  "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (s==0){
        try {
        Class.forName("org.sqlite.JDBC");
//        url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
        conn = java.sql.DriverManager.getConnection(url);    
        int row = tblInfrastracture1.getSelectedRow();
        String value = (tblInfrastracture1.getModel().getValueAt(row, 0).toString());
        String query ="DELETE FROM tblInfrastracture where ID = "+value;
        PreparedStatement pst = conn.prepareStatement(query);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)tblInfrastracture1.getModel();
        model.setRowCount(0);
        show_Infrastructure();
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
        clear();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }  
        }         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
   try {
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          Connection conn = DriverManager.getConnection(url);
          int row = tblInfrastracture1.getSelectedRow();
          String value = (tblInfrastracture1.getModel().getValueAt(row, 0).toString());
          String query ="Update tblCondition set Infrastracture = ?,Location = ? ,Sitio = ?,Baranggay = ?, District = ?, Date = ? where ID ="+value;
          PreparedStatement pst = null;  
          pst = conn.prepareStatement(query);      
          SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
          String Baranggay;
          Baranggay = JComboPob.getSelectedItem().toString(); 
          String District;
          District = jComboDist.getSelectedItem().toString(); 
          String Infrastracture;
          Infrastracture = ComboBoxInfrastracture.getSelectedItem().toString();     
          pst.setString(1, Infrastracture); 
          pst.setString(2, txtLocation.getText());
          pst.setString(3, txtSitio.getText()); 
          pst.setString(4, Baranggay); 
          pst.setString(5, District); 
          pst.setString(6, date);
          pst.executeUpdate(); 
          DefaultTableModel model = (DefaultTableModel)tblInfrastracture1.getModel();
          model.setRowCount(1);
          show_Infrastructure();
          JOptionPane.showMessageDialog(null, "Updated Successfully");
          clear();                                  
            }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
          }        
    }//GEN-LAST:event_UpdateActionPerformed

    private void ComboBoxDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxDateItemStateChanged
        try{
            Connection conn = DriverManager.getConnection(url);
            String query = "Select * from tblInfrastracture where Date=?";
             try (PreparedStatement pst = conn.prepareStatement(query)) {
                 pst.setString(1, (String) ComboBoxDate.getSelectedItem());
                 ResultSet rs=pst.executeQuery();
                 
                 tblInfrastracture1.setModel(DbUtils.resultSetToTableModel(rs));
             }
        }
        catch (Exception ex){
            ex.printStackTrace();
            
        }
    }//GEN-LAST:event_ComboBoxDateItemStateChanged

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
            java.util.logging.Logger.getLogger(FrmAddGovernmentInsfrastracture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddGovernmentInsfrastracture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddGovernmentInsfrastracture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddGovernmentInsfrastracture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                try {
                    new FrmAddGovernmentInsfrastracture().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmAddGovernmentInsfrastracture.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmAddGovernmentInsfrastracture.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxDate;
    private javax.swing.JComboBox<String> ComboBoxInfrastracture;
    private javax.swing.JComboBox<String> JComboPob;
    private javax.swing.JButton Update;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInfrastracture1;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtSitio;
    // End of variables declaration//GEN-END:variables

   
}
