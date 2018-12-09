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
import DAO.TrabajadorDAO;
import Entidades.Atencion;
import Entidades.Empresa;
import VO.AsistenciaVO;
import VO.EvaPer_TerVO;
import VO.EvaluacionLiteVO;
import VO.EvaluacionVO;
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
@WebServlet(name = "ServBuscarEvaluacionPorId", urlPatterns = {"/ServBuscarEvaluacionPorId"})
public class ServBuscarEvaluacionPorId extends HttpServlet {

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
        int idEvaluacion = Integer.parseInt(request.getParameter("idEvaluacion"));
        
        HttpSession session = request.getSession();        
        String salidaPer = "";
        String salidaTer = "";
        String salida = "";
        
        try{
            EvaluacionDAO dao   = new EvaluacionDAO();
                        
            EvaPer_TerVO eva    = new EvaPer_TerVO();
            EvaPer_TerVO eva2    = new EvaPer_TerVO();
            eva                 = dao.EvaPersonaPorId(idEvaluacion);
            
            int hayPer = 0;
            int hayTer = 0;
            
            hayPer = dao.getEvaPer(idEvaluacion);
            hayTer = dao.getEvaTer(idEvaluacion);
            
            if(hayPer > 0){
               //EVA Persona       
                salida              = 
                        "EVALUACIÓN TIPO PERSONA " + "\n" + "\n" +
                        "TITULO EVALUACION : " + eva.getTITULO_EVA() + "\n" + "\n" +
                        "EMPRESA : " + eva.getRAZON_SOCIAL()+ "\n" + "\n" +
                        "RUT EMPRESA : " + eva.getRUT_EMPRESA() + "\n" + "\n" +
                        "FECHA EVALUACION : " + eva.getFECHA_EVAL() + "\n" + "\n" +
                        "DESCRIPCION EVALUACIÓN : " + eva.getDESCRIPCION_EVA() + "\n" + "\n" +
                        "ESTADO EVALUACIÓN : " + eva.getESTADO_EVA() + "\n" + "\n" + 
                        "DESCRIPCION EVALUACIÓN PERSONA : " + eva.getDESCRIPCION_EVA_PERS() + "\n" + "\n" + 
                        "RUT TRABAJADOR : " + eva.getRUT_TRABAJADOR() +"\n" + "\n" 
                        ; 
            }else if(hayTer > 0){
                //Eva Terreno
                eva2     = dao.EvaTerrenoPorId(idEvaluacion);            
                salida   = 
                        "EVALUACIÓN EN TERRENO " + "\n" + "\n" +
                        "TITULO EVALUACION : " + eva2.getTITULO_EVA() + "\n" + "\n" +
                        "EMPRESA : " + eva2.getRAZON_SOCIAL()+ "\n" + "\n" +
                        "RUT EMPRESA : " + eva2.getRUT_EMPRESA() + "\n" + "\n" +
                        "FECHA EVALUACION : " + eva2.getFECHA_EVAL() + "\n" + "\n" +
                        "DESCRIPCION EVALUACIÓN : " + eva2.getDESCRIPCION_EVA() + "\n" + "\n" +
                        "ESTADO EVALUACIÓN : " + eva2.getESTADO_EVA() + "\n" + "\n" + 
                        "DESCRIPCION EVALUACIÓN TERRENO : " + eva2.getDESCRIPCION_EVA_TER()+ "\n"                     
                        ;
            }                
            
            Pregunta_RespuestaVO        vo      = new Pregunta_RespuestaVO();
            List<Pregunta_RespuestaVO>  listado = new ArrayList();
            String                      pregResp = "";
            
            listado = dao.Pregunta_RespuestaPorIdEva(idEvaluacion);
            
            if( (hayPer > 0) || (hayTer > 0) ) {
                int cont = 0;
                for(Pregunta_RespuestaVO obj: listado){ 
                    cont = cont + 1;
                    pregResp = pregResp + "\n" +
                            "PREGUNTA " + cont + ": " + obj.getDETALLE_PREGUNTA() + "\n" + 
                            "RESPUESTA " + cont + ": " + obj.getDETALLE_RESPUESTA()+ "\n" + "\n" 
                            ;
                }
                salida += "\n" + "PREGUNTAS: " + "\n" + pregResp;
                out.println(salida); 
            }else{
               out.println("CONTACTE AL SUPERVISOR!");    
            }

             
                    
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
