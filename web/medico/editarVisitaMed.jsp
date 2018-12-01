<%-- 
    Document   : editarVisitaMed
    Created on : 30-11-2018, 14:08:46
    Author     : Sebastian
--%>

<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<body>    
        <%
        HttpSession z = request.getSession(true);
        Usuario u = (Usuario)z.getAttribute("datosUsuario");
        if(u==null){
            response.sendRedirect("../index.jsp");
        }else{
            switch(u.getId_perfil()){
                case 1:
                    response.sendRedirect("../index.jsp");   
                break;
                
                case 2:
                    response.sendRedirect("../index.jsp");   
                break;
                
                case 3:
                    response.sendRedirect("../index.jsp");   
                break;
                
                case 4:
                    response.sendRedirect("../index.jsp");   
                break;
                
                case 5:
                    response.sendRedirect("../index.jsp");   
                break;
                
                case 6:
                    response.sendRedirect("../index.jsp");   
                break;
                
                case 7:
                %> 
                
                <h1>Hola</h1>
                <% out.println("Bienvenido Usuario: " + u.getNombre_usuario());%>
                
                
                <%
                break;
            }
        }
        %>
</body>
</html>
