/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.CodeDialog;
import Dialog.AddARentBillDialog;
import Dialog.PayRentDialog;
import Dialog.PrintPayRentHistory;
import Model.DateLabelFormatter;
import Model.RentStore;
import Service.RentStoreService;
import Validation.ValidateException;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author ASUS
 */
public class PayRentPanel extends javax.swing.JPanel implements CodeDialog {

    private final RentStoreService rentStoreService;
    private RentStore editedRentStore;
    private List<RentStore> list;
    private ArrayList<RentStore> rentStore;
    private UtilDateModel model1;
    private JDatePanelImpl datePanel1;
    private UtilDateModel model2;
    private JDatePanelImpl datePanel2;
    private PrintPayRentHistory payRentDialog;

    /**
     * Creates new form PayRentPanel
     */
    private void initDatePicker1() {
        model1 = new UtilDateModel();

        Properties p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        datePanel1 = new JDatePanelImpl(model1, p1);
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
        pnlDatePicker1.add(datePicker1);

    }

    private void initDatePicker2() {
        model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        datePanel2 = new JDatePanelImpl(model2, p2);
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        pnlDatePicker2.add(datePicker2);

    }

    public PayRentPanel() {
        initComponents();
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        payRentDialog = new PrintPayRentHistory(frame);
        payRentDialog.addInSub(this);

        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        initDatePicker1();
        initDatePicker2();

        rentStoreService = new RentStoreService();
        editedRentStore = new RentStore();
        tblPayRent.setEnabled(true);
        tblPayRent.setRowHeight(50);
        tblPayRent.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 14));
        tblPayRent.setModel(new AbstractTableModel() {
            String[] columnNames = {"Date", "Rent Price", "Water Payment", "Electic Payment", "Total Payment", "Paid Status"};

            @Override
            public String getColumnName(int column) {
                return columnNames[column];
            }

            @Override
            public int getRowCount() {
                return rentStore.size();
            }

            @Override
            public int getColumnCount() {
                return 6;
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
                RentStore rentStore_ = rentStore.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return rentStore_.getRentDate();
                    case 1:
                        return rentStore_.getRentPrice();
                    case 2:
                        return rentStore_.getRentWater();
                    case 3:
                        return rentStore_.getRentElectic();
                    case 4:
                        return rentStore_.getRentTotal();
                    case 5:
                        return rentStore_.getRentPaidStatus();

                    default:
                        return "Unknown";
                }
            }

        });
        rentStore = (ArrayList<RentStore>) rentStoreService.getRentStores();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtRole = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnConfirm = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlDatePicker1 = new javax.swing.JPanel();
        pnlDatePicker2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPayRent = new javax.swing.JTable();
        btnAddRentBill = new javax.swing.JButton();
        btnPayRent = new javax.swing.JButton();
        btnPrintPaymentHistory = new javax.swing.JButton();
        cmbPosition = new javax.swing.JComboBox<>();
        btnClear = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(224, 205, 174));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel4.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel4.setText("Pay Rent");

        jLabel8.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel8.setText("User Name: ");

        txtUserName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtUserName.setText("Name");

        jLabel9.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel9.setText("Role:");

        txtRole.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtRole.setText("Role");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 714, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtUserName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtRole)))
                    .addComponent(jLabel4))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnConfirm.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        jLabel5.setText("End Date:");

        jLabel6.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        jLabel6.setText("Start Date:");

        jLabel7.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        jLabel7.setText("Status:");

        tblPayRent.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        tblPayRent.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPayRent.setSelectionBackground(new java.awt.Color(213, 208, 189));
        jScrollPane1.setViewportView(tblPayRent);

        btnAddRentBill.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnAddRentBill.setText("Add a rent bill");
        btnAddRentBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRentBillActionPerformed(evt);
            }
        });

        btnPayRent.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnPayRent.setText("Pay rent");
        btnPayRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayRentActionPerformed(evt);
            }
        });

        btnPrintPaymentHistory.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnPrintPaymentHistory.setText("Print payment history");
        btnPrintPaymentHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintPaymentHistoryActionPerformed(evt);
            }
        });

        cmbPosition.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        cmbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid", "Not paid" }));
        cmbPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPositionActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPosition, 0, 228, Short.MAX_VALUE)
                            .addComponent(pnlDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnConfirm)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAddRentBill)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPayRent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPrintPaymentHistory))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPayRent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrintPaymentHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddRentBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(pnlDatePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel6)
                    .addComponent(btnClear))
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbPosition))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPositionActionPerformed



    }//GEN-LAST:event_cmbPositionActionPerformed
    private void openDialog1() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        AddARentBillDialog addRentBillDialog = new AddARentBillDialog(frame);
        addRentBillDialog.setLocationRelativeTo(this); //set dialog to center
        addRentBillDialog.setVisible(true);
        addRentBillDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {

                refreshTable();
            }

        });

    }

    private void openDialog2() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        PayRentDialog payRentDialog = new PayRentDialog(frame, editedRentStore);
        payRentDialog.setLocationRelativeTo(this); //set dialog to center
        payRentDialog.setVisible(true);
        payRentDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {

                refreshTable();
            }

        });
    }

    private void openDialog3() {

        payRentDialog.setLocationRelativeTo(this); //set dialog to center
        payRentDialog.setVisible(true);
        payRentDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {

                refreshTableGetList();
            }

        });
    }

    private void btnAddRentBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRentBillActionPerformed
        editedRentStore = new RentStore();
        openDialog1();
    }//GEN-LAST:event_btnAddRentBillActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        String varName = (String) cmbPosition.getSelectedItem();
        String value = cmbPosition.getSelectedItem().toString();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        if (model1.getValue() == null && model2.getValue() == null) {
            if (value.equals("Paid")) {
                rentStore = rentStoreService.getByPaidStatus("Y");
            } else {
                rentStore = rentStoreService.getByPaidStatus("N");
            }
            cmbPosition.setSelectedItem(value);
        } else {
            String begin = formater.format(model1.getValue());
            String end = formater.format(model2.getValue());

            if (value.equals("Paid")) {
                rentStore = rentStoreService.getByDateByPaidStatus("Y", begin, end);

            } else {
                rentStore = rentStoreService.getByDateByPaidStatus("N", begin, end);
            }
            cmbPosition.setSelectedItem(value);

        }

        refreshTableGetList();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnPayRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayRentActionPerformed
        int selectedIndex = tblPayRent.getSelectedRow();
        if (selectedIndex >= 0) {
            editedRentStore = rentStore.get(selectedIndex);
            openDialog2();
        } else {
            JOptionPane.showMessageDialog(null, "Please select an item", "Error", JOptionPane.ERROR_MESSAGE);
        }

        System.out.println(editedRentStore);
    }//GEN-LAST:event_btnPayRentActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        model1.setSelected(false);
        model2.setSelected(false);
        refreshTable();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnPrintPaymentHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintPaymentHistoryActionPerformed
        openDialog3();
    }//GEN-LAST:event_btnPrintPaymentHistoryActionPerformed

    private void refreshTable() {
        rentStore = (ArrayList<RentStore>) rentStoreService.getRentStores();
        tblPayRent.revalidate();
        tblPayRent.repaint();
    }

    private void refreshTableGetList() {
        tblPayRent.revalidate();
        tblPayRent.repaint();
        System.out.println("Page.PayRentPanel.refreshTableGetList() ::::" + rentStore);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRentBill;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnPayRent;
    private javax.swing.JButton btnPrintPaymentHistory;
    private javax.swing.JComboBox<String> cmbPosition;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDatePicker1;
    private javax.swing.JPanel pnlDatePicker2;
    private javax.swing.JTable tblPayRent;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void CodeDialog(List<RentStore> rentStores) {
        System.out.println("Page.PayRentPanel.CodeDialog() : " + rentStores);
        this.rentStore = (ArrayList<RentStore>) rentStores;
        System.out.println("Page.PayRentPanel.CodeDialog() :::::::::: " + rentStore);
        refreshTableGetList();
    }
}
