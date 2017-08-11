/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class CalculateSalary {
    //global variables
    private int employeeId;
    private int month;
    private int year;  
    private int attendance;
    private float amount;
    private Connection con;
    
    // initializing variables
    public CalculateSalary(int employeeId, int month , int year){
        this.employeeId = employeeId;
        this.month = month;
        this.year = year;
        this.amount = 0;
        this.attendance = 0;
        
        createConnection();
        getDateCount();
    }
    
    // create database connection
    public void createConnection(){
        DBConnect db = new DBConnect();
        con = db.createConnection();
    }
    
    // get the the present days
    public void getDateCount(){
        CountDays countAttendence = new CountDays();
        this.attendance = countAttendence.countDays(employeeId, year, month);
    }
    
    // calculate the salary according to proffession 
    public float getSalary(){
        try{
            String type = "";
            
            
            PreparedStatement ps = con.prepareStatement("select * from employee where employee_id = ?");
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                type = rs.getString("type");
            }

            if(type.equals("Doctor")){

                amount = attendance * 3000f;

            }
            else if(type.equals("Nurse")){

                amount = attendance * 1500f;

            }
            else if(type.equals("Reception")){

                amount = attendance * 1000f;

            }
            else if(type.equals("Maintenance")){

                amount = attendance * 500f;

            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return amount;
    }
}
