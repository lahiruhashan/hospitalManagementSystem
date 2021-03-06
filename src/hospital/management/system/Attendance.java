/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import hospital.management.system.connection.AttendenceConnect;
import hospital.management.system.connection.DBConnect;
import hospital.management.system.connection.GetEmployeeName;
import java.sql.Connection;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class Attendance extends javax.swing.JFrame {

    /**
     * Creates new form Attendance
     */
    private Connection con;
    
    public Attendance() {
        initComponents();
    }
    
    //create the database connection
    public void createConnectoin() {
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }
    
    // get the current time and date in a thread
    protected void currentDateTime() {
        new Thread() {
            public void run() {
                while (true) {

                    Calendar cal = new GregorianCalendar();

                    //formatting the date and time
                    Date currentDate = new Date();
                    String txtDate = new SimpleDateFormat("dd-MM-yyyy").format(currentDate);
                    Time txtTime = new Time(cal.getTimeInMillis());

                    //displaying the date and time
                    dateLabel.setText(txtDate);
                    timeLabel.setText(txtTime.toString());
                }
            }
        }.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        employeeNic = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        employeeName = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        employeeOut = new javax.swing.JButton();
        employeeIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 152, 216));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeNic.setBackground(new java.awt.Color(0, 152, 216));
        employeeNic.setFont(new java.awt.Font("Quicksand", 0, 24)); // NOI18N
        employeeNic.setForeground(new java.awt.Color(255, 255, 255));
        employeeNic.setBorder(null);
        employeeNic.setCaretColor(new java.awt.Color(255, 255, 255));
        employeeNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                employeeNicKeyReleased(evt);
            }
        });
        jPanel1.add(employeeNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 260, 50));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 260, 10));

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Quicksand", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Employee NIC");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 190, 50));

        jLabel19.setBackground(new java.awt.Color(51, 51, 51));
        jLabel19.setFont(new java.awt.Font("Quicksand", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Employee Name");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 190, 50));

        employeeName.setEditable(false);
        employeeName.setBackground(new java.awt.Color(0, 152, 216));
        employeeName.setFont(new java.awt.Font("Quicksand", 0, 24)); // NOI18N
        employeeName.setForeground(new java.awt.Color(255, 255, 255));
        employeeName.setBorder(null);
        employeeName.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(employeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 260, 50));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setEnabled(false);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 260, 10));

        dateLabel.setBackground(new java.awt.Color(0, 102, 102));
        dateLabel.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(0, 153, 153));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Date");
        jPanel1.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 280, 80));

        timeLabel.setBackground(new java.awt.Color(0, 102, 102));
        timeLabel.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(0, 153, 153));
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("Time");
        jPanel1.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 280, 80));

        jPanel3.setBackground(new java.awt.Color(67, 101, 112));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 260));

        jPanel2.setBackground(new java.awt.Color(67, 101, 112));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeOut.setBackground(new java.awt.Color(51, 51, 51));
        employeeOut.setFont(new java.awt.Font("Quicksand", 0, 48)); // NOI18N
        employeeOut.setForeground(new java.awt.Color(255, 255, 255));
        employeeOut.setText("OUT");
        employeeOut.setBorder(null);
        employeeOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        employeeOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        employeeOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeOutActionPerformed(evt);
            }
        });
        jPanel2.add(employeeOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 170, 140));

        employeeIn.setBackground(new java.awt.Color(51, 51, 51));
        employeeIn.setFont(new java.awt.Font("Quicksand", 0, 48)); // NOI18N
        employeeIn.setForeground(new java.awt.Color(255, 255, 255));
        employeeIn.setText("IN");
        employeeIn.setBorder(null);
        employeeIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        employeeIn.setPreferredSize(new java.awt.Dimension(100, 60));
        employeeIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        employeeIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeInActionPerformed(evt);
            }
        });
        jPanel2.add(employeeIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 170, 140));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 640, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void employeeInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeInActionPerformed
        
        //checks for the empty text field
        if(employeeNic.getText().equals("")){
            JOptionPane.showMessageDialog(this, "NIC Cannot Be Empty");
        }else{
            try{
                //get the user input and the date and time 
                int employeeNicTxt = Integer.parseInt(employeeNic.getText());
                String  date = dateLabel.getText();
                String time = timeLabel.getText();

                //adding data to the database
                AttendenceConnect attendenceConnect = new AttendenceConnect(employeeNicTxt, date, time);
                attendenceConnect.createConnectoin();
                int result = attendenceConnect.setInAttendence();

                if(result == 1){
                    JOptionPane.showMessageDialog(this, "Successful");
                }else{
                    JOptionPane.showMessageDialog(this, "Failed");
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Error in values");
            }
        } 
    }//GEN-LAST:event_employeeInActionPerformed

    private void employeeNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeNicKeyReleased
        //updating the name field at every key press
        String nic = employeeNic.getText();
        GetEmployeeName getEmployeeName = new GetEmployeeName();
        employeeName.setText(getEmployeeName.getName(nic));
    }//GEN-LAST:event_employeeNicKeyReleased

    private void employeeOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeOutActionPerformed
        //checks for the empty text field
        try{
            if(employeeNic.getText().equals("")){
                JOptionPane.showMessageDialog(this, "NIC Cannot Be Empty");
            }else{

                //get the user input
                int employeeNicTxt = Integer.parseInt(employeeNic.getText());
                String  date = dateLabel.getText();
                String time = timeLabel.getText();

                // adding to the das=tabase
                AttendenceConnect attendenceConnect = new AttendenceConnect(employeeNicTxt, date, time);
                int result = attendenceConnect.setOutAttendence();

                if(result == 1){
                    JOptionPane.showMessageDialog(this, "Successful");
                }else{
                    JOptionPane.showMessageDialog(this, "Failed");
                }
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Error in NIC");
        }
    }//GEN-LAST:event_employeeOutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton employeeIn;
    private javax.swing.JTextField employeeName;
    private javax.swing.JTextField employeeNic;
    private javax.swing.JButton employeeOut;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
