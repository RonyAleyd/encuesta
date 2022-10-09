
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String lenguajes[] = request.getParameterValues("lenguajes");
        
        //CREAR UN OBJETO PARQA ENCAPSULAR LA INFORMACION 
        Encuesta encu = new Encuesta();
        
        //LLENAR DATOS EN EL OBJETO ENCUESTA 
        encu.setNombre(nombre);
        encu.setLenguajes(lenguajes);
        
        //COLOCAMOS EL OBJETO ENCU COMO ATRIBUTO DEL REQUEST
        request.setAttribute("encu", encu);
        
        //ENVIAR EL OBJETO REQUEST A SALIDA.JSP
        request.getRequestDispatcher("salida.jsp").forward(request, response);
    }

  

}
