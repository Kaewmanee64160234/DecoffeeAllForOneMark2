/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package  Component;

import Component.BuyProductable;
import Model.Product;
import Service.ProductService;
import java.awt.GridLayout;
import java.util.ArrayList;


/**
 *
 * @author toey
 */
public class ProductListPanel extends javax.swing.JPanel implements BuyProductable{

    private final ProductService productService;
    private ArrayList<Product> products;
    private ArrayList<BuyProductable> subscibers = new ArrayList();


    /**
     * Creates new form ProductListPanel
     */
    public ProductListPanel(int CatId) {
        initComponents();
        productService = new ProductService();
        products = new ArrayList<Product>();
        products = productService.getProductsByCatId(CatId);

        int productSize = products.size();
        for (Product p : products) {
            ProductItemPanel pnlProductItem = new ProductItemPanel(p);
            pnlProductItem.addOnBuyProduct(this);
            pnlProductList.add(pnlProductItem);
        }
        pnlProductList.setLayout(new GridLayout((productSize / 3) + ((productSize % 3 != 0) ? 1 : 0), 3, 0, 0));
    }
    
    public void addOnBuyProduct(BuyProductable subsciber) {
        subscibers.add(subsciber);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProductList = new javax.swing.JPanel();

        javax.swing.GroupLayout pnlProductListLayout = new javax.swing.GroupLayout(pnlProductList);
        pnlProductList.setLayout(pnlProductListLayout);
        pnlProductListLayout.setHorizontalGroup(
            pnlProductListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        pnlProductListLayout.setVerticalGroup(
            pnlProductListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(pnlProductList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(pnlProductList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlProductList;
    // End of variables declaration//GEN-END:variables


    @Override
    public void buy(Product product, int qty) {
        System.out.println("" + product.getName() + " " + qty);
        for(BuyProductable s: subscibers) {
                    s.buy(product, qty);
                }
    }

    @Override
    public void chageCat(int catId) {

        int productSize = products.size();
        for (Product p : products) {
            ProductItemPanel pnlProductItem = new ProductItemPanel(p);
            pnlProductItem.addOnBuyProduct(this);
            pnlProductList.add(pnlProductItem);
        }
        pnlProductList.setLayout(new GridLayout((productSize / 3) + ((productSize % 3 != 0) ? 1 : 0), 3, 0, 0));
    }

}
