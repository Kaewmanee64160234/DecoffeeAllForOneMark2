/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Topping {

    private String name;
    private float price;

    public Topping(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Topping() {
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
        return "Topping{" + "name=" + name + ", price=" + price + '}';
    }

    public static Topping fromRS(ResultSet rs) {
        Topping topping = new Topping();
        try {

            topping.setName(rs.getString("topping_name"));
            topping.setPrice(rs.getFloat("topping_price"));

        } catch (SQLException ex) {
            Logger.getLogger(Topping.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return topping;
    }
}
