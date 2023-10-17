/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.CheckinoutDao;
import Model.Checkinout;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class CheckinoutService {

    
    public Checkinout getById(int id) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        Checkinout checkinout = checkinoutDao.get(id);
        return checkinout;
    }
    
    public Checkinout getByDate(Date date) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        Checkinout checkinout = checkinoutDao.getByDate(date);
        return checkinout;
    }

    public List<Checkinout> getCheckinouts() {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        return checkinoutDao.getAll(" checkinout_id asc");
    }
    
    public Checkinout addNew(Checkinout editedCheckinout) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        return checkinoutDao.save(editedCheckinout);
    }

    public Checkinout update(Checkinout editedCheckinout) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        return checkinoutDao.update(editedCheckinout);
    }
}
