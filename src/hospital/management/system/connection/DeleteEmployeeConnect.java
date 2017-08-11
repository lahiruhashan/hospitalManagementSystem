/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class DeleteEmployeeConnect {
    private Connection con;
    private String employeeId;
    
    public DeleteEmployeeConnect(String employeeId){
        this.employeeId = employeeId;
        createConnection();
    }
    
    // creating the database connection
    public void createConnection(){
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }
    
    // delete employee from the database
    public void deleteEmployee(){
        try{
            PreparedStatement ps = con.prepareStatement("delete from employee where employee_id = ?");
            ps.setString(1, employeeId);
            int confirm = JOptionPane.showConfirmDialog(null, "Delete " + employeeId + "?");
            int result = 0;
            if(confirm == 1){
                result = ps.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "Deletion Cancelled");
            }
            
            
            if(result == 1){
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Failed");
        }
        
    }
}
