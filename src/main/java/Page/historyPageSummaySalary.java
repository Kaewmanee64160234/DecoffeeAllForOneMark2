/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.ChagePage;
import Dialog.PrintSlipDialog;
import Model.BillDetail;
import Model.Checkinout;
import Model.Employee;
import Model.SummarySalary;
import Service.CheckinoutService;
import Service.EmployeeService;
import Service.SummarySalaryService;
import TablebtnEditDelete.TableActionCellEditor;
import TablebtnEditDelete.TableActionCellRenderer;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author USER
 */
public class historyPageSummaySalary extends javax.swing.JPanel implements ChagePage {

    private UtilDateModel model1;
    private UtilDateModel model2;
    private ArrayList<SummarySalary> summarySalarys;
    private final SummarySalaryService summarySalaryService;
    private List<Employee> Employees;
    private EmployeeService employeeService;
    private List<String> employeeName = new ArrayList<>();
    private ArrayList<ChagePage> chagePages = new ArrayList<>();

    /**
     * Creates new form historyPageSummaySalary
     */
    public historyPageSummaySalary() {
        initComponents();
        initDatePicker1();
        initDatePicker2();

        summarySalaryService = new SummarySalaryService();
        summarySalarys = new ArrayList<>();
        summarySalarys = summarySalaryService.getAll();
        employeeService = new EmployeeService();
        employeeName.add("All"); // You can add any default value you want
        employeeName.addAll(employeeService.getNameEmployees());
        // Set the ComboBox model with the employee names
        jComboBox1.setModel(new DefaultComboBoxModel<>(employeeName.toArray(new String[0])));

        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        tblSummarySalary.setRowHeight(60);
        tblSummarySalary.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 16));
        tblSummarySalary.setModel(new AbstractTableModel() {
            String[] columnNames = {"ID", "Date", "Work Hour", "Salary", "Paid Status"};

            @Override
            public String getColumnName(int column) {
                return columnNames[column];
            }

            @Override
            public int getRowCount() {
                return summarySalarys.size();
            }

            @Override
            public int getColumnCount() {
                return 5;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    default:
                        return String.class;
                }
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                SummarySalary summarySalary = summarySalarys.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return summarySalary.getId();
                    case 1:
                        return summarySalary.getDate();
                    case 2:
                        return summarySalary.getTotalHour();
                    case 3:
                        return summarySalary.getSalary();
                    case 4:
                        return summarySalary.getPaidStatus();
                    default:
                        return "Unknown";
                }
            }

        });

    }

    private void initDatePicker1() {
        model1 = new UtilDateModel();
        Properties p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new Model.DateLabelFormatter());
        pnlDatePicker1.add(datePicker1);

    }

    private void initDatePicker2() {
        model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new Model.DateLabelFormatter());
        pnlDatePicker2.add(datePicker2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSummarySalary = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelHead2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnlDatePicker3 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        cmbStatus1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        pnlDatePicker4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnClear1 = new javax.swing.JButton();
        btnGo1 = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblSummarySalary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSummarySalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSummarySalaryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSummarySalary);

        btnBack.setBackground(new java.awt.Color(213, 208, 189));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(103, 93, 80));
        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(103, 93, 80)));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(89, 89, 89)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanelHead2.setBackground(new java.awt.Color(224, 205, 174));
        jPanelHead2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelHead2.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel6.setFont(new java.awt.Font("Kanit", 0, 24)); // NOI18N
        jLabel6.setText("History Payment");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Start Date : ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Employee :");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(195, 176, 145));

        cmbStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Paid", "Not Paid" }));
        cmbStatus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatus1ActionPerformed(evt);
            }
        });
        jPanel7.add(cmbStatus1);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Stop Date : ");
        jPanel7.add(jLabel9);
        jPanel7.add(pnlDatePicker4);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Status : ");
        jPanel7.add(jLabel10);

        btnClear1.setBackground(new java.awt.Color(204, 255, 204));
        btnClear1.setForeground(new java.awt.Color(54, 126, 24));
        btnClear1.setText("Clear");
        btnClear1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 126, 24)));
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        btnGo1.setBackground(new java.awt.Color(204, 255, 204));
        btnGo1.setForeground(new java.awt.Color(54, 126, 24));
        btnGo1.setText("Go");
        btnGo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 126, 24)));
        btnGo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHead2Layout = new javax.swing.GroupLayout(jPanelHead2);
        jPanelHead2.setLayout(jPanelHead2Layout);
        jPanelHead2Layout.setHorizontalGroup(
            jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHead2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHead2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelHead2Layout.createSequentialGroup()
                        .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlDatePicker3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelHead2Layout.createSequentialGroup()
                                .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGo1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))))
        );
        jPanelHead2Layout.setVerticalGroup(
            jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHead2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelHead2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGo1)
                            .addComponent(btnClear1)))
                    .addGroup(jPanelHead2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlDatePicker3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelHead2, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelHead2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearJScoll() {
        jScrollPane2.getViewport().removeAll();
        jScrollPane2.revalidate();
        jScrollPane2.repaint();
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        chagePage("SS Main");
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblSummarySalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSummarySalaryMouseClicked
      int seleted_row = tblSummarySalary.getSelectedRow();
        if (seleted_row != -1) {
            int ss_id = (int) tblSummarySalary.getValueAt(seleted_row, 0);
            ArrayList<SummarySalary> ss = summarySalaryService.getAllSummarySalarysByCondition("summary_salary.ss_id=" + ss_id + " ");
            System.out.println(ss);
            CheckinoutService sioService = new CheckinoutService();
            ArrayList<Checkinout> cck = sioService.getCheckinoutsBySsId(ss_id);
            ss.get(0).setCheckins(cck);
            openDialogBillSS(ss.get(0));

        }
    }//GEN-LAST:event_tblSummarySalaryMouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void cmbStatus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatus1ActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void btnGo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGo1ActionPerformed
    private void refreshTable() {
        summarySalarys = summarySalaryService.getAll();
        tblSummarySalary.revalidate();
        tblSummarySalary.repaint();
    }

    private void refreshTableGetList() {
        tblSummarySalary.revalidate();
        tblSummarySalary.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnGo1;
    private javax.swing.JComboBox<String> cmbStatus1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelHead2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlDatePicker3;
    private javax.swing.JPanel pnlDatePicker4;
    private javax.swing.JTable tblSummarySalary;
    // End of variables declaration//GEN-END:variables

    public void addInChagePage(ChagePage ch) {
        chagePages.add(ch);
    }

    @Override
    public void chagePage(String pageName) {
        for (ChagePage ch : chagePages) {
            ch.chagePage(pageName);

        }
    }

    private void openDialogBillSS(SummarySalary ss) {
        jScrollPane2.setViewportView(new TablePaymentStatusPanel(ss));

    }
}
