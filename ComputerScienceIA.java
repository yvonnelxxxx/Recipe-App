/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.yvonne.computerscienceia;

import java.sql.*;

/**
 *
 * @author student
 */
public class ComputerScienceIA {
    public static Connection connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Success Loading");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/IA_database?user=root", "root", "060724lxy");
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        LoginPage userLogin = new LoginPage();
        userLogin.setVisible(true);
    }
}