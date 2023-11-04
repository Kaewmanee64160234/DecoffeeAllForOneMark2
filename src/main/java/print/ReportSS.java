/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package print;

import Model.Reciept;
import java.text.SimpleDateFormat;
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
        reportPay = JasperCompileManager.compileReport("./Blank_A4.jrxml");

    }

    public void printReport(Reciept reciept) throws JRException {
       

    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }
    
}
