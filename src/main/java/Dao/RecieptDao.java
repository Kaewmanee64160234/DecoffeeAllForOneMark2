/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Reciept;
import helper.DatabaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class RecieptDao implements Dao<Reciept>{

    @Override
    public Reciept get(int id) {
        Reciept reciept =null;
        String sql = "SELECT * FROM reciept WHERE reciept_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reciept = Reciept.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return reciept;
    }

    @Override
    public List<Reciept> getAll() {
        ArrayList<Reciept> list = new ArrayList();
        String sql = "SELECT * FROM receipt";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Reciept receipt = Reciept.fromRS(rs);
                list.add(receipt);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    @Override
    public List<Reciept> getAll(String where, String order) {
        ArrayList<Reciept> list = new ArrayList();
        String sql = "SELECT * FROM receipt where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Reciept receipt = Reciept.fromRS(rs);
                list.add(receipt);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    public List<Reciept> getAll(String order) {
        ArrayList<Reciept> list = new ArrayList();
        String sql = "SELECT * FROM receipt  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Reciept receipt = Reciept.fromRS(rs);
                list.add(receipt);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Reciept save(Reciept obj) {
        String sql = "INSERT INTO receipt (reciept_id,created_date,reciept_queue,reciept_discount,reciept_total,reciept_receive,reciept_change,reciept_total_qty,reciept_payment,store_id,customer_id,prom_id,employee_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DatabaseHelper.getConnect();
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.setDate(2, obj.getCreaetedDate());
            stmt.setInt(3, obj.getQueue());
            stmt.setFloat(4, obj.getDiscount());
            stmt.setFloat(5, obj.getTotal());
            stmt.setFloat(6, obj.getReceive());
            stmt.setFloat(7, obj.getChange());
            stmt.setInt(8, obj.getTotalQTY());
            stmt.setString(9, obj.getPayment());
            stmt.setInt(10, obj.getStoreId());
            stmt.setInt(11, obj.getCustomerId());
            stmt.setInt(12, obj.getPromotionId());
            stmt.setInt(13, obj.getEmployeeId());
            stmt.executeUpdate();
            return obj;
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Reciept update(Reciept obj) {
        String sql = "UPDATE receipt SET created_date = ?,reciept_queue = ?,reciept_discount = ?,reciept_total = ?,reciept_receive = ?,reciept_change = ?,reciept_total_qty = ?,reciept_payment = ?,store_id = ?,customer_id = ?,prom_id = ?,employee_id = ? WHERE reciept_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, obj.getCreaetedDate());
            stmt.setInt(2, obj.getQueue());
            stmt.setFloat(3, obj.getDiscount());
            stmt.setFloat(4, obj.getTotal());
            stmt.setFloat(5, obj.getReceive());
            stmt.setFloat(6, obj.getChange());
            stmt.setInt(7, obj.getTotalQTY());
            stmt.setString(8, obj.getPayment());
            stmt.setInt(9, obj.getStoreId());
            stmt.setInt(10, obj.getCustomerId());
            stmt.setInt(11, obj.getPromotionId());
            stmt.setInt(12, obj.getEmployeeId());
            stmt.setInt(13, obj.getId());
            stmt.executeUpdate();
            return obj;
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public int delete(Reciept obj) {
        String sql = "DELETE FROM receipt WHERE reciept_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            return stmt.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    
    
}
