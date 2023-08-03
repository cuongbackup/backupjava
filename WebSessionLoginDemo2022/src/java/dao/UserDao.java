/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbcontext.DBUtil;
import entity.User;
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
 * @author Ly Quynh Tran
 */
public class UserDao {

    public boolean login(User user) {
        DBUtil db = DBUtil.getInstance();
        String sql = "Select * from user_register_TBL where userName=? "
                + "and password=?";
        PreparedStatement statement = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            rs = statement.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                statement.close();
                DBUtil.closeConnection(con);
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean registerUser(User user) {
        DBUtil db = DBUtil.getInstance();
        String sql
                = "insert into user_register_TBL (firstName,lastName,email,userName,password) values(?,?,?,?,?)";
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = db.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getUserName());
            statement.setString(5, user.getPassword());
            statement.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                DBUtil.closeConnection(con);
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
