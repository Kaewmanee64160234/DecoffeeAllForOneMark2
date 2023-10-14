/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;

import Dao.RecieptDao;
import Dao.RecieptDetailDao;
import Model.Reciept;
import Model.RecieptDetail;

/**
 *
 * @author USER
 */
public class RecieptService{
    public Reciept getById(int id){
        RecieptDao recieptDao = new RecieptDao();
        Reciept reciept = recieptDao.get(id);
        return reciept;
    }
    public List<Reciept> getReciepts() {
        RecieptDao recieptDao = new RecieptDao();
        return recieptDao.getAll(" receipt_id asc");
    }

    public Reciept addNew(Reciept reciept) {
        RecieptDao recieptDao = new RecieptDao();
        RecieptDetailDao recieptDetailDao = new RecieptDetailDao();
        Reciept newReciept = recieptDao.save(reciept);
        for (RecieptDetail recieptDetail : reciept.getRecieptDetails()) {
            recieptDetail.setRecieptId(newReciept.getId());
            recieptDetailDao.save(recieptDetail);
        }
        return newReciept;
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
