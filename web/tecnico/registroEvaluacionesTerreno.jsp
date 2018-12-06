<%-- 
    Document   : registroEvaluacionesTerreno
    Created on : 21-oct-2018, 21:12:18
    Author     : Diego
--%>
<%@page import="Entidades.Usuario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
        HttpSession z = request.getSession(true);
        Usuario u = (Usuario)z.getAttribute("datosUsuario");
        if(u==null){
            response.sendRedirect("../index.jsp");
        }else{
            switch(u.getId_perfil()){
                case 4:
                %>
<jsp:include page="../ServMostrarEvalTerreno" flush="true"></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

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
  <link href="../customcss/demo/demo.css" rel="stylesheet" />
</head>

<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-color="purple" data-background-color="white" data-image="../assets/img/sidebar-1.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo">
        <a href="./menuTecnico.jsp" class="simple-text logo-normal">
          Menu
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="menuTecnico.jsp">
              <i class="material-icons">dashboard</i>
              <p>Inicio</p>
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="registroEvaluacionesTerreno.jsp">
              <i class="material-icons">content_paste</i>
              <p>Registrar Evaluacion Terreno</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="registroEvaluacionesPersonal.jsp">
              <i class="material-icons">content_paste</i>
              <p>Registrar Evaluacion Personal</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./menuEvaluaciones.jsp">
              <i class="material-icons">content_paste</i>
              <p>Listar Evaluaciones</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="../ServMostrarIngresoPregunta">
              <i class="material-icons">content_paste</i>
              <p>Registrar Preguntas</p>
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
            <a class="navbar-brand" href="./menuTecnico.jsp">Inicio</a>
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
      <!-- End Navbar -->
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-8">
            <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Registro Evaluacion en Terreno</h4>
                  <p class="card-category">Completa el Formulario</p>
                </div>
                <div class="card-body">
                    <form action="../ServRegistroEvalTerrenoTecnico" method="post">
                    <div class="row">
                      <div class="col-md-5">
                        <div class="form-group">
                          <label class="bmd-label-floating">TITULO EVALUACION</label>
                          <input type="text" name="txtTitulo" class="form-control" required="true">
                        </div>
                      </div>
                        <div class="col-md-5">
                        <div class="form-group">
                          <label class="bmd-label-floating">Fecha</label>
                          <input type="text" name="txtFecha" class="form-control" value="<%out.println(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));%>">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">EMPRESA</label>
                          <select id="ddlEmpresa" name="ddlEmpresa" class="form-control" required="true">
                            <c:forEach items="${datosEmpresa}" var="e">
                                <option value="${e.rut_empresa}">${e.razon_social}</option>
                            </c:forEach>
                           </select>
                        </div>
                      </div>  
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">DESCRIPCION DE EVALUACION</label>
                          <textarea class="form-control" rows="4" cols="50" name="txtDescripcion" required="true"></textarea>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">DETALLE DE EVALUACION EN TERRENO</label>
                          <textarea class="form-control" rows="4" cols="50" name="txtDescripcionTerreno" required="true"></textarea>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Ingeniero a Cargo</label>
                          <select id="ddlEmpresa" name="ddlIngeniero" class="form-control" required="true">
                          <c:forEach items="${datosIngeniero}" var="i">
                                <option value="${i.rut_ingeniero}">${i.nombre} ${i.apellido}</option>
                            </c:forEach>
                          </select>
                        </div>
                      </div>
                    </div>    
                        <input type="submit" class="btn btn-primary pull-right" value="Registrar Evaluación"/>
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
          <nav class="float-left">
            <ul>
              <li>
                <a href="#">
                  SAFE - Prevencion de Riesgos
                </a>
              </li>
              
            </ul>
          </nav>
          <div class="copyright float-right">
            &copy;
            <script>
              document.write(new Date().getFullYear())
            </script>
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
</body>

</html>

<%
                break;
                default :
                    response.sendRedirect("../index.jsp");   
                break;
            }
            
        }
        %>