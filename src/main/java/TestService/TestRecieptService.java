/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import Model.Product;
import Model.Reciept;
import Model.RecieptDetail;
import Service.ProductService;
import Service.RecieptService;

/**
 *
 * @author USER
 */
public class TestRecieptService {
    public static void main(String[] args) {
         RecieptService recieptService = new RecieptService();
    ProductService productService = new ProductService();
    Reciept reciept = new Reciept();    

    Product product1 = productService.getById(1);
    Product product2 = productService.getById(2);
    reciept.addReceiptDetail(product1, 2, "M", "C", "Cheese", 19, 0, 0);
    reciept.addReceiptDetail(product2, 1, "M", "C", "Cheese", 19, 0, 0);
    reciept.setCustomerId(1);
    reciept.setEmployeeId(1);
        
    }
   
    
    
}
