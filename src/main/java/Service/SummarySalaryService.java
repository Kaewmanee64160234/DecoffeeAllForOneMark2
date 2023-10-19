/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;

import Dao.CheckinoutDao;
import Dao.EmployeeDao;
import Dao.RecieptDao;
import Dao.SummarySalaryDao;
import Model.Checkinout;
import Model.Employee;
import Model.Reciept;
import Model.RecieptDetail;
import Model.SummarySalary;
import Page.SalaryPanel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author USER
 */
public class SummarySalaryService {

    ArrayList<Checkinout> checkins;
    SummarySalary summarySalary;

    public SummarySalary getById(int id) {
        SummarySalaryDao summarySalaryDao = new SummarySalaryDao();
        SummarySalary summarySalary = summarySalaryDao.get(id);
        return summarySalary;
    }

    public ArrayList<SummarySalary> getAll() {
        SummarySalaryDao summarySalaryDao = new SummarySalaryDao();
        return (ArrayList<SummarySalary>) summarySalaryDao.getAll();
    }

    public SummarySalary addNewSalary(int empId, SummarySalary summarySalary) {
        SummarySalaryDao summarySalaryDao = new SummarySalaryDao();
        CheckinoutDao checkinoutDao = new CheckinoutDao();
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.get(empId);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date);
        summarySalary.setDate(formattedDate);
        SummarySalary new_sum = summarySalaryDao.save(summarySalary);
        System.out.println(new_sum.toString());
        int totalHour = 0;
        int id = new_sum.getId();
        for (Checkinout object : checkinoutDao.getCheckInOutByPaidStatusAndEmpIdForAddInSS(empId, 'N')) {
            object.setSsId(id);
            checkinoutDao.update(object);
            totalHour += object.getCioTotalHour();
        }
        new_sum.setTotalHour(totalHour);
        new_sum.setSalary(totalHour * employee.getHourlyWage());
        summarySalaryDao.update(new_sum);

        return new_sum;

    }

    public SummarySalary update(SummarySalary editedSummarySalary) {
        SummarySalaryDao SummarySalaryDao = new SummarySalaryDao();
        return SummarySalaryDao.update(editedSummarySalary);
    }

    public SummarySalary updatePaidSttus(SummarySalary editedSummarySalary) {
        SummarySalaryDao SummarySalaryDao = new SummarySalaryDao();
        CheckinoutDao CheckinoutDao = new CheckinoutDao();
        editedSummarySalary.setPaidStatus("Y");
        for (Checkinout object : CheckinoutDao.getBySSId(editedSummarySalary.getId())) {
            object.setCioPaidStatus("Y");
            CheckinoutDao.update(object);
        }
        SummarySalaryDao.update(editedSummarySalary);
        return editedSummarySalary;

    }

    public int delete(SummarySalary editedSummarySalary) {
        SummarySalaryDao SummarySalaryDao = new SummarySalaryDao();
        return SummarySalaryDao.delete(editedSummarySalary);
    }

    public SummarySalary getSalaryLastCreated() {
        SummarySalaryDao summarySalaryDao = new SummarySalaryDao();
        SummarySalary summ = summarySalaryDao.getSalaryLastCreated();
        return summ;
    }

}
