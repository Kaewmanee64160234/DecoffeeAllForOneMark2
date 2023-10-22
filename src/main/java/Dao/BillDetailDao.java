/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.BillDetail;
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
public class BillDetailDao implements Dao<BillDetail> {

    @Override
    public BillDetail get(int id) {
        BillDetail billDetail = null;
        String sql = "SELECT * FROM bill_detail WHERE bill_detail_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                billDetail = BillDetail.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return billDetail;
    }

    public List<BillDetail> getAll() {
        ArrayList<BillDetail> list = new ArrayList();
        String sql = "SELECT * FROM bill_detail";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                BillDetail billDetail = BillDetail.fromRS(rs);
                list.add(billDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<BillDetail> getAll(String where, String order) {
        ArrayList<BillDetail> list = new ArrayList();
        String sql = "SELECT * FROM bill_detail where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                BillDetail billDetail = BillDetail.fromRS(rs);
                list.add(billDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    // public List<BillDetail> getAll(String order) {
    //     ArrayList<BillDetail> list = new ArrayList();
    //     String sql = "SELECT * FROM bill_detail  ORDER BY" + order;
    //     Connection conn = DatabaseHelper.getConnect();
    //     try {
    //         Statement stmt = conn.createStatement();
    //         ResultSet rs = stmt.executeQuery(sql);

    //         while (rs.next()) {
    //             BillDetail billDetail = BillDetail.fromRS(rs);
    //             list.add(billDetail);

    //         }

    //     } catch (SQLException ex) {
    //         System.out.println(ex.getMessage());
    //     }
    //     return list;
    // }

    public List<BillDetail> getAll(String order) {
        ArrayList<BillDetail> list = new ArrayList();
        String sql = "SELECT * FROM bill_detail  ORDER BY " + order; // Added space after "ORDER BY"
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
    
            while (rs.next()) {
                BillDetail billDetail = BillDetail.fromRS(rs);
                list.add(billDetail);
            }
    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<BillDetail> getBillDetailForDate(String selectedDate) {
        ArrayList<BillDetail> list = new ArrayList();
        String sql = """ 
              SELECT bd.*
                FROM bill_detail bd
                     JOIN bill b ON b.bill_id = bd.bill_id
                WHERE b.bill_created_date = ?;
                                 """;
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, selectedDate);
            ResultSet rs = stmt.executeQuery();
    
            while (rs.next()) {
                BillDetail obj = BillDetail.fromRS(rs);
                list.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public BillDetail save(BillDetail obj) {

        String sql = "INSERT INTO bill_detail (bill_detail_name, bill_detail_amount, bill_detail_discount, bill_detail_price, bill_detail_total, bill_id, mat_id)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getAmount());
            stmt.setFloat(3, obj.getDiscount());
            stmt.setFloat(4, obj.getPrice());
            stmt.setFloat(5, obj.getTotal());
            stmt.setInt(6, obj.getBill_id());
            stmt.setInt(7, obj.getMat_id());
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
    public BillDetail update(BillDetail obj) {
        String sql = "UPDATE bill_detail"
                + " SET  bill_detail_name = ?, bill_detail_amount = ?, bill_detail_discount = ?, bill_detail_price = ?, bill_detail_total = ?"
                + " WHERE bill_detail_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getAmount());
            stmt.setFloat(3, obj.getDiscount());
            stmt.setFloat(4, obj.getPrice());
            stmt.setFloat(5, obj.getTotal());
            stmt.setInt(6, obj.getId());
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
    public int delete(BillDetail obj) {
        String sql = "DELETE FROM bill_detail WHERE bill_detail_id=?";
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
