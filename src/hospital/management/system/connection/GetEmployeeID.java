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


public class GetEmployeeID {
    
    private Connection con;
    
    public GetEmployeeID(){
        this.createConnectoin();
    }
    
    // create connection
    public void createConnectoin(){
        DBConnect db = new DBConnect();
        this.con = db.createConnection();        
    }
    
    // get employee id using the name
    public int getEmployeeId(String employeeName){
        int employeeId = 0;
        try {
            
            PreparedStatement ps = con.prepareStatement("select employee_id from employee where name = ?");
            ps.setString(1,employeeName);
            ResultSet result = ps.executeQuery();
            
            if(result.next()){
                employeeId = result.getInt("employee_id");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Eployee ID Get Failed");
        }
        return employeeId;
    }
}
