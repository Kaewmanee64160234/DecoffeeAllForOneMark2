/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Bill;
import Model.HistoryMaterialReport;
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
 * @author werapan
 */
public class BillDao implements Dao<Bill> {

    @Override
    public Bill get(int id) {
        Bill bill = null;
        String sql = "SELECT * FROM bill WHERE bill_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                bill = Bill.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return bill;
    }

    public List<Bill> getAll() {
        ArrayList<Bill> list = new ArrayList();
        String sql = "SELECT * FROM bill";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Bill bill = Bill.fromRS(rs);
                list.add(bill);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<Bill> getAll(String where, String order) {
        ArrayList<Bill> list = new ArrayList();
        String sql = "SELECT * FROM bill where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Bill bill = Bill.fromRS(rs);
                list.add(bill);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Bill> getAll(String order) {
        ArrayList<Bill> list = new ArrayList();
        String sql = "SELECT * FROM bill  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Bill bill = Bill.fromRS(rs);
                list.add(bill);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<HistoryMaterialReport> getBillHistory(String being, String end) {
        ArrayList<HistoryMaterialReport> list = new ArrayList();
        String sql = """ 
               SELECT bill_id, bill_created_date,bill_total
               FROM bill
               WHERE bill_created_date  BETWEEN ? AND ?
                                     """;
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, being);
            stmt.setString(2, end);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                HistoryMaterialReport obj = HistoryMaterialReport.fromRS(rs);
                list.add(obj);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<HistoryMaterialReport> getBillHistory() {
        ArrayList<HistoryMaterialReport> list = new ArrayList();
        String sql = """ 
               SELECT bill_id, bill_created_date,bill_total
               FROM bill
               WHERE bill_created_date  BETWEEN ? AND ?
                                     """;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                HistoryMaterialReport obj = HistoryMaterialReport.fromRS(rs);
                list.add(obj);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Bill save(Bill obj) {

        String sql = "INSERT INTO bill (bill_created_date,bill_shop_name, bill_buy, bill_total_discount, bill_total, bill_change, bill_total_qty, employee_id)"
                + "VALUES(?,?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getCreatdDate());
            stmt.setString(2, obj.getShopname());
            stmt.setFloat(3, obj.getBuy());
            stmt.setFloat(4, obj.getTotalDiscount());
            stmt.setFloat(5, obj.getBillTotal());
            stmt.setFloat(6, obj.getChange());
            stmt.setInt(7, obj.getTotalQty());
            stmt.setInt(8, obj.getEmployeeId());
            // System.out.println(stmt);
            stmt.executeUpdate();
            int id = DatabaseHelper.getInsertedId(stmt);
            obj.setId(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public Bill update(Bill obj) {
        String sql = "UPDATE bill"
                + " SET  bill_shop_name = ?, bill_buy = ?, bill_total_discount = ?, bill_total = ?, bill_change = ? , bill_total_qty = ?"
                + " WHERE bill_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getShopname());
            stmt.setFloat(2, obj.getBuy());
            stmt.setFloat(3, obj.getTotalDiscount());
            stmt.setFloat(4, obj.getBillTotal());
            stmt.setFloat(5, obj.getChange());
            stmt.setInt(6, obj.getTotalQty());
            stmt.setInt(7, obj.getId());
            // System.out.println(stmt);
            int ret = stmt.executeUpdate();
            System.out.println(ret);
            return obj;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int delete(Bill obj) {
        String sql = "DELETE FROM bill WHERE bill_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            int ret = stmt.executeUpdate();
            return ret;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

}
