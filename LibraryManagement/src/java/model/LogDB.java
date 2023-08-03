package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDB implements DatabaseInfo {
     public static Log addNew(Log b){
        try(Connection con=DatabaseInfo.getConnect();) {
//            String sql="Insert into Log(bookID,userID,mrDate) values(?,?,?)";
            PreparedStatement stmt=con.prepareStatement("{Call bookBorrow(?,?,?)}");
            stmt.setInt(1, b.getBookID());
            stmt.setInt(2, b.getUserID());
            stmt.setDate(3, Date.valueOf(b.getMrDate()));
            int rc=stmt.executeUpdate();
            con.close();
            return b;
        } catch (Exception ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Add new log failed!!!");
        }
    }
}
