package Dao;

import Model.Promotion;
import helper.DatabaseHelper;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PromotionDao implements Dao<Promotion> {

    @Override
    public Promotion get(int id) {
        Promotion promotion = null;
        String sql = "SELECT * FROM promotion WHERE prom_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                promotion = Promotion.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return promotion;
    }

    public List<Promotion> getAll() {
        ArrayList<Promotion> list = new ArrayList();
        String sql = "SELECT * FROM promotion";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Promotion promotion = Promotion.fromRS(rs);
                list.add(promotion);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<Promotion> getAll(String where, String order) {
        ArrayList<Promotion> list = new ArrayList();
        String sql = "SELECT * FROM promotion where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Promotion promotion = Promotion.fromRS(rs);
                list.add(promotion);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Promotion> getAll(String order) {
        ArrayList<Promotion> list = new ArrayList();
        String sql = "SELECT * FROM promotion  ORDER BY " + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Promotion promotion = Promotion.fromRS(rs);
                list.add(promotion);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Promotion save(Promotion obj) {

        String sql = "INSERT INTO promotion (prom_end_date, "
                + "prom_name, "
                + "prom_discount, "
                + "prom_discount_perc, "
                + "prom_point_discount, "
                + "prom_used_point)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getEndDate());
            stmt.setString(2, obj.getName());
            stmt.setFloat(3, obj.getDiscount());
            stmt.setInt(4, obj.getDiscountPerc());
            stmt.setInt(5, obj.getPointDiscount());
            stmt.setInt(6, obj.getUsedPoint());
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
    public Promotion update(Promotion obj) {
        String sql = "UPDATE promotion"
                + " SET  prom_end_date = ?, "
                + "prom_name = ?, "
                + "prom_discount = ?, "
                + "prom_discount_perc = ?, "
                + "prom_point_discount = ?"
                + "prom_used_point = ?"
                + " WHERE prom_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getEndDate());
            stmt.setString(2, obj.getName());
            stmt.setFloat(3, obj.getDiscount());
            stmt.setInt(4, obj.getDiscountPerc());
            stmt.setInt(5, obj.getPointDiscount());
            stmt.setInt(6, obj.getUsedPoint());
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
    public int delete(Promotion obj) {
        String sql = "DELETE FROM promotion WHERE prom_id=?";
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
