package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDB implements DatabaseInfo, BookDAO {
    public Book addNew(Book b){
        try(Connection con=DatabaseInfo.getConnect();) {
            //Class.forName(driverName);
            //Connection con=DriverManager.getConnection(dbURL,userDB,passDB);
            String sql="Insert into Book(Title,Author,Category,Description,Pubyear,Quantity,AvailQtt) output inserted.BookID values(?,?,?,?,?,?,?)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, b.getTitle());
            stmt.setString(2, b.getTacgia());
            stmt.setString(3, b.getCategory());
            stmt.setString(4, b.getDescription());
            stmt.setInt(5, b.getPubYear());
            stmt.setInt(6, b.getQuantity());
            stmt.setInt(7, b.getAvailQtt());
            ResultSet rs= stmt.executeQuery();
            rs.next();
            b.setBookID(""+rs.getInt(1));
            con.close();
            return b;
        } catch (Exception ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Add new book failed!!!");
        }
    }
  //-------------------------------------------------------
    public static ArrayList<Book> getDummyBook(int m){
        ArrayList<Book> books= new ArrayList<>(); 
        for(int i=1; i<=m; i++)
            books.add(new Book("B"+i, "Book "+i, "Author "+i, "Cat "+i, "Description "+i, 2023, 10, 10));
        return books;
    }
  //-------------------------------------------------------
    public static ArrayList<Book> getAllBook(){
        ArrayList<Book> books= new ArrayList<>(); 
        try(Connection con=DriverManager.getConnection(dbURL,userDB,passDB)) {
            PreparedStatement stmt=con.prepareStatement("Select BookID,Title,Author,Category,pubyear,Description,quantity,availqtt from Book");
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
                int bid=rs.getInt(1);
                String tt=rs.getString(2);
                String at=rs.getString(3);
                String cat=rs.getString(4);
                int py=rs.getInt(5);
                String des=rs.getString(6);
                int sl=rs.getInt(7);
                int asl=rs.getInt(8);
                books.add(new Book(""+bid, tt, at, cat,des, py, sl,asl));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Something wrong.. Please wait!!");
        }
        return books;
    }
  //-------------------------------------------------------   
}
    

