/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.ResultSet;



/**
 *
 * @author USER
 */
public class RecieptDetail {

    private int id;
    private String name;
    private int qty;
    private float price;
    private String size;
    private float typePrice;
    private String type;
    private float sizePrice;
    private String topping;
    private float toppingPrice;
    private float total;
    private int recieptId;
    private int productId;
    private Product product;
    private Reciept reciept;

    public RecieptDetail(int id, String name, int qty, float price, String size, float typePrice, String type, float sizePrice, String topping, float toppingPrice, float total, int recieptId, int productId) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.size = size;
        this.typePrice = typePrice;
        this.type = type;
        this.sizePrice = sizePrice;
        this.topping = topping;
        this.toppingPrice = toppingPrice;
        this.total = total;
        this.recieptId = recieptId;
        this.productId = productId;
    }

    public RecieptDetail(String name, int qty, float price, String size, float typePrice, String type, float sizePrice, String topping, float toppingPrice, float total, int recieptId, int productId) {
        this.id = -1;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.size = size;
        this.typePrice = typePrice;
        this.type = type;
        this.sizePrice = sizePrice;
        this.topping = topping;
        this.toppingPrice = toppingPrice;
        this.total = total;
        this.recieptId = recieptId;
        this.productId = productId;
    }

    public RecieptDetail() {
        this.id = -1;
        this.name = "";
        this.qty = 0;
        this.price = 0;
        this.size = "";
        this.typePrice = 0;
        this.type = "";
        this.sizePrice = 0;
        this.topping = "";
        this.toppingPrice = 0;
        this.total = 0;
        this.recieptId = -1;
        this.productId = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
        total = qty*price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getTypePrice() {
        return typePrice;
    }

    public void setTypePrice(float typePrice) {
        this.typePrice = typePrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(float sizePrice) {
        this.sizePrice = sizePrice;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public float getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(float toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getRecieptId() {
        return recieptId;
    }

    public void setRecieptId(int recieptId) {
        this.recieptId = recieptId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Reciept getReciept() {
        return reciept;
    }

    public void setReciept(Reciept reciept) {
        this.reciept = reciept;
    }

    @Override
    public String toString() {
        return "RecieptDetail{" + "id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + ", size=" + size + ", typePrice=" + typePrice + ", type=" + type + ", sizePrice=" + sizePrice + ", topping=" + topping + ", toppingPrice=" + toppingPrice + ", total=" + total + ", recieptId=" + recieptId + ", productId=" + productId + ", product=" + product + ", reciept=" + reciept + '}';
    }
    

    public static RecieptDetail fromRS(ResultSet rs){
        RecieptDetail recieptDetail = new RecieptDetail();
        try{
            recieptDetail.setId(rs.getInt("reciept_detail_id"));
            recieptDetail.setName(rs.getString("reciept_detail_name"));
            recieptDetail.setQty(rs.getInt("reciept_detail_qty"));
            recieptDetail.setPrice(rs.getFloat("reciept_detail_price"));
            recieptDetail.setSize(rs.getString("reciept_detail_size"));
            recieptDetail.setTypePrice(rs.getFloat("type_price"));
            recieptDetail.setType(rs.getString("type"));
            recieptDetail.setSizePrice(rs.getFloat("size_price"));
            recieptDetail.setTopping(rs.getString("topping"));
            recieptDetail.setToppingPrice(rs.getFloat("topping_price"));
            recieptDetail.setTotal(rs.getFloat("reciept_detail_total_price"));
            recieptDetail.setRecieptId(rs.getInt("reciept_id"));
            recieptDetail.setProductId(rs.getInt("product_id"));
        }catch(Exception e){
            System.out.println("Error on RecieptDetail.java FromRS: "+e);
        return null;
        }
        return recieptDetail;
    }
    
    

    

}
