/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.AsistenciaDAO;
import DAO.DAOAtencionMedica;
import DAO.DAOEmpresa;
import DAO.TrabajadorDAO;
import Entidades.Atencion;
import Entidades.Empresa;
import VO.AsistenciaVO;
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
@WebServlet(name = "ServBuscarAsistencia", urlPatterns = {"/ServBuscarAsistencia"})
public class ServBuscarAsistencia extends HttpServlet {

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
        List<AsistenciaVO> ListaAsistencia = new ArrayList();
        //List<TrabajadorVO> ListaAsistencia2 = new ArrayList();
        int idcapacitacion = Integer.parseInt(request.getParameter("idcapacitacion"));
        
        HttpSession session = request.getSession();        
        String tmp = "";
        
        try{
            AsistenciaDAO dao = new AsistenciaDAO();
            AsistenciaVO a = new AsistenciaVO();
            //TrabajadorDAO dao = new TrabajadorDAO();
            //TrabajadorVO vo = new TrabajadorVO();
            //Visitas
           
            ListaAsistencia = dao.list2(idcapacitacion);
            for (AsistenciaVO obj : ListaAsistencia)
            {
                tmp = tmp + 
                        "NOMBRE: " + obj.getNombre_trabajador() + " " + obj.getApellido_trabajador() 
                        + " | RUT: "  + obj.getRut_trabajador() + " | FECHA: " + obj.getFecha_asistencia() 
                        + " | ESTADO: " + obj.getEstado_asistencia() + " \n " + " \n " ;                
            }             
            session.setAttribute("ListaAsistencia", ListaAsistencia);
            out.println(tmp);
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
