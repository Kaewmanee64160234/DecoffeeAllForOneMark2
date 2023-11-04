/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.RecieptDetail;
import Model.RecieptDetailReport;
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
public class RecieptDetailDao implements Dao<RecieptDetail> {

    @Override
    public RecieptDetail get(int id) {
        RecieptDetail recieptDetail = null;
        Connection conn = DatabaseHelper.getConnect();
        String sql = "SELECT * FROM reciept_detail WHERE reciept_detail_id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                recieptDetail = RecieptDetail.fromRS(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return recieptDetail;
    }

    @Override
    public List<RecieptDetail> getAll() {
        ArrayList<RecieptDetail> list = new ArrayList();
        String sql = "SELECT * FROM reciept_detail";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RecieptDetail receipt = RecieptDetail.fromRS(rs);
                list.add(receipt);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<RecieptDetail> getAll(String where, String order) {
        ArrayList<RecieptDetail> list = new ArrayList();
        String sql = "SELECT * FROM reciept_detail where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RecieptDetail receipt = RecieptDetail.fromRS(rs);
                list.add(receipt);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<RecieptDetail> getAll(String order) {
        ArrayList<RecieptDetail> list = new ArrayList();
        String sql = "SELECT * FROM reciept_detail  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RecieptDetail receipt = RecieptDetail.fromRS(rs);
                list.add(receipt);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<RecieptDetailReport> getTopTenProductSale(int limit) {
        ArrayList<RecieptDetailReport> list = new ArrayList();
        String sql = """
                SELECT product_id,reciept_detail_name, sum(reciept_detail_qty ) AS TotalQty
                FROM reciept_detail
                GROUP BY product_id
                ORDER BY TotalQty DESC, reciept_detail_name ASC
                LIMIT ?
                                      """;

        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RecieptDetailReport obj = RecieptDetailReport.fromRS(rs);
                list.add(obj);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public RecieptDetail save(RecieptDetail obj) {
        String sql = "INSERT INTO reciept_detail(reciept_detail_name, reciept_detail_qty, reciept_detail_price, size, type_price, type, size_price, topping, topping_price, reciept_detail_total_price, reciept_id, product_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getQty());
            stmt.setFloat(3, obj.getPrice());
            stmt.setString(4, obj.getSize());
            stmt.setFloat(5, obj.getTypePrice());
            stmt.setString(6, obj.getType());
            stmt.setFloat(7, obj.getSizePrice());
            stmt.setString(8, obj.getTopping());
            stmt.setFloat(9, obj.getToppingPrice());
            stmt.setFloat(10, obj.getTotal());
            stmt.setInt(11, obj.getRecieptId());
            stmt.setInt(12, obj.getProductId()); // Set the product_id

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
    public RecieptDetail update(RecieptDetail obj) {
        String sql = "UPDATE reciept_detail SET reciept_detail_name = ?,reciept_detail_qty = ?,reciept_detail_price = ?,size = ?,type_price = ?,type = ?,size_price = ?,topping = ?,topping_price = ?,reciept_detail_total_price = ?,reciept_id = ?,product_id = ? WHERE reciept_detail_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getQty());
            stmt.setFloat(3, obj.getPrice());
            stmt.setString(4, obj.getSize());
            stmt.setFloat(5, obj.getTypePrice());
            stmt.setString(6, obj.getType());
            stmt.setFloat(7, obj.getSizePrice());
            stmt.setString(8, obj.getTopping());
            stmt.setFloat(9, obj.getToppingPrice());
            stmt.setFloat(10, obj.getTotal());
            stmt.setInt(11, obj.getRecieptId());
            stmt.setInt(12, obj.getProductId());
            stmt.setInt(13, obj.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public int delete(RecieptDetail obj) {
        String sql = "DELETE FROM reciept_detail WHERE reciept_detail_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            int ret = stmt.executeUpdate();
            return ret;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    public List<RecieptDetail> getRecieptDetailForDate(String selectedDate) {
        ArrayList<RecieptDetail> list = new ArrayList();
        String sql = """
                SELECT rd.*
                FROM reciept_detail rd
                     JOIN
                     reciept r ON r.reciept_id = rd.reciept_id
                WHERE r.create_date = ?;
                                 """;
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, selectedDate);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RecieptDetail obj = RecieptDetail.fromRS(rs);
                list.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
     public ArrayList<RecieptDetail> getrDetailsByReciptId( int recieptId) {
        ArrayList<RecieptDetail> list = new ArrayList();
        String sql = """
                SELECT *
                FROM reciept_detail
                WHERE reciept_id = ?;
                                 """;
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, recieptId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RecieptDetail obj = RecieptDetail.fromRS(rs);
                list.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    

}
