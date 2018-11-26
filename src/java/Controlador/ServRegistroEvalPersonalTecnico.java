/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOEvaluacion;
import DAO.DAOEvaluacionPersonal;
import Entidades.Evaluacion;
import Entidades.EvaluacionPersonal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
@WebServlet(name = "ServRegistroEvalPersonalTecnico", urlPatterns = {"/ServRegistroEvalPersonalTecnico"})
public class ServRegistroEvalPersonalTecnico extends HttpServlet {

     /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        
        try{
            //DATOS DEL FORMULARIO
            String titulo = request.getParameter("txtEvaluacion");
            String rut_empresa = request.getParameter("ddlEmpresa");
            String rut_trabajador = request.getParameter("ddlTrabajador");
            String descripcion_evaluacion = request.getParameter("");
            String descripcion_evaluacionP = request.getParameter("txtDescripcionPersona");
            int tipo_eval = 7;
            int id_estado = 1;
            
            //FECHA
            String fecha_eval = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
            
            //DAO
            DAOEvaluacion dao = new DAOEvaluacion();
            DAOEvaluacionPersonal eDao = new DAOEvaluacionPersonal();
            
            
            Evaluacion ev = new Evaluacion(titulo, tipo_eval, rut_empresa,fecha_eval, descripcion_evaluacion, id_estado);
            EvaluacionPersonal e = new EvaluacionPersonal(descripcion_evaluacionP,tipo_eval,rut_trabajador);
            
            dao.Insertar(ev);
            eDao.Insertar(e);
            
            response.sendRedirect("./tecnico/registroExitoso.jsp");
        }catch(Exception e)
        {
            response.sendRedirect("./tecnico/registroFallido.jsp");
        }
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
