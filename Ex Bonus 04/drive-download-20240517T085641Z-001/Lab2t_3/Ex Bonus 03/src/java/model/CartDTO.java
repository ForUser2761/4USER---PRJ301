/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hd
 */
public class CartDTO {

    private Map<String, Product> cart;

    public CartDTO() {
        this.cart = new HashMap<>();
    }

    public CartDTO(Map<String, Product> cart) {
        this.cart = cart;
    }

    public Map<String, Product> getCart() {
        return cart;
    }

    public void setCart(Map<String, Product> cart) {
        this.cart = cart;
    }

    public boolean add(Product product) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(product.getSKU())) {
                Product existingProduct = this.cart.get(product.getSKU());
                existingProduct.setQuantity(existingProduct.getQuantity() + product.getQuantity());
                this.cart.put(product.getSKU(), existingProduct);
            } else {
                this.cart.put(product.getSKU(), product);
            }
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

    public boolean change(String id, Product product) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.replace(id, product);
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean remove(String id) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : this.cart.values()) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }

    public void clear() {
        if (this.cart != null) {
            this.cart.clear();
        }
    }
}

