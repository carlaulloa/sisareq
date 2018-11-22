<%-- 
    Document   : generarTicket
    Created on : 14/10/2016, 05:52:44 AM
    Author     : ULLOA
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../plantillas/solicitante avanzado/header.jsp"/>

<jsp:include page="../plantillas/solicitante avanzado/menu.jsp"/>

<c:url value="/solicitanteAv/form_generar_ticket" var="formGenrarTicketAv"/>



<div class="content-wrapper">
    <section class="content-header">
        <h1>
            Ingreso de datos
            <small>Ticket</small>
        </h1>
    </section>

    <c:if test="${msg!=null}">
        <div class="pad margin no-print"> 
            <div class="alert alert-success alert-dismissable" style="margin-bottom: 0!important;">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4><i class="fa fa-check"></i> Registro hecho!</h4>
                ${msg}
            </div>
        </div> 
    </c:if>

    <section class="content ">

        <div class="row">
            <div class="col-md-12" >
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Registrar ticket</h3>
                    </div>

                    <form:form role="form"  action="${formGenrarTicketAv}" method="POST"  enctype="multipart/form-data">
                        <input type="hidden" name="userName" value="${pageContext.request.userPrincipal.name}" id="userName">

                        <div class="box-body ">
                            <!--Nombre completo de usuario -->
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Usuario*</label>
                                        <input class="form-control" placeholder="Nombres y apellidos" type="text" disabled="true" value="${user.nombre} ${user.apellidoPaterno} ${user.apellidoMaterno}">
                                    </div>
                                </div>
                            </div>
                            <!--Selector se servicios -->
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group ">

                                        <label>Servicio*</label>

                                        <div class="row">
                                            <div class="col-md-3">

                                                <a id="dLabel" role="button" data-toggle="dropdown" class="btn  btn-block btn-primary" data-target="#" href="/page.html">
                                                    Seleccione <span class="caret"></span>
                                                </a>
                                                <ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu" name="servicios" id="servicios">
                                                    <c:forEach items="${lsServicios}" var = "servicio">
                                                        <c:set var="nodo" value="${servicio}" scope="request"/>
                                                        <jsp:include page="nodoMenu.jsp" />                                                                    
                                                    </c:forEach>                                                               
                                                </ul>

                                            </div>
                                            <div class="col-md-9">

                                                <input type="hidden" name="servicioSelected" value="" id="servicioSelected">
                                                <input class="form-control" type="text" name="servicio2" id="servicio2" value="" required>


                                            </div>

                                        </div>
                                    </div>
                                </div>   
                            </div>

                            <!--Asunto -->
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Asunto*</label>
                                        <input class="form-control" placeholder="Ingrese asunto" type="text" name="asunto" id="asunto" required="true">
                                    </div>
                                </div>
                                <!-- Prioridad -->
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Prioridad*</label>
                                        <select class="form-control" name="prioridades" required="true">                                                            
                                            <option value="" disabled selected>Seleccionar</option>
                                            <c:forEach items="${lsPrioridades}" var="prioridad">
                                                <option value="${prioridad.id}">${prioridad.prioridad}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <!-- Descripcion -->
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Descripcion*</label>
                                        <textarea class="form-control" placeholder="Ingrese descripcion" cols="8" rows="5" name="descripcion" id="descripcion" required="true"></textarea>
                                    </div>
                                </div>
                            </div>
                            <!-- Archivo -->
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Archivo</label>
                                        <input  placeholder="Imagenes jpg, png " type="file" name="archivo" id="archivo" accept="image/*"> 
                                    </div>
                                </div>

                            </div>
                            <!-- submit -->
                            <div class="box-footer">
                                <div class="col-md-4"></div>
                                <div class="col-md-4 text-center">
                                    <input  type="submit" class="btn btn-primary btn-block btn-flat" value="Registrar" />
                                </div>
                                <div class="col-md-4"></div>
                            </div>
                        </div>
                    </form:form>  
                    <!-- termina el registro-->  
                </div>
            </div>
        </div>
    </section>   
</div>

<script src="<c:url value="/resources/js/jQuery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>

<script>

    document.getElementById("tree1").className = "treeview active";
    document.getElementById("item12").className = "active";

    $('#servicio2').keydown(function () {
        return false;
    });

    $(".item1").click(function () {
        var valor = $(this).html();
        var text = $(this).parent().val();
        $("#servicio2").val(valor);
        $("#servicioSelected").val(text);
    });


</script>

<jsp:include page="../plantillas/solicitante avanzado/footer.jsp"/>

