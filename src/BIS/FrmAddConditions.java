/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIS;

import static BIS.SQLite.conn;
import static BIS.SQLite.url;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
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
//        Fillcombo();
        this.setLocationRelativeTo(null);
        if(SQLite.openDB()){
            String[][] data = SQLite.read("tblCondition");
            String[] column = {"ID","Condition","Location","Sitio","Baranggay","District", "Date"};
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, column);
            this.tblConditions1.setModel(model);
            SQLite.closeDB();
        }
        
      
//	Vector v =new Vector();
//	v.add("Poblacion");
//	v.add(new JCheckBox("1-A", false));
//	v.add(new JCheckBox("2-A", false));
//	v.add(new JCheckBox("3-A", false));
//	v.add(new JCheckBox("4-A", false));
//	v.add(new JCheckBox("5-A", false));
//	v.add(new JCheckBox("6-A", false));
//	v.add(new JCheckBox("7-A", false));
//	v.add(new JCheckBox("8-A", false));
//	v.add(new JCheckBox("9-A", false));
//	v.add(new JCheckBox("10-A",false));
//	v.add(new JCheckBox("11-B", false));
//	v.add(new JCheckBox("12-B", false));
//	v.add(new JCheckBox("13-B", false));
//	v.add(new JCheckBox("14-B", false));
//	v.add(new JCheckBox("15-B", false));
//	v.add(new JCheckBox("16-B", false));
//	v.add(new JCheckBox("17-B", false));
//	v.add(new JCheckBox("18-B", false));
//	v.add(new JCheckBox("19-B", false));
//	v.add(new JCheckBox("20-B",false));
//	v.add(new JCheckBox("21-C", false));
//	v.add(new JCheckBox("22-C", false));
//	v.add(new JCheckBox("23-C", false));
//	v.add(new JCheckBox("24-C", false));
//	v.add(new JCheckBox("25-C", false));
//	v.add(new JCheckBox("26-C", false));
//	v.add(new JCheckBox("27-C", false));
//	v.add(new JCheckBox("28-C", false));
//	v.add(new JCheckBox("29-C", false));
//	v.add(new JCheckBox("30-C",false));
//	v.add(new JCheckBox("31-D", false));
//	v.add(new JCheckBox("32-D", false));
//	v.add(new JCheckBox("33-D", false));
//	v.add(new JCheckBox("34-D", false));
//	v.add(new JCheckBox("35-D", false));
//	v.add(new JCheckBox("36-D", false));
//	v.add(new JCheckBox("37-D", false));
//	v.add(new JCheckBox("38-D", false));
//	v.add(new JCheckBox("39-D", false));
//	v.add(new JCheckBox("40-D",false));
//
//
//	v.add("Talomo");
//	v.add(new JCheckBox("Bago Aplaya", false));
//	v.add(new JCheckBox("Bago Gallera", false));
//	v.add(new JCheckBox("Baliok", false));
//	v.add(new JCheckBox("Bucana", false));
//	v.add(new JCheckBox("Catalunan Grande", false));
//	v.add(new JCheckBox("Catalunan Pequeño", false));
//	v.add(new JCheckBox("Dumoy", false));
//	v.add(new JCheckBox("Langub", false));
//	v.add(new JCheckBox("Ma-a", false));
//	v.add(new JCheckBox("Magtuod", false));
//	v.add(new JCheckBox("Matina Aplaya", false));
//	v.add(new JCheckBox("Matina Crossing", false));
//	v.add(new JCheckBox("Matina Pangi", false));
//	v.add(new JCheckBox("Talomo Proper", false));
//	
//	v.add("Agdao");
//	v.add(new JCheckBox("Agdao Proper", false));
//	v.add(new JCheckBox("Centro (San Juan)", false));
//	v.add(new JCheckBox("Gov. Paciano Bangoy", false));
//	v.add(new JCheckBox("Gov. Vicente Duterte", false));
//	v.add(new JCheckBox("Kap. Tomas Monteverde, Sr.", false));
//	v.add(new JCheckBox("Lapu-Lapu", false));
//	v.add(new JCheckBox("Leon Garcia", false));
//	v.add(new JCheckBox("Rafael Castillo", false));
//	v.add(new JCheckBox("San Antonio", false));
//	v.add(new JCheckBox("Ubalde", false));
//	v.add(new JCheckBox("Wilfredo Aquino", false));
//	
//	v.add("Buhangin");
//	v.add(new JCheckBox("Acacia", false));
//	v.add(new JCheckBox("Alfonso Angliongto Sr.a", false));
//	v.add(new JCheckBox("Buhangin Proper", false));
//	v.add(new JCheckBox("Cabantian", false));
//	v.add(new JCheckBox("Callawa", false));
//	v.add(new JCheckBox("Communal", false));
//	v.add(new JCheckBox("Indangan", false));
//	v.add(new JCheckBox("Mandug", false));
//	v.add(new JCheckBox("Pampanga", false));
//	v.add(new JCheckBox("Sasa", false));
//	v.add(new JCheckBox("Tigatto", false));	
//	v.add(new JCheckBox("Vicente Hizon Sr.a", false));
//	v.add(new JCheckBox("Waan", false));
//
//	v.add("Bunawan");
//	v.add(new JCheckBox("Alejandra Navarro (Lasang)", false));
//	v.add(new JCheckBox("Bunawan Proper", false));
//	v.add(new JCheckBox("Gatungan", false));
//	v.add(new JCheckBox("Ilang", false));
//	v.add(new JCheckBox("Mahayag", false));
//	v.add(new JCheckBox("Mudiang", false));
//	v.add(new JCheckBox("Panacan", false));
//	v.add(new JCheckBox("San Isidro (Licanan)", false));
//	v.add(new JCheckBox("Tibungco", false));
//
//	v.add("Paquibato");
//	v.add(new JCheckBox("Colosas", false));
//	v.add(new JCheckBox("Fatima (Benowang)", false));
//	v.add(new JCheckBox("Lumiad", false));
//	v.add(new JCheckBox("Mabuhay", false));
//	v.add(new JCheckBox("Malabog", false));
//	v.add(new JCheckBox("Mapula", false));
//	v.add(new JCheckBox("Panalum", false));
//	v.add(new JCheckBox("Pandaitan", false));
//	v.add(new JCheckBox("Paquibato Proper", false));
//	v.add(new JCheckBox("Paradise Embak", false));
//	v.add(new JCheckBox("Salapawan", false));
//	v.add(new JCheckBox("Sumimao", false));
//	v.add(new JCheckBox("Tapak", false));
//	
// 	v.add("Baguio");
//	v.add(new JCheckBox("Baguio Proper", false));
//	v.add(new JCheckBox("Cadalian", false));
//	v.add(new JCheckBox("Carmen", false));
//	v.add(new JCheckBox("Gumalang", false));
//	v.add(new JCheckBox("Malagos", false));
//	v.add(new JCheckBox("Tambubong", false));
//	v.add(new JCheckBox("Tawan-Tawan", false));
//	v.add(new JCheckBox("Wines", false));
//
//	
// 	v.add("Calinan");
//	v.add(new JCheckBox("Biao Joaquin", false));
//	v.add(new JCheckBox("Calinan Proper", false));
//	v.add(new JCheckBox("Cawayan", false));
//	v.add(new JCheckBox("Dacudao", false));
//	v.add(new JCheckBox("Dalagdag", false)); 
//	v.add(new JCheckBox("Dominga", false));
//	v.add(new JCheckBox("Inayangan", false));
//	v.add(new JCheckBox("Lacson", false));
//	v.add(new JCheckBox("Lamanan", false)); 
//	v.add(new JCheckBox("Lampianao", false));
//	v.add(new JCheckBox("Megkawayan", false));
//	v.add(new JCheckBox("Pangyan", false));
//	v.add(new JCheckBox("Riverside", false)); 
//	v.add(new JCheckBox("Saloy", false));
//	v.add(new JCheckBox("Sirib", false));
//	v.add(new JCheckBox("Subasta", false));
//	v.add(new JCheckBox("Talomo River", false));
//	v.add(new JCheckBox("Tamayong", false));
//	v.add(new JCheckBox("Wangan", false));
//
//	v.add("Marilog");
//	v.add(new JCheckBox("Baganihan", false));
//	v.add(new JCheckBox("Bantol", false));
//	v.add(new JCheckBox("Buda", false));
//	v.add(new JCheckBox("Dalag", false));
//	v.add(new JCheckBox("Datu Salumay", false)); 
//	v.add(new JCheckBox("Gumitan", false));
//	v.add(new JCheckBox("Magsaysay", false));
//	v.add(new JCheckBox("Malamba", false));
//	v.add(new JCheckBox("Marilog Proper", false)); 
//	v.add(new JCheckBox("Salaysay", false));
//	v.add(new JCheckBox("Suawan (Tuli)", false));
//	v.add(new JCheckBox("Tamugan", false));
//
//	v.add("Toril");
//	v.add(new JCheckBox("Alambre", false));
//	v.add(new JCheckBox("Atan-Awe", false));
//	v.add(new JCheckBox("Bangkas Heights", false));
//	v.add(new JCheckBox("Baracatan", false));
//	v.add(new JCheckBox("Bato", false)); 
//	v.add(new JCheckBox("Bayabas", false));
//	v.add(new JCheckBox("Binugao", false));
//	v.add(new JCheckBox("Camansi", false));
//	v.add(new JCheckBox("Catigan", false)); 
//	v.add(new JCheckBox("Crossing Bayabas", false));
//	v.add(new JCheckBox("Daliao", false));
//	v.add(new JCheckBox("Daliaon Plantation", false));
//	v.add(new JCheckBox("Eden", false));
//	v.add(new JCheckBox("Kilate", false)); 
//	v.add(new JCheckBox("Lizada", false));
//	v.add(new JCheckBox("Lubogan", false));
//	v.add(new JCheckBox("Marapangi", false));
//	v.add(new JCheckBox("Mulig", false));
//	v.add(new JCheckBox("Sibulan", false)); 
//	v.add(new JCheckBox("Sirawan", false));
//	v.add(new JCheckBox("Tagluno", false));
//	v.add(new JCheckBox("Tagurano", false));
//	v.add(new JCheckBox("Tibuloy", false));
//	v.add(new JCheckBox("Toril Proper", false)); 
//	v.add(new JCheckBox("Tungkalan", false));
//	
//	v.add("Tugbok");
//	v.add(new JCheckBox("Angalan", false));
//	v.add(new JCheckBox("Bago Oshiro", false));
//	v.add(new JCheckBox("Balengaeng", false));
//	v.add(new JCheckBox("Biao Escuela", false));
//	v.add(new JCheckBox("Biao Guianga", false)); 
//	v.add(new JCheckBox("Los Amigos", false));
//	v.add(new JCheckBox("Manambulan", false));
//	v.add(new JCheckBox("Manuel Guianga", false));
//	v.add(new JCheckBox("Matina Biao", false)); 
//	v.add(new JCheckBox("Mintal", false));
//	v.add(new JCheckBox("New Carmen", false));
//	v.add(new JCheckBox("New Valencia", false));
//	v.add(new JCheckBox("Santo Niño", false));
//	v.add(new JCheckBox("Tacunan", false)); 
//	v.add(new JCheckBox("Tagakpan", false));
//	v.add(new JCheckBox("Talandang", false));
//	v.add(new JCheckBox("Tugbok Proper", false));
//	v.add(new JCheckBox("Ula", false));
//	
//        getContentPane().add(new  CustomComboCheck(v));
//        }
//    
////  public static void main(String[] args) throws SQLException, ClassNotFoundException  
////  {
////        FrmAddConditions cb= new FrmAddConditions();
////	  cb.setSize(350,350);
////	  cb.setVisible(true);
////  }
//    
//    class CustomComboCheck extends JComboBox{
//        public CustomComboCheck(Vector v){
//	super(v);
//        //set renderer
//        //set listener
//	addActionListener(new ActionListener(){
//	
//            @Override
//	public void actionPerformed(ActionEvent ae){
//	ourItemSelectedd();
//}
//        });
//} 
//        private void ourItemSelectedd()
//{
//    Object selected = getSelectedItem();
//	
//    if(selected instanceof JCheckBox)
//{
//	JCheckBox chk = (JCheckBox) selected;
//	chk.setSelected(!chk.isSelected());
//	repaint();
//	
//	Object[] selections = chk.getSelectedObjects();
//	if(selections !=null)
//	{
//	for(Object lastItem : selections)
//	{
//		JOptionPane.showMessageDialog(null, lastItem.toString());
//	}
//}
//}
//}
//}
//
////Render CheckBox in ComboB
//   class Comborender implements ListCellRenderer{
//       private JLabel label;
//        @Override
//        public Component getListCellRendererComponent(JList list, Object val, int index, boolean selected, boolean focused) {
//            
//        if(val instanceof Component){
//            Component c = (Component) val;
//	if(selected)
//        {
//	c.setBackground(list.getBackground());
//	c.setBackground(list.getForeground());
//        }
//        return c;
//        }else
//        if(label == null)
//        {
//        label = new JLabel(val.toString());
//        }else
//        {
//        label.setText(val.toString());
//        }
//        return label;
//        }   
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
//             String url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";
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
        jLabel5 = new javax.swing.JLabel();
        JComboPob = new javax.swing.JComboBox<>();
        jComboDist = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Families living in conditions"));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Date.png"))); // NOI18N
        jLabel1.setText("Date");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Location.png"))); // NOI18N
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

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons8/Back.png"))); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Year");

        jLabel5.setText("Baranggay");

        JComboPob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Poblacion", "Talomo ", "Agdao", "Buhangin", "Bunawan", "Paquibato", "Baguio ", "Calinan ", "Marilog ", "Toril", "Tugbok" }));
        JComboPob.setToolTipText("");
        JComboPob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboPobActionPerformed(evt);
            }
        });

        jComboDist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-A", "2-A", "3-A", "4-A", "5-A", "6-A", "7-A", "8-A", "9-A", "10-A", "11-B", "12-B", "13-B", "14-B", "15-B", "16-B", "17-B", "18-B", "19-B", "20-B", "21-C", "22-C", "23-C", "24-C", "25-C", "26-C", "27-C", "28-C", "29-C", "30-C", "31-D", "32-D", "33-D", "34-D", "35-D", "36-D", "37-D", "38-D", "39-D", "40-D", "Bago Aplaya", "Bago Gallera", "Baliok", "Bucana", "Catalunan Grande", "Catalunan Pequeño", "Dumoy", "Langub", "Ma-a", "Magtuod", "Matina Aplaya", "Matina Crossing", "Matina Pangi", "Talomo Proper", "Agdao Proper", "Centro (San Juan)", "Gov. Paciano Bangoy", "Gov. Vicente Duterte", "Kap. Tomas Monteverde, Sr.", "Lapu-Lapu", "Leon Garcia", "Rafael Castillo", "San Antonio", "Ubalde", "Wilfredo Aquino", "Acacia", "Alfonso Angliongto Sr.a", "Buhangin Proper", "Cabantian", "Callawa", "Communal", "Indangan", "Mandug", "Pampanga", "Sasa", "Tigatto", "Vicente Hizon Sr.a", "Waan", "Alejandra Navarro (Lasang)", "Bunawan Proper", "Gatungan", "Ilang", "Mahayag", "Mudiang", "Panacan", "San Isidro (Licanan)", "Tibungco", "Colosas", "Fatima (Benowang)", "Lumiad", "Mabuhay", "Malabog", "Mapula", "Panalum", "Pandaitan", "Paquibato Proper", "Paradise Embak", "Salapawan", "Sumimao", "Tapak", "Baguio Proper", "Cadalian", "Carmen", "Gumalang", "Malagos", "Tambubong", "Tawan-Tawan", "Wines", "Biao Joaquin", "Calinan Proper", "Cawayan", "Dacudao", "Dalagdag", "Dominga", "Inayangan", "Lacson", "Lamanan", "Lampianao", "Megkawayan", "Pangyan", "Riverside", "Saloy", "Sirib", "Subasta", "Talomo River", "Tamayong", "Wangan", "Baganihan", "Bantol", "Buda", "Dalag", "Datu Salumay", "Gumitan", "Magsaysay", "Malamba", "Marilog Proper", "Salaysay", "Suawan (Tuli)", "Tamugan", "Alambre", "Atan-Awe", "Bangkas Heights", "Baracatan", "Bato", "Bayabas", "Binugao", "Camansi", "Catigan", "Crossing Bayabas", "Daliao", "Daliaon Plantation", "Eden", "Kilate", "Lizada", "Lubogan", "Marapangi", "Mulig", "Sibulan", "Sirawan", "Tagluno", "Tagurano", "Tibuloy", "Toril Proper", "Tungkalan", "Angalan", "Bago Oshiro", "Balengaeng", "Biao Escuela", "Biao Guianga", "Los Amigos", "Manambulan", "Manuel Guianga", "Matina Biao", "Mintal", "New Carmen", "New Valencia", "Santo Niño", "Tacunan", "Tagakpan", "Talandang", "Tugbok Proper", "Ula" }));

        jLabel6.setText("District");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(37, 37, 37)
                                        .addComponent(JComboPob, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboDist, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(txtLocation)
                                        .addComponent(txtSitio)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(ComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JComboPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jComboDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSitio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton4)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jButton5)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
          Class.forName("org.sqlite.JDBC");
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          Connection conn = DriverManager.getConnection(url);
          String query ="Insert into tblCondition(Condition, Location, Sitio, Baranggay, District, Date)values(?,?,?,?,?,?)";
          PreparedStatement pst = null;  
          pst = conn.prepareStatement(query);     
          SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
          String Baranggay;
          Baranggay = JComboPob.getSelectedItem().toString(); 
          String District;
          District = jComboDist.getSelectedItem().toString(); 
          String Conditions;
          Conditions = ComboBoxConditions.getSelectedItem().toString();     
          pst.setString(1, Conditions); 
          pst.setString(2, txtLocation.getText());
          pst.setString(3, txtSitio.getText()); 
          pst.setString(4, Baranggay); 
          pst.setString(5, District); 
          pst.setString(6, date);
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
//          url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
          Connection conn = DriverManager.getConnection(url);
          int row = tblConditions1.getSelectedRow();
          String value = (tblConditions1.getModel().getValueAt(row, 0).toString());
          String query ="Update tblCondition set Condition = ?,Location = ? ,Sitio = ?,Baranggay = ?, District = ?, Date = ? where ID ="+value;
          PreparedStatement pst = null;  
          pst = conn.prepareStatement(query);      
          SimpleDateFormat dFormat = new SimpleDateFormat("mm/dd/yyyy");
          String date = dFormat.format(jDateChooser1.getDate());
          String Baranggay;
          Baranggay = JComboPob.getSelectedItem().toString(); 
          String District;
          District = jComboDist.getSelectedItem().toString(); 
          String Conditions;
          Conditions = ComboBoxConditions.getSelectedItem().toString();     
          pst.setString(1, Conditions); 
          pst.setString(2, txtLocation.getText());
          pst.setString(3, txtSitio.getText()); 
          pst.setString(4, Baranggay); 
          pst.setString(5, District); 
          pst.setString(6, date);
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
//        url = "jdbc:sqlite:C:\\Users\\Rannie Claire\\Documents\\NetBeansProjects\\BarangayInformationSystem\\src\\BIS\\bis.sqlite";     
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
        date = new SimpleDateFormat("mm/dd/yyyy").parse(model.getValueAt(index, 6).toString());
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
            
            case "Ula":
            jComboDist.setSelectedIndex(181); //--------------------------->181
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

    private void JComboPobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboPobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboPobActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        
//        FrmAddConditions cb= new FrmAddConditions(); 
//	cb.setSize(600,550);
//	cb.setVisible(true);
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
    private javax.swing.JTable tblConditions1;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtSitio;
    // End of variables declaration//GEN-END:variables
}
