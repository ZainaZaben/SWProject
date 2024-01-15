/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.dashboard;

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
 * @author HP
 */
public class COMPANY extends javax.swing.JFrame {

    /**
     * Creates new form COMPANY
     */
    public COMPANY() {
       initComponents();
        Show_companyTable();
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
               DefaultTableModel model = (DefaultTableModel)companyTable.getModel();
               model.setRowCount(0);
               Show_companyTable();
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

      public ArrayList<companys> companyList(String searchVal){
      ArrayList<companys> companyList = new ArrayList<companys>();
      Connection connection = getConnection();
      
         String query1 = "SELECT `email` FROM `company`";
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

        String quary = "SELECT * FROM `company`";
        Statement st;
        ResultSet rs;
       
        try {
            st = connection.createStatement();
            rs = st.executeQuery(quary);
            companys company;

            while(rs.next()){
               company = new companys(rs.getInt("id"),rs.getString("email"),rs.getString("name"),
               rs.getInt("password"),rs.getString("adress"),rs.getInt("phone"));
               companyList.add(company);
             }

       } 
      catch (SQLException e) {
       }
       return companyList;
    }
      public static int COMPANYNUM;

    /**
     *
     */
    public void Show_companyTable(){
        ArrayList <companys> listCompany = companyList(ValToSearch.getText());
        DefaultTableModel model0 = new DefaultTableModel();
        model0.setColumnIdentifiers(new Object[]{"ID","Name","E-mail","Address","Phone"});     
        Object[] row = new Object[5];
        for(int i =0;i<listCompany.size();i++){
            row[0] = listCompany.get(i).getId();
            row[1] = listCompany.get(i).getName();
            row[2] = listCompany.get(i).getEmail();
            row[3] = listCompany.get(i).getAdress();
            row[4] = listCompany.get(i).getPhone();
            model0.addRow(row);
        }
        companyTable.setModel(model0);
        COMPANYNUM = listCompany.size();
    }
    public int getCOMPANYNUM(){
        return COMPANYNUM;
    }
    public void excuteSQLquery(String quary, String massege){
        Connection con = getConnection();
         Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(quary)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)companyTable.getModel();
               model.setRowCount(0);
               Show_companyTable();
               
               JOptionPane.showMessageDialog(null, "Data "+massege+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+massege);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }

    
     public ArrayList<companys> companyList1(String searchVal){
      ArrayList<companys> companyList = new ArrayList<companys>();
      Connection connection = getConnection();
      
         String query1 = "SELECT `email` FROM `company`";
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
            String quary = "SELECT * FROM `company` WHERE (CONCAT(`id`,`email`,`name`,`Adress`,`phone`) like '%"+searchVal+"%')";

        Statement st;
        ResultSet rs;
       
        try {
            st = connection.createStatement();
            rs = st.executeQuery(quary);
            companys company;

            while(rs.next()){
               company = new companys(rs.getInt("id"),rs.getString("email"),rs.getString("name"),
               rs.getInt("password"),rs.getString("Adress"),rs.getInt("phone"));
               companyList.add(company);
             }

       } 
      catch (SQLException e) {
       }
       return companyList;
    }
     
