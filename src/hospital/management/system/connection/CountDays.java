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
public class CountDays {
    
    private Connection con;
    private int count;
    
    public CountDays(){
        createConnection();
        this.count = 0;
    }
    
    // create the database connection
    public void createConnection(){
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }
    
    // get the day count that an employee has attended
    public int countDays(int employeeId,int year,int month){
        try {
            PreparedStatement ps = con.prepareStatement("select * from attendence where MONTH(date) = ? and YEAR(date) = ? and employee_id = ?");
            ps.setInt(1, month);
            ps.setInt(2, year);
            ps.setInt(3, employeeId);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.count++;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Get Count Failed");
        }
        return count;
    }
    
}
