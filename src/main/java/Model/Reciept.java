/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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
    private String CreatedDate;
    private ArrayList<RecieptDetail> recieptDetails = new ArrayList();
    // all

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

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
    // not id

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
        this.payment = "cash";
        this.storeId = -1;
        this.customerId = -1;
        this.promotionId = -1;
        this.CreatedDate = "";
    }

    // have customer promotion
    public Reciept(int queue, String payment, int storeId, int customerId, int promotionId, int employeeId,
            float receive) {
        this.queue = queue;
        this.payment = payment;
        this.storeId = storeId;
        this.customerId = customerId;
        this.promotionId = promotionId;
        this.employeeId = employeeId;
        this.receive = receive;
        this.change = 0;

    }

    public Reciept(int queue, String payment, int storeId, int promotionId, int employeeId, float receive) {
        this.queue = queue;
        this.payment = payment;
        this.storeId = storeId;
        this.customerId = -1;
        this.promotionId = promotionId;
        this.employeeId = employeeId;
        this.receive = receive;
        this.change = 0;
    }

    public int getId() {
        return id;
    }

    public String detailToString(RecieptDetail rd) {
        return rd.getName() + " " + rd.getSize() + " " + rd.getSweet() + " " + rd.getTopping() + " " + rd.getType();
    }

    public void addReceiptDetail(Product product, int qty, String sizeName, float sizePrice, String toppingName,
            float toppingPrice, String sweetName, float sweetPrice, String typeName, float typePrice) {
        RecieptDetail rd = new RecieptDetail(product.getName(), qty, product.getPrice(), sizeName, typePrice, typeName,
                sizePrice, toppingName, toppingPrice, product.getPrice() * qty, -1, product.getId(), sweetName,
                sweetPrice, product.getPrice());

        boolean isDuplicate = false;
        String newDetailStr = detailToString(rd);
        System.out.println(newDetailStr);
        for (RecieptDetail recieptDetail : recieptDetails) {
            String existingDetailStr = detailToString(recieptDetail);
            if (newDetailStr.equals(existingDetailStr)) {
                isDuplicate = true;
                recieptDetail.setQty(qty + recieptDetail.getQty());

                break;
            }
        }

        if (isDuplicate == false) {
            int idProduct = product.getId();
            rd.setProductId(idProduct);
            rd.setTotal(product.getPrice() * qty);
            rd.setProductPrice(product.getPrice());
            recieptDetails.add(rd);
            System.out.println("Model.Reciept.addReceiptDetail()");
            System.out.println(rd.toString());
        }
        calculateTotal();
        System.out.println("-----------------------------------");
        System.out.println(total);
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
        this.total = 0;
        int total_qty = 0;
        float total = 0.0f;
        System.out.println(recieptDetails.size());
        for (RecieptDetail rd : recieptDetails) {

            total += rd.getTotal();
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
                + ", promotion=" + promotion + ", employee=" + employee + ", store=" + store + '}' + " recieptdetail "
                + recieptDetails;
    }

    public static Reciept fromRS(ResultSet rs) {
        try {
            Reciept obj = new Reciept();
            obj.setId(rs.getInt("reciept_id"));
            obj.setCreaetedDate(rs.getTimestamp("create_date"));
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
    
    public static Reciept fromRS__(ResultSet rs) {
        try {
            Reciept obj = new Reciept();
            obj.setId(rs.getInt("reciept_id"));
            obj.setCreaetedDate(rs.getTimestamp("create_date"));
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Define your desired date and time format
            String formattedDate = sdf.format(obj.getCreaetedDate());
            obj.setCreatedDate(formattedDate);
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

    public static Reciept fromRSToGetId(ResultSet rs) {
        try {
            Reciept obj = new Reciept();
            obj.setTotal(rs.getFloat("totalSum"));
            return obj;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
