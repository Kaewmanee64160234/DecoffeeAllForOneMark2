/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.ProductDao;
import Model.Product;
import Model.Size;
import Model.Sweet;
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
    private ArrayList<Size> sizes;
    private ArrayList<Sweet> sweets;

    public ProductService() {

        toppings = new ArrayList<Topping>();
        types = new ArrayList<Type>();
        sizes = new ArrayList<Size>();
        sweets = new ArrayList<Sweet>();

        toppings.add(new Topping("Cheese", 10));
        toppings.add(new Topping("Pearl", 10));
        toppings.add(new Topping("HoneyPearl", 10));
        toppings.add(new Topping("KonjacJelly ", 10));
        toppings.add(new Topping("FruitSalad", 10));

        types.add(new Type("Hot", 0));
        types.add(new Type("Cold", 10));
        types.add(new Type("Frappe", 10));

        sizes.add(new Size("S", 0));
        sizes.add(new Size("M", 10));
        sizes.add(new Size("L", 15));

        sweets.add(new Sweet("No", 0));
        sweets.add(new Sweet("Less", 0));
        sweets.add(new Sweet("Half", 0));
        sweets.add(new Sweet("Normal", 0));
        sweets.add(new Sweet("More", 10));

    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public ArrayList<Sweet> getSweets() {
        return sweets;
    }

    public void setSweets(ArrayList<Sweet> sweets) {
        this.sweets = sweets;
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

    public ArrayList<Size> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<Size> sizes) {
        this.sizes = sizes;
    }

    public ArrayList<Product> getProductsOrderByName() {
        return (ArrayList<Product>) productDao.getAll("product_name ASC");
    }

    public ArrayList<Product> getProductsByCatId(int id) {
        return (ArrayList<Product>) productDao.getByCatId(id);
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
