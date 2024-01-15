/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dashboard;

/**
 *
 * @author HP
 */
public class Managers {
    private int id;
    private String name;
    private String email;
    private int password;
    private String adress;
    private int phone;
    private int salary;
    
    public Managers(int id, String name, String email, int password, String adress,int phone, int salary)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.password = password;
        this.phone = phone;
        this.salary = salary;
    }

    Managers() {
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
        return adress;
    }
    public int getSalary()
    {
        return salary;
    }
}
