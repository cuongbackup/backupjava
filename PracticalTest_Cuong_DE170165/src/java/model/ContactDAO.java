/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connect.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ContactDAO {

    public ArrayList<Contact> getContact() {
        ArrayList<Contact> fl = new ArrayList<>();
        DBContext db = DBContext.getInstance();
        String sql = "select c.id as contact_id, * from dbo.ContactTBL as c inner join dbo.GroupTBL as g on c.id = g.id";
        try {
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String groupName = rs.getString(4);
                String phoneNumber = rs.getString(5);
                Contact contact = new Contact(id, firstName, lastName, groupName, phoneNumber);
                fl.add(contact);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return fl;
    }

    public void addContact(Contact contact) {
        String sql = "INSERT INTO ContactTBL (firstname, lastname, groupname, phonenumber)\n" + "VALUES (?,?,?,?);";
        DBContext db = DBContext.getInstance();

        Connection con;

        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, contact.getFirstName());
            statement.setString(2, contact.getLastName());
            statement.setInt(3, getGroupIdFromName(contact.getGroupName()));
            statement.setString(4, contact.getPhoneNumber());
            statement.execute();

            statement.close();
            con.close();

        } catch (Exception ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

    }

    public void updateContact(Contact contact) {
        String sql = "UPDATE [ContactDB].[dbo].[ContactTBL]\n"
                + "SET firstname=?, lastname=?, groupname=?, phonenumber = ?\n"
                + "WHERE id = ?";
        DBContext db = DBContext.getInstance();
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, contact.getFirstName());
            statement.setString(2, contact.getLastName());
            statement.setInt(3, getGroupIdFromName(contact.getGroupName()));
            statement.setString(4, contact.getPhoneNumber());
            statement.setInt(5, contact.getId());
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public Contact getContact(String idd) {
        int id = Integer.parseInt(idd);
        DBContext db = DBContext.getInstance();

        Contact contact = null;
        String sql = "Select * from ContactTBL where id=?";
        try {
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String groupName = rs.getString(4);
                String phoneNumber = rs.getString(5);
                contact = new Contact(id, firstName, lastName, groupName, phoneNumber);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return contact;
    }

    public void deleteContact(String idd) {
        try {
            DBContext db = DBContext.getInstance();
            Connection con = db.openConnection();
            String sql = "DELETE FROM ContactTBL WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            int id = Integer.parseInt(idd);
            statement.setInt(1, id);
            statement.execute();
            con.close();
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getGroupIdFromName(String name) throws Exception {
        DBContext db = DBContext.getInstance();
        Connection con = db.openConnection();
        ResultSet rs = null;
        int id = 0;
        String sqlStatement = "select id from GroupTBL where group_name=?";
        try {
            PreparedStatement st = con.prepareStatement(sqlStatement);
            st.setString(1, name);
            rs = st.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                try {
                    id = Integer.parseInt(rs.getString("id"));
                } catch (NumberFormatException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return id;
    }
}
