/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.AsistenciaDAO;
import DAO.DAOAtencionMedica;
import DAO.DAOEmpresa;
import DAO.EvaluacionDAO;
import DAO.ObservacionDAO;
import DAO.TrabajadorDAO;
import Entidades.Atencion;
import Entidades.Empresa;
import VO.AsistenciaVO;
import VO.EvaPer_TerVO;
import VO.EvaluacionLiteVO;
import VO.EvaluacionVO;
import VO.ObservacionVO;
import VO.Pregunta_RespuestaVO;
import VO.TrabajadorVO;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ServGrabarObservacion", urlPatterns = {"/ServGrabarObservacion"})
public class ServGrabarObservacion extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        int    idEvaluacion = Integer.parseInt(request.getParameter("idEvaluacion"));
        String observacion  = request.getParameter("observacion");
        
        HttpSession session = request.getSession();  
        String salida = "";
        
        try{
            ObservacionDAO dao   = new ObservacionDAO();                        
            ObservacionVO obs    = new ObservacionVO();
            
            obs.setID_EVALUACION(idEvaluacion);
            obs.setDETALLE_OBSERVACION(observacion);
            dao.add(obs);
            
            EvaluacionDAO daoEva = new EvaluacionDAO();
            daoEva.finalizarEvaluacion(idEvaluacion);
            //out.println("CONTACTE AL SUPERVISOR!"); 
            //response.sendRedirect("./medico/administrarAtenciones.jsp");
        }catch(Exception e)
        {
            //response.sendRedirect("./medico/AdministrarAtencionesNo.jsp");
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
