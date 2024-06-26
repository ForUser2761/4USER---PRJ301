/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.product;

/**
 *
 * @author Tony
 */
public class ProductError {
    private String id;
    private String name;
    private float price;
    private String description;
    private String size;
    private Integer status;

    public ProductError() {
        this.id = "";
        this.name = "";
        this.price = 0;
        
        this.size = "";
        this.description = "";
        this.status = 1;
    }

    public ProductError(String id, String name, float price, String size, String description, Integer status) {
        this.id = id;
        this.name = name;
        this.price = price;
        
        this.size = size;
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    

    
    
}
