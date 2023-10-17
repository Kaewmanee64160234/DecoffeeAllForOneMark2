/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.CheckStockDao;
import Model.CheckStock;
import java.util.List;

/**
 *
 * @author USER
 */
public class CheckStockService {
    static CheckStock currentCheckStock;

    public static CheckStock getCurrentCheckStock() {
        return currentCheckStock;
    }    
    
      public CheckStock login(String login, String password) {
        CheckStockDao checkStockDao = new CheckStockDao();
        CheckStock checkStock = checkStockDao.getByLogin(login);
        if (checkStock != null && checkStock.getPassword().equals(password)) {
            return checkStock;
        }
        return null;
    }
      
      public List<CheckStock>getCheckStocks() {
        CheckStockDao checkStockDao = new CheckStockDao();
        return checkStockDao.getAll(" checkStock_login asc");  
    }

    public CheckStock addNew(CheckStock editedCheckStock) {
        CheckStockDao checkStockDao = new CheckStockDao();
        return checkStockDao.save(editedCheckStock);
    }

    public CheckStock update(CheckStock editedCheckStock) {
        CheckStockDao checkStockDao = new CheckStockDao();
        return checkStockDao.update(editedCheckStock);
    }

    public int delete(CheckStock editedCheckStock) {
        CheckStockDao checkStockDao = new CheckStockDao();
        return checkStockDao.delete(editedCheckStock);
    }

}
