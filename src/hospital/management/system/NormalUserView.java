/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import hospital.management.system.connection.DBConnect;
import hospital.management.system.connection.GetEmployeeName;
import hospital.management.system.connection.UpdatePatientConnect;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashan
 */
public class NormalUserView extends javax.swing.JFrame {

    /**
     * Creates new form NormalUserView
     */
    //global variables
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private String username;

    public NormalUserView() {
        initComponents();
    }

    //constructor override
    public NormalUserView(String username) {
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

    //create the db connection
    public void createConnectoin() {

        DBConnect db = new DBConnect();
        this.con = db.createConnection();

    }

    //fill the table with all the patient details
    public void fillTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
            model.setRowCount(0);
            
            if (toggleOff.isSelected() == true) {

                st = con.createStatement();
                String query = "select * from patient";
                ResultSet resultSet;
                resultSet = st.executeQuery(query);
                
                while (resultSet.next()) {

                    String add1 = resultSet.getString("patient_id");
                    String add2 = resultSet.getString("nic");
                    String add3 = resultSet.getString("name");
                    String add4 = resultSet.getString("gender");
                    String add5 = resultSet.getString("ward");
                    String add6 = resultSet.getString("consultant");
                    String add7 = resultSet.getString("admit_date");
                    String add8 = resultSet.getString("discharge_date");

                    model.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7, add8});
                }
            } else if (toggleOff.isSelected() == false) {

                st = con.createStatement();
                String query = "select * from patient where discharge_date is null";
                ResultSet resultSet;
                resultSet = st.executeQuery(query);
                
                while (resultSet.next()) {

                    String add1 = resultSet.getString("patient_id");
                    String add2 = resultSet.getString("nic");
                    String add3 = resultSet.getString("name");
                    String add4 = resultSet.getString("gender");
                    String add5 = resultSet.getString("ward");
                    String add6 = resultSet.getString("consultant");
                    String add7 = resultSet.getString("admit_date");
                    String add8 = resultSet.getString("discharge_date");

                    model.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7, add8});
                }
            }

            //get the ward list and add them to the ward combo
            String query_ward = "select * from ward";
            ResultSet rst;
            rst = st.executeQuery(query_ward);

            while (rst.next()) {
                int wardNumber = rst.getInt("ward_id");

                wardNumberCombo.addItem(String.valueOf(wardNumber));
            }

            // get the names of the doctors to display
            ResultSet rss;
            rss = st.executeQuery("select * from employee where type = 'Doctor'");

            while (rss.next()) {
                String name = rss.getString("name");

                confirmationCombo.addItem(name);
                consultantCombo.addItem(name);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fill Table Failed");
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

        patientGenderGroup = new javax.swing.ButtonGroup();
        tableContentsToggle = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        admitPatientButton = new javax.swing.JButton();
        PayButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        attendenceButton = new javax.swing.JButton();
        loggedUser = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        toggleOff = new javax.swing.JToggleButton();
        toggleOn = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        clearAll = new javax.swing.JButton();
        updatePatient = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        patient_id = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        patientName = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        recommendation = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        admitDate = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        dischargedDate = new javax.swing.JTextField();
        examinedDoctorsButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        addressLine1 = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        addressLine2 = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        nicNo = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        sickness = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        contactNumber = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        wardNumberCombo = new javax.swing.JComboBox<>();
        confirmationCombo = new javax.swing.JComboBox<>();
        consultantCombo = new javax.swing.JComboBox<>();
        patientMale = new javax.swing.JRadioButton();
        patientFemale = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admitPatientButton.setBackground(new java.awt.Color(0, 152, 216));
        admitPatientButton.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        admitPatientButton.setForeground(new java.awt.Color(255, 255, 255));
        admitPatientButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Desktop\\Grade 11 text\\Wheelchair-48.png")); // NOI18N
        admitPatientButton.setText("Admit Patient");
        admitPatientButton.setBorder(null);
        admitPatientButton.setHideActionText(true);
        admitPatientButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        admitPatientButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        admitPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admitPatientButtonActionPerformed(evt);
            }
        });
        jPanel1.add(admitPatientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 90));

        PayButton.setBackground(new java.awt.Color(0, 152, 216));
        PayButton.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        PayButton.setForeground(new java.awt.Color(255, 255, 255));
        PayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cash in Hand-50.png"))); // NOI18N
        PayButton.setText("Pay");
        PayButton.setBorder(null);
        PayButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PayButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayButtonActionPerformed(evt);
            }
        });
        jPanel1.add(PayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 120, 90));

        logOutButton.setBackground(new java.awt.Color(0, 152, 216));
        logOutButton.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logout Rounded Up-20.png"))); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.setBorder(null);
        logOutButton.setIconTextGap(10);
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 60, 120, 40));

        attendenceButton.setBackground(new java.awt.Color(0, 152, 216));
        attendenceButton.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        attendenceButton.setForeground(new java.awt.Color(255, 255, 255));
        attendenceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Attendance Mark-50.png"))); // NOI18N
        attendenceButton.setText("Attendence");
        attendenceButton.setBorder(null);
        attendenceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        attendenceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        attendenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendenceButtonActionPerformed(evt);
            }
        });
        jPanel1.add(attendenceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 120, 90));

        loggedUser.setBackground(new java.awt.Color(0, 152, 216));
        loggedUser.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        loggedUser.setForeground(new java.awt.Color(255, 255, 255));
        loggedUser.setText("User");
        loggedUser.setBorder(null);
        jPanel1.add(loggedUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 120, 40));

        jSeparator10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1260, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 120));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));

        patientTable.setAutoCreateRowSorter(true);
        patientTable.setBackground(new java.awt.Color(51, 51, 51));
        patientTable.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        patientTable.setForeground(new java.awt.Color(255, 255, 255));
        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "NIC", "Patient Name", "Gender", "Ward Number", "Consultant", "Admit Date", "Discharged Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        patientTable.setFocusTraversalPolicyProvider(true);
        patientTable.setGridColor(new java.awt.Color(51, 51, 51));
        patientTable.setRowHeight(50);
        patientTable.setSelectionBackground(new java.awt.Color(56, 189, 0));
        patientTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        patientTable.setShowHorizontalLines(false);
        patientTable.setShowVerticalLines(false);
        patientTable.getTableHeader().setResizingAllowed(false);
        patientTable.getTableHeader().setReorderingAllowed(false);
        patientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patientTable);
        if (patientTable.getColumnModel().getColumnCount() > 0) {
            patientTable.getColumnModel().getColumn(0).setResizable(false);
            patientTable.getColumnModel().getColumn(1).setResizable(false);
            patientTable.getColumnModel().getColumn(2).setResizable(false);
            patientTable.getColumnModel().getColumn(3).setResizable(false);
            patientTable.getColumnModel().getColumn(4).setResizable(false);
            patientTable.getColumnModel().getColumn(5).setResizable(false);
            patientTable.getColumnModel().getColumn(6).setResizable(false);
            patientTable.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 490));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searched.png"))); // NOI18N
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 48));

        searchText.setBackground(new java.awt.Color(51, 51, 51));
        searchText.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        searchText.setForeground(new java.awt.Color(255, 255, 255));
        searchText.setText("Search");
        searchText.setBorder(null);
        searchText.setCaretColor(new java.awt.Color(255, 255, 255));
        searchText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTextMouseClicked(evt);
            }
        });
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });
        jPanel10.add(searchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 310, 30));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 310, 10));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toggleOff.setBackground(new java.awt.Color(51, 51, 51));
        tableContentsToggle.add(toggleOff);
        toggleOff.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        toggleOff.setForeground(new java.awt.Color(255, 255, 255));
        toggleOff.setSelected(true);
        toggleOff.setText("OFF");
        toggleOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toggleOffMouseClicked(evt);
            }
        });
        jPanel4.add(toggleOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 70, -1));

        toggleOn.setBackground(new java.awt.Color(51, 51, 51));
        tableContentsToggle.add(toggleOn);
        toggleOn.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        toggleOn.setForeground(new java.awt.Color(255, 255, 255));
        toggleOn.setText("ON");
        toggleOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toggleOnMouseClicked(evt);
            }
        });
        jPanel4.add(toggleOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Show All Patient Details");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 3, -1, 30));

        jPanel10.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 350, 40));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 840, -1));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel3.setForeground(new java.awt.Color(245, 245, 245));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clearAll.setBackground(new java.awt.Color(0, 152, 216));
        clearAll.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        clearAll.setForeground(new java.awt.Color(255, 255, 255));
        clearAll.setText("Clear All");
        clearAll.setBorder(null);
        clearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllActionPerformed(evt);
            }
        });
        jPanel12.add(clearAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 80, 40));

        updatePatient.setBackground(new java.awt.Color(0, 152, 216));
        updatePatient.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        updatePatient.setForeground(new java.awt.Color(255, 255, 255));
        updatePatient.setText("Update");
        updatePatient.setBorder(null);
        updatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePatientActionPerformed(evt);
            }
        });
        jPanel12.add(updatePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jPanel8.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 40));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, -1));

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setBorder(null);

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "In Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI Light", 0, 12))); // NOI18N
        jPanel9.setAutoscrolls(true);
        jPanel9.setMinimumSize(new java.awt.Dimension(387, 713));
        jPanel9.setPreferredSize(new java.awt.Dimension(387, 713));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(245, 245, 245));
        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Examined Doctors");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 130, 30));

        jLabel5.setBackground(new java.awt.Color(245, 245, 245));
        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Patient ID");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 80, 30));

        jLabel6.setBackground(new java.awt.Color(245, 245, 245));
        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Recommendation");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 120, 30));

        jLabel7.setBackground(new java.awt.Color(245, 245, 245));
        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirmation");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 90, 30));

        jLabel8.setBackground(new java.awt.Color(245, 245, 245));
        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Consultant");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 90, 30));

        jLabel9.setBackground(new java.awt.Color(245, 245, 245));
        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Admit Date");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 90, 30));

        jLabel10.setBackground(new java.awt.Color(245, 245, 245));
        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Discharged Date");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 110, 30));

        jLabel12.setBackground(new java.awt.Color(245, 245, 245));
        jLabel12.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Patient Name");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 90, 30));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 190, 10));

        patient_id.setEditable(false);
        patient_id.setBackground(new java.awt.Color(51, 51, 51));
        patient_id.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        patient_id.setForeground(new java.awt.Color(255, 255, 255));
        patient_id.setBorder(null);
        jPanel9.add(patient_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 190, 30));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 190, 10));

        patientName.setBackground(new java.awt.Color(51, 51, 51));
        patientName.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        patientName.setForeground(new java.awt.Color(255, 255, 255));
        patientName.setBorder(null);
        jPanel9.add(patientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 190, 30));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 190, 10));

        recommendation.setBackground(new java.awt.Color(51, 51, 51));
        recommendation.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        recommendation.setForeground(new java.awt.Color(255, 255, 255));
        recommendation.setBorder(null);
        jPanel9.add(recommendation, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 190, 30));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 190, 10));

        admitDate.setEditable(false);
        admitDate.setBackground(new java.awt.Color(51, 51, 51));
        admitDate.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        admitDate.setForeground(new java.awt.Color(255, 255, 255));
        admitDate.setBorder(null);
        jPanel9.add(admitDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 190, 30));

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, 190, 10));

        dischargedDate.setEditable(false);
        dischargedDate.setBackground(new java.awt.Color(51, 51, 51));
        dischargedDate.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        dischargedDate.setForeground(new java.awt.Color(255, 255, 255));
        dischargedDate.setBorder(null);
        jPanel9.add(dischargedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 580, 190, 30));

        examinedDoctorsButton.setBackground(new java.awt.Color(0, 152, 216));
        examinedDoctorsButton.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        examinedDoctorsButton.setForeground(new java.awt.Color(255, 255, 255));
        examinedDoctorsButton.setText("Click to View");
        examinedDoctorsButton.setBorder(null);
        examinedDoctorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinedDoctorsButtonActionPerformed(evt);
            }
        });
        jPanel9.add(examinedDoctorsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, 100, 30));

        jLabel13.setBackground(new java.awt.Color(245, 245, 245));
        jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Patient Name");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 90, 30));

        jLabel14.setBackground(new java.awt.Color(245, 245, 245));
        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Gender");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 90, 30));

        jLabel15.setBackground(new java.awt.Color(245, 245, 245));
        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Address Line 1");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 90, 30));

        addressLine1.setBackground(new java.awt.Color(51, 51, 51));
        addressLine1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        addressLine1.setForeground(new java.awt.Color(255, 255, 255));
        addressLine1.setBorder(null);
        jPanel9.add(addressLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 190, 30));

        jSeparator12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 190, 10));

        jLabel16.setBackground(new java.awt.Color(245, 245, 245));
        jLabel16.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Address Line 2");
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 100, 30));

        addressLine2.setBackground(new java.awt.Color(51, 51, 51));
        addressLine2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        addressLine2.setForeground(new java.awt.Color(255, 255, 255));
        addressLine2.setBorder(null);
        jPanel9.add(addressLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 190, 30));

        jSeparator13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 190, 10));

        jLabel17.setBackground(new java.awt.Color(245, 245, 245));
        jLabel17.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("City");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 100, 30));

        city.setBackground(new java.awt.Color(51, 51, 51));
        city.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        city.setForeground(new java.awt.Color(255, 255, 255));
        city.setBorder(null);
        jPanel9.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 190, 30));

        jSeparator14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 190, 10));

        jLabel18.setBackground(new java.awt.Color(245, 245, 245));
        jLabel18.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("NIC");
        jPanel9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 90, 30));

        nicNo.setBackground(new java.awt.Color(51, 51, 51));
        nicNo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        nicNo.setForeground(new java.awt.Color(255, 255, 255));
        nicNo.setBorder(null);
        jPanel9.add(nicNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 190, 30));

        jSeparator15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 190, 10));

        jLabel19.setBackground(new java.awt.Color(245, 245, 245));
        jLabel19.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Ward Number");
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 90, 30));

        jSeparator16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 190, 10));

        sickness.setEditable(false);
        sickness.setBackground(new java.awt.Color(51, 51, 51));
        sickness.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        sickness.setForeground(new java.awt.Color(255, 255, 255));
        sickness.setBorder(null);
        jPanel9.add(sickness, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 190, 30));

        jLabel21.setBackground(new java.awt.Color(245, 245, 245));
        jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Sickess");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 90, 30));

        jSeparator18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 190, 10));

        jLabel20.setBackground(new java.awt.Color(245, 245, 245));
        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Contact Number");
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 110, 30));

        contactNumber.setBackground(new java.awt.Color(51, 51, 51));
        contactNumber.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        contactNumber.setForeground(new java.awt.Color(255, 255, 255));
        contactNumber.setBorder(null);
        jPanel9.add(contactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 190, 30));

        jSeparator19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 190, 10));

        jSeparator20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 190, 10));

        wardNumberCombo.setBackground(new java.awt.Color(51, 51, 51));
        wardNumberCombo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        wardNumberCombo.setForeground(new java.awt.Color(255, 255, 255));
        wardNumberCombo.setBorder(null);
        jPanel9.add(wardNumberCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 70, 30));

        confirmationCombo.setBackground(new java.awt.Color(51, 51, 51));
        confirmationCombo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        confirmationCombo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.add(confirmationCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 190, 30));

        consultantCombo.setBackground(new java.awt.Color(51, 51, 51));
        consultantCombo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        consultantCombo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.add(consultantCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 190, 30));

        patientMale.setBackground(new java.awt.Color(51, 51, 51));
        patientGenderGroup.add(patientMale);
        patientMale.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        patientMale.setForeground(new java.awt.Color(255, 255, 255));
        patientMale.setText("Male");
        jPanel9.add(patientMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        patientFemale.setBackground(new java.awt.Color(51, 51, 51));
        patientGenderGroup.add(patientFemale);
        patientFemale.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        patientFemale.setForeground(new java.awt.Color(255, 255, 255));
        patientFemale.setText("Female");
        jPanel9.add(patientFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        jScrollPane2.setViewportView(jPanel9);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 410, 490));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 420, 580));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1260, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admitPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admitPatientButtonActionPerformed
        AddPatient newPatient = new AddPatient();
        newPatient.getIndex();
        newPatient.setVisible(true);
    }//GEN-LAST:event_admitPatientButtonActionPerformed

    private void patientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientTableMouseClicked

        
        //get the patient id of the selected row
        DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
        int row = patientTable.getSelectedRow();
        String id = (String) model.getValueAt(row, 0);

        // get the details of the selected patient from the db
        try {

            String query = "select * from patient where patient_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String add1 = rs.getString("patient_id");
                String add2 = rs.getString("name");
                String add3 = rs.getString("gender");
                String add4 = rs.getString("nic");
                String add5 = rs.getString("address_line_1");
                String add6 = rs.getString("address_line_2");
                String add7 = rs.getString("city");
                String add8 = rs.getString("admit_date");
                String add9 = rs.getString("sickness");
                String add10 = rs.getString("ward");
                int add11 = rs.getInt("confirmation");
                int add12 = rs.getInt("consultant");
                String add13 = rs.getString("recommendation");
                String add14 = rs.getString("discharge_date");
                String add15 = rs.getString("contact_number");

                // get the name of the confimation doctor
                ResultSet rss;
                PreparedStatement pss = con.prepareStatement("select name from employee where employee_id = ?");
                pss.setInt(1, add11);
                rss = pss.executeQuery();

                while (rss.next()) {
                    String name = rss.getString("name");

                    confirmationCombo.setSelectedItem(name);
                }

                // get the name of the consultant doctor
                ResultSet rst;
                PreparedStatement pst = con.prepareStatement("select name from employee where employee_id = ?");
                pst.setInt(1, add12);
                rst = pst.executeQuery();

                while (rst.next()) {
                    String name = rst.getString("name");

                    consultantCombo.setSelectedItem(name);
                }

                //fill the text fields
                patient_id.setText(add1);
                patientName.setText(add2);
                if (add3.equals("male")) {
                    patientMale.setSelected(true);
                } else {
                    patientFemale.setSelected(true);
                }
                nicNo.setText(add4);
                addressLine1.setText(add5);
                addressLine2.setText(add6);
                city.setText(add7);
                wardNumberCombo.setSelectedItem(add10);
                sickness.setText(add9);
                admitDate.setText(add8);
                recommendation.setText(add13);
                dischargedDate.setText(add14);
                contactNumber.setText(add15);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Date View Failed");
        }
    }//GEN-LAST:event_patientTableMouseClicked

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased

        DefaultTableModel model = (DefaultTableModel) patientTable.getModel();

        // fill the table with all the patient details if the search fiels is empty
        if (searchText.getText().equals("")) {

            model.setRowCount(0);
            fillTable();

        }

        // fill the table with given nic if available
        try {
            
            model.setRowCount(0);
            String query = "select * from patient where nic LIKE ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, searchText.getText()+"%");
            rs = pst.executeQuery();

            while (rs.next()) {

                String add1 = rs.getString("patient_id");
                String add2 = rs.getString("nic");
                String add3 = rs.getString("name");
                String add4 = rs.getString("gender");
                String add5 = rs.getString("ward");
                String add6 = rs.getString("consultant");
                String add7 = rs.getString("admit_date");
                String add8 = rs.getString("discharge_date");

                
                model.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7, add8});
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid NIC Value");
        }
    }//GEN-LAST:event_searchTextKeyReleased

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        Login login = new Login();
        login.closeListener();
        login.currentDateTime();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void examinedDoctorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinedDoctorsButtonActionPerformed
        ExaminedDoctors examinedDoctors = new ExaminedDoctors(Integer.parseInt(nicNo.getText()), patientName.getText());
        examinedDoctors.createConnectoin();
        examinedDoctors.addData();
        examinedDoctors.setVisible(true);
    }//GEN-LAST:event_examinedDoctorsButtonActionPerformed

    private void clearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllActionPerformed

        //clears all required fields and combo boxes
        patientName.setText("");
        nicNo.setText("");
        addressLine1.setText("");
        addressLine2.setText("");
        city.setText("");
        contactNumber.setText("");
        wardNumberCombo.setSelectedIndex(-1);
        recommendation.setText("");

    }//GEN-LAST:event_clearAllActionPerformed

    private void updatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePatientActionPerformed
        // check for empty fields
        if (this.patientName.getText().equals("") || this.nicNo.getText().equals("") || this.contactNumber.getText().equals("") || this.recommendation.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You should fill the empty spaces");
        } else {
            //get all the data and update the database
            int patientId = Integer.parseInt(patient_id.getText());
            String name = this.patientName.getText();
            String gender = this.patientGenderGroup.getElements().nextElement().getText();
            int nic = Integer.parseInt(this.nicNo.getText());
            String address1 = this.addressLine1.getText();
            String address2 = this.addressLine2.getText();
            String city = this.city.getText();
            int contact = Integer.parseInt(this.contactNumber.getText());
            int ward = Integer.parseInt(wardNumberCombo.getSelectedItem().toString());
            String recommend = recommendation.getText();
            String consult = consultantCombo.getSelectedItem().toString();
            String confirm = confirmationCombo.getSelectedItem().toString();

            UpdatePatientConnect update = new UpdatePatientConnect(name, gender, nic, address1, address2, city, contact, ward, recommend, confirm, consult, patientId);
            update.update();
        }


    }//GEN-LAST:event_updatePatientActionPerformed

    private void PayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayButtonActionPerformed
        MakePayment makePayment = new MakePayment();
        makePayment.createConnectoin();
        makePayment.setVisible(true);
    }//GEN-LAST:event_PayButtonActionPerformed

    private void attendenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendenceButtonActionPerformed
        Attendance attendance = new Attendance();
        attendance.createConnectoin();
        attendance.currentDateTime();
        attendance.setVisible(true);
    }//GEN-LAST:event_attendenceButtonActionPerformed

    private void toggleOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toggleOffMouseClicked
        fillTable();
    }//GEN-LAST:event_toggleOffMouseClicked

    private void toggleOnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toggleOnMouseClicked
        fillTable();
    }//GEN-LAST:event_toggleOnMouseClicked

    private void searchTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextMouseClicked
        searchText.setText("");
    }//GEN-LAST:event_searchTextMouseClicked

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
            java.util.logging.Logger.getLogger(NormalUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NormalUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NormalUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NormalUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NormalUserView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PayButton;
    private javax.swing.JTextField addressLine1;
    private javax.swing.JTextField addressLine2;
    private javax.swing.JTextField admitDate;
    private javax.swing.JButton admitPatientButton;
    private javax.swing.JButton attendenceButton;
    private javax.swing.JTextField city;
    private javax.swing.JButton clearAll;
    private javax.swing.JComboBox<String> confirmationCombo;
    private javax.swing.JComboBox<String> consultantCombo;
    private javax.swing.JTextField contactNumber;
    private javax.swing.JTextField dischargedDate;
    private javax.swing.JButton examinedDoctorsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton loggedUser;
    private javax.swing.JTextField nicNo;
    private javax.swing.JRadioButton patientFemale;
    private javax.swing.ButtonGroup patientGenderGroup;
    private javax.swing.JRadioButton patientMale;
    private javax.swing.JTextField patientName;
    private javax.swing.JTable patientTable;
    private javax.swing.JTextField patient_id;
    private javax.swing.JTextField recommendation;
    private javax.swing.JTextField searchText;
    private javax.swing.JTextField sickness;
    private javax.swing.ButtonGroup tableContentsToggle;
    private javax.swing.JToggleButton toggleOff;
    private javax.swing.JToggleButton toggleOn;
    private javax.swing.JButton updatePatient;
    private javax.swing.JComboBox<String> wardNumberCombo;
    // End of variables declaration//GEN-END:variables
}
