<%-- 
    Document   : generarInformeVisita
    Created on : 27-nov-2018, 19:42:04
    Author     : Cristian
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Visita_Med"%>
<%@page import="Entidades.Usuario"%>
<%@page import="java.sql.Date"%>
<%@page import="VO.PlanVO"%>
<%@page import="VO.AreaVO"%>
<%@page import="VO.TrabajadorVO"%>
<%@page import="Entidades.Area"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="VO.VisitaMedicaVO"%>
<%@page import="DAO.*"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<jsp:include page="../ServListarAtencionMed" flush="true"></jsp:include>
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
    <div class="sidebar" data-color="purple" data-background-color="white" data-image="./customcss/img/sidebar-1.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo">
        <a href="./menuTrabajador.jsp" class="simple-text logo-normal">
          Menu
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item active  ">
            <a class="nav-link" href="./menuTrabajador.jsp">
              <i class="material-icons">dashboard</i>x
              <p>Inicio</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./menuTrabajador.jsp">
              <i class="material-icons">person</i>
              <p>Menú</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./generarInformeCapacitacion.jsp">
              <i class="material-icons">content_paste</i>
              <p>Generar Informe Capacitacion</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./generarInformeVisita.jsp">
              <i class="material-icons">content_paste</i>
              <p>Informe de Visitas Medicas</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./informeExamenes.jsp">
              <i class="material-icons">content_paste</i>
              <p>Informe de Ex&aacute;menes</p>
            </a>
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
            <a class="navbar-brand" href="./menuTrabajador.jsp">Mis Controles M&eacute;dicos</a>
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
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            
<section>
      <table id="tblCapacitaciones" class="table table-bordered">
                <thead>
                    <tr>
                        <th bgcolor="#D4E6F1" style="width: 80px;"><b>Fecha Visita</b></th>
                        <th bgcolor="#D4E6F1" style="width: 60px;"><b>Rut M&eacute;dico</b></th>
                        <th bgcolor="#D4E6F1" style="width: 70px;"><b>Motivo Consulta</b></th>
			<th bgcolor="#D4E6F1" style="width: 200px;"><b>Observaciones</b></th>
			<th bgcolor="#D4E6F1" style="width: 100px;"><b>Receta</b></th>
                    </tr>
                </thead>
                <%
                    DAOVisita_Med             dao             = new DAOVisita_Med();
                    ArrayList<Visita_Med>        list            = dao.TraerTodos();
                    Iterator<Visita_Med>    iter            =list.iterator();
                    Visita_Med              visitaMed  = null;
                    while (iter.hasNext()) {
                            visitaMed = iter.next();
                %>
                
                <tbody>
                    <tr>
                        <td class="text-center"><%= visitaMed.getFecha_visita() %></td>
                        <td class="text-center"><%= visitaMed.getRut_trabajador() %></td>
                        <td class="text-center"><%= visitaMed.getMotivo_consulta() %></td>
                        <td class="text-center"><%= visitaMed.getObservaciones() %></td>
                        <td class="text-center"><%= visitaMed.getReceta() %></td>
                        </td>
                        <%}%>
                    </tr>
                </tbody>
            </table>
    </section>
          </div>        
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <table>
                    <tr>
                        <td>
                            <button type="button" class="btn btn-info btn-lg">Excel</button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-info btn-lg">PDF</button>
                        </td>
                    </tr>
                </table>
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
              document.write(new Date().getFullYear());
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
