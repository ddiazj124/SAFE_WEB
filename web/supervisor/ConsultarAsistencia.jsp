<%@page import="VO.AsistenciaVO"%>
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
    <title>CONSULTA ASISTENCIA CAPACITACIONES</title>     
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
            <h1>Consulta de Asistencia</h1>    
            
    <div class="container">
<div class="stepwizard">
    <div class="stepwizard-row setup-panel">
        <div class="stepwizard-step">
            <a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
            <p>Capacitaciones</p>
        </div>        
        <div class="stepwizard-step">
            <a href="#step-2" type="button" class="btn btn-default btn-circle" disabled="disabled">2</a>
            <p>Trabajadores</p>
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
                <button disabled="true" id="siguiente1" class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Siguiente</button>
            </div>
        </div>
    </div>    
   
    <div class="row setup-content" id="step-2">
        <div class="col-xs-12">
            <div class="col-md-12">
                <h3>Trabajadores</h3>                
                <textarea rows="10" cols="100" name="trabajadoresLista" id="trabajadoresLista1" readonly="true">                                    
                </textarea>
                <button id="siguiente2" class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Siguiente</button>
            </div>
        </div>
    </div>
                     
    <div class="row setup-content" id="step-3">
        <div class="col-xs-12">
            <div class="col-md-12">
                <a href="javascript:genPDF()" class="btn btn-success btn-lg pull-right" type="submit">PDF</a>
                <div id="toPDF">
                    <h3>Listado Asistencia</h3>                
                    <br>
                    Estimado Supervisor,
                    <br>
                    para la capacitación: &nbsp;<input size="40" maxlength="40" readonly="true" style="border: white" type="text" id="capacitacionSeleccionada" />&nbsp;,
                    <br>
                    la lista de asistentes es:
                    <br> 
                    <textarea rows="10" cols="100" id="trabajadoresLista2" readonly="true">                                    
                    </textarea>
                </div>
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
        
    $('#siguiente1').click(function(){         
        var capacitacionSeleccionada = $('select[name="idcapacitacion"] option:selected').text();
        document.getElementById('capacitacionSeleccionada').value = capacitacionSeleccionada;
        consultarAsistencia();     
    });      
   
    
    $('#formAsistencia').submit(function () {
        //generaPDF();
    });
    
    function consultarAsistencia() {                    
        var idcapacitacion          = $('#idcapacitacion').val();
        //alert("idcapacitacion: " + idcapacitacion );  
        $.post('../ServBuscarAsistencia', {
                 idcapacitacion     : idcapacitacion
            }, function(responseText) {
                        
            //alert(responseText);
            document.getElementById('trabajadoresLista1').value = responseText;  
            document.getElementById('trabajadoresLista2').value = responseText;
        });
    };
    
    function genPDF() {
        var doc = new jsPDF();
        var lista = document.getElementById('trabajadoresLista1').value;
        
        doc.setFontSize(22);
        doc.text(45, 20, 'Lista de Asistencia');

        doc.setFontSize(16);
        doc.text(45, 30, 'Capacitación: ' + document.getElementById('capacitacionSeleccionada').value);
        
        doc.setFontSize(10);
        doc.text(20, 50, lista);  
        
        var imgData = '../customcss/img/LOGO.png';
        doc.addImage(imgData, 'JPEG', 20, 10, 20, 20);
        
        doc.save('Lista_Asistencia.pdf');
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
<!-- js para PDF -->
<!--<script src="PDF/js/jspdf.js" type="text/javascript"></script>
<script src="PDF/js/jquery-2.1.3.js" type="text/javascript"></script>
<script src="PDF/js/pdfFromHTML.js" type="text/javascript"></script>-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.1/jspdf.debug.js" integrity="sha384-THVO/sM0mFD9h7dfSndI6TS0PgAGavwKvB5hAxRRvc0o9cPLohB0wb/PTA7LdUHs" crossorigin="anonymous"></script>

</body>

</html>

