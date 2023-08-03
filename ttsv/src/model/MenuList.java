/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class MenuList {
    ArrayList<MenuList> menuList = (Arrays.asList{
            new MenuList(1, "List all Student"),
            new MenuList(2, "Input student")
});
        
    public void showMenu() {
        for(int i = 0; i < menuList.size(); i++) {
            System.out.println("Option " + menuList.get(i).chooseId);
        }
    }
}
