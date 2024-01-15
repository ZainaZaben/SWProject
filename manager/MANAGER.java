/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dashboard;

import static com.mycompany.dashboard.ADMIN.Array;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class MANAGER extends javax.swing.JFrame {

    public MANAGER() {
        initComponents();
        Show_ManagerTable();
        //place main frame in center
        super.pack();
        super.setLocationRelativeTo(null);
        
    }
    public Connection getConnection(){
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
                    return con;
        }catch (SQLException e){
          return null;  
        } 
    }
    public static String Array0[]=new String[6];
    public String[] getTable(){
       return Array0;
    }
    public void executeSQlQuery(String query, String msg){
        Connection con = getConnection();
        Statement st;
        try{
            st=con.createStatement();
            if((st.executeUpdate(query))==1){
                // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)managerTable.getModel();
               model.setRowCount(0);
               Show_ManagerTable();
                JOptionPane.showMessageDialog(null, "Data "+msg+" Succefully");
            }
            else{
                JOptionPane.showMessageDialog(null, "Data NOT "+msg);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

      public ArrayList<Managers> managerList(String searchVal){
      ArrayList<Managers> managerList = new ArrayList<Managers>();
      Connection connection = getConnection();
      
         String query1 = "SELECT `email` FROM `manger`";
         Statement st0;
         ResultSet rs0;
         String email = " ";
        try {
           st0 = connection.createStatement();
           rs0 = st0.executeQuery(query1);
           while(rs0.next()){
           email = rs0.getString("email");
            }
        } 
        catch (SQLException e) {
           e.printStackTrace();
         }
            //String quary = "SELECT * FROM `manger` WHERE (CONCAT(`id`,`name`,`email`,`adress`,`phone`) like '%"+searchVal+"%')";

        String quary = "SELECT * FROM `manger`";
        Statement st;
        ResultSet rs;
       
        try {
            st = connection.createStatement();
            rs = st.executeQuery(quary);
            Managers manager;

            while(rs.next()){
               manager = new Managers(rs.getInt("id"),rs.getString("name"),rs.getString("email"),
               rs.getInt("password"),rs.getString("adress"),rs.getInt("phone"),rs.getInt("salary"));
               managerList.add(manager);
             }

       } 
      catch (SQLException e) {
       }
       return managerList;
    }
      public static int MANAGERNUM;
    public void Show_ManagerTable(){
        ArrayList <Managers> listManager = managerList(ValToSearch.getText());
        DefaultTableModel model0 = new DefaultTableModel();
        model0.setColumnIdentifiers(new Object[]{"ID","Name","E-mail","Address","Phone","Salary"});     
        Object[] row = new Object[6];
        for(int i =0;i<listManager.size();i++){
            row[0] = listManager.get(i).getId();
            row[1] = listManager.get(i).getName();
            row[2] = listManager.get(i).getEmail();
            row[3] = listManager.get(i).getAdress();
            row[4] = listManager.get(i).getPhone();
            row[5] = listManager.get(i).getSalary();
            model0.addRow(row);
        }
        managerTable.setModel(model0);
        MANAGERNUM = listManager.size();
    }
    public int getMANAGERNUM(){
        return MANAGERNUM;
    }
    public void excuteSQLquery(String quary, String massege){
        Connection con = getConnection();
         Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(quary)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)managerTable.getModel();
               model.setRowCount(0);
               Show_ManagerTable();
               
               JOptionPane.showMessageDialog(null, "Data "+massege+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+massege);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }
    
    
    
    
     public ArrayList<Managers> managerList1(String searchVal){
      ArrayList<Managers> managerList = new ArrayList<Managers>();
      Connection connection = getConnection();
      
         String query1 = "SELECT `email` FROM `manger`";
         Statement st0;
         ResultSet rs0;
         String email = " ";
        try {
           st0 = connection.createStatement();
           rs0 = st0.executeQuery(query1);
           while(rs0.next()){
           email = rs0.getString("email");
            }
        } 
        catch (SQLException e) {
           e.printStackTrace();
         }
            String quary = "SELECT * FROM `manger` WHERE (CONCAT(`id`,`name`,`email`,`adress`,`phone`,`salary`) like '%"+searchVal+"%')";

      //  String quary = "SELECT * FROM `manger`";
        Statement st;
        ResultSet rs;
       
        try {
            st = connection.createStatement();
            rs = st.executeQuery(quary);
            Managers manager;

            while(rs.next()){
               manager = new Managers(rs.getInt("id"),rs.getString("name"),rs.getString("email"),
               rs.getInt("password"),rs.getString("adress"),rs.getInt("phone"),rs.getInt("salary"));
               managerList.add(manager);
             }

       } 
      catch (SQLException e) {
       }
       return managerList;
    }
    public void Show_ManagerTable1(){
        ArrayList <Managers> listManager = managerList1(ValToSearch.getText());
        DefaultTableModel model0 = new DefaultTableModel();
        model0.setColumnIdentifiers(new Object[]{"ID","Name","E-mail","Address","Phone","Salary"});     
        Object[] row = new Object[6];
        for(int i =0;i<listManager.size();i++){
            row[0] = listManager.get(i).getId();
            row[1] = listManager.get(i).getName();
            row[2] = listManager.get(i).getEmail();
            row[3] = listManager.get(i).getAdress();
            row[4] = listManager.get(i).getPhone();
            row[5] = listManager.get(i).getSalary();
            model0.addRow(row);
        }
        managerTable.setModel(model0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        managerTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        ValToSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        EDIT = new javax.swing.JButton();
        sidepane = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DASHBOAR_PANEL = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MANAGER_PANEL = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ADMIN_PANEL = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        company = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setSize(new java.awt.Dimension(300, 300));

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        managerTable.setAutoCreateRowSorter(true);
        managerTable.setBackground(new java.awt.Color(255, 255, 255));
        managerTable.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        managerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", null, null, null},
                {null, "", null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "E-mail", "Address", "Phone", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        managerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        managerTable.setFocusTraversalPolicyProvider(true);
        managerTable.setGridColor(new java.awt.Color(255, 255, 255));
        managerTable.setName(""); // NOI18N
        managerTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        managerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                managerTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(managerTable);
        if (managerTable.getColumnModel().getColumnCount() > 0) {
            managerTable.getColumnModel().getColumn(0).setResizable(false);
            managerTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            managerTable.getColumnModel().getColumn(1).setResizable(false);
            managerTable.getColumnModel().getColumn(1).setPreferredWidth(80);
            managerTable.getColumnModel().getColumn(2).setResizable(false);
            managerTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            managerTable.getColumnModel().getColumn(3).setResizable(false);
            managerTable.getColumnModel().getColumn(4).setResizable(false);
            managerTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 590, 122));

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\cancel.png")); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, -1, -1));

        ValToSearch.setBackground(new java.awt.Color(255, 255, 255));
        ValToSearch.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        ValToSearch.setForeground(new java.awt.Color(0, 0, 0));
        ValToSearch.setText("Search");
        ValToSearch.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), null));
        ValToSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValToSearchActionPerformed(evt);
            }
        });
        jPanel1.add(ValToSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, 30));

        jButton1.setBackground(new java.awt.Color(218, 98, 9));
        jButton1.setForeground(new java.awt.Color(218, 98, 9));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\search.png")); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 40, 29));

        ADD.setBackground(new java.awt.Color(218, 98, 9));
        ADD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ADD.setForeground(new java.awt.Color(255, 255, 255));
        ADD.setText("Add New Manager");
        ADD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ADDMousePressed(evt);
            }
        });
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        jPanel1.add(ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 150, 30));

        DELETE.setBackground(new java.awt.Color(162, 2, 2));
        DELETE.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        DELETE.setForeground(new java.awt.Color(255, 255, 255));
        DELETE.setText("DELETE");
        DELETE.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        jPanel1.add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 90, 40));

        EDIT.setBackground(new java.awt.Color(5, 156, 47));
        EDIT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        EDIT.setForeground(new java.awt.Color(255, 255, 255));
        EDIT.setText("EDIT");
        EDIT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        EDIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EDITMousePressed(evt);
            }
        });
        jPanel1.add(EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 90, 40));

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 620, 540));

        sidepane.setBackground(new java.awt.Color(218, 98, 9));

        jPanel2.setBackground(new java.awt.Color(218, 98, 9));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\LOGO.png")); // NOI18N

        DASHBOAR_PANEL.setBackground(new java.awt.Color(218, 98, 9));
        DASHBOAR_PANEL.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DASHBOAR_PANELMouseMoved(evt);
            }
        });
        DASHBOAR_PANEL.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                DASHBOAR_PANELMouseWheelMoved(evt);
            }
        });
        DASHBOAR_PANEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DASHBOAR_PANELMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DASHBOAR_PANELMousePressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\menu.png")); // NOI18N
        DASHBOAR_PANEL.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DASHBOARD");
        DASHBOAR_PANEL.add(jLabel3);

        MANAGER_PANEL.setBackground(new java.awt.Color(218, 98, 9));
        MANAGER_PANEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MANAGER_PANELMousePressed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\manager.png")); // NOI18N
        MANAGER_PANEL.add(jLabel11);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGER   ");
        MANAGER_PANEL.add(jLabel4);

        jPanel4.setBackground(new java.awt.Color(218, 98, 9));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\parcel.png")); // NOI18N
        jPanel4.add(jLabel5);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("PARCEL       ");
        jPanel4.add(jLabel12);

        jPanel7.setBackground(new java.awt.Color(218, 98, 9));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\motorbike.png")); // NOI18N
        jPanel7.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DRIVER         ");
        jPanel7.add(jLabel10);

        ADMIN_PANEL.setBackground(new java.awt.Color(218, 98, 9));
        ADMIN_PANEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ADMIN_PANELMousePressed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\admin.png")); // NOI18N
        ADMIN_PANEL.add(jLabel13);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ADMIN         ");
        ADMIN_PANEL.add(jLabel6);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(218, 98, 9));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\logout.png")); // NOI18N
        jPanel5.add(jLabel8);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("LOGOUT       ");
        jPanel5.add(jLabel7);

        company.setBackground(new java.awt.Color(218, 98, 9));
        company.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                companyMousePressed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\company.png")); // NOI18N
        company.add(jLabel14);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("COMPANY");
        company.add(jLabel18);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(DASHBOAR_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MANAGER_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ADMIN_PANEL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DASHBOAR_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ADMIN_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MANAGER_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidepaneLayout = new javax.swing.GroupLayout(sidepane);
        sidepane.setLayout(sidepaneLayout);
        sidepaneLayout.setHorizontalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        sidepaneLayout.setVerticalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bg.add(sidepane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel15MousePressed

    private void ValToSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValToSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValToSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Show_ManagerTable1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDActionPerformed

    private void ADDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMousePressed
        this.dispose();
        MANAGER_ADD MANAGER_ADD = new MANAGER_ADD();
        MANAGER_ADD.setVisible(true);
    }//GEN-LAST:event_ADDMousePressed

    private void EDITMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITMousePressed
        this.dispose();
        MANAGER_EDIT MANAGER_EDIT = new MANAGER_EDIT();
        MANAGER_EDIT.setVisible(true);
    }//GEN-LAST:event_EDITMousePressed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
       int i = managerTable.getSelectedRow();
       TableModel model = managerTable.getModel();
       String id= model.getValueAt(i, 0).toString();
       String sql = "DELETE FROM `manger` WHERE id="+id;
       executeSQlQuery(sql,"Deleted");
    }//GEN-LAST:event_DELETEActionPerformed

    private void managerTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managerTableMousePressed
       int j = managerTable.getSelectedRow();
       TableModel model = managerTable.getModel();
       Array0[0]= model.getValueAt(j, 0).toString();
       Array0[1]= model.getValueAt(j, 1).toString();
       Array0[2]= model.getValueAt(j, 2).toString();
       Array0[3]= model.getValueAt(j, 3).toString();
       Array0[4]= model.getValueAt(j, 4).toString();
       Array0[5]= model.getValueAt(j, 5).toString();
    }//GEN-LAST:event_managerTableMousePressed

    private void DASHBOAR_PANELMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOAR_PANELMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_DASHBOAR_PANELMouseMoved

    private void DASHBOAR_PANELMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_DASHBOAR_PANELMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_DASHBOAR_PANELMouseWheelMoved

    private void DASHBOAR_PANELMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOAR_PANELMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DASHBOAR_PANELMouseClicked

    private void DASHBOAR_PANELMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOAR_PANELMousePressed
        this.dispose();
        MAIN MAIN = new MAIN();
        MAIN.setVisible(true);
    }//GEN-LAST:event_DASHBOAR_PANELMousePressed

    private void MANAGER_PANELMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGER_PANELMousePressed
        this.dispose();
        MANAGER MANAGER = new MANAGER();
        MANAGER.setVisible(true);
    }//GEN-LAST:event_MANAGER_PANELMousePressed

    private void ADMIN_PANELMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADMIN_PANELMousePressed
        this.dispose();
        ADMIN ADMIN = new ADMIN();
        ADMIN.setVisible(true);
    }//GEN-LAST:event_ADMIN_PANELMousePressed

    private void companyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyMousePressed
        this.dispose();
        COMPANY COMPANY = new COMPANY();
        COMPANY.setVisible(true);
    }//GEN-LAST:event_companyMousePressed

   

    void setcolor(JPanel panel){
        setBackground(new Color(250, 118, 20));
    }
    void resetcolor(JPanel panel){
        setBackground(new Color(218,98,9));
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
            java.util.logging.Logger.getLogger(MANAGER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MANAGER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MANAGER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MANAGER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MANAGER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JPanel ADMIN_PANEL;
    private javax.swing.JPanel DASHBOAR_PANEL;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton EDIT;
    private javax.swing.JPanel MANAGER_PANEL;
    private javax.swing.JTextField ValToSearch;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel company;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable managerTable;
    private javax.swing.JPanel sidepane;
    // End of variables declaration//GEN-END:variables
}
