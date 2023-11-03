/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.ChagePage;
import Component.LoginObs;
import Dao.BillDao;
import Dao.BillDetailDao;
import Dao.MaterialDao;
import Model.Bill;
import Model.BillDetail;
import Model.Employee;
import Model.Material;
import Model.User;
import Service.EmployeeService;
import Service.MaterialService;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import scrollbar.ScrollBarCustom;

public class BuyStockPanel extends javax.swing.JPanel implements ChagePage, LoginObs {

    private final MaterialService materialService;
    private List<Material> list;
    private Material material;
    private UtilDateModel model1;
    private ArrayList<ChagePage> chagpages;
    private int selectedRowIndex;
    private ArrayList<LoginObs> loginObses;
    private Employee employee;
    private EmployeeService employService;
    private Bill bill;
    private boolean calculated = false;

    public BuyStockPanel(Employee emp) {
        initComponents();

        employee = emp;
        employService = new EmployeeService();
        bill = new Bill();
        bill.setEmployeeId(employee.getId());
        System.out.println("Create new Buy");
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        chagpages = new ArrayList<ChagePage>();
        initDatePicker();
        loginObses = new ArrayList<>();
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
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new Model.DateLabelFormatter());

        pnlDatePicker.add(datePicker1);

    }
    // setDate in Bill
