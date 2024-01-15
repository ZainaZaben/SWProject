/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dashboard;

/**
 *
 * @author HP
 */
public class companys {
    private int id;
    private String email;
    private String name;
    private int password;
    private String Adress;
    private int phone;
    
    public companys(int id, String email, String name, int password, String Adress,int phone)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.Adress = Adress;
        this.password = password;
        this.phone = phone;
    }

    companys() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getEmail()
    {
        return email;
    }
    public int getPassword()
    {
        return password;
    }
    public int getPhone()
    {
        return phone;
    }
    public String getAdress()
    {
        return Adress;
    }
}
