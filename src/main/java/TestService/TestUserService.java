/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import Dao.UserDao;
import Model.User;

/**
 *
 * @author toey
 */
public class TestUserService {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        for (User u : userDao.getAll()) {
            System.out.println(u);
        }
        
//        User user1 = new User("Toey", "pass123", "toey", "User", 1);
//        userDao.save(user1);
//        for (User u : userDao.getAll()) {
//            System.out.println(u);
//        }
//        
//        User editedUser = userDao.getByLogin("toey");
//        editedUser.setPassword("Pass1234");
//        userDao.update(editedUser);
//        for (User u : userDao.getAll()) {
//            System.out.println(u);
//        }
//        
//        userDao.delete(editedUser);
    }
    
    
}
