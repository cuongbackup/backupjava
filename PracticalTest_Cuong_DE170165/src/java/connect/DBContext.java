/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext implements DatabaseInfor {

    private static DBContext instance;
    
    public DBContext() {
        
    }

    public Connection openConnection() throws Exception {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, user, pass);
            return con;
    }

    public static DBContext getInstance() {
        if (instance == null) {
            instance = new DBContext();
        }
        return instance;
    }
}
