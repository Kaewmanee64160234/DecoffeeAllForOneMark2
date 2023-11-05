/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package print;

import Model.Reciept;
import Model.ReportSSModel;
import Model.SummarySalary;
import Service.SummarySalaryService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void printReport(String date) throws JRException {
        try {
            SummarySalaryService salaryService = new SummarySalaryService();
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date_ = inputDateFormat.parse(date);
            // Format the date to "MM/dd" format
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM/dd");
            SimpleDateFormat outputDateFormat_ = new SimpleDateFormat("YYYY-MM");

            ArrayList<SummarySalary> sses = salaryService.getSummarySalaryForReport(outputDateFormat_.format(date_));
            ArrayList<ReportSSModel> reportSSModels = new ArrayList<>();
            for (SummarySalary sse : sses) {
                ReportSSModel reportSSModel = new ReportSSModel();
                reportSSModel.setDate(sse.getDate());
                reportSSModel.setSalary(sse.getSalary()+"");
                reportSSModel.setEmployeeName(sse.getEmployeeName());
                reportSSModels.add(reportSSModel);
            }
            SummarySalary ss = new SummarySalary();
            ss = salaryService.getTotalSummarySalaryOneMonth(date);
            Map<String, Object> map = new HashMap<>();

            String formattedDateStr = outputDateFormat.format(date_);
            map.put("month", outputDateFormat_);
            map.put("total", ss.getTotalPaid());

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportSSModels);
            JasperPrint print = JasperFillManager.fillReport(reportPay, map, dataSource);
            view(print);
        } catch (ParseException ex) {
            Logger.getLogger(ReportSS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }

}
