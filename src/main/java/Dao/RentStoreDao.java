/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.RentStore;
import helper.DatabaseHelper;
import java.sql.Array;
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
public class RentStoreDao implements Dao<RentStore> {

    @Override
    public RentStore get(int id) {
        RentStore rentStore = null;
        String sql = "SELECT * FROM rent_store WHERE rent_store_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                rentStore = RentStore.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rentStore;
    }

    public ArrayList<RentStore> getAll() {
        ArrayList<RentStore> list = new ArrayList();
        String sql = "SELECT * FROM rent_store";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RentStore rentStore = RentStore.fromRS(rs);
                list.add(rentStore);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<RentStore> getAll(String where, String order) {
        ArrayList<RentStore> list = new ArrayList();
        String sql = "SELECT * FROM rent_store where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RentStore rentStore = RentStore.fromRS(rs);
                list.add(rentStore);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<RentStore> getAll(String order) {
        ArrayList<RentStore> list = new ArrayList();
        String sql = "SELECT * FROM rent_store  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RentStore rentStore = RentStore.fromRS(rs);
                list.add(rentStore);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public RentStore save(RentStore obj) {
        String sql = "INSERT INTO rent_store (rent_water, rent_electric, rent_total, rent_paid_status, store_id, rent_price, rent_date, rent_other )"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setFloat(1, obj.getRentWater());
            stmt.setFloat(2, obj.getRentElectic());
            stmt.setFloat(3, obj.getRentTotal());
            stmt.setString(4, obj.getRentPaidStatus());
            stmt.setInt(5, obj.getStoreId());
            stmt.setFloat(6, obj.getRentPrice());
            stmt.setString(7, obj.getRentDate());
            stmt.setFloat(8, obj.getRentOther());

            stmt.executeUpdate();
            int id = DatabaseHelper.getInsertedId(stmt);
            obj.setId(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    public RentStore getByStore(int store) {
        RentStore rentStore = null;
        String sql = "SELECT * FROM rent_store WHERE store_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, store);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                rentStore = RentStore.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rentStore;
    }
        public ArrayList<RentStore> getByPaidStatus(String status) {
        ArrayList<RentStore> list = new ArrayList();
        String sql = "SELECT * FROM rent_store WHERE rent_paid_status=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RentStore rentStore = RentStore.fromRS(rs);
                list.add(rentStore);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
        
        public ArrayList<RentStore> getByDateByPaidStatus(String status, String begin, String end) {
        ArrayList<RentStore> list = new ArrayList();
        String sql = "SELECT * FROM rent_store WHERE rent_paid_status=? AND rent_date BETWEEN ? AND ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setString(2, begin);
            stmt.setString(3, end);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RentStore rentStore = RentStore.fromRS(rs);
                list.add(rentStore);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }


    public ArrayList<RentStore> getByDate(String begin, String end) {
        ArrayList<RentStore> list = new ArrayList();
        String sql = "SELECT * FROM rent_store WHERE rent_date BETWEEN ? AND ? ";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, begin);
            stmt.setString(2, end);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RentStore rentStore = RentStore.fromRS(rs);
                list.add(rentStore);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    @Override
    public RentStore update(RentStore obj) {
        String sql = "UPDATE rent_store"
                + " SET  rent_water = ?, rent_electric = ?, rent_total = ?, rent_paid_status = ?, store_id = ?, rent_price = ?, rent_other = ?, rent_date = ?"
                + " WHERE rent_store_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setFloat(1, obj.getRentWater());
            stmt.setFloat(2, obj.getRentElectic());
            stmt.setFloat(3, obj.getRentTotal());
            stmt.setString(4, obj.getRentPaidStatus());
            stmt.setInt(5, obj.getStoreId());
            stmt.setFloat(6, obj.getRentPrice());
            stmt.setFloat(7, obj.getRentOther());
            stmt.setString(8, obj.getRentDate());
            stmt.setInt(9, obj.getId());

            int ret = stmt.executeUpdate();
            System.out.println(ret);
            return obj;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int delete(RentStore obj) {
        String sql = "DELETE FROM rent_store WHERE rent_store_id=?";
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
