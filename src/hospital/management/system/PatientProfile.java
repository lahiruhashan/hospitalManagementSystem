/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import hospital.management.system.connection.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashan
 */
public class PatientProfile extends javax.swing.JFrame {

    /**
     * Creates new form PatientProfile
     */
    
    // global variables
    private int username;
    private int patientNic;
    private int patientId;
    private String patientName;
    private String sick;
    private Connection con;
    
    public PatientProfile() {
        initComponents();
 
    }
    //constructor overloading
    public PatientProfile(int patientNic) {
        initComponents();
        this.patientNic = patientNic;
 
    }
    //constructor overloading
    public PatientProfile(int patientNic,int username) {
        initComponents();
        this.patientNic = patientNic;
        this.username = username;
        
    }
    
     //create the database connection
    public void createConnectoin() {
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }
  
    // fill up the lables with patient details
    public void display(){
        try {
            
            PreparedStatement ps = con.prepareStatement("select * from patient where nic = ? and discharge_date is null");
            
            ps.setInt(1,patientNic);
            ResultSet rst;
            String consultant = "";
            
            rst = ps.executeQuery();
            
            while(rst.next()){
                
                this.patientName = rst.getString("name");
                int patientId = rst.getInt("patient_id");
                int weight = rst.getInt("weight");
                String bloodGroup = rst.getString("blood_group");
                int ward = rst.getInt("ward");
                consultant = rst.getString("consultant");
                sick = rst.getString("sickness");
                
                this.patientId = patientId;
                patientNameLabel.setText(patientName);
                patientNicLabel.setText(String.valueOf(patientNic));
                setWeight.setText(String.valueOf(weight));
                setBloodGroup.setText(bloodGroup);
                setWard.setText(String.valueOf(ward));
                sickness.setText(sick);
                
            }
            
            // get employee name of the given employee id
            PreparedStatement pst = con.prepareStatement("select name from employee where employee_id = ?");
            
            pst.setInt(1,Integer.parseInt(consultant));
            ResultSet result;
            
            result = pst.executeQuery();
            
            while(result.next()){
                String name = result.getString("name");
                String namePartials[] = name.split(" ");
                consultantName.setText("Dr. " + namePartials[0]);
                
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fill Table Display Failed");
        }
    }
    
    // fill the table with the patient's test results
    public void fillTable() {
        try {
            PreparedStatement pss = con.prepareStatement("select * from patient_test where nic = ?");
            
            pss.setInt(1,patientNic);
            ResultSet resultSet;
            String add1 = "",add2 = "",add3 = "",add4 = "",add5 = "";
            resultSet = pss.executeQuery();
            
            while (resultSet.next()) {
                add1 = resultSet.getString("test_id");
                add2 = resultSet.getString("recommendation");
                add3 = resultSet.getString("date");
                add4 = resultSet.getString("time");
                add5 = resultSet.getString("result");
                
                // get the test name of the given test id
                PreparedStatement pst = con.prepareStatement("select test_name from test where test_id = ?");
                pst.setString(1,add1);
                ResultSet rst;
                String name = "";
                rst = pst.executeQuery();

                while (rst.next()) {
                    name = rst.getString("test_name");

                }
                    DefaultTableModel model = (DefaultTableModel) testResultsTable.getModel();
                    model.addRow(new Object[]{name, add2, add3, add4, add5});
                }
            
            
            

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fill Table Failed");
        }
    }
    
    // display the examined doctor of the current patient
    public void doctorExamine(){
        
        // get the system date and time
        Date currentDate = new Date();
        java.sql.Date txtDate= new java.sql.Date(currentDate.getTime());
        Time txtTime = new Time(currentDate.getTime());
        
        int consultant = 0;
        try {
            PreparedStatement pst = con.prepareStatement("select consultant from patient where nic = ?");
            pst.setInt(1, patientNic);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                consultant = rs.getInt("consultant");
            }
            
            // insert into examined doctor table if the current logged doctor is not patients consultant
            if(username != consultant){
                
                PreparedStatement ps = con.prepareStatement("insert into doctor_examine_patient values(?,?,?,?,?,?)");
                ps.setString(1, null);
                ps.setInt(2,patientId);
                ps.setInt(3, username);
                ps.setDate(4, txtDate);
                ps.setTime(5, txtTime);
                ps.setString(6, remarkText.getText());


                ps.executeUpdate();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Examine Update Failed");
        }
        
    }
    
    public void addCheckedTest(){
        // get the checked list of test
        ArrayList<Integer> testArray = new  ArrayList<>();
        if(testCompleteBloodCount.isSelected() == true){
            testArray.add(1);
        }
        if(testEchocardiography.isSelected() == true){
           testArray.add(2);
        }
        if(testColonoscopy.isSelected() == true){
            testArray.add(3);
        }
        if(testMRI.isSelected() == true){
            testArray.add(4);
        }
        if(testCTScan.isSelected() == true){
            testArray.add(5);
        }
        if(testElectrocardiogram.isSelected() == true){
            testArray.add(6);
        }
        if(testAIC.isSelected() == true){
            testArray.add(7);
        }
        if(testCMP.isSelected() == true){
            testArray.add(8);
        }
        if(testUrineTest.isSelected() == true){
            testArray.add(9);
        }
        
        Date currentDate = new Date();
        java.sql.Date txtDate= new java.sql.Date(currentDate.getTime());
        Time txtTime = new Time(currentDate.getTime());

        // fill the patients test table with all the checked tests
        try{
            for (Integer test : testArray){
               PreparedStatement pss = con.prepareStatement("insert into patient_test values(?,?,?,?,?,?,?,?,?)");
               pss.setString(1, null);
               pss.setInt(2, patientId);
               pss.setInt(3, patientNic);
               pss.setInt(4, test);
               pss.setInt(5, username);
               pss.setDate(6, txtDate); 
               pss.setTime(7, txtTime);
               pss.setString(8, null);
               pss.setString(9, null);
               pss.executeUpdate();
             }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Test Entry Failed");
        }
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
        jLabel1 = new javax.swing.JLabel();
        exitWithouotSave = new javax.swing.JButton();
        patientNicLabel = new javax.swing.JLabel();
        patientNameLabel = new javax.swing.JLabel();
        saveAndExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        setAge = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        consultantName = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        setWeight = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        setWard = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        setBloodGroup = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        addWeight = new javax.swing.JButton();
        addBloodGroup1 = new javax.swing.JButton();
        sickness = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        recommendedTest = new javax.swing.JButton();
        addSickness = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        testUrineTest = new javax.swing.JCheckBox();
        testCompleteBloodCount = new javax.swing.JCheckBox();
        testEchocardiography = new javax.swing.JCheckBox();
        testColonoscopy = new javax.swing.JCheckBox();
        testMRI = new javax.swing.JCheckBox();
        testCTScan = new javax.swing.JCheckBox();
        testElectrocardiogram = new javax.swing.JCheckBox();
        testAIC = new javax.swing.JCheckBox();
        testCMP = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        patientHistoryButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        testResultsTable = new javax.swing.JTable();
        patientDischarge = new javax.swing.JButton();
        examinedDoctors = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarkText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(1366, 728));
        setPreferredSize(new java.awt.Dimension(1366, 728));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 152, 216));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User-100.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 100));

        exitWithouotSave.setBackground(new java.awt.Color(51, 51, 51));
        exitWithouotSave.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 16)); // NOI18N
        exitWithouotSave.setForeground(new java.awt.Color(255, 255, 255));
        exitWithouotSave.setText("Exit Without Saving");
        exitWithouotSave.setBorder(null);
        exitWithouotSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitWithouotSaveActionPerformed(evt);
            }
        });
        jPanel1.add(exitWithouotSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 60, 170, 30));

        patientNicLabel.setBackground(new java.awt.Color(0, 152, 216));
        patientNicLabel.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        patientNicLabel.setForeground(new java.awt.Color(255, 255, 255));
        patientNicLabel.setText("NIC");
        jPanel1.add(patientNicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 290, 40));

        patientNameLabel.setBackground(new java.awt.Color(0, 152, 216));
        patientNameLabel.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        patientNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        patientNameLabel.setText("Patient Name");
        jPanel1.add(patientNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 290, 40));

        saveAndExit.setBackground(new java.awt.Color(51, 51, 51));
        saveAndExit.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 16)); // NOI18N
        saveAndExit.setForeground(new java.awt.Color(255, 255, 255));
        saveAndExit.setText("Save & Exit");
        saveAndExit.setBorder(null);
        saveAndExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAndExitActionPerformed(evt);
            }
        });
        jPanel1.add(saveAndExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 170, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 100));

        jPanel2.setBackground(new java.awt.Color(67, 101, 112));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(67, 101, 111));
        jLabel5.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SUMMARY");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 40));

        jPanel5.setBackground(new java.awt.Color(67, 101, 112));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setAge.setBackground(new java.awt.Color(67, 101, 112));
        setAge.setFont(new java.awt.Font("Quicksand", 0, 36)); // NOI18N
        setAge.setForeground(new java.awt.Color(217, 222, 225));
        setAge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setAge.setText("36");
        jPanel5.add(setAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 60));

        jLabel6.setBackground(new java.awt.Color(67, 101, 112));
        jLabel6.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Age");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 110, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 110));

        jPanel10.setBackground(new java.awt.Color(67, 101, 112));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consultantName.setBackground(new java.awt.Color(67, 101, 112));
        consultantName.setFont(new java.awt.Font("Quicksand", 0, 36)); // NOI18N
        consultantName.setForeground(new java.awt.Color(217, 222, 225));
        consultantName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        consultantName.setText("Dr.Ajantha");
        jPanel10.add(consultantName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 240, 60));

        jLabel12.setBackground(new java.awt.Color(67, 101, 112));
        jLabel12.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("CONSULTANT");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 240, 30));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 240, 110));

        jPanel6.setBackground(new java.awt.Color(67, 101, 112));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setWeight.setBackground(new java.awt.Color(67, 101, 112));
        setWeight.setFont(new java.awt.Font("Quicksand", 0, 36)); // NOI18N
        setWeight.setForeground(new java.awt.Color(217, 222, 225));
        setWeight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setWeight.setText("70");
        jPanel6.add(setWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 60));

        jLabel8.setBackground(new java.awt.Color(67, 101, 112));
        jLabel8.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Weight");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 110, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 110, 110));

        jPanel7.setBackground(new java.awt.Color(67, 101, 112));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setWard.setBackground(new java.awt.Color(67, 101, 112));
        setWard.setFont(new java.awt.Font("Quicksand", 0, 36)); // NOI18N
        setWard.setForeground(new java.awt.Color(217, 222, 225));
        setWard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setWard.setText("2");
        jPanel7.add(setWard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 60));

        jLabel10.setBackground(new java.awt.Color(67, 101, 112));
        jLabel10.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ward");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 110, 30));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 110, 110));

        jPanel8.setBackground(new java.awt.Color(67, 101, 112));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(67, 101, 112));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 110, 110));

        setBloodGroup.setBackground(new java.awt.Color(67, 101, 112));
        setBloodGroup.setFont(new java.awt.Font("Quicksand", 0, 36)); // NOI18N
        setBloodGroup.setForeground(new java.awt.Color(217, 222, 225));
        setBloodGroup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setBloodGroup.setText("AB-");
        jPanel8.add(setBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 60));

        jLabel15.setBackground(new java.awt.Color(67, 101, 112));
        jLabel15.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Blood Group");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 110, 30));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 110, 110));

        jSeparator1.setBackground(new java.awt.Color(92, 106, 117));
        jSeparator1.setForeground(new java.awt.Color(92, 106, 117));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 240, 10));

        jSeparator2.setBackground(new java.awt.Color(92, 106, 117));
        jSeparator2.setForeground(new java.awt.Color(92, 106, 117));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 10, 120));

        jSeparator4.setBackground(new java.awt.Color(92, 106, 117));
        jSeparator4.setForeground(new java.awt.Color(92, 106, 117));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 240, 10));

        jSeparator5.setBackground(new java.awt.Color(92, 106, 117));
        jSeparator5.setForeground(new java.awt.Color(92, 106, 117));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 10, 120));

        addWeight.setBackground(new java.awt.Color(51, 51, 51));
        addWeight.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        addWeight.setForeground(new java.awt.Color(255, 255, 255));
        addWeight.setText("Add Weight");
        addWeight.setBorder(null);
        addWeight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addWeight.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWeightActionPerformed(evt);
            }
        });
        jPanel2.add(addWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 130, 30));

        addBloodGroup1.setBackground(new java.awt.Color(51, 51, 51));
        addBloodGroup1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        addBloodGroup1.setForeground(new java.awt.Color(255, 255, 255));
        addBloodGroup1.setText("Add Blood Group");
        addBloodGroup1.setBorder(null);
        addBloodGroup1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBloodGroup1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addBloodGroup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBloodGroup1ActionPerformed(evt);
            }
        });
        jPanel2.add(addBloodGroup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, 120, 30));

        sickness.setBackground(new java.awt.Color(67, 101, 112));
        sickness.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        sickness.setForeground(new java.awt.Color(217, 222, 225));
        sickness.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sickness.setText("HEADACHE");
        jPanel2.add(sickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 270, 40));

        jLabel14.setBackground(new java.awt.Color(67, 101, 112));
        jLabel14.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("SICKNESS");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 240, 30));

        jSeparator6.setBackground(new java.awt.Color(92, 106, 117));
        jSeparator6.setForeground(new java.awt.Color(92, 106, 117));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, 10));

        jSeparator7.setBackground(new java.awt.Color(92, 106, 117));
        jSeparator7.setForeground(new java.awt.Color(92, 106, 117));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 240, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 290, 630));

        jPanel3.setBackground(new java.awt.Color(217, 222, 225));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(67, 101, 112));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recommendedTest.setBackground(new java.awt.Color(51, 51, 51));
        recommendedTest.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        recommendedTest.setForeground(new java.awt.Color(255, 255, 255));
        recommendedTest.setText("View Recommended Test");
        recommendedTest.setBorder(null);
        recommendedTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        recommendedTest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        recommendedTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recommendedTestActionPerformed(evt);
            }
        });
        jPanel11.add(recommendedTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 30));

        addSickness.setBackground(new java.awt.Color(51, 51, 51));
        addSickness.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        addSickness.setForeground(new java.awt.Color(255, 255, 255));
        addSickness.setText("Add Sickness");
        addSickness.setBorder(null);
        addSickness.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addSickness.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addSickness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSicknessActionPerformed(evt);
            }
        });
        jPanel11.add(addSickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 190, 30));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 220, 140));

        jLabel13.setBackground(new java.awt.Color(67, 101, 111));
        jLabel13.setFont(new java.awt.Font("Raleway", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(67, 83, 97));
        jLabel13.setText("Tests");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 40));

        testUrineTest.setBackground(new java.awt.Color(217, 222, 225));
        testUrineTest.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        testUrineTest.setForeground(new java.awt.Color(51, 51, 51));
        testUrineTest.setText("Urine Test");
        testUrineTest.setBorder(null);
        testUrineTest.setIconTextGap(6);
        jPanel3.add(testUrineTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        testCompleteBloodCount.setBackground(new java.awt.Color(217, 222, 225));
        testCompleteBloodCount.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        testCompleteBloodCount.setForeground(new java.awt.Color(51, 51, 51));
        testCompleteBloodCount.setText("Complete Blood Count");
        testCompleteBloodCount.setBorder(null);
        testCompleteBloodCount.setIconTextGap(6);
        jPanel3.add(testCompleteBloodCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        testEchocardiography.setBackground(new java.awt.Color(217, 222, 225));
        testEchocardiography.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        testEchocardiography.setForeground(new java.awt.Color(51, 51, 51));
        testEchocardiography.setText("Echocardiography");
        testEchocardiography.setBorder(null);
        testEchocardiography.setIconTextGap(6);
        jPanel3.add(testEchocardiography, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        testColonoscopy.setBackground(new java.awt.Color(217, 222, 225));
        testColonoscopy.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        testColonoscopy.setForeground(new java.awt.Color(51, 51, 51));
        testColonoscopy.setText("Colonoscopy");
        testColonoscopy.setBorder(null);
        testColonoscopy.setIconTextGap(6);
        jPanel3.add(testColonoscopy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        testMRI.setBackground(new java.awt.Color(217, 222, 225));
        testMRI.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        testMRI.setForeground(new java.awt.Color(51, 51, 51));
        testMRI.setText("MRI");
        testMRI.setBorder(null);
        testMRI.setIconTextGap(6);
        jPanel3.add(testMRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        testCTScan.setBackground(new java.awt.Color(217, 222, 225));
        testCTScan.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        testCTScan.setForeground(new java.awt.Color(51, 51, 51));
        testCTScan.setText("CT Scan");
        testCTScan.setBorder(null);
        testCTScan.setIconTextGap(6);
        jPanel3.add(testCTScan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        testElectrocardiogram.setBackground(new java.awt.Color(217, 222, 225));
        testElectrocardiogram.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        testElectrocardiogram.setForeground(new java.awt.Color(51, 51, 51));
        testElectrocardiogram.setText("Electrocardiogram (EKG)");
        testElectrocardiogram.setBorder(null);
        testElectrocardiogram.setIconTextGap(6);
        jPanel3.add(testElectrocardiogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        testAIC.setBackground(new java.awt.Color(217, 222, 225));
        testAIC.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        testAIC.setForeground(new java.awt.Color(51, 51, 51));
        testAIC.setText("AIC ");
        testAIC.setBorder(null);
        testAIC.setIconTextGap(6);
        jPanel3.add(testAIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        testCMP.setBackground(new java.awt.Color(217, 222, 225));
        testCMP.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        testCMP.setForeground(new java.awt.Color(51, 51, 51));
        testCMP.setText("CMP");
        testCMP.setBorder(null);
        testCMP.setIconTextGap(6);
        jPanel3.add(testCMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 100, 220, 630));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patientHistoryButton.setBackground(new java.awt.Color(0, 152, 216));
        patientHistoryButton.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        patientHistoryButton.setForeground(new java.awt.Color(255, 255, 255));
        patientHistoryButton.setText("Patient's History");
        patientHistoryButton.setBorder(null);
        patientHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientHistoryButtonActionPerformed(evt);
            }
        });
        jPanel4.add(patientHistoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 120, 80));

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        testResultsTable.setBackground(new java.awt.Color(51, 51, 51));
        testResultsTable.setFont(new java.awt.Font("Quicksand", 0, 12)); // NOI18N
        testResultsTable.setForeground(new java.awt.Color(255, 255, 255));
        testResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test Name", "Recommended By", "Date", "Time", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        testResultsTable.setRowHeight(60);
        testResultsTable.setSelectionBackground(new java.awt.Color(0, 152, 216));
        testResultsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        testResultsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        testResultsTable.setShowHorizontalLines(false);
        testResultsTable.setShowVerticalLines(false);
        testResultsTable.getTableHeader().setReorderingAllowed(false);
        testResultsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                testResultsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(testResultsTable);
        testResultsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (testResultsTable.getColumnModel().getColumnCount() > 0) {
            testResultsTable.getColumnModel().getColumn(0).setResizable(false);
            testResultsTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            testResultsTable.getColumnModel().getColumn(1).setResizable(false);
            testResultsTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            testResultsTable.getColumnModel().getColumn(2).setResizable(false);
            testResultsTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            testResultsTable.getColumnModel().getColumn(3).setResizable(false);
            testResultsTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            testResultsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 490));

        patientDischarge.setBackground(new java.awt.Color(0, 152, 216));
        patientDischarge.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        patientDischarge.setForeground(new java.awt.Color(153, 0, 0));
        patientDischarge.setText("Discharge");
        patientDischarge.setBorder(null);
        patientDischarge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientDischargeActionPerformed(evt);
            }
        });
        jPanel4.add(patientDischarge, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 500, 120, 80));

        examinedDoctors.setBackground(new java.awt.Color(0, 152, 216));
        examinedDoctors.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        examinedDoctors.setForeground(new java.awt.Color(255, 255, 255));
        examinedDoctors.setText("Examined Doctors");
        examinedDoctors.setBorder(null);
        examinedDoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinedDoctorsActionPerformed(evt);
            }
        });
        jPanel4.add(examinedDoctors, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 120, 80));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, 420, 10));

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("");

        remarkText.setBackground(new java.awt.Color(51, 51, 51));
        remarkText.setColumns(20);
        remarkText.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        remarkText.setForeground(new java.awt.Color(255, 255, 255));
        remarkText.setLineWrap(true);
        remarkText.setRows(3);
        remarkText.setText("Click Here To Enter Remarks...");
        remarkText.setBorder(null);
        remarkText.setCaretColor(new java.awt.Color(255, 255, 255));
        remarkText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remarkTextMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(remarkText);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, 430, 80));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 860, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitWithouotSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitWithouotSaveActionPerformed
        doctorExamine();
        this.dispose();
    }//GEN-LAST:event_exitWithouotSaveActionPerformed

    private void saveAndExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAndExitActionPerformed
        doctorExamine();
        addCheckedTest();
        this.dispose();
    }//GEN-LAST:event_saveAndExitActionPerformed

    private void examinedDoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinedDoctorsActionPerformed
        ExaminedDoctors examinedDocs = new ExaminedDoctors(patientNic,patientNameLabel.getText());
        examinedDocs.createConnectoin();
        examinedDocs.addData();
        examinedDocs.setVisible(true);
    }//GEN-LAST:event_examinedDoctorsActionPerformed

    private void addWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWeightActionPerformed
        AddWeight addWeight = new AddWeight(patientNic);
        addWeight.createConnectoin();
        addWeight.setVisible(true);
    }//GEN-LAST:event_addWeightActionPerformed

    private void recommendedTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recommendedTestActionPerformed
        TestResults testResults = new TestResults(patientNic,patientName);
        testResults.createConnectoin();
        testResults.fillTable(patientNic,patientName);
        testResults.setVisible(true);
    }//GEN-LAST:event_recommendedTestActionPerformed

    private void remarkTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remarkTextMouseClicked
        remarkText.setText("");
    }//GEN-LAST:event_remarkTextMouseClicked

    private void testResultsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testResultsTableMouseClicked
            
        remarkText.setText("Click Here To Enter Remarks...");
        
    }//GEN-LAST:event_testResultsTableMouseClicked

    private void patientHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientHistoryButtonActionPerformed
        PatientHistory ph = new PatientHistory(patientNic);
        ph.createConnectoin();
        ph.setDisplay();
        ph.setVisible(true);
    }//GEN-LAST:event_patientHistoryButtonActionPerformed

    private void addBloodGroup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBloodGroup1ActionPerformed
        AddBloodGroup addBlood = new AddBloodGroup(patientId);
        addBlood.setVisible(true);
    }//GEN-LAST:event_addBloodGroup1ActionPerformed

    private void patientDischargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientDischargeActionPerformed
        // discharging a patient
        try{
            
            Date currentDate = new Date();
            java.sql.Date txtDate= new java.sql.Date(currentDate.getTime());
            
            PreparedStatement ps = con.prepareStatement("update patient set discharge_date = ? where patient_id = ?");
            ps.setDate(1, txtDate);
            ps.setInt(2, patientId);
            int confirm = JOptionPane.showConfirmDialog(null, "Delete " + patientNic + "?");
            if(confirm == 1){
                int result = ps.executeUpdate();
                if(result == 1){
                    JOptionPane.showMessageDialog(null, "Discharge Successful");
                }else{
                    JOptionPane.showMessageDialog(null, "Failed");
                }
            }          
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Discharge Updation Failed");
        }
        
    }//GEN-LAST:event_patientDischargeActionPerformed

    private void addSicknessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSicknessActionPerformed
        AddSickness sick = new AddSickness(patientId);
        sick.createConnectoin();
        sick.setVisible(true);
    }//GEN-LAST:event_addSicknessActionPerformed

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
            java.util.logging.Logger.getLogger(PatientProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBloodGroup1;
    private javax.swing.JButton addSickness;
    private javax.swing.JButton addWeight;
    private javax.swing.JLabel consultantName;
    private javax.swing.JButton examinedDoctors;
    private javax.swing.JButton exitWithouotSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JButton patientDischarge;
    private javax.swing.JButton patientHistoryButton;
    private javax.swing.JLabel patientNameLabel;
    private javax.swing.JLabel patientNicLabel;
    private javax.swing.JButton recommendedTest;
    private javax.swing.JTextArea remarkText;
    private javax.swing.JButton saveAndExit;
    private javax.swing.JLabel setAge;
    private javax.swing.JLabel setBloodGroup;
    private javax.swing.JLabel setWard;
    private javax.swing.JLabel setWeight;
    private javax.swing.JLabel sickness;
    private javax.swing.JCheckBox testAIC;
    private javax.swing.JCheckBox testCMP;
    private javax.swing.JCheckBox testCTScan;
    private javax.swing.JCheckBox testColonoscopy;
    private javax.swing.JCheckBox testCompleteBloodCount;
    private javax.swing.JCheckBox testEchocardiography;
    private javax.swing.JCheckBox testElectrocardiogram;
    private javax.swing.JCheckBox testMRI;
    private javax.swing.JTable testResultsTable;
    private javax.swing.JCheckBox testUrineTest;
    // End of variables declaration//GEN-END:variables
}
