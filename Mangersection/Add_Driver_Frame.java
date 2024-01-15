package com.mycompany.mangersection;
import static java.awt.event.PaintEvent.UPDATE;
import static java.lang.invoke.VarHandle.AccessMode.SET;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Add_Driver_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Add_Driver_Frame
     */
    public Add_Driver_Frame() {
        initComponents();
     //   Show_Driver_In_JTable();
    }
    
    
    //datABASE
    public Connection getConnection(){
        Connection con;
        try{
con= DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            return con;
            
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<driver_1> driverList(){
        ArrayList<driver_1> driverList = new ArrayList<driver_1>();
        Connection connection = getConnection();
        String query = "SELECT * FROM `driver`";
        Statement st;
        ResultSet rs;
        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            driver_1 DRIVER;
            while(rs.next()){
                DRIVER = new driver_1 (rs.getInt("id"),rs.getString("name"),rs.getString("phone"),rs.getInt("salary"),rs.getString("license"),rs.getInt("points"),rs.getString("email"),rs.getString("Address"),rs.getString("Password"));
           driverList.add(DRIVER);
           
            }
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return driverList;
        
 
    }
    // public void Show_Driver_In_JTable(){
            
        //}
    public void executeSQLQuery(String query,String message){
        Connection con = getConnection();
        Statement st;
        try{
            st= con.createStatement();
        if((st.executeUpdate(query)) ==1){
            JOptionPane.showMessageDialog(null,"Data"+ message+"Succefully");
            
        }
        else {
                        JOptionPane.showMessageDialog(null,"Data Not"+ message);
        }
        }catch(Exception ex){
                ex.printStackTrace();
                }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
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
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel26.setText("PASSWORD");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 120, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel27.setText("ID");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 120, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel28.setText("NAME");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 120, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel29.setText("PHONE");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 120, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel30.setText("SALARY");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 120, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel31.setText("LICENSE");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 120, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel33.setText("EMAIL");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 120, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel34.setText("ADDRESS");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 120, 30));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 180, 30));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 180, 30));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 180, 30));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 180, 30));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 180, 30));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 180, 30));
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 180, 30));
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 500, 180, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(218, 98, 9));
        jButton2.setText("INSERT");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, 170, 40));

        jPanel3.setBackground(new java.awt.Color(245, 124, 54));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add Driver");

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Mangersection\\src\\main\\java\\MangerIcon\\LOGO.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addComponent(jLabel23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 14, 790, 150));

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

        Disribute_order.setBackground(new java.awt.Color(218, 98, 9));
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

        Add_driver.setBackground(new java.awt.Color(245, 124, 54));
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
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );

        sidePare1.add(Add_driver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 260, 50));

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

        getContentPane().add(sidePare1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       // String query = "INSERT INTO `driver`(`id`, `name`, `phone`, `salary`, `license`, `points`, `email`, `Address`, `Password`) VALUES ('"+jTextField2.getText()+"','"+jTextField3.getText()+"','"+jTextField4.getText()+"','"+jTextField5.getText()+"','"+jTextField6.getText()+"','"+jTextField7.getText()+"','"+jTextField8.getText()+"','"+jTextField9.getText()+"')";
        //executeSQLQuery(query,"Inserted");
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void Edit_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_orderMouseClicked
        // TODO add your handling code here:
        edit_order_frame orderpage = new edit_order_frame();
        orderpage.setVisible(true);
        dispose();
    }//GEN-LAST:event_Edit_orderMouseClicked

    private void Edit_DriverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_DriverMouseClicked
        // TODO add your handling code here:
       edit_Driver orderpage = new edit_Driver();
        orderpage.setVisible(true);
        dispose();
    }//GEN-LAST:event_Edit_DriverMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        String sql = "INSERT INTO `driver`(`id`, `name`, `phone`, `salary`,`license`,`points`,`email`,`Address`,`Password`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = con.prepareStatement(sql);
            pst.setString(1,jTextField2.getText());
            pst.setString(2,jTextField3.getText());
            pst.setString(3,jTextField4.getText());
            pst.setString(4,jTextField5.getText());
            pst.setString(5,jTextField6.getText());
            pst.setString(6,"0");
            pst.setString(7,jTextField7.getText());
            pst.setString(8,jTextField8.getText());
            pst.setString(9,jTextField9.getText());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(sidePare1, "Adedd successfully!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Driver_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Driver_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Driver_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Driver_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Driver_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Add_driver;
    private javax.swing.JPanel Disribute_order;
    private javax.swing.JPanel Driver;
    private javax.swing.JPanel Edit_Driver;
    private javax.swing.JPanel Edit_order;
    private javax.swing.JPanel Orders;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel sidePare1;
    // End of variables declaration//GEN-END:variables
}
