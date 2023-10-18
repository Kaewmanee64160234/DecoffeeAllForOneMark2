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
public class MaterialReport {

    private int id;
    private String name;
    private int Quantity;

    public MaterialReport(int id, String name, int Quantity) {
        this.id = id;
        this.name = name;
        this.Quantity = Quantity;
    }

    public MaterialReport(String name, int Quantity) {
        this.id = -1;
        this.name = name;
        this.Quantity = Quantity;
    }

    public MaterialReport() {
        this.id = -1;
        this.name = "";
        this.Quantity = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "MaterialReport{" + "id=" + id + ", name=" + name + ", Quantity=" + Quantity + '}';
    }
    
    public static MaterialReport fromRS(ResultSet rs) {
        MaterialReport obj = new MaterialReport();
        try {
            obj.setId(rs.getInt("mat_id"));
            obj.setName(rs.getString("mat_name"));
           obj.setQuantity(rs.getInt("mat_quantity"));
           
        } catch (SQLException ex) {
            Logger.getLogger(MaterialReport.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return obj;
    }

}
