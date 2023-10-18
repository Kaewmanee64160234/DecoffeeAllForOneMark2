/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;




import Dao.BillDao;
import Model.Bill;
import java.util.List;

/**
 *
 * @author werapan
 */
public class BillService {

    public Bill getById(int id) {
        BillDao materialDao = new BillDao();
        return materialDao.get(id);
    }

    public List<Bill> getBills(){
        BillDao materialDao = new BillDao();
        return materialDao.getAll(" bill_id asc");
    }

    public Bill addNew(Bill editedBill) {
        BillDao materialDao = new BillDao();
        return materialDao.save(editedBill);
    }

    public Bill update(Bill editedBill) {
        BillDao materialDao = new BillDao();
        return materialDao.update(editedBill);
    } 

    public int delete(Bill editedBill) {
        BillDao materialDao = new BillDao();
        return materialDao.delete(editedBill);
    }
}
