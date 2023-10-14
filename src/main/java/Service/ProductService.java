/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.ProductDao;
import Model.Product;
import Model.Topping;
import Model.Type;
import java.util.ArrayList;

/**
 *
 * @author Chaiwat
 */
public class ProductService {

    private ProductDao productDao = new ProductDao();
    private ArrayList<Topping> toppings;
    private ArrayList<Type> types;

    public ProductService() {

        toppings = new ArrayList<Topping>();
        types = new ArrayList<Type>();

        toppings.add(new Topping("Cheese", 10));
        toppings.add(new Topping("Pearl", 10));
        toppings.add(new Topping("HoneyPearl", 10));
        toppings.add(new Topping("KonjacJelly ", 10));
        toppings.add(new Topping("FruitSalad", 10));

        types.add(new Type("Hot", 0));
        types.add(new Type("Cold", 10));
        types.add(new Type("Frappe", 10));
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public ArrayList<Type> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Type> types) {
        this.types = types;
    }

    public ArrayList<Product> getProductsOrderByName() {
        return (ArrayList<Product>) productDao.getAll("product_name ASC");
    }

    public Product getById(int id) {
        return productDao.get(id);
    }

    public Product addNew(Product editedProduct) throws ValidateException {
        if (!editedProduct.isValid()) {
            throw new ValidateException("Product is invalid!!!");
        }
        return productDao.save(editedProduct);
    }

    public Product update(Product editedProduct) throws ValidateException {
        if (!editedProduct.isValid()) {
            throw new ValidateException("Product is invalid!!!");
        }
        return productDao.update(editedProduct);
    }

    public int delete(Product editedProduct) {
        return productDao.delete(editedProduct);
    }
}
