package Dao;

import Model.CheckMaterial;
import helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckMaterialDao implements Dao<CheckMaterial> {

    @Override
    public CheckMaterial get(int id) {
        CheckMaterial checkMaterial = null;
        String sql = "SELECT * FROM check_material WHERE check_mat_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                checkMaterial = CheckMaterial.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return checkMaterial;
    }

    public ArrayList<CheckMaterial> getAll() {
        ArrayList<CheckMaterial> list = new ArrayList();
        String sql = "SELECT * FROM check_material";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckMaterial checkMaterial = CheckMaterial.fromRS(rs);
                list.add(checkMaterial);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<CheckMaterial> getAll(String where, String order) {
        ArrayList<CheckMaterial> list = new ArrayList();
        String sql = "SELECT * FROM check_material where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckMaterial checkMaterial = CheckMaterial.fromRS(rs);
                list.add(checkMaterial);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<CheckMaterial> getAll(String order) {
        ArrayList<CheckMaterial> list = new ArrayList();
        String sql = "SELECT * FROM check_material  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckMaterial checkMaterial = CheckMaterial.fromRS(rs);
                list.add(checkMaterial);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public CheckMaterial save(CheckMaterial obj) {
        String sql = "INSERT INTO check_material (employee_id)"
                + " VALUES (?)";

        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getEmployeeId());
            stmt.executeUpdate();
            int id = DatabaseHelper.getInsertedId(stmt);
            obj.setId(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    public CheckMaterial getById(int id) {
        CheckMaterial checkMaterial = null;
        String sql = "SELECT * FROM check_material WHERE check_mat_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                checkMaterial = CheckMaterial.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return checkMaterial;
    }

    public CheckMaterial getByDate(Date date) {
        CheckMaterial checkMaterial = null;
        String sql = "SELECT * FROM check_material WHERE check_mat_datetime=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, (java.sql.Date) date);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                checkMaterial = CheckMaterial.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return checkMaterial;
    }

    public List<CheckMaterial> getDateBetween(String begin, String end) {
        ArrayList<CheckMaterial> list = new ArrayList();
        String sql = """
                    SELECT *
                         FROM check_material cm
                        WHERE cm.check_mat_datetime BETWEEN ? AND ?
                        GROUP BY cm.check_mat_id;
                              """;
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, begin);
            stmt.setString(2, end);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CheckMaterial ar = CheckMaterial.fromRS(rs);
                list.add(ar);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public CheckMaterial update(CheckMaterial obj) {
        String sql = "UPDATE check_material"
                + " SET employee_id = ?"
                + " WHERE check_mat_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getEmployeeId());
            stmt.setInt(2, obj.getId());
            int ret = stmt.executeUpdate();
            System.out.println(ret);
            return obj;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int delete(CheckMaterial obj) {
        String sql = "DELETE FROM check_material WHERE check_mat_id=?";
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

    public List<CheckMaterial> getAllByIdEmployee(int id) {
        ArrayList<CheckMaterial> list = new ArrayList();
        String sql = "SELECT * FROM check_material where employee_id = ? ORDER BY check_mat_datetime ASC";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CheckMaterial checkMaterial = CheckMaterial.fromRS(rs);
                list.add(checkMaterial);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return list;
    }

}
