/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class GetEmployeeName {
    
    private Connection con;
    private ResultSet rs;
    private String name;
    
    public GetEmployeeName(){
        createConnection();
        this.name = "";
    }
    
    // create database connection
    public void createConnection(){
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }
    
    // get the name of the employee 
    public String getName(String employeeNic){
        try {
            String query = "select * from employee where employee_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(employeeNic));
            rs = pst.executeQuery();
            while (rs.next()) {
                this.name = rs.getString("name");
            }
            
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error in NIC");
        }
        return name;
    }
    
}
