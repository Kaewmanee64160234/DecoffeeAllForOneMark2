/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Reciept {
    private int id;
    private Date creaetedDate;
    private int queue;
    private float discount;
    private float total;
    private float receive;
    private float change;
    private int totalQTY;
    private String payment;
    private int storeId;
    private int customerId;
    private int promotionId;
    private int employeeId;
    private Customer customer;
    private Promotion promotion;
    private Employee employee;
    private Store store;
    private ArrayList<RecieptDetail> recieptDetails = new ArrayList();
// all
    public Reciept(int id, Date creaetedDate, int queue, float discount, float total, float receive, float change,
            int totalQTY, String payment, int storeId, int customerId, int promotionId) {
        this.id = id;
        this.creaetedDate = creaetedDate;
        this.queue = queue;
        this.discount = discount;
        this.total = total;
        this.receive = receive;
        this.change = change;
        this.totalQTY = totalQTY;
        this.payment = payment;
        this.storeId = storeId;
        this.customerId = customerId;
        this.promotionId = promotionId;
    }

    public ArrayList<RecieptDetail> getRecieptDetails() {
        return recieptDetails;
    }

    public void setRecieptDetails(ArrayList recieptDetails) {
        this.recieptDetails = recieptDetails;
    }
//not id
    public Reciept(Date creaetedDate, int queue, float discount, float total, float receive, float change, int totalQTY,
            String payment, int storeId, int customerId, int promotionId) {
         this.id = -1;
        this.creaetedDate = creaetedDate;
        this.queue = queue;
        this.discount = discount;
        this.total = total;
        this.receive = receive;
        this.change = change;
        this.totalQTY = totalQTY;
        this.payment = payment;
        this.storeId = storeId;
        this.customerId = customerId;
        this.promotionId = promotionId;
    }
// no Promotion
    public Reciept(Date creaetedDate, int queue, float discount, float total, float receive, float change, int totalQTY,
            String payment, int storeId, int customerId) {
         this.id = -1;
        this.creaetedDate = creaetedDate;
        this.queue = queue;
        this.discount = discount;
        this.total = total;
        this.receive = receive;
        this.change = change;
        this.totalQTY = totalQTY;
        this.payment = payment;
        this.storeId = storeId;
        this.customerId = customerId;
        this.promotionId = -1;
    }

    public Reciept() {
        this.id = -1;
        this.creaetedDate = new Date(2023, 10, 14);
        this.queue = 0;
        this.discount = 0;
        this.total = 0;
        this.receive = 0;
        this.change = 0;
        this.totalQTY = 0;
        this.payment = "Prompay";
        this.storeId = -1;
        this.customerId = -1;
        this.promotionId = -1;
    }

    public int getId() {
        return id;
    }

    public void addReceiptDetail(Product product, int qty, String size, String type, String topping, float toppingPrice,
            float typePrice, float sizePrice) {
        RecieptDetail rd = new RecieptDetail(product.getName(), qty, product.getPrice(), size, typePrice, type, sizePrice, topping, toppingPrice, product.getPrice()*qty, -1, product.getId());
        recieptDetails.add(rd);
        calculateTotal();
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreaetedDate() {
        return creaetedDate;
    }

    public void setCreaetedDate(Date creaetedDate) {
        this.creaetedDate = creaetedDate;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public float getReceive() {
        return receive;
    }

    public void setReceive(float receive) {
        this.receive = receive;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public int getTotalQTY() {
        return totalQTY;
    }

    public void setTotalQTY(int totalQTY) {
        this.totalQTY = totalQTY;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void calculateTotal() {
        int total_qty = 0;
        float total = 0.0f;
        for (RecieptDetail rd : recieptDetails) {

            total += rd.getTotal();
            total += rd.getToppingPrice();
            total += rd.getTypePrice();
            total += rd.getSizePrice();
            total_qty += rd.getQty();
        }
        this.total = total;
        this.totalQTY = total_qty;
    }

    

    public void removeReceiptDetail(RecieptDetail receiptDateil) {
        recieptDetails.remove(receiptDateil);
        calculateTotal();
    }

    @Override
    public String toString() {
        return "Reciept{" + "id=" + id + ", creaetedDate=" + creaetedDate + ", queue=" + queue + ", discount="
                + discount + ", total=" + total + ", receive=" + receive + ", change=" + change + ", totalQTY="
                + totalQTY + ", payment=" + payment + ", storeId=" + storeId + ", customerId=" + customerId
                + ", promotionId=" + promotionId + ", employeeId=" + employeeId + ", customer=" + customer
                + ", promotion=" + promotion + ", employee=" + employee + ", store=" + store + '}';
    }

    public static Reciept fromRS(ResultSet rs) {
        try {
            Reciept obj = new Reciept();
            obj.setId(rs.getInt("reciept_id"));
            obj.setCreaetedDate(rs.getDate("created_date"));
            obj.setQueue(rs.getInt("reciept_queue"));
            obj.setDiscount(rs.getFloat("reciept_discount"));
            obj.setTotal(rs.getFloat("reciept_total"));
            obj.setReceive(rs.getFloat("reciept_receive"));
            obj.setChange(rs.getFloat("reciept_change"));
            obj.setTotalQTY(rs.getInt("reciept_total_qty"));
            obj.setPayment(rs.getString("reciept_payment"));
            obj.setStoreId(rs.getInt("store_id"));
            obj.setCustomerId(rs.getInt("customer_id"));
            obj.setPromotionId(rs.getInt("prom_id"));
            obj.setEmployeeId(rs.getInt("employee_id"));
            return obj;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
