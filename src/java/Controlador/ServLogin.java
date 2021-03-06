    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOExamen;
import DAO.DAOMedico;
import DAO.DAOTrabajador;
import DAO.DAOUsuario;
import DAO.DAOVisita_Med;
import Entidades.Examen;
import Entidades.Medico;
import Entidades.Trabajador;
import Entidades.Usuario;
import Entidades.Visita_Med;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "ServLogin", urlPatterns = {"/ServLogin"})
public class ServLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static String getMD5(String input) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);

        while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
        }
        return hashtext;
    }
    catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
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
        
        String txtUser = request.getParameter("txtUser");
        String txtPass = request.getParameter("txtPass");
        
        
        DAOUsuario dao = new DAOUsuario();
        
        if(dao.ValidarUsuario(txtUser, getMD5(txtPass))){
              
         DAOUsuario uDao = new DAOUsuario();
         
        Usuario u = uDao.Autenticacion(txtUser, getMD5(txtPass));
        System.out.println(u.getId_perfil());
             HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("datosUsuario", u);
                    
                    if(u.getId_perfil()==1)
                    {
                        response.sendRedirect("supervisor/menuSupervisor.jsp");
                    }
                    if(u.getId_perfil()==2)
                    {
                        response.sendRedirect("cliente/menuCliente.jsp");
                    }
                    if(u.getId_perfil()==3)
                    {
                        response.sendRedirect("trabajador/menuTrabajador.jsp");
                    }
                    if(u.getId_perfil()==4)
                    {
                        Usuario uc = uDao.AutenticacionCorreo(txtUser, getMD5(txtPass));
                        sesion.setAttribute("datosUsuarioCorreo", uc);
                        response.sendRedirect("tecnico/menuTecnico.jsp");
                    }
                    if(u.getId_perfil()==5)
                    {
                        response.sendRedirect("ingeniero/menuIngeniero.jsp");
                    }
                    if(u.getId_perfil()==6)
                    {
                        response.sendRedirect("administrador/menuAdministrador.jsp");
                    }
                    if(u.getId_perfil()==7)
                    {
                        HttpSession session = request.getSession();
                        
                        Medico med = new Medico();
                        DAOMedico daoMed = new DAOMedico();
                        Examen exam = new Examen();
                        
                        
                        
                        
                        med = daoMed.BuscarRutMedico(u.getNombre_usuario());
                        
                        DAOVisita_Med vism = new DAOVisita_Med();
                        DAOExamen daoExam = new DAOExamen();
                        DAOTrabajador t = new DAOTrabajador();
                        
                        ArrayList<Medico> Lmedicos = daoMed.TraerTodos();
                        ArrayList<Visita_Med> Listvis = vism.TraerVisitasMedXRut(med.getRut_medico());
                        ArrayList<Examen> Lexam = daoExam.TraerExamenMedXRut(med.getRut_medico());
                        ArrayList<Trabajador> ListTrab = t.TraerTodos();
                        
                        //session.setAttribute("datosTrabajador", ListTrab);
                        session.setAttribute("Lmedicos", Lmedicos);
                        session.setAttribute("ListarVisitasX", Listvis);
                        session.setAttribute("ListarExamX", Lexam);
                        
                        response.sendRedirect("medico/menuMedico.jsp");
                    }
        }else{
            HttpSession session = request.getSession();
            boolean error = true;
            String mensaje = "";
            if(error){
                
               mensaje = "ERROR"; 
                
                
                session.setAttribute("msjError", error);
                response.sendRedirect("index.jsp");
            }
            //System.out.println("USUARIO Y CONTRASEÑA INCORRECTO");
        }
        
        
        
        /*
        try{
            DAOUsuario uDao = new DAOUsuario();
            
            
            Usuario u = uDao.Autenticacion(txtUser, getMD5(txtPass));
            
            
            /*
            if(u.getNombre_usuario().equals(user) && u.getContrasena().equals(md5))
            {
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("datosUsuario", u);
                if(u.getId_perfil()==1)
                {
                    response.sendRedirect("supervisor/menuSupervisor.jsp");
                }
                if(u.getId_perfil()==2)
                {
                    response.sendRedirect("cliente/menuCliente.jsp");
                }
                if(u.getId_perfil()==3)
                {
                    response.sendRedirect("trabajador/menuTrabajador.jsp");
                }
                if(u.getId_perfil()==4)
                {
                    response.sendRedirect("tecnico/menuTecnico.jsp");
                }
                if(u.getId_perfil()==5)
                {
                    response.sendRedirect("ingeniero/menuIngeniero.jsp");
                }
                if(u.getId_perfil()==6)
                {
                    response.sendRedirect("administrador/menuAdministrador.jsp");
                }
                if(u.getId_perfil()==7)
                {
                    response.sendRedirect("medico/menuMedico.jsp");
                }
                
                
            }
            else if(u.getNombre_usuario().equals(user) && u.getContrasena()!=md5)
            {
                String error = "Contraseña no coincide, reintente";
                request.setAttribute("error",error);
                response.sendRedirect("index.jsp");
            }
            }        
            catch(Exception ex)
            {
                String error = "Usuario no existe";
                request.setAttribute("error", error);
                response.sendRedirect("index.jsp");
            }
            */
        
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
