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
    public void buy(Product product, int qty, String sizeName, float sizePrice, String toppingName, float toppingPrice, String sweetName, float sweetPrice, String typeName, float typePrice);
    public void chageCat(int catId);
}
