/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOVisita_Med;
import Entidades.Visita_Med;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian
 */
@WebServlet(name = "ServActualizarVisitaMed", urlPatterns = {"/ServActualizarVisitaMed"})
public class ServActualizarVisitaMed extends HttpServlet {

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
        
        int id_vis_ori = 0;
        
        String estado = request.getParameter("cmbEstado");
        String idvis = request.getParameter("txtId");
        String motivo_consulta = request.getParameter("txtMotivoConsulta");
        String observaciones = request.getParameter("txtObservaciones");
        String diagnostico = request.getParameter("txtDiagnostico");
        String receta = request.getParameter("txtReceta");
        
        try {
            DAOVisita_Med vism = new DAOVisita_Med();
            
            
            try{
                int id = Integer.parseInt(idvis);
                id_vis_ori = id;
             }catch(NumberFormatException ex){ // handle your exception
                System.out.println(ex);
             }
            
            Visita_Med visi = new Visita_Med(id_vis_ori, motivo_consulta, observaciones, diagnostico, Integer.parseInt("estado"), receta);
            vism.ActualizarVisitaMedX(visi);
            
            response.sendRedirect("medico/editarVisitaMed.jsp");
        } catch (Exception e) {
            System.out.println("Error: " + e);
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
