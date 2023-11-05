/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.decoffeeallforone;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class SuccessDialog extends javax.swing.JFrame {

    /**
     * Creates new form ConfirmDialog
     */
    public SuccessDialog() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        
        loadImage();
    }

    private void loadImage() {
        ImageIcon icon  = new ImageIcon("./correct"+ ".png");
        Image image = icon.getImage();
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        Image newImage = image.getScaledInstance((int) (150*((float)width)/height), 150, Image.SCALE_SMOOTH);
        icon.setImage(newImage);
        lblPhoto.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblText = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        lblPhoto = new javax.swing.JLabel();
        lblFrame = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);
        getContentPane().add(lblText);
        lblText.setBounds(170, 220, 190, 40);

        btnOk.setBackground(new java.awt.Color(102, 204, 255));
        btnOk.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk);
        btnOk.setBounds(190, 270, 130, 40);
        getContentPane().add(lblPhoto);
        lblPhoto.setBounds(180, 50, 200, 160);

        lblFrame.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblFrame.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrame.setIcon(new javax.swing.ImageIcon("D:\\y3t1\\SoftDevAjKob\\DecoffeeAllForOneMark2\\Lovepik_com-401078816-cartoon-hand-painted-rectangular-border.png")); // NOI18N
        lblFrame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFrame.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(lblFrame);
        lblFrame.setBounds(0, 0, 510, 370);

        setSize(new java.awt.Dimension(519, 372));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SuccessDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuccessDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuccessDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuccessDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuccessDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblFrame;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
}
