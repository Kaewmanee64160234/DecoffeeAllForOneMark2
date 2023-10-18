/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Reciept;
import Model.RecieptReport;
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
public class RecieptDao implements Dao<Reciept> {

    @Override
    public Reciept get(int id) {
        Reciept reciept = null;
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
        String sql = "SELECT * FROM receipt where " + where + " ORDER BY " + order;
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
        String sql = "SELECT * FROM reciept  ORDER BY" + order;
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

    public List<RecieptReport> getRecieptByTotalSale(String being, String end) {
        ArrayList<RecieptReport> list = new ArrayList();
        String sql = """
            SELECT sum(reciept_total) AS TotalSale
            FROM reciept
            WHERE  create_date BETWEEN ? AND ?
            GROUP BY create_date
                     """;
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, being);
            stmt.setString(2, end);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RecieptReport obj = RecieptReport.fromRS(rs);
                list.add(obj);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    
    @Override
    public Reciept save(Reciept obj) {

        String sql = "INSERT INTO reciept (reciept_queue,reciept_discount,reciept_total,reciept_receive,reciept_change,reciept_total_qty,reciept_payment,store_id,customer_id,prom_id,employee_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println(sql);
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getQueue());
            stmt.setFloat(2, obj.getDiscount());
            stmt.setFloat(3, obj.getTotal());
            stmt.setFloat(4, obj.getReceive());
            stmt.setFloat(5, obj.getChange());
            stmt.setInt(6, obj.getTotalQTY());
            stmt.setString(7, obj.getPayment());
            stmt.setInt(8, obj.getStoreId());
            stmt.setInt(9, obj.getCustomerId());
            stmt.setInt(10, obj.getPromotionId());
            stmt.setInt(11, obj.getEmployeeId());
           
            stmt.executeUpdate();
            int id = DatabaseHelper.getInsertedId(stmt);
            obj.setId(id);
            return obj;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public Reciept update(Reciept obj) {
        String sql = "UPDATE receipt SET created_date = ?,reciept_queue = ?,reciept_discount = ?,reciept_total = ?,reciept_receive = ?,reciept_change = ?,reciept_total_qty = ?,reciept_payment = ?,store_id = ?,customer_id = ?,prom_id = ?,employee_id = ? WHERE reciept_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public int delete(Reciept obj) {
        String sql = "DELETE FROM receipt WHERE reciept_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

}
