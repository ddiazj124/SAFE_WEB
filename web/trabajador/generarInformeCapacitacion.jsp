<%-- 
    Document   : menuTrabajador
    Created on : 22-oct-2018, 10:21:09
    Author     : Diego
--%>
<%@page import="Entidades.Usuario"%>
<%@page import="java.sql.Date"%>
<%@page import="VO.PlanVO"%>
<%@page import="VO.AreaVO"%>
<%@page import="VO.TrabajadorVO"%>
<%@page import="Entidades.Area"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="VO.CapacitacionVO"%>
<%@page import="DAO.*"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.Paragraph"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../customcss/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../customcss/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Safe - Prevenci&oacute;n
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
            <%
        HttpSession z = request.getSession(true);
        Usuario u = (Usuario)z.getAttribute("datosUsuario");
        String nombreUsuario = u.getNombre_usuario();
        if(u==null){
            response.sendRedirect("../index.jsp");
        }else{
            switch(u.getId_perfil()){
                case 1:
                    response.sendRedirect("../index.jsp");   
                break;
                
                case 7:
                    response.sendRedirect("../index.jsp");   
                break;
                
                case 2:
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
                
                case 3:
    %>
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
              <i class="material-icons">dashboard</i>
              <p>Inicio</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./menuTrabajador.jsp">
              <i class="material-icons">person</i>
              <p>Men&uacute;</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./generarInformeCapacitacion.jsp">
              <i class="material-icons">content_paste</i>
              <p>Generar Informe Capacitaci&oacute;n</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./generarInformeVisita.jsp">
              <i class="material-icons">content_paste</i>
              <p>Informe de Visitas M&eacute;dicas</p>
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
              <p>Cerrar Sesi&oacute;n</p>
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
                <table>
                    <tr>
                        <td>
                            <button type="button" class="btn btn-info btn-lg" onClick="exportTableToExcel()">Excel</button>
                        </td>
                        <td>
                            <a href="javascript:pruebaDivAPdf()" class="btn btn-info btn-lg">PDF</a>
                        </td>
                    </tr>
                </table>
          </div>
            <p><% out.println("Bienvenido "+nombreUsuario);%></p>
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
          <div class="row" id="imprimir">
                                      <div class="card card-stats">
                <div class="card-header card-header-warning card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">content_copy</i>
                  </div>
                <p class="card-title">MIS CAPACITACIONES</p>            
    <section>
      <table id="tblCapacitaciones" class="table table-bordered">
                <thead>
                    <tr>
                        <th bgcolor="#D4E6F1" class="text-center text-dark">NOMBRE CAPACITACIÓN</th>
                        <th bgcolor="#D4E6F1" class="text-center text-dark">FECHA TERMINO</th>
                        <th bgcolor="#D4E6F1" class="text-center text-dark">FECHA INICIO</th>
                        <th bgcolor="#D4E6F1" class="text-center text-dark">NOMBRE AREA</th>
                        <th bgcolor="#D4E6F1" class="text-center text-dark">NOMBRE PLAN</th>
                    </tr>
                </thead>
                <%
                    CapacitacionDAO             dao             = new CapacitacionDAO();
                    List<CapacitacionVO>        list            = dao.listarAsc();
                    Iterator<CapacitacionVO>    iter            = list.iterator();
                    CapacitacionVO              capacitacionVO  = null;
                    while (iter.hasNext()) {
                            capacitacionVO = iter.next();                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center text-dark"><%= capacitacionVO.getNombre_capacitación() %></td>
                        <td class="text-center text-dark"><%= capacitacionVO.getFecha_termino() %></td>
                        <td class="text-center text-dark"><%= capacitacionVO.getFecha_inicio() %></td>
                        <td class="text-center text-dark"><%= capacitacionVO.getArea() %></td>
                        <td class="text-center text-dark"><%= capacitacionVO.getPlan() %></td>
                        </td>
                        <%}%>
                    </tr>
                </tbody>
            </table>
    </section>
          </div>
        </div><!--fin card-->
        </div>
      </div>
      <footer class="footer">
        <div class="container-fluid">
          <nav class="float-left">
            <ul>
              <li>
                <a href="#Diego">
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
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
    <script type="text/javascript">
        function exportTableToExcel() {                
                    var uri = 'data:application/vnd.ms-excel;base64,'
                    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
                    , base64 = function (s) { return window.btoa(unescape(encodeURIComponent(s))) }
                    , format = function (s, c) { return s.replace(/{(\w+)}/g, function (m, p) { return c[p]; }) }

                    var table = 'tblReporte';
                    var name = 'nombre_hoja_calculo';

                    if (!table.nodeType) table = document.getElementById('tblCapacitaciones')
                     var ctx = { worksheet: name || 'Worksheet', table: table.innerHTML }
                     window.location.href = uri + base64(format(template, ctx))
                };
    </script>
    
    <script>
        function pruebaDivAPdf() {
            var pdf = new jsPDF('p', 'pt', 'letter');
            pdf.text(200,50,"CAPACITACIONES REALIZADAS");
            pdf.text(200,750,"- Empresas SAFE -");
            source = $('#imprimir')[0];

            specialElementHandlers = {
                '#bypassme': function (element, renderer) {
                    return true
            }
            };
        
            margins = {
                top: 80,
                bottom: 60,
                left: 40,
                width: 522
            };

            pdf.fromHTML(
                source, 
                margins.left, // x coord
                margins.top, { // y coord
                    'width': margins.width, 
                    'elementHandlers': specialElementHandlers
                },

                function (dispose) {
                    pdf.save('MisCapacitaciones.pdf');
                }, margins
            );
        }
</script>
</html>
