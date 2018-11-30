package Controlador;

import DAO.CapacitacionDAO;
import DAO.VisitaMedicaDAO;
import VO.CapacitacionVO;
import VO.VisitaMedicaVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServEditarVisitasMedicas", urlPatterns = {"/ServEditarVisitasMedicas"})
public class ServEditarVisitasMedicas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        
        response.setContentType( "text/html; charset=iso-8859-1" );
        PrintWriter out = response.getWriter();
        Boolean salida  = false;
        
        String idVisitaMedicaEditar     = request.getParameter("idVisitaMedicaEditar");
        String rutMedicoEditar          = request.getParameter("rutMedicoEditar");
        String rutTrabajadorEditar      = request.getParameter("rutTrabajadorEditar");
        String motivoConsultaEditar     = request.getParameter("motivoConsultaEditar");
        String fechaVisitaEditar        = request.getParameter("fechaVisitaEditar");
        
        String salida2 = "";
        //String salida2 = idVisitaMedicaEditar + "-" + rutMedicoEditar + "-" + rutTrabajadorEditar 
        //                + "-" + motivoConsultaEditar + "-" + fechaVisitaEditar;                
        try{
            VisitaMedicaDAO dao         = new VisitaMedicaDAO();
            VisitaMedicaVO  vo          = new VisitaMedicaVO();
            
            vo.setId_visita(Integer.parseInt(idVisitaMedicaEditar));
            vo.setRut_medico(rutMedicoEditar);
            vo.setRut_trabajador(rutTrabajadorEditar);
            vo.setMotivo_consulta(motivoConsultaEditar);
            vo.setFecha_visita(Date.valueOf(fechaVisitaEditar));
            
            salida = dao.edit(vo); 
            
            salida2 = vo.getId_visita() + "-" + vo.getRut_medico() + "-" + vo.getRut_trabajador() +
                             vo.getMotivo_consulta() + "-" + vo.getFecha_visita();
            
            HttpSession session = request.getSession();            
            session.setAttribute("visitaModificada", true);            
            //response.sendRedirect("./supervisor/Capacitaciones.jsp");
        }
        catch(Exception e)
        {   
            HttpSession session = request.getSession();
            session.setAttribute("visitaModificada", false);
            //Boolean capacitacionEdit = false;
            //session.setAttribute("capacitacionEdit", capacitacionEdit);
            //response.sendRedirect("./supervisor/Capacitaciones.jsp");
            
        }
        out.println(salida2);
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
