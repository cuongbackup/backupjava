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
public class FastfoodDAO {

    public List<Fastfood> getFood() {
        List<Fastfood> fl = new ArrayList<>();
        DBContext db = DBContext.getInstance();
        String sql = "Select * from FastfoodTBL";
        try {
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String type = rs.getString(3);
                float price = rs.getFloat(4);
                int amount = rs.getInt(5);
                Fastfood fastfood = new Fastfood(id, name, type, price, amount);
                fl.add(fastfood);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(FastfoodDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return fl;
    }

    public void addFood(Fastfood fastfood) {
        String sql = "INSERT INTO FastfoodTBL (name, type, price, amount)\n" + "VALUES (?,?,?,?);";
        DBContext db = DBContext.getInstance();

        Connection con;

        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, fastfood.getName());
            statement.setString(2, fastfood.getType());
            statement.setFloat(3, fastfood.getPrice());
            statement.setInt(4, fastfood.getAmount());
            statement.execute();

            statement.close();
            con.close();

        } catch (Exception ex) {
            Logger.getLogger(FastfoodDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

    }

    public void updateFood(Fastfood fastfood) {
        String sql = "UPDATE [Fastfood].[dbo].[FastfoodTBL]\n"
                + "SET name=?, type=?, price=?, amount = ?\n"
                + "WHERE id = ?";
        DBContext db = DBContext.getInstance();
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, fastfood.getName());
            statement.setString(2, fastfood.getType());
            statement.setFloat(3, fastfood.getPrice());
            statement.setInt(4, fastfood.getAmount());
            statement.setInt(5, fastfood.getId());
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(FastfoodDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public Fastfood getFood(String idd) {
        int id = Integer.parseInt(idd);
        DBContext db = DBContext.getInstance();

        Fastfood fastfood = null;
        String sql = "Select * from FastfoodTBL where id=?";
        try {
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                String type = rs.getString(3);
                float price = rs.getFloat(4);
                int amount = rs.getInt(5);
                fastfood = new Fastfood(id, name, type, price, amount);

            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(FastfoodDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return fastfood;
    }

    public void deleteFood(String idd) {
        try {
            DBContext db = DBContext.getInstance();
            Connection con = db.openConnection();
            String sql = "DELETE FROM FastfoodTBL WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            int id = Integer.parseInt(idd);
            statement.setInt(1, id);
            statement.execute();
            con.close();
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(FastfoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
