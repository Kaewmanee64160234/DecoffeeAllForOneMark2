
package Service;

import Dao.CheckMaterialDao;
import Model.CheckMaterial;
import Model.CheckMaterialDetail;
import java.util.Date;
import java.util.List;


public class CheckMaterialService {

    
    public CheckMaterial getById(int id) {
        CheckMaterialDao checkMaterialDao = new CheckMaterialDao();
        CheckMaterial checkMaterial = checkMaterialDao.get(id);
        return checkMaterial;
    }
    
    public CheckMaterial getByDate(Date date) {
        CheckMaterialDao checkMaterialDao = new CheckMaterialDao();
        CheckMaterial checkMaterial = checkMaterialDao.getByDate(date);
        return checkMaterial;
    }

    public List<CheckMaterial> getCheckMaterials() {
        CheckMaterialDao checkMaterialDao = new CheckMaterialDao();
        return checkMaterialDao.getAll(" check_mat_id asc");
    }
    public  List<CheckMaterial> getCheckMaterialsByIdEmployee(int id){
        CheckMaterialDao checkMaterialDao = new CheckMaterialDao();
        return checkMaterialDao.getAllByIdEmployee(id);
        
    }
    
    public CheckMaterial addNew(CheckMaterial editedCheckMaterial) {
        CheckMaterialDao checkMaterialDao = new CheckMaterialDao();
        CheckMaterialDetailService checkMaterialDetailService = new CheckMaterialDetailService();
        CheckMaterial new_cm = checkMaterialDao.save(editedCheckMaterial);
        for (CheckMaterialDetail object : editedCheckMaterial.getDetails()) {
            object.setCheckMaterialId(new_cm.getId());
            checkMaterialDetailService.addNew(object);
            
        }
        return checkMaterialDao.save(editedCheckMaterial);
    }

    public CheckMaterial update(CheckMaterial editedCheckMaterial) {
        CheckMaterialDao checkMaterialDao = new CheckMaterialDao();
        return checkMaterialDao.update(editedCheckMaterial);
    }
    public int delete(CheckMaterial editedCheckMaterial) {
        CheckMaterialDao checkMaterialDao = new CheckMaterialDao();
        return checkMaterialDao.delete(editedCheckMaterial);
    }
}

