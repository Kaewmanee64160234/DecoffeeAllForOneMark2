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
public class SummarySalaryDao implements Dao<SummarySalary> {

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
            int id = DatabaseHelper.getInsertedId(stmt);
            System.out.println(id);

            obj.setId(id);
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
            int id = DatabaseHelper.getInsertedId(stmt);
            obj.setId(id);
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

    public SummarySalary getSalaryLastCreated() {
        SummarySalary summary = new SummarySalary();
        String sql = "SELECT summary_salary.ss_id, MIN(check_in_out.cio_date) as startDate ,MAX(check_in_out.cio_date) as endDate ,ss_work_hour as totalHour,ss_salary as Salary  FROM summary_salary JOIN check_in_out ON summary_salary.ss_id = check_in_out.ss_id ORDER BY summary_salary.ss_id DESC LIMIT 1;";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                summary = SummarySalary.fromRSToPrintSummarySalary(rs);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return summary;
    }

    public ArrayList<SummarySalary> getSummarySalarysByPaidStatus(String status) {
        ArrayList<SummarySalary> summaryList = new ArrayList();
        String sql = "SELECT * FROM summary_salary WHERE ss_paid_status = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
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
    public ArrayList<SummarySalary> getSummarySalarysByDateByPaidStatus(String status, String begin, String end) {
        ArrayList<SummarySalary> summaryList = new ArrayList();
        String sql = "SELECT * FROM summary_salary WHERE ss_paid_status = ? AND ss_date BETWEEN ? AND ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setString(2, begin);
            stmt.setString(3, end);
            
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
     public ArrayList<SummarySalary> getByDate(String begin, String end) {
        ArrayList<SummarySalary> summaryList = new ArrayList();
        String sql = "SELECT * FROM summary_salary WHERE ss_date BETWEEN ? AND ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, begin);
            stmt.setString(2, end);
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

    public ArrayList<SummarySalary> getAllSummarySalarysByCondition(String condition) {
        ArrayList<SummarySalary> summaryList = new ArrayList();
        String sql = "SELECT summary_salary.ss_id ,summary_salary.ss_date,summary_salary.ss_work_hour,summary_salary.ss_salary,employee.employee_id FROM summary_salary JOIN check_in_out ON check_in_out.ss_id = summary_salary.ss_id JOIN employee on employee.employee_id = check_in_out.employee_id  WHERE  " + condition+"GROUP BY summary_salary.ss_id ORDER BY ss_id DESC";
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
