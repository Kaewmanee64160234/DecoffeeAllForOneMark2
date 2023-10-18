/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Checkinout {

    private int id;
    private Date cioDate;
    private String cioTimeIn;
    private String cioTimeOut;
    private int cioTotalHour;
    private String cioPaidStatus;
    private int employeeId;
    private int ssId;
    private ArrayList<Employee> employees = new ArrayList();

    public Checkinout(int id, Date cioDate, String cioTimeIn, String cioTimeOut, int cioTotalHour, String cioPaidStatus, int employeeId, int ssId) {
        this.id = id;
        this.cioDate = cioDate;
        this.cioTimeIn = cioTimeIn;
        this.cioTimeOut = cioTimeOut;
        this.cioTotalHour = cioTotalHour;
        this.cioPaidStatus = cioPaidStatus;
        this.employeeId = employeeId;
        this.ssId = ssId;
    }

    public Checkinout(Date cioDate, String cioTimeIn, String cioTimeOut, int cioTotalHour, String cioPaidStatus, int employeeId, int ssId) {
        this.id = -1;
        this.cioDate = cioDate;
        this.cioTimeIn = cioTimeIn;
        this.cioTimeOut = cioTimeOut;
        this.cioTotalHour = cioTotalHour;
        this.cioPaidStatus = cioPaidStatus;
        this.employeeId = employeeId;
        this.ssId = ssId;
    }

    public Checkinout(String cioTimeIn, String cioTimeOut, int cioTotalHour, String cioPaidStatus, int employeeId, int ssId) {
        this.cioTimeIn = cioTimeIn;
        this.cioTimeOut = cioTimeOut;
        this.cioTotalHour = cioTotalHour;
        this.cioPaidStatus = cioPaidStatus;
        this.employeeId = employeeId;
        this.ssId = ssId;
    }

    public Checkinout() {
        this.id = -1;
        this.cioDate = null;
        this.cioTimeIn = null;
        this.cioTimeOut = null;
        this.cioTotalHour = 0;
        this.cioPaidStatus = "";
        this.employeeId = -1;
        this.ssId = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCioDate() {
        return cioDate;
    }

    public void setCioDate(Date cioDate) {
        this.cioDate = cioDate;
    }

    public String getCioTimeIn() {
        return cioTimeIn;
    }

    public void setCioTimeIn(String cioTimeIn) {
        this.cioTimeIn = cioTimeIn;
    }

    public String getCioTimeOut() {
        return cioTimeOut;
    }

    public void setCioTimeOut(String cioTimeOut) {
        this.cioTimeOut = cioTimeOut;
    }

    public int getCioTotalHour() {
        return cioTotalHour;
    }

    public void setCioTotalHour(int cioTotalHour) {
        this.cioTotalHour = cioTotalHour;
    }

    public String getCioPaidStatus() {
        return cioPaidStatus;
    }

    public void setCioPaidStatus(String cioPaidStatus) {
        this.cioPaidStatus = cioPaidStatus;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSsId() {
        return ssId;
    }

    public void setSsId(int ssId) {
        this.ssId = ssId;
    }

    @Override
    public String toString() {
        return "Checkinout{" + "id=" + id + ", cioDate=" + cioDate + ", cioTimeIn=" + cioTimeIn + ", cioTimeOut=" + cioTimeOut + ", cioTotalHour=" + cioTotalHour + ", cioPaidStatus=" + cioPaidStatus + ", employeeId=" + employeeId + ", ssId=" + ssId + '}';
    }
    public void calculateTotalHour() {
        int Total_Hour = 0;
        for (Employee ey : employees) {
            Total_Hour = ey.getHourlyWage()*Total_Hour;
        }
        this.cioTotalHour = Total_Hour;
    }

//    
//    public static Checkinout fromRS(ResultSet rs) {
//        Checkinout checkinout = new Checkinout();
//        try {
//            checkinout.setId(rs.getInt("cio_id"));
//            checkinout.setCioDate(rs.getTimestamp("cio_date"));
//            
////            checkinout.setCioTimeIn(rs.getTime("cio_time_in"));
////            checkinout.setCioTimeOut(rs.getTime("cio_time_out"));
// // Retrieve time values as strings
//        String timeInStr = rs.getString("cio_time_in");
//        String timeOutStr = rs.getString("cio_time_out");
//
//        // Split the time strings and construct Time objects
//        String[] timeInParts = timeInStr.split(":");
//        Time timeIn = new Time(Integer.parseInt(timeInParts[0]), Integer.parseInt(timeInParts[1]), Integer.parseInt(timeInParts[2]));
//
//        String[] timeOutParts = timeOutStr.split(":");
//        Time timeOut = new Time(Integer.parseInt(timeOutParts[0]), Integer.parseInt(timeOutParts[1]), Integer.parseInt(timeOutParts[2]));
//
//        checkinout.setCioTimeIn(timeIn);
//        checkinout.setCioTimeOut(timeOut);
//        
//            checkinout.setCioTotalHour(rs.getInt("cio_total_hour"));
//            checkinout.setCioPaidStatus(rs.getString("cio_paid_status"));
//            checkinout.setEmployeeId(rs.getInt("employee_id"));
//            checkinout.setSsId(rs.getInt("ss_id"));
//        } catch (SQLException ex) { 
//            Logger.getLogger(Checkinout.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//        return checkinout;
//    }
    public static Checkinout fromRS(ResultSet rs) {
        Checkinout checkinout = new Checkinout();
        try {
            checkinout.setId(rs.getInt("cio_id"));
            checkinout.setCioDate(rs.getTimestamp("cio_date"));
            checkinout.setCioTimeIn(rs.getString("cio_time_in"));
            checkinout.setCioTimeOut(rs.getString("cio_time_out"));
            checkinout.setCioTotalHour(rs.getInt("cio_total_hour"));
            checkinout.setCioPaidStatus(rs.getString("cio_paid_status"));
            checkinout.setEmployeeId(rs.getInt("employee_id"));
            checkinout.setSsId(rs.getInt("ss_id"));
        } catch (SQLException ex) {
            Logger.getLogger(Checkinout.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return checkinout;
    }

}
