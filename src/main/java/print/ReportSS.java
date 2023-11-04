/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package print;

import Model.Reciept;
import Model.SummarySalary;
import Service.SummarySalaryService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USER
 */
public class ReportSS {

    private static ReportSS instance;
    private JasperReport reportPay;

    public static ReportSS getInstance() {
        if (instance == null) {
            instance = new ReportSS();
        }
        return instance;
    }

    private ReportSS() {

    }

    public void complieReport() throws JRException {
        reportPay = JasperCompileManager.compileReport("./Blank_A4_1.jrxml");

    }

    public void printReport(SummarySalary summarySalary, String date) throws JRException {
        SummarySalaryService salaryService = new SummarySalaryService();
        ArrayList<SummarySalary> sses = salaryService.getSummarySalaryForReport(date);
        ArrayList<SummarySalary> sses1 = salaryService.getSummarySalaryByTotalPaid(date, date);
        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
        String strDate = formatter.format(date);
        map.put("month", strDate);
        map.put("total", sses1.get(0).getTotalPaid());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(sses);
        JasperPrint print = JasperFillManager.fillReport(reportPay, map, dataSource);
        view(print);
    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }

}
