/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.product;

/**
 *
 * @author Tony
 */
public class BookDTO {
    private String SKU;
    private String Name;
    private float Price;
    private String Description;
    private int Quantity;

    public BookDTO() {
    }

    public BookDTO(String SKU, String Name, float Price, String Description, int quantity) {
        this.SKU = SKU;
        this.Name = Name;
        this.Price = Price;
        this.Description = Description;
        this.Quantity = 0;
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

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
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
