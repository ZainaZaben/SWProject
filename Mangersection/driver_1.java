package com.mycompany.mangersection;
import java.util.*;
import java.util.Comparator;
public class driver_1 {
    
   private  int id;
   private String name;
   private String phone;
   private  int salary;
   private String license;
   private  int points;
   private String email;
   private String Address;
   private String Password;

    
   public driver_1(int ID,String Name,String Phone,int Salary,String License,int Points,String Email,String address,String password){
       this.id =ID;
       this.name =Name;
       this.phone =Phone;
       this.salary =Salary;
       this.license =License;
       this.points =Points;
       this.email =Email;
       this.Address =address;
       this.Password =password;

   }
    public int getid() {
    	return id;
    }
    
    public String getname() {
    	return name;
    }
    
    public String getphone() {
    	return phone;
    }
    
    public int getsalary() {
    	return salary;
    }
    
    public String getlicense() {
    	return license;
    }
    public int getpoints() {
    	return points;
    }
    
    public String getemail() {
    	return email;
    }
    
    public String getAddress() {
    	return Address;
    }
    
    public String getPassword() {
    	return Password;
    }
   
   
}
