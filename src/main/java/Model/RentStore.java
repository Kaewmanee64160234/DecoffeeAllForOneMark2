/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class RentStore {

    private int id;
    private float rentWater;
    private float rentElectic;
    private float rentTotal;
    private String rentPaidStatus;
    private int storeId;

    public RentStore(int id, float rentWater, float rentElectic, float rentTotal, String rentPaidStatus, int storeId) {
        this.id = id;
        this.rentWater = rentWater;
        this.rentElectic = rentElectic;
        this.rentTotal = rentTotal;
        this.rentPaidStatus = rentPaidStatus;
        this.storeId= storeId;
    }
     public RentStore(float rentWater, float rentElectic, float rentTotal, String rentPaidStatus, int storeId) {
        this.id = -1;
        this.rentWater = rentWater;
        this.rentElectic = rentElectic;
        this.rentTotal = rentTotal;
        this.rentPaidStatus = rentPaidStatus;
        this.storeId= storeId;
    }
     public RentStore() {
        this.id = -1;
        this.rentWater = 0;
        this.rentElectic = 0;
        this.rentTotal = 0;
        this.rentPaidStatus = "";
        this.storeId= -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRentWater() {
        return rentWater;
    }

    public void setRentWater(float rentWater) {
        this.rentWater = rentWater;
    }

    public float getRentElectic() {
        return rentElectic;
    }

    public void setRentElectic(float rentElectic) {
        this.rentElectic = rentElectic;
    }

    public float getRentTotal() {
        return rentTotal;
    }

    public void setRentTotal(float rentTotal) {
        this.rentTotal = rentTotal;
    }

    public String getRentPaidStatus() {
        return rentPaidStatus;
    }

    public void setRentPaidStatus(String rentPaidStatus) {
        this.rentPaidStatus = rentPaidStatus;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "RentStore{" + "id=" + id + ", rentWater=" + rentWater + ", rentElectic=" + rentElectic + ", rentTotal=" + rentTotal + ", rentPaidStatus=" + rentPaidStatus + ", storeId=" + storeId + '}';
    }

    
    
    public static RentStore fromRS(ResultSet rs) {
        RentStore rentStore = new RentStore();
        try {
            rentStore.setId(rs.getInt("rent_store_id"));
            rentStore.setRentWater(rs.getFloat("rent_water"));
            rentStore.setRentElectic(rs.getFloat("rent_electric"));
            rentStore.setRentTotal(rs.getFloat("rent_total"));
            rentStore.setRentPaidStatus(rs.getString("rent_paid_status"));
            rentStore.setStoreId(rs.getInt("store_id"));
        } catch (SQLException ex) { 
            Logger.getLogger(RentStore.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return rentStore;
    }
}
