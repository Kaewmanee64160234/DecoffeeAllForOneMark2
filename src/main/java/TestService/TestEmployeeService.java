/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import Model.Employee;
import Service.EmployeeService;

/**
 *
 * @author Lenovo
 */
public class TestEmployeeService {

    public static void main(String[] args) {
        EmployeeService cs = new EmployeeService();
        for (Employee employee : cs.getEmployees()) {
            System.out.println(employee);
        }
        System.out.println(cs.getByTel("0856681796"));

        Employee emp1 = new Employee("PP", "Yala", "0925687459", "PP@gmail.com", "cleaner", 60, 1);
        cs.addNew(emp1);
        for (Employee employee : cs.getEmployees()) {
            System.out.println(employee);
        }
//        Employee delEmp = cs.getByTel("0925687459");
//        delEmp.setTelephone("0878825590");
//        cs.update(delEmp);
//        System.out.println("After Updated");
//         for (Employee employee : cs.getEmployees()) {
//            System.out.println(employee);
//        }
//        cs.delete(delEmp);
//        for (Employee employee : cs.getEmployees()) {
//            System.out.println(employee);
//        }
    }
}
