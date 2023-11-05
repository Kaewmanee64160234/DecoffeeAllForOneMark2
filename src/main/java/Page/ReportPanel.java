/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.ChagePage;
import Component.LoginObs;
import Model.CustomerReport;
import Model.MaterialReport;
import Model.RecieptDetailReport;
import Model.RecieptDetailWorstProduct;
import Model.RecieptReport;
import Model.User;
import Service.CustomerService;
import Service.MaterialService;
import Service.RecieptService;
import java.awt.BorderLayout;
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
import scrollbar.ScrollBarCustom;

/**
 *
 * @author toey
 */
public class ReportPanel extends javax.swing.JPanel implements LoginObs, ChagePage {

    private final CustomerService customerService;
    private final List<CustomerReport> customerList;

    private final MaterialService materialService;
    private final List<MaterialReport> materialList;

    private final RecieptService recieptDetailService;
    private final List<RecieptDetailReport> recieptDetailList;
    private final List<RecieptDetailWorstProduct> recieptDetailList2;

    private AbstractTableModel model;
    private AbstractTableModel model2;
    private AbstractTableModel model3;
    private AbstractTableModel model6;

    private UtilDateModel model4;
    private UtilDateModel model5;

    private DefaultCategoryDataset barDataset;
    private List<RecieptReport> reciept;
    private ArrayList<LoginObs> loginObses;
    private ArrayList<ChagePage> chagePages;

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
        recieptDetailList2 = recieptDetailService.getTopFiveWorstSellingProducts();

        chagePages = new ArrayList<>();
        loginObses = new ArrayList<>();

        reciept = new ArrayList<>();
        initTableCustomer();
        initTableMaterial();
        initTableTopSeller();
        initTableWorstProduct();
        initDatePicker();
        initBarChart();
        loadBarDataset();
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom());
    }

//    private void initBarChart() {
//        barDataset = new DefaultCategoryDataset();
//        JFreeChart chart = ChartFactory.createBarChart(
//                "Total Sale",
//                "Month Year",
//                "Total Income",
//                barDataset,
//                PlotOrientation.VERTICAL,
//                true, true, false);
//        ChartPanel chartPanel = new ChartPanel(chart);
//        pnlBarGraph.add(chartPanel);
//    }
    private void initBarChart() {
        barDataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart(
                "Total Sale",
                "Month Year",
                "Total Income",
                barDataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        pnlBarGraph.setLayout(new java.awt.BorderLayout());
        pnlBarGraph.add(chartPanel, BorderLayout.CENTER);
    }

    private void loadBarDataset() {
        barDataset.clear();
        for (RecieptReport r : reciept) {
            System.out.println("MonthYear: " + r.getMonthYear() + ", TotalSale: " + r.getTotalSale());
            barDataset.addValue(r.getTotalSale(), "Income", r.getMonthYear());
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

    private void initTableWorstProduct() {
        model6 = new AbstractTableModel() {
            String[] colNames = {"ID", "Name", "TotalQty"};

            @Override
            public String getColumnName(int column) {
                return colNames[column];
            }

            @Override
            public int getRowCount() {
                return recieptDetailList2.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                RecieptDetailWorstProduct recieptDetail2 = recieptDetailList2.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return recieptDetail2.getId();
                    case 1:
                        return recieptDetail2.getName();
                    case 2:
                        return recieptDetail2.getTotalQty();
                    default:
                        return "";
                }
            }
        };
        tblWorstProduct.setModel(model6);

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
        lblProductOutstock1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblWorstProduct = new javax.swing.JTable();
        jpnlHeader1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRole = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnComfirm.setBackground(new java.awt.Color(93, 156, 89));
        btnComfirm.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnComfirm.setForeground(new java.awt.Color(255, 255, 255));
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

        lblSaleSumGraph.setFont(new java.awt.Font("Kanit", 0, 20)); // NOI18N
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

        pnlDatePicker1.setBackground(new java.awt.Color(255, 255, 255));

        pnlDatePicker2.setBackground(new java.awt.Color(255, 255, 255));

        lblProductOutstock1.setFont(new java.awt.Font("Kanit", 0, 24)); // NOI18N
        lblProductOutstock1.setText("Top 5 Worst Product");

        tblWorstProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblWorstProduct);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBarGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTopCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTopSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductOutstock1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductOutstock, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSaleSumGraph)
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
                                .addComponent(btnComfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 354, Short.MAX_VALUE)))
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
                    .addComponent(btnComfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblStartDate)
                    .addComponent(pnlDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEndDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBarGraph, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTopCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTopSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductOutstock1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductOutstock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpnlHeader1.setBackground(new java.awt.Color(224, 205, 174));
        jpnlHeader1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpnlHeader1.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel1.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel1.setText("Dashboard");

        jLabel5.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel5.setText("User Name: ");

        txtUserName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtUserName.setText("Name");

        jLabel6.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel6.setText("Role:");

        txtRole.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtRole.setText("Role");

        javax.swing.GroupLayout jpnlHeader1Layout = new javax.swing.GroupLayout(jpnlHeader1);
        jpnlHeader1.setLayout(jpnlHeader1Layout);
        jpnlHeader1Layout.setHorizontalGroup(
            jpnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpnlHeader1Layout.setVerticalGroup(
            jpnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnlHeader1Layout.createSequentialGroup()
                        .addGroup(jpnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtUserName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtRole)))
                    .addComponent(jLabel1))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnlHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnComfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComfirmActionPerformed

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        System.out.println("" + formater.format(model4.getValue()) + " " + formater.format(model5.getValue()));
        String begin = formater.format(model4.getValue());
        String end = formater.format(model5.getValue());
        reciept = recieptDetailService.getRecieptByTotalSale(begin, end);
        System.out.println("Reciept List: " + reciept); // Add this line for debugging
        model.fireTableDataChanged();
        loadBarDataset();

    }//GEN-LAST:event_btnComfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpnlHeader1;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblProductOutstock;
    private javax.swing.JLabel lblProductOutstock1;
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
    private javax.swing.JTable tblWorstProduct;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loginData(User user) {
        for (LoginObs loginObse : loginObses) {
            loginObse.loginData(user);
        }
        txtUserName.setText(user.getUsername());
        txtRole.setText(user.getRole());
    }

    @Override
    public void chagePage(String pageName) {
        for (ChagePage chagePage : chagePages) {
            chagePage.chagePage(pageName);
        }
    }

    public void addInChangePage(ChagePage che) {
        chagePages.add(che);
    }

    public void loginObs(LoginObs logObs) {
        loginObses.add(logObs);
    }
}
