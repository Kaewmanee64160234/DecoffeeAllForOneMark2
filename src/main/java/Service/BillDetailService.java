/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;




import Dao.BillDetailDao;
import Model.Bill;
import Model.BillDetail;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author werapan
 */
public class BillDetailService {

    public BillDetail getById(int id) {
        BillDetailDao billDetailDao = new BillDetailDao();
        return billDetailDao.get(id);
    }

    public List<BillDetail> getBills(){
        BillDetailDao billDetailDao = new BillDetailDao();
        return billDetailDao.getAll(" bill_detail_id asc");
    }

     public List<BillDetail> getBillDetailForDate(String date){
       BillDetailDao billDetailDao = new BillDetailDao();
       return billDetailDao.getBillDetailForDate(date);
   }
     
    
    public BillDetail addNew(BillDetail editedBillDetail) {
//        if(!editedBillDetail.isValid()){
//            throw new ValidateException("BillDetail is invalid!!!");
//        }
        BillDetailDao billDetailDao = new BillDetailDao();
        return billDetailDao.save(editedBillDetail);
    }

    public BillDetail update(BillDetail editedBillDetail) {
        BillDetailDao billDetailDao = new BillDetailDao();
        return billDetailDao.update(editedBillDetail);
    } 

    public int delete(BillDetail editedBillDetail) {
        BillDetailDao billDetailDao = new BillDetailDao();
        return billDetailDao.delete(editedBillDetail);
    }
}
