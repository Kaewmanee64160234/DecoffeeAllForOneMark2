/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package print;

import Model.Bill;
import Model.Reciept;
import Model.ReportSSModel;
import Model.SummarySalary;
import Service.BillService;
import Service.RecieptDetailService;
import Service.RecieptService;
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
public class ReportExpenseStock {

    private static ReportExpenseStock instance;
    private JasperReport reportPay;

    public static ReportExpenseStock getInstance() {
        if (instance == null) {
            instance = new ReportExpenseStock();
        }
        return instance;
    }

    private ReportExpenseStock() {

    }

    public void complieReport() throws JRException {
        reportPay = JasperCompileManager.compileReport("./Blank_A4_2.jrxml");

    }

    public void printReport(String date) throws JRException {
        try {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date_ = inputDateFormat.parse(date);

            SimpleDateFormat outputDateFormat_1 = new SimpleDateFormat("YYYY-MM");
            BillService billService = new BillService();
            ArrayList<Bill> biills = new ArrayList<>();
            Bill bill = new Bill();
            bill = billService.getBillByDate(date);
            biills = billService.getBillOneMonth(date);
            if (biills.size() >= 1) {
                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(biills);
                Map<String, Object> map = new HashMap<>();
                map.put("month", outputDateFormat_1.format(date_));

                map.put("total", bill.getBillTotal() + "");

                JasperPrint print = JasperFillManager.fillReport(reportPay, map, dataSource);
                view(print);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ReportExpenseStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }

}
