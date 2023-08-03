package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class UserDB implements DatabaseInfo {
    public static User getUser(int uid){
        ArrayList<User> au= Library.search(getAllUser(), u->u.getUid()==uid);
        return au.get(0);
    }
//-------------------------------------------
    public static ArrayList<User> getAllUser(){
        ArrayList<User> users= new ArrayList<>();
        try(Connection con=DatabaseInfo.getConnect()) { 
            PreparedStatement stmt=con.prepareStatement("Select UserID,fullname,dob,password,email,tel,status,role from Users");
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
                int uid=rs.getInt(1);
                String name=rs.getString(2);
                Date dob=rs.getDate(3);
                String pw=rs.getString(4);
                String tel=rs.getString(5);
                String email=rs.getString(6);
                String status=rs.getString(7);
                String role=rs.getString(8);
                User us=new User(uid,name,pw,email,tel,status,role,dob.toLocalDate());
                users.add(us);
            }
            con.close();
            return users;
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Read users error!!");
        }
    }
//-------------------------------------------  
        public static ArrayList<User> getDummyUser(int m){
        ArrayList<User> users= new ArrayList<>(); 
        for(int i=1; i<=m; i++)
            users.add(new User(i,"UserName "+i, "pass"+i, "Email "+i, "Phone "+i, "H", "RD", LocalDate.now()));
        return users;
    }

}
