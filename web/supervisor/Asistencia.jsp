<%@page import="VO.TrabajadorVO"%>
<%@page import="DAO.TrabajadorDAO"%>
<%@page import="VO.EmpresaVO"%>
<%@page import="DAO.EmpresaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="VO.CapacitacionVO"%>
<%@page import="DAO.CapacitacionDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="es">
    
<head>
    <meta charset="utf-8" />    
    <title>ASISTENCIA CAPACITACIONES</title>     
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        body{ 
            margin-top:40px; 
        }

        .stepwizard-step p {
            margin-top: 10px;
        }

        .stepwizard-row {
            display: table-row;
        }

        .stepwizard {
            display: table;
            width: 100%;
            position: relative;
        }

        .stepwizard-step button[disabled] {
            opacity: 1 !important;
            filter: alpha(opacity=100) !important;
        }

        .stepwizard-row:before {
            top: 14px;
            bottom: 0;
            position: absolute;
            content: " ";
            width: 100%;
            height: 1px;
            background-color: #ccc;
            z-order: 0;

        }

        .stepwizard-step {
            display: table-cell;
            text-align: center;
            position: relative;
        }

        .btn-circle {
          width: 30px;
          height: 30px;
          text-align: center;
          padding: 6px 0;
          font-size: 12px;
          line-height: 1.428571429;
          border-radius: 15px;
        }
    </style>

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
            <h1>Registro de Asistencia</h1>    
            
    <div class="container">
<div class="stepwizard">
    <div class="stepwizard-row setup-panel">
        <div class="stepwizard-step">
            <a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
            <p>Datos Generales</p>
        </div>        
        <div class="stepwizard-step">
            <a href="#step-2" type="button" class="btn btn-default btn-circle" disabled="disabled">2</a>
            <p>Trabajador</p>
        </div>
        <div class="stepwizard-step">
            <a href="#step-3" type="button" class="btn btn-default btn-circle" disabled="disabled">3</a>
            <p>Resúmen</p>
        </div>
    </div>
</div>
<form id="formAsistencia" role="form">
    <div class="row setup-content" id="step-1">
        <div class="col-xs-12">
            <div class="col-md-12">
                <h3>Datos Generales</h3>
                <br>
                <div class="form-group">
                    <label class="control-label">Capacitación:</label>
                    <select id="idcapacitacion" name="idcapacitacion" class="form-control form-control-lg">
                        <option value="-1">Seleccione</option>
                        <%
                                CapacitacionDAO             dao     = new CapacitacionDAO();
                                List<CapacitacionVO>        list    = dao.listar();
                                Iterator<CapacitacionVO>    iter    = list.iterator();
                                CapacitacionVO              vo      = null;
                                while (iter.hasNext()) {
                                                vo = iter.next();                           
                        %>  
                        <option value="<%= vo.getId_capacitacion()%>"><%= vo.getNombre_capacitación() %></option>
                        <%}%>
                    </select>
                </div>
                <div class="form-group">
                    <label class="control-label">Fecha Asistencia</label>                        
                    <input id="fechaAsistencia" type="date" class="form-control" placeholder="dd/mm/yyyy" required="required">
                </div>    
                <div class="form-group">
                    <label class="control-label">Lugar</label>
                    <input id="lugar" maxlength="50" type="text" required="required" class="form-control" placeholder="Ingrese el lugar de realización de la capacitación" />
                </div>
                    <button disabled="true" id="siguiente1" class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Siguiente</button>
            </div>
        </div>
    </div>    
   
    <div class="row setup-content" id="step-2">
        <div class="col-xs-12">
            <div class="col-md-12">
                <h3>Trabajadores</h3>
                    <br>
                    <div class="form-group">
                        <label class="control-label">Seleccione Trabajador</label>
                        <select id="idTrabajador" name="idTrabajador" class="form-control form-control-sm" >
                            <option value="-1">Seleccione</option>
                            <%
                                TrabajadorDAO             dao3     = new TrabajadorDAO();
                                List<TrabajadorVO>        list3    = dao3.listar();
                                Iterator<TrabajadorVO>    iter3    = list3.iterator();
                                TrabajadorVO              vo3      = null;
                                while (iter3.hasNext()) {
                                                                vo3 = iter3.next();                           
                            %>  
                            <option value="<%= vo3.getRut_trabajador()%>" ><%= vo3.getRut_trabajador() %></option>
                            <%}%>
                    </select>
                    </div>
                    <button disabled="true" id="siguiente2" class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Siguiente</button>
            </div>
        </div>
    </div>
    <div class="row setup-content" id="step-3">
        <div class="col-xs-12">
            <div class="col-md-12">
                <h3>Resúmen</h3>
                <button class="btn btn-success btn-lg pull-right" type="submit">Finalizar</button>
                <br>
                Estimado Supervisor,
                <br><br>
                Para la Capacitación: &nbsp;<input size="40" maxlength="40" readonly="true" style="border: white" type="text" id="capacitacionSeleccionada" />&nbsp;
                <br><br>
                ,a realizarse en: &nbsp;<input size="40" maxlength="40" readonly="true" style="border: white" type="text" id="lugarResumen" />&nbsp;
                <br><br>
                ,se agregará a la Lista de Asistencia 
                <br><br>
                el Trabajador con RUT: &nbsp;<input size="40" maxlength="40" readonly="true" style="border: white" type="text" id="trabajadorSeleccionado" />
                <br>  
            </div>
        </div>
    </div>
