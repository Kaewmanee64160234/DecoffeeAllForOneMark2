/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.BillDao;
import Model.Bill;
import Model.HistoryMaterialReport;
import java.util.List;

/**
 *
 * @author werapan
 */
public class BillService {

    public Bill getById(int id) {
        BillDao billDao = new BillDao();
        return billDao.get(id);
    }

    public List<Bill> getBills() {
        BillDao billDao = new BillDao();
        return billDao.getAll(" bill_id asc");
    }
    
      public List<HistoryMaterialReport> getBillHistory() {
        BillDao billDao = new BillDao();
        return billDao.getBillHistory();
    }
    

    public List<HistoryMaterialReport> getBillHistory(String begin, String end) {
        BillDao billDao = new BillDao();
        return billDao.getBillHistory(begin, end);
    }

    public Bill addNew(Bill editedBill){
//        if(!editedBill.isValid()){
//            throw new ValidateException("Bill is invalid!!!");
//        }
        BillDao billDao = new BillDao();
        return billDao.save(editedBill);
    }

    public Bill update(Bill editedBill) {
        BillDao billDao = new BillDao();
        return billDao.update(editedBill);
    }

    public int delete(Bill editedBill) {
        BillDao billDao = new BillDao();
        return billDao.delete(editedBill);
    }
}
