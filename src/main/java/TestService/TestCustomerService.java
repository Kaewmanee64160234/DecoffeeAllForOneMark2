/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import Model.Customer;
import Service.CustomerService;
import Service.ValidateException;

/**
 *
 * @author Lenovo
 */
public class TestCustomerService {

    public static void main(String[] args) throws ValidateException {
        CustomerService cs = new CustomerService();
        for (Customer customer : cs.getCustomers()) {
            System.out.println(customer);
        }
        System.out.println(cs.getByTel("0856681796"));

        Customer cus1 = new Customer("kob", "0863398888", 20);
        cs.addNew(cus1);
        for (Customer customer : cs.getCustomers()) {
            System.out.println(customer);
        }
        Customer delCus = cs.getByTel("0878825599");
        delCus.setTel("0878825590");
        cs.update(delCus);
        System.out.println("After Updated");
         for (Customer customer : cs.getCustomers()) {
            System.out.println(customer);
        }
        cs.delete(delCus);
        for (Customer customer : cs.getCustomers()) {
            System.out.println(customer);
        }
    }
}
