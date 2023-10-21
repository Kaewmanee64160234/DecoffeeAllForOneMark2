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
 * @author Lenovo
 */
public class HistoryMaterialReport {

    private int id;
    private Date created_date;
    private float Total;

    public HistoryMaterialReport(int id, Date created_date, float Total) {
        this.id = id;
        this.created_date = created_date;
        this.Total = Total;
    }

    public HistoryMaterialReport(float Total) {
        this.id = -1;
        this.created_date = null;
        this.Total = Total;
    }

    public HistoryMaterialReport() {
        this.id = -1;
        this.created_date = null;
        this.Total = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    @Override
    public String toString() {
        return "HistoryMaterialReport{" + "id=" + id + ", created_date=" + created_date + ", Total=" + Total + '}';
    }

    public static HistoryMaterialReport fromRS(ResultSet rs) {
        HistoryMaterialReport obj = new HistoryMaterialReport();
        try {
            obj.setId(rs.getInt("bill_id"));
            obj.setCreated_date(rs.getDate("bill_created_date"));
            obj.setTotal(rs.getFloat("bill_total"));

        } catch (SQLException ex) {
            Logger.getLogger(HistoryMaterialReport.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return obj;
    }
}
