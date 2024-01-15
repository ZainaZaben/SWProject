/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mangersection;

/**
 *
 * @author hp
 */
public class Driver {
    private int id;
    private String Name;
    private String Phone;
    private int Salary;
    private String License;
    private int points;
    private String email;
    private String Address;
    private String Password;
    
    public Driver(int ID, String name, String phone, int salary, String date,int points,String email,String Address, String password)
    {
        this.id = ID;
        this.Name = name;
        this.Phone = phone;
        this.Salary = salary;
        this.License = date;
        this.points = points;
        this.email = email;
        this.Address = Address;
        this.Password = password;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public String getPhone()
    {
        return Phone;
    }
    public int getSalary()
    {
        return Salary;
    }
    public String getLicens()
    {
        return License;
    }
    public String getEmail()
    {
        return email;
    }
    
    public String getAddress()
    {
        return Address;
    }
    public int getPoints()
    {
        return points;
    }
    public String getPassword()
    {
        return Password;
    }
}
