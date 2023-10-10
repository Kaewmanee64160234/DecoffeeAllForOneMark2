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
 * @author USER
 */
public class Employee {
    private int id;
    private String name;
    private String address;
    private String telephone;
    private String email;
    private String position;
    private int hourlyWage;
    private int user_id;

    public Employee(int id, String name, String address, String telephone, String email, String position, int hourlyWage, int user_id) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.position = position;
        this.hourlyWage = hourlyWage;
        this.user_id = user_id;
    }

    public Employee(String name, String address, String telephone, String email, String position, int hourlyWage, int user_id) {
        this.id = -1;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.position = position;
        this.hourlyWage = hourlyWage;
        this.user_id = user_id;
    }
    
    public Employee() {
        this.id = -1;
        this.name = "";
        this.address = "";
        this.telephone = "";
        this.email = "";
        this.position = "";
        this.hourlyWage = 0;
        this.user_id = -1;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(int hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", address=" + address + ", telephone=" + telephone + ", email=" + email + ", position=" + position + ", hourlyWage=" + hourlyWage + ", user_id=" + user_id + '}';
    }
    
    public static Employee fromRS(ResultSet rs) {
        Employee employee = new Employee();
        try {
          employee.setId(rs.getInt("employee_id"));
          employee.setName(rs.getString("employee_name"));
          employee.setAddress(rs.getString("employee_address"));
          employee.setTelephone(rs.getString("employee_tel"));
          employee.setEmail(rs.getString("employee_email"));
          employee.setPosition(rs.getString("employee_position"));
          employee.setHourlyWage(rs.getInt("employee_hourly_wage"));
          employee.setUser_id(rs.getInt("user_id"));
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return employee;
    }
    
    
    
    
}
