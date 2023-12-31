/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.CustomerDao;
import Dao.EmployeeDao;
import Dao.UserDao;
import Model.Customer;
import Model.Employee;

import Model.EmployeeReport;

import Model.User;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public class EmployeeService {

    private Employee editedEmployee;

    public Employee getById(int id) {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getById(id);
        return employee;
    }

    public Employee getByTel(String tel) {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getByTel(tel);
        return employee;
    }

    public List<Employee> getEmployees() {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getAll(" employee_id asc");
    }

    public Employee getEditedEmployee() {
        return editedEmployee;
    }

    public List<EmployeeReport> getEmployeeByTotalHour(String begin, String end) {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getEmployeeByTotalHour(begin, end, 5);
    }

    public void setEditedEmployee(Employee editedEmployee) {
        this.editedEmployee = editedEmployee;
        System.out.println("from service : " + editedEmployee.toString());
    }

    public Employee addNew(Employee editedEmployee) {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.save(editedEmployee);
    }

    public Employee update(Employee editedEmployee) {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.update(editedEmployee);
    }

    public int delete(Employee editedEmployee) {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.delete(editedEmployee);
    }

    public ArrayList<String> getNameEmployees() {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getNameEmployees();
    }
    public Employee getEmployeebyUserId(int id) {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getEmployeebyUserId(id);
    }
}
