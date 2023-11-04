package Page;

import Component.ChagePage;
import Model.Bill;
import Model.RecieptDetail;
import Model.DateLabelFormatter;
import Model.HistoryOrderReport;
import Service.RecieptDetailService;
import Service.RecieptService;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import scrollbar.ScrollBarCustom;

/**
 *
 * @Dang Double H
 */
public class HistoryOrderPanel extends javax.swing.JPanel implements ChagePage {

    private final RecieptService recieptService;
    private List<HistoryOrderReport> recieptList;

    private final RecieptDetailService recieptDetailService;
    private List<RecieptDetail> recieptDetailList;

    private UtilDateModel model1;
    private UtilDateModel model2;
    private AbstractTableModel model3;
    private ArrayList<ChagePage> chagpages;

    public HistoryOrderPanel() {
        initComponents();
        recieptService = new RecieptService();
        recieptList = recieptService.getRecieptHistory();
        recieptDetailService = new RecieptDetailService();
        recieptDetailList = recieptDetailService.getRecieptDetails();
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
        pnlDatePicker1 = new javax.swing.JPanel();
        lblStartDate = new javax.swing.JLabel();
        lblStartDate1 = new javax.swing.JLabel();
        pnlDatePicker2 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDateOrder = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderInDate = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        lblTotalShow = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(195, 176, 145));

        lblStartDate.setText("Date:");

        lblStartDate1.setText("To Date:");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel3.setText("History Order");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lblStartDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblStartDate1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnSubmit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(pnlDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStartDate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblStartDate1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(28, 28, 28))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 251, 245));

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
        tblDateOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDateOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDateOrder);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(195, 176, 145));

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
        jScrollPane2.setViewportView(tblOrderInDate);

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setText("Total:");

        lblTotalShow.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalShow.setText("0");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalShow, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTotal)
                        .addComponent(lblTotalShow))
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void tblDateOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDateOrderMouseClicked

        int selectedRow = tblDateOrder.getSelectedRow();
        if (selectedRow >= 0) {
            String selectedDate = (String) tblDateOrder.getValueAt(selectedRow, 1); // Assuming column index 1 contains the date
            List<RecieptDetail> recieptDetailsForDate = recieptDetailService.getRecieptDetailForDate(selectedDate);

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
            lblTotalShow.setText(String.valueOf(totalAmount));
        }


    }//GEN-LAST:event_tblDateOrderMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        chagePage("Material");
    }//GEN-LAST:event_btnBackActionPerformed

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
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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

}
