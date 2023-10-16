/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Component;

import Model.Product;

/**
 *
 * @author toey
 */
public interface BuyProductable {
    public void buy(Product product, int qty);
    public void chageCat(int catId);
}
