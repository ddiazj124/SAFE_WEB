/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOEvaluacion;
import DAO.DAOTecnico;
import Entidades.Evaluacion;
import Entidades.Tecnico;
import Entidades.Usuario;
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
 * @author Diego
 */
@WebServlet(name = "ServMostrarIngresoPregunta", urlPatterns = {"/ServMostrarIngresoPregunta"})
public class ServMostrarIngresoPregunta extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        //Recuperar Correo del Uusario
        Usuario u = (Usuario)session.getAttribute("datosUsuarioCorreo");
        String correo = u.getCorreo_electronico();
        //Busca el Rut actual del Tecnico 
        DAOTecnico dao = new DAOTecnico();
        ArrayList<Tecnico> Ltecnico = dao.TraerTecnico(correo);
        String rut_tecnico = "";
        for (Tecnico obj : Ltecnico) {
            rut_tecnico = obj.getRut_tecnico();
        }
        
        //Guardar Dato de Nombre Evaluacion
        DAOEvaluacion dev = new DAOEvaluacion();
        ArrayList<Evaluacion> Listdev = dev.TraerEvaluacionesTecnico(rut_tecnico);
        
        session.setAttribute("datosEvaluacionesA", Listdev);
        response.sendRedirect("./tecnico/registroPregunta.jsp");
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
