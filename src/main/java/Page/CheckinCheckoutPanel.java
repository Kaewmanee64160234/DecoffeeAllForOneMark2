/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.LoginObs;
import Model.Checkinout;
import Model.Employee;
import Service.CheckinoutService;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import Model.Customer;
import Model.Employee;
import Model.User;
import Service.CustomerService;
import Service.EmployeeService;
import Service.UserService;
import java.awt.Font;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author toey
 */
public class CheckinCheckoutPanel extends javax.swing.JPanel implements LoginObs {

    private final CheckinoutService checkinoutService;
    private List<Checkinout> list;

    private Checkinout checkinout;
    private ArrayList<Checkinout> checkinouts;
    private Customer customer;
    private CustomerService customerService;
    private UserService userService;
    private Employee employee;
    private User user;
    private EmployeeService employeeService;
    private ArrayList<LoginObs> loginOsbs;

    /**
     * Creates new form ChecekinCheckoutPanel
     */
    public CheckinCheckoutPanel() {
        initComponents();
        loginOsbs = new ArrayList<>();
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        checkinoutService = new CheckinoutService();
        checkinout = new Checkinout();
        customer = new Customer();
        customerService = new CustomerService();
        userService = new UserService();
        employee = new Employee();
        employeeService = new EmployeeService();
        list = new ArrayList<Checkinout>();
        tblCheckInCheckOut.setEnabled(false);
        tblCheckInCheckOut.setRowHeight(50);
        tblCheckInCheckOut.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 16));
        tblCheckInCheckOut.setModel(new AbstractTableModel() {
            String[] columnNames = {"Date", "Time In", "Time Out", "Total Hour", "Total Price"};

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
                return 5;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {

                    default:
                        return String.class;
                }
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Checkinout checkinout = list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return checkinout.getCioDate();
                    case 1:
                        return checkinout.getCioTimeIn();
                    case 2:
                        return checkinout.getCioTimeOut();
                    case 3:
                        return checkinout.getCioTotalHour();
                    case 4:
                        if (employee == null) {
                            return "-";
                        } else {
                            return checkinout.getCioTotalHour() * employee.getHourlyWage();
                        }

                    default:
                        return "Unknown";
                }
            }

        });
        btnCheckOut.setEnabled(false);
        setTimeInLblDate();
    }

    private void setTimeInLblDate() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
                String formattedTime = dateFormat.format(now);
                txtDateTime.setText(formattedTime);
            }
        }, 0, 1000); // Update every 1 second
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
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRole = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pfdPassword = new javax.swing.JPasswordField();
        txtLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDateTime = new javax.swing.JLabel();
        btnCheckIn = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCheckInCheckOut = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(224, 205, 174));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel1.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel1.setText("Check in - Check out");
        jLabel1.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel5.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel5.setText("User Name: ");

        txtUserName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtUserName.setText("Name");

        jLabel6.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel6.setText("Role:");

        txtRole.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtRole.setText("Role");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtUserName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtRole)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lblImage.setBackground(new java.awt.Color(236, 226, 226));
        lblImage.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Kanit", 0, 16)); // NOI18N
        jLabel2.setText("Login: ");

        jLabel3.setFont(new java.awt.Font("Kanit", 0, 16)); // NOI18N
        jLabel3.setText("Password:");

        pfdPassword.setFont(new java.awt.Font("Kanit", 0, 16)); // NOI18N

        txtLogin.setFont(new java.awt.Font("Kanit", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Kanit", 0, 16)); // NOI18N
        jLabel4.setText("Date Time: ");

        txtDateTime.setFont(new java.awt.Font("Kanit", 0, 16)); // NOI18N
        txtDateTime.setText("00/00/00 00:00:00");

        btnCheckIn.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnCheckIn.setText("Check In");
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });

        btnCheckOut.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnCheckOut.setText("Check Out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addComponent(pfdPassword))
                            .addComponent(txtDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pfdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDateTime))
                .addGap(35, 35, 35)
                .addComponent(btnCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblCheckInCheckOut.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        tblCheckInCheckOut.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCheckInCheckOut.setSelectionBackground(new java.awt.Color(213, 208, 189));
        jScrollPane2.setViewportView(tblCheckInCheckOut);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        String name = txtLogin.getText();
        String pass = new String(pfdPassword.getPassword());
        System.out.println(pass);
        userService = new UserService();
        employeeService = new EmployeeService();
        checkinout = new Checkinout();
        User user = userService.login(name, pass);

        if (user != null) {
            int empID = user.getEmployee_id();
            String formattedTime = cretaeFormatDate();
            employee = employeeService.getById(empID);
            employeeService.setEditedEmployee(employee);
            setImage(user);
            loginData(user);
            checkinout.setCioTimeIn(formattedTime);
            checkinout.setCioTimeOut("-");
            checkinout.setCioPaidStatus("N");
            checkinout.setEmployeeId(empID);
            checkinout.setCioTotalHour(0);
            checkinoutService.addNew(checkinout);
            txtUserName.setText(user.getUsername());
            txtRole.setText(user.getRole());
            list = checkinoutService.getCheckinoutsByIdEmployee(empID);

            tblCheckInCheckOut.setEnabled(true);
            txtUserName.setText(user.getUsername());
            txtRole.setText(user.getRole());
            loginData(user);
            refreshForm();
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Usernot Found");
            return;
        }

        btnCheckIn.setEnabled(false);
        btnCheckOut.setEnabled(true);

    }//GEN-LAST:event_btnCheckInActionPerformed
    private void refreshTable() {

        tblCheckInCheckOut.revalidate();
        tblCheckInCheckOut.repaint();
    }

    private void refreshForm() {
        txtLogin.setText("");
        pfdPassword.setText("");

    }

    private void setImage(User user) {
        ImageIcon icon = new ImageIcon("./user" + user.getId() + ".png");
        Image image = icon.getImage();
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        Image newImage = image.getScaledInstance((int) (100 * ((float) width) / height), 100, Image.SCALE_SMOOTH);
        icon.setImage(newImage);
        lblImage.setIcon(icon);
    }

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        // TODO add your handling code here:

        System.out.println("-----------------------------------");
        String formattedTime = cretaeFormatDate();
        String[] time = new String[2];
        System.out.println(formattedTime);
        double total = calculateTotalHours(checkinout.getCioTimeIn(), formattedTime);
        checkinout.setCioTimeOut(formattedTime);
        checkinout.setCioTotalHour((int) total);
        System.out.println(total);
        System.out.println(checkinout.toString());
        checkinoutService.update(checkinout);
        //logout Emplouyy

        tblCheckInCheckOut.setEnabled(false);
        list.clear();
        refreshTable();
        User user = new User();
        user.setRole("user");
        setImage(user);
        loginData(user);

        employee = new Employee();
        txtUserName.setText("");
        txtRole.setText("");
        System.out.println("-----------------------------------");
        btnCheckIn.setEnabled(true);
        btnCheckOut.setEnabled(false);
        setImage(user);


    }//GEN-LAST:event_btnCheckOutActionPerformed

    private String cretaeFormatDate() {
        // TODO add your handling code here:
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        String formattedTime = timeFormat.format(currentTime);
        return formattedTime;
    }

    public static double calculateTotalHours(String startTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        try {
            Date start = sdf.parse(startTime);
            Date end = sdf.parse(endTime);

            long timeDifference = end.getTime() - start.getTime();
            double hoursDifference = timeDifference / (double) 3600000;

            return hoursDifference;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1; // Return a negative value to indicate an error
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JPasswordField pfdPassword;
    private javax.swing.JTable tblCheckInCheckOut;
    private javax.swing.JLabel txtDateTime;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loginData(User user) {
        System.out.println("Page.CheckinCheckoutPanel.loginData()" + user.toString());

        for (LoginObs log : loginOsbs) {
            log.loginData(user);
            System.out.println(log.toString());

        }
        txtUserName.setText(user.getUsername());
        txtRole.setText(user.getRole());

    }

    public void addInLoginist(LoginObs login) {
        loginOsbs.add(login);
    }
}
