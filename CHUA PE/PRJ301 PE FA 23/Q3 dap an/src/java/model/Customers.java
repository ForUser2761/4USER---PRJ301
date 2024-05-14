/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class Customers {
    private String CustomerID;
    private String CustomerName;
    private Date BirthDate;
    private boolean Gender;
    private String Address;

    public Customers() {
    }

    public Customers(String CustomerID, String CustomerName, Date BirthDate, boolean Gender, String Address) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.BirthDate = BirthDate;
        this.Gender = Gender;
        this.Address = Address;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return "Customers{" + "CustomerID=" + CustomerID + ", CustomerName=" + CustomerName + ", BirthDate=" + BirthDate + ", Gender=" + Gender + ", Address=" + Address + '}';
    }
    
    
}
