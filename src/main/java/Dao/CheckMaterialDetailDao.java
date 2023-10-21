package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.CheckMaterialDetail;
import helper.DatabaseHelper;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckMaterialDetailDao implements Dao<CheckMaterialDetail> {

    @Override
    public CheckMaterialDetail get(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM check_material_detail WHERE cmd_id = ?";
        CheckMaterialDetail checkMaterialDetail = new CheckMaterialDetail();
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                checkMaterialDetail = CheckMaterialDetail.fromRS(rs);
            }
            return checkMaterialDetail;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<CheckMaterialDetail> getAll() {
        ArrayList<CheckMaterialDetail> list = new ArrayList();
        String sql = "SELECT * FROM check_material_detail";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckMaterialDetail checkMaterialDetail = CheckMaterialDetail.fromRS(rs);
                list.add(checkMaterialDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<CheckMaterialDetail> getAll(String where, String order) {
        ArrayList<CheckMaterialDetail> list = new ArrayList();
        String sql = "SELECT * FROM check_material_detail where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckMaterialDetail checkMaterialDetail = CheckMaterialDetail.fromRS(rs);
                list.add(checkMaterialDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<CheckMaterialDetail> getAll(String order) {
        ArrayList<CheckMaterialDetail> list = new ArrayList();
        String sql = "SELECT * FROM check_material_detail  ORDER BY " + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckMaterialDetail checkMaterialDetail = CheckMaterialDetail.fromRS(rs);
                list.add(checkMaterialDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public CheckMaterialDetail save(CheckMaterialDetail obj) {
        CheckMaterialDetail checkMaterialDetail = new CheckMaterialDetail();
        String sql = "INSERT INTO check_material_detail (cmd_name, cmd_qty_last, cmd_qty_remain, mat_id, check_mat_id) VALUES (?, ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getLastQty());
            stmt.setInt(3, obj.getQty());
            stmt.setInt(4, obj.getMaterialId());
            stmt.setInt(5, obj.getCheckMaterialId());
            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                checkMaterialDetail = this.get(rs.getInt(1));
            }
            int ret = stmt.executeUpdate();
            System.out.println(ret);
            return obj;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public CheckMaterialDetail update(CheckMaterialDetail obj) {
        // TODO Auto-generated method stubs
        String sql = "UPDATE check_material_detail SET cmd_name = ?, cmd_qty_last = ?, cmd_qty_remain = ?, mat_id = ?, check_mat_id = ? WHERE cmd_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getLastQty());
            stmt.setInt(3, obj.getQty());
            stmt.setInt(4, obj.getMaterialId());
            stmt.setInt(5, obj.getCheckMaterialId());
            stmt.setInt(6, obj.getId());

            int ret = stmt.executeUpdate();
            System.out.println(ret);
            return obj;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public int delete(CheckMaterialDetail obj) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM check_material_detail WHERE cmd_id = ?";
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

}
