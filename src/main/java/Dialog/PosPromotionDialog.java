package Dialog;

import Component.PromotionObs;
import Model.Customer;
import Model.Promotion;
import Page.PosPanel;
import Service.PromotionService;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class PosPromotionDialog extends javax.swing.JDialog implements PromotionObs {

    private PromotionService promotionService;
    private Promotion editedPromotion;
    private ArrayList<Promotion> promotions;
    private ArrayList<PromotionObs> subscripts;
    private PosPanel pospanel;

    public PosPromotionDialog(java.awt.Frame parent, PosPanel pospanel) {
        super(parent, true);
        initComponents();
        initPromotion();
        initDateLable();
        this.pospanel = pospanel;
        this.subscripts = new ArrayList<PromotionObs>();
        addPromotionSub(pospanel);
        initTable();

    }

    private void initTable() {
        tblPosPromotion.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 16));
        tblPosPromotion.setModel(new AbstractTableModel() {
            String[] columnNames = {"ID", "Created Date", "End Date", "Name", "Discount", "Discount Perc", "Point Discount"};

            @Override
            public String getColumnName(int column) {
                return columnNames[column];
            }

            @Override
            public int getRowCount() {
                return promotions.size();
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
                Promotion promotion = promotions.get(rowIndex);
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

    private void initPromotion() {
        this.promotions = new ArrayList<Promotion>();
        this.promotionService = new PromotionService();
        promotions = (ArrayList<Promotion>) promotionService.getPromotions();
    }

    private void initDateLable() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = sdf.format(new Date());
        lblDate.setText("Date: " + formattedDate);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPosPromotion = new javax.swing.JTable();
        lblDate = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnCancel.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnConfirm.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirm)
                .addGap(9, 9, 9))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnConfirm))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblPosPromotion.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        tblPosPromotion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPosPromotion);

        lblDate.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDate.setText("Date:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(224, 205, 174));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblName.setFont(new java.awt.Font("Kanit", 1, 30)); // NOI18N
        lblName.setText("Payment period");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(lblName)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed

        int row = tblPosPromotion.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pase Select Index In Table");
            return;
        }
        TableModel model = tblPosPromotion.getModel();
        int index = Integer.parseInt(model.getValueAt(row, 0) + "");
        
        Promotion pro = promotionService.getById(index);
        System.out.println(pro.toString());
        setInfoPromotion(pro);
        this.dispose();


    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JTable tblPosPromotion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setInfoPromotion(Promotion promotion) {
        for (PromotionObs sub : subscripts) {
            sub.setInfoPromotion(promotion);
        }
    }

    public void addPromotionSub(PromotionObs sub) {
        subscripts.add(sub);
    }

}
