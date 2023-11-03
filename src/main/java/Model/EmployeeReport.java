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
public class EmployeeReport {

    private int id;
    private String name;
    private String MonthYear;
    private int TopEmployee;

    public EmployeeReport(int id, String name, String MonthYear, int TopEmployee) {
        this.id = id;
        this.name = name;
        this.MonthYear = MonthYear;
        this.TopEmployee = TopEmployee;
    }

    public EmployeeReport(String name, String MonthYear, int TopEmployee) {
        this.id = -1;
        this.name = name;
        this.MonthYear = MonthYear;
        this.TopEmployee = TopEmployee;
    }

    public EmployeeReport() {
        this.id = -1;
        this.name = "";
        this.MonthYear = "";
        this.TopEmployee = 0;
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

    public int getTopEmployee() {
        return TopEmployee;
    }

    public void setTopEmployee(int TopEmployee) {
        this.TopEmployee = TopEmployee;
    }

    public String getMonthYear() {
        return MonthYear;
    }

    public void setMonthYear(String MonthYear) {
        this.MonthYear = MonthYear;
    }

    @Override
    public String toString() {
        return "EmployeeReport{" + "id=" + id + ", name=" + name + ", MonthYear=" + MonthYear + ", TopEmployee=" + TopEmployee + '}';
    }
    
  

    public static EmployeeReport fromRS(ResultSet rs) {
        EmployeeReport obj = new EmployeeReport();
        try {
            obj.setId(rs.getInt("employee_id"));
            obj.setName(rs.getString("employee_name"));
            obj.setMonthYear(rs.getString("MonthYear"));
            obj.setTopEmployee(rs.getInt("TopEmployee"));

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeReport.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return obj;
    }

}
