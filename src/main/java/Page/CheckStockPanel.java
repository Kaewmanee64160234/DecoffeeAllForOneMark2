package Page;

import Component.ChagePage;
import Component.LoginObs;
import Model.CheckMaterial;
import Model.CheckMaterialDetail;
import Model.Employee;
import Model.Material;
import Model.User;
import Service.CheckMaterialService;
import Service.CheckinoutService;
import Service.EmployeeService;
import Service.MaterialService;
import Service.UserService;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import scrollbar.ScrollBarCustom;

public class CheckStockPanel extends javax.swing.JPanel implements ChagePage, LoginObs,DataUpdateObserver{

    private final MaterialService materialService;
    private List<Material> list;
    private Material editedMaterial;
    private ArrayList<ChagePage> subs;
    private ArrayList<ChagePage> chagpages;
    private Employee employee = new Employee();
    private ArrayList<DataUpdateObserver> dataUpdateObservers = new ArrayList<>();

    // OVS
    private MaterialPanel materialPanel;

    public void setMaterialPanel(MaterialPanel materialPanel) {
        this.materialPanel = materialPanel;
    }


    public CheckStockPanel() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        subs = new ArrayList<>();
        int number = 0;
        materialService = new MaterialService();
        list = materialService.getMaterials();
        tblCheckStock.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 16));
        tblCheckStock.setModel(new AbstractTableModel() {
            String[] columnNames = {"Id", "Name", "Number", "Minnimum", "Unit"};

            @Override
            public int getRowCount() {
                return list.size();
            }

            @Override
            public int getColumnCount() {
                return columnNames.length;
            }

            @Override
            public String getColumnName(int column) {
                return columnNames[column];

            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Material material = list.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return material.getId();
                    case 1:
                        return material.getName();
                    case 2:
                        return material.getMatQty();
                    case 3:
                        return material.getMatMinQty();
                    case 4:
                        return material.getMatUnit();
                    default:
                        return null;
                }
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

                Material material = list.get(rowIndex);
                if (columnIndex == 2) {
                    int qty = Integer.parseInt(aValue.toString());
                    if (qty < 1) {
                        return;
                    }

                    list.get(rowIndex).setMatQty(qty);
                    System.out.println(list.get(rowIndex).toString());
                    refreshTable();
                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 2;

            }

        });
    }

    public void addInSubs(ChagePage chagePage) {
        subs.add(chagePage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRole = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCheckStock = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(224, 205, 174));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(521, 76));

        jLabel1.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        jLabel1.setText("Check Stock");

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtUserName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtRole)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblCheckStock.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        tblCheckStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Number", "Minnimum", "Unit"
            }
        ));
        tblCheckStock.setSelectionBackground(new java.awt.Color(213, 208, 189));
        jScrollPane1.setViewportView(tblCheckStock);

        btnBack.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnConfirm.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirm)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnConfirm))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        chagePage("Material");
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
//        if (saveCheckStockDetail()) {
//            JOptionPane.showMessageDialog(this, "Update Material Complete.");
//            chagePage("Material");
//        }
//        refreshTable();

        if (saveCheckStockDetail()) {
            list = materialService.getMaterials();
            refreshTable();
            JOptionPane.showMessageDialog(this, "Update Material Complete.");


                onDataUpdated();


            chagePage("Material");
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private boolean saveCheckStockDetail() {
        try {
            CheckMaterialService checkMatService = new CheckMaterialService();
            CheckMaterial checkMaterial = new CheckMaterial();
            checkMaterial.setEmployeeId(employee.getId());
            ArrayList<CheckMaterialDetail> checkMaterialDetails = new ArrayList<>();
            //set last mat in matdetail
            for (Material material : materialService.getMaterials()) {
                System.out.println(material.getMatQty());
                CheckMaterialDetail checkMaterialDetail = new CheckMaterialDetail(material.getName(), material.getMatQty(), 1, material.getId());
                checkMaterialDetails.add(checkMaterialDetail);
            }
            //set current qty
            checkMaterial.setDetails(checkMaterialDetails);
            ArrayList<CheckMaterialDetail> checkMaterialDetails_ = new ArrayList<>();
            int count = 0;
            for (CheckMaterialDetail detail : checkMaterial.getDetails()) {
                detail.setQty(list.get(count).getMatQty());
                count++;
                checkMaterialDetails_.add(detail);
            }
            checkMaterial.setDetails(checkMaterialDetails_);

//create chekStock
            checkMatService.addNew(checkMaterial);
//update Mat
            for (Material material : list) {
                materialService.update(material);
            }
            list = materialService.getMaterials();
            return true;

        } catch (Exception e) {
            System.err.println("Error");
            return false;
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCheckStock;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration//GEN-END:variables

    private void refreshTable() {
        tblCheckStock.revalidate();
        tblCheckStock.repaint();

  
         onDataUpdated();
  
    }

    @Override
    public void chagePage(String pageName) {
        for (ChagePage sub : subs) {
            sub.chagePage(pageName);
        }
    }

    @Override
    public void loginData(User user) {
       EmployeeService employeeService = new EmployeeService();
       employee = employeeService.getEmployeebyUserId(user.getId());
       
        txtUserName.setText(user.getUsername());
        txtRole.setText(user.getRole());


    }
    
    public  void addInupdate (DataUpdateObserver dataUpdateObserver){
        dataUpdateObservers.add(dataUpdateObserver);
    }

    @Override
    public void onDataUpdated() {
        for (DataUpdateObserver dataUpdateObserver : dataUpdateObservers) {
            dataUpdateObserver.onDataUpdated();
            
        }
   
    }
}
