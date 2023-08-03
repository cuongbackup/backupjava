/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.ContactDAO;
import model.Contact;
import model.Group;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GroupDAO;

/**
 *
 * @author Administrator
 */
public class ContactControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContactControllerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContactControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GroupDAO dao = new GroupDAO();
        ArrayList<Group> listGroup = new ArrayList<Group>();
        listGroup = dao.getGroup();
        request.setAttribute("listGroup", listGroup);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddContact.jsp");
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST":
                    listContacts(request, response);
                    break;
                case "ADD":
                    addContacts(request, response);
                    break;
                case "LOAD":
                    loadContacts(request, response);
                    break;
                case "UPDATE":
                    updateContacts(request, response);
                    break;
                case "DELETE":
                    deleteContacts(request, response);
                default:
                    listContacts(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(ContactControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listContacts(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ContactDAO contactDAO = new ContactDAO();
        List<Contact> list = contactDAO.getContact();
        request.setAttribute("contactlist", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListContacts.jsp");
        dispatcher.forward(request, response);
    }

    private void addContacts(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddContact.jsp");
        dispatcher.forward(request, response);
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String groupName = request.getParameter("groupName");
        String phoneNumber = request.getParameter("phoneNumber");
        Contact contact = new Contact(firstName, lastName, groupName, phoneNumber);
        ContactDAO contactDAO = new ContactDAO();
        contactDAO.addContact(contact);
        listContacts(request, response);
    }

    private void loadContacts(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theContactId = request.getParameter("contactId");
        Contact contact = new ContactDAO().getContact(theContactId);
        Contact s = (Contact) contact;
        request.setAttribute("THE_CONTACT", contact);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditContact.jsp");
        dispatcher.forward(request, response);
    }

    private void updateContacts(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("contactId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String groupName = request.getParameter("groupName");
        String phoneNumber = request.getParameter("phoneNumber");
        Contact contact = new Contact(id, firstName, lastName, groupName, phoneNumber);
        new ContactDAO().updateContact(contact);
        listContacts(request, response);
    }

    private void deleteContacts(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theContactId = request.getParameter("contactId");
        new ContactDAO().deleteContact(theContactId);
        listContacts(request, response);
    }

}
