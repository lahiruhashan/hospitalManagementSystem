/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import hospital.management.system.connection.DBConnect;
import hospital.management.system.connection.MakePaymentConnect;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class MakePayment extends javax.swing.JFrame {

    /**
     * Creates new form MakePayment
     */
    
    //global variables
    private Connection con;
    
    public MakePayment() {
        initComponents();
    }
    
    // create connection
     public void createConnectoin() {
 
        DBConnect db = new DBConnect();
        this.con = db.createConnection();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING:     Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        patientNic = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        amountPaid = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        payButton = new javax.swing.JButton();
        patientName = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 152, 216));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 170, 10));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 230, 10));

        jLabel7.setBackground(new java.awt.Color(0, 153, 204));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cash in Hand-100.png"))); // NOI18N
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 110, 150));

        jLabel4.setBackground(new java.awt.Color(0, 152, 216));
        jLabel4.setFont(new java.awt.Font("Quicksand", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Make A Payment");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 240, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 490));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Patient NIC");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 80, 30));

        patientNic.setBackground(new java.awt.Color(51, 51, 51));
        patientNic.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        patientNic.setForeground(new java.awt.Color(255, 255, 255));
        patientNic.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        patientNic.setBorder(null);
        patientNic.setCaretColor(new java.awt.Color(255, 255, 255));
        patientNic.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        patientNic.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        patientNic.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        patientNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                patientNicKeyReleased(evt);
            }
        });
        jPanel2.add(patientNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 190, 30));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 190, 10));

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Amount");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 90, 30));

        amountPaid.setBackground(new java.awt.Color(51, 51, 51));
        amountPaid.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        amountPaid.setForeground(new java.awt.Color(255, 255, 255));
        amountPaid.setBorder(null);
        amountPaid.setCaretColor(new java.awt.Color(255, 255, 255));
        amountPaid.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(amountPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 190, 30));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 190, 10));

        payButton.setBackground(new java.awt.Color(0, 152, 216));
        payButton.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        payButton.setForeground(new java.awt.Color(255, 255, 255));
        payButton.setText("Confirm Payment");
        payButton.setBorder(null);
        payButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        payButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });
        jPanel2.add(payButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 140, 30));

        patientName.setEditable(false);
        patientName.setBackground(new java.awt.Color(51, 51, 51));
        patientName.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        patientName.setForeground(new java.awt.Color(255, 255, 255));
        patientName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        patientName.setBorder(null);
        patientName.setCaretColor(new java.awt.Color(255, 255, 255));
        patientName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        patientName.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        patientName.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(patientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 190, 30));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 190, 10));

        jLabel19.setBackground(new java.awt.Color(51, 51, 51));
        jLabel19.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Patient Name");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 100, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 370, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
       
        if(patientNic.getText().equals("") || amountPaid.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Enter values");
            
        }else{
            try{
                //add the payment details to the database
                String nic = patientNic.getText();
                Float amount = Float.parseFloat(amountPaid.getText());

                MakePaymentConnect mpk = new MakePaymentConnect(Integer.parseInt(nic), amount);
                int result = mpk.setPayment();

                if(result == 1){
                    JOptionPane.showMessageDialog(this, "Successful");
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Failed");
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Invalid Amount");
                
            }
            
        }   
    }//GEN-LAST:event_payButtonActionPerformed

    private void patientNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patientNicKeyReleased
        // get the matching name of the patient and set on the label
        try {
            String query = "select * from patient where nic = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, patientNic.getText());
            ResultSet rs = pst.executeQuery();
            patientName.setText("");
            while (rs.next()) {

                String name = rs.getString("name");
                
                patientName.setText(name);

            }
            

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No Such Patient");
        }
    }//GEN-LAST:event_patientNicKeyReleased

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
            java.util.logging.Logger.getLogger(MakePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakePayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountPaid;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField patientName;
    private javax.swing.JTextField patientNic;
    private javax.swing.JButton payButton;
    // End of variables declaration//GEN-END:variables
}