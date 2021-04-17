/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.math.linearalgebra;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Odec
 */
public class CanvasRadialGradiant extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
        Double X = Double.parseDouble(request.getParameter("x"));
        Double Y = Double.parseDouble(request.getParameter("y"));    
        Double X0 = Double.parseDouble(request.getParameter("x0"));
        Double Y0 = Double.parseDouble(request.getParameter("y0"));
        Double R0 = Double.parseDouble(request.getParameter("r0"));
        Double X1 = Double.parseDouble(request.getParameter("x1"));
        Double Y1 = Double.parseDouble(request.getParameter("y1"));
        Double R1 = Double.parseDouble(request.getParameter("r1"));
        String Color1 = request.getParameter("color1");
        String Color2 = request.getParameter("color2");

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CanvasTexto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<canvas id=\"myCanvas\" width="+X+" height="+Y+" style=\"border:1px solid #d3d3d3;\">\n" +
"Your browser does not support the HTML5 canvas tag.</canvas>");
            out.println("<script>");
            out.println("var c = document.getElementById(\"myCanvas\");");
            out.println("var ctx = c.getContext(\"2d\");");
            out.println("var grd = ctx.createRadialGradient("+X0+","+Y0+","+R0+","+X1+","+Y1+","+R1+");");
            out.println("grd.addColorStop(0, \""+Color1+"\");");
            out.println("grd.addColorStop(1, \""+Color2+"\");");
            out.println("ctx.fillStyle = grd;");
            out.println("ctx.fillRect(0, 0, "+X+", "+Y+");");
            out.println("</script>");
            out.println("<h1></h1>");
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
        processRequest(request, response);
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

}
