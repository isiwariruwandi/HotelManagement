/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cw.hotelmanagementcw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USER
 */
public class Reservation extends javax.swing.JFrame 
{

    /**
     * Creates new form Reservation
     */
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    
    
    public Reservation()
    {
        initComponents();
        conn = HotelManagementCW.conn();//add connection
        autoID();
        RoomTypeL();
        RoomNo();
        BedType();
        Load_reservation();
        truncateSuborderTable();
    }
    
    
    
       public void autoID() //ID auto increment
       {
    try 
    {
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT MAX(reid) FROM reservation");
        
        if (rs.next()) 
        {
            String maxReid = rs.getString("MAX(reid)");
            
            if (maxReid == null)
            {
                jLabel12.setText("RE001");
            } else {
                long id = Long.parseLong(maxReid.substring(2)); 
                id++;
                jLabel12.setText("RE" + String.format("%03d", id)); 
            }
        }
        
        rs.close();
        s.close();
    } 
    catch (SQLException e) 
    {
        JOptionPane.showMessageDialog(null, e);
    }
  
}
       
       public void RoomTypeL()//get roomtype from room database
       {
           
        try 
        {
            pst = conn.prepareStatement("select Distinct rtype from room");
            ResultSet rs = pst.executeQuery();
            jComboBox2.removeAllItems();
            
            while(rs.next())
            {
                jComboBox2.addItem(rs.getString("rtype"));
            }
            
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
       public void Load_reservation()//load data to table
   {
       
        try
        {
            String sqlquer = ("SELECT reid,name,address,mobile,checkin,checkout,rtype,roomno,bedtype,amount FROM reservation");
            pst = conn.prepareStatement(sqlquer);
            rs = pst.executeQuery();
            
            
            DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
            tblModel.setRowCount(0);
            
            while(rs.next())
            {
                
              String reid = rs.getString("reid");
              String name = rs.getString("name");
              String address = rs.getString("address");
              String mobile = rs.getString("mobile");
              String checkin = rs.getString("checkin");
              String checkout = rs.getString("checkout");
              String rtype = rs.getString("rtype");
              String roomno = rs.getString("roomno");
              String bedtype = rs.getString("bedtype");
              String amount = rs.getString("amount");
              
              String tblData[]= {reid,name,address,mobile,checkin,checkout,rtype,roomno,bedtype,amount};
              tblModel.addRow(tblData);
              
            }  
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

       
       
       public void RoomNo()// get roomno from room database
       {
           
        try 
        {
            pst = conn.prepareStatement("select Distinct rid from room");
            ResultSet rs = pst.executeQuery();
            jComboBox1.removeAllItems();
            
            while(rs.next())
            {
                jComboBox1.addItem(rs.getString("rid"));
            }
            
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
       public void BedType()//get bedtype from room database
       {
           
        try 
        {
            pst = conn.prepareStatement("select Distinct btype from room");
            ResultSet rs = pst.executeQuery();
            jComboBox3.removeAllItems();
            
            while(rs.next())
            {
                jComboBox3.addItem(rs.getString("btype"));
            }
            
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Reservation");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Reservation No");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Address");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mobile");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Check In");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Check Out");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Room Type");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Room No");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Amount");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Bed Type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RID", "Name", "Address", "Mobile", "CheckIn", "CheckOut", "RoomType", "RoomNo", "BedType", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("jLabel12");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox2, 0, 146, Short.MAX_VALUE)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(461, 461, 461))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Invoice");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jButton3)
                .addGap(55, 55, 55)
                .addComponent(jButton2)
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addGap(48, 48, 48)
                .addComponent(jButton4)
                .addGap(47, 47, 47)
                .addComponent(jButton5)
                .addGap(44, 44, 44)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //save records to reservation and suborder tables 
        
    String reno = jLabel12.getText();
    String name = jTextField3.getText();
    String address = jTextField2.getText();
    String mobile = jTextField1.getText();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    String startDate = df.format(jDateChooser2.getDate());
    String endDate = df.format(jDateChooser1.getDate());
    String rtype = jComboBox2.getSelectedItem().toString();
    String roomNo = jComboBox1.getSelectedItem().toString();
    String bedType = jComboBox3.getSelectedItem().toString();
    String amount = jTextField4.getText();
    
    PreparedStatement pstReservation = null;
    PreparedStatement pstSuborder = null;

    try 
    {
        // Insert data into reservation table
        pstReservation = conn.prepareStatement("INSERT INTO reservation (reid, name, address, mobile, checkin, checkout, bedtype, roomno, rtype, amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pstReservation.setString(1, reno);
        pstReservation.setString(2, name);
        pstReservation.setString(3, address);
        pstReservation.setString(4, mobile);
        pstReservation.setString(5, startDate);
        pstReservation.setString(6, endDate);
        pstReservation.setString(7, bedType);
        pstReservation.setString(8, roomNo);
        pstReservation.setString(9, rtype);
        pstReservation.setString(10, amount);
        pstReservation.executeUpdate();
        
        // Insert data into suborder table
        pstSuborder = conn.prepareStatement("INSERT INTO suborder (reid, name, address, mobile, checkin, checkout, bedtype, roomno, rtype, amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pstSuborder.setString(1, reno);
        pstSuborder.setString(2, name);
        pstSuborder.setString(3, address);
        pstSuborder.setString(4, mobile);
        pstSuborder.setString(5, startDate);
        pstSuborder.setString(6, endDate);
        pstSuborder.setString(7, bedType);
        pstSuborder.setString(8, roomNo);
        pstSuborder.setString(9, rtype);
        pstSuborder.setString(10, amount);
        pstSuborder.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Reservation Added!");

        // Reset fields and reload reservation list
        jTextField3.setText("");
        jTextField2.setText("");
        jTextField1.setText("");
        jComboBox2.setSelectedIndex(-1);
        jComboBox1.setSelectedIndex(-1);
        jComboBox3.setSelectedIndex(-1);
        jTextField4.setText("");
        autoID();
        Load_reservation();

    }
    catch (SQLException ex) 
    {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
    } 
    finally
    {
        // Close the prepared statements if they were used
        try
        {
            if (pstReservation != null) pstReservation.close();
            if (pstSuborder != null) pstSuborder.close();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // allow uodate
        String reno = jLabel12.getText();
        String name = jTextField3.getText();
        String address = jTextField2.getText();
        String mobile = jTextField1.getText();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-mm-dd");
        String StartDate = df1.format(jDateChooser2.getDate());
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-mm-dd");
        String EndDate = df1.format(jDateChooser1.getDate());
        String rtype = jComboBox2.getSelectedItem().toString();
        String roomno = jComboBox1.getSelectedItem().toString();
        String bedtype = jComboBox3.getSelectedItem().toString();
        String amount = jTextField4.getText();
        
        try
        {
            pst = conn.prepareStatement("update reservation set name=?,address=?,mobile=?,checkin=?,checkout=?,bedtype=?,roomno=?,rtype=?,amount=? where reid=?");
            
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, mobile);
            pst.setString(4, StartDate);
            pst.setString(5, EndDate);
            pst.setString(6, bedtype);
            pst.setString(7, roomno);
            pst.setString(8, rtype);
            pst.setString(9, amount);
            pst.setString(10, reno);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Reservation Edited!");
            
            jTextField3.setText("");
            jTextField2.setText("");
            jTextField1.setText("");
            jComboBox2.setSelectedIndex(-1);
            jComboBox1.setSelectedIndex(-1);
            jComboBox3.setSelectedIndex(-1);
            jTextField4.setText("");
            autoID();
            Load_reservation();
            
            
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // delete records
        String reno = jLabel12.getText();
        
        
        try
        {
            pst = conn.prepareStatement("delete from reservation where reid=?");
            
           
            pst.setString(1, reno);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Reservation Deleted!");
            
            jTextField3.setText("");
            jTextField2.setText("");
            jTextField1.setText("");
            jDateChooser2.setDate(null);
            jDateChooser1.setDate(null);
            jComboBox2.setSelectedIndex(-1);
            jComboBox1.setSelectedIndex(-1);
            jComboBox3.setSelectedIndex(-1);
            jTextField4.setText("");
            autoID();
            Load_reservation();
            
            jPanel1.setEnabled(true);
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // clear records in textfields
        jTextField3.setText("");
        jTextField2.setText("");
        jTextField1.setText("");
        jDateChooser2.setDate(null);
        jDateChooser1.setDate(null);
        jComboBox2.setSelectedIndex(-1);
        jComboBox1.setSelectedIndex(-1);
        jComboBox3.setSelectedIndex(-1);
        jTextField4.setText("");
        autoID();
        Load_reservation();
            
        jPanel1.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       // load data to textfields when row clicked
    d = (DefaultTableModel) jTable1.getModel();
    int selectIndex = jTable1.getSelectedRow();
    
    jLabel12.setText(d.getValueAt(selectIndex, 0).toString());
    jTextField3.setText(d.getValueAt(selectIndex, 1).toString());
    jTextField2.setText(d.getValueAt(selectIndex, 2).toString());
    jTextField1.setText(d.getValueAt(selectIndex, 3).toString());
    try
    {
            Date checkInDate = new SimpleDateFormat("yyyy-MM-dd").parse(d.getValueAt(selectIndex, 4).toString());
            jDateChooser2.setDate(checkInDate);

            Date checkOutDate = new SimpleDateFormat("yyyy-MM-dd").parse(d.getValueAt(selectIndex, 5).toString());
            jDateChooser1.setDate(checkOutDate);
    } 
    catch (ParseException ex)
    {
            ex.printStackTrace();
    }
    jComboBox2.setSelectedItem(d.getValueAt(selectIndex, 6).toString());
    jComboBox1.setSelectedItem(d.getValueAt(selectIndex, 7).toString());
    jComboBox3.setSelectedItem(d.getValueAt(selectIndex, 8).toString());
    jTextField4.setText(d.getValueAt(selectIndex, 9).toString());
    
    jPanel1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // jasper connection
         try
        {
            String rp = "C:\\Users\\USER\\Documents\\NetBeansProjects\\HotelManagementCW\\src\\main\\java\\Reports\\Invoice.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(rp);
            JasperPrint jp = JasperFillManager.fillReport(jr,null,conn);
            JasperViewer.viewReport(jp);
            //conn.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // jasper connection
         try
        {
            String rp = "C:\\Users\\USER\\Documents\\NetBeansProjects\\HotelManagementCW\\src\\main\\java\\Reports\\Reservations.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(rp);
            JasperPrint jp = JasperFillManager.fillReport(jr,null,conn);
            JasperViewer.viewReport(jp);
            //conn.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        } 
    }//GEN-LAST:event_jButton6ActionPerformed

    
    
    private void truncateSuborderTable()//truncate previous records in suborder table
    {
    PreparedStatement pstTruncate = null;
    
    try
    {
        
        pstTruncate = conn.prepareStatement("TRUNCATE TABLE suborder");
        pstTruncate.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Suborder table truncated successfully!");
    } 
    catch (SQLException ex) 
    {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
    } 
    finally
    {
       
        try
        {
            if (pstTruncate != null) pstTruncate.close();
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    
    
        
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
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
