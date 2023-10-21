/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Dialog.AddARentBillDialog;
import Dialog.PayRentDialog;
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
public class PayRentPanel extends javax.swing.JPanel {

    private final RentStoreService rentStoreService;
    private RentStore editedRentStore;
    private List<RentStore> list;
    private ArrayList<RentStore> rentStore;
    private UtilDateModel model1;
    private JDatePanelImpl datePanel1;
    private UtilDateModel model2;
    private JDatePanelImpl datePanel2;

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

        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
         initDatePicker1();
         initDatePicker2();

        rentStoreService = new RentStoreService();
        editedRentStore = new RentStore();
        rentStore = rentStoreService.getByDate("", "");
        list = rentStoreService.getRentStores();
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
                return list.size();
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
                RentStore rentStore = list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return rentStore.getRentDate();
                    case 1:
                        return rentStore.getRentPrice();
                    case 2:
                        return rentStore.getRentWater();
                    case 3:
                        return rentStore.getRentElectic();
                    case 4:
                        return rentStore.getRentTotal();
                    case 5:
                        return rentStore.getRentPaidStatus();

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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
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
        jButton7 = new javax.swing.JButton();
        cmbPosition = new javax.swing.JComboBox<>();
        btnClear = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(213, 208, 189));

        jLabel4.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel4.setText("Pay Rent");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(170, 183, 173));

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

        jButton7.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        jButton7.setText("Print payment history");

        cmbPosition.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddRentBill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPayRent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(cmbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnConfirm))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(pnlDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnlDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear)))
                        .addGap(0, 92, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnlDatePicker1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pnlDatePicker2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(btnConfirm)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(cmbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnClear)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddRentBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPayRent, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                list = rentStoreService.getByPaidStatus("Y");
            } else {
                list = rentStoreService.getByPaidStatus("N");
            }
            cmbPosition.setSelectedItem(value);
        } else {
            String begin = formater.format(model1.getValue());
            String end = formater.format(model2.getValue());
            list = rentStore;

            if (value.equals("Paid")) {
                list = rentStoreService.getByDateByPaidStatus("Y", begin, end);

            } else {
                list = rentStoreService.getByDateByPaidStatus("N", begin, end);
            }
            cmbPosition.setSelectedItem(value);

        }

        refreshTableGetList();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnPayRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayRentActionPerformed
        int selectedIndex = tblPayRent.getSelectedRow();
        if (selectedIndex >= 0) {
            editedRentStore = list.get(selectedIndex);
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

    private void refreshTable() {
        list = rentStoreService.getRentStores();
        tblPayRent.revalidate();
        tblPayRent.repaint();
    }

    private void refreshTableGetList() {
        tblPayRent.revalidate();
        tblPayRent.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRentBill;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnPayRent;
    private javax.swing.JComboBox<String> cmbPosition;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDatePicker1;
    private javax.swing.JPanel pnlDatePicker2;
    private javax.swing.JTable tblPayRent;
    // End of variables declaration//GEN-END:variables
}
