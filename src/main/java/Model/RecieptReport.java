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

    private float TotalSale;
    private int TotalQuantity;
    private String MonthYear;

    public RecieptReport(float TotalSale, int TotalQuantity, String MonthYear) {
        this.TotalSale = TotalSale;
        this.TotalQuantity = TotalQuantity;
    }

    public RecieptReport() {
        this.TotalSale = 0;
        this.TotalQuantity = 0;
    }

    public String getMonthYear() {
        return MonthYear;
    }

    public void setMonthYear(String MonthYear) {
        this.MonthYear = MonthYear;
    }

    public float getTotalSale() {
        return TotalSale;
    }

    public void setTotalSale(float TotalSale) {
        this.TotalSale = TotalSale;
    }

    public int getTotalQuantity() {
        return TotalQuantity;
    }

    public void setTotalQuantity(int TotalQuantity) {
        this.TotalQuantity = TotalQuantity;
    }

    @Override
    public String toString() {
        return "RecieptReport{" + "TotalSale=" + TotalSale + ", TotalQuantity=" + TotalQuantity + ", MonthYear=" + MonthYear + '}';
    }

    
    
    public static RecieptReport fromRS(ResultSet rs) {
        RecieptReport obj = new RecieptReport();
        try {
            obj.setTotalSale(rs.getFloat("TotalSale"));
            obj.setTotalQuantity(rs.getInt("TotalQuantity"));
            obj.setMonthYear(rs.getString("MonthYear"));

        } catch (SQLException ex) {
            Logger.getLogger(RecieptReport.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return obj;
    }

}
