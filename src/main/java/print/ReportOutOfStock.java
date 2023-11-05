/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package print;

import Model.Material;
import Model.MaterialReport;
import Model.Reciept;
import Model.ReportSSModel;
import Model.SummarySalary;
import Service.MaterialService;
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
public class ReportOutOfStock {

    private static ReportOutOfStock instance;
    private JasperReport reportPay;

    public static ReportOutOfStock getInstance() {
        if (instance == null) {
            instance = new ReportOutOfStock();
        }
        return instance;
    }

    private ReportOutOfStock() {

    }

    public void complieReport() throws JRException {
        reportPay = JasperCompileManager.compileReport("./Blank_A4_4.jrxml");

    }

    public void printReport(String date) throws JRException {
 
        
            MaterialService materialService = new MaterialService();
          ArrayList<Material> materials = new ArrayList<>();
          materials = materialService.getMaterialByMinQtyReport();
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(materials);
            Map<String, Object> map = new HashMap<>();
          
            JasperPrint print = JasperFillManager.fillReport(reportPay, map, dataSource);
            view(print);

       
    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }

}
