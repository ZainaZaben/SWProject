/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.dashboard;

/**
 *
 * @author HP
 */
public class Admins {
    private int id;
    private String name;
    private String email;
    private int password;
    
    public Admins(int id, String name, String email, int password)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    Admins() {
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
}
