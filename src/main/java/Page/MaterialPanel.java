/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.ChagePage;
import Component.LoginObs;
import Component.changePageSummary;
import Component.sentDate;
import Dialog.MaterialDialog;
import Dialog.SelectDateForPrintReport;
import Model.Material;
import Model.User;
import Service.MaterialService;
import TablebtnEditDelete.TableActionCellEditor;
import TablebtnEditDelete.TableActionCellRenderer;
import TablebtnEditDelete.TableActionEvent;
import scrollbar.ScrollBarCustom;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import net.sf.jasperreports.engine.JRException;
import print.ReportCheckStock;
import print.ReportOutOfStock;
import print.ReportSaleIncome;

/**
 *
 * @author toey
 */
public class MaterialPanel extends javax.swing.JPanel implements ChagePage, LoginObs, DataUpdateObserver,sentDate {

    private final MaterialService materialService;
    private List<Material> list;
    private Material editedMaterial;
    private ArrayList<ChagePage> chagePages = new ArrayList<>();
    private String date = "";
    private SelectDateForPrintReport selectDateForPrintReport;

    /**
     * Creates new form UserPanel
     */
    public MaterialPanel() {
        initComponents();
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        selectDateForPrintReport = new SelectDateForPrintReport(frame, true);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int selectIndex = tblMaterial.getSelectedRow();
                if (selectIndex >= 0) {
                    editedMaterial = list.get(selectIndex);
                    openDialog();
                }
            }

            private void refreshTable() {
                list = materialService.getMaterials();
                tblMaterial.revalidate();
                tblMaterial.repaint();

            }

