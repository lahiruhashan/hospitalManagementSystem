/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class GetDoctorNameList {
    
    private Connection con;
    private ResultSet rs;
    private Statement st;
    private ArrayList<String> names;
    
    public GetDoctorNameList(){
        createConnection();
    }
    
    // create connection
    private void createConnection(){
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }
    
    // get the id of all the doctors and return the names
    public ArrayList<String> getDoctorList(){
        names = new ArrayList<>();
        try{
            st = con.createStatement();
            rs = st.executeQuery("select * from employee where type = 'Doctor'");
            while(rs.next()){
                names.add(rs.getString("name"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Doctor ID Get Failed");
        }
        return names;
        }
       
    }
