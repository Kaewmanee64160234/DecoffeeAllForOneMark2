package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Promotion {

    private int id;
    private Date createdDate;
    private String endDate;
    private String Name;
    private float Discount;
    private int discountPerc;
    private int pointDiscount;
    private boolean usedPoint;

    public Promotion(int id, Date createdDate, String endDate, String Name, float Discount, int discountPerc, int pointDiscount, boolean usedPoint) {
        this.id = id;
        this.createdDate = createdDate;
        this.endDate = endDate;
        this.Name = Name;
        this.Discount = Discount;
        this.discountPerc = discountPerc;
        this.pointDiscount = pointDiscount;
        this.usedPoint = usedPoint;
    }

    public Promotion(Date createdDate, String endDate, String Name, float Discount, int discountPerc, int pointDiscount, boolean usedPoint) {
        this.id = -1;
        this.createdDate = createdDate;
        this.endDate = endDate;
        this.Name = Name;
        this.Discount = Discount;
        this.discountPerc = discountPerc;
        this.pointDiscount = pointDiscount;
        this.usedPoint = usedPoint;
    }

    public Promotion(String endDate, String Name, float Discount, int discountPerc, int pointDiscount, boolean usedPoint) {
        this.id = -1;
        this.createdDate = null;
        this.endDate = endDate;
        this.Name = Name;
        this.Discount = Discount;
        this.discountPerc = discountPerc;
        this.pointDiscount = pointDiscount;
        this.usedPoint = usedPoint;
    }

    public Promotion() {
        this.id = -1;
        this.createdDate = null;
        this.endDate = "";
        this.Name = "";
        this.Discount = 0;
        this.discountPerc = 0;
        this.pointDiscount = 0;
        this.usedPoint = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getDiscount() {
        return Discount;
    }

    public void setDiscount(float Discount) {
        this.Discount = Discount;
    }

    public int getDiscountPerc() {
        return discountPerc;
    }

    public void setDiscountPerc(int discountPerc) {
        this.discountPerc = discountPerc;
    }

    public int getPointDiscount() {
        return pointDiscount;
    }

    public void setPointDiscount(int pointDiscount) {
        this.pointDiscount = pointDiscount;
    }

    public boolean getUsedPoint() {
        return usedPoint;
    }

    public void setUsedPoint(boolean usedPoint) {
        this.usedPoint = usedPoint;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", createdDate=" + createdDate + ", endDate=" + endDate + ", Name=" + Name + ", Discount=" + Discount + ", discountPerc=" + discountPerc + ", pointDiscount=" + pointDiscount + ", usedPoint=" + usedPoint + '}';
    }

//    public Promotion(String endDateStr, String Name, float Discount, int discountPerc, int pointDiscount) {
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            this.endDate = dateFormat.parse(endDateStr);
//        } catch (ParseException e) {
//            
//        }
//    }
    public static Promotion fromRS(ResultSet rs) {
        Promotion promotion = new Promotion();
        try {
            promotion.setId(rs.getInt("prom_id"));
            promotion.setCreatedDate(rs.getDate("prom_created_date"));
            promotion.setEndDate(rs.getString("prom_end_date"));
            promotion.setName(rs.getString("prom_name"));
            promotion.setDiscount(rs.getFloat("prom_discount"));
            promotion.setDiscountPerc(rs.getInt("prom_discount_perc"));
            promotion.setPointDiscount(rs.getInt("prom_point_discount"));
            promotion.setUsedPoint(rs.getBoolean("prom_used_point"));
        } catch (SQLException ex) {
            Logger.getLogger(Promotion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return promotion;
    }
}
