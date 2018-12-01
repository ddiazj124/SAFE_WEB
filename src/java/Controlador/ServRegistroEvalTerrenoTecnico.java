/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOEvaluacion;
import DAO.DAOEvaluacionTerreno;
import Entidades.Evaluacion;
import Entidades.EvaluacionTerreno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
@WebServlet(name = "ServRegistroEvalTerrenoTecnico", urlPatterns = {"/ServRegistroEvalTerrenoTecnico"})
public class ServRegistroEvalTerrenoTecnico extends HttpServlet {

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
        try{
            
            //Evaluacion;
            int id_eval = 0;
            String titulo = request.getParameter("txtTitulo");
            String rut_empresa = request.getParameter("ddlEmpresa");
            String fecha_eval = request.getParameter("txtFecha");
            String descripcion = request.getParameter("txtDescripcion");
            int estado_eval = 1;
            String rut_tecnico = "16200739-4";
            String rut_ingeniero = request.getParameter("ddlIngeniero");
            
            Evaluacion ev = new Evaluacion(id_eval, titulo, rut_empresa, fecha_eval, descripcion, estado_eval,rut_tecnico,rut_ingeniero);
            DAOEvaluacion dev = new DAOEvaluacion();
            dev.Insertar(ev);
            
            //Evaluacion Terreno
            String descripcion_Terreno = request.getParameter("txtDescripcionTerreno");
            int id_tipo = 1;
            id_eval = dev.TraerMaximo();
            
            EvaluacionTerreno et = new EvaluacionTerreno(0, descripcion, id_tipo, id_eval);
            DAOEvaluacionTerreno det = new DAOEvaluacionTerreno();
            
            det.Insertar(et);
            
            response.sendRedirect("./tecnico/registroExitoso.jsp");
        }catch(Exception e)
        {
            response.sendRedirect("./tecnico/registroFallidoT.jsp");
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
