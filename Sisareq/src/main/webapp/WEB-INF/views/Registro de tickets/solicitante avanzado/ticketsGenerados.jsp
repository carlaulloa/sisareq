<%-- 
    Document   : ticketsGenerados
    Created on : 04/11/2016, 08:01:45 AM
    Author     : ULLOA
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page="../plantillas/solicitante avanzado/header.jsp"/>
<jsp:include page="../plantillas/solicitante avanzado/menu.jsp"/>

<c:url value="/solicitanteAv/form_filtrargen_by_rango" var="formFiltrarByRango"/>


<style>
    table th {
        text-align: center;
    }

    table tbody{
        text-align: center;
    }
    
    textarea{
        text-align: left;
    }

</style>


<div class="content-wrapper">
    <section class="content-header">
        <h1>
            Tickets Generados
            <small></small>
        </h1>
        <!--
  <ol class="breadcrumb">
    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
    <li class="active">Intranet</li>
  </ol>
        -->
    </section>

    <section class="content">
        <!-- contenido -->

        <div class="row">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-body"> 
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-12 col-md-offset-2">
                                    <h3>Cargar datos</h3>
                                </div>
                            </div>
                            <form:form id="formFiltroFecha" action="${formFiltrarByRango}" method="POST" role="form" class="form-horizontal">

                                <div class="row">
                                    <fieldset>

                                        <div class="col-md-4 col-md-offset-2">
                                            <div class="form-group">
                                                <label>Fecha Inicio*</label>
                                                <div class="input-group">
                                                    <div class="input-group-addon">
                                                        <i class="fa fa-calendar"></i>
                                                    </div>
                                                    <input name="fechaIni" id="fechai" class="form-control"   type="text" placeholder="MM/DD/AA">
                                                </div>
                                            </div>
                                        </div>


                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Fecha Final*</label>
                                                <div class="input-group">
                                                    <div class="input-group-addon">
                                                        <i class="fa fa-calendar"></i>
                                                    </div>
                                                    <input name="fechaFin" id="fechaf" class="form-control"   type="text" placeholder="MM/DD/AA">
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>

                                </div>
                                <div class="row">
                                    <div class="col-md-4 col-md-offset-5">
                                        <div class="form-group">
                                            <label id="white">______</label>
                                            <div class="input-group">
                                                <input type="button" class="btn btn-primary btn-flat" value="CARGAR" onclick="fechaCorrecta(document.getElementById('fechai').value, document.getElementById('fechaf').value)">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form:form>

                            <div class="row">
                                <div class="col-md-12 col-md-offset-2">
                                    <h3>Buscar datos </h3>
                                </div>
                            </div>

                            <div class="row">
                                <br/>
                            </div>
                            
                            <div class="row">
                                <div class="col-md-8 col-md-offset-2">
                                    <input type="search" class="form-control light-table-filter" id="campobuscar" name="campobuscar" required="true" data-table="order-table">
                                </div>

                                
                            </div>
                        </div>
                        <div class="row">
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <table id="tablaTickets" aria-describedby="example2_info" role="grid" id="example2" class="order-table table table-bordered table-hover dataTable">
                                    <caption style="font-weight: bold;text-align: center;" align="top">${tituloTabla}</caption>
                                    <thead>
                                        <tr role="row">
                                            <th aria-label="Rendering engine: activate to sort column descending" aria-sort="ascending" colspan="1" rowspan="1" aria-controls="example2" tabindex="0" class="sorting_asc">ID</th>
                                            <th aria-label="Browser: activate to sort column ascending" colspan="1" rowspan="1" aria-controls="example2" tabindex="0" class="sorting">Asunto</th>
                                            <th aria-label="CSS grade: activate to sort column ascending" colspan="1" rowspan="1" aria-controls="example2" tabindex="0" class="sorting">Fecha</th>
                                            <th aria-label="CSS grade: activate to sort column ascending" colspan="1" rowspan="1" aria-controls="example2" tabindex="0" class="sorting">Hora</th>
                                            <th aria-label="CSS grade: activate to sort column ascending" colspan="1" rowspan="1" aria-controls="example2" tabindex="0" class="sorting">Estado</th>
                                            <th aria-label="CSS grade: activate to sort column ascending" colspan="1" rowspan="1" aria-controls="example2" tabindex="0" class="sorting">Servicio</th>
                                            <th aria-label="Platform(s): activate to sort column ascending" colspan="1" rowspan="1" aria-controls="example2" tabindex="0" class="sorting">Detalle</th>
                                            <th aria-label="Platform(s): activate to sort column ascending" colspan="1" rowspan="1" aria-controls="example2" tabindex="0" class="sorting">Respuesta</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${lsTickets}" var="ticket">
                                            <tr class="odd" role="row">
                                                <td class="sorting_1">${ticket.id}</td>
                                                <td>${ticket.asunto}</td>
                                                <td>${ticket.fecha}</td>
                                                <td>${ticket.hora}</td>
                                                <td class="sorting_1">${ticket.estado.estado}</td>
                                                <td>${ticket.servicio.nombre}</td>
                                                <td>
                                                    <a href="#${ticket.id}" class="btn " data-toggle="modal"><img src="<c:url value="/resources/img/verDetalle.jpg"/>" alt="50" width="20" height="20" /></a>
                                                    <div class="modal fade" id="${ticket.id}">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <button tytle="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                                    <h4 class="modal-title">Resumen</h4>
                                                                </div>
                                                                <!--contenido de ventana modal-->
                                                                <form class="form-horizontal">
                                                                    <div class="modal-body">
                                                                        <div class="form-group">
                                                                            <label for="nombre1" class="control-label col-md-2 col-left">Usuario</label>
                                                                            <div class="col-md-10">
                                                                                <input type="text" class="form-control" id="usuario" disabled value="${user.nombre} ${user.apellidoPaterno} ${user.apellidoMaterno}">
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="servicio" class="control-label col-md-2 col-left">Servicio</label>
                                                                            <div class="col-md-10">
                                                                                <input type="text" class="form-control" id="servicio" disabled value="${ticket.servicio.nombre}">
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="apellidoPat" class="control-label col-md-2 col-left">Prioridad</label>
                                                                            <div class="col-md-10">
                                                                                <input type="text" class="form-control" id="prioridad" disabled value="${ticket.prioridad.prioridad}">
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="apellidoMat" class="control-label col-md-2 col-left">Aprobado</label>
                                                                            <div class="col-md-10">
                                                                                <c:choose>
                                                                                    <c:when test="${ticket.aprobado}">
                                                                                        <input type="text" class="form-control" id="aprobacion" disabled value="Si">
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <input type="text" class="form-control" id="aprobacion" disabled value="No">
                                                                                    </c:otherwise>
                                                                                </c:choose>                                                                            
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="asunto" class="control-label col-md-2 col-left">Asunto</label>
                                                                            <div class="col-md-10">
                                                                                <input type="text" class="form-control" id="asunto" disabled value="${ticket.asunto}">
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="nomUsuario" class="control-label col-md-2 col-left">Descripción</label>
                                                                            <div class="col-md-10">
                                                                                <!-- <input type="text" class="form-control" id="nomUsuario">-->
                                                                                 <textarea class="form-control" placeholder="Ingrese descripcion" cols="8" rows="5" name="descripcion" id="descripcion" disabled>${ticket.descripcion}</textarea>
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="contrasenia" class="control-label col-md-2 col-left">Archivo</label>
                                                                            <div class="col-md-10">
                                                                                <!-- Link del archivo -->
                                                                                <c:choose >
                                                                                    <c:when test="${ticket.archivo!=null}">
                                                                                        <a href="<c:url value="/descargar-archivo/${ticket.id}" />"  class="" >${ticket.archivo}</a>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <p>No hay archivo cargado.</p>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <!--contenido-->
                                                                </form>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${ticket.estado.estado == 'Cerrado'}">
                                                            <a href="#s${ticket.atencion.id}" class="btn " data-toggle="modal"><img src="<c:url value="/resources/img/siRespuesta.jpg"/>" alt="50" width="40" height="40" /></a> 
                                                            <div class="modal fade" id="s${ticket.atencion.id}">
                                                                <div class="modal-dialog">
                                                                    <div class="modal-content">

                                                                        <div class="modal-header">
                                                                            <button tytle="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                                            <h4 class="modal-title">Respuesta</h4>
                                                                        </div>
                                                                        <!--contenido de ventana modal-->
                                                                        <form class="form-horizontal">
                                                                        <div class="modal-body">
                                                                            <div class="form-group">
                                                                                <label for="nombre1" class="control-label col-md-2 col-left">Fecha</label>
                                                                                <div class="col-md-10">
                                                                                    <input type="text" class="form-control" id="fecha" value="${ticket.atencion.fecha}" disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="apellidoPat" class="control-label col-md-2 col-left">Hora</label>
                                                                                <div class="col-md-10">
                                                                                    <input type="text" class="form-control" id="hora" value="${ticket.atencion.hora}" disabled>
                                                                                </div> 
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="apellidoMat" class="control-label col-md-2 col-left">Descripción</label>
                                                                                <div class="col-md-10">
                                                                                    <textarea class="form-control" placeholder="Ingrese descripcion" cols="8" rows="5" name="descripcion" id="descripcion" disabled>${ticket.atencion.descripcion}</textarea>
                                                                                </div>
                                                                            </div>
                                                                            
                                                                        </div>
                                                                        <!--contenido-->
                                                                        </form>
                                                                        <div class="modal-footer">
                                                                            <!--
                                                                              <button type="button" class="btn btn-primary">Guardar</button>
                                                                            -->
                                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                                                        </div>

                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="#" class="btn " data-toggle="modal"><img src="<c:url value="/resources/img/noRespuesta.jpg"/>" alt="50" width="40" height="40" /></a> 
                                                            </c:otherwise>
                                                        </c:choose>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>


                                    <!--
                                             <tfoot>
                                               <tr><th colspan="1" rowspan="1">Nombre de la Unidad</th><th colspan="1" rowspan="1">SBN</th><th colspan="1" rowspan="1">Estado</th><th colspan="1" rowspan="1">Descripcion</th><th colspan="1" rowspan="1">Marca</th><th colspan="1" rowspan="1">Modelo</th><th colspan="1" rowspan="1">Serie</th><th colspan="1" rowspan="1">Tipo</th><th colspan="1" rowspan="1">Dimension</th><th colspan="1" rowspan="1">Placa</th><th colspan="1" rowspan="1">Color</th><th colspan="1" rowspan="1">Compra</th><th colspan="1" rowspan="1">Pecosa</th><th colspan="1" rowspan="1">Fecha de Adq</th><th colspan="1" rowspan="1">Valor</th></tr>
                                             </tfoot>
                                         
                                    -->
                                </table>
                            </div>
                        </div>

                        
                    </div>   
                </div>
            </div>
        </div>
    </section>
