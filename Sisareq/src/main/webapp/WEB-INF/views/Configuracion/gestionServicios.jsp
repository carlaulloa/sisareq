<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<jsp:include page="plantillas/header.jsp"/>
<jsp:include page="plantillas/menu.jsp"/>

<c:url value="/admin_config/form_registrar_servicio" var="formRegistrarServicio"/>
<c:url value="/admin_config/form_filtrar_nomservicio" var="formBuscarByNomServicio"/>
<c:url value="/admin_config/form_filtrar_nivel_1" var="formBuscarByNivel1"/>
<c:url value="/admin_config/form_update_servicio" var="formUpdateServicio"/>
<c:url value="/admin_config/form_delete_servicio" var="formDeleteServicio"/>
<c:url value="/admin_config/update_selector_nivel2" var="ajaxUpdate"/>

<style>
    #btnVerNivel3{
        background: transparent;
        border: none !important;
        font-size:0;
    }

    #h4TituloTabla{
        text-align: center;
        font-weight: bold
    }
</style>

<div class="content-wrapper">


    <!-- contenido -->

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
                    <div class="alert alert-warning alert-dismissable" style="margin-bottom: 0!important;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4><i class="fa fa-warning"></i> ${tituloMsg}</h4>
                        ${msg}
                    </div>
                </div>
            </c:when>
        </c:choose>
    </c:if>

    <section class="content">

        <div class="row">
            <div class="col-md-10 color1">
                <h1 class="espacio">Gestión de servicios</h1>       
            </div>

            <div class="col-md-2">
                <br>
                <a href="#ventana1" class="btn btn-primary " data-toggle="modal">Añadir servicio</a> 
                <div class="modal fade" id="ventana1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button tytle="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title">Añadir Servicio</h4>
                            </div>
                            <!--contenido de ventana modal-->
                            <form:form action="${formRegistrarServicio}" role="form" class="form-horizontal" method="POST" >
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="nombreServicio" class="control-label col-md-2 col-left">Nombre</label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" name="nombreServicio" id="nombreServicio" required="true">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="autorizacion" class="control-label col-md-2">Necesita autorización</label>
                                        <div class="col-md-10">
                                            <label for="radio1" class="radio-inline">
                                                <input type="radio" name="autorizacion1" id="radio1" value="si">Si
                                            </label>

                                            <label for="radio2" class="radio-inline">
                                                <input type="radio" name="autorizacion1" id="radio2" value="no" checked="checked">No
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-2">Nivel 1</label>
                                        <div class="col-md-10">
                                            <select class="form-control" id="serviciosNivel1">
                                                <c:forEach items="${lsServiciosFiltro}" var="servicioPrimerNivel">
                                                    <option value="${servicioPrimerNivel.id}">${servicioPrimerNivel.nombre}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2 ">Nivel 2</label>
                                        <div class="col-md-10">
                                            <select class="form-control" name="serviciosNivel2" id="serviciosNivel2" required="true">
                                                <c:forEach items="${lsServiciosNivel2}" var="servicioNivel2">
                                                    <option value="${servicioNivel2.id}">${servicioNivel2.nombre}</option>
                                                </c:forEach>                                                
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2 ">SLA</label>
                                        <div class="col-md-10">
                                            <select class="form-control" name="slas" id="option">
                                                <c:forEach items="${lsSlas}" var="sla">
                                                    <option value="${sla.id}">${sla.nombre}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <!--contenido footer modal-->
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
            <form:form action="${formBuscarByNomServicio}" role="form" method="POST" class="form-horizontal">
                <div class="col-md-4">
                    <br><br>
                    <input type="text" name="nomServicio" class="form-control" placeholder="Filtar por el nombre del servicio">   
                </div>
                <div class="col-md-8">
                    <br><br>
                    <button type="submit" class="btn btn-primary">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </div> 
            </form:form>
        </div>


        <div class="row">
            <div class="col-md-12">
                <br><br>        
                <label for="option">Servicios de nivel 1</label>
            </div>            
        </div>
        <form:form action="${formBuscarByNivel1}" role="form" method="POST" class="form-horizontal">
            <div class="row">
                <div class="col-md-4">
                    <select name="filtroPrimerNivel" class="form-control" id="option">
                        <c:forEach items="${lsServiciosFiltro}" var="servicioPrimNivel">
                            <option value="${servicioPrimNivel.id}" > ${servicioPrimNivel.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-1">
                    <button type="submit" class="btn btn-primary">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </div>
            </div>
        </form:form>

        <div class="row">
            <br><br>
            <div class="col-md-12">
                <h4 id="h4TituloTabla" >${tituloTabla}</h4>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <table class="table  table-hover ">
                    <tr class="active info ">
                        <th># ID</th>
                        <th>Nombre</th>
                        <th>Nivel</th>
                        <th>Servicio Padre</th>
                        <th>SLA</th>
                        <th>Opciones</th>
                    </tr>

                    <c:forEach items="${lsServiciosTabla}" var="servicio">
                        <tr>
                            <td>${servicio.id}</td>
                            <td>${servicio.nombre}</td>
                            <td>${servicio.nivel}</td>

                            <c:choose>
                                <c:when test="${servicio.servicioPadre != null}">
                                    <td>${servicio.servicioPadre.nombre}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>-</td>
                                </c:otherwise>
                            </c:choose>

                            <td>${servicio.slaBO.nombre}</td>

                            <td>
                                <c:if test="${servicio.nivel == 3}">
                                    <a href="#${servicio.id}" class="btn " data-toggle="modal"><img src="<c:url value="/resources/img/modificarUsuario.jpg"/>" alt="x" /></a> 
                                    <div class="modal fade" id="${servicio.id}">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button tytle="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">Modificar Servicio</h4>
                                                </div>
                                                <!--contenido de ventana modal-->
                                                <form:form action="${formUpdateServicio}" method="POST" role="form" class="form-horizontal">
                                                    <input type="hidden" value="${servicio.id}" name="idServicio" />
                                                    <div class="modal-body">                                                    
                                                        <div class="form-group">
                                                            <label for="nombreServicio" class="control-label col-md-2 col-left">Nombre</label>
                                                            <div class="col-md-10">
                                                                <input type="text" class="form-control" id="nombreServicio" value="${servicio.nombre}" name="nombreServicioUpdate" required="true">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <label for="autorizacion" class="control-label col-md-2">Necesita autorización</label>
                                                            <div class="col-md-10">
                                                                <c:choose>
                                                                    <c:when test="${servicio.autorizacion}">
                                                                        <label for="radio1" class="radio-inline">
                                                                            <input type="radio" name="autorizacion1" value="si" id="radio1" checked="checked">Si
                                                                        </label>
                                                                        <label for="radio2" class="radio-inline">
                                                                            <input type="radio" name="autorizacion1" value="no" id="radio2" >No
                                                                        </label>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <label for="radio1" class="radio-inline">
                                                                            <input type="radio" name="autorizacion1" value="si" id="radio1" >Si
                                                                        </label>
                                                                        <label for="radio2" class="radio-inline">
                                                                            <input type="radio" name="autorizacion1" value="no" id="radio2"checked="checked" >No
                                                                        </label>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label col-md-2">Nivel 1</label>
                                                            <div class="col-md-10">
                                                                <select class="form-control" name="" id="option" disabled>
                                                                    <option value="">${servicio.servicioPadre.servicioPadre.nombre}</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label col-md-2 ">Nivel 2</label>
                                                            <div class="col-md-10">
                                                                <select class="form-control" name="" id="option" disabled>
                                                                    <option value="">${servicio.servicioPadre.nombre}</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label col-md-2 ">SLA</label>
                                                            <div class="col-md-10">
                                                                <select class="form-control" name="slasUpdate" id="option">
                                                                    <c:forEach items="${lsSlas}" var="sla">
                                                                        <c:choose>
                                                                            <c:when test="${servicio.slaBO.nombre eq sla.nombre}">
                                                                                <option value="${sla.id}" selected>${sla.nombre}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${sla.id}">${sla.nombre}</option>
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
                                    <form:form action="${formDeleteServicio}" method="POST" role="form" class="form-horizontal">
                                        <input type="hidden" value="${servicio.id}" name="idServicioDelete"/>
                                        <input type="hidden" value="${servicio.nombre}" name="nomServicioDelete"/>
                                      <!--  <button type="button" class="btnElim" nombreServicio="${servicio.nombre}" >   -->                                         
                                        <a href="#" class="btn btnElim" nombreServicio="${servicio.nombre}"> <img src="<c:url value="/resources/img/eliminarUsuario.jpg"/>"/></a>
                                        <!--  </button> -->
                                    </form:form>
                                </c:if>
                                <c:if test="${servicio.nivel== 2 && servicio.numSubServicios > 0}">
                                    <form:form action="${formBuscarByNivel1}" method="POST" role="form" class="form-horizontal" >
                                        <input  type="hidden" name="filtroPrimerNivel" value="${servicio.id}"/>
                                        <button  id="btnVerNivel3" type="submit">
                                            <a href="#" class="btn "><img alt="" /> Ver de Nivel 3</a>
                                        </button>
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

    document.getElementById("tree13").className = "treeview active";
    document.getElementById("item131").className = "active";

    $('.btnElim').click(function () {
        var v = $(this).attr("nombreServicio");
        if (confirm('¿Esta seguro de eliminar este servicio? ' + v)) {
            $(this).parent().submit();
        }
    });


    $('#serviciosNivel1').change(function () {
        var datos = {id: $("#serviciosNivel1 option:selected").val()};
        $.ajax({
            type: "POST", 
            // .../web-security/admin_config/{}
            // u obtener el contexto + update_selector_nivel2
            url: "update_selector_nivel2",                   
            data: JSON.stringify(datos),
            contentType: 'application/json; charset=utf-8',
            dataType: "json",  
            success: function (response) {
                $("#serviciosNivel2 option").remove();
                $.each(response, function () {
                    $("#serviciosNivel2").append('<option value="' + this.id + '">' + this.nombre + '</option>');
                });
            },
            error: function (e) {
                alert('Error: ' + e);
            }
        });
    });

</script>

<jsp:include page="plantillas/footer.jsp"/>
