/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Hashan
 */
public class DateTime {
    
    private Date currentDate;
    
    public DateTime(){
        //initializing current date to today
        currentDate = new Date();
    }
    
    // get the current date
    public Date getDate(){
        java.sql.Date txtDate= new java.sql.Date(currentDate.getTime());
        return txtDate;
    }
    
    // get the current time
    public Time getTime(){
        Time txtTime = new Time(currentDate.getTime());
        return txtTime;
    }
    
}
