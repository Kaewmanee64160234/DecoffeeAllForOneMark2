/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.MaterialDao;
import Model.Material;
import Model.MaterialReport;
import helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author werapan
 */
public class MaterialService {

    static Material currentMaterial;

    public static Material getCurrenMaterial() {
        return currentMaterial;
    }

    public Material getById(int id) {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.get(id);
    }

    public List<MaterialReport> getMaterialByMinQty() {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.getMaterialByMinQty();
    }

    public List<Material> getMaterials() {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.getAll(" mat_id asc");
    }

    public Material addNew(Material editedMaterial) {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.save(editedMaterial);
    }

    public Material update(Material editedMaterial) {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.update(editedMaterial);
    }

    public int delete(Material editedMaterial) {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.delete(editedMaterial);
    }

    public Material getMaterialByName(String name) {
        String sql = "SELECT * FROM material WHERE mat_name = ?";
        Connection conn = DatabaseHelper.getConnect();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Material.fromRS(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    public ArrayList<Material> getMaterialByMinQtyReport() {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.getMaterialByMinQtyReport();
    }
       
}
