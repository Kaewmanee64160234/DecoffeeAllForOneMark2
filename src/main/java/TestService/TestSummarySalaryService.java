package TestService;

import Model.SummarySalary;
import Service.SummarySalaryService;

public class TestSummarySalaryService {

    public static void main(String[] args) {
        SummarySalaryService summarySalaryService = new SummarySalaryService();
//        System.out.println(summarySalaryService.getById(3));
//        SummarySalary summarySalary = new SummarySalary();
//        summarySalaryService.addNewSalary(2, summarySalary);
//        for (SummarySalary ss : summarySalaryService.getAll()) {
//            System.out.println(ss.toString());
//
//        }
        SummarySalary summarySalary = summarySalaryService.getById(7);
        summarySalaryService.updatePaidSttus(summarySalary);
        for (SummarySalary summarySalary1 : summarySalaryService.getAll()) {
            System.out.println(summarySalary1.toString());
            
        }
    }

}
