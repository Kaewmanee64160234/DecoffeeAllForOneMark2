/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Model.CustomerReport;
import Model.MaterialReport;
import Model.RecieptDetailReport;
import Model.RecieptReport;
import Service.CustomerService;
import Service.MaterialService;
import Service.RecieptService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.table.AbstractTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author toey
 */
public class ReportPanel extends javax.swing.JPanel {

    private final CustomerService customerService;
    private final List<CustomerReport> customerList;
    private AbstractTableModel model;
    private final MaterialService materialService;
    private final List<MaterialReport> materialList;
    private AbstractTableModel model2;
    private final RecieptService recieptDetailService;
    private final List<RecieptDetailReport> recieptDetailList;
    private AbstractTableModel model3;
    private UtilDateModel model4;
    private UtilDateModel model5;
    private DefaultCategoryDataset barDataset;
    private List<RecieptReport> reciept;

    /**
     * Creates new form ReportPanel
     */
    public ReportPanel() {
        initComponents();
        customerService = new CustomerService();
        customerList = customerService.getTopFiveCustomerByTotalPrice();
        materialService = new MaterialService();
        materialList = materialService.getMaterialByMinQty();
        recieptDetailService = new RecieptService();
        recieptDetailList = recieptDetailService.getTopTenProductSale();

        reciept = new ArrayList<>();
        initTableCustomer();
        initTableMaterial();
        initTableTopSeller();
        initDatePicker();
        initBarChart();
        loadBarDataset();
    }

    private void initBarChart() {
        barDataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart(
                "Total Sale",
                "Store Name",
                "Total Income",
                barDataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        pnlBarGraph.add(chartPanel);
    }

    private void loadBarDataset() {
        barDataset.clear();
            for (RecieptReport r : reciept) {
                barDataset.setValue(r.getTotalSale(), "Income", r.getStoreName());
            }
    }

    private void initDatePicker() {
        model4 = new UtilDateModel();
        Properties p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model4, p1);
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
        pnlDatePicker1.add(datePicker1);
        model4.setSelected(true);

        model5 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model5, p2);
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        pnlDatePicker2.add(datePicker2);
        model5.setSelected(true);
    }

    private void initTableTopSeller() {
        model3 = new AbstractTableModel() {
            String[] colNames = {"ID", "Name", "TotalQty"};

            @Override
            public String getColumnName(int column) {
                return colNames[column];
            }

            @Override
            public int getRowCount() {
                return recieptDetailList.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                RecieptDetailReport recieptDetail = recieptDetailList.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return recieptDetail.getId();
                    case 1:
                        return recieptDetail.getName();
                    case 2:
                        return recieptDetail.getTotalQty();

                    default:
                        return "";
                }
            }
        };
        tblTopSeller.setModel(model3);
    }

    private void initTableMaterial() {
        model2 = new AbstractTableModel() {
            String[] colNames = {"ID", "Name", "Quantity"};

            @Override
            public String getColumnName(int column) {
                return colNames[column];
            }

            @Override
            public int getRowCount() {
                return materialList.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                MaterialReport material = materialList.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return material.getId();
                    case 1:
                        return material.getName();
                    case 2:
                        return material.getQuantity();

                    default:
                        return "";
                }
            }
        };
        tblProductOutStock.setModel(model2);
    }

    private void initTableCustomer() {
        model = new AbstractTableModel() {
            String[] colNames = {"ID", "Name", "TotalSpend"};

            @Override
            public String getColumnName(int column) {
                return colNames[column];
            }

            @Override
            public int getRowCount() {
                return customerList.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                CustomerReport customer = customerList.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return customer.getId();
                    case 1:
                        return customer.getName();
                    case 2:
                        return customer.getTotalSpend();

                    default:
                        return "";
                }
            }
        };
        tblTopCustomer.setModel(model);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnComfirm = new javax.swing.JButton();
        lblEndDate = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        pnlBarGraph = new javax.swing.JPanel();
        lblSaleSumGraph = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTopCustomer = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTopSeller = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductOutStock = new javax.swing.JTable();
        lblTopCustomer = new javax.swing.JLabel();
        lblTopSeller = new javax.swing.JLabel();
        lblProductOutstock = new javax.swing.JLabel();
        pnlDatePicker1 = new javax.swing.JPanel();
        pnlDatePicker2 = new javax.swing.JPanel();

        jPanel2.setBackground(new java.awt.Color(213, 208, 189));

        jLabel1.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel1.setText("Report");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel3.setBackground(new java.awt.Color(170, 183, 173));

        btnComfirm.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnComfirm.setText("Confirm");
        btnComfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComfirmActionPerformed(evt);
            }
        });

        lblEndDate.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblEndDate.setText("End Date:");

        lblStartDate.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblStartDate.setText("Start Date:");

        lblSaleSumGraph.setFont(new java.awt.Font("Kanit", 0, 24)); // NOI18N
        lblSaleSumGraph.setText("Sales summary graph");

        tblTopCustomer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTopCustomer);

        tblTopSeller.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblTopSeller);

        tblProductOutStock.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblProductOutStock);

        lblTopCustomer.setFont(new java.awt.Font("Kanit", 0, 24)); // NOI18N
        lblTopCustomer.setText("Top 5 Customer");

        lblTopSeller.setFont(new java.awt.Font("Kanit", 0, 24)); // NOI18N
        lblTopSeller.setText("Top 10 Best Seller");

        lblProductOutstock.setFont(new java.awt.Font("Kanit", 0, 24)); // NOI18N
        lblProductOutstock.setText("Product Out Of Stock");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBarGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblStartDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(lblEndDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnComfirm))
                    .addComponent(lblSaleSumGraph)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(lblTopCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(lblTopSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(lblProductOutstock, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSaleSumGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDatePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnComfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStartDate)
                    .addComponent(pnlDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEndDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBarGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblProductOutstock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTopSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTopCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnComfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComfirmActionPerformed
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        System.out.println("" + formater.format(model4.getValue()) + " " + formater.format(model5.getValue()));
        String begin = formater.format(model4.getValue());
        String end = formater.format(model5.getValue());
        reciept = recieptDetailService.getRecieptByTotalSale(begin, end);
        model.fireTableDataChanged();
        loadBarDataset();

    }//GEN-LAST:event_btnComfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblProductOutstock;
    private javax.swing.JLabel lblSaleSumGraph;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblTopCustomer;
    private javax.swing.JLabel lblTopSeller;
    private javax.swing.JPanel pnlBarGraph;
    private javax.swing.JPanel pnlDatePicker1;
    private javax.swing.JPanel pnlDatePicker2;
    private javax.swing.JTable tblProductOutStock;
    private javax.swing.JTable tblTopCustomer;
    private javax.swing.JTable tblTopSeller;
    // End of variables declaration//GEN-END:variables
}
