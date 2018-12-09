package Controlador;

import DAO.AsistenciaDAO;
import DAO.DAOAtencionMedica;
import DAO.DAOEmpresa;
import DAO.EvaluacionDAO;
import DAO.TrabajadorDAO;
import Entidades.Atencion;
import Entidades.Empresa;
import VO.AsistenciaVO;
import VO.EvaluacionLiteVO;
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
@WebServlet(name = "ServBuscarTrabajadoresPorEmpresa", urlPatterns = {"/ServBuscarTrabajadoresPorEmpresa"})
public class ServBuscarTrabajadoresPorEmpresa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        List<TrabajadoresLiteVO> TrabajadoresLiteVO = new ArrayList();
        
        String idCapacitacionCmb = request.getParameter("idCapacitacionCmb");
        
        HttpSession session = request.getSession(); 
        
        try{
            EvaluacionDAO dao = new EvaluacionDAO();
            EvaluacionLiteVO eva = new EvaluacionLiteVO();
           
            ListaTrabajadoresLite = dao.listLite(idCapacitacionCmb);
            String salida = "";
           
            request.setAttribute("ListaTrabajadoresLite", ListaTrabajadoresLite);
            for (TrabajadoresLiteVO tra : ListaTrabajadoresLite) {
                salida = salida + "<option value=" + String.valueOf(tra.getRut()) + "> "
                        + tra.getNombre()+ " " + tra.getApellido() + "</option>" + "</br>";                
            }
            
            //session.setAttribute("ListaEvaluacionLite", ListaEvaluacionLite);
            //session.setAttribute("idEmpresaCmbX", idEmpresaCmbX);
            out.println(salida);
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
