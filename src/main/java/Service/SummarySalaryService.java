/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;

import Dao.CheckinoutDao;
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
    ArrayList<Checkinout> checkins ;
    SummarySalary summarySalary;

    public SummarySalary getById(int id) {
        SummarySalaryService summarySalaryService = new SummarySalaryService();
        SummarySalary summarySalary = summarySalaryService.getById(id);
        return summarySalary;
    }
    public SummarySalary addNewSalary(SummarySalary summarySalary) { 
        SummarySalaryDao summarySalaryDao = new SummarySalaryDao(); 
        CheckinoutDao checkinoutDao = new CheckinoutDao();

         SummarySalary new_sum = summarySalaryDao.save(summarySalary);
        int id = new_sum.getId();
        for (Checkinout object : checkinoutDao.getCheckInOutByPaidStatusAndEmpId( id, paidStatus)) {
            object.setRecieptId(id);
            recieptDetailDao.save(object);

        }
        return receipt;
        
    }

    
}
