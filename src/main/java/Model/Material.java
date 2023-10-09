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
        this.matMinQty = matMinQty;
        this.name = name;
        this.matQty = matQty;
        this.matUnit = matUnit;
        this.matPricePerUnit= matPricePerUnit;
    }
     public Material( int matMinQty, String name, int matQty, String matUnit, float matPricePerUnit) {
        this.id = -1;
        this.matMinQty = matMinQty;
        this.name = name;
        this.matQty = matQty;
        this.matUnit = matUnit;
        this.matPricePerUnit= matPricePerUnit;
    }
    public Material( ) {
        this.id = -1;
        this.matMinQty = 0;
        this.name = "";
        this.matQty = 0;
        this.matUnit = "";
        this.matPricePerUnit= 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatMinQty() {
        return matMinQty;
    }

    public void setMatMinQty(int matMinQty) {
        this.matMinQty = matMinQty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatQty() {
        return matQty;
    }

    public void setMatQty(int matQty) {
        this.matQty = matQty;
    }

    public String getMatUnit() {
        return matUnit;
    }

    public void setMatUnit(String matUnit) {
        this.matUnit = matUnit;
    }

    public float getMatPricePerUnit() {
        return matPricePerUnit;
    }

    public void setMatPricePerUnit(float matPricePerUnit) {
        this.matPricePerUnit = matPricePerUnit;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", matMinQty=" + matMinQty + ", name=" + name + ", matQty=" + matQty + ", matUnit=" + matUnit + ", matPricePerUnit=" + matPricePerUnit + '}';
    }

    
    public static Material fromRS(ResultSet rs) {
        Material material = new Material();
        try {
            material.setId(rs.getInt("mat_id"));
            material.setMatMinQty(rs.getInt("mat_min_quantity"));
            material.setName(rs.getString("mat_name"));
            material.setMatQty(rs.getInt("mat_quantity"));
            material.setMatUnit(rs.getString("mat_unit"));
            material.setMatPricePerUnit(rs.getFloat("mat_price_per_unit"));
        } catch (SQLException ex) { 
            Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return material;
    }
}
