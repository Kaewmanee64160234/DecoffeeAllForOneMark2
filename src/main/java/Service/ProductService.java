/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.ProductDao;
import Model.Product;
import java.util.ArrayList;

/**
 *
 * @author Chaiwat
 */
public class ProductService {
    private ProductDao productDao = new ProductDao();

    public ArrayList<Product> getProductsOrderByName() {
        return (ArrayList<Product>) productDao.getAll("product_name ASC");
    }
    
    public Product getById(int id) {
        return productDao.get(id);
    }

    public Product addNew(Product editedProduct) {
        return productDao.save(editedProduct);
    }

    public Product update(Product editedProduct) {
        return productDao.update(editedProduct);
    }

    public int delete(Product editedProduct) {
        return productDao.delete(editedProduct);
    }
}
