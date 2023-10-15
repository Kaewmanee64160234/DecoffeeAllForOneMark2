/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Dialog;

import Model.Material;
import Service.MaterialService;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author toey
 */
public class MaterialDialog extends javax.swing.JDialog {

    private final MaterialService materialService;
    private List<MaterialService> list;
    private Material editedMaterial;
    private String path;

    public MaterialDialog(java.awt.Frame parent, Material editedMaterial) {
        super(parent, true);
        initComponents();
        this.editedMaterial = editedMaterial;
        setObjectToForm();
        materialService = new MaterialService();
    }

    public MaterialDialog(JFrame frame, Material editedMaterial) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        txtName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        edtName = new javax.swing.JTextField();
        txtMinimum = new javax.swing.JLabel();
        edtMinimum = new javax.swing.JTextField();
        txtUnit = new javax.swing.JLabel();
        edtUnit = new javax.swing.JPasswordField();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtQuantity = new javax.swing.JLabel();
        edtQuantity = new javax.swing.JTextField();
        txtPricePerUnit = new javax.swing.JLabel();
        edtPericePerUnit = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(183, 202, 219));

        lblID.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblID.setText("ID: ");

        txtName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtName.setText("Name:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        edtName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        txtMinimum.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtMinimum.setText("Minimum:");

        edtMinimum.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        txtUnit.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtUnit.setText("Unit: ");

        edtUnit.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        btnCancel.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtQuantity.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtQuantity.setText("Quantity:");

        edtQuantity.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        txtPricePerUnit.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtPricePerUnit.setText("Price Per Unit");

        edtPericePerUnit.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMinimum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtMinimum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPricePerUnit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtPericePerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtQuantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtName)
                    .addComponent(jLabel8)
                    .addComponent(edtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinimum)
                    .addComponent(edtMinimum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQuantity)
                        .addComponent(edtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUnit)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPricePerUnit)
                            .addComponent(edtPericePerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
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
        Material material;
        if (editedMaterial.getId() < 0) {//Add New
            setFormToObject();
            material = materialService.addNew(editedMaterial);
        } else {
            setFormToObject();
            material = materialService.update(editedMaterial);
        }
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed


    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void setFormToObject() {
        editedMaterial.setName(edtName.getText());
        editedMaterial.setMatMinQty((Integer.parseInt(edtMinimum.getText())));
        editedMaterial.setMatQty((Integer.parseInt(edtQuantity.getText())));
        editedMaterial.setMatUnit(edtUnit.getText());
        editedMaterial.setMatPricePerUnit((Integer.parseInt(edtPericePerUnit.getText())));
    }

    private void setObjectToForm() {
        edtName.setText(editedMaterial.getName());
        edtMinimum.setText(editedMaterial.getMatMinQty()+ "");
        edtQuantity.setText(editedMaterial.getMatQty() + "");
        edtUnit.setText(editedMaterial.getMatUnit()+ "");
        edtPericePerUnit.setText(editedMaterial.getMatPricePerUnit()+ "");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField edtMinimum;
    private javax.swing.JTextField edtName;
    private javax.swing.JTextField edtPericePerUnit;
    private javax.swing.JTextField edtQuantity;
    private javax.swing.JPasswordField edtUnit;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel txtMinimum;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtPricePerUnit;
    private javax.swing.JLabel txtQuantity;
    private javax.swing.JLabel txtUnit;
    // End of variables declaration//GEN-END:variables
}
