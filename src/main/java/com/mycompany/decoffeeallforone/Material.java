/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.decoffeeallforone;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Material {

    private int id;
    private int matMinQty;
    private String name;
    private int matQty;
    private String matUnit;
    private float matPricePerUnit;

    public Material(int id, int matMinQty, String name, int matQty, String matUnit, float matPricePerUnit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.sweetLevel = sweetLevel;
        this.type = type;
        this.categoryId = categoryId;
    }
    public Material(String name, float price, String size, String sweetLevel, String type, int categoryId) {
        this.id = -1;
        this.name = name;
        this.price = price;
        this.size = size;
        this.sweetLevel = sweetLevel;
        this.type = type;
        this.categoryId = categoryId;
    }
    public Material() {
        this.id = -1;
        this.name = "";
        this.price = 0;
        this.size = "";
        this.sweetLevel = "";
        this.type = "";
        this.categoryId = 0;
    }

    

   

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", size=" + size + ", sweetLevel=" + sweetLevel + ", type=" + type + ", categoryId=" + categoryId + '}';
    }
    public static Material fromRS(ResultSet rs) {
        Material product = new Material();
        try {
            product.setId(rs.getInt("product_id"));
            product.setName(rs.getString("product_name"));
            product.setPrice(rs.getFloat("product_price"));
            product.setSize(rs.getString("product_size"));
            product.setSweetLevel(rs.getString("product_sweet_level"));
            product.setType(rs.getString("product_type"));
            product.setCategoryId(rs.getInt("category_id"));
        } catch (SQLException ex) { 
            Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return product;
    }
}
