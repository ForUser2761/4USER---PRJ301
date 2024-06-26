/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nnkha
 */
public class Product {
    private String SKU;
            private String Name;
            private double Price;
            private String Description;
            private int Quantity;

    public Product() {
    }

    public Product(String SKU, String Name, double Price, String Description, int Quantity) {
        this.SKU = SKU;
        this.Name = Name;
        this.Price = Price;
        this.Description = Description;
        this.Quantity = Quantity;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    

     
            
}
