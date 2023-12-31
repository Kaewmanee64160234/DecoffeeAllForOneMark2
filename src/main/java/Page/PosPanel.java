/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Page;

import Component.BuyProductable;
import Component.ChagePage;
import Component.ProductListPanel;
import Dao.RecieptDao;
import Dialog.FindMemberDialog;
import Model.Reciept;
import Service.ProductService;

import Dialog.PromotionDialog;
import Model.Customer;

import Model.Product;
import Model.Promotion;
import Model.RecieptDetail;
import Service.RecieptService;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Component.CusObs;

import Component.PromotionObs;
import Dialog.AddCustomerDialog;
import Dialog.PosPromotionDialog;
import Service.CustomerService;
import Service.ValidateException;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;

import net.sf.jasperreports.engine.JRException;
import print.ReportManager;

import scrollbar.ScrollBarCustom;
import deleteInTable.TableActionCellRenderer;
import deleteInTable.TableActionCellEditor;
import deleteInTable.TableActionEvent;

/**
 *
 * @author toey
 */
public final class PosPanel extends javax.swing.JPanel implements ChagePage, BuyProductable, CusObs, PromotionObs {

    private ProductListPanel productListPanel;
    private final RecieptService recieptService;
    private List<RecieptDetail> list;
    private RecieptDetail editedRecieptDetail;
    private Promotion editedPromotion;
    private FindMemberDialog findMemberDialog;
    private Reciept reciept;
    private Promotion promotion;
    private Customer customer;
    private AddCustomerDialog addMemberDialog;
    private CustomerService customerService;
    private String payment;
    private int queue = 1;

    private ArrayList<ChagePage> subs;
    private ArrayList<ChagePage> chagpages;

    private ReportPanel reportPanel;

    public void setReportPanel(ReportPanel reportPanel) {
        this.reportPanel = reportPanel;
    }

    private ArrayList<CusObs> cusObs = new ArrayList<>();


