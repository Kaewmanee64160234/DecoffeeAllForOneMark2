/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Employee;
import Model.EmployeeReport;
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
 * @author Lenovo
 */
public class EmployeeDao implements Dao<Employee> {

    @Override
    public Employee get(int id) {
        Employee employee = null;
        String sql = "SELECT * FROM employee WHERE employee_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                employee = Employee.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employee;
    }

    public Employee getById(int id) {
        Employee employee = null;
        String sql = "SELECT * FROM employee WHERE employee_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                employee = Employee.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employee;
    }

    public Employee getByTel(String tel) {
        Employee employee = null;
        String sql = "SELECT * FROM employee WHERE employee_tel=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tel);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                employee = Employee.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employee;
    }

    public Employee getEmployeebyUserId(int id) {
        Employee employee = null;
        String sql = "SELECT * FROM employee WHERE user_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                employee = Employee.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employee;

    }

    @Override
    public List<Employee> getAll() {
        ArrayList<Employee> list = new ArrayList();
        String sql = "SELECT * FROM employee";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee employee = Employee.fromRS(rs);
                list.add(employee);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<Employee> getAll(String where, String order) {
        ArrayList<Employee> list = new ArrayList();
        String sql = "SELECT * FROM employee where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee employee = Employee.fromRS(rs);
                list.add(employee);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Employee> getAll(String order) {
        ArrayList<Employee> list = new ArrayList();
        String sql = "SELECT * FROM employee  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee employee = Employee.fromRS(rs);
                list.add(employee);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<EmployeeReport> getEmployeeByTotalHour(String begin, String end, int limit) {
        ArrayList<EmployeeReport> list = new ArrayList();
        String sql = """
                SELECT emp.employee_id,
                       emp.employee_name,
                       strftime('%m-%Y', cio.cio_date) AS MonthYear,
                       sum(cio.cio_total_hour) AS TopEmployee
                  FROM employee emp
                       NATURAL JOIN
                       check_in_out cio
                WHERE cio.cio_date BETWEEN ? AND ?
                 GROUP BY emp.employee_id
                 ORDER BY TopEmployee DESC
                 LIMIT ?;
                                         """;

        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, begin);
            stmt.setString(2, end);
            stmt.setInt(3, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EmployeeReport obj = EmployeeReport.fromRS(rs);
                list.add(obj);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Employee save(Employee obj) {

        String sql = "INSERT INTO employee (employee_name, employee_address, employee_tel, employee_email, employee_position, employee_hourly_wage)"
                + "VALUES(?,?,?,?,?,?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getAddress());
            stmt.setString(3, obj.getTelephone());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getPosition());
            stmt.setInt(6, obj.getHourlyWage());
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
    public Employee update(Employee obj) {
        String sql = "UPDATE employee"
                + " SET employee_name = ?, employee_address = ?, employee_tel = ?, employee_email = ?, employee_position = ?, employee_hourly_wage = ?"
                + " WHERE employee_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getAddress());
            stmt.setString(3, obj.getTelephone());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getPosition());
            stmt.setInt(6, obj.getHourlyWage());
            stmt.setInt(7, obj.getId());
            int ret = stmt.executeUpdate();
            System.out.println(ret);
            return obj;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int delete(Employee obj) {
        String sql = "DELETE FROM employee WHERE employee_id=?";
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

    public ArrayList<String> getNameEmployees() {
        ArrayList<String> list = new ArrayList();
        String sql = "SELECT employee_name FROM employee";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("employee_name");
                list.add(name);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;

    }
}
