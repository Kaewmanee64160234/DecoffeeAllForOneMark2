/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package print;

import java.util.HashMap;
import java.util.Map;

import Model.Reciept;
import java.text.SimpleDateFormat;
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
public class ReportManager {

    private static ReportManager instance;
    private JasperReport reportPay;

    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }

    private ReportManager() {

    }

    public void complieReport() throws JRException {
        reportPay = JasperCompileManager.compileReport("./Blank_A4.jrxml");

    }

    public void printReport(Reciept reciept) throws JRException {
        Map<String, Object> map = new HashMap<>();

        if (reciept.getEmployee() == null) {
            map.put("staff", "-");
        } else {
            map.put("staff", reciept.getEmployee().getName());
        }

        if (reciept.getCustomer() == null) {
            map.put("customer", "-");
        } else {
            map.put("customer", reciept.getCustomer().getName());
        }
        map.put("total", reciept.getTotal() + reciept.getDiscount() + "");
        map.put("recieve", reciept.getReceive() + "");
        map.put("change", reciept.getChange() + "");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(reciept.getCreaetedDate());
        map.put("date", formattedDate);
        map.put("discount", reciept.getDiscount() + "");
        map.put("totalNet", reciept.getTotal()-reciept.getDiscount() + "");
        map.put("queue", reciept.getQueue() + "");

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reciept.getRecieptDetails());
        JasperPrint print = JasperFillManager.fillReport(reportPay, map, dataSource);
        view(print);

    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);

    }
}
