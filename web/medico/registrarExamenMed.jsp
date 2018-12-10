<%-- 
    Document   : editarVisitaMed
    Created on : 30-11-2018, 14:08:46
    Author     : Sebastian
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entidades.Examen"%>
<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../customcss/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../customcss/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Safe - Prevención
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="../customcss/css/material-dashboard.css?v=2.1.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href=".../customcss/demo/demo.css" rel="stylesheet" />
  
</head>
<body class="">
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
                    HttpSession vm = request.getSession(true);
                    Examen examen = (Examen)vm.getAttribute("ExamenMedX");
                %> 
<div class="wrapper ">
    <div class="sidebar" data-color="purple" data-background-color="white" data-image="../assets/img/sidebar-1.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo">
        <a href="./menuMedico.jsp" class="simple-text logo-normal">
          Menu
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="./menuMedico.jsp">
              <i class="material-icons">dashboard</i>
              <p>Inicio</p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="listarAtenciones.jsp">
              <i class="material-icons">content_paste</i>
              <p>Lista Atenciones Medicas</p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="listarExamenes.jsp">
              <i class="material-icons">content_paste</i>
              <p>Lista de Examenes</p>
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="registrarExamenMed.jsp">
              <i class="material-icons">content_paste</i>
              <p>Registrar Examen</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="../index.jsp">
              <i class="material-icons">content_paste</i>
              <p>Cerrar Sesión</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="./menuMedico.jsp">Inicio</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
              <li class="nav-item dropdown">
                <a class="nav-link" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">person</i>
                  <p class="d-lg-none d-md-block">
                    Some Actions
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="#">Perfil</a>
                  <a class="dropdown-item" href="../index.jsp">Salir</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <jsp:include page="../ServMostrarTrabajador" flush="true"></jsp:include>
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Administrar Examen</h4>
                  <p class="card-category"><%out.print(u.getNombre_usuario().toUpperCase() + ", acá podrás crear un examen medico."); %></p>
                </div>
                <div class="card-body">
                    <form action="../ServInsertarExamenMed" method="POST">
                    <div class="row">
                    </div>    
                    <div class="row">
                      <div class="col-md-3">
                        <div class="form-group">
                          <label class="bmd-label-floating">NÚMERO DE VISITA ASOCIADA</label>
                          <select class="form-control" name="cmbVisitaMed">
                              <c:forEach items="${ListarVisitasX}" var="vm">
                                <option value="${vm.id_visita}">${vm.id_visita}</option>
                            </c:forEach>
                          </select>
                        </div>
                      </div>  
                      <div class="col-md-3">
                        <div class="form-group">
                          <label class="bmd-label-floating">FECHA DE LA VISITA</label>
                          <input type="date" name="txtFecha" id="txtFecha" class="form-control"/>
                        </div>
                      </div>
                    </div>
                    <div class="row">    
                        <div class="col-md-6">
                            <div class="form-group">
                              <label class="bmd-label-floating">OBSERVACION</label>
                              <textarea class="form-control" rows="4" cols="50" id="txtObservacion" name="txtObservacion" required ></textarea>
                            </div>
                        </div>
                    </div>    
                    <div class="row">    
                        <div class="col-md-6">
                            <div class="form-group">
                              <label class="bmd-label-floating">RESULTADO</label>
                              <textarea class="form-control" rows="4" cols="50" id="txtResultado" name="txtResultado" required ></textarea>
                            </div>
                        </div>
                    </div>      
                    <button type="submit" class="btn btn-primary pull-right">Registrar Examen Medico</button>
                    <div class="clearfix"></div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <footer class="footer">
        <div class="container-fluid">
          <div class="copyright float-right">
            &copy;
            <script>
              document.write(new Date().getFullYear())
            </script> <i class="material-icons">favorite</i>
          </div>
        </div>
      </footer>
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="../customcss/js/core/jquery.min.js" type="text/javascript"></script>
  <script src="../customcss/js/core/popper.min.js" type="text/javascript"></script>
  <script src="../customcss/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
  <script src="../customcss/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!-- Chartist JS -->
  <script src="../customcss/js/plugins/chartist.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="../customcss/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="../customcss/js/material-dashboard.min.js?v=2.1.0" type="text/javascript"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="../customcss/demo/demo.js"></script>
  
  <script>
    $(document).ready(function() {
      // Javascript method's body can be found in assets/js/demos.js
      md.initDashboardPageCharts();

    });
  </script>
                <%
                break;
            }
        }
        %>
</body>
</html>
