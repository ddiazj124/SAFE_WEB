/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOVisita_Med;
import Entidades.Email;
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
        
        String id_visita = request.getParameter("txtId");
        id_visita = id_visita.trim();
        String estado = request.getParameter("cmbEstado");
        String correo = request.getParameter("txtcorreo");
        //String id_visita = request.getParameter("txtId");
        String motivo_consulta = request.getParameter("txtMotivoConsulta");
        String observaciones = request.getParameter("txtObservaciones");
        String diagnostico = request.getParameter("txtDiagnostico");
        String receta = request.getParameter("txtReceta");
        
        try {
            DAOVisita_Med vism = new DAOVisita_Med();
            int otroid = Integer.parseInt(id_visita);
            Visita_Med visi = new Visita_Med(otroid, motivo_consulta, observaciones, diagnostico, Integer.parseInt(estado), receta);
            vism.ActualizarVisitaMedX(visi);
            if(Integer.parseInt(estado) == 2){
                Entidades.Email em = new Entidades.Email();
                String texto = "Se ha confirmado la visita medica número: 1.\n"
                        + "Para mayor información revisar en la pagina web el panel de administración.\n"
                        + "Saluda atte. Safe.";
                Email.enviarConGMail(correo, "Confirmación visita medica número: "+ id_visita, texto);
                Email.enviarConGMail("se.calquin@alumnos.duoc.cl", "Confirmación visita medica número: "+id_visita, texto);
                Email.enviarConGMail("diego.safe.supervisor@gmail.com", "Confirmación visita medica número: "+id_visita, texto);
 
            }
                
            
            
            response.sendRedirect("medico/listarAtenciones.jsp");
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
