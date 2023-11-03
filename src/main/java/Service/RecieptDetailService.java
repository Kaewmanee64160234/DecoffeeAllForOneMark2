package Service;

import java.util.List;
import Dao.RecieptDetailDao;
import Model.RecieptDetail;

public class RecieptDetailService {

    public RecieptDetail getById(int id) {
        RecieptDetailDao recieptDetailDao = new RecieptDetailDao();
        return recieptDetailDao.get(id);
    }

//         public List<RecieptDetail> getRecieptDetailForDate(String date){
//       RecieptDetailDao recieptDetailDao = new RecieptDetailDao();
//       return recieptDetailDao.getRecieptDetailForDate(date);
//   }
    
    public List<RecieptDetail> getRecieptDetails() {
        RecieptDetailDao recieptDetailDao = new RecieptDetailDao();
        return recieptDetailDao.getAll(" reciept_detail_id asc");
    }

    public RecieptDetail addNew(RecieptDetail editedRecieptDetail) {
        RecieptDetailDao recieptDetailDao = new RecieptDetailDao();
        return recieptDetailDao.save(editedRecieptDetail);
    }

    public RecieptDetail update(RecieptDetail editedRecieptDetail) {
        RecieptDetailDao recieptDetailDao = new RecieptDetailDao();
        return recieptDetailDao.update(editedRecieptDetail);
    }

    public int delete(RecieptDetail editedRecieptDetail) {
        RecieptDetailDao recieptDetailDao = new RecieptDetailDao();
        return recieptDetailDao.delete(editedRecieptDetail);
    }

}
