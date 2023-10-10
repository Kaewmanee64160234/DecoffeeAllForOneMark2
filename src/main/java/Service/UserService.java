/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.UserDao;
import Model.User;

/**
 *
 * @author USER
 */
public class UserService {
    
      public User login(String login, String password) {
        UserDao userDao = new UserDao();
        User user = userDao.getByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}
