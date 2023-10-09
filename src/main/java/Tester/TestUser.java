/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tester;

import Dao.UserDao;
import Model.User;
import java.util.List;

/**
 *
 * @author USER
 */
public class TestUser {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
//        User new_user = new User("Kaewmanee", "Pass1234", "pim123", "user", 1);
//        userDao.save(new_user);
        
        for (User user : userDao.getAll()) {
            System.out.println(user.toString());
            
        }
        
    }
    
}
