/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Checkinout;
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
public class CheckinoutDao implements Dao<Checkinout> {

    @Override
    public Checkinout get(int id) {
        Checkinout checkinout = null;
        String sql = "SELECT * FROM checkinout WHERE cio_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                checkinout = Checkinout.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return checkinout;
    }

   

    public List<Checkinout> getAll() {
        ArrayList<Checkinout> list = new ArrayList();
        String sql = "SELECT * FROM checkinout";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Checkinout checkinout = Checkinout.fromRS(rs);
                list.add(checkinout);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<Checkinout> getAll(String where, String order) {
        ArrayList<Checkinout> list = new ArrayList();
        String sql = "SELECT * FROM checkinout where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Checkinout checkinout = Checkinout.fromRS(rs);
                list.add(checkinout);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<Checkinout> getAll(String order) {
        ArrayList<Checkinout> list = new ArrayList();
        String sql = "SELECT * FROM checkinout  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Checkinout checkinout = Checkinout.fromRS(rs);
                list.add(checkinout);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Checkinout save(Checkinout obj) {

        String sql = "INSERT INTO checkinout (cio_id, cio_time_in, cio_time_out, cio_total_hour, cio_paid_status, employee_id, ss_id)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTime(1, obj.getCioTimeIn());
            stmt.setTime(2, obj.getCioTimeOut());
            stmt.setInt(3, obj.getCioTotalHour());
            stmt.setString(4, obj.getCioPaidStatus());
            stmt.setInt(5, obj.getEmployeeId());
            stmt.setInt(6, obj.getSsId());
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
    public Checkinout update(Checkinout obj) {
        String sql = "UPDATE checkinout"
                + " SET  cio_date = ?, cio_time_in = ?, cio_time_out = ?, cio_total_hour = ?, cio_paid_status = ?, employee_id = ?, ss_id = ?"
                + " WHERE cio_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTime(1, obj.getCioTimeIn());
            stmt.setTime(2, obj.getCioTimeOut());
            stmt.setInt(3, obj.getCioTotalHour());
            stmt.setString(4, obj.getCioPaidStatus());
            stmt.setInt(5, obj.getEmployeeId());
            stmt.setInt(6, obj.getSsId());
            stmt.setInt(7, obj.getId());
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
    public int delete(Checkinout obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
