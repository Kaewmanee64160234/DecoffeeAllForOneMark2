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
public class RecieptDetailWorstProduct {

    private int id;
    private String name;
    private int TotalQty;

    public RecieptDetailWorstProduct(int id, String name, int TotalQty) {
        this.id = id;
        this.name = name;
        this.TotalQty = TotalQty;
    }

    public RecieptDetailWorstProduct(String name, int TotalQty) {
        this.id = -1;
        this.name = name;
        this.TotalQty = TotalQty;
    }

    public RecieptDetailWorstProduct() {
        this.id = -1;
        this.name = "";
        this.TotalQty = 0;
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

    public int getTotalQty() {
        return TotalQty;
    }

    public void setTotalQty(int TotalQty) {
        this.TotalQty = TotalQty;
    }

    @Override
    public String toString() {
        return "RecieptDetailReport{" + "id=" + id + ", name=" + name + ", TotalQty=" + TotalQty + '}';
    }

    public static RecieptDetailWorstProduct fromRS(ResultSet rs) {
        RecieptDetailWorstProduct obj = new RecieptDetailWorstProduct();
        try {
            obj.setId(rs.getInt("product_id"));
            obj.setName(rs.getString("reciept_detail_name"));
            obj.setTotalQty(rs.getInt("TotalQty"));

        } catch (SQLException ex) {
            Logger.getLogger(RecieptDetailWorstProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return obj;
    }
}
