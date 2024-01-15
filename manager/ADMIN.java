/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dashboard;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class ADMIN extends javax.swing.JFrame {

    public ADMIN() {
        initComponents();
        Show_AdminTable();
        //place main frame in center
        super.pack();
        super.setLocationRelativeTo(null);
        
    
    }
    public Connection getConnection(){
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/delivery", "root", "");
                    return con;
        }catch (SQLException e){
          return null;  
        } 
    }
    
    public static String Array[]=new String[3];
    public String[] getTable(){
       return Array;
    }

    public void executeSQlQuery(String query, String msg){
        Connection con = getConnection();
        Statement st;
        try{
            st=con.createStatement();
            if((st.executeUpdate(query))==1){
                // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)adminTable.getModel();
               model.setRowCount(0);
               Show_AdminTable();
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
     public ArrayList<Admins> AdminsList(String searchVal){
      ArrayList<Admins> AdminsList = new ArrayList<Admins>();
      Connection connection = getConnection();
      
      
      
      String quary = "SELECT * FROM `admin`";
      Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(quary);
           Admins Admins;
           while(rs.next()){
               Admins = new Admins(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getInt("password"));
               AdminsList.add(Admins);
           }

       } 
      catch (SQLException e) {
       }
       return AdminsList;
    }
     public static int adminNUM;
    public void Show_AdminTable(){
        ArrayList <Admins> listAdmins = AdminsList(ValToSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","Name","E-mail"});     
        Object[] row = new Object[3];
        for(int i =0;i<listAdmins.size();i++){
            row[0] = listAdmins.get(i).getId();
            row[1] = listAdmins.get(i).getName();
            row[2] = listAdmins.get(i).getEmail();
            model.addRow(row);
        }
        adminTable.setModel(model);
        adminNUM = listAdmins.size();
    }
    public int getAdminNUM(){
        return adminNUM;
    }
    
    public void excuteSQLquery(String quary, String massege){
        Connection con = getConnection();
         Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(quary)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)adminTable.getModel();
               model.setRowCount(0);
               Show_AdminTable();
               
               JOptionPane.showMessageDialog(null, "Data "+massege+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+massege);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }
    
    
    
    
    
    public ArrayList<Admins> AdminsList1(String searchVal){
      ArrayList<Admins> AdminsList = new ArrayList<Admins>();
      Connection connection = getConnection();
      
      
      
      String quary1 = "SELECT * FROM `admin` WHERE (CONCAT(`id`,`name`,`email`) like '%"+searchVal+"%')";
      Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(quary1);
           Admins Admins;
           while(rs.next()){
               Admins = new Admins(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getInt("password"));
               AdminsList.add(Admins);
           }

       } 
      catch (SQLException e) {
       }
       return AdminsList;
    }
    public void Show_AdminTable1(){
        ArrayList <Admins> listAdmins = AdminsList1(ValToSearch.getText());
        DefaultTableModel model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(new Object[]{"ID","Name","E-mail"});     
        Object[] row = new Object[3];
        for(int i =0;i<listAdmins.size();i++){
            row[0] = listAdmins.get(i).getId();
            row[1] = listAdmins.get(i).getName();
            row[2] = listAdmins.get(i).getEmail();
            model2.addRow(row);
        }
        adminTable.setModel(model2);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        ValToSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        EDIT = new javax.swing.JButton();
        sidepane2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        DASHBOAR_PANEL2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
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
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setSize(new java.awt.Dimension(300, 300));

        bg.setMinimumSize(new java.awt.Dimension(840, 540));
        bg.setPreferredSize(new java.awt.Dimension(840, 540));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        adminTable.setAutoCreateRowSorter(true);
        adminTable.setBackground(new java.awt.Color(255, 255, 255));
        adminTable.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        adminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        adminTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        adminTable.setFocusTraversalPolicyProvider(true);
        adminTable.setGridColor(new java.awt.Color(255, 255, 255));
        adminTable.setName(""); // NOI18N
        adminTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        adminTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adminTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(adminTable);
        if (adminTable.getColumnModel().getColumnCount() > 0) {
            adminTable.getColumnModel().getColumn(0).setResizable(false);
            adminTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            adminTable.getColumnModel().getColumn(1).setResizable(false);
            adminTable.getColumnModel().getColumn(1).setPreferredWidth(80);
            adminTable.getColumnModel().getColumn(2).setResizable(false);
            adminTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 590, 122));

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\cancel.png")); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

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
        ADD.setText("Add New Admin");
        ADD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ADDMousePressed(evt);
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

        sidepane2.setBackground(new java.awt.Color(218, 98, 9));

        jPanel6.setBackground(new java.awt.Color(218, 98, 9));

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\LOGO.png")); // NOI18N

        DASHBOAR_PANEL2.setBackground(new java.awt.Color(218, 98, 9));
        DASHBOAR_PANEL2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DASHBOAR_PANEL2MouseMoved(evt);
            }
        });
        DASHBOAR_PANEL2.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                DASHBOAR_PANEL2MouseWheelMoved(evt);
            }
        });
        DASHBOAR_PANEL2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DASHBOAR_PANEL2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DASHBOAR_PANEL2MousePressed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\menu.png")); // NOI18N
        DASHBOAR_PANEL2.add(jLabel19);

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("DASHBOARD");
        DASHBOAR_PANEL2.add(jLabel20);

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

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\company.png")); // NOI18N
        company.add(jLabel21);

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("COMPANY");
        company.add(jLabel22);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(DASHBOAR_PANEL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MANAGER_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ADMIN_PANEL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DASHBOAR_PANEL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout sidepane2Layout = new javax.swing.GroupLayout(sidepane2);
        sidepane2.setLayout(sidepane2Layout);
        sidepane2Layout.setHorizontalGroup(
            sidepane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        sidepane2Layout.setVerticalGroup(
            sidepane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bg.add(sidepane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 540));

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
        Show_AdminTable1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EDITMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITMousePressed
        this.dispose();
        ADMIN_EDIT ADMIN_EDIT = new ADMIN_EDIT();
        ADMIN_EDIT.setVisible(true);
    }//GEN-LAST:event_EDITMousePressed

    private void ADDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMousePressed
        this.dispose();
        ADMIN_ADD ADMIN_ADD = new ADMIN_ADD();
        ADMIN_ADD.setVisible(true);
    }//GEN-LAST:event_ADDMousePressed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        int i = adminTable.getSelectedRow();
       TableModel model = adminTable.getModel();
       String id= model.getValueAt(i, 0).toString();
       String sql = "DELETE FROM `admin` WHERE id="+id;
       executeSQlQuery(sql,"deleted");
    }//GEN-LAST:event_DELETEActionPerformed

    private void adminTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTableMousePressed
         int j = adminTable.getSelectedRow();
       TableModel model = adminTable.getModel();
       Array[0]= model.getValueAt(j, 0).toString();
       Array[1]= model.getValueAt(j, 1).toString();
       Array[2]= model.getValueAt(j, 2).toString();
    }//GEN-LAST:event_adminTableMousePressed

    private void DASHBOAR_PANEL2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOAR_PANEL2MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_DASHBOAR_PANEL2MouseMoved

    private void DASHBOAR_PANEL2MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_DASHBOAR_PANEL2MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_DASHBOAR_PANEL2MouseWheelMoved

    private void DASHBOAR_PANEL2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOAR_PANEL2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DASHBOAR_PANEL2MouseClicked

    private void DASHBOAR_PANEL2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOAR_PANEL2MousePressed
        this.dispose();
        MAIN MAIN = new MAIN();
        MAIN.setVisible(true);
    }//GEN-LAST:event_DASHBOAR_PANEL2MousePressed

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
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADMIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JPanel ADMIN_PANEL;
    private javax.swing.JPanel DASHBOAR_PANEL2;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton EDIT;
    private javax.swing.JPanel MANAGER_PANEL;
    private javax.swing.JTextField ValToSearch;
    private javax.swing.JTable adminTable;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel company;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel sidepane2;
    // End of variables declaration//GEN-END:variables
}
