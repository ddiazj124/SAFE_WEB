<%-- 
    Document   : administrarEvaluaciones
    Created on : 22-oct-2018, 10:47:02
    Author     : Diego
--%>


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
  <link href=".../customcss/demo/demo.css" rel="stylesheet" />
</head>

<body class="">
    
  <div class="wrapper ">
    <div class="sidebar" data-color="purple" data-background-color="white" data-image="../assets/img/sidebar-1.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo">
        <a href="./menuIngeniero.jsp" class="simple-text logo-normal">
          Menu
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="./menuIngeniero.jsp">
              <i class="material-icons">dashboard</i>
              <p>Inicio</p>
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="./administrarEvaluaciones.jsp">
              <i class="material-icons">content_paste</i>
              <p>Administrar Evaluaciones</p>
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
            <a class="navbar-brand" href="./menuIngeniero.jsp">Inicio</a>
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
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Administrar Evaluación en Terreno</h4>
                  <p class="card-category">Completa el Formulario</p>
                </div>
                <div class="card-body">
                    <form action="" method="post">
                    <div class="row">
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">RUT EMPRESA</label>
                          <select class="form-control" name="sRutEmpresa">
                          <!-- <c:forEach items="${CargarCombo}" var="e">
                                    <option value="${e.rut_empresa}">${e.razon_social}</option>
                            </c:forEach> -->
                                <option value="20385652-9">Empresa Independiente</option>
                          </select>                            
                        </div>
                      </div>
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">TIPO EVALUACION</label>
                          <select name="sTipoEvaluacion" class="form-control">
                             <option value="1">Evaluacion Electrica</option>
                           </select>                            
                        </div>
                      </div>
                    </div>
                      <button type="submit" class="btn btn-primary pull-right">Buscar Evaluación</button>
                    <div class="clearfix"></div>
                  </form>
                </div>
              </div>
            </div>
          </div>         
        </div>
    <div class="col-md-12">
             <div class="card">
                <div class="card-header card-header-primary">
                    <h4 class="card-title ">Evaluaciones en Terreno.</h4>
                    <p class="card-category">Listado de las evaluaciones en terreno.</p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table">
                      <thead class=" text-primary">
                        <th>
                          Número de informe
                        </th>
                        <th>
                          Fecha
                        </th>
                        <th>
                          Descripcion Informe
                        </th>
                        <th>
                          Comentario Ingeniero
                        </th>
                        <th>
                          Ver
                        </th>
                      </thead>
                      <tbody>
                          <c:forEach items="${datosEvaluacion}" var="e">
                              <tr>
                              <td>1</td>
                              <td>10/11/2018</td>
                              <td>Mantención</td>
                              <td>(Sin Comentario)</td>
                              <td>
                                  <form action="#" method="POST">
                                    <input type="hidden" name="id_eval" value="${e.id_ev}"/>
                                    <input type="submit" name="btnVerEva" class="btn btn-primary pull" value="Ver"/>
                                  </form>
                              </td>
                              </tr>
                          </c:forEach>
                      </tbody>
                    </table>
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
            </script> <i class="material-icons"></i>
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
  
  <script>
		$(document).ready(function(){
				$('#ddlAnimal').change(function(){
                                var raza = $(this).val();
                                        
                                $.post( "ServTraerTrabajadores", { trabajador: trabajador})
                                .done(function( data ) {
                                $("#ddlRaza").append(data);
                                        });
				});
                            });
</script>
</body>

</html>
