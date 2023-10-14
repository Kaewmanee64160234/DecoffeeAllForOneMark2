/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import Model.Product;
import Service.ProductService;
import Service.ValidateException;

/**
 *
 * @author Chaiwat
 */
public class TestProductService {

    public static void main(String[] args) throws ValidateException {
        ProductService pd = new ProductService();
        for (Product product : pd.getProductsOrderByName()) {
            System.out.println(product);
        }
        Product pro1 = new Product("product1",40,"SML","0123","HC",1);
        pd.addNew(pro1);
        for (Product product : pd.getProductsOrderByName()) {
            System.out.println(product);
        }
        
        Product pro1up = pd.getById(4);
        pro1up.setPrice(45);
        pd.update(pro1up);
        System.out.println("After Updated");
         for (Product product : pd.getProductsOrderByName()) {
            System.out.println(product);
        }
         
        pd.delete(pro1up);
        System.out.println("After Delete");
        for (Product product : pd.getProductsOrderByName()) {
            System.out.println(product);
        }
    }
}
