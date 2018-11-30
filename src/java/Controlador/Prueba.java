/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOUsuario;
import Entidades.Usuario;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;

/**
 *
 * @author Sebastian
 */
@WebServlet(name = "Prueba", urlPatterns = {"/Prueba"})
public class Prueba extends HttpServlet {

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
        
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try {
            //Estilos
            Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
            Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
            Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
            Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            //IMAGEN
            String RutaImagen = "";
            
            Document document = new Document();
            /* Estructura basica de pdf */
            PdfWriter.getInstance(document, out);
            document.open();
            //AÑADIR RUTA PARA AGREGAR IMAGEN
            //Image imagen = Image.getInstance();
            
            //Pagina 1
            document.addTitle("Reporte Visitas Medicas");
            document.addSubject("Generando Pdf Visitas.");
            document.addKeywords("Safe");
            document.addAuthor("SAFE - Asesoria Empresarial");
            document.addCreator("SAFE - Asesoria Empresarial");
            
            //Contenido PDF
            Chunk chunk = new Chunk("This is the title", chapterFont);
            //chunk.setBackground(BaseColor.GRAY);
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);
            chapter.add(new Paragraph("This is the paragraph", paragraphFont));
            Image image;
            try {
                image = Image.getInstance(RutaImagen);  
                image.setAbsolutePosition(2, 150);
                chapter.add(image);
            } catch (BadElementException ex) {
                System.out.println("Error en la imagen" +  ex);
            }
            
            document.add(chapter);
            document.close();
            System.out.println("¡Se ha generado tu hoja PDF!");
        } catch (DocumentException e) {
            System.out.println("Se ha producido un error al generar un documento: "+ e);
        }finally{
            out.close();
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
