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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashan
 */
public class EmployeeList extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeList
     */
    //delcaring global variables
    private Connection con;
    
    public EmployeeList() {
        initComponents();        
    }
    
    // creating the connection
    public void createConnectoin() {
        DBConnect db = new DBConnect();
        this.con = db.createConnection();
    }

    //fill each table with data separately
    public void fillTable() {
        try {
            //fill doctors
            DefaultTableModel modelDoctor = (DefaultTableModel) employeeDoctorList.getModel();
            modelDoctor.setRowCount(0);

            PreparedStatement pss = con.prepareStatement("select * from employee where type = 'Doctor'");
            ResultSet resultSet;
            resultSet = pss.executeQuery();
            
            while (resultSet.next()) {
                String add1 = resultSet.getString("employee_id");
                String add2 = resultSet.getString("name");
                String add3 = resultSet.getString("gender");
                String add4 = resultSet.getString("address_line_1");
                String add5 = resultSet.getString("address_line_2");
                String add6 = resultSet.getString("city");
                String add7 = resultSet.getString("specialization");
                String add8 = resultSet.getString("mobile");
                String add9 = resultSet.getString("dateOfJob");
                String add10 = resultSet.getString("privilege");

                
                modelDoctor.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7, add8,add9 , add10});

            }

            //fill nurses
            DefaultTableModel modelNurse = (DefaultTableModel) employeeNurseList.getModel();
            modelNurse.setRowCount(0);
            PreparedStatement ps = con.prepareStatement("select * from employee where type = 'Nurse'");
            ResultSet rs;
            rs = ps.executeQuery();
            
            while (rs.next()) {
                String add1 = rs.getString("employee_id");
                String add2 = rs.getString("name");
                String add3 = rs.getString("gender");
                String add4 = rs.getString("address_line_1");
                String add5 = rs.getString("address_line_2");
                String add6 = rs.getString("city");
                String add7 = rs.getString("mobile");
                String add8 = rs.getString("dateOfJob");
                String add9 = rs.getString("privilege");

                
                modelNurse.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7, add8,add9});

            }
            
            //fill maintenance staff
            DefaultTableModel modelMaintenance = (DefaultTableModel) employeeMaintenanceList.getModel();
            modelMaintenance.setRowCount(0);
            PreparedStatement pst = con.prepareStatement("select * from employee where type = 'Maintenance'");
            ResultSet rst;
            rst = pst.executeQuery();
            
            while (rst.next()) {
                String add1 = rst.getString("employee_id");
                String add2 = rst.getString("name");
                String add3 = rst.getString("gender");
                String add4 = rst.getString("address_line_1");
                String add5 = rst.getString("address_line_2");
                String add6 = rst.getString("city");
                String add7 = rst.getString("mobile");
                String add8 = rst.getString("dateOfJob");
                String add9 = rst.getString("privilege");

               
                modelMaintenance.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7, add8,add9});

            }
            
            //fill receptions
            DefaultTableModel modelReception = (DefaultTableModel) employeeReceptionList.getModel();
            modelReception.setRowCount(0);
            PreparedStatement psp = con.prepareStatement("select * from employee where type = 'Reception'");
            ResultSet rsp;
            rsp = psp.executeQuery();
            
            while (rsp.next()) {
                String add1 = rsp.getString("employee_id");
                String add2 = rsp.getString("name");
                String add3 = rsp.getString("gender");
                String add4 = rsp.getString("address_line_1");
                String add5 = rsp.getString("address_line_2");
                String add6 = rsp.getString("city");
                String add7 = rsp.getString("mobile");
                String add8 = rsp.getString("dateOfJob");
                String add9 = rsp.getString("privilege");

                modelReception.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7, add8,add9});

            }
            
        } catch (Exception ex) {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeDoctorList = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        serachTextDoctor = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        employeeNurseList = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchTextNurse = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchTextMaintenance = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        employeeMaintenanceList = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        searchTextReception = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        employeeReceptionList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeDoctorList.setBackground(new java.awt.Color(51, 51, 51));
        employeeDoctorList.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        employeeDoctorList.setForeground(new java.awt.Color(255, 255, 255));
        employeeDoctorList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "Gender", "Address Line 1", "Address Line 2", "City", "Specilization", "mobile", "Employment Date", "Privilege"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeDoctorList.setRowHeight(50);
        employeeDoctorList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        employeeDoctorList.setShowHorizontalLines(false);
        employeeDoctorList.setShowVerticalLines(false);
        jScrollPane1.setViewportView(employeeDoctorList);
        if (employeeDoctorList.getColumnModel().getColumnCount() > 0) {
            employeeDoctorList.getColumnModel().getColumn(0).setResizable(false);
            employeeDoctorList.getColumnModel().getColumn(1).setResizable(false);
            employeeDoctorList.getColumnModel().getColumn(2).setResizable(false);
            employeeDoctorList.getColumnModel().getColumn(3).setResizable(false);
            employeeDoctorList.getColumnModel().getColumn(4).setResizable(false);
            employeeDoctorList.getColumnModel().getColumn(5).setResizable(false);
            employeeDoctorList.getColumnModel().getColumn(6).setResizable(false);
            employeeDoctorList.getColumnModel().getColumn(7).setResizable(false);
            employeeDoctorList.getColumnModel().getColumn(8).setResizable(false);
            employeeDoctorList.getColumnModel().getColumn(9).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 550));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searched.png"))); // NOI18N
        jPanel12.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 48));

        serachTextDoctor.setBackground(new java.awt.Color(51, 51, 51));
        serachTextDoctor.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        serachTextDoctor.setForeground(new java.awt.Color(255, 255, 255));
        serachTextDoctor.setText("Search");
        serachTextDoctor.setBorder(null);
        serachTextDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serachTextDoctorKeyReleased(evt);
            }
        });
        jPanel12.add(serachTextDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 310, 30));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel12.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 310, 10));

        jPanel7.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 80));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1280, 80));

        jTabbedPane1.addTab("Doctor", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeNurseList.setBackground(new java.awt.Color(51, 51, 51));
        employeeNurseList.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        employeeNurseList.setForeground(new java.awt.Color(255, 255, 255));
        employeeNurseList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "Gender", "Address Line 1", "Address Line 2", "City", "Mobile", "Employment Date", "Privilege"
            }
        ));
        employeeNurseList.setGridColor(new java.awt.Color(51, 51, 51));
        employeeNurseList.setRowHeight(50);
        employeeNurseList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        employeeNurseList.setShowHorizontalLines(false);
        employeeNurseList.setShowVerticalLines(false);
        jScrollPane4.setViewportView(employeeNurseList);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 550));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searched.png"))); // NOI18N
        jPanel11.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 48));

        searchTextNurse.setBackground(new java.awt.Color(51, 51, 51));
        searchTextNurse.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        searchTextNurse.setForeground(new java.awt.Color(255, 255, 255));
        searchTextNurse.setText("Search");
        searchTextNurse.setBorder(null);
        searchTextNurse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextNurseKeyReleased(evt);
            }
        });
        jPanel11.add(searchTextNurse, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 310, 30));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 310, 10));

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 80));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1280, 80));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Nurse", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searched.png"))); // NOI18N
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 48));

        searchTextMaintenance.setBackground(new java.awt.Color(51, 51, 51));
        searchTextMaintenance.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        searchTextMaintenance.setForeground(new java.awt.Color(255, 255, 255));
        searchTextMaintenance.setText("Search");
        searchTextMaintenance.setBorder(null);
        searchTextMaintenance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextMaintenanceKeyReleased(evt);
            }
        });
        jPanel10.add(searchTextMaintenance, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 310, 30));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 310, 10));

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 80));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1280, 80));

        employeeMaintenanceList.setBackground(new java.awt.Color(51, 51, 51));
        employeeMaintenanceList.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        employeeMaintenanceList.setForeground(new java.awt.Color(255, 255, 255));
        employeeMaintenanceList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "Gender", "Address Line 1", "Address Line 2", "City", "Mobile", "Employment Date", "priviledge"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeMaintenanceList.setGridColor(new java.awt.Color(51, 51, 51));
        employeeMaintenanceList.setRowHeight(50);
        employeeMaintenanceList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        employeeMaintenanceList.setShowHorizontalLines(false);
        employeeMaintenanceList.setShowVerticalLines(false);
        jScrollPane5.setViewportView(employeeMaintenanceList);
        if (employeeMaintenanceList.getColumnModel().getColumnCount() > 0) {
            employeeMaintenanceList.getColumnModel().getColumn(0).setResizable(false);
            employeeMaintenanceList.getColumnModel().getColumn(1).setResizable(false);
            employeeMaintenanceList.getColumnModel().getColumn(2).setResizable(false);
            employeeMaintenanceList.getColumnModel().getColumn(3).setResizable(false);
            employeeMaintenanceList.getColumnModel().getColumn(4).setResizable(false);
            employeeMaintenanceList.getColumnModel().getColumn(5).setResizable(false);
            employeeMaintenanceList.getColumnModel().getColumn(6).setResizable(false);
            employeeMaintenanceList.getColumnModel().getColumn(7).setResizable(false);
            employeeMaintenanceList.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 550));

        jTabbedPane1.addTab("Maintenance", jPanel3);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searched.png"))); // NOI18N
        jPanel14.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 48));

        searchTextReception.setBackground(new java.awt.Color(51, 51, 51));
        searchTextReception.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 18)); // NOI18N
        searchTextReception.setForeground(new java.awt.Color(255, 255, 255));
        searchTextReception.setText("Search");
        searchTextReception.setBorder(null);
        searchTextReception.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextReceptionKeyReleased(evt);
            }
        });
        jPanel14.add(searchTextReception, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 310, 30));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 310, 10));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 80));

        jPanel8.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1280, 80));

        employeeReceptionList.setBackground(new java.awt.Color(51, 51, 51));
        employeeReceptionList.setFont(new java.awt.Font("Quicksand", 0, 14)); // NOI18N
        employeeReceptionList.setForeground(new java.awt.Color(255, 255, 255));
        employeeReceptionList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "Gender", "Address Line 1", "Address Line 2", "City", "Mobile", "Employment Date", "priviledge"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeReceptionList.setGridColor(new java.awt.Color(51, 51, 51));
        employeeReceptionList.setRowHeight(50);
        employeeReceptionList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        employeeReceptionList.setShowHorizontalLines(false);
        employeeReceptionList.setShowVerticalLines(false);
        jScrollPane6.setViewportView(employeeReceptionList);
        if (employeeReceptionList.getColumnModel().getColumnCount() > 0) {
            employeeReceptionList.getColumnModel().getColumn(0).setResizable(false);
            employeeReceptionList.getColumnModel().getColumn(1).setResizable(false);
            employeeReceptionList.getColumnModel().getColumn(2).setResizable(false);
            employeeReceptionList.getColumnModel().getColumn(3).setResizable(false);
            employeeReceptionList.getColumnModel().getColumn(4).setResizable(false);
            employeeReceptionList.getColumnModel().getColumn(5).setResizable(false);
            employeeReceptionList.getColumnModel().getColumn(6).setResizable(false);
            employeeReceptionList.getColumnModel().getColumn(7).setResizable(false);
            employeeReceptionList.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel8.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 550));

        jTabbedPane1.addTab("Reception", jPanel8);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextReceptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextReceptionKeyReleased
        // searching a reception using the id
        DefaultTableModel model = (DefaultTableModel) employeeReceptionList.getModel();

        // fill the table with all recptions if the textfield is empty
        if (searchTextReception.getText().equals("")) {

            model.setRowCount(0);
            fillTable();

        }

        //filling the table with matching id
        try {
            String query = "select * from employee where employee_id = ? and type = 'Reception'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, searchTextReception.getText());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String add1 = rs.getString("employee_id");
                String add2 = rs.getString("name");
                String add3 = rs.getString("gender");
                String add4 = rs.getString("address_line_1");
                String add5 = rs.getString("address_line_2");
                String add6 = rs.getString("city");
                String add7 = rs.getString("specialization");
                String add8 = rs.getString("mobile");
                String add9 = rs.getString("dateOfJob");
                String add10 = rs.getString("privilege");

                model.setRowCount(0);
                model.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7, add8,add9,add10});
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    
    }//GEN-LAST:event_searchTextReceptionKeyReleased

    private void serachTextDoctorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serachTextDoctorKeyReleased
        // searching a doctor using the id
        DefaultTableModel model = (DefaultTableModel) employeeDoctorList.getModel();

        // fill the table with all recptions if the textfield is empty
        if (serachTextDoctor.getText().equals("")) {

            model.setRowCount(0);
            fillTable();

        }

         //filling the table with matching id
        try {
            String query = "select * from employee where employee_id = ? and type = 'Doctor'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, serachTextDoctor.getText());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String add1 = rs.getString("employee_id");
                String add2 = rs.getString("name");
                String add3 = rs.getString("gender");
                String add4 = rs.getString("address_line_1");
                String add5 = rs.getString("address_line_2");
                String add6 = rs.getString("city");
                String add7 = rs.getString("specialization");
                String add8 = rs.getString("mobile");
                String add9 = rs.getString("dateOfJob");
                String add10 = rs.getString("privilege");

                model.setRowCount(0);
                model.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7, add8,add9,add10});
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_serachTextDoctorKeyReleased

    private void searchTextNurseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextNurseKeyReleased
        // searching a nurse using the id
        DefaultTableModel model = (DefaultTableModel) employeeNurseList.getModel();

        // fill the table with all recptions if the textfield is empty
        if (searchTextNurse.getText().equals("")) {
            model.setRowCount(0);
            fillTable();
        }

         //filling the table with matching id
        try {
            String query = "select * from employee where employee_id = ? and type = 'Nurse'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, searchTextNurse.getText());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String add1 = rs.getString("employee_id");
                String add2 = rs.getString("name");
                String add3 = rs.getString("gender");
                String add4 = rs.getString("address_line_1");
                String add5 = rs.getString("address_line_2");
                String add6 = rs.getString("city");
                String add7 = rs.getString("specialization");
                String add8 = rs.getString("mobile");
                String add9 = rs.getString("dateOfJob");
                String add10 = rs.getString("privilege");

                model.setRowCount(0);
                model.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7, add8,add9,add10});
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_searchTextNurseKeyReleased

    private void searchTextMaintenanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextMaintenanceKeyReleased
        // searching a maintenance using the id
        DefaultTableModel model = (DefaultTableModel) employeeMaintenanceList.getModel();

        // fill the table with all recptions if the textfield is empty
        if (searchTextMaintenance.getText().equals("")) {

            model.setRowCount(0);
            fillTable();

        }

        //filling the table with matching id
        try {
            String query = "select * from employee where employee_id = ? and type = 'Maintenance'";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, searchTextMaintenance.getText());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String add1 = rs.getString("employee_id");
                String add2 = rs.getString("name");
                String add3 = rs.getString("gender");
                String add4 = rs.getString("address_line_1");
                String add5 = rs.getString("address_line_2");
                String add6 = rs.getString("city");
                String add7 = rs.getString("specialization");
                String add8 = rs.getString("mobile");
                String add9 = rs.getString("dateOfJob");
                String add10 = rs.getString("privilege");

                model.setRowCount(0);
                model.addRow(new Object[]{add1, add2, add3, add4, add5, add6, add7, add8,add9,add10});
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_searchTextMaintenanceKeyReleased

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
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable employeeDoctorList;
    private javax.swing.JTable employeeMaintenanceList;
    private javax.swing.JTable employeeNurseList;
    private javax.swing.JTable employeeReceptionList;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField searchTextMaintenance;
    private javax.swing.JTextField searchTextNurse;
    private javax.swing.JTextField searchTextReception;
    private javax.swing.JTextField serachTextDoctor;
    // End of variables declaration//GEN-END:variables
}
