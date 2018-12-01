/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOEvaluacion;
import DAO.DAOPregunta;
import Entidades.Evaluacion;
import Entidades.Pregunta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego.diaz
 */
@WebServlet(name = "ServMostrarPreguntas", urlPatterns = {"/ServMostrarPreguntas"})
public class ServMostrarPreguntas extends HttpServlet {

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
        try {
                HttpSession session = request.getSession();
                int id_ev = Integer.parseInt(request.getParameter("id_ev"));
                //Añadir objeto de Session que consulte que ID de evaluacion es:
                
                //Preguntas
                DAOPregunta p = new DAOPregunta();
                ArrayList<Pregunta> Listemp = p.TraerPreguntasEval(id_ev);
                session.setAttribute("datosPreguntas", Listemp);
                
                DAOEvaluacion e = new DAOEvaluacion();
                ArrayList<Evaluacion> ListEval = e.TraerEvaluacionesPregunta(id_ev);
                session.setAttribute("datosDatosEval", ListEval);
                
                response.sendRedirect("./tecnico/responderPreguntas.jsp");
                
                
        }
        catch (Exception ex)
        {
            String error;
            error = ex.toString();
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
