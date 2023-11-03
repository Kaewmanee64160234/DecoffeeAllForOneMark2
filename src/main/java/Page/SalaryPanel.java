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
import Model.Product;
import Service.EmployeeService;
import TablebtnEditDelete.TableActionCellEditor;
import TablebtnEditDelete.TableActionCellRenderer;
import TablebtnEditDelete.TableActionEvent;
import com.mycompany.decoffeeallforone.MainFrame;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import javax.swing.table.AbstractTableModel;
import selectInTable.TableActionCellRender;
import scrollbar.ScrollBarCustom;


/**
 *
 * @author ASUS
 */
public class SalaryPanel extends javax.swing.JPanel implements changePageSummary,ChagePage {

    private Product editedProduct;
    private EmployeeService employeeService;
    private Employee editedEmployee;
    private ArrayList<Employee> list;
    private ArrayList<changePageSummary> subs;    private ArrayList<ChagePage> chagePages = new ArrayList<>();


    /**
     * Creates new form SalaryPanel
     */
    public SalaryPanel() {
        initComponents();
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane4.setVerticalScrollBar(new ScrollBarCustom());
        employeeService = new EmployeeService();
        editedEmployee = new Employee();
        list = new ArrayList<>();
        subs = new ArrayList<>();


        employeeService = new EmployeeService();

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
            String[] columnNames = {"Profile","ID", "Name", "Address", "Telephone", "Email", "Position", "Hourly wage", "Action"};

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlNavigation2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTopEmployee = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSalary = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnHistory = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnPaymentHistory = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlNavigation2.setBackground(new java.awt.Color(213, 208, 189));

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

        javax.swing.GroupLayout pnlNavigation2Layout = new javax.swing.GroupLayout(pnlNavigation2);
        pnlNavigation2.setLayout(pnlNavigation2Layout);
        pnlNavigation2Layout.setHorizontalGroup(
            pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavigation2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)

                    .addGroup(pnlNavigation2Layout.createSequentialGroup()
                        .addGroup(pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlNavigation2Layout.setVerticalGroup(
            pnlNavigation2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNavigation2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jPanel3.setBackground(new java.awt.Color(166, 190, 178));

        btnHistory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHistory.setText("History");
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        btnPrint.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                .addGap(18, 18, 18)
                .addComponent(btnPrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistory)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHistory)
                    .addComponent(btnPrint)
                    .addComponent(btnPaymentHistory))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(pnlNavigation2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnlNavigation2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed

    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnPaymentHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentHistoryActionPerformed
        chagePage("History ss");
    }//GEN-LAST:event_btnPaymentHistoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnPaymentHistory;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
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
     public void addInChagePage(ChagePage ch){
        chagePages.add(ch);
    }


    @Override
    public void chagePage(String pageName) {
        for (ChagePage chagePage : chagePages) {
            chagePage.chagePage(pageName);
            
        }
    }

}