//        Date selectedDate = (Date) datePicker1.getModel().getValue();
//        bill.setCreatdDate(selectedDate);

    private void updateBillDetailTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Amount");
        model.addColumn("Price");
        model.addColumn("Total");
        model.addColumn("Discount");

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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edtShopName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pnlDatePicker = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMeterial = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBillDetail = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edtDiscount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        edtBuy = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblChange = new javax.swing.JLabel();
        btnCalculate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("เพิ่ม Stock");

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel2.setText("Shop Name:");

        edtShopName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel3.setText("Date:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtShopName, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(pnlDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(467, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(edtShopName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMeterial.setFocusable(false);
        tblMeterial.setSelectionBackground(new java.awt.Color(213, 208, 189));
        tblMeterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMeterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMeterial);

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
        tblBillDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillDetailMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBillDetail);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel4.setText("Total Price:");

        lblTotalPrice.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel5.setText("Discount:");

        edtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtDiscountActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel6.setText("Total:");

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel7.setText("Buy:");

        jLabel8.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel8.setText("Change:");

        btnCalculate.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        btnCalculate.setText("Calculate");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(lblTotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtBuy, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(lblChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotalPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(edtBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(edtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(lblChange, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(21, 21, 21))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        btnDelete.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblBillDetail.getSelectedRow();

        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblBillDetail.getModel();
            int selectedMaterialId = (int) model.getValueAt(selectedRow, 0);
            BillDetail detailToRemove = null;
            for (BillDetail detail : bill.getBillDetails()) {
                if (detail.getMat_id() == selectedMaterialId) {
                    detailToRemove = detail;
                    break;
                }
            }
            if (detailToRemove != null) {
                bill.getBillDetails().remove(detailToRemove);
            }
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to delete first", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!calculated) {
            JOptionPane.showMessageDialog(this, "Please calculate first by clicking the 'Calculate' button.");
            return;
        }

        System.out.println("Start : " + bill.toString());
        System.out.println(employee.toString());

        String shopName = edtShopName.getText().trim();
        String buyText = edtBuy.getText().trim();
        String discountText = edtDiscount.getText().trim();

        if (shopName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a shop name.");
            return;
        }

        if (buyText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the buy amount.");
            return;
        }

        if (discountText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the discount.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblBillDetail.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please add items to the bill detail.");
            return;
        }

        BillDetailDao billDetailDao = new BillDetailDao();
        BillDao billDao = new BillDao();
        boolean saved = true;

// add bill
        bill.setShopname(shopName);
        Date selectedDate = model1.getValue();

        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Please select a date.");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(selectedDate);
        bill.setCreatdDate(formattedDate);
        System.out.println(formattedDate);

        float buyValue = Float.parseFloat(buyText);
        bill.setBuy(buyValue);

        float totaldiscountValue = Float.parseFloat(discountText);
        bill.setTotalDiscount(totaldiscountValue);

        String billtotalText = lblTotal.getText();
        float billtotalValue = Float.parseFloat(billtotalText);
        bill.setBillTotal(billtotalValue);

        String billchangText = lblChange.getText();
        float billchangValue = Float.parseFloat(billchangText);
        bill.setChange(billchangValue);

        int billtotalQty = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            int amount = Integer.parseInt(model.getValueAt(i, 2).toString());
            billtotalQty += amount;
        }

        System.out.println("Save :" + bill.toString());
        Bill savedBill = billDao.save(bill);

        if (savedBill == null) {
            saved = false;
        }

//add bill_detail
        for (int i = 0; i < model.getRowCount(); i++) {
            String name = model.getValueAt(i, 1).toString();
            int amount = Integer.parseInt(model.getValueAt(i, 2).toString());
            float price = Float.parseFloat(model.getValueAt(i, 3).toString());
            float total = Float.parseFloat(model.getValueAt(i, 4).toString());
            float discount = Float.parseFloat(model.getValueAt(i, 5).toString());
            int mat_id = Integer.parseInt(model.getValueAt(i, 0).toString());

            BillDetail billDetail = new BillDetail();
            billDetail.setName(name);
            billDetail.setAmount(amount);
            billDetail.setDiscount(discount);
            billDetail.setPrice(price);
            billDetail.setTotal(total - discount);
            billDetail.setMat_id(mat_id);
            billDetail.setBill_id(bill.getId());

            BillDetail savedBillDetail = billDetailDao.save(billDetail);

            if (savedBillDetail == null) {
                saved = false;
                break;
            }
        }

//updater materail
        MaterialDao materialDao = new MaterialDao();

        for (int i = 0; i < model.getRowCount(); i++) {
            int mat_id = Integer.parseInt(model.getValueAt(i, 0).toString());
            int amount = Integer.parseInt(model.getValueAt(i, 2).toString());

            Material material = materialDao.get(mat_id);

            if (material != null) {
                material.setMatQty(material.getMatQty() + amount);
                materialDao.update(material);
            }
        }

        if (saved) {
            JOptionPane.showMessageDialog(this, "Save successful");
            bill = new Bill();

            chagePage("Material");

            model.setRowCount(0);
            edtShopName.setText("");
            model1.setValue(null);
            edtBuy.setText("");
            edtDiscount.setText("");
            lblTotal.setText("0.00");
            lblChange.setText("0.00");
            lblTotalPrice.setText("0.00");
            calculated = false;
        } else {
            JOptionPane.showMessageDialog(this, "Save unsuccessful");
            System.out.println("Page.BuyStockPanel.btnSaveActionPerformed()");
            chagePage("Material");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        DefaultTableModel model = (DefaultTableModel) tblBillDetail.getModel();
        bill = new Bill();
        model.setRowCount(0);
        edtShopName.setText("");
        model1.setValue(null);
        edtBuy.setText("");
        edtDiscount.setText("");
        lblTotal.setText("0.00");
        lblChange.setText("0.00");
        lblTotalPrice.setText("0.00");
        calculated = false;
        chagePage("Material");

    }//GEN-LAST:event_btnCancelActionPerformed

    private void tblMeterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMeterialMouseClicked
        int selectedRow = tblMeterial.getSelectedRow();
        if (selectedRow >= 0) {
            Material selectedMaterial = list.get(selectedRow);

            boolean materialExistsInBill = false;
            for (BillDetail bd : bill.getBillDetails()) {
                if (bd.getMat_id() == selectedMaterial.getId()) {
                    int currentAmount = bd.getAmount();
                    float pricePerUnit = bd.getPrice();
                    currentAmount++;
                    bd.setAmount(currentAmount);
                    bd.setTotal(pricePerUnit * currentAmount);
                    materialExistsInBill = true;
                    break;
                }
            }

            if (!materialExistsInBill) {
                BillDetail billDetail = new BillDetail(-1, selectedMaterial.getName(), 1, 0.0f, selectedMaterial.getMatPricePerUnit(), selectedMaterial.getMatPricePerUnit(), bill.getId(), selectedMaterial.getId());
                bill.addBillDetail(billDetail);
            }
            updateBillDetailTable();
        }
    }//GEN-LAST:event_tblMeterialMouseClicked

    private void tblBillDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillDetailMouseClicked
        int selectedRow = tblBillDetail.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblBillDetail.getModel();
            int itemId = (int) model.getValueAt(selectedRow, 0);
            String itemName = (String) model.getValueAt(selectedRow, 1);
            int amount = (int) model.getValueAt(selectedRow, 2);
        }
    }//GEN-LAST:event_tblBillDetailMouseClicked

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed

        float totalMaterialPrice = 0.0f;

        for (BillDetail billDetail : bill.getBillDetails()) {
            totalMaterialPrice += billDetail.getTotal();
        }

        lblTotalPrice.setText(String.valueOf(totalMaterialPrice));

        String discountText = edtDiscount.getText().trim();
        String buyText = edtBuy.getText().trim();
        
        DefaultTableModel model = (DefaultTableModel) tblBillDetail.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please add items to the bill detail.");
            return;
        }
        
        if (discountText.isEmpty() || buyText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                float discount = Float.parseFloat(discountText);
                float totalAfterDiscount = totalMaterialPrice - discount;
                float buy = Float.parseFloat(buyText);

                if (buy < totalAfterDiscount) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid purchase amount", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    float change = buy - totalAfterDiscount;

                    if (totalAfterDiscount < 0) {
                        totalAfterDiscount = 0;
                        change = buy - totalAfterDiscount;
                    }

                    lblTotal.setText(String.valueOf(totalAfterDiscount));
                    lblChange.setText(String.valueOf(change));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }

        calculated = true;


    }//GEN-LAST:event_btnCalculateActionPerformed

    private void edtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDiscountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField edtBuy;
    private javax.swing.JTextField edtDiscount;
    private javax.swing.JTextField edtShopName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JPanel pnlDatePicker;
    private javax.swing.JTable tblBillDetail;
    private javax.swing.JTable tblMeterial;
    // End of variables declaration//GEN-END:variables

    @Override
    public void chagePage(String pageName) {
        for (ChagePage subscober : chagpages) {
            subscober.chagePage(pageName);

        }
    }

    public void addInSubs(ChagePage chagePage) {
        chagpages.add(chagePage);
    }

    @Override
    public void loginData(User user) {

        System.out.println("Page.BuyStockPanel.loginData() " + user.toString());

        this.employee = this.employService.getById(user.getEmployee_id()); // Set the 'employee' property, not 'editedEmployee'

        System.out.println("set: " + employee.toString());
        this.bill.setEmployeeId(this.employee.getId());
        this.bill.setBuy(1000000);
        System.out.println(bill.toString());
    }

    public void addInLoginObs(LoginObs loginObs) {
        loginObses.add(loginObs);
    }

}
