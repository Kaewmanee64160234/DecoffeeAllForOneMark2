/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class SummarySalary {

    private int id;
    private Date date;
    private int totalHour;
    private double salary;
    private char paidStatus;
    private ArrayList<Checkinout> checkins;
    private Employee employee;

    public SummarySalary(int id, Date date, int totalHour, double salary, char paidStatus) {
        this.id = id;
        this.date = date;
        this.totalHour = totalHour;
        this.salary = salary;
        this.paidStatus = paidStatus;
    }

    public SummarySalary(Date date, int totalHour, double salary, char paidStatus) {
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
        this.paidStatus = 'N';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public char getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(char paidStatus) {
        this.paidStatus = paidStatus;
    }

    @Override
    public String toString() {
        return "SummarySalary{" + "id=" + id + ", date=" + date + ", totalHour=" + totalHour + ", salary=" + salary + ", paidStatus=" + paidStatus + ", checkins=" + checkins + ", employee=" + employee + '}';
    }

      public static SummarySalary fromRS(ResultSet rs) {
        SummarySalary obj = new SummarySalary();
        try {
            obj.setId(rs.getInt("ss_id"));
            obj.setDate(rs.getDate("ss_date"));
            obj.setTotalHour(rs.getInt("ss_work_hour"));
            obj.setSalary(rs.getDouble("ss_salary"));
            obj.setPaidStatus(rs.getString("ss_paid_status").charAt(0));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
      }
    

}
