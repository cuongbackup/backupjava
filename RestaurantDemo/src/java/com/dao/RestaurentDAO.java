/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.connect.DBContext;
import com.entity.Food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class RestaurentDAO implements RestaurentDAOInterface {

    @Override
    public Optional<Food> get() {
        DBContext db = DBContext.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Optional<Food> food = null;
        try {
            con = db.openConnection();
            String sql = "Select * from menu";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2).trim();
                String content = rs.getString(3).trim();
                String price = rs.getString(4).trim();
                food = Optional.of(new Food(id, name, content, price));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RestaurentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RestaurentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(RestaurentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return food;
    }
}
