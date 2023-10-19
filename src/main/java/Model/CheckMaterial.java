package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckMaterial {

    private int id;
    private Date cmDate;
    private int employeeId;
    private CheckMaterialDetail details;

    public CheckMaterial(int id, Date cmDate, int employeeId) {
        this.id = id;
        this.cmDate = cmDate;
        this.employeeId = employeeId;
    }

    public CheckMaterial(Date cmDate, int employeeId) {
        this.id = -1;
        this.cmDate = cmDate;
        this.employeeId = employeeId;
    }

    public CheckMaterial(int employeeId) {
        this.id = -1;
        this.cmDate = null;
        this.employeeId = employeeId;
    }

    public CheckMaterial() {
        this.id = -1;
        this.cmDate = null;
        this.employeeId = -1;
    }

    public CheckMaterialDetail getDetails() {
        return details;
    }

    public void setDetails(CheckMaterialDetail details) {
        this.details = details;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCmDate() {
        return cmDate;
    }

    public void setCmDate(Date cmDate) {
        this.cmDate = cmDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "CheckMaterial{" + "id=" + id + ", cmDate=" + cmDate + ", mployeeId=" + employeeId + '}';
    }

    public static CheckMaterial fromRS(ResultSet rs) {
        CheckMaterial obj = new CheckMaterial();
        try {
            obj.setId(rs.getInt("check_mat_id"));
            obj.setCmDate(rs.getTimestamp("check_mat_datetime"));
            obj.setEmployeeId(rs.getInt("employee_id"));

        } catch (SQLException ex) {
            Logger.getLogger(CheckMaterial.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return obj;
    }
}
