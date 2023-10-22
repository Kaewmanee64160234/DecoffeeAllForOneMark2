/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Checkinout;
import Model.SummarySalary;
import helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author werapan
 */
public class CheckinoutDao implements Dao<Checkinout> {

    @Override
    public Checkinout get(int id) {
        Checkinout checkinout = null;
        String sql = "SELECT * FROM check_in_out WHERE cio_id=?";
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

   

    public ArrayList<Checkinout> getAll() {
        ArrayList<Checkinout> list = new ArrayList();
        String sql = "SELECT * FROM check_in_out";
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
        String sql = "SELECT * FROM check_in_out where " + where + " ORDER BY" + order;
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
        String sql = "SELECT * FROM check_in_out  ORDER BY" + order;
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
       String sql = "INSERT INTO check_in_out (cio_time_in, cio_time_out, cio_total_hour, cio_paid_status, employee_id, ss_id)"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getCioTimeIn());
            stmt.setString(2, obj.getCioTimeOut());
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
    
    public Checkinout getById(int id) {
        Checkinout checkinout = null;
        String sql = "SELECT * FROM check_in_out WHERE cio_id=?";
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

    public ArrayList<Checkinout> getBySSId(int ssId){
        ArrayList<Checkinout> list = new ArrayList();
        String sql = "SELECT * FROM check_in_out WHERE ss_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ssId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Checkinout checkinout = Checkinout.fromRS(rs);
                list.add(checkinout);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
      
    }
    
    
    public Checkinout getByDate(Date date) {
        Checkinout checkinout = null;
        String sql = "SELECT * FROM check_in_out WHERE cio_date=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, (java.sql.Date) date);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                checkinout = Checkinout.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return checkinout;
    }

    @Override
    public Checkinout update(Checkinout obj) {
        String sql = "UPDATE check_in_out"
                + " SET cio_time_in = ?, cio_time_out = ?, cio_total_hour = ?, cio_paid_status = ?, employee_id = ?, ss_id = ?"
                + " WHERE cio_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getCioTimeIn());
            stmt.setString(2, obj.getCioTimeOut());
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
         String sql = "DELETE FROM check_in_out WHERE cio_id=?";
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



    public List<Checkinout> getAllByIdEmployee(int id) {
        ArrayList<Checkinout> list = new ArrayList();
        String sql = "SELECT * FROM check_in_out where employee_id = ? ORDER BY cio_date ASC";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Checkinout checkinout = Checkinout.fromRS(rs);
                list.add(checkinout);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return list;
    }

    
    public ArrayList<Checkinout> getCheckInOutByPaidStatusAndEmpId(int id,char paidStatus){
        ArrayList<Checkinout> list = new ArrayList();
        String sql = "SELECT * FROM check_in_out where employee_id = ? and cio_paid_status = ? and ss_id=-1 ORDER BY cio_date DESC";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, String.valueOf(paidStatus));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Checkinout checkinout = Checkinout.fromRS(rs);
                list.add(checkinout);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return list;
    }
    
    public ArrayList<Checkinout> getCheckInOutByPaidStatusAndEmpIdForAddInSS(int id,char paidStatus){
        ArrayList<Checkinout> list = new ArrayList();
        String sql = "SELECT * FROM check_in_out where employee_id = ? and ss_id=-1 and cio_paid_status = ? ORDER BY cio_date DESC";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, String.valueOf(paidStatus));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Checkinout checkinout = Checkinout.fromRS(rs);
                list.add(checkinout);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return list;
    }
    public ArrayList<Checkinout>  getCheckInOutByEmpIdStatusNoAndTotalNotZero(int id){
        ArrayList<Checkinout> list = new ArrayList();
        String sql = "SELECT * FROM check_in_out where employee_id = ? and cio_paid_status = 'N' and cio_total_hour != 0 and ss_id=-1 ORDER BY cio_date DESC";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Checkinout checkinout = Checkinout.fromRS(rs);
                list.add(checkinout);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return list;
    }
    public ArrayList<Checkinout> getCheckinoutsBySsId(int id) {
        ArrayList<Checkinout> list = new ArrayList();
        String sql = "SELECT * FROM check_in_out where ss_id = ? ORDER BY cio_date DESC";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Checkinout checkinout = Checkinout.fromRS(rs);
                list.add(checkinout);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return list;
    }



    public ArrayList<Checkinout> getLastCheckInOut(int id) {
        ArrayList<Checkinout> list = new ArrayList();
        String sql = "SELECT * FROM check_in_out where employee_id = ? and cio_paid_status = 'N' and cio_total_hour != 0 and ss_id !=-1 ORDER BY cio_date DESC";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Checkinout checkinout = Checkinout.fromRS(rs);
                list.add(checkinout);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return list;
        
    }



}
