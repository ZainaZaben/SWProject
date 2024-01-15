package com.mycompany.mangersection;

import java.util.*;
import java.util.Comparator;
public class order {
    
   private  int id;
   private String sendername;
   private String receivername;
   private  String type;
   private String phone;
   private  int price;
   private String address;
   private String driverid;
   private int status;

    
   public order(int ID,String Sendername,String Receivername,String Type,String Phone,int Price,String Address,String Driverid,int Status){
       this.id =ID;
       this.sendername =Sendername;
       this.receivername =Receivername;
       this.type =Type;
       this.phone =Phone;
       this.price =Price;
       this.address =Address;
       this.driverid =Driverid;
       this.status =Status;

   }
    public int getid() {
    	return id;
    }
    
    public String getsendername() {
    	return sendername;
    }
    
    public String getreceivername() {
    	return receivername;
    }
    
    public String gettype() {
    	return type;
    }
    
    public String getphone() {
    	return phone;
    }
    public int getprice() {
    	return price;
    }
    
    public String getaddress() {
    	return address;
    }
    
    public String getdriverid() {
    	return driverid;
    }
    
    public int getstatus() {
    	return status;
    }
   
   
}
