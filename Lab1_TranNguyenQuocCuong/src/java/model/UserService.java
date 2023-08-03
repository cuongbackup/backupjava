/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class UserService {

    public boolean checkLogin(User user) {
        if (user.getUsername().equals("abc") && user.getPassword().equals("12345")) {
            return true;
        }
        return false;
    }
}