            @Override
            public void onDelete(int row) {
                int selectIndex = tblMaterial.getSelectedRow();
                if (selectIndex >= 0) {
                    editedMaterial = list.get(selectIndex);
                    int input = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Select an Option...",
                            JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (input == 0) {
                        materialService.delete(editedMaterial);
                    }
                    refreshTable();
                }
            }
        };

        materialService = new MaterialService();

        list = materialService.getMaterials();
        tblMaterial.setRowHeight(50);
        tblMaterial.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 16));
        tblMaterial.setModel(new AbstractTableModel() {
            String[] columnNames = {"ID", "Date", "Minimum Quantity", "Quantity", "Unit", "Price Per Unit", "Action"};

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
                return 7;
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
                Material material = list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return material.getId();
                    case 1:
                        return material.getName();
                    case 2:
                        return material.getMatMinQty();
                    case 3:
                        return material.getMatQty();
                    case 4:
                        return material.getMatUnit();
                    case 5:
                        return material.getMatPricePerUnit();
                    case 6:
                        return new TableActionCellRenderer();
                    default:
                        return "Unknown";
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                if (columnIndex == 6) {
                    return true;
                }
                return false;
            }

        });
        tblMaterial.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRenderer());
        tblMaterial.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHead = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRole = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaterial = new javax.swing.JTable();
        btnHisMat = new javax.swing.JButton();
        btnCheckStock = new javax.swing.JButton();
        btnBuyStock = new javax.swing.JButton();
        btnReportStock = new javax.swing.JButton();
        btnExpense = new javax.swing.JButton();
        btnOutOfStock = new javax.swing.JButton();

        jPanelHead.setBackground(new java.awt.Color(224, 205, 174));
        jPanelHead.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelHead.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel2.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel2.setText("Material");

        jLabel5.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel5.setText("User Name: ");

        txtUserName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtUserName.setText("Name");

        jLabel6.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel6.setText("Role:");

        txtRole.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtRole.setText("Role");

        javax.swing.GroupLayout jPanelHeadLayout = new javax.swing.GroupLayout(jPanelHead);
        jPanelHead.setLayout(jPanelHeadLayout);
        jPanelHeadLayout.setHorizontalGroup(
            jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelHeadLayout.setVerticalGroup(
            jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeadLayout.createSequentialGroup()
                .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHeadLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtUserName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtRole)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setBackground(new java.awt.Color(66, 133, 91));
        btnAdd.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblMaterial.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        tblMaterial.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMaterial.setSelectionBackground(new java.awt.Color(213, 208, 189));
        tblMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMaterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMaterial);

        btnHisMat.setBackground(new java.awt.Color(83, 113, 136));
        btnHisMat.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnHisMat.setForeground(new java.awt.Color(255, 255, 255));
        btnHisMat.setText("History Material");
        btnHisMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHisMatActionPerformed(evt);
            }
        });

        btnCheckStock.setBackground(new java.awt.Color(255, 165, 89));
        btnCheckStock.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnCheckStock.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckStock.setText("Check Stock");
        btnCheckStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckStockActionPerformed(evt);
            }
        });

        btnBuyStock.setBackground(new java.awt.Color(157, 68, 192));
        btnBuyStock.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnBuyStock.setForeground(new java.awt.Color(255, 255, 255));
        btnBuyStock.setText("Buy Stock");
        btnBuyStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyStockActionPerformed(evt);
            }
        });

        btnReportStock.setBackground(new java.awt.Color(41, 91, 167));
        btnReportStock.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnReportStock.setForeground(new java.awt.Color(255, 255, 255));
        btnReportStock.setText("Print Report Stock");
        btnReportStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportStockActionPerformed(evt);
            }
        });

        btnExpense.setBackground(new java.awt.Color(185, 0, 91));
        btnExpense.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnExpense.setForeground(new java.awt.Color(255, 255, 255));
        btnExpense.setText("Print Expense CheckStock");
        btnExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpenseActionPerformed(evt);
            }
        });

        btnOutOfStock.setBackground(new java.awt.Color(68, 93, 72));
        btnOutOfStock.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnOutOfStock.setForeground(new java.awt.Color(255, 255, 255));
        btnOutOfStock.setText("Print Out Of Stock");
        btnOutOfStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutOfStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(241, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBuyStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCheckStock)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHisMat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnOutOfStock)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExpense)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReportStock))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHisMat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuyStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReportStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOutOfStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelHead, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        editedMaterial = new Material();
        openDialog();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaterialMouseClicked
        refreshTable();
    }//GEN-LAST:event_tblMaterialMouseClicked

    private void btnHisMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHisMatActionPerformed
        chagePage("HistoryMaterial");
    }//GEN-LAST:event_btnHisMatActionPerformed

    private void btnCheckStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckStockActionPerformed
        chagePage("Check Stock");
    }//GEN-LAST:event_btnCheckStockActionPerformed

    private void btnBuyStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyStockActionPerformed
        chagePage("BuyStock");
    }//GEN-LAST:event_btnBuyStockActionPerformed

    private void btnReportStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportStockActionPerformed
        // TODO add your handling code here:
        try {
            Date currentDate = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-yyyy");
            String forr = simpleDateFormat.format(currentDate);

            // TODO add your handling code here:
            ReportCheckStock.getInstance().complieReport();
            ReportCheckStock.getInstance().printReport();

        } catch (JRException ex) {
            Logger.getLogger(MaterialPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReportStockActionPerformed

    private void btnExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpenseActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        try {
            Date currentDate = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-yyyy");
            String forr = simpleDateFormat.format(currentDate);

            // TODO add your handling code here:
            ReportOutOfStock.getInstance().complieReport();
            ReportOutOfStock.getInstance().printReport(forr);

        } catch (JRException ex) {
            Logger.getLogger(MaterialPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExpenseActionPerformed

    private void btnOutOfStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutOfStockActionPerformed
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
            };
        });
    }//GEN-LAST:event_btnOutOfStockActionPerformed
                
    private void openDialog() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        MaterialDialog materialDialog = new MaterialDialog(frame, editedMaterial);
        materialDialog.setLocationRelativeTo(this); //set dialog to center
        materialDialog.setVisible(true);
        materialDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable();
            }

        });
    }

    private void refreshTable() {
        list = materialService.getMaterials();
        tblMaterial.revalidate();
        tblMaterial.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBuyStock;
    private javax.swing.JButton btnCheckStock;
    private javax.swing.JButton btnExpense;
    private javax.swing.JButton btnHisMat;
    private javax.swing.JButton btnOutOfStock;
    private javax.swing.JButton btnReportStock;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelHead;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMaterial;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loginData(User user) {
        txtUserName.setText(user.getUsername());
        txtRole.setText(user.getRole());

    }

    @Override
    public void onDataUpdated() {
        System.out.println("Page.MaterialPanel.onDataUpdated()");
        refreshTable();
    }

    @Override
    public void chagePage(String pageName) {
        for (ChagePage ch : chagePages) {
            ch.chagePage(pageName);
        }
    }

    public void addInchangePage(ChagePage ch) {
        chagePages.add(ch);
    }

    @Override
    public void sentDate(String date) {
        this.date = date;
    }
}