    public void Show_companyTable1(){
        ArrayList <companys> listCompany = companyList1(ValToSearch.getText());
        DefaultTableModel model0 = new DefaultTableModel();
        model0.setColumnIdentifiers(new Object[]{"ID","Name","E-mail","Address","Phone"});     
        Object[] row = new Object[5];
        for(int i =0;i<listCompany.size();i++){
            row[0] = listCompany.get(i).getId();
            row[1] = listCompany.get(i).getName();
            row[2] = listCompany.get(i).getEmail();
            row[3] = listCompany.get(i).getAdress();
            row[4] = listCompany.get(i).getPhone();
            model0.addRow(row);
        }
        companyTable.setModel(model0);
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
        companyTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        ValToSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        EDIT = new javax.swing.JButton();
        sidepane4 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        DASHBOAR_PANEL4 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        MANAGER_PANEL4 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        ADMIN_PANEL4 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jPanel21 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        company4 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        companyTable.setAutoCreateRowSorter(true);
        companyTable.setBackground(new java.awt.Color(255, 255, 255));
        companyTable.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        companyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", null, null},
                {null, "", null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "E-mail", "Address", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        companyTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        companyTable.setFocusTraversalPolicyProvider(true);
        companyTable.setGridColor(new java.awt.Color(255, 255, 255));
        companyTable.setName(""); // NOI18N
        companyTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        companyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                companyTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(companyTable);

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
        ADD.setText("Add New Company");
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

        sidepane4.setBackground(new java.awt.Color(218, 98, 9));

        jPanel18.setBackground(new java.awt.Color(218, 98, 9));

        jLabel62.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\LOGO.png")); // NOI18N

        DASHBOAR_PANEL4.setBackground(new java.awt.Color(218, 98, 9));
        DASHBOAR_PANEL4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DASHBOAR_PANEL4MouseMoved(evt);
            }
        });
        DASHBOAR_PANEL4.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                DASHBOAR_PANEL4MouseWheelMoved(evt);
            }
        });
        DASHBOAR_PANEL4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DASHBOAR_PANEL4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DASHBOAR_PANEL4MousePressed(evt);
            }
        });

        jLabel63.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\menu.png")); // NOI18N
        DASHBOAR_PANEL4.add(jLabel63);

        jLabel64.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("DASHBOARD");
        DASHBOAR_PANEL4.add(jLabel64);

        MANAGER_PANEL4.setBackground(new java.awt.Color(218, 98, 9));
        MANAGER_PANEL4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MANAGER_PANEL4MousePressed(evt);
            }
        });

        jLabel65.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\manager.png")); // NOI18N
        MANAGER_PANEL4.add(jLabel65);

        jLabel66.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("MANAGER   ");
        MANAGER_PANEL4.add(jLabel66);

        jPanel19.setBackground(new java.awt.Color(218, 98, 9));

        jLabel67.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\parcel.png")); // NOI18N
        jPanel19.add(jLabel67);

        jLabel68.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("PARCEL       ");
        jPanel19.add(jLabel68);

        jPanel20.setBackground(new java.awt.Color(218, 98, 9));

        jLabel69.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\motorbike.png")); // NOI18N
        jPanel20.add(jLabel69);

        jLabel70.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("DRIVER         ");
        jPanel20.add(jLabel70);

        ADMIN_PANEL4.setBackground(new java.awt.Color(218, 98, 9));
        ADMIN_PANEL4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ADMIN_PANEL4MousePressed(evt);
            }
        });

        jLabel71.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\admin.png")); // NOI18N
        ADMIN_PANEL4.add(jLabel71);

        jLabel72.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("ADMIN         ");
        ADMIN_PANEL4.add(jLabel72);

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator10.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(218, 98, 9));
        jPanel21.setForeground(new java.awt.Color(255, 255, 255));

        jLabel73.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\logout.png")); // NOI18N
        jPanel21.add(jLabel73);

        jLabel74.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("LOGOUT       ");
        jPanel21.add(jLabel74);

        company4.setBackground(new java.awt.Color(218, 98, 9));
        company4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                company4MousePressed(evt);
            }
        });

        jLabel75.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\DASHBOARD\\src\\main\\java\\com\\mycompany\\dashboard\\imgs\\company.png")); // NOI18N
        company4.add(jLabel75);

        jLabel76.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("COMPANY");
        company4.add(jLabel76);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(DASHBOAR_PANEL4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MANAGER_PANEL4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ADMIN_PANEL4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(company4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DASHBOAR_PANEL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ADMIN_PANEL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MANAGER_PANEL4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(company4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidepane4Layout = new javax.swing.GroupLayout(sidepane4);
        sidepane4.setLayout(sidepane4Layout);
        sidepane4Layout.setHorizontalGroup(
            sidepane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        sidepane4Layout.setVerticalGroup(
            sidepane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bg.add(sidepane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 540));

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
    }// </editor-fold>//GEN-END:initComponents

    private void companyTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyTableMousePressed
        int j = companyTable.getSelectedRow();
        TableModel model = companyTable.getModel();
        Array0[0]= model.getValueAt(j, 0).toString();
        Array0[1]= model.getValueAt(j, 1).toString();
        Array0[2]= model.getValueAt(j, 2).toString();
        Array0[3]= model.getValueAt(j, 3).toString();
        Array0[4]= model.getValueAt(j, 4).toString();
    }//GEN-LAST:event_companyTableMousePressed

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel15MousePressed

    private void ValToSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValToSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValToSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Show_companyTable1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ADDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMousePressed
        this.dispose();
        COMPANY_ADD COMPANY_ADD = new COMPANY_ADD();
        COMPANY_ADD.setVisible(true);
    }//GEN-LAST:event_ADDMousePressed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        int i = companyTable.getSelectedRow();
        TableModel model = companyTable.getModel();
        String id= model.getValueAt(i, 0).toString();
        String sql = "DELETE FROM `company` WHERE id="+id;
        executeSQlQuery(sql,"Deleted");
    }//GEN-LAST:event_DELETEActionPerformed

    private void EDITMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITMousePressed
        this.dispose();
        COMPANY_EDIT COMPANY_EDIT = new COMPANY_EDIT();
        COMPANY_EDIT.setVisible(true);
    }//GEN-LAST:event_EDITMousePressed

    private void DASHBOAR_PANEL4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOAR_PANEL4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_DASHBOAR_PANEL4MouseMoved

    private void DASHBOAR_PANEL4MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_DASHBOAR_PANEL4MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_DASHBOAR_PANEL4MouseWheelMoved

    private void DASHBOAR_PANEL4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOAR_PANEL4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DASHBOAR_PANEL4MouseClicked

    private void DASHBOAR_PANEL4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOAR_PANEL4MousePressed
        this.dispose();
        MAIN MAIN = new MAIN();
        MAIN.setVisible(true);
    }//GEN-LAST:event_DASHBOAR_PANEL4MousePressed

    private void MANAGER_PANEL4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MANAGER_PANEL4MousePressed
        this.dispose();
        MANAGER MANAGER = new MANAGER();
        MANAGER.setVisible(true);
    }//GEN-LAST:event_MANAGER_PANEL4MousePressed

    private void ADMIN_PANEL4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADMIN_PANEL4MousePressed
        this.dispose();
        ADMIN ADMIN = new ADMIN();
        ADMIN.setVisible(true);
    }//GEN-LAST:event_ADMIN_PANEL4MousePressed

    private void company4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_company4MousePressed
        this.dispose();
        COMPANY COMPANY = new COMPANY();
        COMPANY.setVisible(true);
    }//GEN-LAST:event_company4MousePressed

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
            java.util.logging.Logger.getLogger(COMPANY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(COMPANY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(COMPANY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(COMPANY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new COMPANY().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JPanel ADMIN_PANEL4;
    private javax.swing.JPanel DASHBOAR_PANEL4;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton EDIT;
    private javax.swing.JPanel MANAGER_PANEL4;
    private javax.swing.JTextField ValToSearch;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel company4;
    private javax.swing.JTable companyTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel sidepane4;
    // End of variables declaration//GEN-END:variables
}
