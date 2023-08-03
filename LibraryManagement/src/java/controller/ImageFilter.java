/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
public class ImageFilter implements Filter {
    private FilterConfig filterConfig = null;
    private int MAX_WIDTH = 400;
    private int MAX_HEIGHT = 300;
    private String uploadFolder="uploads";
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        this.MAX_WIDTH=Integer.parseInt(filterConfig.getInitParameter("MAX_WIDTH"));
        this.MAX_HEIGHT=Integer.parseInt(filterConfig.getInitParameter("MAX_HEIGHT"));
        this.uploadFolder=filterConfig.getInitParameter("FOLDER");
// Check if the request is a file upload
    if (httpRequest.getContentType()!=null && httpRequest.getContentType().startsWith("multipart/form-data")) {
        String applicationPath = request.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + File.separator +uploadFolder;
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        // Get the uploaded image from the request
        Part filePart = httpRequest.getPart("file");
        BufferedImage image = ImageIO.read(filePart.getInputStream());
        // Scale the image if necessary
        if (image != null) {
            // Calculate the scaled dimensions
            int scaledWidth = image.getWidth(null);
            int scaledHeight = image.getHeight(null);
            if (scaledWidth > MAX_WIDTH) {
                scaledWidth = MAX_WIDTH;
                scaledHeight = (int) ((double) MAX_WIDTH / image.getWidth(null) * image.getHeight(null));
            }
            if (scaledHeight > MAX_HEIGHT) {
                scaledHeight = MAX_HEIGHT;
                scaledWidth = (int) ((double) MAX_HEIGHT / image.getHeight(null) * image.getWidth(null));
            }
            // Create a new scaled image
            BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = scaledImage.createGraphics();
            g2d.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
            g2d.dispose();
            String fileName =filePart.getSubmittedFileName(); 
            File output = new File(uploadFilePath + File.separator + fileName);
            ImageIO.write(scaledImage, "jpg", output);
            request.getServletContext().setAttribute("uFolder", uploadFolder);
            chain.doFilter(request, response);
        }
    }
    else chain.doFilter(request, response);
 }

    public void destroy() {
        // Cleanup if needed
    }
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig=filterConfig;
    }

}

    
