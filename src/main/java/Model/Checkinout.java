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
    private Time cioTimeIn;
    private Time cioTimeOut;
    private int cioTotalHour;
    private String cioPaidStatus;
    private int employeeId;
    private int ssId;
    private ArrayList<Employee> employees = new ArrayList();



    public Checkinout(int id, Date cioDate, Time cioTimeIn, Time cioTimeOut, int cioTotalHour, String cioPaidStatus, int employeeId, int ssId) {
        this.id = id;
        this.cioDate = cioDate;
        this.cioTimeIn = cioTimeIn;
        this.cioTimeOut = cioTimeOut;
        this.cioTotalHour = cioTotalHour;
        this.cioPaidStatus= cioPaidStatus;
        this.employeeId= employeeId;
        this.ssId = ssId;
    }
     public Checkinout(Date cioDate, Time cioTimeIn, Time cioTimeOut, int cioTotalHour, String cioPaidStatus, int employeeId, int ssId) {
        this.id = -1;
        this.cioDate = cioDate;
        this.cioTimeIn = cioTimeIn;
        this.cioTimeOut = cioTimeOut;
        this.cioTotalHour = cioTotalHour;
        this.cioPaidStatus= cioPaidStatus;
        this.employeeId= employeeId;
        this.ssId = ssId;
    }
    public Checkinout( ) {
        this.id = -1;
        this.cioDate = null;
        this.cioTimeIn = null;
        this.cioTimeOut = null;
        this.cioTotalHour = 0;
        this.cioPaidStatus= "";
        this.employeeId= -1;
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

    public Time getCioTimeIn() {
        return cioTimeIn;
    }

    public void setCioTimeIn(Time cioTimeIn) {
        this.cioTimeIn = cioTimeIn;
    }

    public Time getCioTimeOut() {
        return cioTimeOut;
    }

    public void setCioTimeOut(Time cioTimeOut) {
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

   

    
    public static Checkinout fromRS(ResultSet rs) {
        Checkinout checkinout = new Checkinout();
        try {
            checkinout.setId(rs.getInt("cio_id"));
            checkinout.setCioDate(rs.getTimestamp("cio_date"));
//                        obj.setCreaetedDate(rs.getTimestamp("create_date"));

            checkinout.setCioTimeIn(rs.getTime("cio_time_in"));
            checkinout.setCioTimeOut(rs.getTime("cio_time_out"));
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
