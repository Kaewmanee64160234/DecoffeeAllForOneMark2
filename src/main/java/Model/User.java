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
 * @author USER
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String login;
    private String role;
    private int employee_id;

    public User(int id, String username, String password, String login, String role, int employee_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.login = login;
        this.role = role;
        this.employee_id = employee_id;
    }

    public User(String username, String password, String login, String role, int employee_id) {
        this.id = -1;
        this.username = username;
        this.password = password;
        this.login = login;
        this.role = role;
        this.employee_id = employee_id;
    }

    public User() {
        this.id = -1;
        this.username = "";
        this.password = "";
        this.login = "";
        this.role = "";
        this.employee_id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", login=" + login + ", role=" + role + ", employee_id=" + employee_id + '}';
    }
    public static User fromRS(ResultSet rs) {
        User user = new User();
        try {
          user.setId(rs.getInt("user_id"));
            user.setUsername(rs.getString("user_name"));
            user.setPassword(rs.getString("user_password"));
            user.setLogin(rs.getString("user_login"));
            user.setRole(rs.getString("user_role"));
            user.setEmployee_id(rs.getInt("employee_id"));
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return user;
    }
    
    
    
    
    
}
