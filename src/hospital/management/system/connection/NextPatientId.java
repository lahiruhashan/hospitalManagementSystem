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
public class NextPatientId {

    //global variables
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int count;
    
    public NextPatientId(){
        this.count = 0;
        createConnection();
    }
    
    // create the datebase connection
    private void createConnection(){
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }
    
    // get the next id for the patient
    public int getNextId(){
        try{
            st = con.createStatement();
            rs = st.executeQuery("select * from patient");
           
            while(rs.next()){
                count++;
            }
            count++;
        }catch(Exception ex){
            System.out.println(ex);
        }
        return count;
    }
            
}
