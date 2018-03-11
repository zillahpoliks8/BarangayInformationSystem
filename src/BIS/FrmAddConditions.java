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
 * @author Rannie Claire
 */
public class FrmAddConditions extends javax.swing.JFrame {

    /**
     * Creates new form FrmAddConditions
     */
    public FrmAddConditions() throws SQLException, ClassNotFoundException {
        initComponents();
        show_Condition();
        ComboboxDate();
        Fillcombo();
        this.setLocationRelativeTo(null);
        if(SQLite.openDB()){
            String[][] data = SQLite.read("tblCondition");
            String[] column = {"ID","Condition","Location","Sitio", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblConditions1.setModel(model);
            SQLite.closeDB();
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
            String sql = "Select * from tblCondition";
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                String Condition = rs.getString("Condition");
                ComboBoxConditions.addItem(Condition);
            }
    } catch(Exception e){
    
    JOptionPane.showMessageDialog(null, e);
    }
    }
        public void ComboboxDate(){
     try{
          Class.forName("org.sqlite.JDBC");
          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          Connection conn = DriverManager.getConnection(url);
          SQLite.openDB();
          String query = "Select DISTINCT Date from tblCondition";
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
        ComboBoxConditions = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        txtSitio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConditions1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        ComboBoxDate = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Families living in conditions"));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Conditions"));

        ComboBoxConditions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Coastal&Island", "Riverbanks&Waterways", "Under Bridges", "Streets" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBoxConditions, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboBoxConditions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Date");

        jLabel3.setText("Location (Pls. Specify)");

        jLabel4.setText("No. of families to be affected per sitio");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Add New.png"))); // NOI18N
        jButton1.setText("New");
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

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Save.png"))); // NOI18N
        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Cancel.png"))); // NOI18N
        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tblConditions1.setBackground(new java.awt.Color(153, 153, 153));
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
        jScrollPane1.setViewportView(tblConditions1);

        ComboBoxDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxDateItemStateChanged(evt);
            }
        });

        jLabel2.setText("Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(txtLocation)
                                            .addComponent(txtSitio)))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 20, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(61, 61, 61)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSitio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3)
                                .addComponent(jButton2)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
          Class.forName("org.sqlite.JDBC");
          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          Connection conn = DriverManager.getConnection(url);
          String query ="Insert into tblCondition(Condition, Location, Sitio, Date)values(?,?,?,?)";
          PreparedStatement pst = null;  
          pst = conn.prepareStatement(query);     
          SimpleDateFormat dFormat = new SimpleDateFormat("yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
          String Conditions;
          Conditions = ComboBoxConditions.getSelectedItem().toString();     
          pst.setString(1, Conditions); 
          pst.setString(2, txtLocation.getText());
          pst.setString(3, txtSitio.getText()); 
          pst.setString(4, date);
          pst.executeUpdate(); 
          DefaultTableModel model = (DefaultTableModel)tblConditions1.getModel();
          model.setRowCount(1);
          show_Condition();
          JOptionPane.showMessageDialog(null, "Added Successfully");
          clear();                                  
            }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
          }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
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
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     txtLocation.setText("");
     txtSitio.setText("");   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
          Class.forName("org.sqlite.JDBC");
          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          Connection conn = DriverManager.getConnection(url);
          int row = tblConditions1.getSelectedRow();
          String value = (tblConditions1.getModel().getValueAt(row, 0).toString());
          String query ="Update tblCondition set Condition = ?,Location = ? ,Sitio = ?, Date = ? where ID ="+value;
          PreparedStatement pst = null;  
          pst = conn.prepareStatement(query);      
          SimpleDateFormat dFormat = new SimpleDateFormat("yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
          String Conditions;
          Conditions = ComboBoxConditions.getSelectedItem().toString();     
          pst.setString(1, Conditions); 
          pst.setString(2, txtLocation.getText());
          pst.setString(3, txtSitio.getText()); 
          pst.setString(4,date);
          pst.executeUpdate(); 
          DefaultTableModel model = (DefaultTableModel)tblConditions1.getModel();
          model.setRowCount(1);
          show_Condition();
          JOptionPane.showMessageDialog(null, "Updated Successfully");
          clear();                                  
            }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
          }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
        clear();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }  
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblConditions1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConditions1MouseClicked
       int index = tblConditions1.getSelectedRow();
        TableModel model = tblConditions1.getModel();
//      txtID.setText(model.getValueAt(index, 0).toString());
        txtLocation.setText(model.getValueAt(index, 2).toString());
        txtSitio.setText(model.getValueAt(index, 3).toString());
          Date date = null;
        try {
        date = new SimpleDateFormat("yyyy").parse(model.getValueAt(index, 4).toString());
           } catch (ParseException ex) {
               Logger.getLogger(FrmAddBDRRMC.class.getName()).log(Level.SEVERE, null, ex);
           }
        jDateChooser1.setDate(date);
   
 
        String Condition = model.getValueAt (index, 1).toString();
            switch(Condition){
        
            case "Coastal&Island":
            ComboBoxConditions.setSelectedIndex(0);
            break;
            
            case "Riverbanks&Waterways":
            ComboBoxConditions.setSelectedIndex(1);
            break;
            
            case "Under Bridges":
            ComboBoxConditions.setSelectedIndex(2);
            break;
            
            case "Streets":
            ComboBoxConditions.setSelectedIndex(3);
            break;
                    
                }
        
    }//GEN-LAST:event_tblConditions1MouseClicked

    private void ComboBoxDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxDateItemStateChanged
         try{
            Connection conn = DriverManager.getConnection(url);
            String query = "Select * from tblCondition where Date=?";
             try (PreparedStatement pst = conn.prepareStatement(query)) {
                 pst.setString(1, (String) ComboBoxDate.getSelectedItem());
                 ResultSet rs=pst.executeQuery();
                 
                 tblConditions1.setModel(DbUtils.resultSetToTableModel(rs));
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
            java.util.logging.Logger.getLogger(FrmAddConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddConditions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmAddConditions().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmAddConditions.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmAddConditions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxConditions;
    private javax.swing.JComboBox<String> ComboBoxDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConditions1;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtSitio;
    // End of variables declaration//GEN-END:variables
}
