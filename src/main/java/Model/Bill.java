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
 * @author Chaiwat
 */
public class Bill {
    private int id;
    private String shopname;
    private Date creatdDate;
    private float buy;
    private float totalDiscount;
    private float billTotal;
    private float change;
    private int totalQty;
    private int employeeId;

    public Bill(int id, String shopname, Date creatdDate, float buy, float totalDiscount, float billTotal, float change, int totalQty, int employeeId) {
        this.id = id;
        this.shopname = shopname;
        this.creatdDate = creatdDate;
        this.buy = buy;
        this.totalDiscount = totalDiscount;
        this.billTotal = billTotal;
        this.change = change;
        this.totalQty = totalQty;
        this.employeeId = employeeId;
    }
    public Bill(String shopname, Date creatdDate, float buy, float totalDiscount, float billTotal, float change, int totalQty, int employeeId) {
        this.id = -1;
        this.shopname = shopname;
        this.creatdDate = creatdDate;
        this.buy = buy;
        this.totalDiscount = totalDiscount;
        this.billTotal = billTotal;
        this.change = change;
        this.totalQty = totalQty;
        this.employeeId = employeeId;
    }
    public Bill(String shopname,float buy, float totalDiscount, float billTotal, float change, int totalQty, int employeeId) {
        this.id = -1;
        this.shopname = shopname;
        this.creatdDate = null;
        this.buy = buy;
        this.totalDiscount = totalDiscount;
        this.billTotal = billTotal;
        this.change = change;
        this.totalQty = totalQty;
        this.employeeId = employeeId;
    }
    public Bill() {
        this.id = -1;
        this.shopname = "";
        this.creatdDate = null;
        this.buy = 0;
        this.totalDiscount = 0;
        this.billTotal = 0;
        this.change = 0;
        this.totalQty = 0;
        this.employeeId = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public Date getCreatdDate() {
        return creatdDate;
    }

    public void setCreatdDate(Date creatdDate) {
        this.creatdDate = creatdDate;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public float getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(float totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public float getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(float billTotal) {
        this.billTotal = billTotal;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", shopname=" + shopname + ", creatdDate=" + creatdDate + ", buy=" + buy + ", totalDiscount=" + totalDiscount + ", billTotal=" + billTotal + ", change=" + change + ", totalQty=" + totalQty + ", employeeId=" + employeeId + '}';
    }
    public static Bill fromRS(ResultSet rs) {
        Bill bill = new Bill();
        try {
            bill.setId(rs.getInt("bill_id"));
            bill.setShopname(rs.getString("bill_shop_name"));
            bill.setCreatdDate(rs.getTimestamp("bill_created_date"));
            bill.setBuy(rs.getFloat("bill_buy"));
            bill.setTotalDiscount(rs.getFloat("bill_total_discount"));
            bill.setBillTotal(rs.getFloat("bill_total"));
            bill.setChange(rs.getFloat("bill_change"));
            bill.setTotalQty(rs.getInt("bill_total_qty"));
            bill.setEmployeeId(rs.getInt("employee_id"));
        } catch (SQLException ex) {
            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return bill;
    }

//    public boolean isValid() {
//        // Business Rule
//        // Name >= 3
//        // Tel = 10
//        return this.name.length() >= 3
//                && this.tel.length() == 10;
//    }
    
    
}
