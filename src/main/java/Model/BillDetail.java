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
 * @author Chaiwat
 */
public class BillDetail {
    private int id;
    private String  name;
    private int amount;
    private float discount;
    private float price;
    private float total;
    private int bill_id;
    private int mat_id;

    public BillDetail(int id, String name, int amount, float discount, float price, float total, int bill_id, int mat_id) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.discount = discount;
        this.price = price;
        this.total = total;
        this.bill_id = bill_id;
        this.mat_id = mat_id;
    }
    
    public BillDetail(String name, int amount, float discount, float price, float total, int bill_id, int mat_id) {
        this.id = -1;
        this.name = name;
        this.amount = amount;
        this.discount = discount;
        this.price = price;
        this.total = total;
        this.bill_id = bill_id;
        this.mat_id = mat_id;
    }
    
    public BillDetail() {
        this.id = -1;
        this.name = "";
        this.amount = 0;
        this.discount = 0;
        this.price = 0;
        this.total = 0;
        this.bill_id = -1;
        this.mat_id = -1;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getMat_id() {
        return mat_id;
    }

    public void setMat_id(int mat_id) {
        this.mat_id = mat_id;
    }

    @Override
    public String toString() {
        return "BillDetail{" + "id=" + id + ", name=" + name + ", amount=" + amount + ", discount=" + discount + ", price=" + price + ", total=" + total + ", bill_id=" + bill_id + ", mat_id=" + mat_id + '}';
    }
    
    public static BillDetail fromRS(ResultSet rs) {
        BillDetail billDetail = new BillDetail();
        try {
            billDetail.setId(rs.getInt("bill_detail_id"));
            billDetail.setName(rs.getString("bill_detail_name"));
            billDetail.setAmount(rs.getInt("bill_detail_amount"));
            billDetail.setDiscount(rs.getFloat("bill_detail_discount"));
            billDetail.setPrice(rs.getFloat("bill_detail_price"));
            billDetail.setTotal(rs.getFloat("bill_detail_total"));
            billDetail.setBill_id(rs.getInt("bill_id"));
            billDetail.setMat_id(rs.getInt("mat_id"));
        } catch (SQLException ex) {
            Logger.getLogger(BillDetail.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return billDetail;
    }
}
