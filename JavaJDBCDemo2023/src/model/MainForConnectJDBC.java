/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class MainForConnectJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://NANI\\MSSQLSERVER1:1433;databaseName=StudentDB2023;trustServerCertificate=true";
            String user = "sa";
            String pass = "Troller23012003.";
            
            Class.forName(driverName);            
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM dbo.StudentDB2023TBL";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                String numberDB = result.getString(1).trim();
                String nameDB = result.getString(2);
                String courseDB = result.getString(3);
                Student tempStudent = new Student(numberDB, nameDB, courseDB);
                System.out.println("" + tempStudent.toString());
            }
            
            result.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainForConnectJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainForConnectJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
}
