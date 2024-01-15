package com.mycompany.mangersection;


public class Orders {
    
    private int id;
    private String senderName;
    private String recieverName;
    private String Type;
    private String Phone;
    private int Price;
    private String Address;
    private int driverID;
    
    public Orders(int ID, String sendName, String reciveName, String Type, String phone, int price, String address, int driverID)
    {
        this.id = ID;
        this.senderName = sendName;
        this.recieverName = reciveName;
        this.Type = Type;
        this.Phone = phone;
        this.Price = price;
        this.Address = address;
        this.driverID = driverID;
    }

    Orders() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public int DriverID(){
        return driverID;
    }
    public int getId()
    {
        return id;
    }
    
    public String getsenderName()
    {
        return senderName;
    }
    
    public String getrecieverName()
    {
        return recieverName;
    }
    
    public String getType()
    {
        return Type;
    }
    public String getPhone()
    {
        return Phone;
    }
    public int getPrice()
    {
        return Price;
    }
    public String getAddress()
    {
        return Address;
    }
}
