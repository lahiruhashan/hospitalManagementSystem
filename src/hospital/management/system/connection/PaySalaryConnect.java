/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class PaySalaryConnect {
    
    private Connection con;
    
    public PaySalaryConnect(){
        createConnection();
        addToDatabase();
    }
    
    // create database connectoin
    public void createConnection(){
        DBConnect db = new DBConnect();
        con = db.createConnection();
    }
    
    // get the date count that an employee has attended
    public int dateCount(int employeeId,int year,int month){
       
        int count = 0;

        try {
            PreparedStatement ps = con.prepareStatement("select * from attendence where MONTH(date) = ? and YEAR(date) = ? and employee_id = ?");
            ps.setInt(1, month);
            ps.setInt(2, year);
            ps.setInt(3, employeeId);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
           
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return count;
    }
    
    // add salary of each employee to the database
    public void addToDatabase(){
        try{
            Calendar cal = new GregorianCalendar();
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            
            Date currentDate = new Date();
            java.sql.Date textDate= new java.sql.Date(currentDate.getTime());
            
            PreparedStatement ps = con.prepareStatement("select * from employee");
            PreparedStatement pst = con.prepareStatement("insert into salary values(?,?,?)");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int employee_id = rs.getInt("employee_id");
                String type = rs.getString("type");

                
                if(type.equals("Doctor")){
                    
                    int count = dateCount(employee_id,year,month+1);
                    float amount = count * 2000.00f;
                    
                    pst.setInt(1, employee_id);
                    pst.setDate(2, textDate);
                    pst.setFloat(3, amount);
                    
                }
                else if(type.equals("Nurse")){
                    
                    int count = dateCount(employee_id,year,month+1);
                    float amount = count * 1500.00f;
                    
                    pst.setInt(1, employee_id);
                    pst.setDate(2, textDate);
                    pst.setFloat(3, amount);
                }
                else if(type.equals("Reception")){
                    
                    int count = dateCount(employee_id,year,month+1);
                    float amount = count * 1000.00f;
                    
                    pst.setInt(1, employee_id);
                    pst.setDate(2, textDate);
                    pst.setFloat(3, amount);
                }
                else if(type.equals("Maintenance")){
                    
                    int count = dateCount(employee_id,year,month+1);
                    float amount = count * 500.00f;
                    
                    pst.setInt(1, employee_id);
                    pst.setDate(2, textDate);
                    pst.setFloat(3, amount);
                }
                pst.executeUpdate();
            }
            
            JOptionPane.showMessageDialog(null, "Salary Calculated Successfully");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
