<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="plantillas/header.jsp"/>
<jsp:include page="plantillas/menu.jsp"/>


<c:url value="/admin_config/form_registrar_sla" var="formRegistrarSla"/>
<c:url value="/admin_config/form_filtrar_nombreSla" var="formBuscarByNomSla"/>
<c:url value="/admin_config/form_update_sla" var="formUpdateSla"/>
<c:url value="/admin_config/form_delete_sla" var="formDeleteSla"/>
<c:url value="/admin_config/filtrar_nombre_sla" var="filtrarSla"/>



<div class="content-wrapper">

    <c:if test="${tipoMsg!=null}">
        <c:choose>
            <c:when test="${tipoMsg==1}">
                <div class="pad margin no-print"> 
                    <div class="alert alert-success alert-dismissable" style="margin-bottom: 0!important;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4><i class="fa fa-check"></i> ${tituloMsg}</h4>
                        ${msg}
                    </div>
                </div> 
            </c:when>
            <c:when test="${tipoMsg == 2}">
                <div class="pad margin no-print"> 
                    <div class="alert alert-error alert-dismissable" style="margin-bottom: 0!important;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4><i class="fa fa-ban"></i> ${tituloMsg}</h4>
                        ${msg}
                    </div>
                </div>
            </c:when>
            <c:when test="${tipoMsg == 3}">
                <div class="pad margin no-print"> 
                    <div class="alert alert-warning alert-dismissable" style="margin-bottom: 0!important;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4><i class="fa fa-warning"></i> ${tituloMsg}</h4>
                        ${msg}
                    </div>
                </div>
            </c:when>
        </c:choose>
    </c:if>

    <!-- contenido -->
    <section class="content">
        <div class="row">
            <div class="col-md-10 color1">
                <h1 class="espacio">Gestión de SLA</h1>       
            </div>

            <div class="col-md-2">
                <br>
                <a href="#ventana1" class="btn btn-primary " data-toggle="modal">Añadir SLA</a> 
                <div class="modal fade" id="ventana1">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <div class="modal-header">
                                <button tytle="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title">Añadir SLA</h4>
                            </div>
                            <form:form action="${formRegistrarSla}" method="POST" role="form" class="form-horizontal">
                                <!--contenido de ventana modal-->
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="nombre_sla" class="control-label col-md-2 col-left">SLA</label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" id="nombre_sla" name="nombre_sla" required="true">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-1  ">Tiempo de resolución</label>
                                    </div>
                                    <div class="form-group">
                                        <label for="horas_resolucion" class="control-label col-md-2 col-left">Dias</label>
                                        <div class="col-md-2">
                                            <select class="form-control" name="diasResol" id="horas_resolucion" required="true">
                                                <c:forEach items="${lsDias}" var="itDia">
                                                    <option value="${itDia}">${itDia}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <label for="minutos_resolucion" class="control-label col-md-1 col-left">Hrs</label>
                                        <div class="col-md-2">
                                            <select class="form-control" name="horasResol" id="minutos_resolucion">
                                                <c:forEach items="${lsHoras}" var="itHora">
                                                    <option value="${itHora}">${itHora}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <label for="segundos_resolucion" class="control-label col-md-1  col-left">Min</label>
                                        <div class="col-md-2">
                                            <select class="form-control" name="minutosResol" id="segundos_resolucion" required="true">
                                                <c:forEach items="${lsMinutos}" var="itMinuto">
                                                    <option value="${itMinuto}">${itMinuto}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="control-label col-md-1 ">Tiempo de respuesta</label>
                                    </div>
                                    <div class="form-group">
                                        <label for="horas_resolucion" class="control-label col-md-2 col-left">Dias</label>
                                        <div class="col-md-2">
                                            <select class="form-control" name="diasRpta" id="horas_resolucion" required="true">
                                                <c:forEach items="${lsDias}" var="itDia">
                                                    <option value="${itDia}">${itDia}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <label for="minutos_resolucion" class="control-label col-md-1 col-left">Hrs</label>
                                        <div class="col-md-2">
                                            <select class="form-control" name="horasRpta" id="minutos_resolucion" required="true">
                                                <c:forEach items="${lsHoras}" var="itHora">
                                                    <option value="${itHora}">${itHora}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <label for="segundos_resolucion" class="control-label col-md-1  col-left">Min</label>
                                        <div class="col-md-2">
                                            <select class="form-control" name="minutosRpta" id="segundos_resolucion" required="true">
                                                <c:forEach items="${lsMinutos}" var="itMinuto">
                                                    <option value="${itMinuto}">${itMinuto}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <!--contenido-->
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary">Guardar</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>  
            </div>
        </div>

        <div class="row">
            <form:form action="${filtrarSla}" method="POST"  role="form" class="form-horizontal" id="filtroSla">     
                <div class="col-md-4">
                    <br><br>                    
                    <input type="text" name="nombreSla" class="form-control" placeholder="Filtar por nombre de SLA" id="filtroNombre" required="true">   
                </div>
                <div class="col-md-1">
                    <br><br>
                    <button type="submit" class="btn btn-primary">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </div>
            </form:form> 
            <div class="col-md-7"></div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <br><br>
                <table class="table  table-hover ">
                    <tr class="active info ">
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Tiempo de resolución</th>
                        <th>Tiempo de respuesta</th>
                        <th>Estado</th>
                        <th>Opciones</th>
                    </tr>

                    <c:forEach items="${lsSlas}" var="sla">
                        <tr>
                            <td>${sla.id}</td>
                            <td>${sla.nombre}</td>
                            <td> ${sla.resolucionDias}  Dias  ${sla.resolucionHoras} Hrs ${sla.resolucionMinutos} Mins</td>
                            <td>  ${sla.respuestaDias}  Dias  ${sla.respuestaHoras} Hrs ${sla.respuestaMinutos} Mins</td>
                            <c:choose>
                                <c:when test="${sla.estado}">
                                    <td>Activado</td>
                                </c:when>
                                <c:otherwise>
                                    <td>Desactivado</td>
                                </c:otherwise>
                            </c:choose>                        
                            <td>
                                <c:if test="${sla.estado}"> 
                                    <a href="#${sla.id}" class="btn " data-toggle="modal"><img src="<c:url value="/resources/img/modificarUsuario.jpg"/>" alt="x" /></a> 
                                    <div class="modal fade" id="${sla.id}">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button tytle="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">Modificar SLA</h4>
                                                </div>
                                                <!--contenido de ventana modal-->
                                                <form:form action="${formUpdateSla}" method="POST" role="form" class="form-horizontal">
                                                    <div class="modal-body">
                                                        <input type="hidden" value="${sla.id}" name="id_sla"/>
                                                        <div class="form-group">
                                                            <label for="nombre_sla" class="control-label col-md-2 col-left">SLA</label>
                                                            <div class="col-md-10">
                                                                <input type="text" class="form-control" id="nombre_sla" value="${sla.nombre}" name="nombre_sla" required="true">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label col-md-2 ">Tiempo de resolución</label>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="horas_resolucion" class="control-label col-md-2 col-left">Dias</label>
                                                            <div class="col-md-2">
                                                                <select class="form-control" name="diasResol" id="horas_resolucion" required="true">
                                                                    <c:forEach items="${lsDias}" var="itDia">
                                                                        <c:choose>
                                                                            <c:when test="${itDia == sla.resolucionDias}">
                                                                                <option value="${itDia}" selected>${itDia}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${itDia}">${itDia}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <label for="minutos_resolucion" class="control-label col-md-1 col-left">Hrs</label>
                                                            <div class="col-md-2">
                                                                <select class="form-control" name="horasResol" id="minutos_resolucion" required="true">
                                                                    <c:forEach items="${lsHoras}" var="itHora">
                                                                        <c:choose>
                                                                            <c:when test="${itHora == sla.resolucionHoras}">
                                                                                <option value="${itHora}" selected>${itHora}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${itHora}">${itHora}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <label for="segundos_resolucion" class="control-label col-md-1  col-left">Min</label>
                                                            <div class="col-md-2">
                                                                <select class="form-control" name="minutosResol" id="segundos_resolucion" required="true">
                                                                    <c:forEach items="${lsMinutos}" var="itMinuto">
                                                                        <c:choose>
                                                                            <c:when test="${itMinuto == sla.resolucionMinutos}">
                                                                                <option value="${itMinuto}" selected>${itMinuto}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${itMinuto}">${itMinuto}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div>


                                                        <div class="form-group">
                                                            <label class="control-label col-md-2 ">Tiempo de respuesta</label>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="horas_resolucion" class="control-label col-md-2 col-left">Dias</label>
                                                            <div class="col-md-2">
                                                                <select class="form-control" name="diasRpta" id="horas_resolucion" required="true">
                                                                    <c:forEach items="${lsDias}" var="itDia">
                                                                        <c:choose>
                                                                            <c:when test="${itDia == sla.respuestaDias}">
                                                                                <option value="${itDia}" selected>${itDia}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${itDia}">${itDia}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <label for="minutos_resolucion" class="control-label col-md-1 col-left">Hrs</label>
                                                            <div class="col-md-2">
                                                                <select class="form-control" name="horasRpta" id="minutos_resolucion" required="true">
                                                                    <c:forEach items="${lsHoras}" var="itHora">
                                                                        <c:choose>
                                                                            <c:when test="${itHora == sla.respuestaHoras}">
                                                                                <option value="${itHora}" selected>${itHora}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${itHora}">${itHora}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <label for="segundos_resolucion" class="control-label col-md-1  col-left">Min</label>
                                                            <div class="col-md-2">
                                                                <select class="form-control" name="minutosRpta" id="segundos_resolucion" required="true">
                                                                    <c:forEach items="${lsMinutos}" var="itMinuto">
                                                                        <c:choose>
                                                                            <c:when test="${itMinuto == sla.respuestaMinutos}">
                                                                                <option value="${itMinuto}" selected>${itMinuto}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${itMinuto}">${itMinuto}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div>                                                        
                                                    </div>
                                                    <!--contenido-->
                                                    <div class="modal-footer">
                                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                                    </div>
                                                </form:form>
                                            </div>
                                        </div>
                                    </div>  
                                    <form:form action="${formDeleteSla}" method="POST" role="form" class="form-horizontal">
                                        <input type="hidden" value="${sla.id}" name="idSlaDelete"/>
                                        <input type="hidden" value="${sla.nombre}" name="nomSlaDelete"/>
                                        <a href="#" class="btn btnElim" nombreSla="${sla.nombre}"> <img src="<c:url value="/resources/img/eliminarUsuario.jpg"/>"/></a>
                                        </form:form>
                                    </c:if>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>



    </section>

</div>

<script src="<c:url value="/resources/js/jQuery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>


<script>

    document.getElementById("tree12").className = "treeview active";
    document.getElementById("item121").className = "active";

    $('.btnElim').click(function () {
        var v = $(this).attr("nombreSla");
        if (confirm('¿Esta seguro de eliminar este SLA? ' + v)) {
            $(this).parent().submit();
        }
    });
/*
    $('#filtroSla').submit(function(evento){
        var datos = {nombre : $('#filtroNombre').val() };
       $.ajax({
            type: "POST", 
            // .../web-security/admin_config/{}
            // u obtener el contexto + update_selector_nivel2
            url: "filtrar_nombre_sla",                   
            data: JSON.stringify(datos),
            contentType: 'application/json; charset=utf-8',
            dataType: "json",  
            success: function (response) {
                alert(response);
            },
            error: function (e) {
                alert('Error: ' + e);
            }
        }
               ); 
     evento.preventDefault();
    });
*/

</script>

<jsp:include page="plantillas/footer.jsp"/>

