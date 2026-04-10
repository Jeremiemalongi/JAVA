/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.projet_web_tp;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author jerem
 */

@WebServlet(name = "UniConverterServlet", urlPatterns = {"/convert"})
public class UniConverterServlet extends HttpServlet {

   

   
   
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // 1) Récupérer les deux nombres
    float nbre1 = Float.parseFloat(request.getParameter("nbre1"));
    float nbre2 = Float.parseFloat(request.getParameter("nbre2"));

    // 2) Addition
    float resultat = nbre1 + nbre2;

    // 3) Envoyer les résultats vers la JSP
    request.setAttribute("nbre1", nbre1);
    request.setAttribute("nbre2", nbre2);
    request.setAttribute("resultat", resultat);

    // 4) Afficher la page résultat
    RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
    dispatcher.forward(request, response);
        
        
 }

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.getWriter().println("Servlet convert OK");
}

   
}
