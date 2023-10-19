/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import Dao.RecieptDao;
import Model.Product;
import Model.Reciept;
import Model.RecieptDetail;
import Model.Topping;
import Service.ProductService;
import Service.RecieptService;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class TestRecieptService {

    public static void main(String[] args) {
        RecieptService recieptService = new RecieptService();
        ProductService productService = new ProductService();
        RecieptDao recieptDao = new RecieptDao();
        Reciept reciept = new Reciept(1, "Promppay", 1, 4, 1,0);
//
//
//        Product product1 = productService.getById(1);
//        Product product2 = productService.getById(3);
//        reciept.addReceiptDetail(product1, 2, "M", "C", "Cheese", 19, 0, 0);
//        reciept.addReceiptDetail(product2, 1, "M", "C", "Cheese", 19, 0, 0);
//        
//        recieptService.addNew(reciept);
//        
        for (Reciept re : recieptDao.getAll(" reciept_id asc")) {
           System.out.println(re.toString());

       }
       

    }

}
