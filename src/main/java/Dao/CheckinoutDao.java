/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Material;
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
public class CheckinoutDao implements Dao<Material> {

    @Override
    public Material get(int id) {
        Material material = null;
        String sql = "SELECT * FROM material WHERE mat_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                material = Material.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return material;
    }

   

    public List<Material> getAll() {
        ArrayList<Material> list = new ArrayList();
        String sql = "SELECT * FROM material";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Material material = Material.fromRS(rs);
                list.add(material);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<Material> getAll(String where, String order) {
        ArrayList<Material> list = new ArrayList();
        String sql = "SELECT * FROM material where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Material material = Material.fromRS(rs);
                list.add(material);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<Material> getAll(String order) {
        ArrayList<Material> list = new ArrayList();
        String sql = "SELECT * FROM material  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Material material = Material.fromRS(rs);
                list.add(material);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Material save(Material obj) {

        String sql = "INSERT INTO material (mat_name, mat_min_quantity, mat_quantity, mat_unit, mat_price_per_unit)"
                + "VALUES(?, ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getMatMinQty());
            stmt.setInt(3, obj.getMatQty());
            stmt.setString(4, obj.getMatUnit());
            stmt.setFloat(5, obj.getMatPricePerUnit());
//            System.out.println(stmt);
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
    public Material update(Material obj) {
        String sql = "UPDATE material"
                + " SET  mat_name = ?, mat_min_quantity = ?, mat_quantity = ?, mat_unit = ?, mat_price_per_unit = ?"
                + " WHERE mat_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getMatMinQty());
            stmt.setInt(3, obj.getMatQty());
            stmt.setString(4, obj.getMatUnit());
            stmt.setFloat(5, obj.getMatPricePerUnit());
            stmt.setInt(6, obj.getId());
//            System.out.println(stmt);
            int ret = stmt.executeUpdate();
            System.out.println(ret);
            return obj;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int delete(Material obj) {
        String sql = "DELETE FROM material WHERE mat_id=?";
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
