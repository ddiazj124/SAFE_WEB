<%@page import="VO.PlanCapacitacionVO"%>
<%@page import="Entidades.Trabajador"%>
<%@page import="VO.MedicoVO"%>
<%@page import="VO.VisitaMedicaVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.Date"%>
<%@page import="VO.PlanVO"%>
<%@page import="VO.AreaVO"%>
<%@page import="Entidades.Area"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="VO.CapacitacionVO"%>
<%@page import="DAO.*"%>

<!DOCTYPE html>
<html lang="es">
    
<head>
    <meta charset="utf-8" />
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/jquery-latest.js" type="text/javascript"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    
    <title>PLAN ANUAL DE CAPACITACIONES</title>
    
    <!--<link rel="stylesheet" type="text/css" href="CSS.css"> -->
    <style type="text/css"> 
        .preloader {
            background-color    : #D2D2D2;
            opacity             : 0.4;
            width               : 100%; 
            height              : 100%; 
            top                 : 0px; 
            left                : 0px; 
            position            : absolute; 
            z-index             : 10000; 
            text-align          : center;            
        }
    </style> 

</head>

<body >
    <div class="preloader" id="wait">
        <img src="img/loading.gif" width="80" height="80" alt="" style="position: fixed; top: 50%; left: 50%; " />
    </div>
    <!--<div class="preloader"></div>-->
        </br>&nbsp;&nbsp;  
        <a class="" href="menuSupervisor.jsp">
            <button id="btnMenu"
                  type="submit" 
                  class="btn btn-lg"                                
                  href="menuSupervisor.jsp"
                  >
                  Menú
          </button> 
       </a>
        <div class="container" >
            <h1>Plan Anual de Capacitaciones</h1>    
            <button id="btnAgregarPlanCapacitacion"
                    type="submit" 
                    class="btn btn-success"                                
                    data-toggle="modal" 
                    data-target="#modalAgregar">
                    Agregar Plan Anual de Capacitación
            </button>
            <button id="btnExcel"
                    class="btn btn-success"
                    onclick="exportTableToExcel()">                                
                    EXCEL
            </button>
            </br></br>
            
            <table id="tblPlanCapacitaciones" class="table table-bordered">
                <thead>
                    <tr>
                        <th bgcolor="#D4E6F1" class="text-center">ID</th>
                        <th bgcolor="#D4E6F1" class="text-center">DESCRIPCIÓN</th>
                        <th bgcolor="#D4E6F1" class="text-center">FECHA INICIO</th>
                        <th bgcolor="#D4E6F1" class="text-center">FECHA TÉRMINO</th>
                        <th bgcolor="#D4E6F1" class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    PlanCapacitacionDAO             dao                 = new PlanCapacitacionDAO();
                    List<PlanCapacitacionVO>        list                = dao.listar();
                    Iterator<PlanCapacitacionVO>    iter                = list.iterator();
                    PlanCapacitacionVO              planCapacitacionVO  = null;
                    while (iter.hasNext()) {
                            planCapacitacionVO = iter.next();                    
                %> 
                <tbody>
                    <tr>
                        <td class="text-center"><%= planCapacitacionVO.getId_plan() %></td>
                        <td class="text-center"><%= planCapacitacionVO.getNombre_plan() %></td>
                        <td class="text-center"><%= planCapacitacionVO.getFecha_inicio() %></td>
                        <td class="text-center"><%= planCapacitacionVO.getFecha_termino() %></td>
                        <td class="text-center">
                            <button id="btnEditar"
                                    type="button" 
                                    class="btn btn-primary btn-sm" 
                                    data-toggle="modal" 
                                    data-target="#modalEditar">
                                    Editar
                            </button>
                            <button id="btnEliminar"
                                    type="button" 
                                    class="btn btn-warning btn-sm"                                 
                                    data-toggle="modal" 
                                    data-target="#modalEliminar">
                                    Eliminar
                            </button>
                        </td>
                        <%}%>
                    </tr>
                </tbody>
            </table>

            <!-- MODAL AGREGAR PLAN ANUAL DE CAPACITACIÓN-->
            <div class="modal fade" id="modalAgregar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLongTitle">Agregar Plan Anual de Capacitación</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <form id="formAgregarPlanCapacitacion" action="" method="" >
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" >Descripción</label>
                          <div class="col-sm-10">
                              <input id="descripcion" type="text" class="form-control form-control-lg" placeholder="Largo máximo 50" maxlength="50" required>
                          </div>
                        </div>                                                       
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Fecha Inicio</label>
                          <div class="col-sm-10">
                            <input id="fechaInicio" type="date" class="form-control form-control-lg" placeholder="dd/mm/yyyy" required>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Fecha Término</label>
                          <div class="col-sm-10">
                            <input id="fechaTermino" type="date" class="form-control form-control-lg" placeholder="dd/mm/yyyy" required>
                          </div>
                        </div> 
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button 
                                id="btnAgregarPlanCpacitacion"                     
                                type="submit" 
                                value="Agregar"
                                class="btn btn-primary">
                                Agregar
                            </button>
                        </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>        

            <!-- MODAL EDITAR PLAN ANUAL DE CAPACITACIÓN-->            
            <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLongTitle">Editar Plan Anual de Capacitación</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <form id="formEditarPlanCapacitacion" action="" method="">
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">ID</label>
                          <div class="col-sm-10">
                              <input id="idEditar" type="email" class="form-control form-control-lg" readonly="true">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" >Descripción</label>
                          <div class="col-sm-10">
                              <input id="descripcionEditar" type="text" class="form-control form-control-lg" placeholder="Largo máximo 50" maxlength="50" required>
                          </div>
                        </div>                                                       
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Fecha Inicio</label>
                          <div class="col-sm-10">
                            <input id="fechaInicioEditar" type="date" class="form-control form-control-lg" placeholder="dd/mm/yyyy" required>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Fecha Término</label>
                          <div class="col-sm-10">
                            <input id="fechaTerminoEditar" type="date" class="form-control form-control-lg" placeholder="dd/mm/yyyy" required>
                          </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button 
                                id="btnGrabarEditPlanCapacitacion"                     
                                type="submit" 
                                value="Grabar"                                
                                class="btn btn-primary">
                                Grabar
                            </button>
                        </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>

            <!-- MODAL ELIMINAR VISITA MEDICA -->
            <div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLongTitle">Eliminar Plan Anual de Capacitación</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <h4>¿Está seguro de eliminar el Plan anual de Capacitación? </h4>
                  </div>
                  <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button 
                            id="btnEliminarPlanCapacitacion"                     
                            type="button" 
                            value="Eliminar"
                            data-dismiss="modal"                            
                            onclick="eliminarPlanCapacitacion()"
                            class="btn btn-primary">
                            Eliminar                            
                        </button>
                    </div>
                </div>
              </div>
            </div>
                        
            <script type="text/javascript">
                //SETIAMOS EL MODAL DE EDICION 
                var table = document.getElementById('tblPlanCapacitaciones'),rIndex;
                for (var i = 0; i < table.rows.length; i++) {
                    table.rows[i].onclick = function(){
                        rIndex = this.rowIndex; 
                        document.getElementById('idEditar').value           = this.cells[0].innerHTML;
                        document.getElementById('descripcionEditar').value  = this.cells[1].innerHTML;
                        document.getElementById('fechaInicioEditar').value  = this.cells[2].innerHTML;
                        document.getElementById('fechaTerminoEditar').value = this.cells[3].innerHTML;
                    };
                }
                //FIN
                
                //EXPORT EXCEL
                function exportTableToExcel() {                
                    var uri = 'data:application/vnd.ms-excel;base64,'
                    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
                    , base64 = function (s) { return window.btoa(unescape(encodeURIComponent(s))) }
                    , format = function (s, c) { return s.replace(/{(\w+)}/g, function (m, p) { return c[p]; }) }

                    var table = 'tblReporte';
                    var name = 'nombre_hoja_calculo';

                    if (!table.nodeType) table = document.getElementById('tblPlanCapacitaciones')
                     var ctx = { worksheet: name || 'Worksheet', table: table.innerHTML }
                     window.location.href = uri + base64(format(template, ctx))
                }; 
                //FIN
                
                function editarPlanCapacitacion() {
                    var idEditar                = $('#idEditar').val();
                    var descripcionEditar       = $('#descripcionEditar').val();
                    var fechaInicioEditar       = $('#fechaInicioEditar').val();
                    var fechaTerminoEditar      = $('#fechaTerminoEditar').val();
                       
                    $.post('../ServEditarPlanCapacitacion', {
                             idEditar           : idEditar
                            ,descripcionEditar  : descripcionEditar
                            ,fechaInicioEditar  : fechaInicioEditar
                            ,fechaTerminoEditar : fechaTerminoEditar
                    }, function(responseText) {
                        location.reload();
                        //alert(responseText); 
                        //$('#modCapacitacionModificada2').style.display = "block";                       
                            //$('#tabla').html(responseText);
                    });
                };
                
                function agregarPlanCapacitacion() {   
                    var descripcion    = $('#descripcion').val();
                    var fechaInicio    = $('#fechaInicio').val();
                    var fechaTermino   = $('#fechaTermino').val();

                    $.post('../ServAgregarPlanCapacitacion', {
                             descripcion    : descripcion
                            ,fechaInicio    : fechaInicio
                            ,fechaTermino   : fechaTermino
                    }, function(responseText) {
                        location.reload();
                        //alert(responseText); 
                        //$('#modCapacitacionModificada2').style.display = "block";                       
                            //$('#tabla').html(responseText);
                    });
                };
                
                function eliminarPlanCapacitacion() {                     
                    var idPlanCapacitacionEliminar = $('#idEditar').val();
                    
                    $.post('../ServEliminarPlanCapacitacion', {
                             idPlanCapacitacionEliminar    : idPlanCapacitacionEliminar
                    }, function(responseText) {
                        location.reload();
                        //alert(responseText); 
                        //$('#modCapacitacionModificada2').style.display = "block";                       
                            //$('#tabla').html(responseText);
                    });
                };
                
                $('#formAgregarPlanCapacitacion').submit(function () {                    
                    agregarPlanCapacitacion();
                });
                
                $('#formEditarPlanCapacitacion').submit(function () {                    
                    editarPlanCapacitacion();
                });
                
                $(document).ready(function () {                                      
                    $('.preloader').fadeOut('fast');
                                
                    $(document).ajaxStart(function () {
                        //$('#wait').show();
                        $('.preloader').fadeOut('fast');
                    });
                    $(document).ajaxStop(function () {
                        //$('#wait').hide();
                        $('.preloader').fadeOut('fast');
                    });
                    $(document).ajaxError(function () {
                        //$('#wait').hide();
                        $('.preloader').fadeOut('fast');
                    });                     
                });
                
                function pageLoad() {                    
                    //location.reload();
                    $('#wait').show();
                    window.location = document.URL;
                };
                
            </script> 
        </div>
        
               
        <!--<div id="wait" style="display: none; width: 100%; height: 100%; top: 100px; left: 0px; position: fixed; z-index: 10000; text-align: center;">
            <img src="img/loading.gif" width="45" height="45" alt="" style="position: fixed; top: 50%; left: 50%;" />
        </div>-->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-latest.js" type="text/javascript"></script>   
        <!-- FIN -->
    
         
</body>

</html>
