/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Component;

import java.util.ArrayList;

/**
 *
 * @author toey
 */
public class NavigationBar extends javax.swing.JPanel implements ChagePage {

    private ArrayList<ChagePage> subscobers;

    /**
     * Creates new form NavigationBar
     */
    public NavigationBar() {
        initComponents();
        subscobers = new ArrayList<ChagePage>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCheckStock = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JPanel();
        txt = new javax.swing.JLabel();
        btnMainMenu = new javax.swing.JButton();
        btnPos = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnEmployee = new javax.swing.JButton();
        btnMaterial = new javax.swing.JButton();
        btnCheckinout = new javax.swing.JButton();
        btnCheckStock1 = new javax.swing.JButton();
        btnSummarySalary = new javax.swing.JButton();
        btnButStock = new javax.swing.JButton();

        btnCheckStock.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnCheckStock.setText("Check Stock");
        btnCheckStock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCheckStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckStockActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(213, 208, 189));

        javax.swing.GroupLayout lblLogoLayout = new javax.swing.GroupLayout(lblLogo);
        lblLogo.setLayout(lblLogoLayout);
        lblLogoLayout.setHorizontalGroup(
            lblLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        lblLogoLayout.setVerticalGroup(
            lblLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        txt.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        txt.setText("D-Coffee");

        btnMainMenu.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnMainMenu.setText("Main Menu");
        btnMainMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        btnPos.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnPos.setText("Point of Sell");
        btnPos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosActionPerformed(evt);
            }
        });

        btnProduct.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnProduct.setText("Product");
        btnProduct.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });

        btnUser.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnUser.setText("User");
        btnUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnEmployee.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnEmployee.setText("Employee");
        btnEmployee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });

        btnMaterial.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnMaterial.setText("Material");
        btnMaterial.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaterialActionPerformed(evt);
            }
        });

        btnCheckinout.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnCheckinout.setText("Check in - Check out");
        btnCheckinout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCheckinout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckinoutActionPerformed(evt);
            }
        });

        btnCheckStock1.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnCheckStock1.setText("Check Stock");
        btnCheckStock1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCheckStock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckStock1ActionPerformed(evt);
            }
        });

        btnSummarySalary.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnSummarySalary.setText("Summay Salary");
        btnSummarySalary.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSummarySalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummarySalaryActionPerformed(evt);
            }
        });

        btnButStock.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnButStock.setText("BuyStock");
        btnButStock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnButStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnButStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnPos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCheckinout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCheckStock1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSummarySalary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnButStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCheckinout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCheckStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSummarySalary, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnButStock, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosActionPerformed
        // TODO add your handling code here:
        chagePage("POS");
    }//GEN-LAST:event_btnPosActionPerformed

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        // TODO add your handling code here:
        chagePage("Product");

    }//GEN-LAST:event_btnProductActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
        chagePage("User");

    }//GEN-LAST:event_btnUserActionPerformed

    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
        // TODO add your handling code here:
        chagePage("Employee");

    }//GEN-LAST:event_btnEmployeeActionPerformed

    private void btnMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaterialActionPerformed
        // TODO add your handling code here:
        chagePage("Material");

    }//GEN-LAST:event_btnMaterialActionPerformed

    private void btnCheckinoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckinoutActionPerformed
        // TODO add your handling code here:
        chagePage("Check In-Out");
    }//GEN-LAST:event_btnCheckinoutActionPerformed

    private void btnCheckStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckStockActionPerformed
        // TODO add your handling code here:
                chagePage("Check Stock");

    }//GEN-LAST:event_btnCheckStockActionPerformed

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        // TODO add your handling code here:
        chagePage("Main menu");
    }//GEN-LAST:event_btnMainMenuActionPerformed

    private void btnCheckStock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckStock1ActionPerformed
        // TODO add your handling code here:
        chagePage("Check Stock");
    }//GEN-LAST:event_btnCheckStock1ActionPerformed

    private void btnSummarySalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummarySalaryActionPerformed
        // TODO add your handling code here:
        chagePage("SS Main");
    }//GEN-LAST:event_btnSummarySalaryActionPerformed

    private void btnButStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnButStockActionPerformed
        // TODO add your handling code here:
        chagePage("BuyStock");
    }//GEN-LAST:event_btnButStockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnButStock;
    private javax.swing.JButton btnCheckStock;
    private javax.swing.JButton btnCheckStock1;
    private javax.swing.JButton btnCheckinout;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnMaterial;
    private javax.swing.JButton btnPos;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnSummarySalary;
    private javax.swing.JButton btnUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel lblLogo;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables

    @Override
    public void chagePage(String pageName) {
        for (ChagePage subscober : subscobers) {
            subscober.chagePage(pageName);
            
        }
    }

    public void addInSubs(ChagePage chagePage) {
        subscobers.add(chagePage);
    }
}
