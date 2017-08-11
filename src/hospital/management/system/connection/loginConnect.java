/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;


import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Hashan
 */
public class loginConnect {
    private String user;
    private String pass;
    private String time;
    private String date;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int status;
    private String privilege;
                         
    
    public loginConnect(String user, String pass, String time, String date ){
        this.user = user;
        this.pass = pass;
        this.time = time;
        this.date = date;
        
        status = 0;
        
        createConnection();
    }
    
    // create the connection
    public final void createConnection(){
        
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }
     
    // add login details
    public void sendLoginDetails(){
        try {
            
            PreparedStatement ps;
            ps = con.prepareStatement("insert into login_detail values(?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, user);
            ps.setString(3, date);
            ps.setString(4, time);
            ps.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Login Details Failed");
        }
        
    }
           

    // check for the  user availability and previlege
    public int sendData(){
            
        
        try {
            st = con.createStatement();
            String query = "select * from employee";
            rs = st.executeQuery(query);
            
            while(rs.next()){
        
                String un = rs.getString("employee_id");
                String pw = rs.getString("password");
                String type = rs.getString("type");
                String privilege = rs.getString("privilege");
                
                if(user.equals(un) && pass.equals(pw)){
                    if(privilege.equals("admin")){
                        
                        status = 4;
                    }else{
                        if(type.equals("Doctor")){
                            status = 3;
                        }else if(type.equals("Nurse")){
                            status = 2;
                        }else if(type.equals("Reception")){
                            status = 1;
                        }                        
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Login Data Fetch Failed");
        }
        
        return status;
    }
}


