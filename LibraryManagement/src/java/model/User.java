package model;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class User implements HtmlTable{
    private int uid;
    private String fullName,password,email,tel,status,role;
    LocalDate dob;	

    public User() {
    }

    public User(int uid, String fullName,String pass, String email, String tel, String status, String role, LocalDate dob) {
        this.uid = uid;
        this.fullName = fullName;
        this.email = email;
        this.tel = tel;
        this.status = status;
        this.role = role;
        this.dob = dob;
        password=pass;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static User login(int uid, String pass){
        User user=UserDB.getUser(uid);
        if(user.getPassword().equals(pass)) return user;
        throw new RuntimeException("Invalid login!!!");
    }

    
    public static String getHeaderRow() {
        return "<TR><TH>User ID</TH><TH>FullName</TH><TH>Date of Birth<TH>Email</TH><TH>Phone</TH></TR>";
    }

    @Override
    public String getDataRow() {
        return "<TR><TD>"+uid+"</TD><TD>"+fullName+"</TD><TD>"+dob+"</TD><TD>"+email+"</TD><TD>"+tel+"</TD></TR>";
    }
    
}
