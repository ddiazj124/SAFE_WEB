<%@page contentType="text/html" pageEncoding="UTF-8"%>
﻿﻿<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SUPERVISOR</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>      
    <div id="wrapper">
         <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="adjust-nav">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img style="height: 300%" src="../customcss/img/LOGO.png" />

                    </a>
                    
                </div>
              
                <span class="logout-spn" >
                    <a href="../index.jsp" style="color:#fff;">CERRAR</a> 
                </span>
            </div>
        </div>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">                 
                    <li>
                        <a href="VisitasMedicas.jsp"><i class="fa fa-table "></i>Visitas Médicas<span class="badge"></span></a>
                    </li>
                    <li>
                        <a href="Capacitaciones.jsp"><i class="fa fa-edit "></i>Capacitaciones<span class="badge"></span></a>
                    </li>
                    <li>
                        <a href="PlanCapacitaciones.jsp"><i class="fa fa-qrcode "></i>Plan Capacitaciones</a>
                    </li>                    
                    <li class="active-link">
                        <a href="Asistencia.jsp" ><i class="fa fa-desktop "></i>Registrar Asistencia<span class="badge"></span></a>
                    </li>
                    <li>
                        <a href="ConsultarAsistencia.jsp"><i class="fa fa-table "></i>Consultar Asistencia<span class="badge"></span></a>
                    </li>
                    <li>
                        <a href="ConsultarEvaluacion.jsp"><i class="fa fa-edit "></i>Consultar Evaluación<span class="badge"></span></a>
                    </li>
                </ul>
            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-lg-12">
                     <h2>Supervisor</h2>   
                    </div>
                </div>              
                 <!-- /. ROW  -->
                  <hr />
                <div class="row">                    
                    </div>
                  <!-- /. ROW  --> 
            <div class="row text-center pad-top">
                
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                      <div class="div-square">
                           <a href="VisitasMedicas.jsp" >
                        <i class="fa fa-user fa-5x"></i>
                      <h4>Visitas Médicas</h4>
                      </a>
                      </div>
                </div> 
                  
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                      <div class="div-square">
                           <a href="Capacitaciones.jsp" >
                        <i class="fa fa-comments-o fa-5x"></i>
                      <h4>Capacitaciones</h4>
                      </a>
                      </div>
                </div>        
                
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                      <div class="div-square">
                           <a href="PlanCapacitaciones.jsp" >
                        <i class="fa fa-gear fa-5x"></i>
                      <h4>Plan Capacitaciones</h4>
                      </a>
                      </div>
                </div>             
                  
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                    <div class="div-square">
                        <a href="Asistencia.jsp" >
                            <i class="fa fa-users fa-5x"></i>
                            <h4>Registrar Asistencia Capacitaciones</h4>
                        </a>
                    </div>
                </div>
                
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                    <div class="div-square">
                        <a href="ConsultarAsistencia.jsp" >
                            <i class="fa fa-key fa-5x"></i>
                            <h4>Consultar Asistencia Capacitaciones</h4>
                       </a>
                    </div> 
                </div>
                
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                    <div class="div-square">
                        <a href="ConsultarEvaluacion.jsp" >
                            <i class="fa fa-clipboard fa-5x"></i>
                            <h4>Consultar Evaluación</h4>
                        </a>
                    </div>
                </div>
            </div> 
                  
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
    <div class="footer">
      
    
            <div class="row">
                <div class="col-lg-12" >
                    &copy;  2018 safe.com |
                </div>
            </div>
        </div>
          

     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    
   
</body>
</html>
