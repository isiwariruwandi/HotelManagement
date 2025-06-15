/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cw.hotelmanagementcw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class HotelManagementCW {
    //add connection to database
    public static Connection conn(){
        try{
             String url = ("jdbc:mysql://localhost:3306/usersdata");
            String username = "Ruwii";
            String password = "1234abcd";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }catch(SQLException | ClassNotFoundException e){
        JOptionPane.showMessageDialog(null,e);
    }   
     return null;  
    }
   

    public static void main(String[] args)
    {
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
    }
}
