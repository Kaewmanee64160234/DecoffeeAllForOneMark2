package TestService;

import Service.SummarySalaryService;

public class TestSummarySalaryService {
    public static void main(String[] args) {
        SummarySalaryService summarySalaryService = new SummarySalaryService();
        System.out.println(summarySalaryService.getById(1));
    }
    
}
