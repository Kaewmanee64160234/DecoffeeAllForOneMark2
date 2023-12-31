/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.EmpObs;
import Component.LoginObs;
import Dialog.EditUserDialog;
import TablebtnEditDelete.TableActionCellRenderer;
import Dialog.UserDialog;
import Model.Employee;
import Model.User;
import Service.UserService;
import TablebtnEditDelete.TableActionCellEditor;
import TablebtnEditDelete.TableActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author toey
 */
public class UserPanel extends javax.swing.JPanel implements LoginObs, EmpObs {

    private final UserService userService;
    private List<User> list;
    private User editedUser;
    private ArrayList<EmpObs> empObss;
    private UserDialog userDialog;
    private EditUserDialog editUserDialog;

    /**
     * Creates new form UserPanel
     */
    public UserPanel() {
        initComponents();

        empObss = new ArrayList();
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        userDialog = new UserDialog(frame, editedUser);
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int selectIndex = tblUser.getSelectedRow();
                if (selectIndex >= 0) {
                    editedUser = list.get(selectIndex);
                    openDialog2();
                }
            }

            @Override
            public void onDelete(int row) {
                int selectIndex = tblUser.getSelectedRow();
                if (selectIndex >= 0) {
                    editedUser = list.get(selectIndex);
                    int input = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Select an Option...",
                            JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (input == 0) {
                        userService.delete(editedUser);
                    }
                    refreshTable();
                }
            }
        };

        userService = new UserService();

        list = userService.getUsers();
        tblUser.setRowHeight(50);
        tblUser.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 16));

        tblUser.setModel(new AbstractTableModel() {
            String[] columnNames = {"Profile", "Id", "Login", "Name", "Role", "Action"};

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
                return 6;
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
                User user = list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        ImageIcon icon = new ImageIcon("./user" + user.getId() + ".png");
                        Image image = icon.getImage();
                        int width = image.getWidth(null);
                        int height = image.getHeight(null);
                        Image newImage = image.getScaledInstance((int) (250 * ((float) width) / height), 250, Image.SCALE_SMOOTH);
                        icon.setImage(newImage);
                        return icon;
                    case 1:
                        return user.getId();
                    case 2:
                        return user.getLogin();
                    case 3:
                        return user.getUsername();
                    case 4:
                        return user.getRole();
                    case 5:
                        return new TableActionCellRenderer();
                    default:
                        return "Unknown";
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                if (columnIndex == 5) {
                    return true;
                }
                return false;
            }

        });
        int columnIndex = 0; // The column index where you want to display the image
        tblUser.getColumnModel().getColumn(columnIndex).setCellRenderer(new ImageRenderer());
        tblUser.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderer());
        tblUser.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGender = new javax.swing.ButtonGroup();
        jPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        jpnlHeader1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRole = new javax.swing.JLabel();

        jPanel.setBackground(new java.awt.Color(255, 255, 255));

        tblUser.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Profile", "ID", "Login", "Name", "Password", "Role", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.setRowHeight(60);
        tblUser.setSelectionBackground(new java.awt.Color(213, 208, 189));
        jScrollPane1.setViewportView(tblUser);

        btnAdd.setBackground(new java.awt.Color(66, 133, 91));
        btnAdd.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)))
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnlHeader1.setBackground(new java.awt.Color(224, 205, 174));
        jpnlHeader1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpnlHeader1.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel2.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel2.setText("User");

        jLabel5.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        jLabel5.setText("User Name: ");

        txtUserName.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        txtUserName.setText("Name");

        jLabel6.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        jLabel6.setText("Role:");

        txtRole.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        txtRole.setText("Role");

        javax.swing.GroupLayout jpnlHeader1Layout = new javax.swing.GroupLayout(jpnlHeader1);
        jpnlHeader1.setLayout(jpnlHeader1Layout);
        jpnlHeader1Layout.setHorizontalGroup(
            jpnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlHeader1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jpnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jpnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRole))
                .addContainerGap())
            .addGroup(jpnlHeader1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpnlHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void openDialog() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        userDialog = new UserDialog(frame, editedUser);
        userDialog.setLocationRelativeTo(this); //set dialog to center
        userDialog.setVisible(true);
        userDialog.addInSub(this);
        userDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable();
                updateEmployee(new Employee());
            }

        });
    }
    private void openDialog2() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        editUserDialog = new EditUserDialog(frame, editedUser);
        editUserDialog.setLocationRelativeTo(this); //set dialog to center
        editUserDialog.setVisible(true);
        editUserDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable();
            }

        });
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        editedUser = new User();
        openDialog();
    }//GEN-LAST:event_btnAddActionPerformed

    private void refreshTable() {
        list = userService.getUsers();
        tblUser.revalidate();
        tblUser.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.ButtonGroup btnGender;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnlHeader1;
    private javax.swing.JTable tblUser;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loginData(User user) {
        txtUserName.setText(user.getUsername());
        txtRole.setText(user.getRole());
    }

    @Override
    public void updateEmployee(Employee employee) {
        System.out.println("Page.UserPanel.updateEmployee()");
        for (EmpObs empObs : empObss) {
            empObs.updateEmployee(employee);
            
        }
    }

    public void addInSub(EmpObs empObs) {
        empObss.add(empObs);
    }

}
