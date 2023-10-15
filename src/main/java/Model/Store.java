/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class Store {
    private int id;
    private String name;
    private String address;
    private String tel;

    public Store(int id, String name, String address, String tel) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public Store(String name, String address, String tel) {
       this.id = -1;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public Store() {
        this.id = -1;
        this.name = "";
        this.address = "";
        this.tel = "";
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Store{" + "id=" + id + ", name=" + name + ", address=" + address + ", tel=" + tel + '}';
    }

    public static Store fromRs(ResultSet rs) {
        try {
            Store obj = new Store();
            obj.setId(rs.getInt("store_id"));
            obj.setName(rs.getString("store_name"));
            obj.setAddress(rs.getString("store_address"));
            obj.setTel(rs.getString("store_tel"));
            return obj;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    
    
    
    
}
