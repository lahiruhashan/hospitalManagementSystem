/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Hashan
 */
public class UpdateBloodGroupConnect {
    
    private Connection con;
    
    public UpdateBloodGroupConnect(){
        this.createConnection();
    }
    
    // create database connection
    public void createConnection(){
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }
    
    //update the blood group of a patient
    public int updateData(String bloodGroup,int patientId){
        int result = 0;
        try {
            
            PreparedStatement ps = con.prepareStatement("update patient set blood_group=? where patient_id=?");
            ps.setString(1, bloodGroup);
            ps.setInt(2, patientId);

            result = ps.executeUpdate();

        } catch (Exception ex) {

        }
    return result;
}
    
}
