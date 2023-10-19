/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class CheckMaterialDetail {

    private int id;
    private String name;
    private int lastQty;
    private int qty;
    private int materialId;
    private int checkMaterialId;

    public CheckMaterialDetail(int id, String name, int lastQty, int qty, int materialId, int checkMaterialId) {
        this.id = id;
        this.name = name;
        this.lastQty = lastQty;
        this.qty = qty;
        this.materialId = materialId;
        this.checkMaterialId = checkMaterialId;
    }

    public CheckMaterialDetail(String name, int lastQty, int qty, int materialId, int checkMaterialId) {
        this.id = -1;
        this.name = name;
        this.lastQty = lastQty;
        this.qty = qty;
        this.materialId = materialId;
        this.checkMaterialId = checkMaterialId;
    }

    public CheckMaterialDetail(String name, int lastQty, int qty, int materialId) {
        this.id = -1;

        this.name = name;
        this.lastQty = lastQty;
        this.qty = qty;
        this.materialId = materialId;
        this.checkMaterialId = -1;

    }

    public CheckMaterialDetail() {
        this.id = -1;
        this.name = "";
        this.lastQty = 0;
        this.qty = 0;
        this.materialId = -1;
        this.checkMaterialId = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLastQty() {
        return lastQty;
    }

    public void setLastQty(int lastQty) {
        this.lastQty = lastQty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getCheckMaterialId() {
        return checkMaterialId;
    }

    public void setCheckMaterialId(int checkMaterialId) {
        this.checkMaterialId = checkMaterialId;
    }

    @Override
    public String toString() {
        return "CheckMaterialDetail{" + "id=" + id + ", name=" + name + ", lastQty=" + lastQty + ", qty=" + qty
                + ", materialId=" + materialId + ", checkMaterialId=" + checkMaterialId + '}';
    }

    public static CheckMaterialDetail fromRS(ResultSet rs) {
        CheckMaterialDetail checkMaterialDetail = new CheckMaterialDetail();
        try {
            checkMaterialDetail.setId(rs.getInt("cmd_id"));
            checkMaterialDetail.setName(rs.getString("cmd_name"));
            checkMaterialDetail.setLastQty(rs.getInt("cmd_qty_last"));
            checkMaterialDetail.setQty(rs.getInt("cmd_qty_remain"));
            checkMaterialDetail.setMaterialId(rs.getInt("mat_id"));
            checkMaterialDetail.setCheckMaterialId(rs.getInt("check_mat_id"));
            return checkMaterialDetail;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return checkMaterialDetail;
    }

}
