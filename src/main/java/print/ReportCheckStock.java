/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package print;

import Model.Material;
import Service.MaterialService;
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
public class ReportCheckStock {
   
    private static ReportCheckStock instance;
    private JasperReport reportPay;

    public static ReportCheckStock getInstance() {
        if (instance == null) {
            instance = new ReportCheckStock();
        }
        return instance;
    }

    private ReportCheckStock() {

    }

    public void complieReport() throws JRException {
        reportPay = JasperCompileManager.compileReport("./Blank_A4_3.jrxml");

    }

    public void printReport() throws JRException {
       
            MaterialService materialService = new MaterialService();
            ArrayList<Material> materials = new ArrayList<>();
            materials = (ArrayList<Material>) materialService.getMaterials();
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(materials);
            Map<String, Object> map = new HashMap<>();
            map.put("month", "");
            
            map.put("total","");

            JasperPrint print = JasperFillManager.fillReport(reportPay, map, dataSource);
            view(print);

    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    } 
}
