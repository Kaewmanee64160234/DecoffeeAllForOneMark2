/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Dialog;

import Model.Product;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author toey
 */
public class ToppingDialog extends javax.swing.JDialog {
    private Product product;
    /**
     * Creates new form ToppingDialog1
     */
    public ToppingDialog(java.awt.Frame parent,Product product) {
        super(parent, true);
        initComponents();
        this.product = product;
        ImageIcon icon = new ImageIcon("./" + product.getName() + ".jpg");
        Image image = icon.getImage();
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        Image newImage = image.getScaledInstance((int) ((120.0 * width) / height), 120, Image.SCALE_SMOOTH);
        lblImg.setIcon(icon);
        lblProductName.setText(product.getName());
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
        lblImg = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        rbtHot = new javax.swing.JRadioButton();
        rbtFrappe = new javax.swing.JRadioButton();
        rbtCold = new javax.swing.JRadioButton();
        txtTopping = new javax.swing.JLabel();
        rbtBubble = new javax.swing.JRadioButton();
        rbtTopping2 = new javax.swing.JRadioButton();
        rbtWhipcream = new javax.swing.JRadioButton();
        btnConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(183, 202, 219));

        lblImg.setBackground(new java.awt.Color(237, 236, 230));
        lblImg.setOpaque(true);

        lblProductName.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblProductName.setText("Product Name");

        rbtHot.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        rbtHot.setText("Hot  +0");

        rbtFrappe.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        rbtFrappe.setText("ปั่น  +10");

        rbtCold.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        rbtCold.setText("เย็น  +5");

        txtTopping.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtTopping.setText("Topping:");

        rbtBubble.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        rbtBubble.setText("ไข่มุก  +5");

        rbtTopping2.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        rbtTopping2.setText("บุก  +10");

        rbtWhipcream.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        rbtWhipcream.setText("วิปครีม  +5");

        btnConfirm.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        btnConfirm.setText("Confirm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rbtHot)
                                .addGap(18, 18, 18)
                                .addComponent(rbtCold)
                                .addGap(18, 18, 18)
                                .addComponent(rbtFrappe))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProductName)
                                    .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtTopping))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rbtBubble)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtTopping2)
                                .addGap(18, 18, 18)
                                .addComponent(rbtWhipcream)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductName)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtHot)
                    .addComponent(rbtCold)
                    .addComponent(rbtFrappe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTopping)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtBubble)
                    .addComponent(rbtTopping2)
                    .addComponent(rbtWhipcream))
                .addGap(18, 18, 18)
                .addComponent(btnConfirm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JRadioButton rbtBubble;
    private javax.swing.JRadioButton rbtCold;
    private javax.swing.JRadioButton rbtFrappe;
    private javax.swing.JRadioButton rbtHot;
    private javax.swing.JRadioButton rbtTopping2;
    private javax.swing.JRadioButton rbtWhipcream;
    private javax.swing.JLabel txtTopping;
    // End of variables declaration//GEN-END:variables
}
