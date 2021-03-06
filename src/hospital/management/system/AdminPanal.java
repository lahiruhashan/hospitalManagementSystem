/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import hospital.management.system.connection.CalculateSalary;
import hospital.management.system.connection.CountDays;
import hospital.management.system.connection.DBConnect;
import hospital.management.system.connection.GetEmployeeName;
import hospital.management.system.connection.PaySalaryConnect;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class AdminPanal extends javax.swing.JFrame {

    /**
     * Creates new form AdminPanal
     */
    
    //initializing global variables
    private static String username;
    private static Connection con;
    
    public AdminPanal() {
        initComponents();
    }
    
    //overloading constructor
    public AdminPanal(String username) {
        initComponents();
        this.username = username;
    }
    
     //close button click listener
    protected void closeListener(){
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    
    // set the name of the user logged in
    protected void setEmployeeName(){
        //get the name of the logged user
        GetEmployeeName setName = new GetEmployeeName();
        String name = setName.getName(username);
        String namePartials[] = name.split(" ");
        loggedUser.setText(namePartials[0]);
    }
    
    //creating the database connection
    public void createConnectoin() {
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }

    
    // check for the payability of the the salaries
    public void payable(){
        try{
            Calendar cal = new GregorianCalendar();
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);
            
            PreparedStatement pst = con.prepareStatement("select * from salary where MONTH(date) = ? and YEAR(date) = ?");
            pst.setInt(1, month);
            pst.setInt(2, year);
            ResultSet rs = pst.executeQuery();
           
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "You have already paid this month salary");
            }else{
                PaySalaryConnect psc = new PaySalaryConnect();
            }
        }catch(Exception ex){
            System.out.println(ex);
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
        paySalary = new javax.swing.JButton();
        doctorView = new javax.swing.JButton();
        nurseView = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        addEmployee = new javax.swing.JButton();
        userView = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JSeparator();
        logDetails = new javax.swing.JButton();
        employeeListView = new javax.swing.JButton();
        deleteEmployee = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        attendenceEmployeeId = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        attendenceCheck = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        presentCount = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        absentCount = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        attendanceMonth = new com.toedter.calendar.JMonthChooser();
        attendanceYear = new com.toedter.calendar.JYearChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        salaryEmployeeId = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        calculateSalary = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        salary = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        salaryYear = new com.toedter.calendar.JYearChooser();
        salaryMonth = new com.toedter.calendar.JMonthChooser();
        jPanel7 = new javax.swing.JPanel();
        logOutButton = new javax.swing.JButton();
        loggedUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(67, 101, 112));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paySalary.setBackground(new java.awt.Color(51, 51, 51));
        paySalary.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        paySalary.setForeground(new java.awt.Color(255, 255, 255));
        paySalary.setText("Pay Salary");
        paySalary.setBorder(null);
        paySalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paySalaryActionPerformed(evt);
            }
        });
        jPanel1.add(paySalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 160, 40));

        doctorView.setBackground(new java.awt.Color(51, 51, 51));
        doctorView.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        doctorView.setForeground(new java.awt.Color(255, 255, 255));
        doctorView.setText("Doctor View");
        doctorView.setBorder(null);
        doctorView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        doctorView.setMinimumSize(new java.awt.Dimension(121, 23));
        doctorView.setPreferredSize(new java.awt.Dimension(121, 23));
        doctorView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        doctorView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorViewActionPerformed(evt);
            }
        });
        jPanel1.add(doctorView, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 160, 40));

        nurseView.setBackground(new java.awt.Color(51, 51, 51));
        nurseView.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        nurseView.setForeground(new java.awt.Color(255, 255, 255));
        nurseView.setText("Nurse View");
        nurseView.setBorder(null);
        nurseView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nurseView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nurseView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nurseViewActionPerformed(evt);
            }
        });
        jPanel1.add(nurseView, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 160, 40));

        jSeparator1.setBackground(new java.awt.Color(92, 106, 117));
        jSeparator1.setForeground(new java.awt.Color(92, 106, 117));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 220, 10));

        jSeparator2.setBackground(new java.awt.Color(92, 106, 117));
        jSeparator2.setForeground(new java.awt.Color(92, 106, 117));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 220, 10));

        addEmployee.setBackground(new java.awt.Color(51, 51, 51));
        addEmployee.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        addEmployee.setForeground(new java.awt.Color(255, 255, 255));
        addEmployee.setText("Add Employee");
        addEmployee.setBorder(null);
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });
        jPanel1.add(addEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 160, 40));

        userView.setBackground(new java.awt.Color(51, 51, 51));
        userView.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        userView.setForeground(new java.awt.Color(255, 255, 255));
        userView.setText("User View");
        userView.setBorder(null);
        userView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        userView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userViewActionPerformed(evt);
            }
        });
        jPanel1.add(userView, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 160, 40));

        jSeparator12.setBackground(new java.awt.Color(92, 106, 117));
        jSeparator12.setForeground(new java.awt.Color(92, 106, 117));
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 220, 10));

        logDetails.setBackground(new java.awt.Color(51, 51, 51));
        logDetails.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        logDetails.setForeground(new java.awt.Color(255, 255, 255));
        logDetails.setText("Log Details");
        logDetails.setBorder(null);
        logDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(logDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 160, 40));

        employeeListView.setBackground(new java.awt.Color(51, 51, 51));
        employeeListView.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        employeeListView.setForeground(new java.awt.Color(255, 255, 255));
        employeeListView.setText("Employee List");
        employeeListView.setBorder(null);
        employeeListView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeListViewActionPerformed(evt);
            }
        });
        jPanel1.add(employeeListView, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 160, 40));

        deleteEmployee.setBackground(new java.awt.Color(51, 51, 51));
        deleteEmployee.setFont(new java.awt.Font("Quicksand", 0, 18)); // NOI18N
        deleteEmployee.setForeground(new java.awt.Color(255, 255, 255));
        deleteEmployee.setText("Delete Employee");
        deleteEmployee.setBorder(null);
        deleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmployeeActionPerformed(evt);
            }
        });
        jPanel1.add(deleteEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 660));

        jPanel3.setBackground(new java.awt.Color(217, 222, 225));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attendence Check", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(51, 51, 51));
        jLabel19.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Employee ID");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 80, 30));

        attendenceEmployeeId.setBackground(new java.awt.Color(217, 222, 225));
        attendenceEmployeeId.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        attendenceEmployeeId.setForeground(new java.awt.Color(0, 0, 0));
        attendenceEmployeeId.setBorder(null);
        jPanel3.add(attendenceEmployeeId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 190, 30));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 190, 10));

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Month");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 110, 30));

        attendenceCheck.setBackground(new java.awt.Color(0, 152, 216));
        attendenceCheck.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        attendenceCheck.setForeground(new java.awt.Color(255, 255, 255));
        attendenceCheck.setText("Check");
        attendenceCheck.setBorder(null);
        attendenceCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendenceCheckActionPerformed(evt);
            }
        });
        jPanel3.add(attendenceCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 110, 40));

        jLabel20.setBackground(new java.awt.Color(51, 51, 51));
        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Present");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 80, 30));

        presentCount.setBackground(new java.awt.Color(217, 222, 225));
        presentCount.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        presentCount.setForeground(new java.awt.Color(0, 0, 0));
        presentCount.setBorder(null);
        jPanel3.add(presentCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 190, 30));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 190, 10));

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Absent");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 110, 30));

        absentCount.setBackground(new java.awt.Color(217, 222, 225));
        absentCount.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        absentCount.setForeground(new java.awt.Color(0, 0, 0));
        absentCount.setBorder(null);
        jPanel3.add(absentCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 190, 30));

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 190, 10));

        attendanceMonth.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jPanel3.add(attendanceMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, 40));

        attendanceYear.setBackground(new java.awt.Color(217, 222, 225));
        jPanel3.add(attendanceYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 400, 560));

        jPanel4.setBackground(new java.awt.Color(217, 222, 225));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salary Calculator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Employee ID");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 80, 30));

        salaryEmployeeId.setBackground(new java.awt.Color(217, 222, 225));
        salaryEmployeeId.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        salaryEmployeeId.setForeground(new java.awt.Color(0, 0, 0));
        salaryEmployeeId.setBorder(null);
        jPanel4.add(salaryEmployeeId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 190, 30));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 190, 10));

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Month");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 110, 30));

        calculateSalary.setBackground(new java.awt.Color(0, 152, 216));
        calculateSalary.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        calculateSalary.setForeground(new java.awt.Color(255, 255, 255));
        calculateSalary.setText("Calculate");
        calculateSalary.setBorder(null);
        calculateSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateSalaryActionPerformed(evt);
            }
        });
        jPanel4.add(calculateSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 110, 40));

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Salary (Rs.)");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 110, 30));

        salary.setBackground(new java.awt.Color(217, 222, 225));
        salary.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        salary.setForeground(new java.awt.Color(0, 0, 0));
        salary.setBorder(null);
        jPanel4.add(salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 190, 30));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 190, 10));

        salaryYear.setBackground(new java.awt.Color(217, 222, 225));
        jPanel4.add(salaryYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, 40));

        salaryMonth.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        jPanel4.add(salaryMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 400, 560));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutButton.setBackground(new java.awt.Color(0, 152, 216));
        logOutButton.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logout Rounded Up-20.png"))); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.setBorder(null);
        logOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logOutButton.setIconTextGap(10);
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        jPanel7.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 140, 30));

        loggedUser.setBackground(new java.awt.Color(0, 152, 216));
        loggedUser.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        loggedUser.setForeground(new java.awt.Color(255, 255, 255));
        loggedUser.setText("Current User");
        loggedUser.setBorder(null);
        loggedUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loggedUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel7.add(loggedUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 140, 30));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 800, 100));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        //opening the logging window
        Login login = new Login();
        login.closeListener();
        login.currentDateTime();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void doctorViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorViewActionPerformed
        //opening the doctor's view window
        DoctorView doctorV = new DoctorView(username);
        doctorV.createConnectoin();
        doctorV.closeListener();
        doctorV.fillTable();
        doctorV.setEmployeeName();
        doctorV.setVisible(true);
        dispose();
    }//GEN-LAST:event_doctorViewActionPerformed

    private void nurseViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nurseViewActionPerformed
        //opening the nurse's view window
        NurseView nurseView = new NurseView(username);
        nurseView.createConnectoin();
        nurseView.closeListener();
        nurseView.fillTable();
        nurseView.setEmployeeName();
        nurseView.setVisible(true);
        dispose();
    }//GEN-LAST:event_nurseViewActionPerformed

    private void paySalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paySalaryActionPerformed
        //checking and adding salaries to the databases
        payable();
    }//GEN-LAST:event_paySalaryActionPerformed

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed
        //opening the add employee window
        AddEmployee addEmployee = new AddEmployee();
        addEmployee.setVisible(true);
    }//GEN-LAST:event_addEmployeeActionPerformed

    private void userViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userViewActionPerformed
        //opening the reception window
        NormalUserView normalView = new NormalUserView(username);
        normalView.createConnectoin();
        normalView.closeListener();
        normalView.setEmployeeName();
        normalView.fillTable();
        normalView.setVisible(true);
        dispose();
    }//GEN-LAST:event_userViewActionPerformed

    private void logDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logDetailsActionPerformed
        LoginDetails loginDetails = new LoginDetails();
        loginDetails.createConnection();
        loginDetails.fillLogTable();
        loginDetails.setVisible(true);
    }//GEN-LAST:event_logDetailsActionPerformed

    private void attendenceCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendenceCheckActionPerformed
        try {
            //checking for the empty text field
            if (attendenceEmployeeId.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Employee ID Cannot Be Empty");
            } else {
                //getting the user input and assigning to the variables
                int employeeId = Integer.parseInt(attendenceEmployeeId.getText());
                int year = attendanceYear.getYear();
                int month = attendanceMonth.getMonth();
                
                //get the days that employee has present in the month
                CountDays daysCount = new CountDays();
                int count = daysCount.countDays(employeeId, year, month + 1);
                
                //assining the required month and the year
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                
                //getting the number of days in the month
                int days = cal.getActualMaximum(Calendar.DATE);
                
                //displying the present and absent days
                presentCount.setText(String.valueOf(count));
                absentCount.setText(String.valueOf(days - count));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "You Cannot Enter Letters To ID");
        }
    }//GEN-LAST:event_attendenceCheckActionPerformed

    private void calculateSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateSalaryActionPerformed
        try {
            //checks for the empty text field
            if (salaryEmployeeId.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Employee ID Cannot Be Empty");
            } else {
                
                // getting the user input
                int employeeId = Integer.parseInt(salaryEmployeeId.getText());
                int year = salaryYear.getYear();
                int month = salaryMonth.getMonth() + 1;
                
                //getting the number of days that employee has present
                CountDays counter = new CountDays();
                int count = counter.countDays(employeeId, year, month);
                
                //calculating the salary
                CalculateSalary calSalary = new CalculateSalary(employeeId, month, year);
                float salaryAmount = calSalary.getSalary();
                salary.setText(String.valueOf(salaryAmount));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "You Cannot Enter Letters To ID");
        }        
    }//GEN-LAST:event_calculateSalaryActionPerformed

    private void employeeListViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeListViewActionPerformed
        // opeing the employee list window
        EmployeeList list = new EmployeeList();
        list.createConnectoin();
        list.fillTable();
        list.setVisible(true);
    }//GEN-LAST:event_employeeListViewActionPerformed

    private void deleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmployeeActionPerformed
        //opeinging the delete employee window
        DeleteEmployee delete = new DeleteEmployee();
        delete.setVisible(true);
    }//GEN-LAST:event_deleteEmployeeActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField absentCount;
    private javax.swing.JButton addEmployee;
    private com.toedter.calendar.JMonthChooser attendanceMonth;
    private com.toedter.calendar.JYearChooser attendanceYear;
    private javax.swing.JButton attendenceCheck;
    private javax.swing.JTextField attendenceEmployeeId;
    private javax.swing.JButton calculateSalary;
    private javax.swing.JButton deleteEmployee;
    private javax.swing.JButton doctorView;
    private javax.swing.JButton employeeListView;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton logDetails;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton loggedUser;
    private javax.swing.JButton nurseView;
    private javax.swing.JButton paySalary;
    private javax.swing.JTextField presentCount;
    private javax.swing.JTextField salary;
    private javax.swing.JTextField salaryEmployeeId;
    private com.toedter.calendar.JMonthChooser salaryMonth;
    private com.toedter.calendar.JYearChooser salaryYear;
    private javax.swing.JButton userView;
    // End of variables declaration//GEN-END:variables
}
