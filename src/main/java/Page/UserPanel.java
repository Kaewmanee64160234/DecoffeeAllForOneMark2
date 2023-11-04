/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.LoginObs;
import TablebtnEditDelete.TableActionCellRenderer;
import Dialog.UserDialog;
import Model.User;
import Service.UserService;
import TablebtnEditDelete.TableActionCellEditor;
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
import javax.swing.table.DefaultTableModel;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author toey
 */
public class UserPanel extends javax.swing.JPanel implements LoginObs{

    private final UserService userService;
    private List<User> list;
    private User editedUser;

    /**
     * Creates new form UserPanel
     */
    public UserPanel() {
        initComponents();
        
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int selectIndex = tblUser.getSelectedRow();
                if (selectIndex >= 0) {
                    editedUser = list.get(selectIndex);
                    openDialog();
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
        tblUser.setRowHeight(60);
        tblUser.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 16));

        tblUser.setModel(new AbstractTableModel() {
            String[] columnNames = {"Profile", "Id", "Login", "Name", "Password", "Role", "Action"};

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
                        Image newImage = image.getScaledInstance((int) (50 * ((float) width) / height), 50, Image.SCALE_SMOOTH);
                        icon.setImage(newImage);
                        return icon;
                    case 1:
                        return user.getId();
                    case 2:
                        return user.getLogin();
                    case 3:
                        return user.getUsername();
                    case 4:
                        return user.getPassword();
                    case 5:
                        return user.getRole();
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
        tblUser.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRenderer());
        tblUser.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
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
        jPanelHead2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUserName1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRole1 = new javax.swing.JLabel();

        jPanel.setBackground(new java.awt.Color(255, 251, 245));

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
        tblUser.setSelectionBackground(new java.awt.Color(164, 196, 203));
        jScrollPane1.setViewportView(tblUser);

        btnAdd.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
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
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelHead2.setBackground(new java.awt.Color(224, 205, 174));
        jPanelHead2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelHead2.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel3.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel3.setText("User");

        jLabel7.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel7.setText("User Name: ");

        txtUserName1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtUserName1.setText("Name");

        jLabel8.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel8.setText("Role:");

        txtRole1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtRole1.setText("Role");

        javax.swing.GroupLayout jPanelHead2Layout = new javax.swing.GroupLayout(jPanelHead2);
        jPanelHead2.setLayout(jPanelHead2Layout);
        jPanelHead2Layout.setHorizontalGroup(
            jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHead2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHead2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHead2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRole1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelHead2Layout.setVerticalGroup(
            jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHead2Layout.createSequentialGroup()
                .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHead2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtUserName1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelHead2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtRole1)))
                    .addGroup(jPanelHead2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelHead2, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelHead2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void openDialog() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        UserDialog userDialog = new UserDialog(frame, editedUser);
        userDialog.setLocationRelativeTo(this); //set dialog to center
        userDialog.setVisible(true);
        userDialog.addWindowListener(new WindowAdapter() {
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelHead2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUser;
    private javax.swing.JLabel txtRole1;
    private javax.swing.JLabel txtUserName1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loginData(User user) {
        txtUserName.setText(user.getUsername());       
        txtRole.setText(user.getRole());
    }

}
