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

import Service.EmployeeService;

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
    private String startDate;
    private String endDate;

    private float TotalPaid;
    private String MonthYear;

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
        this.MonthYear = "";
        this.TotalPaid = 0;
    }

    public SummarySalary(String MonthYear, float TotalPaid) {
        this.MonthYear = MonthYear;
        this.TotalPaid = TotalPaid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public float getTotalPaid() {
        return TotalPaid;
    }

    public void setTotalPaid(float TotalPaid) {
        this.TotalPaid = TotalPaid;
    }

    public String getMonthYear() {
        return MonthYear;
    }

    public void setMonthYear(String MonthYear) {
        this.MonthYear = MonthYear;
    }

    @Override
    public String toString() {
        return "SummarySalary{" + "id=" + id + ", date=" + date + ", totalHour=" + totalHour + ", salary=" + salary
                + ", paidStatus=" + paidStatus + ", checkins=" + checkins + ", employee=" + employee + '}';
    }

    public String printSummaryReciept() {
        return "SummarySalary{" + startDate + " - " + endDate + ", totalHour=" + totalHour + ", salary=" + salary
                + '}';
    }

    public String summaryReport() {
        return "SummarySalary{" + " MonthYear=" + MonthYear + ", TotalPaid=" + TotalPaid + '}';
    }

    public ArrayList<Checkinout> getCheckins() {
        return checkins;
    }

    public void setCheckins(ArrayList<Checkinout> checkins) {
        this.checkins = checkins;
    }

    public static SummarySalary fromRS(ResultSet rs) {
        try {
            SummarySalary summarySalary = new SummarySalary();
            summarySalary.setId(rs.getInt("ss_id"));
            summarySalary.setDate(rs.getString("ss_date"));
            summarySalary.setTotalHour(rs.getInt("ss_work_hour"));
            summarySalary.setSalary(rs.getDouble("ss_salary"));
            summarySalary.setPaidStatus(rs.getString("ss_paid_status"));
            // summarySalary.setCheckins(rs.get);
            return summarySalary;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static SummarySalary fromRSToPrintSummarySalary(ResultSet rs) {
        try {
            SummarySalary summarySalary = new SummarySalary();
            summarySalary.setId(rs.getInt("ss_id"));
            summarySalary.setStartDate(rs.getString("startDate"));
            summarySalary.setEndDate(rs.getString("endDate"));
            summarySalary.setTotalHour(rs.getInt("totalHour"));
            summarySalary.setSalary(rs.getDouble("salary"));

            return summarySalary;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static SummarySalary fromRSCondition(ResultSet rs) {
        try {

            SummarySalary summarySalary = new SummarySalary();
            summarySalary.setId(rs.getInt("ss_id"));
            summarySalary.setDate(rs.getString("ss_date"));
            summarySalary.setTotalHour(rs.getInt("ss_work_hour"));
            summarySalary.setSalary(rs.getDouble("ss_salary"));
            summarySalary.setPaidStatus(rs.getString("ss_paid_status"));
            EmployeeService employeeService = new EmployeeService();
            Employee employee = employeeService.getById(rs.getInt("employee_id"));
            summarySalary.setEmployee(employee);

            // summarySalary.setCheckins(rs.get);
            return summarySalary;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static SummarySalary fromRSReport(ResultSet rs) {
        try {
            SummarySalary summarySalary = new SummarySalary();
            summarySalary.setMonthYear(rs.getString("MonthYear"));
            summarySalary.setTotalPaid(rs.getFloat("TotalPaid"));
            // summarySalary.setCheckins(rs.get);
            return summarySalary;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public SummarySalary get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
