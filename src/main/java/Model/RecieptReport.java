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
public class RecieptReport {

    private int id;
    private float TotalSale;

    public RecieptReport(int id, float TotalSale) {
        this.id = id;
        this.TotalSale = TotalSale;
    }

    public RecieptReport(float TotalSale) {
        this.id = -1;
        this.TotalSale = TotalSale;
    }

    public RecieptReport() {
        this.id = -1;
        this.TotalSale = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalSale() {
        return TotalSale;
    }

    public void setTotalSale(float TotalSale) {
        this.TotalSale = TotalSale;
    }

    @Override
    public String toString() {
        return "RecieptReport{" + "id=" + id + ", TotalSale=" + TotalSale + '}';
    }

    public static RecieptReport fromRS(ResultSet rs) {
        RecieptReport obj = new RecieptReport();
        try {
            obj.setId(rs.getInt("reciept_id"));
            obj.setTotalSale(rs.getFloat("TotalSale"));

        } catch (SQLException ex) {
            Logger.getLogger(CustomerReport.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return obj;
    }

}
