package Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Dao.CheckMaterialDetailDao;
import Model.CheckMaterialDetail;
import Model.CheckMaterialDetail;

public class CheckMaterialDetailService {

    public CheckMaterialDetail getById(int id) {
        CheckMaterialDetailDao CheckMaterialDetailDao = new CheckMaterialDetailDao();
        CheckMaterialDetail CheckMaterialDetail = CheckMaterialDetailDao.get(id);
        return CheckMaterialDetail;
    }

    public CheckMaterialDetail addNew(CheckMaterialDetail editedCheckMaterialDetail) {
        CheckMaterialDetailDao CheckMaterialDetailDao = new CheckMaterialDetailDao();
        return CheckMaterialDetailDao.save(editedCheckMaterialDetail);
    }

    public CheckMaterialDetail update(CheckMaterialDetail editedCheckMaterialDetail) {
        CheckMaterialDetailDao CheckMaterialDetailDao = new CheckMaterialDetailDao();
        return CheckMaterialDetailDao.update(editedCheckMaterialDetail);
    }

    public int delete(CheckMaterialDetail editedCheckMaterialDetail) {
        CheckMaterialDetailDao CheckMaterialDetailDao = new CheckMaterialDetailDao();
        return CheckMaterialDetailDao.delete(editedCheckMaterialDetail);
    }

}
