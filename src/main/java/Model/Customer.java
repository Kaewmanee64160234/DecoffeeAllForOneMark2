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
public class Customer {

    private int id;
    private String name;
    private String tel;
    private int point;
    private Date startDate;

    public Customer(int id, String name, String tel, int point, Date startDate) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.point = point;
        this.startDate = startDate;
    }

    public Customer(String name, String tel, int point, Date startDate) {
        this.id = -1;
        this.name = name;
        this.tel = tel;
        this.point = point;
        this.startDate = startDate;
    }
    
     public Customer(String name, String tel, int point) {
        this.id = -1;
        this.name = name;
        this.tel = tel;
        this.point = point;
        this.startDate = null;
    }

    public Customer() {
        this.id = -1;
        this.name = "";
        this.tel = "";
        this.point = 0;
        this.startDate = null;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", tel=" + tel + ", point=" + point + ", startDate=" + startDate + '}';
    }

    public static Customer fromRS(ResultSet rs) {
        Customer customer = new Customer();
        try {
            customer.setId(rs.getInt("customer_id"));
            customer.setName(rs.getString("customer_name"));
            customer.setTel(rs.getString("customer_tel"));
            customer.setPoint(rs.getInt("customer_point"));
            customer.setStartDate(rs.getTimestamp("customer_start_date"));
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return customer;
    }
}
