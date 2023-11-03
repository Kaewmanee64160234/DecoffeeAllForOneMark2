package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoryOrderReport {

    private int id;
    private String created_date;
    private float Total;

    public HistoryOrderReport(int id, String created_date, float Total) {
        this.id = id;
        this.created_date = created_date;
        this.Total = Total;
    }

    public HistoryOrderReport(float Total) {
        this.id = -1;
        this.created_date = null;
        this.Total = Total;
    }

    public HistoryOrderReport() {
        this.id = -1;
        this.created_date = null;
        this.Total = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    @Override
    public String toString() {
        return "HistoryOrderReport{" + "id=" + id + ", created_date=" + created_date + ", Total=" + Total + '}';
    }


    public static HistoryOrderReport fromRS(ResultSet rs) {
        HistoryOrderReport obj = new HistoryOrderReport();
        try {
            obj.setId(rs.getInt("reciept_id"));
            obj.setCreated_date(rs.getString("created_date"));
            obj.setTotal(rs.getFloat("Total"));

        } catch (SQLException ex) {
            Logger.getLogger(HistoryOrderReport.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return obj;
    }
}
