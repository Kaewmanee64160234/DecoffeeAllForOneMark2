/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import Model.Bill;
import Service.BillService;
import Service.BillService;
import Service.ValidateException;

/**
 *
 * @author Lenovo
 */
public class TestBillService {

    public static void main(String[] args) throws ValidateException {
        BillService bs = new BillService();
        for (Bill bill : bs.getBills()) {
            System.out.println(bill);
        }

        Bill bill1 = new Bill("CKmart",100,25,75,25,2,1);
        bs.addNew(bill1);
        for (Bill bill : bs.getBills()) {
            System.out.println(bill);
        }
        
        Bill delBill = bs.getById(3);
        delBill.setChange(50);
        bs.update(delBill);
        System.out.println("After Updated");
         for (Bill bill : bs.getBills()) {
            System.out.println(bill);
        }
        
//        Bill deleteBill = bs.getById(6);
//        bs.delete(deleteBill);
//        for (Bill bill : bs.getBills()) {
//            System.out.println(bill);
//        }
    }
}
