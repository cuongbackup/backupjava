/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.Fastfood;
import model.FastfoodDAO;
import sun.rmi.runtime.Log;

/**
 *
 * @author Administrator
 */
public class FoodControllerServlet extends HttpServlet {

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
            out.println("<title>Servlet FoodControllerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FoodControllerServlet at " + request.getContextPath() + "</h1>");
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
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST":
                    listFoods(request, response);
                    break;
                case "ADD":
                    addFoods(request, response);
                    break;
                case "LOAD":
                    loadFoods(request, response);
                    break;
                case "UPDATE":
                    updateFoods(request, response);
                    break;
                case "DELETE":
                    deleteFoods(request, response);
                default:
                    listFoods(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(FoodControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private void listFoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FastfoodDAO foodDAO = new FastfoodDAO();
        List<Fastfood> list = foodDAO.getFood();
        request.setAttribute("foodlist", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-food.jsp");
        dispatcher.forward(request, response);
    }

    private void addFoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String amount = request.getParameter("amount");
        String price = request.getParameter("price");
        
        Fastfood food = new Fastfood(name, type, Float.parseFloat(price), Integer.parseInt(amount));
        FastfoodDAO foodDAO = new FastfoodDAO();
        foodDAO.addFood(food);
        listFoods(request, response);
    }

    private void loadFoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theFoodId = request.getParameter("foodId");
        Fastfood food = new FastfoodDAO().getFood(theFoodId);
        Fastfood s = (Fastfood) food;
        request.setAttribute("THE_FOOD", food);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update-food-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateFoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("foodId"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String amount = request.getParameter("amount");
        String price = request.getParameter("price");
        Fastfood food = new Fastfood(id, name, type, Float.parseFloat(price), Integer.parseInt(amount));
        new FastfoodDAO().updateFood(food);
        listFoods(request, response);
    }

    private void deleteFoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theFoodId = request.getParameter("foodId");
        new FastfoodDAO().deleteFood(theFoodId);
        listFoods(request, response);

    }
}
