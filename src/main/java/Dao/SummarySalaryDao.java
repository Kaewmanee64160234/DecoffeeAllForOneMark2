/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.SummarySalary;
import helper.DatabaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class SummarySalaryDao implements Dao<SummarySalary>{

    @Override
    public SummarySalary get(int id) {
        SummarySalary summary = new SummarySalary();
        String sql = "SELECT * FROM summary_salary WHERE ss_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                summary = SummarySalary.fromRS(rs);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return summary;
    }

    @Override
    public List<SummarySalary> getAll() {
        ArrayList<SummarySalary> summaryList = new ArrayList();
        String sql = "SELECT * FROM summary_salary";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SummarySalary summary = SummarySalary.fromRS(rs);
                summaryList.add(summary);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return summaryList;
    }

    @Override
    public SummarySalary save(SummarySalary obj) {
        String sql = "INSERT INTO summary_salary ( ss_date, ss_work_hour, ss_salary,ss_paid_status) VALUES ( ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getDate());
            stmt.setInt(2, obj.getTotalHour());
            stmt.setDouble(3, obj.getSalary());
            stmt.setString(4, obj.getPaidStatus());
            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public SummarySalary update(SummarySalary obj) {
    String sql = "UPDATE summary_salary SET ss_date = ?, ss_work_hour = ?, ss_salary = ?, ss_paid_status = ? WHERE ss_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getDate());
            stmt.setInt(2, obj.getTotalHour());
            stmt.setDouble(3, obj.getSalary());
            stmt.setString(4, obj.getPaidStatus());
            stmt.setInt(5, obj.getId());
            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public int delete(SummarySalary obj) {
        String sql = "DELETE FROM summary_salary WHERE ss_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            int ret = stmt.executeUpdate();
            return ret;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    @Override
    public List<SummarySalary> getAll(String where, String order) {
        ArrayList<SummarySalary> summaryList = new ArrayList();
        String sql = "SELECT * FROM summary_salary " + where + " " + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SummarySalary summary = SummarySalary.fromRS(rs);
                summaryList.add(summary);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return summaryList;
    }

   
    
}
