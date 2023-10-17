/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;


import Dao.MaterialDao;
import Model.Material;
import java.util.List;

/**
 *
 * @author werapan
 */
public class MaterialService {
    static Material currentMaterial;

    public static Material getCurrenMaterial() {
        return currentMaterial;
    } 
    public Material getById(int id) {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.get(id);
    }
    
    public List<Material> getMaterials(){
        MaterialDao materialDao = new MaterialDao();
        return materialDao.getAll(" mat_id asc");
    }

    public Material addNew(Material editedMaterial) {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.save(editedMaterial);
    }

    public Material update(Material editedMaterial) {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.update(editedMaterial);
    } 

    public int delete(Material editedMaterial) {
        MaterialDao materialDao = new MaterialDao();
        return materialDao.delete(editedMaterial);
    }
}
