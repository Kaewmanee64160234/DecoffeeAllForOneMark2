/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.decoffeeallforone;

import Component.ChagePage;
import Component.CusObs;
import Component.EmpObs;
import Component.LoginObs;
import Component.NavigationBar;
import Component.ProductListPanel;
import Component.changePageSummary;
import Dialog.CustomerDialog;
import Dialog.PosDialog;
import Dialog.PosPromotionDialog;
import Model.Customer;
import Model.Employee;
import Model.Promotion;
import Model.RentStore;
import Model.User;
import Page.BuyStockPanel;
import Page.CheckStockPanel;
import Page.CheckinCheckoutPanel;
import Page.EmployeePanel;
import Page.CheckinCheckoutPanel;
import Page.CustomerPanel;
import Page.DataUpdateObserver;
import Page.EmployeePanel;
import Page.HistoryCheckStockPanel;
import Page.HistoryMaterialPanel;
import Page.HistoryOrderPanel;
import Page.MaterialPanel;
import Page.PayRentPanel;

import Page.PosPanel;
import Page.ProductPanel;
import Page.PromotionPanel;
import Page.ReportPanel;
import Page.SalaryPanel;
import Page.TablePaymentStatusPanel;
import Page.TableSalaryPanel;
import Page.UserPanel;
import Page.historyPageSummaySalary;
import Service.EmployeeService;
import Service.PromotionService;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author USER
 */
public class MainFrame extends javax.swing.JFrame implements ChagePage, changePageSummary, LoginObs, DataUpdateObserver, EmpObs, CusObs {

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
    private Employee employee;
    private BuyStockPanel buyStockPanel;
    private ArrayList<LoginObs> loginObses;
    private ArrayList<EmpObs> empObss;
    private ArrayList<CusObs> cusObss;
    private HistoryMaterialPanel historyMaterialPanel;
    private Component PosDialog;
    private final JFrame frame;
    private PayRentPanel payRentPanel;
    private historyPageSummaySalary hisPageSummaySalary;
    private TableSalaryPanel tableSalaryPanel;
    private CustomerPanel customerPanel;
    private PromotionPanel promotionPanel;
   private HistoryOrderPanel historyOrderPanel;
    private ArrayList<DataUpdateObserver> dataUpdateObservers = new ArrayList<>();

    public MainFrame() {
        initComponents();
        loginObses = new ArrayList<>();
        empObss = new ArrayList<>();
        cusObss = new ArrayList<>();
        scrPanel.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set full Screen
        // loginObses = new ArrayList<>();
        employee = new Employee();
        productPanel = new ProductPanel();
        tableSalaryPanel = new TableSalaryPanel(employee);
        // posPanel = new PosPanel();
        hisPageSummaySalary = new historyPageSummaySalary();
        buystockPanel = new BuyStockPanel(employee);
        posPanel = new PosPanel();
        userPannel = new UserPanel();
        payRentPanel = new PayRentPanel();
        employeePannel = new EmployeePanel();
        materialPanel = new MaterialPanel();
        checkInOutPannel = new CheckinCheckoutPanel();
        navigationBar = new NavigationBar();
        checkStockPanel = new CheckStockPanel();
        salaryPannel = new SalaryPanel();
        reportPanel = new ReportPanel();
        historyMaterialPanel = new HistoryMaterialPanel();
        buyStockPanel = new BuyStockPanel(employee);
        customerPanel = new CustomerPanel();
        promotionPanel = new PromotionPanel();
        historyOrderPanel = new HistoryOrderPanel();
        jScrollPane1.setViewportView(navigationBar);
        loginObses.add(checkInOutPannel);

        checkStockPanel.addInSubs(this);
        salaryPannel.addInSubs(this);
        buystockPanel.addInSubs(this);
        navigationBar.addInSubs(this);
        buyStockPanel.addInSubs(this);
        historyOrderPanel.addInSubs(this);
        userPannel.addInSub(this);
        empObss.add(employeePannel);
        cusObss.add(customerPanel);
        posPanel.addSubs(this);

//        navigationBar.addInSubsLogin(this);
        hisPageSummaySalary.addInChagePage(this);
        tableSalaryPanel.addInChagePage(this);
        customerPanel.addInChangePage(this);
        promotionPanel.addInChangePage(this);
        frame = (JFrame) SwingUtilities.getRoot(this);
        materialPanel.addInchangePage(this);
        scrPanel.setViewportView(new UserPanel());
historyMaterialPanel.addInSubs(this);
        checkInOutPannel.addInLoginist(navigationBar);
        checkInOutPannel.addInLoginist(this.productPanel);
        checkInOutPannel.addInLoginist(this.materialPanel);
        checkInOutPannel.addInLoginist(this.checkStockPanel);
        checkInOutPannel.addInLoginist(buyStockPanel);
        checkInOutPannel.addInLoginist(userPannel);
        checkInOutPannel.addInLoginist(employeePannel);
        checkInOutPannel.addInLoginist(historyMaterialPanel);
        checkInOutPannel.addInLoginist(customerPanel);

        checkStockPanel.addInupdate(this);
        dataUpdateObservers.add(materialPanel);
//-----------------------------------------------------
        hisPageSummaySalary.addInChagePage(this);

        salaryPannel.addInChagePage(this);
        scrPanel.setViewportView(posPanel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrPanel = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1318, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 785, Short.MAX_VALUE));

        scrPanel.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(scrPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1320,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(scrPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 787,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(0, 0, 0)));

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
        if (pageName.equals("Rent Store")) {
            scrPanel.setViewportView(payRentPanel);
        }
        if (pageName.equals("History ss")) {
            scrPanel.setViewportView(hisPageSummaySalary);
        }
        if (pageName.equals("Customer")) {
            scrPanel.setViewportView(customerPanel);
        }
        if (pageName.equals("Promotion")) {
            scrPanel.setViewportView(promotionPanel);
        }
         if (pageName.equals("History Order")) {
            scrPanel.setViewportView(historyOrderPanel);
        }

    }

    @Override
    public void chagePageEmp(Employee emp, String pageName) {
        if (pageName.equals("SS Emp")) {
            tableSalaryPanel = new TableSalaryPanel(emp);
            tableSalaryPanel.addInChagePage(this);
            scrPanel.setViewportView(tableSalaryPanel);
        }
    }

    @Override
    public void loginData(User user) {
        for (LoginObs loginObse : loginObses) {
            loginObse.loginData(user);
//            System.out.println(loginObse.toString());

        }

//        System.out.println("com.mycompany.decoffeeallforone.MainFrame.loginData()");
//        EmployeeService employSer = new EmployeeService();
//        buyStockPanel = new BuyStockPanel(employSer.getById(user.getEmployee_id()));
    }

    @Override
    public void onDataUpdated() {
        System.out.println("com.mycompany.decoffeeallforone.MainFrame.onDataUpdated()");
        for (DataUpdateObserver dataUpdateObserver : dataUpdateObservers) {

            dataUpdateObserver.onDataUpdated();
        }
    }

    public void updateEmployee(Employee employee) {
        System.out.println("com.mycompany.decoffeeallforone.MainFrame.updateEmployee()");
        for (EmpObs empObs : empObss) {
            empObs.updateEmployee(employee);
        }

    }

    @Override
    public void updateCustomer(Customer customer) {
        for (CusObs cusObs : cusObss) {
            cusObs.updateCustomer(customer);
        }
    }

}
