/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import Dao.CheckinoutDao;
import Model.Checkinout;


/**
 *
 * @author user
 */
public class TestCheckinout {
    public static void main(String[] args) {
        CheckinoutDao ck = new CheckinoutDao();

        Checkinout cnk = ck.get(1);
        System.out.println(cnk.toString());
        
//        Material mat1 = new Material(9, "cake", 7, "Kg", 70);
//        md.save(mat1);
//        for(Material material:md.getAll()){
//            System.out.println(material);
//        }
    }
}
