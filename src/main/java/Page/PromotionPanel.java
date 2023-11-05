package Page;

import Component.ChagePage;
import Component.LoginObs;
import com.mycompany.decoffeeallforone.*;
import Dialog.PromotionDialog;
import Model.Promotion;
import Model.User;
import Service.PromotionService;
import TablebtnEditDelete.TableActionEvent;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

public class PromotionPanel extends javax.swing.JPanel implements LoginObs, ChagePage {

    private final PromotionService promotionService;
    private List<Promotion> list;
    private Promotion editedPromotion;
    private ArrayList<LoginObs> loginObses;
    private ArrayList<ChagePage> chagePages = new ArrayList<>();

    public PromotionPanel() {
        initComponents();
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int selectedIndex = tblPromotion.getSelectedRow();
                if (selectedIndex >= 0) {
                    editedPromotion = list.get(selectedIndex);
                    openDialog();
                }
            }

            @Override
            public void onDelete(int row) {
                int selectedIndex = tblPromotion.getSelectedRow();
                if (selectedIndex >= 0) {
                    editedPromotion = list.get(selectedIndex);
                    int input = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Select an Option...",
                            JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (input == 0) {
                        promotionService.delete(editedPromotion);
                    }
                    refreshTable();
                }
            }
        };
        promotionService = new PromotionService();

        list = promotionService.getPromotions();
        tblPromotion.setRowHeight(30);
        tblPromotion.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 16));
        tblPromotion.setModel(new AbstractTableModel() {
            String[] columnNames = {"ID", "Created_Date", "End_Date", "Name", "Discount", "Discount_Perc", "Point_Discount"};

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
                        return String.class;
                    default:
                        return String.class;
                }
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Promotion promotion = list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return promotion.getId();
                    case 1:
                        return promotion.getCreatedDate();
                    case 2:
                        return promotion.getEndDate();
                    case 3:
                        return promotion.getName();
                    case 4:
                        return promotion.getDiscount();
                    case 5:
                        return promotion.getDiscountPerc();
                    case 6:
                        return promotion.getPointDiscount();
                    default:
                        return "Unknown";
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHead = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRole = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPromotion = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();

        jPanelHead.setBackground(new java.awt.Color(224, 205, 174));
        jPanelHead.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelHead.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel2.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel2.setText("Promotion");

        lblName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblName.setText("User Name: ");

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
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblName)
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
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRole))
                .addGap(14, 14, 14))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblPromotion.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        tblPromotion.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPromotion.setSelectionBackground(new java.awt.Color(213, 208, 189));
        jScrollPane1.setViewportView(tblPromotion);

        btnAdd.setBackground(new java.awt.Color(213, 208, 189));
        btnAdd.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(103, 93, 80));
        btnAdd.setText("Add");
        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(103, 93, 80)));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHead, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        editedPromotion = new Promotion();
        openDialog();
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelHead;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JTable tblPromotion;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables

    private void openDialog() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        PromotionDialog promotionDialog = new PromotionDialog(frame, editedPromotion);
        promotionDialog.setLocationRelativeTo(this);
        promotionDialog.setVisible(true);
        promotionDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable();
            }
        });
    }

    private void refreshTable() {
        list = promotionService.getPromotions();
        tblPromotion.revalidate();
        tblPromotion.repaint();
    }

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
