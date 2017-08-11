/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class DBConnect {
    
    private Connection con;
    
    public DBConnect(){
        
    }
    
    // creating the database connection
    public Connection createConnection() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb", "root", "");
    

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database Connection Failed!!!");
        }
        return con;
    }
    
    public void closeConnection(Connection conn) throws SQLException{
        conn.close();
    }
    
}
