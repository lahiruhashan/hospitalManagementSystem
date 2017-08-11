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
public class UpdatePatientConnect {
    //global variables
    private String patientName;
    private String gender;
    private int nic;
    private String addressLine1;
    private String addressLine2;                       
    private String city;
    private int contactNumber;
    private int ward;
    private String recommendation;
    private String confirmation;
    private String consultant;
    private int patientId;
    private Connection con;
    
    public UpdatePatientConnect(String patientName,String gender,int nic,String addressLine1,String addressLine2,
            String city,int contactNumber,int ward,String recommendation,String confirmation,String consultant,int patient_id){
        
        this.patientName = patientName;
        this.gender = gender;
        this.nic = nic;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.contactNumber = contactNumber;
        this.ward = ward;
        this.recommendation = recommendation;
        this.consultant = consultant;
        this.confirmation = confirmation;
        this.patientId = patient_id;
        
        this.createConnection();
    }
    
    // create connection
    public void createConnection(){
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
        
    }
    
    //// update the patient details
    public void update(){
        
        GetEmployeeID empId = new GetEmployeeID();
        int confirmationId = empId.getEmployeeId(confirmation);
        int consultantId = empId.getEmployeeId(consultant);
        try {
            PreparedStatement ps = con.prepareStatement("update patient set name = ?,nic = ?,gender = ?,address_line_1 = ?,"
                    + "address_line_2 = ?,city = ?,contact_number = ?,ward = ?,recommendation = ?,confirmation = ?,consultant = ? where patient_id = ?");
            ps.setString(1, patientName);
            ps.setInt(2, nic);
            ps.setString(3, gender);
            ps.setString(4, addressLine1);
            ps.setString(5, addressLine2);
            ps.setString(6, city);
            ps.setInt(7, contactNumber);
             ps.setInt(8, ward);
            ps.setString(9, recommendation);
            ps.setInt(10, confirmationId);
            ps.setInt(11, consultantId);
            ps.setInt(12, patientId);
            
            int result = ps.executeUpdate();
            
            if(result == 1){
                JOptionPane.showMessageDialog(null, "Updated Successfully");
            }else{
                JOptionPane.showMessageDialog(null, "Failed");
            }
            
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    
    
}
