/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Model.Bill;
import Model.BillDetail;
import Model.DateLabelFormatter;
import Model.Material;
import Model.RecieptDetail;
import Service.MaterialService;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Chaiwat
 */
public class BuyStockPanel extends javax.swing.JPanel {

    private final MaterialService materialService;
    private List<Material> list;
    private Material material;
    private UtilDateModel model1;
    private Bill bill;

    public BuyStockPanel() {
        initComponents();
        initDatePicker();
        bill = new Bill();
        materialService = new MaterialService();
        list = materialService.getMaterials();
        tblMeterial.setRowHeight(30);
        tblMeterial.setModel(new AbstractTableModel() {
            String[] columnNames = {"ID", "Name", "Minimum"};

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
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Material meterial = list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return meterial.getId();
                    case 1:
                        return meterial.getName();
                    case 2:
                        return meterial.getMatMinQty();

                    default:
                        return "Unknown";
                }
            }
        });
        initTable();
    }

    private void initTable() {
        tblBillDetail.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 14));

        tblBillDetail.setModel(new AbstractTableModel() {
            String[] headers = {"ID", "Name", "Amount", "Price", "Total", "Discount"};

            @Override
            public String getColumnName(int column) {
                return headers[column];
            }

            @Override
            public int getRowCount() {
                return bill.getBillDetails().size();
            }

            @Override
            public int getColumnCount() {
                return 6;
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//                ArrayList<BillDetail> billDetails = bill.getBillDetails();
//                BillDetail billDetail = billDetails.get(rowIndex);

                //setValueAt Bill
//                bill.setShopname(edtShopName.getSelectedText());
//
//                float totalDis = 0.0f;
//
//                if (columnIndex == 5) {
//                    int qty = Integer.parseInt((String) aValue);
//
//                    if (qty < 1) {
//                        return;
//                    }
//
//                    for (BillDetail bd : billDetails) {
//                        totalDis += bd.getDiscount();
//                    }
//
//                    totalDis *= qty;
//
//                    bill.setTotalDiscount(totalDis);
//                }
//                String totalpice = edtTotalprice.getText();
//                float biltotalprice = Float.parseFloat(totalpice) - bill.getTotalDiscount();
//                bill.setBillTotal(biltotalprice);
//                
//                String buyText = edtBuy.getText();
//                float buy = Float.parseFloat(buyText);
//                bill.setChange(buy - bill.getBillTotal());
//
//                if (columnIndex == 2) {
//                    int qty = Integer.parseInt((String) aValue);
//                    if (qty < 1) {
//                        return;
//                    }
//
//                    bill.setTotalQty(qty);
//                }
                //setValueAt BillDetail
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 2:
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                ArrayList<BillDetail> billDetails = bill.getBillDetails();
                BillDetail billDetail = billDetails.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return billDetail.getMat_id();
                    case 1:
                        return billDetail.getName();
                    case 2:
                        return billDetail.getAmount();
                    case 3:
                        return billDetail.getPrice();
                    case 4:
                        return billDetail.getTotal();
                    case 5:
                        return billDetail.getDiscount();
                    default:
                        return "";
                }
            }
        });
        tblBillDetail.setCellSelectionEnabled(true);
        tblBillDetail.setColumnSelectionAllowed(true);
        tblBillDetail.setSurrendersFocusOnKeystroke(true);
    }

    private void initDatePicker() {
        model1 = new UtilDateModel();
        Properties p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());

        pnlDatePicker.add(datePicker1);

        // setDate in Bill
//        Date selectedDate = (Date) datePicker1.getModel().getValue();
//        bill.setCreatdDate(selectedDate);
    }

    private void updateBillDetailTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Amount");
        model.addColumn("Price");
        model.addColumn("Total");
        model.addColumn("Discount");

        Bill bill = this.bill;
        ArrayList<BillDetail> billDetails = bill.getBillDetails();

        for (BillDetail billDetail : billDetails) {
            Object[] rowData = {
                billDetail.getMat_id(),
                billDetail.getName(),
                billDetail.getAmount(),
                billDetail.getPrice(),
                billDetail.getTotal(),
                billDetail.getDiscount()
            };
            model.addRow(rowData);
        }

        tblBillDetail.setModel(model);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblAddStock = new javax.swing.JLabel();
        txtShopName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edtShopName = new javax.swing.JTextField();
        pnlDatePicker = new javax.swing.JPanel();
        txtUserName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBillDetail = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtTotalPrice = new javax.swing.JLabel();
        edtDiscount = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JLabel();
        edtTotalprice = new javax.swing.JTextField();
        txtTotal = new javax.swing.JLabel();
        txtBuy = new javax.swing.JLabel();
        edtBuy = new javax.swing.JTextField();
        txtChange = new javax.swing.JLabel();
        btnCalculate = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        lblChange = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMeterial = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblAddStock.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblAddStock.setText("เพิ่ม Stock");

        txtShopName.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        txtShopName.setText("Shop Name:");

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel3.setText("Date:");

        edtShopName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtShopNameActionPerformed(evt);
            }
        });

        txtUserName.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        txtUserName.setText("UserName:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblAddStock, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txtShopName)
                        .addGap(18, 18, 18)
                        .addComponent(edtShopName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddStock)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtShopName)
                            .addComponent(edtShopName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblBillDetail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblBillDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Amount", "Price", "Total", "Discount"
            }
        ));
        jScrollPane1.setViewportView(tblBillDetail);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtTotalPrice.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtTotalPrice.setText("Total price:");

        txtDiscount.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtDiscount.setText("Discount:");

        txtTotal.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtTotal.setText("Total:");

        txtBuy.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtBuy.setText("Buy:");

        txtChange.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        txtChange.setText("Change:");

        btnCalculate.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        btnCalculate.setText("Calculate");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTotal)
                    .addComponent(txtDiscount)
                    .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtTotalprice, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(edtDiscount)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCalculate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtBuy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtBuy))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtChange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPrice)
                    .addComponent(edtTotalprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtBuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiscount)
                    .addComponent(edtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChange)
                    .addComponent(lblChange, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal)
                    .addComponent(btnCalculate)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        tblMeterial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblMeterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Minimum"
            }
        ));
        tblMeterial.setFocusable(false);
        tblMeterial.setGridColor(new java.awt.Color(255, 255, 255));
        tblMeterial.setSelectionBackground(new java.awt.Color(207, 202, 186));
        tblMeterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMeterialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMeterial);

        btnDelete.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        btnDelete.setText("Delete");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnSave.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edtShopNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtShopNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtShopNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tblMeterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMeterialMouseClicked
        int selectedRow = tblMeterial.getSelectedRow();
        if (selectedRow >= 0) {
            Material selectedMaterial = list.get(selectedRow);

            BillDetail billDetail = new BillDetail(-1, selectedMaterial.getName(), 1, 0.0f, selectedMaterial.getMatPricePerUnit(), selectedMaterial.getMatPricePerUnit(), bill.getId(), selectedMaterial.getId());

            bill.addBillDetail(billDetail);

            updateBillDetailTable();
        }
    }//GEN-LAST:event_tblMeterialMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField edtBuy;
    private javax.swing.JTextField edtDiscount;
    private javax.swing.JTextField edtShopName;
    private javax.swing.JTextField edtTotalprice;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddStock;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlDatePicker;
    private javax.swing.JTable tblBillDetail;
    private javax.swing.JTable tblMeterial;
    private javax.swing.JLabel txtBuy;
    private javax.swing.JLabel txtChange;
    private javax.swing.JLabel txtDiscount;
    private javax.swing.JLabel txtShopName;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JLabel txtTotalPrice;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables
}
