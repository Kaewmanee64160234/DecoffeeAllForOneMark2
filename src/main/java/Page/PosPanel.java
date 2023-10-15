/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.ProductListPanel;
import Dao.RecieptDao;
import Model.Reciept;
import Service.ProductService;
import Service.RecieptService;

/**
 *
 * @author toey
 */
public class PosPanel extends javax.swing.JPanel {


    
    /**
     * Creates new form PosDialog
     */
    public PosPanel() {
        initComponents();
        
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlHeader = new javax.swing.JPanel();
        txtDcoffee = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        jpnlDetail = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRecieptDetail = new javax.swing.JTable();
        jpnlMember = new javax.swing.JPanel();
        txtmemberName = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JLabel();
        txtMemberPoint = new javax.swing.JLabel();
        txtPointEarn = new javax.swing.JLabel();
        txtMemberDiscount = new javax.swing.JLabel();
        txtTotalPoint = new javax.swing.JLabel();
        lblMemberName = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblMemberPoint = new javax.swing.JLabel();
        lblPointEarn = new javax.swing.JLabel();
        lblMemberDiscount = new javax.swing.JLabel();
        lblTotalPoint = new javax.swing.JLabel();
        txtPoint = new javax.swing.JLabel();
        txtPoint1 = new javax.swing.JLabel();
        txtPoint2 = new javax.swing.JLabel();
        txtBaht = new javax.swing.JLabel();
        jpnlCaculator = new javax.swing.JPanel();
        txtTotal = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JLabel();
        txtTotalNet = new javax.swing.JLabel();
        txtCash = new javax.swing.JLabel();
        txtCange = new javax.swing.JLabel();
        txtBaht1 = new javax.swing.JLabel();
        txtBaht2 = new javax.swing.JLabel();
        txtBaht3 = new javax.swing.JLabel();
        txtBaht4 = new javax.swing.JLabel();
        txtBaht5 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblDiscount = new javax.swing.JLabel();
        lblTotalNet = new javax.swing.JLabel();
        lblCash = new javax.swing.JLabel();
        lblCange = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnDrinks = new javax.swing.JButton();
        btnDessert = new javax.swing.JButton();
        btnFood = new javax.swing.JButton();
        txtItemList = new javax.swing.JLabel();
        btnPromotion = new javax.swing.JButton();
        scrProductList = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnMainMenu = new javax.swing.JButton();
        btnFindMember = new javax.swing.JButton();
        btnAddMember = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnPosConfirm = new javax.swing.JButton();

        jpnlHeader.setBackground(new java.awt.Color(213, 208, 189));

        txtDcoffee.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        txtDcoffee.setText("D-Coffee");

        lblUserName.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserName.setText("UserName");

        javax.swing.GroupLayout jpnlHeaderLayout = new javax.swing.GroupLayout(jpnlHeader);
        jpnlHeader.setLayout(jpnlHeaderLayout);
        jpnlHeaderLayout.setHorizontalGroup(
            jpnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDcoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnlHeaderLayout.setVerticalGroup(
            jpnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnlHeaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblUserName))
                    .addComponent(txtDcoffee, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpnlDetail.setBackground(new java.awt.Color(170, 183, 173));

        tblRecieptDetail.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        tblRecieptDetail.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblRecieptDetail);

        jpnlMember.setBackground(new java.awt.Color(199, 195, 188));

        txtmemberName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtmemberName.setText("Member Name:");

        txtPhoneNumber.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtPhoneNumber.setText("Phone Number:");

        txtMemberPoint.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtMemberPoint.setText("Member Point:");

        txtPointEarn.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtPointEarn.setText("Point Earn:");

        txtMemberDiscount.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtMemberDiscount.setText("Member Discount:");

        txtTotalPoint.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtTotalPoint.setText("Total Point");

        lblMemberName.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblMemberName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMemberName.setText("-");

        lblPhoneNumber.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhoneNumber.setText("-");

        lblMemberPoint.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblMemberPoint.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMemberPoint.setText("-");

        lblPointEarn.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblPointEarn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPointEarn.setText("-");

        lblMemberDiscount.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblMemberDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMemberDiscount.setText("-");

        lblTotalPoint.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblTotalPoint.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalPoint.setText("-");

        txtPoint.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtPoint.setText("Point");

        txtPoint1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtPoint1.setText("Point");

        txtPoint2.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtPoint2.setText("Point");

        txtBaht.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtBaht.setText("Baht");

        javax.swing.GroupLayout jpnlMemberLayout = new javax.swing.GroupLayout(jpnlMember);
        jpnlMember.setLayout(jpnlMemberLayout);
        jpnlMemberLayout.setHorizontalGroup(
            jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlMemberLayout.createSequentialGroup()
                        .addComponent(txtmemberName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMemberName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpnlMemberLayout.createSequentialGroup()
                        .addComponent(txtPhoneNumber)
                        .addGap(2, 2, 2)
                        .addComponent(lblPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlMemberLayout.createSequentialGroup()
                        .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnlMemberLayout.createSequentialGroup()
                                .addComponent(txtTotalPoint)
                                .addGap(45, 45, 45)
                                .addComponent(lblTotalPoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlMemberLayout.createSequentialGroup()
                                .addComponent(txtMemberDiscount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMemberDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlMemberLayout.createSequentialGroup()
                                .addComponent(txtPointEarn)
                                .addGap(32, 32, 32)
                                .addComponent(lblPointEarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlMemberLayout.createSequentialGroup()
                                .addComponent(txtMemberPoint)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(lblMemberPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlMemberLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtPoint))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlMemberLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPoint1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPoint2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtBaht, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        jpnlMemberLayout.setVerticalGroup(
            jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmemberName)
                    .addComponent(lblMemberName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNumber)
                    .addComponent(lblPhoneNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMemberPoint)
                    .addComponent(lblMemberPoint)
                    .addComponent(txtPoint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPointEarn)
                    .addComponent(lblPointEarn)
                    .addComponent(txtPoint1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMemberDiscount)
                    .addComponent(lblMemberDiscount)
                    .addComponent(txtBaht))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPoint)
                    .addComponent(lblTotalPoint)
                    .addComponent(txtPoint2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnlCaculator.setBackground(new java.awt.Color(199, 195, 188));

        txtTotal.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtTotal.setText("Total:");

        txtDiscount.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtDiscount.setText("Discount:");

        txtTotalNet.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtTotalNet.setText("Total Net:");

        txtCash.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtCash.setText("Cash:");

        txtCange.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtCange.setText("Change:");

        txtBaht1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtBaht1.setText("Baht");

        txtBaht2.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtBaht2.setText("Baht");

        txtBaht3.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtBaht3.setText("Baht");

        txtBaht4.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtBaht4.setText("Baht");

        txtBaht5.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtBaht5.setText("Baht");

        lblTotal.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0");

        lblDiscount.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiscount.setText("0");

        lblTotalNet.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblTotalNet.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalNet.setText("0");

        lblCash.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblCash.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCash.setText("0");

        lblCange.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        lblCange.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCange.setText("0");

        javax.swing.GroupLayout jpnlCaculatorLayout = new javax.swing.GroupLayout(jpnlCaculator);
        jpnlCaculator.setLayout(jpnlCaculatorLayout);
        jpnlCaculatorLayout.setHorizontalGroup(
            jpnlCaculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlCaculatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlCaculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlCaculatorLayout.createSequentialGroup()
                        .addComponent(txtTotal)
                        .addGap(19, 19, 19)
                        .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBaht1))
                    .addGroup(jpnlCaculatorLayout.createSequentialGroup()
                        .addComponent(txtCange)
                        .addGap(13, 13, 13)
                        .addComponent(lblCange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBaht5))
                    .addGroup(jpnlCaculatorLayout.createSequentialGroup()
                        .addComponent(txtDiscount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBaht2))
                    .addGroup(jpnlCaculatorLayout.createSequentialGroup()
                        .addComponent(txtTotalNet)
                        .addGap(3, 3, 3)
                        .addComponent(lblTotalNet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBaht3))
                    .addGroup(jpnlCaculatorLayout.createSequentialGroup()
                        .addComponent(txtCash)
                        .addGap(28, 28, 28)
                        .addComponent(lblCash, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBaht4)))
                .addContainerGap())
        );
        jpnlCaculatorLayout.setVerticalGroup(
            jpnlCaculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlCaculatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlCaculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal)
                    .addComponent(txtBaht1)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlCaculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiscount)
                    .addComponent(txtBaht2)
                    .addComponent(lblDiscount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlCaculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalNet)
                    .addComponent(txtBaht3)
                    .addComponent(lblTotalNet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlCaculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCash)
                    .addComponent(txtBaht4)
                    .addComponent(lblCash))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlCaculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCange)
                    .addComponent(txtBaht5)
                    .addComponent(lblCange))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(170, 183, 173));

        btnDrinks.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnDrinks.setText("Drinks");

        btnDessert.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnDessert.setText("Dessert");

        btnFood.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnFood.setText("Food");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDessert, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFood, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDrinks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDessert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        txtItemList.setFont(new java.awt.Font("Kanit", 0, 24)); // NOI18N
        txtItemList.setText("Item List");

        btnPromotion.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnPromotion.setText("Promotion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        scrProductList.setViewportView(jPanel1);

        btnMainMenu.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnMainMenu.setText("MainMenu");

        btnFindMember.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnFindMember.setText("Find Member");

        btnAddMember.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnAddMember.setText("Add Member");

        btnCancel.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnCancel.setText("Cancel");

        btnPosConfirm.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnPosConfirm.setText("Confirm");
        btnPosConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlDetailLayout = new javax.swing.GroupLayout(jpnlDetail);
        jpnlDetail.setLayout(jpnlDetailLayout);
        jpnlDetailLayout.setHorizontalGroup(
            jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrProductList)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtItemList, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnlDetailLayout.createSequentialGroup()
                        .addComponent(jpnlMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnlCaculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlDetailLayout.createSequentialGroup()
                        .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddMember, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFindMember, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPosConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jpnlDetailLayout.setVerticalGroup(
            jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItemList, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDetailLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpnlMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnlCaculator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jpnlDetailLayout.createSequentialGroup()
                                    .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpnlDetailLayout.createSequentialGroup()
                                    .addComponent(btnFindMember, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAddMember, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpnlDetailLayout.createSequentialGroup()
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPosConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(scrProductList, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnlDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPosConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosConfirmActionPerformed
          RecieptService recieptService = new RecieptService();
        ProductService productService = new ProductService();
        RecieptDao recieptDao = new RecieptDao();
        
        Reciept reciept = new Reciept();
        reciept.setQueue(1);
        reciept.setPayment("cash");
        reciept.setStoreId(1);
        //set emplyee
        reciept.setEmployeeId(1);
        reciept.setReceive((float) Double.parseDouble(lblCange.getText()));
        float cash = (float) Double.parseDouble(lblCange.getText());
        
        

        
    }//GEN-LAST:event_btnPosConfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMember;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDessert;
    private javax.swing.JButton btnDrinks;
    private javax.swing.JButton btnFindMember;
    private javax.swing.JButton btnFood;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnPosConfirm;
    private javax.swing.JButton btnPromotion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpnlCaculator;
    private javax.swing.JPanel jpnlDetail;
    private javax.swing.JPanel jpnlHeader;
    private javax.swing.JPanel jpnlMember;
    private javax.swing.JLabel lblCange;
    private javax.swing.JLabel lblCash;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblMemberDiscount;
    private javax.swing.JLabel lblMemberName;
    private javax.swing.JLabel lblMemberPoint;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPointEarn;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalNet;
    private javax.swing.JLabel lblTotalPoint;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JScrollPane scrProductList;
    private javax.swing.JTable tblRecieptDetail;
    private javax.swing.JLabel txtBaht;
    private javax.swing.JLabel txtBaht1;
    private javax.swing.JLabel txtBaht2;
    private javax.swing.JLabel txtBaht3;
    private javax.swing.JLabel txtBaht4;
    private javax.swing.JLabel txtBaht5;
    private javax.swing.JLabel txtCange;
    private javax.swing.JLabel txtCash;
    private javax.swing.JLabel txtDcoffee;
    private javax.swing.JLabel txtDiscount;
    private javax.swing.JLabel txtItemList;
    private javax.swing.JLabel txtMemberDiscount;
    private javax.swing.JLabel txtMemberPoint;
    private javax.swing.JLabel txtPhoneNumber;
    private javax.swing.JLabel txtPoint;
    private javax.swing.JLabel txtPoint1;
    private javax.swing.JLabel txtPoint2;
    private javax.swing.JLabel txtPointEarn;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JLabel txtTotalNet;
    private javax.swing.JLabel txtTotalPoint;
    private javax.swing.JLabel txtmemberName;
    // End of variables declaration//GEN-END:variables
}
