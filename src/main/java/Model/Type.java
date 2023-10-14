/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class Type {
    private String name;
    private float price;

    public Type(String name, float price) {
        this.name = name;
        this.price = price;
    }
    
    public Type() {
        this.name = "";
        this.price = 0;
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
    
     @Override
    public String toString() {
        return "Type{" + "name=" + name + ", price=" + price + '}';
    }
}
