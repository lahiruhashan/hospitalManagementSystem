/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class AttendenceConnect {
    
    private int employeeNicTxt;
    private String date;
    private String time;
    private Connection con; 
    
    //constructor overloading
    public AttendenceConnect(int employeeNic,String date,String time){
        this.employeeNicTxt = employeeNic;
        this.date = date;
        this.time = time;
    }
    
    // create the connection
    public void createConnectoin() {
        
        DBConnect db = new DBConnect();
        con = db.createConnection();
        
    }
    
    //set in time and date
    public int setInAttendence(){
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        int result = 0;
        
        try{
            java.sql.Date dateTxt= new java.sql.Date(format.parse(date).getTime());
            Time timeTxt = Time.valueOf(time);
        
            PreparedStatement ps = con.prepareStatement("insert into attendence values(?,?,?,?)");
            ps.setInt(1, employeeNicTxt);
            ps.setDate(2, dateTxt);
            ps.setTime(3, timeTxt);
            ps.setTime(4, null);
            
            result = ps.executeUpdate();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Attendence Updation failed !!!");
        }
        return result;
    }
    
    // set out time and date
    public int setOutAttendence(){
        
        int result = 0;
        
        try{
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            java.sql.Date dateTxt= new java.sql.Date(format.parse(date).getTime());
            Time timeTxt = Time.valueOf(time);
        
            PreparedStatement ps = con.prepareStatement("update attendence set out_time = ? where employee_id = ? and date = ?");
            ps.setTime(1, timeTxt);
            ps.setInt(2, employeeNicTxt);
            ps.setDate(3, dateTxt);
            
            result = ps.executeUpdate();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Attendance Updation Failed");
        }
        return result;
    }
        
        
    
}
