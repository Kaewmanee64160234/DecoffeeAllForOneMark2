/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.decoffeeallforone;

import Component.ChagePage;
import Component.LoginObs;
import Component.NavigationBar;
import Component.ProductListPanel;
import Component.changePageSummary;
import Dialog.CustomerDialog;
import Model.Employee;
import Model.Promotion;
import Model.User;
import Page.BuyStockPanel;
import Page.CheckStockPanel;
import Page.CheckinCheckoutPanel;
import Page.EmployeePanel;
import Page.CheckinCheckoutPanel;
import Page.EmployeePanel;
import Page.HistoryCheckStockPanel;
import Page.HistoryMaterialPanel;
import Page.MaterialPanel;
import Page.PayRentPanel;

import Page.PosPanel;
import Page.ProductPanel;
import Page.ReportPanel;
import Page.SalaryPanel;
import Page.TablePaymentStatusPanel;
import Page.TableSalaryPanel;
import Page.UserPanel;
import Service.EmployeeService;
import Service.PromotionService;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author USER
 */
public class MainFrame extends javax.swing.JFrame implements ChagePage, changePageSummary, LoginObs {

    /**
     * Creates new form MainFrame
     */
    private NavigationBar navigationBar;
    private PosPanel posPanel;
    private ProductPanel productPanel;
    private UserPanel userPannel;
    private EmployeePanel employeePannel;
    private MaterialPanel materialPanel;
    private CheckinCheckoutPanel checkInOutPannel;
    private CheckStockPanel checkStockPanel;
    private BuyStockPanel buystockPanel;
    private ReportPanel reportPanel;
    private SalaryPanel salaryPannel;
    private TableSalaryPanel tableSalaryPannel;
    private Employee employee;
    private BuyStockPanel buyStockPanel;


    private ArrayList<LoginObs> loginObses;
    private HistoryMaterialPanel historyMaterialPanel;

    public MainFrame() {
        initComponents();
        scrPanel.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        setExtendedState(JFrame.MAXIMIZED_BOTH); //Set full Screen
       // loginObses = new ArrayList<>();
        employee = new Employee();
        productPanel = new ProductPanel();
        ProductPanel productPanel = new ProductPanel();
        navigationBar = new NavigationBar();
//        posPanel = new PosPanel();
        buystockPanel = new BuyStockPanel(employee);
        posPanel = new PosPanel();
        userPannel = new UserPanel();
        employeePannel = new EmployeePanel();
        materialPanel = new MaterialPanel();
        checkInOutPannel = new CheckinCheckoutPanel();
        navigationBar = new NavigationBar();
        checkStockPanel = new CheckStockPanel();
        salaryPannel = new SalaryPanel();
        reportPanel = new ReportPanel();
        buyStockPanel = new BuyStockPanel(employee);
        jScrollPane1.setViewportView(navigationBar);
        checkStockPanel.addInSubs(this);
        salaryPannel.addInSubs(this);
        buystockPanel.addInSubs(this);
        navigationBar.addInSubs(this);

       //scrPanel.setViewportView(reportPanel);

       scrPanel.setViewportView(new HistoryMaterialPanel());

        checkInOutPannel.addInLoginist(buystockPanel);
        checkInOutPannel.addInLoginist(this);
        buyStockPanel.addInLoginObs(this);
        buyStockPanel.addInSubs(this);

        scrPanel.setViewportView(new PayRentPanel());   
//        scrPanel.setViewportView();



    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrPanel = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1318, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );

        scrPanel.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void chagePage(String pageName) {
        if (pageName.equals("Main menu")) {
            scrPanel.setViewportView(reportPanel);
        }

        if (pageName.equals("POS")) {
            scrPanel.setViewportView(posPanel);
        }
        if (pageName.equals("Product")) {
            scrPanel.setViewportView(productPanel);
        }
        if (pageName.equals("User")) {
            scrPanel.setViewportView(userPannel);
        }
        if (pageName.equals("Employee")) {
            scrPanel.setViewportView(employeePannel);
        }
        if (pageName.equals("Material")) {
            scrPanel.setViewportView(materialPanel);
        }
        if (pageName.equals("Check In-Out")) {
            scrPanel.setViewportView(checkInOutPannel);
        }
        if (pageName.equals("Check Stock")) {
            scrPanel.setViewportView(checkStockPanel);
        }
        if (pageName.equals("SS Main")) {
            scrPanel.setViewportView(salaryPannel);

        }
        if (pageName.equals("BuyStock")) {
            scrPanel.setViewportView(buyStockPanel);
        }
        if (pageName.equals("HistoryMaterial")) {
            scrPanel.setViewportView(historyMaterialPanel);
        }

    }

    @Override
    public void chagePageEmp(Employee emp, String pageName) {
        if (pageName.equals("SS Emp")) {
            scrPanel.setViewportView(new TableSalaryPanel(emp));
        }
    }

    @Override
    public void loginData(User user) {
        EmployeeService employSer = new EmployeeService();
        buyStockPanel = new BuyStockPanel(employSer.getById(user.getEmployee_id()));

    }

}
