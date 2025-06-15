/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cw.hotelmanagementcw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author USER
 */
public class Login extends javax.swing.JFrame 
{

    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    public Login() 
    {
        initComponents();
        conn = HotelManagementCW.conn();//add connection
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        checkshow = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnlog = new javax.swing.JButton();
        btnsign = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textpassword = new javax.swing.JPasswordField();
        textuser = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));
        setMinimumSize(new java.awt.Dimension(100, 100));
        setResizable(false);
        setSize(new java.awt.Dimension(1009, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(560, 400));
        jPanel1.setLayout(null);

        checkshow.setBackground(new java.awt.Color(204, 204, 204));
        checkshow.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        checkshow.setText("Show Password");
        checkshow.setOpaque(true);
        checkshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkshowActionPerformed(evt);
            }
        });
        jPanel1.add(checkshow);
        checkshow.setBounds(180, 260, 100, 20);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("User Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 140, 74, 20);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 210, 64, 20);

        btnlog.setBackground(new java.awt.Color(0, 0, 0));
        btnlog.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnlog.setForeground(new java.awt.Color(255, 255, 255));
        btnlog.setText("Log In");
        btnlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogActionPerformed(evt);
            }
        });
        jPanel1.add(btnlog);
        btnlog.setBounds(180, 340, 72, 30);

        btnsign.setBackground(new java.awt.Color(0, 0, 0));
        btnsign.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsign.setForeground(new java.awt.Color(255, 255, 255));
        btnsign.setText("Sign Up");
        btnsign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignActionPerformed(evt);
            }
        });
        jPanel1.add(btnsign);
        btnsign.setBounds(330, 340, 90, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setText("Log In");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(240, 40, 130, 48);
        jPanel1.add(textpassword);
        textpassword.setBounds(180, 230, 230, 30);
        jPanel1.add(textuser);
        textuser.setBounds(180, 160, 230, 30);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(500, 450, 72, 23);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignActionPerformed
        // Visible next interface
        Signup signupFrame = new Signup();
        signupFrame.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnsignActionPerformed

    private void btnlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogActionPerformed
        // Validations
        String UserName= textuser.getText();
        String Createpassword= String.valueOf(textpassword.getPassword());
        
        if(textuser.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please fill out User Name!");
        }
        else if(textpassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please fill out Password!");
        }
        else
        {
                try
                {
                       pst = conn.prepareStatement("SELECT * FROM user WHERE UserName=? AND Createpassword = ?");
                       pst.setString(1, UserName);
                       pst.setString(2, Createpassword);
                       rs = pst.executeQuery();
                       if(rs.next())
                       {
                           JOptionPane.showMessageDialog(null, "Login Successfull");
                           Dashboard dashFrame = new Dashboard();
                           dashFrame.setVisible(true);
                           this.hide();
                           
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null,"User Name or Password is incorrect");
                       }
                       
                       
                       
                }
                catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
                
            
        }
        
        
    }//GEN-LAST:event_btnlogActionPerformed

    private void checkshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkshowActionPerformed
        // show the password values
        if(checkshow.isSelected())
        {
            textpassword.setEchoChar((char)0);
        }
        else
        {
            textpassword.setEchoChar(('*'));
        }
    }//GEN-LAST:event_checkshowActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Visible next interface:
        HomePage HomeFrame = new HomePage();
        HomeFrame.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlog;
    private javax.swing.JButton btnsign;
    private javax.swing.JCheckBox checkshow;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField textpassword;
    private javax.swing.JTextField textuser;
    // End of variables declaration//GEN-END:variables
}
