/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connect.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class GroupDAO {

    public ArrayList<Group> getGroup() {
        ArrayList<Group> fl = new ArrayList<>();
        DBContext db = DBContext.getInstance();
        String sql = "Select * from GroupTBL";
        try {
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                Group group = new Group(id, name, description);
                fl.add(group);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return fl;
    }

    public void addGroup(Group group) {
        String sql = "INSERT INTO GroupTBL (name, type, price, amount)\n" + "VALUES (?,?,?,?);";
        DBContext db = DBContext.getInstance();

        Connection con;

        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, group.getGroupName());
            statement.setString(2, group.getDescription());
            statement.execute();
            statement.close();
            con.close();

        } catch (Exception ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    }