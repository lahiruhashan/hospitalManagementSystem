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
public class AddPatientConnect {

    public AddPatientConnect() {

    }

    // add data to the database
    public int updateData(int patientId, String name, int nic, String gender,
            String admit_date, String admit_time, String address_line_1, String address_line_2,
            String city, int contact_number, String sickness, int ward,
            String recommendation, String confirmation, String consultant) {
        int result = 0;
        try {
            // create the database connection
            DBConnect db = new DBConnect();
            Connection con = db.createConnection();

            //get the relavent confirmation employee id 
            String get_confirmation_id = "select employee_id from employee where name = ?";
            PreparedStatement pst = con.prepareStatement(get_confirmation_id);
            pst.setString(1, confirmation);
            ResultSet confirmation_result = pst.executeQuery();
            int confirmatoinId = 0;

            while (confirmation_result.next()) {
                confirmatoinId = confirmation_result.getInt("employee_id");
            }

            //get the relavent consultant employee id 
            String get_consultant_id = "select employee_id from employee where name = ?";
            PreparedStatement prst = con.prepareStatement(get_consultant_id);

            prst.setString(1, consultant);
            ResultSet consultant_result = prst.executeQuery();
            int consultantId = 0;

            while (consultant_result.next()) {
                consultantId = consultant_result.getInt("employee_id");
            }

            //add to database
            PreparedStatement ps = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, patientId);
            ps.setString(2, name);
            ps.setInt(3, nic);
            ps.setString(4, gender);
            ps.setString(5, admit_date);
            ps.setString(6, admit_time);
            ps.setString(7, address_line_1);
            ps.setString(8, address_line_2);
            ps.setString(9, city);
            ps.setInt(10, contact_number);
            ps.setString(11, null);
            ps.setString(12, sickness);
            ps.setInt(13, ward);
            ps.setString(14, recommendation);
            ps.setInt(15, confirmatoinId);
            ps.setInt(16, consultantId);
            ps.setInt(17, 0);
            ps.setString(18, "");

            result = ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to Add the Patient");
            System.out.println(ex);
        }
        return result;
    }

}
