/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Dialog;

import Component.CusObs;
import Model.Customer;
import Model.User;
import Service.CustomerService;
import Service.UserService;
import Service.ValidateException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author toey
 */
public class AddCustomerDialog extends javax.swing.JDialog implements CusObs{

    private final CustomerService customerService;
    private ArrayList<Customer> lists;
    private Customer editedCustomer;
    private String path;
    private ArrayList<CusObs> listCusObses;

    public AddCustomerDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        this.editedCustomer = new Customer();
        setObjectToForm();
        customerService = new CustomerService();
        listCusObses = new ArrayList<CusObs>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblTel = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        lblPoint = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtPoint = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(183, 202, 219));

        lblID.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblID.setText("ID: ");

        lblName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblName.setText("Name:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        lblTel.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblTel.setText("Telephone:");

        txtTel.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        lblPoint.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblPoint.setText("Point: ");

        btnClear.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtPoint.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(lblTel)
                .addGap(29, 29, 29)
                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblName)
                    .addComponent(jLabel8)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTel)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPoint)
                    .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnClear))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = txtName.getText();
        String tel = txtTel.getText();
        int point = Integer.parseInt(txtPoint.getText());
        if (name.length() < 3) {
            JOptionPane.showMessageDialog(this, "Plase Insert name more than 3 character");
            return;
        }
        if (tel.length() != 10) {
            JOptionPane.showMessageDialog(this, "Plase Insert teleplhon number 10 character");
            return;

        }
        if (point < 0) {
            JOptionPane.showMessageDialog(this, "Insert point is must more than 0");
            return;

        }
        try {
            editedCustomer.setName(name);
            editedCustomer.setTel(tel);
            editedCustomer.setPoint(point);
            customerService.addNew(editedCustomer);
            updateCustomer(editedCustomer);
        } catch (ValidateException ex) {
            Logger.getLogger(AddCustomerDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void setFormToObject() {
        editedCustomer.setName(txtName.getText());
        editedCustomer.setTel((txtTel.getText()));
        editedCustomer.setPoint((Integer.parseInt(txtPoint.getText())));
    }

    private void setObjectToForm() {
        txtName.setText(editedCustomer.getName());
        txtTel.setText(editedCustomer.getTel());
        txtPoint.setText((editedCustomer.getPoint() + ""));
    }
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        lblName.setText("");
        lblPoint.setText("");
        lblTel.setText("");
        dispose();
    }//GEN-LAST:event_btnClearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPoint;
    private javax.swing.JLabel lblTel;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPoint;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateCustomer(Customer customer) {
        for (CusObs ob : listCusObses) {
            ob.updateCustomer(customer);
            
        }
        
    }
     public void addSubs(CusObs cusObs) {
        listCusObses.add(cusObs);
        
    }
    
}
