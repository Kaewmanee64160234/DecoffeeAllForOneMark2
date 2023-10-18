/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestService;

import Dao.CheckinoutDao;
import Model.Checkinout;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author user
 */
public class TestCheckinout {

    public static void main(String[] args) {
        CheckinoutDao ck = new CheckinoutDao();

        Checkinout cnk = ck.get(1);
        System.out.println(cnk.toString());
        
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        String formattedTime = timeFormat.format(currentTime);


        Checkinout cc = new Checkinout(formattedTime, formattedTime, 0, "Y", 1, 1);
        ck.save(cc);
        
        for (Checkinout arg : ck.getAll()) {
            System.out.println(arg.toString());
            
        }
      

    }
}
