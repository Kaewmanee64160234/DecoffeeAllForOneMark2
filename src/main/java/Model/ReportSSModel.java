/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USER
 */
public class ReportSSModel {
 
        private String employeeName;
        private String salary;
        private String date;

    public ReportSSModel(String employeeName, String ss_salary, String ss_date) {
        this.employeeName = employeeName;
        this.salary = ss_salary;
        this.date = ss_date;
    }

    public ReportSSModel() {
         this.employeeName = "";
        this.salary = "";
        this.date = "";
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReportSSModel{" + "employeeName=" + employeeName + ", salary=" + salary + ", date=" + date + '}';
    }
    

  

   
    
}
