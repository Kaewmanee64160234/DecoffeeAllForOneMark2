/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.CustomerDao;
import Model.Customer;
import Model.CustomerReport;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class CustomerService {

    public Customer getByTel(String tel) {
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getByTel(tel);
        return customer;
    }
    
    public List<CustomerReport> getTopFiveCustomerByTotalPrice() {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.getCustomerByTotalPrice(5);
    }
    
    public List<Customer> getCustomers() {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.getAll(" customer_id asc");
    }

    public Customer addNew(Customer editedCustomer) throws ValidateException {
        if(!editedCustomer.isValid()){
            throw new ValidateException("Customer is invalid!!!");
        }
        CustomerDao customerDao = new CustomerDao();
        return customerDao.save(editedCustomer);
    }

    public Customer update(Customer editedCustomer) throws ValidateException{
         if(!editedCustomer.isValid()){
            throw new ValidateException("Customer is invalid!!!");
        }
        CustomerDao customerDao = new CustomerDao();
        return customerDao.update(editedCustomer);
    }

    public int delete(Customer editedCustomer) {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.delete(editedCustomer);
    }
}
