/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Dialog;

import Model.Employee;
import Model.User;
import Service.EmployeeService;
import Service.UserService;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
public class EmployeeDialog extends javax.swing.JDialog {

    private final EmployeeService employeeService;
    private List<Employee> list;
    private Employee editedEmployee;
    private String path;

    public EmployeeDialog(java.awt.Frame parent, Employee editedEmployee) {
        super(parent, true);
        initComponents();
        this.editedEmployee = editedEmployee;
        setObjectToForm();
        employeeService = new EmployeeService();
        loadImage();
    }

    private void loadImage() {
        if (editedEmployee.getId() > 0) {
            ImageIcon icon = new ImageIcon("./employee" + editedEmployee.getId() + ".png");
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            icon.setImage(newImage);
            lblPhoto.setIcon(icon);
        }

    }
    
    private void loadImage(String path) {
        if (editedEmployee.getId() > 0) {
            ImageIcon icon = new ImageIcon(path);
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            icon.setImage(newImage);
            lblPhoto.setIcon(icon);
        }

    }

    public void chooseImage() {
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "png", "jpg");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Selected file" + file.getAbsolutePath());
            loadImage(file.getAbsolutePath());
            path = file.getAbsolutePath();
        }

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
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblTelephone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        cmbPosition = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblPhoto = new javax.swing.JLabel();
        lblPassword1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPosition = new javax.swing.JLabel();
        lblHourlyWage = new javax.swing.JLabel();
        txtHourlyWage = new javax.swing.JTextField();
        txtTelephone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 251, 245));

        lblID.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblID.setText("ID: ");

        lblName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblName.setText("Name: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        lblAddress.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblAddress.setText("Address:");

        txtAddress.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        lblTelephone.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblTelephone.setText("Telephone:");

        lblEmail.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblEmail.setText("Email: ");

        cmbPosition.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        cmbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cashier", "Cleaner" }));
        cmbPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPositionActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(231, 70, 70));
        btnCancel.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(93, 156, 89));
        btnSave.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhoto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblPhoto.setOpaque(true);
        lblPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhotoMouseClicked(evt);
            }
        });

        lblPassword1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblPassword1.setText("Select Pic:");

        txtEmail.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        lblPosition.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblPosition.setText("Position:");

        lblHourlyWage.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblHourlyWage.setText("Hourly Wage: ");

        txtHourlyWage.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        txtTelephone.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelephone)
                    .addComponent(lblName)
                    .addComponent(lblPosition))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHourlyWage)
                    .addComponent(lblEmail)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtHourlyWage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(lblName)
                            .addComponent(jLabel8)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTelephone)
                                .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEmail)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPosition)
                    .addComponent(lblHourlyWage)
                    .addComponent(txtHourlyWage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Employee employee;
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTelephone.getText();
        String email = txtEmail.getText();
        int hw;
        if (name.matches(".*\\d+.*")) {
            JOptionPane.showMessageDialog(this, "Name must not contain numbers.");
            return;
        }
         if (name.length() < 3) {
            JOptionPane.showMessageDialog(this, "Plase Insert name more than 3 character");
            return;
        }
          if (!tel.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Please insert a telephone number with exactly 10 digits.");
            return;
        }
         if (address.length() < 3) {
            JOptionPane.showMessageDialog(this, "Plase Insert address more than 3 character");
            return;
        }
         if (email.length() < 5) {
            JOptionPane.showMessageDialog(this, "Plase Insert email more than 5 character");
            return;
        }
         try {
            hw = Integer.parseInt(txtHourlyWage.getText());
            if (hw < 1) {
                JOptionPane.showMessageDialog(this, "Hourly Wage must more than 0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please fill the hourly wage and must be a valid integer.");
            return;
        }

        if (editedEmployee.getId() < 0) {//Add New
            setFormToObject();
            employee = employeeService.addNew(editedEmployee);
        } else {
            setFormToObject();
            employee = employeeService.update(editedEmployee);
        }
        saveImage(employee);
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void saveImage(Employee employee) {
        if(path==null || path.isEmpty()) return;
        try {
            BufferedImage  image = ImageIO.read(new File(path));
            ImageIO.write(image, "png", new File("./user" + employee.getId() + ".png")); // name image
        } catch (IOException ex) {
            Logger.getLogger(EmployeeDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void lblPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhotoMouseClicked
        chooseImage();
    }//GEN-LAST:event_lblPhotoMouseClicked

    private void cmbPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPositionActionPerformed

    private void setFormToObject() {
        editedEmployee.setName(txtName.getText());
        editedEmployee.setAddress(txtAddress.getText());
        editedEmployee.setTelephone(txtTelephone.getText());
        editedEmployee.setEmail(txtEmail.getText());
        if(0 == cmbPosition.getSelectedIndex()){
            editedEmployee.setPosition("Cashier");
        }else{
            editedEmployee.setPosition("Cleaner");
        }
        editedEmployee.setHourlyWage(Integer.parseInt(txtHourlyWage.getText()));
       
    }

    private void setObjectToForm() {
        txtName.setText(editedEmployee.getName());
        txtAddress.setText(editedEmployee.getAddress());
        txtTelephone.setText(editedEmployee.getTelephone());
        txtEmail.setText(editedEmployee.getEmail());
        if(0 == cmbPosition.getSelectedIndex()){
            editedEmployee.setPosition("Cashier");
        }else{
            editedEmployee.setPosition("Cleaner");
        }
        txtHourlyWage.setText(editedEmployee.getHourlyWage()+"");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbPosition;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHourlyWage;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHourlyWage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
