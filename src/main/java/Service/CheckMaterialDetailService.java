package Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Dao.CheckMaterialDetailDao;
import Model.CheckMaterialDetail;
import Model.CheckMaterialDetail;

public class CheckMaterialDetailService {

    public CheckMaterialDetail getById(int id) {
        CheckMaterialDetailDao checkMaterialDetailDao = new CheckMaterialDetailDao();
        return checkMaterialDetailDao.get(id);
    }

    public List<CheckMaterialDetail> getCheckMaterialDetails() {
        CheckMaterialDetailDao checkMaterialDetailDao = new CheckMaterialDetailDao();
        return checkMaterialDetailDao.getAll(" cmd_id asc");
    }

    public CheckMaterialDetail addNew(CheckMaterialDetail editedCheckMaterialDetail) {
        CheckMaterialDetailDao checkMaterialDetailDao = new CheckMaterialDetailDao();
        return checkMaterialDetailDao.save(editedCheckMaterialDetail);
    }

    public CheckMaterialDetail update(CheckMaterialDetail editedCheckMaterialDetail) {
        CheckMaterialDetailDao checkMaterialDetailDao = new CheckMaterialDetailDao();
        return checkMaterialDetailDao.update(editedCheckMaterialDetail);
    }

    public int delete(CheckMaterialDetail editedCheckMaterialDetail) {
        CheckMaterialDetailDao checkMaterialDetailDao = new CheckMaterialDetailDao();
        return checkMaterialDetailDao.delete(editedCheckMaterialDetail);
    }

}
