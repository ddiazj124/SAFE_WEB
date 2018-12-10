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
    <!--<link href="css/loader.css" rel="stylesheet" type="text/css"/>-->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <title>VISITAS MEDICAS</title>
    
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
            <h1>Visitas Médicas</h1>    
            <button id="btnAgregarVisita"
                    type="submit" 
                    class="btn btn-success"                                
                    data-toggle="modal" 
                    data-target="#modalAgregar">
                    Agregar Visita
            </button>
            <button id="btnExcel"
                    class="btn btn-success"
                    onclick="exportTableToExcel()">                                
                    EXCEL
            </button>
            </br></br>
            
            <table id="tblVisitasMedicas" class="table table-bordered">
                <thead>
                    <tr>
                        <th bgcolor="#D4E6F1" class="text-center">ID</th>
                        <th bgcolor="#D4E6F1" class="text-center">RUT MEDICO</th>
                        <th bgcolor="#D4E6F1" class="text-center">NOMBRE MEDICO</th>
                        <th bgcolor="#D4E6F1" class="text-center">RUT TRABAJADOR</th>
                        <th bgcolor="#D4E6F1" class="text-center">MOTIVO CONSULTA</th>
                        <!--<th bgcolor="#D4E6F1" class="text-center">OBSERVACIONES</th>-->
                        <!--<th bgcolor="#D4E6F1" class="text-center">DIAGNOSTICO</th>-->
                        <th bgcolor="#D4E6F1" class="text-center">FECHA VISITA</th>
                        <th bgcolor="#D4E6F1" class="text-center">ID ESTADO</th>
                        <th bgcolor="#D4E6F1" class="text-center">ESTADO</th>
                        <!--<th bgcolor="#D4E6F1" class="text-center">RECETA</th>-->
                        <th bgcolor="#D4E6F1" class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    VisitaMedicaDAO             dao             = new VisitaMedicaDAO();
                    List<VisitaMedicaVO>        list            = dao.listar();
                    Iterator<VisitaMedicaVO>    iter            =list.iterator();
                    VisitaMedicaVO              visitaMedicaVO  = null;
                    while (iter.hasNext()) {
                            visitaMedicaVO = iter.next();                    
                %> 
                <tbody>
                    <tr>
                        <td class="text-center"><%= visitaMedicaVO.getId_visita()%></td>
                        <td class="text-center"><%= visitaMedicaVO.getRut_medico()%></td>
                        <td class="text-center"><%= visitaMedicaVO.getNombre_medico()%></td>
                        <td class="text-center"><%= visitaMedicaVO.getRut_trabajador() %></td>
                        <td class="text-center"><%= visitaMedicaVO.getMotivo_consulta()%></td>
                        <!--<td class="text-center"><%= visitaMedicaVO.getObservaciones() %></td>-->
                        <!--<td class="text-center"><%= visitaMedicaVO.getDiagnostico() %></td>-->
                        <td class="text-center"><%= visitaMedicaVO.getFecha_visita()%></td>
                        <td class="text-center"><%= visitaMedicaVO.getEstado() %></td>
                        <td class="text-center"><%= visitaMedicaVO.getEstado_descripcion() %></td>
                        <!--<td class="text-center"><%= visitaMedicaVO.getReceta() %></td>-->
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

            <!-- MODAL AGREGAR VISITA-->
            <div class="modal fade" id="modalAgregar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLongTitle">Agregar Visita Médica</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <form id="formAgregarVisitaMedica" action="" method="" >                     
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" >Rut Médico</label>
                            <div class="col-sm-10">                            
                                <select id="rutMedico" class="form-control form-control-lg">                                      
                                <%
                                    MedicoDAO           daoMedico    = new MedicoDAO();
                                    List<MedicoVO>      listMedico   = daoMedico.listar();
                                    Iterator<MedicoVO>  iterMedico   = listMedico.iterator();
                                    MedicoVO            medicoVO      = null;
                                    while (iterMedico.hasNext()) {
                                            medicoVO = iterMedico.next();                           
                                %>  
                                    <option value="<%= medicoVO.getRut_medico() %>"><%= medicoVO.getRut_medico() %></option>
                                <%}%>
                                </select>                            
                            </div> 
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" >Trabajador</label>
                            <div class="col-sm-10">                            
                                <select id="rutTrabajador" class="form-control form-control-lg">
                                <%
                                    DAOTrabajador           daoTrabajador   = new DAOTrabajador();
                                    List<Trabajador>        listTrabajador  = daoTrabajador.TraerTodos();
                                    Iterator<Trabajador>    iterTrabajador  = listTrabajador.iterator();
                                    Trabajador              trabajador      = null;
                                    while (iterTrabajador.hasNext()) {
                                            trabajador = iterTrabajador.next();                           
                                %>  
                                    <option value="<%= trabajador.getRut_trabajador() %>" >
                                        <%= trabajador.getRut_trabajador() %>
                                         - <%= trabajador.getNombre() %> <%= trabajador.getApellido() %>
                                    </option>
                                <%}%>
                                </select>                            
                            </div> 
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" >Motivo Consulta</label>
                          <div class="col-sm-10">
                              <input id="motivoConsulta" type="text" class="form-control form-control-lg" placeholder="Largo máximo 50" maxlength="50" required>
                          </div>
                        </div>                                                       
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Fecha Visita</label>
                          <div class="col-sm-10">
                            <input id="fechaVisita" type="date" class="form-control form-control-lg" placeholder="dd/mm/yyyy" required>
                          </div>
                        </div>  
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button 
                                id="btnAgregarVisitaMedica"                     
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

            <!-- MODAL EDITAR VISITA MEDICA-->            
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
                      <form id="formEditVisitaMedica" action="" method="">
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">ID</label>
                          <div class="col-sm-10">
                              <input id="idVisitaMedicaEditar" type="email" class="form-control form-control-lg" readonly="true">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" >Rut Médico</label>
                            <div class="col-sm-10">                            
                                <select id="rutMedicoEditar" class="form-control form-control-lg">                                    
                                <%
                                    MedicoDAO           daoMedico2    = new MedicoDAO();
                                    List<MedicoVO>      listMedico2   = daoMedico2.listar();
                                    Iterator<MedicoVO>  iterMedico2   = listMedico2.iterator();
                                    MedicoVO            medicoVO2      = null;
                                    while (iterMedico2.hasNext()) {
                                            medicoVO2 = iterMedico2.next();                           
                                %>  
                                    <option vaue="<%= medicoVO2.getRut_medico() %>" >
                                        <%= medicoVO2.getRut_medico() %>
                                                                                
                                    </option>
                                <%}%>
                                </select>                            
                            </div> 
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" >Trabajador</label>
                            <div class="col-sm-10">                            
                                <select id="rutTrabajadorEditar" class="form-control form-control-lg">
                                <%
                                    DAOTrabajador           daoTrabajador2   = new DAOTrabajador();
                                    List<Trabajador>        listTrabajador2  = daoTrabajador2.TraerTodos();
                                    Iterator<Trabajador>    iterTrabajador2  = listTrabajador2.iterator();
                                    Trabajador              trabajador2      = null;
                                    while (iterTrabajador2.hasNext()) {
                                            trabajador2 = iterTrabajador2.next();                           
                                %>  
                                    <option value="<%=  trabajador2.getRut_trabajador() %>">
                                        <%= trabajador2.getRut_trabajador() %>
                                         - <%= trabajador2.getNombre() %> <%= trabajador2.getApellido() %>                                         
                                    </option>
                                <%}%>
                                </select>                            
                            </div> 
                        </div>
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" >Motivo Consulta</label>
                          <div class="col-sm-10">
                              <input id="motivoConsultaEditar" type="text" class="form-control form-control-lg" placeholder="Largo máximo 50" maxlength="50" required>
                          </div>
                        </div>                                                       
                        <div class="form-group row">
                          <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Fecha Visita</label>
                          <div class="col-sm-10">
                            <input id="fechaVisitaEditar" type="date" class="form-control form-control-lg" placeholder="dd/mm/yyyy" required>
                          </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <!--<button 
                                id="btnGrabarEditCapacitacion"                     
                                type="button" 
                                value="Editar" 
                                data-dismiss="modal"
                                data-toggle="modal" 
                                data-target="#modCapacitacionModificada"                                
                                onclick="editarCapacitacion()"
                                class="btn btn-primary"> 
                                Guardar
                            </button>-->
                            <button 
                                id="btnGrabarEditVisitaMedica"                     
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
                    <h2 class="modal-title" id="exampleModalLongTitle">Eliminar Visita Médica</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      <h4>¿Está seguro de eliminar la Visita Médica? </h4>
                  </div>
                  <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button 
                            id="btnEliminarCapacitacion"                     
                            type="button" 
                            value="Eliminar"
                            data-dismiss="modal"                            
                            onclick="eliminarVisitaMedica()"
                            class="btn btn-primary">
                            Eliminar                            
                        </button>
                    </div>
                </div>
              </div>
            </div>
            
            <!-- MODAL VISITA MEDICA MODIFICADA -->
            <div class="modal fade" id="modVisitaMedicaModificada" tabindex="-1" role="dialog" 
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
                      <h4>Visita Médica modificada correctamente</h4>
                  </div>
                  <div class="modal-footer">
                      <button type="button" onclick="pageLoad()" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>                        
                    </div>
                </div>
              </div>
            </div>

            <!-- MODAL VISITA MEDICA AGREGADA -->
            <div class="modal fade" id="modVisitaMedicaAgregada" tabindex="-1" role="dialog" 
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
                      <h4>Visita Médica agregada correctamente</h4>
                  </div>
                  <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>                        
                    </div>
                </div>
              </div>
            </div>
            
            <!-- MODAL VISITA MEDICA ELIMINADA -->
            <div class="modal fade" id="modVisitaMedicaEliminada" tabindex="-1" role="dialog" 
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
                      <h4>Visita Médica eliminada correctamente</h4>
                  </div>
                  <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>                        
                    </div>
                </div>
              </div>
            </div>
             
            <script type="text/javascript">
                //SETIAMOS EL MODAL DE EDICION 
                var table = document.getElementById('tblVisitasMedicas'),rIndex;
                for (var i = 0; i < table.rows.length; i++) {
                    table.rows[i].onclick = function(){
                        rIndex = this.rowIndex; 
                        document.getElementById('idVisitaMedicaEditar').value       = this.cells[0].innerHTML;
                        document.getElementById('rutMedicoEditar').value            = this.cells[1].innerHTML;
                        document.getElementById('rutTrabajadorEditar').value        = this.cells[3].innerHTML;
                        document.getElementById('motivoConsultaEditar').value       = this.cells[4].innerHTML;
                        document.getElementById('fechaVisitaEditar').value          = this.cells[5].innerHTML;
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

                    if (!table.nodeType) table = document.getElementById('tblVisitasMedicas')
                     var ctx = { worksheet: name || 'Worksheet', table: table.innerHTML }
                     window.location.href = uri + base64(format(template, ctx))
                }; 
                //FIN
                
                $('#rutMedico').change(function() {
                    //validar por web service
                    var rutMedico         = $('#rutMedico').val();
                    $.post('../ServVerificarMedico', {
                             rutMedico        : rutMedico
                    }, function(data) {
                        //alert('data: ' + data);
                        if(data = 'CERTIFICADO'){
                            alert('doctor Certificado');
                        }
                        else if(data = 'NO_CERTIFICADO'){
                            alert('doctor no Certificado');                           
                        }
                    });
                });
                
                function editarVisitaMedica() {
                    var idVisitaMedicaEditar    = $('#idVisitaMedicaEditar').val();
                    var rutMedicoEditar         = $('#rutMedicoEditar').val();
                    var rutTrabajadorEditar     = $('#rutTrabajadorEditar').val();
                    var motivoConsultaEditar    = $('#motivoConsultaEditar').val();
                    var fechaVisitaEditar       = $('#fechaVisitaEditar').val();
                       
                    $.post('../ServEditarVisitasMedicas', {
                            idVisitaMedicaEditar    : idVisitaMedicaEditar
                            ,rutMedicoEditar        : rutMedicoEditar
                            ,rutTrabajadorEditar    : rutTrabajadorEditar
                            ,motivoConsultaEditar   : motivoConsultaEditar
                            ,fechaVisitaEditar      : fechaVisitaEditar
                    }, function(responseText) {                        
                        location.reload();
                        //alert(responseText); 
                        //$('#modCapacitacionModificada2').style.display = "block";                       
                            //$('#tabla').html(responseText);
                    });
                };
                
                function agregarVisitaMedica() {  
                    var rutMedico       = $('#rutMedico').val();
                    var rutTrabajador   = $('#rutTrabajador').val();
                    var motivoConsulta  = $('#motivoConsulta').val();
                    var fechaVisita     = $('#fechaVisita').val();                    

                    $.post('../ServAgregarVisitaMedica', {
                             rutMedico        : rutMedico
                            ,rutTrabajador    : rutTrabajador
                            ,motivoConsulta   : motivoConsulta
                            ,fechaVisita      : fechaVisita
                    }, function(responseText) {
                        alert('Email enviado al doctor exitosamente!');
                        location.reload();
                    });                    
                };
                
                function eliminarVisitaMedica() {                     
                    var idVisitaMedicaEliminar = $('#idVisitaMedicaEditar').val();
                    
                    $.post('../ServEliminarVisitaMedica', {
                             idVisitaMedicaEliminar    : idVisitaMedicaEliminar
                    }, function(responseText) {
                        location.reload();
                        //alert(responseText); 
                        //$('#modCapacitacionModificada2').style.display = "block";                       
                            //$('#tabla').html(responseText);
                    });
                };
                
                $('#formAgregarVisitaMedica').submit(function () {                    
                    agregarVisitaMedica();
                });
                
                $('#formEditVisitaMedica').submit(function () {                    
                    editarVisitaMedica();
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
