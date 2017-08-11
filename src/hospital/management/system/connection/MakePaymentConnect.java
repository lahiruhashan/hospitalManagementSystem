/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author Hashan
 */
public class MakePaymentConnect {
    
    private int patientNic;
    private float amount;
    private int patientId;
    private Date date;
    private Time time;
    private Connection con;
    
    public MakePaymentConnect(int patientNic,float amount){
        this.patientNic = patientNic;
        this.amount = amount;
        this.patientId = 0;
        
        createConnectoin();
        getPatientId();
        getDateTime();
    }
    
    // create database connectoin
     public void createConnectoin() {
         
         DBConnect db = new DBConnect();
         con = db.createConnection();

    }
     
     // get the patient id using nic
     public void getPatientId(){
         
         try{
             PreparedStatement ps = con.prepareStatement("select patient_id from patient where nic = ?");
             ps.setInt(1,patientNic);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 patientId = rs.getInt("patient_id");
             }
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "No Such Patient");
         }
     }
     
     // get date and time
    public void getDateTime(){

        try{
            Date currentDate = new Date();
            java.sql.Date textDate= new java.sql.Date(currentDate.getTime());
            Time txtTime = new Time(currentDate.getTime());
            this.date = textDate;
            this.time = txtTime;

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Date Time Error");
        }
     }

     // add payment to the database
     public int setPayment(){
         int result = 0;
         try{
             PreparedStatement ps = con.prepareStatement("insert into payment values(?,?,?,?,?)");
             ps.setString(1, null);
             ps.setInt(2, patientId);
             ps.setFloat(3, amount);
             ps.setDate(4, (java.sql.Date) date);
             ps.setTime(5, time);
             result = ps.executeUpdate();
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Payment Failed");
         }
         return result;
     }
}
