/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOUsuario;
import Entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
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
        
        try{
            String user = request.getParameter("txtUser");
            String pass = request.getParameter("txtPass");
            DAOUsuario uDao = new DAOUsuario();
            
            //String md5 = getMD5(pass);
            String md5 = pass;
            Usuario u = uDao.Autenticacion(user, md5);
            
            if(u.getNombre_usuario().equals(user) && u.getContrasena().equals(md5))
            {
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("datosUsuario", u);
                if(u.getId_perfil()==1)
                {
                    request.getRequestDispatcher("supervisor/menuSupervisor.jsp").forward(request, response);
                }
                if(u.getId_perfil()==2)
                {
                    request.getRequestDispatcher("cliente/menuCliente.jsp").forward(request, response);
                }
                if(u.getId_perfil()==3)
                {
                    request.getRequestDispatcher("trabajador/menuTrabajador.jsp").forward(request, response);
                }
                if(u.getId_perfil()==4)
                {
                    RequestDispatcher rs = request.getRequestDispatcher("tecnico/menuTecnico.jsp");
                    rs.forward(request, response);
                }
                if(u.getId_perfil()==5)
                {
                    request.getRequestDispatcher("ingeniero/menuIngeniero.jsp").forward(request, response);
                }
                if(u.getId_perfil()==6)
                {
                    request.getRequestDispatcher("administrador/menuAdministrador.jsp").forward(request, response);
                }
                if(u.getId_perfil()==7)
                {
                    request.getRequestDispatcher("medico/menuMedico.jsp").forward(request, response);
                }
                
                
            }
            else if(u.getNombre_usuario().equals(user) && u.getContrasena()!=md5)
            {
                String error = "Contraseña no coincide, reintente";
                request.setAttribute("error",error);
                request.getRequestDispatcher("./index.jsp").forward(request, response);
            }
            }        
            catch(Exception ex)
            {
                String error = "Usuario no existe";
                request.setAttribute("error", error);
                request.getRequestDispatcher("./index.jsp").forward(request, response);
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
