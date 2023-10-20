/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.UserDao;
import Model.Employee;
import Model.User;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class UserService {
    static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }    
    
      public User login(String login, String password) {
        UserDao userDao = new UserDao();
        EmployeeService employeeService = new EmployeeService();
        User user = userDao.getByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            Employee employee = employeeService.getById(user.getEmployee_id());
            employeeService.setEditedEmployee(employee);
            
            return user;
        }
        return null;
    }
      
      public List<User>getUsers() {
        UserDao userDao = new UserDao();
        return userDao.getAll(" user_login asc");  
    }

    public User addNew(User editedUser) {
        UserDao userDao = new UserDao();
        return userDao.save(editedUser);
    }

    public User update(User editedUser) {
        UserDao userDao = new UserDao();
        return userDao.update(editedUser);
    }

    public int delete(User editedUser) {
        UserDao userDao = new UserDao();
        return userDao.delete(editedUser);
    }

}
