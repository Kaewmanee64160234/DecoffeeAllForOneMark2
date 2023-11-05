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
import java.sql.SQLException;
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
        String sql = "SELECT summary_salary.ss_id,\r\n"
                + //
                "       MIN(check_in_out.cio_date) as startDate,\r\n"
                + //
                "       MAX(check_in_out.cio_date) as endDate,\r\n"
                + //
                "       summary_salary.ss_work_hour as totalHour,\r\n"
                + //
                "       summary_salary.ss_salary as Salary\r\n"
                + //
                "FROM summary_salary\r\n"
                + //
                "LEFT JOIN check_in_out ON summary_salary.ss_id = check_in_out.ss_id\r\n"
                + //
                "WHERE summary_salary.ss_id = (\r\n"
                + //
                "  SELECT MAX(ss_id)\r\n"
                + //
                "  FROM summary_salary\r\n"
                + //
                ");\r\n"
                + //
                "";
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
        String sql = "SELECT summary_salary.ss_id ,summary_salary.ss_date,summary_salary.ss_work_hour,summary_salary.ss_salary,summary_salary.ss_paid_status,employee.employee_id FROM summary_salary JOIN check_in_out ON check_in_out.ss_id = summary_salary.ss_id JOIN employee on employee.employee_id = check_in_out.employee_id WHERE  "
                + condition + "GROUP BY summary_salary.ss_id ORDER BY summary_salary.ss_id DESC";
        System.out.println(sql);
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SummarySalary summary = SummarySalary.fromRSCondition(rs);
                summaryList.add(summary);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return summaryList;
    }

    public ArrayList<SummarySalary> getSummarySalaryByTotalPaid(String begin, String end) {
        ArrayList<SummarySalary> summaryList = new ArrayList();
        String sql = """
                SELECT   strftime('%m-%Y', ss.ss_date) AS MonthYear,
                          sum(ss.ss_salary) AS TotalPaid
                          FROM
                          summary_salary ss
                          WHERE
                          ss.ss_date BETWEEN ? AND ?
                          GROUP BY
                          MonthYear
                          ORDER BY
                          TotalPaid DESC;
                               """;
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, begin);
            stmt.setString(2, end);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SummarySalary summary = SummarySalary.fromRSReport(rs);
                summaryList.add(summary);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return summaryList;
    }

    public ArrayList<SummarySalary> getSummarySalaryForReport(String date) {
        ArrayList<SummarySalary> summaryList = new ArrayList();
        String sql = """
                     SELECT e.employee_name,
                       s.ss_date,
                       s.ss_salary
                FROM employee e
                JOIN check_in_out c ON e.employee_id = c.employee_id
                JOIN summary_salary s ON c.ss_id = s.ss_id
                WHERE strftime('%Y-%m', s.ss_date) = ?
                GROUP BY s.ss_id;

                                                                   """;
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SummarySalary summary = SummarySalary.fromRSReportPrint(rs);
                summaryList.add(summary);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return summaryList;

    }

    public SummarySalary getTotalSummarySalaryOneMonth(String date) {
        SummarySalary summary = new SummarySalary();
        String sql = "SELECT strftime('%m-%Y', ss.ss_date) AS MonthYear, "
                + "sum(ss.ss_salary) AS TotalPaid "
                + "FROM summary_salary ss "
                + "WHERE strftime('%m-%Y', ss.ss_date) = ? "
                + // Removed single quotes
                "GROUP BY MonthYear "
                + "ORDER BY TotalPaid DESC;";
        System.out.println(sql);
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, date); // Set the date parameter without single quotes
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                summary = SummarySalary.fromRSReport(rs);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return summary;
    }

}
