package Controlador;

import DAO.VisitaMedicaDAO;
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

@WebServlet(name = "ServAgregarVisitaMedica", urlPatterns = {"/ServAgregarVisitaMedica"})
public class ServAgregarVisitaMedica extends HttpServlet {

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
        Boolean salida = false;
        
        String rutMedico        = request.getParameter("rutMedico");
        String rutTrabajador    = request.getParameter("rutTrabajador");
        String motivoConsulta   = request.getParameter("motivoConsulta");
        String fechaVisita      = request.getParameter("fechaVisita");
                         
        try{             
            VisitaMedicaDAO dao = new VisitaMedicaDAO();
            VisitaMedicaVO  vo  = new VisitaMedicaVO();
            
            vo.setRut_medico(rutMedico);
            vo.setRut_trabajador(rutTrabajador);
            vo.setMotivo_consulta(motivoConsulta);
            vo.setFecha_visita(Date.valueOf(fechaVisita));
            
            salida = dao.add(vo);           
            
            //HttpSession session = request.getSession();
            
            //session.setAttribute("capacitacionEdit", vo);            
            //response.sendRedirect("./supervisor/Capacitaciones.jsp");
        }
        catch(Exception e)
        {            
            //HttpSession session = request.getSession();
            //Boolean capacitacionEdit = false;
            //session.setAttribute("capacitacionEdit", capacitacionEdit);
            //response.sendRedirect("./supervisor/Capacitaciones.jsp");
            
        }
        out.println(salida);
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