</div>

<script src="<c:url value="/resources/js/jQuery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>

<script>

    document.getElementById("tree2").className = "treeview active";
    document.getElementById("item21").className = "active";


  $(function () {
                                                        $('#fechai').datepicker();
                                                        $('#fechaf').datepicker();
                                                    });
  function fechaCorrecta(fecha1, fecha2) {
//Split de las fechas recibidas para separarlas
    fecha1 = fecha1.replace(/\//g, "-");
    fecha2 = fecha2.replace(/\//g, "-");
     var x = fecha1.split("-");
     var z = fecha2.split("-");

// AQUI COMPARO SI LA FECHA INICIAL ES MAYOR A LA FECHA FINAL 
     if ((Date.parse(fecha1) > Date.parse(fecha2)) || (fecha1.length == 0 || fecha2.length == 0)) {
    //return false; la fecha inicial es mayor 
         alert("Rango de fechas inválido.");
    } else {
     $("#formFiltroFecha").submit();
     }
     }

</script>

<script type="text/javascript">
(function(document) {
  'use strict';

  var LightTableFilter = (function(Arr) {

    var _input;

    function _onInputEvent(e) {
      _input = e.target;
      var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
      Arr.forEach.call(tables, function(table) {
        Arr.forEach.call(table.tBodies, function(tbody) {
          Arr.forEach.call(tbody.rows, _filter);
        });
      });
    }

    function _filter(row) {
      var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
      row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
    }

    return {
      init: function() {
        var inputs = document.getElementsByClassName('light-table-filter');
        Arr.forEach.call(inputs, function(input) {
          input.oninput = _onInputEvent;
        });
      }
    };
  })(Array.prototype);

  document.addEventListener('readystatechange', function() {
    if (document.readyState === 'complete') {
      LightTableFilter.init();
    }
  });

})(document);
</script>

<jsp:include page="../plantillas/solicitante avanzado/footer.jsp"/>


