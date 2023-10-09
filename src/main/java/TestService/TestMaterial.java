/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import Dao.MaterialDao;
import Model.Material;


/**
 *
 * @author user
 */
public class TestMaterial {
    public static void main(String[] args) {
        MaterialDao md = new MaterialDao();
        for(Material material:md.getAll()){
            System.out.println(material);
        }
        Material mat1 = new Material(9, "cake", 7, "Kg", 70);
        md.save(mat1);
        for(Material material:md.getAll()){
            System.out.println(material);
        }
    }
}
