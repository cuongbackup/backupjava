/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.*;


/**
 * Web application lifecycle listener.
 *
 * @author Admin
 */
public class ApplicationtListener implements DatabaseInfo, ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApplicationtListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Book> books=BookDB.getDummyBook(1000);
        sce.getServletContext().setAttribute("list", books);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
