/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Dialog.PaymentSlipDialog;
import Dialog.PaymentStatus;
import Dialog.PrintSlipDialog;
import Model.Checkinout;
import Model.Employee;
import Model.SummarySalary;
import Service.CheckinoutService;
import Service.SummarySalaryService;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author ASUS
 */
public class TableSalaryPanel extends javax.swing.JPanel {

    static void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Creates new form TableSalaryPanel
     */
    private Employee employee;
    private CheckinoutService checkinoutService;
    private SummarySalaryService summarySalaryService;
    private ArrayList<Checkinout> cioList;
    private SummarySalary summarySalary;

    public TableSalaryPanel(Employee employee) {
        initComponents();
        this.employee = employee;
        this.cioList = new ArrayList<>();
        this.summarySalary = new SummarySalary();
        lblNameEmp.setText(employee.getName());
        txtBathPerHr.setText(employee.getHourlyWage() + "");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        checkinoutService = new CheckinoutService();
        summarySalaryService = new SummarySalaryService();
        cioList = checkinoutService.getCheckInOutByPaidStatusAndEmpId(employee.getId(), "N");

        tblPaidDate.setModel(new AbstractTableModel() {
            String[] columnNames = {"Date", "Time In", "Time Out", "Total Hour", "Total Price"};

            @Override
            public String getColumnName(int column) {
                return columnNames[column];
            }

            @Override
            public int getRowCount() {
                return cioList.size();
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
                Checkinout checkinout = cioList.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return checkinout.getCioDate();
                    case 1:
                        return checkinout.getCioTimeIn();
                    case 2:
                        return checkinout.getCioTimeOut();
                    case 3:
                        return checkinout.getCioTotalHour();
                    case 4:
                        if (employee == null) {
                            return "-";
                        } else {
                            return checkinout.getCioTotalHour() * employee.getHourlyWage();
                        }

                    default:
                        return "Unknown";
                }
            }
        });

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
        lblNameEmp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBathPerHr = new javax.swing.JLabel();
        btnPaymentHistory = new javax.swing.JButton();
        btnPrintSlip = new javax.swing.JButton();
        btnPayMentStatus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaidDate = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cmbPosition = new javax.swing.JComboBox<>();
        btnCancel1 = new javax.swing.JButton();
        btnConfirm1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(213, 208, 189));

        lblNameEmp.setFont(new java.awt.Font("Kanit", 0, 24)); // NOI18N
        lblNameEmp.setText("Keawmanee Marasri");

        jLabel4.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        jLabel4.setText("bath/hr :");

        txtBathPerHr.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N

        btnPaymentHistory.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        btnPaymentHistory.setText("Payment history");
        btnPaymentHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentHistoryActionPerformed(evt);
            }
        });

        btnPrintSlip.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        btnPrintSlip.setText("Print payment slip");
        btnPrintSlip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintSlipActionPerformed(evt);
            }
        });

        btnPayMentStatus.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        btnPayMentStatus.setText("Payment status");
        btnPayMentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayMentStatusActionPerformed(evt);
            }
        });

        tblPaidDate.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPaidDate);

        jLabel6.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        jLabel6.setText("Status :");

        cmbPosition.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        cmbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid", "Not paid" }));
        cmbPosition.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPositionActionPerformed(evt);
            }
        });

        btnCancel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancel1.setText("Cancel");
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });

        btnConfirm1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnConfirm1.setText("Confirm");
        btnConfirm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirm1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNameEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBathPerHr, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(btnPaymentHistory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrintSlip))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 450, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPayMentStatus)
                    .addComponent(cmbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirm1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNameEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtBathPerHr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnPayMentStatus)
                                .addComponent(btnPrintSlip)
                                .addComponent(btnPaymentHistory)))
                        .addGap(6, 6, 6)
                        .addComponent(cmbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel1)
                    .addComponent(btnConfirm1))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPaymentHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentHistoryActionPerformed

    }//GEN-LAST:event_btnPaymentHistoryActionPerformed

    private void btnPrintSlipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintSlipActionPerformed
        openPrintSlipDialog();
        refreshTable();

    }//GEN-LAST:event_btnPrintSlipActionPerformed

    private void btnPayMentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayMentStatusActionPerformed
        openPaymentStatusDialog();
    }//GEN-LAST:event_btnPayMentStatusActionPerformed

    private void cmbPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPositionActionPerformed

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed

    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void btnConfirm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirm1ActionPerformed

    }//GEN-LAST:event_btnConfirm1ActionPerformed

    private void openPrintSlipDialog() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        PrintSlipDialog printSlipDialog = new PrintSlipDialog(frame, employee);
        printSlipDialog.setLocationRelativeTo(this);
        printSlipDialog.setVisible(true);
        printSlipDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable();
                summarySalary = summarySalaryService.getSalaryLastCreated();
                summarySalary.setCheckins(checkinoutService.getCheckinoutsBySsId(summarySalary.getId()));
                summarySalary.setEmployee(employee);
                System.out.println(summarySalary.toString());
                opendialogSlip(summarySalary, employee);

            }
        });
    }

    private void openPaymentStatusDialog() {
        ArrayList<SummarySalary> summarySalarys = summarySalaryService.getSummarySalarysByPaidStatus("N");
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        PaymentStatus paymentStatus = new PaymentStatus(frame, summarySalarys);
        paymentStatus.setLocationRelativeTo(this);
        paymentStatus.setVisible(true);
        paymentStatus.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable();
            }
        });
    }

    private void refreshTable() {
        cioList = checkinoutService.getCheckInOutByPaidStatusAndEmpId(employee.getId(), "N");
        tblPaidDate.revalidate();
        tblPaidDate.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnConfirm1;
    private javax.swing.JButton btnPayMentStatus;
    private javax.swing.JButton btnPaymentHistory;
    private javax.swing.JButton btnPrintSlip;
    private javax.swing.JComboBox<String> cmbPosition;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNameEmp;
    private javax.swing.JTable tblPaidDate;
    private javax.swing.JLabel txtBathPerHr;
    // End of variables declaration//GEN-END:variables

    private void opendialogSlip(SummarySalary summarySalary, Employee employee) {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        PaymentSlipDialog paymentSlipDialog = new PaymentSlipDialog(frame, summarySalary, employee);
        paymentSlipDialog.setLocationRelativeTo(this);
        paymentSlipDialog.setVisible(true);
    }
}
