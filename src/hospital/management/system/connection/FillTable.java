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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashan
 */
public class FillTable {
    private Connection con;
    
    public FillTable(){
        createConnection();
    }
    
    // create connection
    public void createConnection(){
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }
    
    // fill table with patient consulted by the given employee id
    public void fillTable(DefaultTableModel model,String username){
         try {
             
            PreparedStatement pss = con.prepareStatement("select * from patient where consultant = ? and discharge_date is NULL");
            pss.setInt(1,Integer.parseInt(username));
            ResultSet resultSet;
            resultSet = pss.executeQuery();

            while (resultSet.next()) {
                String add1 = resultSet.getString("nic");
                String add2 = resultSet.getString("name");
                String add3 = resultSet.getString("gender");
                String add4 = resultSet.getString("ward");
                String add5 = resultSet.getString("confirmation");
                String add6 = resultSet.getString("consultant");
                String add7 = resultSet.getString("admit_date");
     
                model.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7});

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Adding to the table failed");
        }
    }
    
    // fill the table with relavant details of the searching patient
    public void fillSearch(DefaultTableModel model,String nic){
        try {

            model.setRowCount(0);
            
            String query = "select * from patient where nic LIKE ? and discharge_date is NULL";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, nic+"%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String add1 = rs.getString("nic");
                String add2 = rs.getString("name");
                String add3 = rs.getString("gender");
                String add4 = rs.getString("ward");
                String add5 = rs.getString("confirmation");
                String add6 = rs.getString("consultant");
                String add7 = rs.getString("admit_date");

                model.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7});
            }

        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }
    }
}
