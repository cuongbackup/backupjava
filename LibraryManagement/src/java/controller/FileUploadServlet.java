/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/staff/FileUploadServlet"})
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/lib/staff/upload.jsp");
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String data=request.getParameter("data");
        Part part = request.getPart("file");
        String fileName =part.getSubmittedFileName(); 
        request.setAttribute("data", data);
        String uploadfilePath=request.getContextPath()+"/"+request.getServletContext().getAttribute("uFolder")+"/"+fileName;
        request.setAttribute("path",uploadfilePath);
        request.getRequestDispatcher("/staff/showImage.jsp").forward(request, response);
    }
}
