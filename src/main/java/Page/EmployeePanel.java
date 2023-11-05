/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.EmpObs;
import Component.LoginObs;
import Dialog.EmployeeDialog;
import Dialog.UserDialog;
import Model.Employee;
import Model.User;
import Service.EmployeeService;
import Service.UserService;
import TablebtnEditDelete.TableActionCellEditor;
import TablebtnEditDelete.TableActionCellRenderer;
import TablebtnEditDelete.TableActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author ASUS
 */
public class EmployeePanel extends javax.swing.JPanel implements LoginObs, EmpObs{

    private final EmployeeService employeeService;
    private List<Employee> list;
    private Employee editedEmployee;
    private UserPanel userPanel;
    /**
     * Creates new form Employee
     */
    public EmployeePanel() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        userPanel = new UserPanel();
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int selectIndex = tblEmployee.getSelectedRow();
                if (selectIndex >= 0) {
                    editedEmployee = list.get(selectIndex);
                    openDialog();
                }
            }

            @Override
            public void onDelete(int row) {
                int selectIndex = tblEmployee.getSelectedRow();
                if (selectIndex >= 0) {
                    editedEmployee = list.get(selectIndex);
                    int input = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Select an Option...",
                            JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (input == 0) {
                        employeeService.delete(editedEmployee);
                    }
                    refreshTable();
                }
            }
        };

        employeeService = new EmployeeService();

        list = employeeService.getEmployees();
        tblEmployee.setRowHeight(50);
        tblEmployee.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 16));
        tblEmployee.setModel(new AbstractTableModel() {
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
        tblEmployee.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRenderer());
        tblEmployee.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(event));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jPanelHead = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUserName1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRole1 = new javax.swing.JLabel();

        jPanel.setBackground(new java.awt.Color(255, 255, 255));

        tblEmployee.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmployee.setSelectionBackground(new java.awt.Color(213, 208, 189));
        jScrollPane1.setViewportView(tblEmployee);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelHead.setBackground(new java.awt.Color(224, 205, 174));
        jPanelHead.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelHead.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel3.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel3.setText("Employee");

        jLabel7.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel7.setText("User Name: ");

        txtUserName1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtUserName1.setText("Name");

        jLabel8.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel8.setText("Role:");

        txtRole1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtRole1.setText("Role");

        javax.swing.GroupLayout jPanelHeadLayout = new javax.swing.GroupLayout(jPanelHead);
        jPanelHead.setLayout(jPanelHeadLayout);
        jPanelHeadLayout.setHorizontalGroup(
            jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRole1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelHeadLayout.setVerticalGroup(
            jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUserName1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRole1))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelHead, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void openDialog() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        EmployeeDialog EmployeeDialog = new EmployeeDialog(frame, editedEmployee);
        EmployeeDialog.setLocationRelativeTo(this); //set dialog to center
        EmployeeDialog.setVisible(true);
        EmployeeDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable();
            }

        });
    }
    public void refreshTable() {
        list = employeeService.getEmployees();
        tblEmployee.revalidate();
        tblEmployee.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelHead;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JLabel txtRole1;
    private javax.swing.JLabel txtUserName1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loginData(User user) {
        txtUserName1.setText(user.getUsername());       
        txtRole1.setText(user.getRole());
    }


    @Override
    public void updateEmployee(Employee employee) {
        System.out.println("Page.EmployeePanel.updateEmployee()");
        refreshTable();
    }
}
