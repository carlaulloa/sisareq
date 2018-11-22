<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page="plantillas/header.jsp"/>
<jsp:include page="plantillas/menu.jsp"/>

<c:url value="/admin_config/form_registrar_usuario" var="formRegistrarUsuario"/>
<c:url value="/admin_config/form_filtrar_nomuser" var="formBuscarByNomUsuario"/>
<c:url value="/admin_config/form_filtrar_rol" var="formBuscarByRol"/>
<c:url value="/admin_config/form_update_usuario" var="formUpdateUsuario"/>
<c:url value="/admin_config/form_delete_usuario" var="formDeleteUsuario"/>


<style>
    #divSupervisores{
        display: none;
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
                        <h4><i class="fa fa-check"></i> Registro hecho</h4>
                        ${msg}
                    </div>
                </div> 
            </c:when>
            <c:when test="${tipoMsg == 2}">
                <div class="pad margin no-print"> 
                    <div class="alert alert-warning alert-dismissable" style="margin-bottom: 0!important;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4><i class="fa fa-warning"></i> Usuario duplicado</h4>
                        ${msg}
                    </div>
                </div>
            </c:when>
            <c:when test="${tipoMsg == 3}">
                <div class="pad margin no-print"> 
                    <div class="alert alert-error alert-dismissable" style="margin-bottom: 0!important;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4><i class="fa fa-ban"></i> Error</h4>
                        ${msg}
                    </div>
                </div>
            </c:when>
            <c:when test="${tipoMsg == 4}">
                <div class="pad margin no-print"> 
                    <div class="alert alert-success alert-dismissable" style="margin-bottom: 0!important;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4><i class="fa fa-check"></i> Eliminación correcta</h4>
                        ${msg}
                    </div>
                </div>
            </c:when>
            <c:when test="${tipoMsg == 5}">
                <div class="pad margin no-print"> 
                    <div class="alert alert-error alert-dismissable" style="margin-bottom: 0!important;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4><i class="fa fa-ban"></i> Error</h4>
                        ${msg}
                    </div>
                </div>
            </c:when>
            <c:when test="${tipoMsg == 6}">
                <div class="pad margin no-print"> 
                    <div class="alert alert-success alert-dismissable" style="margin-bottom: 0!important;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4><i class="fa fa-check"></i> Actualización correcta</h4>
                        ${msg}
                    </div>
                </div>
            </c:when>
            <c:when test="${tipoMsg == 7}">
                <div class="pad margin no-print"> 
                    <div class="alert alert-error alert-dismissable" style="margin-bottom: 0!important;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4><i class="fa fa-ban"></i> Error</h4>
                        ${msg}
                    </div>
                </div>
            </c:when>
            <c:when test="${tipoMsg == 8}">
                <div class="pad margin no-print"> 
                    <div class="alert alert-error alert-dismissable" style="margin-bottom: 0!important;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4><i class="fa fa-ban"></i> Usuario no existe</h4>
                        ${msg}
                    </div>
                </div>
            </c:when>
        </c:choose>
    </c:if>

    <section class="content ">
        <div class="box-body">         
            <div class="row">
                <div class="col-md-10 color1">
                    <h1 class="espacio">Gestión de usuarios</h1>       
                </div>
                <div class="col-md-2">
                    <br>
                    <a href="#ventana1" class="btn btn-primary " data-toggle="modal">Añadir Usuario</a> 
                    <div class="modal fade" id="ventana1">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button tytle="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Añadir Usuario</h4>
                                </div>
                                <!--contenido de ventana modal-->
                                <form:form role="form" action="${formRegistrarUsuario}" method="POST" class="form-horizontal">
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label for="nombre1" class="control-label col-md-2 col-left">Nombre*</label>
                                            <div class="col-md-10">
                                                <input type="text" name="nombre" class="form-control" id="nombre1" required="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="apellidoPat" class="control-label col-md-2 col-left">Apellido paterno*</label>
                                            <div class="col-md-10">
                                                <input type="text" class="form-control" name="apellidoPat" required="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="apellidoMat" class="control-label col-md-2 col-left">Apellido materno*</label>
                                            <div class="col-md-10">
                                                <input type="text" class="form-control" name="apellidoMat" required="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="nomUsuario" class="control-label col-md-2 col-left">Nombre de usuario*</label>
                                            <div class="col-md-10">
                                                <input type="text" class="form-control" name="nomUsuario" required="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="contrasenia" class="control-label col-md-2 col-left">Contraseña*</label>
                                            <div class="col-md-10">
                                                <input type="password" class="form-control" name="contrasenia" required="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-1 col-left">Rol*</label>
                                            <div class="col-md-6 col-md-offset-1">
                                                <select id="selectorRol" class="form-control" name="roles" id="option" required="true">
                                                    <c:forEach items="${lsRoles}" var="rol">
                                                        <option value = "${rol.id}"> ${rol.descripcion}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div id="divSupervisores" class="form-group">
                                            <label class="control-label col-md-1 col-left">Supervisor*</label>
                                            <div id="" class="col-md-6 col-md-offset-1">
                                                <select name="supervisores" id="supervisores" class="form-control" name="" id="usuarioSupervidor">
                                                    <c:forEach items="${lsSupervisores}" var="supervisor">
                                                        <option value="${supervisor.id}"> ${supervisor.nombre} ${supervisor.apellidoPaterno} ${supervisor.apellidoMaterno} </option>
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
                <form:form action="${formBuscarByNomUsuario}"  role="form" class="form-horizontal" method="POST">  
                    <div class="col-md-4">
                        <input name="nomUser" type="text" class="form-control" placeholder="Filtar por nombre de usuario" required="true">   
                    </div>
                    <div class="col-md-1">
                        <button type="submit" class="btn btn-primary">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>                   
                    </div> 
                </form:form> 
                <form:form action="${formBuscarByRol}"  role="form" class="form-horizontal" method="POST">  
                    <div class="col-md-2">
                        <label for="option">Filtrar por rol</label>
                    </div> 
                    <div class="col-md-4">
                        <div class="form-group">
                            <select id="filtraRoles" class="form-control" name="rolesFiltro" id="option" required="true">
                                <option value="todos"> Todos </option>
                                <c:forEach items="${lsRoles}" var="rol">
                                    <option value = "${rol.id}"> ${rol.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <button type="submit" class="btn btn-primary">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </div>
                </form:form> 
            </div>

            <div class="row">
                <div class="col-md-12">
                    <br><br>
                    <table class="table  table-hover ">
                        <tr class="active info ">
                            <th># ID</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Rol</th>
                            <th>Supervisor</th>
                            <th>Opciones</th>
                        </tr>
                        <c:forEach items="${lsUsuarios}" var="usuario">
                            <tr>
                                <td>${usuario.id}</td>
                                <td>${usuario.nombre}</td>
                                <td>${usuario.apellidoPaterno} ${usuario.apellidoMaterno}</td>
                                <td>${usuario.rol.descripcion}</td>
                                <c:choose>
                                    <c:when test="${usuario.supervisor!=null}">
                                        <td>${usuario.supervisor.nombre} ${usuario.supervisor.apellidoPaterno} ${usuario.supervisor.apellidoMaterno} </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>-</td>
                                    </c:otherwise>
                                </c:choose>
                                <td>
                                    <a href="#${usuario.id}" class="btn " data-toggle="modal"><img src="<c:url value="/resources/img/modificarUsuario.jpg"/>" alt="x" /></a> 
                                    <div class="modal fade" id="${usuario.id}">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button tytle="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">Modificar Usuario</h4>
                                                </div>
                                                <!--contenido de ventana modal-->
                                                <form:form action="${formUpdateUsuario}" class="form-horizontal" method="POST">
                                                    <input type="hidden" name="idUsuario" value="${usuario.id}">
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <label for="nombre1" class="control-label col-md-2 col-left">Nombre</label>
                                                            <div class="col-md-10">
                                                                <input type="text" class="form-control" id="nombre1" value="${usuario.nombre}" name="nombre">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="apellidoPat" class="control-label col-md-2 col-left">Apellido paterno</label>
                                                            <div class="col-md-10">
                                                                <input type="text" class="form-control" id="apellidoPat" value="${usuario.apellidoPaterno}"name="apellidoPat">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="apellidoMat" class="control-label col-md-2 col-left">Apellido materno</label>
                                                            <div class="col-md-10">
                                                                <input type="text" class="form-control" id="apellidoMat" value="${usuario.apellidoMaterno}" name="apellidoMat">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="nomUsuario" class="control-label col-md-2 col-left">Nombre de usuario</label>
                                                            <div class="col-md-10">
                                                                <input type="hidden" value="${usuario.nomUsuario}" name="nomUsuario"/>
                                                                <input type="text" class="form-control" id="nomUsuario" value="${usuario.nomUsuario}" name="nomUsuario" disabled="true">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="contrasenia" class="control-label col-md-2 col-left">Contraseña</label>
                                                            <div class="col-md-10">
                                                                <input type="text" class="form-control" id="contrasenia" value="${usuario.clave}" name="contrasenia">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label col-md-1 col-left">Rol</label>
                                                            <div class="col-md-6 col-md-offset-1">
                                                                <select name="selectorRolUpdate" id="selectorRolUpdate" class="form-control" required="true">
                                                                    <c:forEach items="${lsRoles}" var="rol">
                                                                        <c:choose>
                                                                            <c:when test="${rol.id == usuario.rol.id}">
                                                                                <option value = "${rol.id}" selected> ${rol.descripcion}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value = "${rol.id}"> ${rol.descripcion}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>

                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div> 
                                                        <c:choose>
                                                            <c:when test="${usuario.supervisor!=null}">
                                                                <div id="divSupervisoresUpdate" class="form-group">
                                                                    <label class="control-label col-md-1 col-left">Supervisor</label>
                                                                    <div class="col-md-6 col-md-offset-1">
                                                                        <select name="supervisoresUpdate" id="supervisoresUpdate" class="form-control" name="" >
                                                                            <c:forEach items="${lsSupervisores}" var="supervisor">
                                                                                <c:choose>
                                                                                    <c:when test="${supervisor.id == usuario.supervisor.id}">
                                                                                        <option value="${supervisor.id}" selected> ${supervisor.nombre} ${supervisor.apellidoPaterno} ${supervisor.apellidoMaterno} </option>   
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <option value="${supervisor.id}"> ${supervisor.nombre} ${supervisor.apellidoPaterno} ${supervisor.apellidoMaterno} </option>                                                                            </c:otherwise>
                                                                                </c:choose>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <div id="divSupervisoresUpdate" class="form-group" style="display:none">
                                                                    <label class="control-label col-md-1 col-left">Supervisor</label>
                                                                    <div class="col-md-6 col-md-offset-1">
                                                                        <select name="supervisoresUpdate" id="supervisoresUpdate" class="form-control" name="" >
                                                                            <c:forEach items="${lsSupervisores}" var="supervisor">
                                                                                <option value="${supervisor.id}"> ${supervisor.nombre} ${supervisor.apellidoPaterno} ${supervisor.apellidoMaterno} </option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                            </c:otherwise>
                                                        </c:choose> 
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
                                    <c:if test="${usuario.nomUsuario != pageContext.request.userPrincipal.name}">
                                        <form:form action="${formDeleteUsuario}" method="POST" role="form">
                                            <input type="hidden" value="${usuario.id}" name="idUserDelete"/>
                                            <input type="hidden" value="${usuario.nomUsuario}" name="nomUserDelete"/>
                                            <a href="#" class="btn btnElim" nombreUsuario="${usuario.nomUsuario}"> <img src="<c:url value="/resources/img/eliminarUsuario.jpg"/>"/></a>
                                        </form:form>
                                    </c:if>
                                </td>        
                            </tr>
                        </c:forEach>
                    </table>
                </div> 
            </div>
        </div>
    </section>

</div>
<script src="<c:url value="/resources/js/jQuery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>

<script>

    document.getElementById("tree11").className = "treeview active";
    document.getElementById("item111").className = "active";

    $('.btnElim').click(function () {
        var v = $(this).attr("nombreUsuario");
        if (confirm('¿Esta seguro de eliminar este usuario? ' + v)) {
            $(this).parent().submit();
        }
    });

    $('#selectorRol').change(function () {
        var id = $('#selectorRol').val();
        if (id == '1') {
            document.getElementById('divSupervisores').style.display = "block";
        } else {
            document.getElementById('divSupervisores').style.display = "none";
        }
    });


    $('#selectorRolUpdate').change(function () {
        var id = $('#selectorRolUpdate').val();
        if (id == '1') {
            document.getElementById('divSupervisoresUpdate').style.display = "block";
        } else {
            document.getElementById('divSupervisoresUpdate').style.display = "none";
        }
    });

</script>
<jsp:include page="plantillas/footer.jsp"/>
