/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class AddEmployeeConnect {
    
    public AddEmployeeConnect(){
        
    }
    //add employee to the database
    public int updateData(int employee_id,String name,String gender,
            String address_line_1,String address_line_2,
            String city, String specialization,int contact, String dateOfJob,String type,String password,String adminRight){
        int result = 0;
        try{
            //creating db connection
            DBConnect db = new DBConnect();
            Connection con = db.createConnection();

            //add to database
            PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,employee_id);
            ps.setString(2,type);
            ps.setString(3,specialization);
            ps.setString(4,name);
            ps.setString(5,gender);
            ps.setString(6,address_line_1);
            ps.setString(7,address_line_2);
            ps.setString(8,city);
            ps.setInt(9,contact);
            ps.setString(10,dateOfJob);
            ps.setString(11, password);
            ps.setString(12, adminRight);
            
            result = ps.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Failed to Add the Employee");
        }    
        return result;
    }
    
}
