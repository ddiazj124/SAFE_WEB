/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOEmpresa;
import DAO.DAOEvaluacion;
import DAO.DAOEvaluacionPersonal;
import DAO.DAOIngeniero;
import DAO.DAOTipo_Eval;
import DAO.DAOTrabajador;
import Entidades.Empresa;
import Entidades.EvaluacionPersonal;
import Entidades.Ingeniero;
import Entidades.Tipo_Eval;
import Entidades.Trabajador;
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
@WebServlet(name = "ServMostrarRegistroEvaluacionesPersonal", urlPatterns = {"/ServMostrarRegistroEvaluacionesPersonal"})
public class ServMostrarRegistroEvaluacionesPersonal extends HttpServlet {

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
        try
            {
                
                HttpSession session = request.getSession();
                
                //Empresas
                DAOEmpresa e = new DAOEmpresa();
                ArrayList<Empresa> Listemp = e.TraerTodos();
                session.setAttribute("datosEmpresa", Listemp);
                
                //Tipo Evaluacion
                DAOTipo_Eval teDao = new DAOTipo_Eval();
                ArrayList<Tipo_Eval> ListTipoEval = teDao.TraerTodos();
                session.setAttribute("datosTipoEvaluacion", ListTipoEval);
                
                //Trabajador
                DAOTrabajador tr = new DAOTrabajador();
                ArrayList<Trabajador> Listtr = tr.TraerTodos();
                session.setAttribute("datosTrabajador", Listtr);
                
                //Ingeniero
                DAOIngeniero i = new DAOIngeniero();
                ArrayList<Ingeniero> Listing = i.TraerTodos();
                session.setAttribute("datosIngeniero", Listing);
                
                
                
                //response.sendRedirect("medico/administrarAtenciones.jsp");
                //request.getRequestDispatcher("medico/administrarAtenciones.jsp").forward(request, response);
            }catch (Exception ex)
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
