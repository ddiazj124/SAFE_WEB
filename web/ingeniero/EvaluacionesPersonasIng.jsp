<%@page import="Entidades.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.EvaluacionDAO"%>
<%@page import="VO.EvaluacionLiteVO"%>
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
    <title>CONSULTA DE EVALUACIÓN DE PERSONAS</title>     
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
        <a class="" href="menuIngeniero.jsp">
            <button id="btnMenu"
                  type="submit" 
                  class="btn btn-lg"                                
                  href="menuIngeniero.jsp"
                  >
                  Menú
          </button> 
       </a>      
        <div class="container" >
            <h1>Consulta de Evaluación de Persona Procesada</h1>    
            
    <div class="container">
<div class="stepwizard">
    <div class="stepwizard-row setup-panel">
        <div class="stepwizard-step">
            <a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
            <p>Empresa</p>
        </div>        
        <div class="stepwizard-step">
            <a href="#step-2" type="button" class="btn btn-default btn-circle" disabled="disabled">2</a>
            <p>Evaluación</p>
        </div>
        <div class="stepwizard-step">
            <a href="#step-3" type="button" class="btn btn-default btn-circle" disabled="disabled">3</a>
            <p>Información</p>
        </div>
        <div class="stepwizard-step">
            <a href="#step-4" type="button" class="btn btn-default btn-circle" disabled="disabled">4</a>
            <p>Observación</p>
        </div>        
    </div>
</div>
<form id="formAsistencia" role="form">
    <div class="row setup-content" id="step-1">
        <div class="col-xs-12">
            <div class="col-md-12">
                <h3>Seleccione Empresa</h3>
                <br>
                <div class="form-group">
                    <label class="control-label">Empresa:</label>
                    <select id="idEmpresa" name="idEmpresa" class="form-control form-control-lg">
                        <option value="-1">Seleccione</option>
                        <%
                                HttpSession z = request.getSession(true);
                                Usuario u = (Usuario)z.getAttribute("datosUsuario");
                                
                                EmpresaDAO                  dao     = new EmpresaDAO();
                                List<EmpresaVO>             list    = dao.empresasEvalPersonaPorUsuario(u.getNombre_usuario());
                                Iterator<EmpresaVO>         iter    = list.iterator();
                                EmpresaVO                   vo      = null;
                                while (iter.hasNext()) {
                                                vo = iter.next();                           
                        %>  
                        <option value="<%= vo.getRut_empresa() %>"><%= vo.getRazon_social()%></option>
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
                <h3>Seleccione Evaluación</h3>
                <br>
                <div class="form-group">
                    <label class="control-label">Evaluación</label>
                    <select id="idEvaluacion" name="idEvaluacion" class="form-control form-control-lg">
                        <option value="-1">Seleccione</option>                        
                    </select>
                </div>
                <button disabled="true" id="siguiente2" class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Siguiente</button>
            </div>
        </div>
    </div>
                     
    <div class="row setup-content" id="step-3">
        <div class="col-xs-12">
            <div class="col-md-12">
                <div id="toPDF">
                    <h3>Información Evaluación</h3>                
                    </br>
                    <textarea style="border-color: transparent" readonly="true" id="evaBusqueda" class="form-control" rows="12" ></textarea>
                </div
                </br></br>
                <button id="siguiente3" class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Siguiente</button>
            </div>
        </div>
    </div>
                    
    <div class="row setup-content" id="step-4">
        <div class="col-xs-12">
            <div class="col-md-12">
                <!--<a href="javascript:genPDF()" class="btn btn-success btn-lg pull-right" type="submit">PDF</a>-->
                <div id="toPDF">
                    <h3>Agregar Observación</h3>                
                    </br>
                    <textarea style="background-color: #efebe9" id="observacion" class="form-control" rows="10" ></textarea>
                </div>
                </br>
                <button id="finalizar" class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Finalizar</button>
            </div>
        </div>
    </div>
</form>
</div>
                                
<script type="text/javascript"> 
      
    $('#idEmpresa').change(function(){
        var idEmpresa = document.getElementById('idEmpresa');;
        var idEmpresaSelect = idEmpresa.options[idEmpresa.selectedIndex].value;
       
        if(idEmpresaSelect !== -1){  
            $('#siguiente1').attr('disabled', false);
            
            var idEmpresaCmb          = $('#idEmpresa').val();
            
            $.post('../ServBuscarEvaluacionProcesadasPorEmpresa', {
                 idEmpresaCmb     : idEmpresaCmb
            }, function(data) {                
                document.getElementById('idEvaluacion').innerHTML = "";
                document.getElementById('idEvaluacion').innerHTML = 
                        "<option value=\'-1\'>Seleccione</option>" + data;
                
            });
       }       
    }); 
    
    $('#idEvaluacion').change(function(){
       var idEvaluacion = document.getElementById('idEvaluacion');
       var idEvaluacionSelect = idEvaluacion.options[idEvaluacion.selectedIndex].value;
                     
       if(idEvaluacionSelect !== -1){  
          $('#siguiente2').attr('disabled', false);
          //document.getElementById('siguiente1').disabled = "false"; 
       }       
    }); 
        
    $('#siguiente2').click(function(){         
        var idEvaluacion          = $('#idEvaluacion').val();
        //console.log('## idEvaluacion: ' + idEvaluacion);
        
        $.post('../ServBuscarEvaluacionPorId', {
             idEvaluacion     : idEvaluacion
        }, function(data) { 
            //console.log(data);
            document.getElementById('evaBusqueda').innerHTML = "";
            document.getElementById('evaBusqueda').innerHTML = data;

        });     
    });
    
    $('#finalizar').click(function(){         
        var observacion     = document.getElementById('observacion').value;
        var idEvaluacion    = $('#idEvaluacion').val();
        console.log('## observacion: ' + observacion + "\n" 
                    + "## idEvaluacion: " + idEvaluacion);
        
        $.post('../ServGrabarObservacion', {
             observacion    : observacion,
             idEvaluacion   : idEvaluacion
        }, function(data) {
            alert('Evaluación finalizada!');  
            genPDF();
            location.reload();
        }); 
    });
    
    function genPDF() {
        var doc = new jsPDF();
        //var lista = document.getElementById('trabajadoresLista1').value;
        
        doc.setFontSize(22);
        doc.text(45, 20, 'Evaluación Finalizada :');
        
        doc.setFontSize(12);
        doc.text(20, 40, "OBSERVACION:");
        
        doc.setFontSize(10);
        doc.text(20, 50, document.getElementById('observacion').value);
        
        doc.setFontSize(10);
        doc.text(20, 90, document.getElementById('evaBusqueda').value);
        
        //doc.setFontSize(10);
        //doc.text(20, 50, lista);  
        
        var imgData = '../customcss/img/LOGO.png';
        doc.addImage(imgData, 'JPEG', 20, 10, 20, 20);
        
        doc.save('Consulta_Evaluacion.pdf');
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

