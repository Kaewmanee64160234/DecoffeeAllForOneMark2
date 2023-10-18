/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import Model.BillDetail;
import Service.BillDetailService;
import Service.ValidateException;

/**
 *
 * @author Lenovo
 */
public class TestBillDetailService {

    public static void main(String[] args) throws ValidateException {
        BillDetailService bds = new BillDetailService();
        for (BillDetail billDetail : bds.getBills()) {
            System.out.println(billDetail);
        }

        BillDetail billdetail1 = new BillDetail("charyen",5,25,100,75,1,1);
        bds.addNew(billdetail1);
        for (BillDetail billdetail : bds.getBills()) {
            System.out.println(billdetail);
        }
        
        BillDetail delBillDetail = bds.getById(4);
        delBillDetail.setName("charlala");
        bds.update(delBillDetail);
        System.out.println("After Updated");
         for (BillDetail billDetail : bds.getBills()) {
            System.out.println(billDetail);
        }
        
        BillDetail deleteBill = bds.getById(4);
        bds.delete(deleteBill);
        for (BillDetail bill : bds.getBills()) {
            System.out.println(bill);
        }
    }
}