</form>
</div>
                                
<script type="text/javascript"> 
      
    $('#idcapacitacion').change(function(){
       var idcapacitacion = document.getElementById('idcapacitacion');;
       var idcapacitacionSelect = idcapacitacion.options[idcapacitacion.selectedIndex].value;
                     
       if(idcapacitacionSelect !== -1){  
          $('#siguiente1').attr('disabled', false);
          //document.getElementById('siguiente1').disabled = "false"; 
       }
       
    }); 
    
    $('#idTrabajador').change(function(){
       var idTrabajador = document.getElementById('idTrabajador');;
       var idTrabajadorSelect = idTrabajador.options[idTrabajador.selectedIndex].value;
                     
       if(idTrabajadorSelect !== -1){  
          $('#siguiente2').attr('disabled', false);
          //document.getElementById('siguiente1').disabled = "false"; 
       }       
    }); 
    
    $('#siguiente2').click(function(){         
        var capacitacionSeleccionada = $('select[name="idcapacitacion"] option:selected').text();
        document.getElementById('capacitacionSeleccionada').value = capacitacionSeleccionada;

        var lugarResumen = document.getElementById('lugar').value;
        document.getElementById('lugarResumen').value = lugarResumen;

        trabajadorFinalizar();               
    });      
    
    function trabajadorFinalizar(){
        var idTrabajador = document.getElementById('idTrabajador');
        var trabajadorSelect = idTrabajador.options[idTrabajador.selectedIndex].value;  
        document.getElementById('trabajadorSeleccionado').value = trabajadorSelect;        
    };  
    
    $('#formAsistencia').submit(function () {
        agregarAsistencia();
    });
    
    function agregarAsistencia() {                    
        var idcapacitacion          = $('#idcapacitacion').val();
        var fechaAsistencia         = $('#fechaAsistencia').val();
        var lugar                   = $('#lugar').val();
        var idTrabajador          = $('#idTrabajador').val();
        //alert("idcapacitacion: " + idcapacitacion + " \n " + "fechaAsistencia: " + fechaAsistencia 
        //        + " \n " + "lugar: " + lugar + " \n " + "idTrabajador: " + idTrabajador);    
        $.post('../ServAgregarAsistencia', {
                 idcapacitacion     : idcapacitacion
                ,fechaAsistencia    : fechaAsistencia
                ,lugar              : lugar
                ,idTrabajador       : idTrabajador
        }, function(responseText) {
            //alert(responseText);
            //alert(responseText); 
            //$('#modCapacitacionModificada2').style.display = "block";                       
                //$('#tabla').html(responseText);
        });
    };
    
    function pageLoad() {                    
        //location.reload();
        $('#wait').show();
        window.location = document.URL;
    };
    
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
</script>

<script type="text/javascript">    
    $(document).ready(function () {

    var navListItems = $('div.setup-panel div a'),
            allWells = $('.setup-content'),
            allNextBtn = $('.nextBtn');

    allWells.hide();

    navListItems.click(function (e) {
        e.preventDefault();
        var $target = $($(this).attr('href')),
                $item = $(this);

        if (!$item.hasClass('disabled')) {
            navListItems.removeClass('btn-primary').addClass('btn-default');
            $item.addClass('btn-primary');
            allWells.hide();
            $target.show();
            $target.find('input:eq(0)').focus();
        }
    });

    allNextBtn.click(function(){
        var curStep = $(this).closest(".setup-content"),
            curStepBtn = curStep.attr("id"),
            nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
            curInputs = curStep.find("input[type='text'],input[type='url']"),
            isValid = true;

        $(".form-group").removeClass("has-error");
        for(var i=0; i<curInputs.length; i++){
            if (!curInputs[i].validity.valid){
                isValid = false;
                $(curInputs[i]).closest(".form-group").addClass("has-error");
            }
        }

        if (isValid)
            nextStepWizard.removeAttr('disabled').trigger('click');
    });

    $('div.setup-panel div a.btn-primary').trigger('click');
});
</script>
</body>

</html>

