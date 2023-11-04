/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.ChagePage;
import Component.changePageSummary;
import Dialog.PrintSlipDialog;
import Dialog.ProductDialog;
import Model.Employee;
import Model.EmployeeReport;
import Model.Product;
import Model.SummarySalary;
import Service.EmployeeService;
import Service.SummarySalaryService;
import TablebtnEditDelete.TableActionCellRenderer;
import com.mycompany.decoffeeallforone.MainFrame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import javax.swing.table.AbstractTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import selectInTable.TableActionCellRender;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author ASUS
 */
public class SalaryPanel extends javax.swing.JPanel implements changePageSummary, ChagePage {

    private Product editedProduct;
    private Employee editedEmployee;
    private ArrayList<Employee> list;
    private ArrayList<changePageSummary> subs;
    private ArrayList<ChagePage> chagePages = new ArrayList<>();
    private UtilDateModel model1;
    private UtilDateModel model2;
    private EmployeeService employeeService;
    private List<EmployeeReport> employeeList;
    private AbstractTableModel model3;
    private DefaultCategoryDataset barDataset;
    private List<SummarySalary> salary;
    private  SummarySalaryService summarySalaryService = new SummarySalaryService();
    private historyPageSummaySalary hisPageSummaySalary_ = new historyPageSummaySalary();
    private TableSalaryPanel tableSalaryPanel ;

