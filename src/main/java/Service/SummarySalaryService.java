/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;

import Dao.CheckinoutDao;
import Dao.RecieptDao;
import Dao.SummarySalaryDao;
import Model.Checkinout;
import Model.Reciept;
import Model.RecieptDetail;
import Model.SummarySalary;

/**
 *
 * @author USER
 */
public class SummarySalaryService {
    ArrayList<Checkinout> checkins;
    SummarySalary summarySalary;

    public SummarySalary getById(int id) {
        SummarySalaryService summarySalaryService = new SummarySalaryService();
        SummarySalary summarySalary = summarySalaryService.getById(id);
        return summarySalary;
    }

    public SummarySalary addNewSalary(int empId, SummarySalary summarySalary) {
        SummarySalaryDao summarySalaryDao = new SummarySalaryDao();
        CheckinoutDao checkinoutDao = new CheckinoutDao();

        SummarySalary new_sum = summarySalaryDao.save(summarySalary);
        int id = new_sum.getId();
        for (Checkinout object : checkinoutDao.getCheckInOutByPaidStatusAndEmpId(empId, 'N')) {
            object.setSsId(id);
            checkinoutDao.update(object);

        }
        return new_sum;

    }

    public SummarySalary update(SummarySalary editedSummarySalary) {
        SummarySalaryDao SummarySalaryDao = new SummarySalaryDao();
        return SummarySalaryDao.update(editedSummarySalary);
    }

    public int delete(SummarySalary editedSummarySalary) {
        SummarySalaryDao SummarySalaryDao = new SummarySalaryDao();
        return SummarySalaryDao.delete(editedSummarySalary);
    }

    public ArrayList<Checkinout> getAllCheckinsByEmpId(int id) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        ArrayList<Checkinout> checkins = (ArrayList<Checkinout>) checkinoutDao.getAllByIdEmployee(id);
        return checkins;
       
    }

    public ArrayList<Checkinout> getAllCheckinsByEmpIdAndPaidStatus(int id, char paidStatus) {
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        ArrayList<Checkinout> checkins = (ArrayList<Checkinout>) checkinoutDao.getCheckInOutByPaidStatusAndEmpId(id, paidStatus);
        return checkins;
    }

}
