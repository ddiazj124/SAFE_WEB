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
    <!--<link href="css/loader.css" rel="stylesheet" type="text/css"/>-->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <title>CAPACITACIONES</title>
    
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
            <h1>Capacitaciones</h1>    
            <button id="btnAgregarCapacitacion"
                    type="submit" 
                    class="btn btn-success"                                
                    data-toggle="modal" 
                    data-target="#modalAgregar">
                    Agregar Capacitación
            </button>
            <button id="btnExcel"
                    class="btn btn-success"
                    onclick="exportTableToExcel()">                                
                    EXCEL
            </button>
            </br></br>
            
            <table id="tblCapacitaciones" class="table table-bordered">
                <thead>
                    <tr>
                        <th bgcolor="#D4E6F1" class="text-center">ID</th>
                        <th bgcolor="#D4E6F1" class="text-center">NOMBRE</th>
                        <th bgcolor="#D4E6F1" class="text-center">FECHA TERMINO</th>
                        <th bgcolor="#D4E6F1" class="text-center">FECHA INICIO</th>
                        <th bgcolor="#D4E6F1" class="text-center">ID AREA</th>
                        <th bgcolor="#D4E6F1" class="text-center">AREA</th>
                        <th bgcolor="#D4E6F1" class="text-center">ID PLAN</th>
                        <th bgcolor="#D4E6F1" class="text-center">PLAN</th>
                        <th bgcolor="#D4E6F1" class="text-center">ACCIONES</th> 
                    </tr>
                </thead>
                <%
                    CapacitacionDAO             dao         = new CapacitacionDAO();
                    List<CapacitacionVO>        list            = dao.listar();
                    Iterator<CapacitacionVO>    iter            =list.iterator();
                    CapacitacionVO              capacitacionVO  = null;
                    while (iter.hasNext()) {
                            capacitacionVO = iter.next();                    
                %> 
                <tbody>
                    <tr>
                        <td class="text-center"><%= capacitacionVO.getId_capacitacion() %></td>
                        <td class="text-center"><%= capacitacionVO.getNombre_capacitación() %></td>
                        <td class="text-center"><%= capacitacionVO.getFecha_termino() %></td>
                        <td class="text-center"><%= capacitacionVO.getFecha_inicio() %></td>
                        <td class="text-center"><%= capacitacionVO.getId_area() %></td>
                        <td class="text-center"><%= capacitacionVO.getArea() %></td>
                        <td class="text-center"><%= capacitacionVO.getId_plan()  %></td>
                        <td class="text-center"><%= capacitacionVO.getPlan() %></td>
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

            <!-- MODAL AGREGAR CAPACITACION-->
            <div class="modal fade" id="modalAgregar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLongTitle">Agregar Capacitación</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <form id="formAgregarCapacitacion" action="" method="" >                     
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" >Nombre</label>
                          <div class="col-sm-10">
                              <input id="nombreAgregar" type="text" class="form-control form-control-lg" placeholder="Largo máximo 30" maxlength="30" required>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Fecha Término</label>
                          <div class="col-sm-10">
                            <input id="fechaTerminoAgregar" type="date" class="form-control form-control-lg" placeholder="dd/mm/yyyy" required>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Fecha Inicio</label>
                          <div class="col-sm-10">
                            <input id="fechaInicioAgregar" type="date" class="form-control form-control-lg" placeholder="dd/mm/yyyy" required>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Área</label>
                            <div class="col-sm-10">                            
                                <select id="areaAgregar" class="form-control form-control-lg">
                                <%
                                    AreaDAO             daoArea1     = new AreaDAO();
                                    List<AreaVO>        listArea1    = daoArea1.listar();
                                    Iterator<AreaVO>    iterArea1    = listArea1.iterator();
                                    AreaVO              areaVO1      = null;
                                    while (iterArea1.hasNext()) {
                                            areaVO1 = iterArea1.next();                           
                                %>  
                                    <option value="<%= areaVO1.getId_area() %>"><%= areaVO1.getNombre_area() %></option>
                                <%}%>
                                </select>                            
                            </div>                          
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Plan</label>
                            <div class="col-sm-10">                            
                                <select id="planAgregar" class="form-control form-control-lg">
                                <%
                                    PlanDAO             daoPlan1     = new PlanDAO();
                                    List<PlanVO>        listPlan1    = daoPlan1.listar();
                                    Iterator<PlanVO>    iterPlan1    = listPlan1.iterator();
                                    PlanVO              planVO1      = null;
                                    while (iterPlan1.hasNext()) {
                                            planVO1 = iterPlan1.next();                           
                                %>  
                                    <option value="<%= planVO1.getId_plan()%>"><%= planVO1.getDescripcion()%></option>
                                <%}%>
                                </select>                            
                            </div>                          
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button 
                                id="btnAgregarCapacitacion"                     
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

            <!-- MODAL EDITAR CAPACITACION-->            
            <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLongTitle">Editar Capacitación</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <form id="formEditCapacitacion">
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">ID</label>
                          <div class="col-sm-10">
                              <input id="idCapacitacionEditar" type="email" class="form-control form-control-lg" readonly="true">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" >Nombre</label>
                          <div class="col-sm-10">
                              <input id="nombreEditar" type="text" class="form-control form-control-lg" placeholder="Largo máximo 30" maxlength="30" required>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Fecha Término</label>
                          <div class="col-sm-10">
                            <input id="fechaTerminoEditar" type="date" class="form-control form-control-lg" placeholder="dd/mm/yyyy" required>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Fecha Inicio</label>
                          <div class="col-sm-10">
                            <input id="fechaInicioEditar" type="date" class="form-control form-control-lg" placeholder="dd/mm/yyyy" required>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Área</label>
                            <div class="col-sm-10">                            
                                <select id="areaEditar" class="form-control form-control-lg">
                                <%
                                    AreaDAO             daoArea     = new AreaDAO();
                                    List<AreaVO>        listArea    = daoArea.listar();
                                    Iterator<AreaVO>    iterArea    = listArea.iterator();
                                    AreaVO              areaVO      = null;
                                    while (iterArea.hasNext()) {
                                            areaVO = iterArea.next();                           
                                %>  
                                    <option value="<%= areaVO.getId_area() %>"><%= areaVO.getNombre_area() %></option>
                                <%}%>
                                </select>                            
                            </div>                          
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Plan</label>
                            <div class="col-sm-10">                            
                                <select id="areaPlan" class="form-control form-control-lg">
                                <%
                                    PlanDAO             daoPlan     = new PlanDAO();
                                    List<PlanVO>        listPlan    = daoPlan.listar();
                                    Iterator<PlanVO>    iterPlan    = listPlan.iterator();
                                    PlanVO              planVO      = null;
                                    while (iterPlan.hasNext()) {
                                            planVO = iterPlan.next();                           
                                %>  
                                    <option value="<%= planVO.getId_plan()%>"><%= planVO.getDescripcion()%></option>
                                <%}%>
                                </select>                            
                            </div>                          
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <!--<button 
                                id="btnGrabarEditCapacitacion"                     
                                type="submit" 
                                value="Editar" 
                                data-dismiss="modal"
                                data-toggle="modal" 
                                data-target="#modCapacitacionModificada"                                
                                onclick="editarCapacitacion()"
                                class="btn btn-primary"> 
                                Guardar
                            </button>-->
                            <button 
                                id="btnGrabarEditCapacitacion"                     
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

            <!-- MODAL ELIMINAR CAPACITACION -->
            <div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLongTitle">Eliminar Capacitación</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <h4>¿Está seguro de eliminar la capacitación? </h4>
                  </div>
                  <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button 
                            id="btnEliminarCapacitacion"                     
                            type="button" 
                            value="Eliminar"
                            data-dismiss="modal"                            
                            onclick="eliminarCapacitacion()"
                            class="btn btn-primary">
                            Eliminar                            
                        </button>
                    </div>
                </div>
              </div>
            </div>
            
            <!-- MODAL CACAPACITACION MODIFICADA -->
            <div class="modal fade" id="modCapacitacionModificada" tabindex="-1" role="dialog" 
                 aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLongTitle">Estimado Supervisor</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <h4>Capacitación modificada correctamente</h4>
                  </div>
                  <div class="modal-footer">
                      <button type="button" onclick="pageLoad()" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>                        
                    </div>
                </div>
              </div>
            </div>

            <!-- MODAL CACAPACITACION AGREGADA -->
            <div class="modal fade" id="modCapacitacionAgregada" tabindex="-1" role="dialog" 
                 aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLongTitle">Estimado Supervisor</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <h4>Capacitación agregada correctamente</h4>
                  </div>
                  <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>                        
                    </div>
                </div>
              </div>
            </div>
            
            <!-- MODAL CACAPACITACION ELIMINADA -->
            <div class="modal fade" id="modCapacitacionEliminada" tabindex="-1" role="dialog" 
                 aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLongTitle">Estimado Supervisor</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <h4>Capacitación eliminada correctamente</h4>
                  </div>
                  <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>                        
                    </div>
                </div>
              </div>
            </div>
            
            <script type="text/javascript">
                var table = document.getElementById('tblCapacitaciones'),rIndex;
                for (var i = 0; i < table.rows.length; i++) {
                    table.rows[i].onclick = function(){
                        rIndex = this.rowIndex; 
                        document.getElementById('idCapacitacionEditar').value   = this.cells[0].innerHTML;
                        document.getElementById('nombreEditar').value           = this.cells[1].innerHTML;
                        document.getElementById('fechaTerminoEditar').value     = this.cells[2].innerHTML;
                        document.getElementById('fechaInicioEditar').value      = this.cells[3].innerHTML;
                        document.getElementById('areaEditar').selectedIndex     = (this.cells[4].innerHTML)-1;
                        document.getElementById('areaPlan').selectedIndex       = (this.cells[6].innerHTML)-1;
                    };
                }
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
                
                function editarCapacitacion() {
                    var idCapacitacionEditar    = $('#idCapacitacionEditar').val();
                    var nombreEditar            = $('#nombreEditar').val();
                    var fechaTerminoEditar      = $('#fechaTerminoEditar').val();
                    var fechaInicioEditar       = $('#fechaInicioEditar').val();
                    var fechaInicioEditar       = $('#fechaInicioEditar').val();
                    var areaEditar              = $('#areaEditar').val();
                    var areaPlan                = $('#areaPlan').val();

                    $.post('../ServEditarCapacitaciones', {
                            idCapacitacionEditar    : idCapacitacionEditar
                            ,nombreEditar           : nombreEditar
                            ,fechaTerminoEditar     : fechaTerminoEditar
                            ,fechaInicioEditar      : fechaInicioEditar
                            ,areaEditar             : areaEditar
                            ,areaPlan               : areaPlan
                    }, function(responseText) {                       
                        //alert(responseText); 
                        //$('#modCapacitacionModificada2').style.display = "block";                       
                            //$('#tabla').html(responseText);
                    });
                };
                
                function agregarCapacitacion() {                    
                    var nombreAgregar           = $('#nombreAgregar').val();
                    var fechaTerminoAgregar     = $('#fechaTerminoAgregar').val();
                    var fechaInicioAgregar      = $('#fechaInicioAgregar').val();
                    var areaAgregar             = $('#areaAgregar').val();
                    var planAgregar             = $('#planAgregar').val();

                    $.post('../ServAgregarCapacitacion', {
                             nombreAgregar           : nombreAgregar
                            ,fechaTerminoAgregar    : fechaTerminoAgregar
                            ,fechaInicioAgregar     : fechaInicioAgregar
                            ,areaAgregar            : areaAgregar
                            ,planAgregar            : planAgregar
                    }, function(responseText) {
                        
                        //alert(responseText); 
                        //$('#modCapacitacionModificada2').style.display = "block";                       
                            //$('#tabla').html(responseText);
                    });
                };
                
                function eliminarCapacitacion() {                    
                     var idCapacitacionEliminar    = $('#idCapacitacionEditar').val();

                    $.post('../ServEliminarCapacitacion', {
                             idCapacitacionEliminar    : idCapacitacionEliminar
                    }, function(responseText) {                        
                        location.reload();
                        //alert(responseText); 
                        //$('#modCapacitacionModificada2').style.display = "block";                       
                            //$('#tabla').html(responseText);
                    });
                };
                
                $('#formAgregarCapacitacion').submit(function () {
                    agregarCapacitacion();
                });
                
                $('#formEditCapacitacion').submit(function () {
                    editarCapacitacion();
                });
                                
                //circular load
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