    /**
     * Creates new form PosDialog
     */
    public PosPanel() {
        initComponents();
        subs = new ArrayList<>();
        this.productListPanel = new ProductListPanel(1);
        productListPanel.addOnBuyProduct(this);
        scrProductList.setViewportView(productListPanel);
        recieptService = new RecieptService();
        customerService = new CustomerService();
        reciept = new Reciept();
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        addMemberDialog = new AddCustomerDialog(frame);
        addMemberDialog.addSubs(this);
        initTable();
        this.reciept = new Reciept();
        this.promotion = new Promotion();
        initFindMemberDialog();
        scrProductList.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());

    }

    private void initTable() {
        deleteInTable.TableActionEvent event = new deleteInTable.TableActionEvent() {

            @Override
            public void onDelete(int row) {
                if (tblRecieptDetail.isEditing()) {
                    tblRecieptDetail.getCellEditor().stopCellEditing();
                }
                reciept.getRecieptDetails().remove(row);
                refreshTable();
                resetPOSLableByList();
                System.out.println("This is row: " + row);
            }
        };

        tblRecieptDetail.getTableHeader().setFont(new Font("Kanit", Font.PLAIN, 14));
        tblRecieptDetail.setRowHeight(50);
        tblRecieptDetail.setModel(new AbstractTableModel() {
            String[] headers = {"Name", "Price", "Qty", "Sizes", "Type", "Topping", "Sweet", "Total", "Action"};

            @Override
            public String getColumnName(int column) {
                return headers[column];
            }

            @Override
            public int getRowCount() {
                return reciept.getRecieptDetails().size();
            }

            @Override
            public int getColumnCount() {
                return 9;
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                ArrayList<RecieptDetail> recieptDetails = reciept.getRecieptDetails();
                RecieptDetail recieptDetail = recieptDetails.get(rowIndex);
                if (columnIndex == 2) {
                    int qty = Integer.parseInt((String) aValue);
                    System.out.println(qty);
                    if (qty < 1) {
                        return;
                    }

                    recieptDetail.setQty(qty);
                    reciept.calculateTotal();
                    refreshTable();

                }
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 2:
                        return true;
                    default:
                        return true;
                }
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                ArrayList<RecieptDetail> recieptDetails = reciept.getRecieptDetails();
                RecieptDetail recieptDetail = recieptDetails.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return recieptDetail.getName();
                    case 1:
                        return recieptDetail.getPrice();
                    case 2:
                        return recieptDetail.getQty();
                    case 3:
                        return recieptDetail.getSize();
                    case 4:
                        return recieptDetail.getType();
                    case 5:
                        return recieptDetail.getTopping();
                    case 6:
                        return recieptDetail.getSweet();
                    case 7:
                        return recieptDetail.getTotal();
                    case 8:
                        return new TableActionCellRenderer();
                    default:
                        return "";
                }
            }
        });
        tblRecieptDetail.setCellSelectionEnabled(true);
        tblRecieptDetail.setColumnSelectionAllowed(true);
        tblRecieptDetail.setSurrendersFocusOnKeystroke(true);
        tblRecieptDetail.getColumnModel().getColumn(8).setCellRenderer(new deleteInTable.TableActionCellRenderer());
        tblRecieptDetail.getColumnModel().getColumn(8).setCellEditor(new deleteInTable.TableActionCellEditor(event));
        tblRecieptDetail.getColumnModel().getColumn(2).setCellEditor(new QtyCellEditor());
        tblRecieptDetail.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);
                return this;
            }

        });

    }

    public class QtyCellEditor extends DefaultCellEditor {

        private JSpinner input;

        public QtyCellEditor() {
            super(new JTextField());
            input = new JSpinner();
            SpinnerNumberModel numberModel = (SpinnerNumberModel) input.getModel();
            numberModel.setMinimum(1);
            JSpinner.NumberEditor editor = (JSpinner.NumberEditor) input.getEditor();
            DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
            formatter.setCommitsOnValidEdit(true);
            editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
            input.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {

                }

            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            super.getTableCellEditorComponent(table, value, isSelected, row, column);
            int qty = Integer.parseInt(value.toString());
            input.setValue(qty);
            return input;
        }

        @Override
        public Object getCellEditorValue() {
            int qty = (int) input.getValue(); // Get the Integer value directly
            return String.valueOf(qty);

        }
    }

    private void initFindMemberDialog() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        this.findMemberDialog = new FindMemberDialog(frame, this);
        this.findMemberDialog.setInfoCustomer(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlHeader = new javax.swing.JPanel();
        txtDcoffee = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUserName1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRole1 = new javax.swing.JLabel();
        jpnlDetail = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRecieptDetail = new javax.swing.JTable();
        jpnlMember = new javax.swing.JPanel();
        txtmemberName = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JLabel();
        txtMemberPoint = new javax.swing.JLabel();
        txtPointEarn = new javax.swing.JLabel();
        txtTotalPoint = new javax.swing.JLabel();
        lblMemberName = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblMemberPoint = new javax.swing.JLabel();
        lblPointEarn = new javax.swing.JLabel();
        lblTotalPoint = new javax.swing.JLabel();
        txtPoint = new javax.swing.JLabel();
        txtPoint1 = new javax.swing.JLabel();
        txtPoint2 = new javax.swing.JLabel();
        lblPromotionName = new javax.swing.JLabel();
        lblPromotionNameShow = new javax.swing.JLabel();
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
        lblChange = new javax.swing.JLabel();
        lblCash = new javax.swing.JTextField();
        btnCalculator = new javax.swing.JButton();
        btnCash = new javax.swing.JButton();
        btnPromtpay = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnDrinks = new javax.swing.JButton();
        btnDessert = new javax.swing.JButton();
        btnFood = new javax.swing.JButton();
        txtItemList = new javax.swing.JLabel();
        btnPromotion = new javax.swing.JButton();
        scrProductList = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnFindMember = new javax.swing.JButton();
        btnAddMember = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnPosConfirm = new javax.swing.JButton();

        jpnlHeader.setBackground(new java.awt.Color(224, 205, 174));
        jpnlHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtDcoffee.setFont(new java.awt.Font("Kanit", 0, 36)); // NOI18N
        txtDcoffee.setText("D-Coffee");

        jLabel7.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel7.setText("User Name: ");

        txtUserName1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtUserName1.setText("Name");

        jLabel8.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        jLabel8.setText("Role:");

        txtRole1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
        txtRole1.setText("Role");

        javax.swing.GroupLayout jpnlHeaderLayout = new javax.swing.GroupLayout(jpnlHeader);
        jpnlHeader.setLayout(jpnlHeaderLayout);
        jpnlHeaderLayout.setHorizontalGroup(
            jpnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDcoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRole1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpnlHeaderLayout.setVerticalGroup(
            jpnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnlHeaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtUserName1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtRole1)))
                    .addComponent(txtDcoffee, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpnlDetail.setBackground(new java.awt.Color(255, 255, 255));

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

        jpnlMember.setBackground(new java.awt.Color(255, 255, 255));

        txtmemberName.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtmemberName.setText("Member Name:");

        txtPhoneNumber.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtPhoneNumber.setText("Phone Number:");

        txtMemberPoint.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtMemberPoint.setText("Member Point:");

        txtPointEarn.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtPointEarn.setText("Point Earn:");

        txtTotalPoint.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtTotalPoint.setText("Total Point");

        lblMemberName.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblMemberName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMemberName.setText("-");

        lblPhoneNumber.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhoneNumber.setText("-");

        lblMemberPoint.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblMemberPoint.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMemberPoint.setText("0");

        lblPointEarn.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblPointEarn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPointEarn.setText("0");

        lblTotalPoint.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblTotalPoint.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalPoint.setText("0");

        txtPoint.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtPoint.setText("Point");

        txtPoint1.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtPoint1.setText("Point");

        txtPoint2.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtPoint2.setText("Point");

        lblPromotionName.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblPromotionName.setText("Promotion:");

        lblPromotionNameShow.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblPromotionNameShow.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPromotionNameShow.setText("-");

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
                        .addComponent(txtMemberPoint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                        .addComponent(lblMemberPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPoint))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlMemberLayout.createSequentialGroup()
                        .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnlMemberLayout.createSequentialGroup()
                                .addComponent(txtPointEarn)
                                .addGap(32, 32, 32)
                                .addComponent(lblPointEarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpnlMemberLayout.createSequentialGroup()
                                .addComponent(txtTotalPoint)
                                .addGap(45, 45, 45)
                                .addComponent(lblTotalPoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnlMemberLayout.createSequentialGroup()
                                .addComponent(lblPromotionName)
                                .addGap(32, 32, 32)
                                .addComponent(lblPromotionNameShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPoint2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPoint1, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                    .addComponent(lblPromotionName)
                    .addComponent(lblPromotionNameShow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPoint)
                    .addComponent(lblTotalPoint)
                    .addComponent(txtPoint2))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jpnlCaculator.setBackground(new java.awt.Color(255, 255, 255));

        txtTotal.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtTotal.setText("Total:");

        txtDiscount.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtDiscount.setText("Discount:");

        txtTotalNet.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtTotalNet.setText("Total Net:");

        txtCash.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtCash.setText("Cash:");

        txtCange.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtCange.setText("Change:");

        txtBaht1.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtBaht1.setText("Baht");

        txtBaht2.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtBaht2.setText("Baht");

        txtBaht3.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtBaht3.setText("Baht");

        txtBaht4.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtBaht4.setText("Baht");

        txtBaht5.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        txtBaht5.setText("Baht");

        lblTotal.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0");

        lblDiscount.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiscount.setText("0");

        lblTotalNet.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblTotalNet.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalNet.setText("0");

        lblChange.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblChange.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblChange.setText("0");

        lblCash.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        lblCash.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lblCash.setText("0");

        btnCalculator.setBackground(new java.awt.Color(255, 184, 76));
        btnCalculator.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnCalculator.setForeground(new java.awt.Color(255, 255, 255));
        btnCalculator.setText("Calculator");
        btnCalculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculatorActionPerformed(evt);
            }
        });

        btnCash.setBackground(new java.awt.Color(8, 131, 149));
        btnCash.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnCash.setForeground(new java.awt.Color(255, 255, 255));
        btnCash.setText("Cash");
        btnCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCashActionPerformed(evt);
            }
        });

        btnPromtpay.setBackground(new java.awt.Color(128, 179, 255));
        btnPromtpay.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnPromtpay.setForeground(new java.awt.Color(255, 255, 255));
        btnPromtpay.setText("Promtpay");
        btnPromtpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromtpayActionPerformed(evt);
            }
        });

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
                        .addComponent(lblChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                        .addComponent(lblCash, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBaht4))
                    .addGroup(jpnlCaculatorLayout.createSequentialGroup()
                        .addComponent(btnPromtpay, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCash, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCalculator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(lblCash, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlCaculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCange)
                    .addComponent(txtBaht5)
                    .addComponent(lblChange))
                .addGap(18, 18, 18)
                .addComponent(btnCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlCaculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCash, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPromtpay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnDrinks.setBackground(new java.awt.Color(138, 108, 81));
        btnDrinks.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnDrinks.setForeground(new java.awt.Color(255, 255, 255));
        btnDrinks.setText("Drinks");
        btnDrinks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDrinksMouseClicked(evt);
            }
        });
        btnDrinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrinksActionPerformed(evt);
            }
        });

        btnDessert.setBackground(new java.awt.Color(138, 108, 81));
        btnDessert.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnDessert.setForeground(new java.awt.Color(255, 255, 255));
        btnDessert.setText("Dessert");
        btnDessert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDessertMouseClicked(evt);
            }
        });
        btnDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDessertActionPerformed(evt);
            }
        });

        btnFood.setBackground(new java.awt.Color(138, 108, 81));
        btnFood.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnFood.setForeground(new java.awt.Color(255, 255, 255));
        btnFood.setText("Food");
        btnFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFoodMouseClicked(evt);
            }
        });


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
                    .addComponent(btnDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnDessert, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnFood, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );

        txtItemList.setFont(new java.awt.Font("Kanit", 0, 24)); // NOI18N
        txtItemList.setText("Item List");

        btnPromotion.setBackground(new java.awt.Color(173, 108, 128));
        btnPromotion.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnPromotion.setForeground(new java.awt.Color(255, 255, 255));
        btnPromotion.setText("Promotion");
        btnPromotion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPromotionMouseClicked(evt);
            }
        });
        btnPromotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromotionActionPerformed(evt);
            }
        });

        scrProductList.setBackground(new java.awt.Color(255, 251, 245));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
        );

        scrProductList.setViewportView(jPanel1);

        btnFindMember.setBackground(new java.awt.Color(65, 145, 151));
        btnFindMember.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnFindMember.setForeground(new java.awt.Color(255, 255, 255));
        btnFindMember.setText("Find Member");
        btnFindMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFindMemberMouseClicked(evt);
            }
        });
        btnFindMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindMemberActionPerformed(evt);
            }
        });

        btnAddMember.setBackground(new java.awt.Color(141, 114, 225));
        btnAddMember.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnAddMember.setForeground(new java.awt.Color(255, 255, 255));
        btnAddMember.setText("Add Member");
        btnAddMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMemberMouseClicked(evt);
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

        btnPosConfirm.setBackground(new java.awt.Color(93, 156, 89));
        btnPosConfirm.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        btnPosConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnPosConfirm.setText("Confirm");
        btnPosConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPosConfirmMouseClicked(evt);
            }
        });
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
                .addGap(5, 5, 5)
                .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrProductList)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDetailLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtItemList, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnlDetailLayout.createSequentialGroup()
                                .addComponent(jpnlMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpnlCaculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlDetailLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnFindMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPromotion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPosConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpnlCaculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnlMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFindMember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnPosConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnAddMember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)))
                    .addComponent(scrProductList, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPosConfirmMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnPosConfirmMouseClicked
        if (!reciept.getPayment().equals("QR")) {
            if (Float.parseFloat(lblCash.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "You are not paid.");
                return;
            }
            float total = Float.parseFloat(lblCash.getText()) - Float.parseFloat(lblTotalNet.getText());

            if (total < 0) {

                JOptionPane.showMessageDialog(this, "Your monry  not emoghe.");
                return;
            }
        }
        if (reciept.getRecieptDetails().size() <= 0) {
            JOptionPane.showMessageDialog(this, "Detail is emplty");
            return;
        }
        if (Float.parseFloat(lblTotalNet.getText()) <= 0) {
            reciept.setReceive(0);

        }
        if (reciept.getCustomerId() > 0) {
            int point = (int) (reciept.getTotal() / 50);
            customer.setPoint(point + customer.getPoint());
            System.out.println("Customer point +" + customer.getPoint());
            try {
                Customer updatedCus = customerService.update(customer);
                System.out.println(updatedCus.toString());
            } catch (ValidateException ex) {
                Logger.getLogger(PosPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        float total = Float.parseFloat(lblCash.getText()) - Float.parseFloat(lblTotalNet.getText());

        reciept.setStoreId(1);
        reciept.setQueue(1);
        reciept.setDiscount(Float.parseFloat(lblDiscount.getText()));
        // set befor implement login
        reciept.setCustomerId(1);
        reciept.setReceive(Float.parseFloat(lblCash.getText()));
        reciept.setChange(Float.parseFloat(lblChange.getText()));
        reciept.setEmployeeId(1);
        reciept.setQueue(queue);
        // Save
        Reciept new_re = recieptService.addNew(reciept);

        try {
            ReportManager.getInstance().complieReport();
            ReportManager.getInstance().printReport(new_re);

        } catch (JRException ex) {
            Logger.getLogger(PosPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(new_re.toString());
        System.out.println("Save !!!!!");
        reciept = new Reciept();
        queue++;
        resetPOSLable();
        refreshTable();

    }// GEN-LAST:event_btnPosConfirmMouseClicked

    private void btnPromtpayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPromtpayActionPerformed
        if (reciept.getRecieptDetails().size() <= 0) {
            JOptionPane.showMessageDialog(this, "Detail is emplty");
            return;
        }
        lblCash.setText(lblTotalNet.getText());
        lblChange.setText("0");
        payment = "QR";
        reciept.setPayment(payment);
        btnCash.setEnabled(false);
        btnCalculator.setEnabled(true);
    }

    private void btnCalculatorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCalculatorActionPerformed
        if (reciept.getRecieptDetails().size() <= 0) {
            JOptionPane.showMessageDialog(this, "Detail is emplty");
            return;
        }

        if (Float.parseFloat(lblCash.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "You are not paid.");
            return;
        }
        float total = Float.parseFloat(lblCash.getText()) - Float.parseFloat(lblTotalNet.getText());

        if (total < 0) {
            JOptionPane.showMessageDialog(this, "Your money not enough.");
            return;
        }

        if (Float.parseFloat(lblTotalNet.getText()) <= 0) {
            reciept.setReceive(0);

        }
//        payment = "cash";
//        reciept.setPayment(payment);
        lblChange.setText("" + total);
        btnCash.setEnabled(true);
        btnPromtpay.setEnabled(true);
    }

    private void btnCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashActionPerformed
        if (reciept.getRecieptDetails().size() <= 0) {
            JOptionPane.showMessageDialog(this, "Detail is emplty");
            return;
        }
        payment = "cash";
        reciept.setPayment(payment);
        btnPromtpay.setEnabled(false);
        btnCalculator.setEnabled(true);
    }//GEN-LAST:event_btnCashActionPerformed

    public void addInSubs(ChagePage chagePage) {
        subs.add(chagePage);
    }
    private void btnPromotionMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnPromotionMouseClicked
        // TODO add your handling code here:
        openDialog();
    }// GEN-LAST:event_btnPromotionMouseClicked

    private void btnFindMemberMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnFindMemberMouseClicked
        openDialogFindMember();
        // TODO add your handling code here:
    }// GEN-LAST:event_btnFindMemberMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        reciept = new Reciept();
        btnCash.setEnabled(true);
        btnPromtpay.setEnabled(true);
        btnCalculator.setEnabled(true);
        queue++;
        resetPOSLable();
        refreshTable();
    }// GEN-LAST:event_btnCancelActionPerformed

    private void btnAddMemberMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnAddMemberMouseClicked
        // TODO add your handling code here:
        addMemberDialog.setLocationRelativeTo(this); // set dialog to center
        addMemberDialog.setVisible(true);

    }// GEN-LAST:event_btnAddMemberMouseClicked

    private void resetPOSLable() {
        lblMemberName.setText("-");
        lblPhoneNumber.setText("-");
        lblMemberPoint.setText("0");
        lblPointEarn.setText("0");
        lblPromotionNameShow.setText("0");
        lblTotalPoint.setText("0");
        lblTotal.setText("0 ");
        lblDiscount.setText("0");
        lblTotalNet.setText("0");
        lblCash.setText("0");
        lblChange.setText("0");
    }

    private void resetPOSLableByList() {
        reciept.calculateTotal();
        lblTotal.setText(reciept.getTotal() + "");
        lblTotalNet.setText(reciept.getTotal() + "");
        lblChange.setText(reciept.getChange() + "");
    }

    private void btnPosConfirmActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPosConfirmActionPerformed
        RecieptService recieptService = new RecieptService();
        ProductService productService = new ProductService();
        RecieptDao recieptDao = new RecieptDao();

        Reciept reciept = new Reciept();
        reciept.setQueue(1);
        reciept.setStoreId(1);
        reciept.setPayment(payment);
        // set emplyee
        reciept.setEmployeeId(1);
        reciept.setReceive((float) Double.parseDouble(lblChange.getText()));
        float cash = (float) Double.parseDouble(lblChange.getText());

        btnCalculator.setEnabled(true);
        btnPromtpay.setEnabled(true);
    }// GEN-LAST:event_btnPosConfirmActionPerformed

    private void btnDrinksActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDrinksActionPerformed
        // TODO add your handling code here:

    }// GEN-LAST:event_btnDrinksActionPerformed

    private void btnPromotionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPromotionActionPerformed
        editedPromotion = new Promotion();
        openDialog();
    }// GEN-LAST:event_btnPromotionActionPerformed

    private void btnDrinksMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnDrinksMouseClicked
        // TODO add your handling code here:

        chageCat(1);

    }// GEN-LAST:event_btnDrinksMouseClicked

    private void btnDessertMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnDessertMouseClicked
        // TODO add your handling code here:

        chageCat(2);

    }// GEN-LAST:event_btnDessertMouseClicked

    private void btnFoodMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnFoodMouseClicked
        // TODO add your handling code here:

        chageCat(3);

    }// GEN-LAST:event_btnFoodMouseClicked

    private void btnDessertActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDessertActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnDessertActionPerformed

    private void btnFindMemberActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFindMemberActionPerformed
        // TODO add your handling code here:
        openDialogFindMember();
    }// GEN-LAST:event_btnFindMemberActionPerformed

    private void openDialog() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        PosPromotionDialog posPromotionDailog = new PosPromotionDialog(frame, this);
        posPromotionDailog.setLocationRelativeTo(this); // set dialog to center
        posPromotionDailog.setVisible(true);
        posPromotionDailog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refreshTable();
            }

        });

    }

    private void openDialogFindMember() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);

        FindMemberDialog findMemberDialog = new FindMemberDialog(frame, this);
        findMemberDialog.setLocationRelativeTo(this); // set dialog to center
        findMemberDialog.setVisible(true);
    }

    private void refreshTable() {
        // list = recieptService.getReciepts();
        tblRecieptDetail.revalidate();
        tblRecieptDetail.repaint();
        lblTotal.setText(reciept.getTotal() + "");
        lblTotalNet.setText(reciept.getTotal() - Float.parseFloat(lblDiscount.getText()) + "");
    }

    @Override
    public void chagePage(String pageName) {
        for (ChagePage sub : subs) {
            sub.chagePage(pageName);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMember;
    private javax.swing.JButton btnCalculator;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCash;
    private javax.swing.JButton btnDessert;
    private javax.swing.JButton btnDrinks;
    private javax.swing.JButton btnFindMember;
    private javax.swing.JButton btnFood;
    private javax.swing.JButton btnPosConfirm;
    private javax.swing.JButton btnPromotion;
    private javax.swing.JButton btnPromtpay;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpnlCaculator;
    private javax.swing.JPanel jpnlDetail;
    private javax.swing.JPanel jpnlHeader;
    private javax.swing.JPanel jpnlMember;
    private javax.swing.JTextField lblCash;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblMemberName;
    private javax.swing.JLabel lblMemberPoint;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPointEarn;
    private javax.swing.JLabel lblPromotionName;
    private javax.swing.JLabel lblPromotionNameShow;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalNet;
    private javax.swing.JLabel lblTotalPoint;
    private javax.swing.JScrollPane scrProductList;
    private javax.swing.JTable tblRecieptDetail;
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
    private javax.swing.JLabel txtMemberPoint;
    private javax.swing.JLabel txtPhoneNumber;
    private javax.swing.JLabel txtPoint;
    private javax.swing.JLabel txtPoint1;
    private javax.swing.JLabel txtPoint2;
    private javax.swing.JLabel txtPointEarn;
    private javax.swing.JLabel txtRole1;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JLabel txtTotalNet;
    private javax.swing.JLabel txtTotalPoint;
    private javax.swing.JLabel txtUserName1;
    private javax.swing.JLabel txtmemberName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void buy(Product product, int qty, String sizeName, float sizePrice, String toppingName, float toppingPrice,
            String sweetName, float sweetPrice, String typeName, float typePrice) {
        reciept.addReceiptDetail(product, qty, sizeName, sizePrice, toppingName, toppingPrice, sweetName, sweetPrice,
                typeName, typePrice);
        if (reciept.getPromotion() != null && reciept.getPromotion().getDiscountPerc() > 0) {
            double presentForCal = (Double.parseDouble(promotion.getDiscountPerc() + "") / 100);
            lblDiscount.setText((presentForCal * reciept.getTotal()) + "");
        }
        refreshTable();
        reciept.calculateTotal();
        lblTotal.setText(reciept.getTotal() + "");

    }

    @Override
    public void chageCat(int catId) {
        productListPanel = new ProductListPanel(catId);
        productListPanel.addOnBuyProduct(this);
        scrProductList.setViewportView(productListPanel);
        
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.customer = customer;
        reciept.setCustomer(customer);
        reciept.setCustomerId(customer.getId());
        System.out.println("Page.PosPanel" + reciept.getCustomer().toString());
        lblMemberName.setText(customer.getName());
        lblMemberPoint.setText(customer.getPoint() + "");
        lblPhoneNumber.setText(customer.getTel());
        lblTotalPoint.setText((customer.getPoint() - Integer.parseInt(lblPointEarn.getText())) + "");
        for (CusObs cd : cusObs) {
            cd.updateCustomer(customer);
        }
        
    }
     public void addSubs(CusObs cusObss) {
        cusObs.add(cusObss);

    }


    @Override
    public void setInfoPromotion(Promotion promotion) {
        this.promotion = promotion;

        if (promotion.getPointDiscount() == 0) {
            validateNotCusUsePromotion(promotion);
            setTotalNet();
            return;
        }

        validateCusUsePromotion(promotion);

    }

    private void setTotalNet() {
        double totalNet = reciept.getTotal() - Double.parseDouble(lblDiscount.getText());
        lblTotal.setText(reciept.getTotal() + "");
        lblTotalNet.setText(totalNet + "");

    }

    private void validateNotCusUsePromotion(Promotion promotion1) {
        // not cus

        System.out.println("Page.PosPanel.validateNotCusUsePromotion()");
        reciept.setPromotion(promotion1);
        reciept.setPromotionId(promotion1.getId());
        System.out.println(promotion1.toString());
        if (promotion1.getDiscountPerc() > 0) {

            lblDiscount.setText(((promotion1.getDiscountPerc() / 100)) * reciept.getTotal() + "");
        } else {
            lblDiscount.setText(promotion1.getDiscount() + "");
        }
        lblPointEarn.setText(promotion1.getPointDiscount() + "");
        lblPromotionNameShow.setText(promotion1.getName());
        lblTotalPoint.setText(0 + "");
        if (promotion1.getDiscountPerc() != 0) {
            double presentForCal = (Double.parseDouble(promotion1.getDiscountPerc() + "") / 100);
            lblDiscount.setText((presentForCal * reciept.getTotal()) + "");
        }
        if (promotion1.getDiscount() != 0) {
            lblDiscount.setText(promotion1.getDiscount() + "");
        }
        lblPointEarn.setText(promotion1.getPointDiscount() + "");
        lblPromotionNameShow.setText(promotion1.getName());
        lblTotalPoint.setText(0 + "");

    }

    private boolean validateCusUsePromotion(Promotion promotion1) {
        // cus

        if (reciept.getCustomerId() < 0 && promotion1.getPointDiscount() > 0) {
            JOptionPane.showMessageDialog(this, "This Promotion for Member");
            return true;
        }
        int totalPoint = reciept.getCustomer().getPoint() - promotion1.getPointDiscount();
        if (totalPoint < 0) {
            JOptionPane.showMessageDialog(this, "Point Not Enogh");
            return true;
        }
        reciept.setPromotion(promotion1);
        reciept.setPromotionId(promotion1.getId());
        if (promotion1.getDiscountPerc() != 0) {
            double presentForCal = (Double.parseDouble(promotion1.getDiscountPerc() + "") / 100);
            lblDiscount.setText((presentForCal * reciept.getTotal()) + "");

        } else {
            lblDiscount.setText(promotion1.getDiscount() + "");
        }
        lblPointEarn.setText(promotion1.getPointDiscount() + "");
        reciept.setDiscount(promotion1.getPointDiscount());
        lblPromotionNameShow.setText(promotion1.getName());
        lblTotalPoint.setText(totalPoint + "");
        setTotalNet();
        return false;
    }

}
