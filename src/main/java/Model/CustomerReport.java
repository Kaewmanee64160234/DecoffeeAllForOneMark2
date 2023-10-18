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
public class CustomerReport {
    private int id;
    private String name;
    private  float TotalSpend;

    public CustomerReport(int id, String name, float TotalSpend) {
        this.id = id;
        this.name = name;
        this.TotalSpend = TotalSpend;
    }
    
     public CustomerReport( String name, float TotalSpend) {
        this.id = -1;
        this.name = name;
        this.TotalSpend = TotalSpend;
    }
     
      public CustomerReport() {
        this.id = -1;
        this.name = "";
        this.TotalSpend = 0;
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

    public float getTotalSpend() {
        return TotalSpend;
    }

    public void setTotalSpend(float TotalSpend) {
        this.TotalSpend = TotalSpend;
    }

    @Override
    public String toString() {
        return "CustomerReport{" + "id=" + id + ", name=" + name + ", TotalSpend=" + TotalSpend + '}';
    }
    
     public static CustomerReport fromRS(ResultSet rs) {
        CustomerReport obj = new CustomerReport();
        try {
            obj.setId(rs.getInt("customer_id"));
            obj.setName(rs.getString("customer_name"));
           obj.setTotalSpend(rs.getFloat("TotalSpend"));
           
        } catch (SQLException ex) {
            Logger.getLogger(CustomerReport.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return obj;
    }
}
