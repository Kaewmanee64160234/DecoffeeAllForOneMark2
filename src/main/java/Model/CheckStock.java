/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class CheckStock {
    private int id;
    private Date dateTime;
    private int employee_id;

    public CheckStock(int id, Date dateTime, int employee_id) {
        this.id = id;
        this.dateTime = dateTime;
        this.employee_id = employee_id;
    }
    
    public CheckStock(Date dateTime, int employee_id) {
        this.id = -1;
        this.dateTime = dateTime;
        this.employee_id = employee_id;
    }
    
    public CheckStock() {
        this.id = -1;
        this.dateTime = null;
        this.employee_id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public String toString() {
        return "CheckStock{" + "id=" + id + ", dateTime=" + dateTime + ", employee_id=" + employee_id + '}';
    }
    
    
    
    public static CheckStock fromRS(ResultSet rs) {
        CheckStock checkStock = new CheckStock();
        try {
          checkStock.setId(rs.getInt("check_mat_id"));
          checkStock.setDateTime(rs.getDate("check_mat_datetime"));
          checkStock.setEmployee_id(rs.getInt("employee_id"));
            
        } catch (SQLException ex) {
            Logger.getLogger(CheckStock.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return checkStock;
    }
    
    
    
    
    
}
