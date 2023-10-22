package Page;

import Component.ChagePage;
import Model.BillDetail;
import Model.CheckMaterial;
import Model.CheckMaterialDetail;
import Service.BillDetailService;
import Service.CheckMaterialDetailService;
import Service.CheckMaterialService;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import scrollbar.ScrollBarCustom;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class HistoryCheckStockPanel extends javax.swing.JPanel {

    private final CheckMaterialDetailService checkMaterialDetailService;
    private List<CheckMaterialDetail> list;
    private CheckMaterialDetail editedCheckMaterialDetail;
    CheckMaterialDetail checkMaterialDetail;

    private final CheckMaterialService checkMaterialService;
    private List<CheckMaterial> listCM;
    private CheckMaterial editedCheckMaterial;
    private UtilDateModel model1, model2;
    private ArrayList<ChagePage> chagpages;

    public HistoryCheckStockPanel() {
        initComponents();
        initDatePicker();
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom());

        checkMaterialDetailService = new CheckMaterialDetailService();
        checkMaterialService = new CheckMaterialService();
        checkMaterialDetail = new CheckMaterialDetail();

        list = checkMaterialDetailService.getCheckMaterialDetails();
        listCM = checkMaterialService.getCheckMaterials();

        tblDateHistory.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
        tblDateHistory.setRowHeight(30);
        tblDateHistory.setModel(new AbstractTableModel() {
            String[] columnNames = {"No.", "Date History"};

            @Override
            public int getRowCount() {
                return listCM.size();
            }

            @Override
            public int getColumnCount() {
                return columnNames.length;
            }

            @Override
            public String getColumnName(int column) {
                return columnNames[column];

            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                CheckMaterial checkMaterial = listCM.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return checkMaterial.getId();
                    case 1:
                        return checkMaterial.getCmDate();
                    default:
                        return null;
                }
            }
        });

        tblDateHistory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int selectedRow = tblDateHistory.getSelectedRow();
                if (selectedRow >= 0) {
                    String selectedDate = (String) tblDateHistory.getValueAt(selectedRow, 1); // Assuming column index 1 contains the date
                    List<CheckMaterialDetail> cmdForDate = checkMaterialDetailService.getCheckMaterialDetailForDate(selectedDate);

                    System.out.println(cmdForDate);
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("ID");
                    model.addColumn("Name");
                    model.addColumn("Qty Last");
                    model.addColumn("Qty Remain");
                    model.addColumn("Total");
                    model.addColumn("Discount");

                    int totalAmount = 0;
                    for (CheckMaterialDetail cmd : cmdForDate) {
                        Object[] rowData = {
                            cmd.getId(),
                            cmd.getName(),
                            cmd.getLastQty(),
                            cmd.getQty(),
                            cmd.getMaterialId(),
                            cmd.getCheckMaterialId()
                        };
                        model.addRow(rowData);
                    }

                    tblHistoryStock.setModel(model);
                }
            }
        });

    }

    private void initDatePicker() {
        model1 = new UtilDateModel();
        Properties p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new Model.DateLabelFormatter());
        pnlDatePicker1.add(datePicker1);
        model1.setSelected(true);

        model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new Model.DateLabelFormatter());
        pnlDatePicker2.add(datePicker2);
        model2.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        lblStartDate1 = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        pnlDatePicker1 = new javax.swing.JPanel();
        pnlDatePicker2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDateHistory = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHistoryStock = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel3.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel3.setText("History CheckStock");

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblStartDate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStartDate1.setText("To Date :");

        lblStartDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStartDate.setText("From Date :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(527, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStartDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStartDate1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(pnlDatePicker2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatePicker1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStartDate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblStartDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        tblDateHistory.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblDateHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tblDateHistory);

        tblHistoryStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane3.setViewportView(tblHistoryStock);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        System.out.println("" + formater.format(model1.getValue()) + "" + formater.format(model2.getValue()));
        String begin = formater.format(model1.getValue());
        String end = formater.format(model2.getValue());
        listCM = checkMaterialService.getDateBetween(begin, end);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        chagePage("Material");
    }//GEN-LAST:event_btnBackActionPerformed
    public void chagePage(String pageName) {
        for (ChagePage subscober : chagpages) {
            subscober.chagePage(pageName);
        }
    }
    private void edtDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDatePicker1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDatePicker1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblStartDate1;
    private javax.swing.JPanel pnlDatePicker1;
    private javax.swing.JPanel pnlDatePicker2;
    private javax.swing.JTable tblDateHistory;
    private javax.swing.JTable tblHistoryStock;
    // End of variables declaration//GEN-END:variables
}
