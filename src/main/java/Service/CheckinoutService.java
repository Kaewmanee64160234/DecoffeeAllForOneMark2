/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.CheckinoutDao;
import Model.Checkinout;
import Model.Employee;
import java.util.ArrayList;
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
        return checkinoutDao.getAll(" cio_id asc");
    }

    public List<Checkinout> getCheckinoutsByIdEmployee(int id) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        return checkinoutDao.getAllByIdEmployee(id);

    }

    public Checkinout addNew(Checkinout editedCheckinout) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        CheckMaterialDetailService checkMaterialDetailService = new CheckMaterialDetailService();

        return checkinoutDao.save(editedCheckinout);
    }

    public Checkinout update(Checkinout editedCheckinout) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        return checkinoutDao.update(editedCheckinout);
    }

    public int delete(Checkinout editedCheckinout) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        return checkinoutDao.delete(editedCheckinout);
    }

    public ArrayList<Checkinout> getAllCheckinsByEmpIdAndPaidStatus(int id, char paidStatus) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        ArrayList<Checkinout> checkins = (ArrayList<Checkinout>) checkinoutDao.getCheckInOutByPaidStatusAndEmpId(id,
                paidStatus);
        return checkins;
    }

    public ArrayList<Checkinout> getCheckInOutByEmpIdStatusNoAndTotalNotZero(int id) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        ArrayList<Checkinout> checkins = (ArrayList<Checkinout>) checkinoutDao
                .getCheckInOutByEmpIdStatusNoAndTotalNotZero(id);
        return checkins;

    }

    public ArrayList<Checkinout> getLastCheckInOut(int id) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        ArrayList<Checkinout> checkins = (ArrayList<Checkinout>) checkinoutDao.getLastCheckInOut(id);
        return checkins;

    }

    public ArrayList<Checkinout> getCheckInOutByPaidStatusAndEmpId(int id, String status) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        ArrayList<Checkinout> checkins = (ArrayList<Checkinout>) checkinoutDao.getCheckInOutByPaidStatusAndEmpId(id,
                status.charAt(0));
        return checkins;
    }

    public ArrayList<Checkinout> getCheckinoutsBySsId(int id) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        ArrayList<Checkinout> checkins = (ArrayList<Checkinout>) checkinoutDao.getCheckinoutsBySsId(id);
        return checkins;
    }

    public Checkinout getLestCio() {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        Checkinout checkinout = checkinoutDao.getLestCio();
        return checkinout;
    }

}
