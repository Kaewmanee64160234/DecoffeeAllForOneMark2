/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class SummarySalary {

    private int id;
    private String date;
    private int totalHour;
    private double salary;
    private String paidStatus;
    private ArrayList<Checkinout> checkins;
    private Employee employee;

    public SummarySalary(int id, String date, int totalHour, double salary, String paidStatus) {
        this.id = id;
        this.date = date;
        this.totalHour = totalHour;
        this.salary = salary;
        this.paidStatus = paidStatus;
    }

    public SummarySalary(String date, int totalHour, double salary, String paidStatus) {
        this.id = -1;

        this.date = date;
        this.totalHour = totalHour;
        this.salary = salary;
        this.paidStatus = paidStatus;
    }

    public SummarySalary() {
        this.id = -1;
        this.date = null;
        this.totalHour = 0;
        this.salary = 0;
        this.paidStatus = "N";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(int totalHour) {
        this.totalHour = totalHour;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String string) {
        this.paidStatus = string;
    }

    @Override
    public String toString() {
        return "SummarySalary{" + "id=" + id + ", date=" + date + ", totalHour=" + totalHour + ", salary=" + salary
                + ", paidStatus=" + paidStatus + ", checkins=" + checkins + ", employee=" + employee + '}';
    }

    public static SummarySalary fromRS(ResultSet rs) {
        try {
            SummarySalary summarySalary = new SummarySalary();
            summarySalary.setId(rs.getInt("ss_id"));
            summarySalary.setDate(rs.getString("ss_date"));
            summarySalary.setTotalHour(rs.getInt("ss_work_hour"));
            summarySalary.setSalary(rs.getDouble("ss_salary"));
            summarySalary.setPaidStatus(rs.getString("ss_paid_status"));
            return summarySalary;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


  
}
