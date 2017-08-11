/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Hashan
 */
public class NextEmployeeId {
    // global variables
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int count;
    
    public NextEmployeeId(){
        this.count = 0;
        
        createConnection();
    }
    
    // create database connection
    public void createConnection(){
        DBConnect db = new DBConnect();
        con = db.createConnection();
    }
    // get next id for the employee
    public int getNextId(){
        try {
            
            st = con.createStatement();
            rs = st.executeQuery("select * from employee");

            while (rs.next()) {
                count++;
            }
            count++;

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return count;
    }
    
}
