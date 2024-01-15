/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mangersection;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author hp
 */
public class Distribute_order extends javax.swing.JFrame {

    /**
     * Creates new form Distribute_order
     */
    public Distribute_order() {
        initComponents();
        Show_driverTable();
        Show_orderTable();
    }
    
     public Connection getConnection(){
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
                    return con;
        }catch (Exception e){
           return null; 
        }
    }
    public ArrayList<Driver> driverList(){
      ArrayList<Driver> driverList = new ArrayList<Driver>();
      Connection connection = getConnection();
      String query1 = "SELECT `email` FROM `login`";
       Statement st0;
       ResultSet rs0;
       String email = " ";
       try {
           st0 = connection.createStatement();
           rs0 = st0.executeQuery(query1);


           while(rs0.next())
           {
            email = rs0.getString("email");
           }

       } 
      catch (SQLException e) {
           e.printStackTrace();
       }
      String query = "SELECT `adress` FROM `manger` where `email` = '"+email+"'";
       Statement st1;
       ResultSet rs1;
       String address = " ";
       try {
           st1 = connection.createStatement();
           rs1 = st1.executeQuery(query);


           while(rs1.next())
           {
            address = rs1.getString("adress");
           }

       } 
      catch (SQLException e) {
           e.printStackTrace();
       }
  
      
      String quary = "SELECT * FROM `Driver` WHERE `address`='"+address+"'";
      Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(quary);

           Driver drivers;

           while(rs.next())
           {
drivers = new Driver(rs.getInt("id"),rs.getString("name"),rs.getString("phone"),rs.getInt("salary"),rs.getString("license"),rs.getInt("points"),rs.getString("email"),rs.getString("Address"),rs.getString("Password"));
              driverList.add(drivers);
           }

       } 
      catch (SQLException e) {
           e.printStackTrace();
       }
       return driverList;
    }
    public void Show_driverTable(){
        ArrayList <Driver> listDriver = driverList();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","Name"});     
        Object[] row = new Object[2];
        for(int i =0;i<listDriver.size();i++){
            row[0] = listDriver.get(i).getId();
            row[1] = listDriver.get(i).getName();
            model.addRow(row);
        }
        JTable_Drivers.setModel(model);
    }
    public ArrayList<Orders> orderList(){
      ArrayList<Orders> orderList = new ArrayList<Orders>();
      Connection connection = getConnection();
      String query1 = "SELECT `email` FROM `login`";
       Statement st0;
       ResultSet rs0;
       String email = " ";
       try {
           st0 = connection.createStatement();
           rs0 = st0.executeQuery(query1);


           while(rs0.next())
           {
            email = rs0.getString("email");
           }

       } 
      catch (SQLException e) {
           e.printStackTrace();
       }
      String query = "SELECT `adress` FROM `manger` where `email` = '"+email+"'";
       Statement st1;
       ResultSet rs1;
       String address = " ";
       try {
           st1 = connection.createStatement();
           rs1 = st1.executeQuery(query);


           while(rs1.next())
           {
            address = rs1.getString("adress");
           }

       } 
      catch (SQLException e) {
           e.printStackTrace();
       }
      
      
      String quary = "SELECT * FROM `order` WHERE (`distribute_flage` = '%"+0+"%' and `address`='"+address+"')";
      Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(quary);

           Orders Order;

           while(rs.next())
           {
               Order = new Orders(rs.getInt("id"),rs.getString("senderName"),rs.getString("receiverName"),
               rs.getString("type"),rs.getString("Phone"),rs.getInt("Price"),
               rs.getString("address"),rs.getInt("driverID"));
               orderList.add(Order);
           }

       } 
      catch (SQLException e) {
       }
       return orderList;
    }
    public ArrayList<Orders> OrderList(){
      ArrayList<Orders> Orderlist = new ArrayList<Orders>();
      Connection connection = getConnection();
      String query1 = "SELECT `email` FROM `login`";
       Statement st0;
       ResultSet rs0;
       String email = " ";
       try {
           st0 = connection.createStatement();
           rs0 = st0.executeQuery(query1);


           while(rs0.next())
           {
            email = rs0.getString("email");
           }

       } 
      catch (SQLException e) {
           e.printStackTrace();
       }
      String query = "SELECT `adress` FROM `manger` where `email` = '"+email+"'";
       Statement st1;
       ResultSet rs1;
       String address = " ";
       try {
           st1 = connection.createStatement();
           rs1 = st1.executeQuery(query);


           while(rs1.next())
           {
            address = rs1.getString("adress");
           }

       } 
      catch (SQLException e) {
           e.printStackTrace();
       }
      
      String quary = "SELECT * FROM `order` WHERE (`distribute_flage` != '%"+0+"%' and `address`='"+address+"')";
      Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(quary);

           Orders Order;

           while(rs.next())
           {
               Order = new Orders(rs.getInt("id"),rs.getString("senderName"),rs.getString("receiverName"),
               rs.getString("type"),rs.getString("Phone"),rs.getInt("Price"),
               rs.getString("address"),rs.getInt("driverID"));
               Orderlist.add(Order);
           }

       } 
      catch (SQLException e) {
       }
       return Orderlist;
    }
    public void Show_orderTable(){
        ArrayList <Orders> listOrder = orderList();
DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","Phone number"});     
        Object[] row = new Object[2];
        for(int i =0;i<listOrder.size();i++){
            row[0] = listOrder.get(i).getId();
            row[1] = listOrder.get(i).getPhone();
            
            model.addRow(row);
        }
        jTable_Display_Users.setModel(model);
    }
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Distribute_order().setVisible(true);
            }
        });
    }
    
     public void excuteSQLquery(String quary, String massege){
        Connection con = getConnection();
         Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(quary)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)distribute_table.getModel();
               model.setRowCount(0);
               Show_disributeTable();
               
               JOptionPane.showMessageDialog(jPanel1, "Data "+massege+" Succefully");
           }else{
               JOptionPane.showMessageDialog(jPanel1, "Data Not "+massege);
           }
       }catch(HeadlessException | SQLException ex){
           ex.printStackTrace();
       }
    }
      public void Show_disributeTable(){
        ArrayList <Orders> listOrder = OrderList();
DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Order ID","Driver ID"});     
        Object[] row = new Object[2];
        for(int i =0;i<listOrder.size();i++){
            row[0] = listOrder.get(i).getId();
            row[1] = listOrder.get(i).DriverID();
            
            model.addRow(row);
        }
        distribute_table.setModel(model);
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
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        orderID = new javax.swing.JTextField();
        driverID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        distribute_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Display_Users = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTable_Drivers = new javax.swing.JTable();
        assaign = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        sidePare1 = new javax.swing.JPanel();
        Orders = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Disribute_order = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Driver = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Add_driver = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Edit_Driver = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Edit_order = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(245, 124, 54));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Distribute orders");

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Mangersection\\src\\main\\java\\MangerIcon\\LOGO.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addComponent(jLabel23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 790, 150));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Order ID: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Driver ID: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        orderID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        orderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderIDActionPerformed(evt);
            }
        });
        jPanel1.add(orderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 160, 40));

        driverID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        driverID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driverIDActionPerformed(evt);
            }
        });
        jPanel1.add(driverID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 182, 160, 40));

        distribute_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Driver ID", "Order ID"
            }
        ));
        distribute_table.setGridColor(new java.awt.Color(255, 255, 255));
        distribute_table.setSelectionBackground(new java.awt.Color(255, 204, 204));
        distribute_table.setSelectionForeground(new java.awt.Color(153, 0, 51));
        jScrollPane1.setViewportView(distribute_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 230, 200));

        jTable_Display_Users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", " Address"
            }
        ));
        jTable_Display_Users.setGridColor(new java.awt.Color(255, 255, 255));
        jTable_Display_Users.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jTable_Display_Users.setSelectionForeground(new java.awt.Color(153, 0, 51));
        jTable_Display_Users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_UsersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Display_Users);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 250, 170));

        JTable_Drivers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Driver ID", "Phone number"
            }
        ));
        JTable_Drivers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTable_Drivers.setGridColor(new java.awt.Color(255, 255, 255));
        JTable_Drivers.setSelectionBackground(new java.awt.Color(255, 204, 204));
        JTable_Drivers.setSelectionForeground(new java.awt.Color(153, 0, 51));
        JTable_Drivers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_DriversMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JTable_Drivers);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 250, 170));

        assaign.setBackground(new java.awt.Color(51, 204, 0));
        assaign.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        assaign.setForeground(new java.awt.Color(255, 255, 255));
        assaign.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Mangersection\\src\\main\\java\\MangerIcon\\icons8-add-16.png")); // NOI18N
        assaign.setText("Assign");
        assaign.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        assaign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assaignActionPerformed(evt);
            }
        });
        jPanel1.add(assaign, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 140, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(218, 98, 9));
        jLabel17.setText("Drivers list");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(218, 98, 9));
        jLabel21.setText("Orders list");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 410, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(218, 98, 9));
        jLabel22.setText("Distributed list");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, -1, -1));

        sidePare1.setBackground(new java.awt.Color(218, 98, 9));
        sidePare1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Orders.setBackground(new java.awt.Color(218, 98, 9));
        Orders.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrdersMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Orders");

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Mangersection\\src\\main\\java\\MangerIcon\\icons8-package-24.png")); // NOI18N

        javax.swing.GroupLayout OrdersLayout = new javax.swing.GroupLayout(Orders);
        Orders.setLayout(OrdersLayout);
        OrdersLayout.setHorizontalGroup(
            OrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrdersLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        OrdersLayout.setVerticalGroup(
            OrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrdersLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(OrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        sidePare1.add(Orders, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 260, -1));

        Disribute_order.setBackground(new java.awt.Color(245, 124, 54));
        Disribute_order.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Disribute_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Disribute_orderMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Distribute orders");

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Mangersection\\src\\main\\java\\MangerIcon\\icons8-list-24.png")); // NOI18N

        javax.swing.GroupLayout Disribute_orderLayout = new javax.swing.GroupLayout(Disribute_order);
        Disribute_order.setLayout(Disribute_orderLayout);
        Disribute_orderLayout.setHorizontalGroup(
            Disribute_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Disribute_orderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        Disribute_orderLayout.setVerticalGroup(
            Disribute_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Disribute_orderLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(Disribute_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        sidePare1.add(Disribute_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 260, -1));

        Driver.setBackground(new java.awt.Color(218, 98, 9));
        Driver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Driver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DriverMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Drivers");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Mangersection\\src\\main\\java\\MangerIcon\\icons8-driver-24.png")); // NOI18N

        javax.swing.GroupLayout DriverLayout = new javax.swing.GroupLayout(Driver);
        Driver.setLayout(DriverLayout);
        DriverLayout.setHorizontalGroup(
            DriverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DriverLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        DriverLayout.setVerticalGroup(
            DriverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DriverLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(DriverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        sidePare1.add(Driver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 260, -1));

        Add_driver.setBackground(new java.awt.Color(218, 98, 9));
        Add_driver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add_driver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_driverMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Add driver");

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Mangersection\\src\\main\\java\\MangerIcon\\icons8-add-new-16.png")); // NOI18N

        javax.swing.GroupLayout Add_driverLayout = new javax.swing.GroupLayout(Add_driver);
        Add_driver.setLayout(Add_driverLayout);
        Add_driverLayout.setHorizontalGroup(
            Add_driverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_driverLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        Add_driverLayout.setVerticalGroup(
            Add_driverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Add_driverLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_driverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Add_driverLayout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );

        sidePare1.add(Add_driver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 260, -1));

        Edit_Driver.setBackground(new java.awt.Color(218, 98, 9));
        Edit_Driver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit_Driver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Edit_DriverMouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(218, 98, 9));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Edit Driver information");

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Mangersection\\src\\main\\java\\MangerIcon\\editdriver.png")); // NOI18N

        javax.swing.GroupLayout Edit_DriverLayout = new javax.swing.GroupLayout(Edit_Driver);
        Edit_Driver.setLayout(Edit_DriverLayout);
        Edit_DriverLayout.setHorizontalGroup(
            Edit_DriverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Edit_DriverLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(29, 29, 29))
        );
        Edit_DriverLayout.setVerticalGroup(
            Edit_DriverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Edit_DriverLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(Edit_DriverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        sidePare1.add(Edit_Driver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 260, -1));

        Edit_order.setBackground(new java.awt.Color(218, 98, 9));
        Edit_order.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Edit_orderMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Edit order information");

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Mangersection\\src\\main\\java\\MangerIcon\\editorder.png")); // NOI18N

        javax.swing.GroupLayout Edit_orderLayout = new javax.swing.GroupLayout(Edit_order);
        Edit_order.setLayout(Edit_orderLayout);
        Edit_orderLayout.setHorizontalGroup(
            Edit_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Edit_orderLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(34, 34, 34))
        );
        Edit_orderLayout.setVerticalGroup(
            Edit_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Edit_orderLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(Edit_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel18))
                .addGap(15, 15, 15))
        );

        sidePare1.add(Edit_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 260, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Delivery System");
        sidePare1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sidePare1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 180, 10));

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Mangersection\\src\\main\\java\\MangerIcon\\delivery.png")); // NOI18N
        sidePare1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        logout.setBackground(new java.awt.Color(218, 98, 9));
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Logout");
        logout.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Downloads\\icons8-logout-24 (1).png")); // NOI18N
        logout.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 0, -1, 33));

        sidePare1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 523, 260, 40));

        jPanel1.add(sidePare1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 1050, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderIDActionPerformed

    private void driverIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_driverIDActionPerformed

    private void assaignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assaignActionPerformed
        // TODO add your handling code here:
        String query = "UPDATE `order` SET`driverID`='"+driverID.getText()+"',`distribute_flage`='"+1+"' WHERE `id`='"+orderID.getText()+"'";
        excuteSQLquery(query," Inserted");
        Show_orderTable();
        
    }//GEN-LAST:event_assaignActionPerformed

    private void JTable_DriversMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_DriversMouseClicked
        int i = JTable_Drivers.getSelectedRow();
        TableModel model = JTable_Drivers.getModel();
        driverID.setText(model.getValueAt(i,0).toString());
        
    }//GEN-LAST:event_JTable_DriversMouseClicked

    private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UsersMouseClicked
        // TODO add your handling code here:
        int i = jTable_Display_Users.getSelectedRow();
        TableModel model = jTable_Display_Users.getModel();
        orderID.setText(model.getValueAt(i,0).toString());
    }//GEN-LAST:event_jTable_Display_UsersMouseClicked

    private void OrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdersMouseClicked
        // TODO add your handling code here:
        Order_Page orderpage = new Order_Page();
        orderpage.setVisible(true);
        dispose();
    }//GEN-LAST:event_OrdersMouseClicked

    private void Disribute_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Disribute_orderMouseClicked
        // TODO add your handling code here:
        Distribute_order distribuetPage = new Distribute_order();
        distribuetPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_Disribute_orderMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        driverPage driverPage = new driverPage();
        driverPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void DriverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DriverMouseClicked
        // TODO add your handling code here:
        driverPage driverpage = new driverPage();
        driverpage.setVisible(true);
        dispose();
    }//GEN-LAST:event_DriverMouseClicked

    private void Add_driverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_driverMouseClicked
        // TODO add your handling code here:
        Add_Driver_Frame orderpage = new Add_Driver_Frame();
        orderpage.setVisible(true);
        dispose();
    }//GEN-LAST:event_Add_driverMouseClicked

    private void Edit_DriverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_DriverMouseClicked
        // TODO add your handling code here:
        edit_Driver orderpage = new edit_Driver();
        orderpage.setVisible(true);
        dispose();
    }//GEN-LAST:event_Edit_DriverMouseClicked

    private void Edit_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_orderMouseClicked
        // TODO add your handling code here:
        edit_order_frame orderpage = new edit_order_frame();
        orderpage.setVisible(true);
        dispose();
    }//GEN-LAST:event_Edit_orderMouseClicked

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Add_driver;
    private javax.swing.JPanel Disribute_order;
    private javax.swing.JPanel Driver;
    private javax.swing.JPanel Edit_Driver;
    private javax.swing.JPanel Edit_order;
    private javax.swing.JTable JTable_Drivers;
    private javax.swing.JPanel Orders;
    private javax.swing.JButton assaign;
    private javax.swing.JTable distribute_table;
    private javax.swing.JTextField driverID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable_Display_Users;
    private javax.swing.JPanel logout;
    private javax.swing.JTextField orderID;
    private javax.swing.JPanel sidePare1;
    // End of variables declaration//GEN-END:variables
}
