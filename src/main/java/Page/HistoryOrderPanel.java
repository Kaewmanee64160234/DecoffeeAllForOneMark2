package Page;

import Component.ChagePage;
import Component.sentDate;
import Dialog.SelectDateForPrintReport;
import Model.Bill;
import Model.RecieptDetail;
import Model.DateLabelFormatter;
import Model.HistoryOrderReport;
import Service.RecieptDetailService;
import Service.RecieptService;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import net.sf.jasperreports.engine.JRException;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import print.ReportSS;
import print.ReportSaleIncome;
import scrollbar.ScrollBarCustom;

/**
 *
 * @Dang Double H
 */
public class HistoryOrderPanel extends javax.swing.JPanel implements ChagePage, sentDate {

    private final RecieptService recieptService;
    private List<HistoryOrderReport> recieptList;

    private final RecieptDetailService recieptDetailService;
    private List<RecieptDetail> recieptDetailList;

    private UtilDateModel model1;
    private UtilDateModel model2;
    private AbstractTableModel model3;
    private ArrayList<ChagePage> chagpages;
    private String date;
    private SelectDateForPrintReport selectDateForPrintReport;

    public HistoryOrderPanel() {
        initComponents();
        chagpages = new ArrayList<ChagePage>();
        recieptService = new RecieptService();
        recieptList = recieptService.getRecieptHistory();
        recieptDetailService = new RecieptDetailService();
        recieptDetailList = recieptDetailService.getRecieptDetails();
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        selectDateForPrintReport = new SelectDateForPrintReport(frame, true);
        initTableBill();
        initDatePicker();
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());

    }

    private void initTableBill() {
        model3 = new AbstractTableModel() {
            String[] colNames = {"ID", "Date History", "Total"};

            @Override
            public String getColumnName(int column) {
                return colNames[column];
            }

            @Override
            public int getRowCount() {
                return recieptList.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                HistoryOrderReport reciept = recieptList.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return reciept.getId();
                    case 1:
                        return reciept.getCreated_date();
                    case 2:
                        return reciept.getTotal();
                    default:
                        return "";
                }
            }
        };
        tblDateOrder.setModel(model3);
        tblDateOrder.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 16));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelHis = new javax.swing.JPanel();
        lblStartDate = new javax.swing.JLabel();
        pnlDatePicker1 = new javax.swing.JPanel();
        lblStartDate1 = new javax.swing.JLabel();
        pnlDatePicker2 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDateOrder = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnSubmit1 = new javax.swing.JButton();
        jPanelDetail = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderInDate = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        lblTotalShow = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(224, 205, 174));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel1.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel1.setText("History Order");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelHis.setBackground(new java.awt.Color(255, 255, 255));

        lblStartDate.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblStartDate.setText("Date:");

        pnlDatePicker1.setBackground(new java.awt.Color(255, 255, 255));

        lblStartDate1.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblStartDate1.setText("To Date:");

        pnlDatePicker2.setBackground(new java.awt.Color(255, 255, 255));

        btnSubmit.setBackground(new java.awt.Color(33, 156, 144));
        btnSubmit.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        tblDateOrder.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        tblDateOrder.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDateOrder.setSelectionBackground(new java.awt.Color(213, 208, 189));
        tblDateOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDateOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDateOrder);

        jLabel2.setFont(new java.awt.Font("Kanit", 0, 20)); // NOI18N
        jLabel2.setText("History");

        btnSubmit1.setBackground(new java.awt.Color(247, 140, 162));
        btnSubmit1.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnSubmit1.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit1.setText("Print");
        btnSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHisLayout = new javax.swing.GroupLayout(jPanelHis);
        jPanelHis.setLayout(jPanelHisLayout);
        jPanelHisLayout.setHorizontalGroup(
            jPanelHisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHisLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelHisLayout.createSequentialGroup()
                        .addComponent(lblStartDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblStartDate1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSubmit))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelHisLayout.setVerticalGroup(
            jPanelHisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelHisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHisLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblStartDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelHisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pnlDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelHisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDatePicker1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHisLayout.createSequentialGroup()
                                .addComponent(lblStartDate1)
                                .addGap(8, 8, 8)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelDetail.setBackground(new java.awt.Color(255, 255, 255));

        tblOrderInDate.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        tblOrderInDate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Amount", "Price", "Total", "Discount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrderInDate.setSelectionBackground(new java.awt.Color(213, 208, 189));
        jScrollPane2.setViewportView(tblOrderInDate);

        lblTotal.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblTotal.setText("Total:");

        lblTotalShow.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblTotalShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalShow.setText("0");

        jLabel3.setFont(new java.awt.Font("Kanit", 0, 20)); // NOI18N
        jLabel3.setText("Detail");

        javax.swing.GroupLayout jPanelDetailLayout = new javax.swing.GroupLayout(jPanelDetail);
        jPanelDetail.setLayout(jPanelDetailLayout);
        jPanelDetailLayout.setHorizontalGroup(
            jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                    .addGroup(jPanelDetailLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDetailLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTotal)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalShow, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDetailLayout.setVerticalGroup(
            jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblTotalShow))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                    .addComponent(jPanelHis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelHis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void tblDateOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDateOrderMouseClicked

        int selectedRow = tblDateOrder.getSelectedRow();
        int selectedId = (int) tblDateOrder.getValueAt(selectedRow, 0);

        System.out.println(selectedId);
        if (selectedRow >= 0) {
            List<RecieptDetail> recieptDetailsForDate = recieptDetailService.getrDetailsByReciptId(selectedId);

            System.out.println(recieptDetailsForDate);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Qty");
            model.addColumn("Price");
            model.addColumn("Total Price");
            model.addColumn("Type");
            model.addColumn("Type Price");
            model.addColumn("Size");
            model.addColumn("Size Price");
            model.addColumn("Topping");
            model.addColumn("Topping Price");
            model.addColumn("Product Id");
            model.addColumn("Reciept Id");

            int totalAmount = 0;
            for (RecieptDetail rd : recieptDetailsForDate) {
                Object[] rowData = {
                    rd.getId(),
                    rd.getName(),
                    rd.getQty(),
                    rd.getPrice(),
                    rd.getTotal(),
                    rd.getType(),
                    rd.getTypePrice(),
                    rd.getSize(),
                    rd.getSizePrice(),
                    rd.getTopping(),
                    rd.getToppingPrice(),
                    rd.getProductId(),
                    rd.getRecieptId()
                };
                model.addRow(rowData);

                totalAmount += rd.getTotal();
            }
            tblOrderInDate.setModel(model);
            tblOrderInDate.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 16));
            lblTotalShow.setText(String.valueOf(totalAmount));
        }
        
    }//GEN-LAST:event_tblDateOrderMouseClicked

    private void btnSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit1ActionPerformed
        // TODO add your handling code here:
        selectDateForPrintReport.addinDate(this);
        selectDateForPrintReport.setLocationRelativeTo(this); //set dialog to center
        selectDateForPrintReport.setVisible(true);
        selectDateForPrintReport.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    if (date != "") {
                        ReportSaleIncome.getInstance().complieReport();
                        ReportSaleIncome.getInstance().printReport(date);
                    }
                } catch (JRException ex) {
                    Logger.getLogger(SalaryPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }//GEN-LAST:event_btnSubmit1ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        System.out.println("" + formater.format(model1.getValue()) + " " + formater.format(model2.getValue()));
        String begin = formater.format(model1.getValue());
        String end = formater.format(model2.getValue());
        recieptList = recieptService.getRecieptHistory(begin, end);
        System.out.println(recieptList);
        model3.fireTableDataChanged();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmit1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDetail;
    private javax.swing.JPanel jPanelHis;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblStartDate1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalShow;
    private javax.swing.JPanel pnlDatePicker1;
    private javax.swing.JPanel pnlDatePicker2;
    private javax.swing.JTable tblDateOrder;
    private javax.swing.JTable tblOrderInDate;
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
    public void sentDate(String date) {
        this.date = date;
    }

}
