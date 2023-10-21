/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;



import Dao.RentStoreDao;
import Model.RentStore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author werapan
 */
public class RentStoreService {
    static RentStore currentRentStore;

    public static RentStore getCurrenRentStore() {
        return currentRentStore;
    } 
    public RentStore getByStore(int store) {
        RentStoreDao rentStoreDao = new RentStoreDao();
        return rentStoreDao.getByStore(store);
    }
    public ArrayList<RentStore> getByDate(String begin, String end) {
        RentStoreDao rentStoreDao = new RentStoreDao();
        return rentStoreDao.getByDate(begin, end);
    }
   public ArrayList<RentStore> getByPaidStatus(String status) {
        RentStoreDao rentStoreDao = new RentStoreDao();
        return rentStoreDao.getByPaidStatus(status);
    }

    
    public List<RentStore> getRentStores(){
        RentStoreDao rentStoreDao = new RentStoreDao();
        return rentStoreDao.getAll(" rent_store_id asc");
    }

    public RentStore addNew(RentStore editedRentStore) {
        RentStoreDao rentStoreDao = new RentStoreDao();
        return rentStoreDao.save(editedRentStore);
    }

    public RentStore update(RentStore editedRentStore) {
        RentStoreDao rentStoreDao = new RentStoreDao();
        return rentStoreDao.update(editedRentStore);
    } 

    public int delete(RentStore editedRentStore) {
        RentStoreDao rentStoreDao = new RentStoreDao();
        return rentStoreDao.delete(editedRentStore);
    }

    


}