    /**
     * Creates new form SalaryPanel
     */
    public SalaryPanel() {
        initComponents();
        salary = new ArrayList<>(); 
        initDatePicker();
        initBarChart();
        loadBarDataset();
        initTableEmployee();
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane4.setVerticalScrollBar(new ScrollBarCustom());
        employeeService = new EmployeeService();
        editedEmployee = new Employee();
        tableSalaryPanel = new TableSalaryPanel(editedEmployee);
        tableSalaryPanel.addInChagePage(this);
        list = new ArrayList<>();
        subs = new ArrayList<>();
        employeeList = new ArrayList<>();
        

        list = (ArrayList<Employee>) employeeService.getEmployees();

        selectInTable.TableActionEvent event = new selectInTable.TableActionEvent() {

            @Override
            public void onSelect(int row) {
                chagePageEmp(list.get(row), "SS Emp");
            }
        };

        employeeService = new EmployeeService();

        list = (ArrayList<Employee>) employeeService.getEmployees();
        tblSalary.setRowHeight(60);
        tblSalary.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 14));
        tblSalary.setModel(new AbstractTableModel() {
            String[] columnNames = {"Profile", "ID", "Name", "Address", "Telephone", "Email", "Position", "Hourly wage", "Action"};

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
                return 9;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return ImageIcon.class;
                    default:
                        return String.class;
                }
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Employee employee = list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        ImageIcon icon = new ImageIcon("./employee" + employee.getId() + ".png");
                        Image image = icon.getImage();
                        int width = image.getWidth(null);
                        int height = image.getHeight(null);
                        Image newImage = image.getScaledInstance((int) (50 * ((float) width) / height), 50, Image.SCALE_SMOOTH);
                        icon.setImage(newImage);
                        return icon;
                    case 1:
                        return employee.getId();
                    case 2:
                        return employee.getName();
                    case 3:
                        return employee.getAddress();
                    case 4:
                        return employee.getTelephone();
                    case 5:
                        return employee.getEmail();
                    case 6:
                        return employee.getPosition();
                    case 7:
                        return employee.getHourlyWage();
                    case 8:
                        return new TableActionCellRenderer();
                    default:
                        return "Unknown";
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                if (columnIndex == 8) {
                    return true;
                }
                return false;
            }

        });
        tblSalary.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
        tblSalary.getColumnModel().getColumn(8).setCellEditor(new selectInTable.TableActionCellEditor(event));
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane4.setVerticalScrollBar(new ScrollBarCustom());

    }

    private void initBarChart() {
        barDataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart(
                "Total Paid",
                "Month Year",
                "Total expenses",
                barDataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        pnlBarGraph.setLayout(new java.awt.BorderLayout());
        pnlBarGraph.add(chartPanel, BorderLayout.CENTER);
    }

    private void loadBarDataset() {
        barDataset.clear();
        for (SummarySalary ss : salary) {
            System.out.println("MonthYear: " + ss.getMonthYear() + ", TotalPaid: " + ss.getTotalPaid());
            barDataset.addValue(ss.getTotalPaid(), "expenses", ss.getMonthYear());
        }
    }

    private void initDatePicker() {
        model1 = new UtilDateModel();
        Properties p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
        pnlDatePicker1.add(datePicker1);
        model1.setSelected(true);

        model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        pnlDatePicker2.add(datePicker2);
        model2.setSelected(true);
    }

    private void initTableEmployee() {
        model3 = new AbstractTableModel() {
            String[] colNames = {"ID", "Name", "MonthYear", "TotalEmployee"};

            @Override
            public String getColumnName(int column) {
                return colNames[column];
            }

            @Override
            public int getRowCount() {
                return employeeList.size();
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                EmployeeReport employee = employeeList.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return employee.getId();
                    case 1:
                        return employee.getName();
                    case 2:
                        return employee.getMonthYear();
                    case 3:
                        return employee.getTopEmployee();

                    default:
                        return "";
                }
            }
        };
        tblTopEmployee.setModel(model3);
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
        pnlNavigation2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTopEmployee = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSalary = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        pnlDatePicker1 = new javax.swing.JPanel();
        lblEndDate = new javax.swing.JLabel();
        pnlDatePicker2 = new javax.swing.JPanel();
        btnComfirm = new javax.swing.JButton();
        pnlBarGraph = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnPrint = new javax.swing.JButton();
        btnPaymentHistory = new javax.swing.JButton();

        pnlNavigation2.setBackground(new java.awt.Color(255, 251, 245));

        tblTopEmployee.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblTopEmployee);

        jLabel3.setFont(new java.awt.Font("Kanit", 0, 24)); // NOI18N
        jLabel3.setText("Salary");

        tblSalary.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblSalary);

        jLabel4.setText("TopGoodEmployee");

        jLabel5.setText("SalaryTable");

        lblStartDate.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblStartDate.setText("Start Date:");

        lblEndDate.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblEndDate.setText("End Date:");

        btnComfirm.setBackground(new java.awt.Color(213, 208, 189));
        btnComfirm.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnComfirm.setForeground(new java.awt.Color(103, 93, 80));
        btnComfirm.setText("Confirm");
        btnComfirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(103, 93, 80)));
        btnComfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBarGraphLayout = new javax.swing.GroupLayout(pnlBarGraph);
        pnlBarGraph.setLayout(pnlBarGraphLayout);
        pnlBarGraphLayout.setHorizontalGroup(
            pnlBarGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );
        pnlBarGraphLayout.setVerticalGroup(
            pnlBarGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlNavigation2Layout = new javax.swing.GroupLayout(pnlNavigation2);
        pnlNavigation2.setLayout(pnlNavigation2Layout);
        pnlNavigation2Layout.setHorizontalGroup(
            pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavigation2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNavigation2Layout.createSequentialGroup()
                        .addGap(0, 95, Short.MAX_VALUE)
                        .addComponent(lblStartDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(lblEndDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnComfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNavigation2Layout.createSequentialGroup()
                        .addGroup(pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlNavigation2Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlBarGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlNavigation2Layout.setVerticalGroup(
            pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNavigation2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNavigation2Layout.createSequentialGroup()
                        .addGroup(pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnComfirm)
                            .addComponent(lblStartDate)
                            .addComponent(lblEndDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlDatePicker2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlDatePicker1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBarGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(195, 176, 145));

        btnPrint.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnPaymentHistory.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        btnPaymentHistory.setText("Payment history");
        btnPaymentHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPaymentHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrint)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPaymentHistory)
                    .addComponent(btnPrint))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlNavigation2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnlNavigation2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnPaymentHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentHistoryActionPerformed
        chagePage("History ss");
    }//GEN-LAST:event_btnPaymentHistoryActionPerformed

    private void btnComfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComfirmActionPerformed

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        System.out.println("" + formater.format(model1.getValue()) + " " + formater.format(model2.getValue()));
        String begin = formater.format(model1.getValue());
        String end = formater.format(model2.getValue());
        employeeList = employeeService.getEmployeeByTotalHour(begin, end);
        salary = summarySalaryService.getSummarySalaryByTotalPaid(begin, end);
        model3.fireTableDataChanged();
        loadBarDataset();
    }//GEN-LAST:event_btnComfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComfirm;
    private javax.swing.JButton btnPaymentHistory;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JPanel pnlBarGraph;
    private javax.swing.JPanel pnlDatePicker1;
    private javax.swing.JPanel pnlDatePicker2;
    private javax.swing.JPanel pnlNavigation2;
    private javax.swing.JTable tblSalary;
    private javax.swing.JTable tblTopEmployee;
    // End of variables declaration//GEN-END:variables

    @Override
    public void chagePageEmp(Employee emp, String pageName) {
        for (changePageSummary sub : subs) {
            sub.chagePageEmp(emp, pageName);

        }
    }

    public void addInSubs(changePageSummary aThis) {
        subs.add(aThis);
    }

    public void addInChagePage(ChagePage ch) {
        chagePages.add(ch);
    }

    @Override
    public void chagePage(String pageName) {
        for (ChagePage chagePage : chagePages) {
            chagePage.chagePage(pageName);

        }
    }

}
