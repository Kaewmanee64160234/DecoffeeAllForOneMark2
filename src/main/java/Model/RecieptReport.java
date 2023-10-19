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

    private String StoreName;
    private float TotalSale;

    public RecieptReport( String StoreName, float TotalSale) {
        this.StoreName = StoreName;
        this.TotalSale = TotalSale;
    }

    public RecieptReport() {
        this.StoreName = "";
        this.TotalSale = 0;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String StoreName) {
        this.StoreName = StoreName;
    }

    public float getTotalSale() {
        return TotalSale;
    }

    public void setTotalSale(float TotalSale) {
        this.TotalSale = TotalSale;
    }

    @Override
    public String toString() {
        return "RecieptReport{" + "StoreName=" + StoreName + ", TotalSale=" + TotalSale + '}';
    }
    
    public static RecieptReport fromRS(ResultSet rs) {
        RecieptReport obj = new RecieptReport();
        try {
            obj.setStoreName(rs.getString("StoreName"));
            obj.setTotalSale(rs.getFloat("TotalSale"));

        } catch (SQLException ex) {
            Logger.getLogger(RecieptReport.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return obj;
    }

}
