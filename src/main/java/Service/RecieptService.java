/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;

import Dao.RecieptDao;
import Dao.RecieptDetailDao;
import Model.Reciept;
import Model.RecieptDetail;
import Model.Topping;

/**
 *
 * @author USER
 */
 
    

public class RecieptService{
    private ArrayList<Topping> toppings;

    public RecieptService() {
        toppings = new ArrayList<Topping>();

        toppings.add(new Topping("Cheese", 19));
        toppings.add(new Topping("Egg", 19));
        toppings.add(new Topping("Sausage", 19));
        toppings.add(new Topping("Bacon", 19));
        toppings.add(new Topping("Ham", 19));
        toppings.add(new Topping("Pineapple", 19));
    }

    public Reciept getById(int id){
        RecieptDao recieptDao = new RecieptDao();
        Reciept reciept = recieptDao.get(id);
        return reciept;
    }
    
    public List<Reciept> getReciepts() {
        RecieptDao recieptDao = new RecieptDao();
        return recieptDao.getAll(" receipt_id asc");
    }

    public Reciept addNew(Reciept editedReciept) {
        RecieptDao recieptDao = new RecieptDao();
        RecieptDetailDao recieptDetailDao = new RecieptDetailDao();
        
        Reciept receipt = recieptDao.save(editedReciept);
        int id = receipt.getId();
        for (RecieptDetail object : receipt.getRecieptDetails()) {
            object.setRecieptId(id);
            recieptDetailDao.save(object);

        }
        return receipt;
    }
    public Reciept update(Reciept editedReciept) {
        RecieptDao recieptDao = new RecieptDao();
        return recieptDao.update(editedReciept);
    }
    public int delete(Reciept editedReciept) {
        RecieptDao recieptDao = new RecieptDao();
        return recieptDao.delete(editedReciept);
    }
   
    
}