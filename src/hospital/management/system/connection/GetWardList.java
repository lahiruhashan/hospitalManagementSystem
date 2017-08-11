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

/**
 *
 * @author Hashan
 */
public class GetWardList {
    
    // global variables 
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public GetWardList(){
        createConnection();
    }
    
    // create database connection
    private void createConnection(){
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }
    
    // get the ward list
    public ArrayList<Integer> getWardList(){
        ArrayList<Integer> wardList = new ArrayList<>();
        try{
            st = con.createStatement();
            rs = st.executeQuery("select * from ward");
            while(rs.next()){
                wardList.add(rs.getInt("ward_id"));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return wardList;
    }
}
