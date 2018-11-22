<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="pageTitle" scope="request" value="Detalle Ticket"/>

<t:plantillaIncidentes>
    <jsp:body>
        <legend>Detalle de Ticket Nº ${ticket.idTicket}</legend>
        <div class="container-fluid">
            <form class="form-horizontal">
                <div class="form-group" >
                    <label for="inputDate" class="control-label col-xs-2">Fecha:</label>
                    <div class="col-xs-10">
                         <p class = "form-control-static">${ticket.fechaGen}</p>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="inputAsunto" class="control-label col-xs-2">Asunto:</label>
                    <div class="col-xs-10">
                        <input type="text" class="form-control" readonly value="${ticket.asunto}">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="inputDescripcion" class="control-label col-xs-2">Descripción:</label>
                    <div class="col-xs-10">
                        <textarea class="form-control" rows="5" id="comment" readonly> ${ticket.descripcion}</textarea>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="inputSol" class="control-label col-xs-2">Solicitante:</label>
                    <div class="col-xs-10">
                         <p class = "form-control" readonly>${ticket.usuarioId.nombre} ${ticket.usuarioId.apellidoPat} ${ticket.usuarioId.apellidoMat}</p>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="inputEstado" class="control-label col-xs-2">Estado:</label>
                    <div class="col-xs-10">
                         <p class = "form-control" readonly> ${ticket.estadoId.nombreEstado}</p>
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="control-label col-xs-2">Prioridad:</label>
                    <div class="col-xs-3">
                        <p class = "form-control" readonly> ${ticket.prioridadId.nombrePrioridad}</p>
                    </div>
                    <div class="col-xs-3" style="font-size: 15pt" hidden>
                        <span class="label label-danger">tiempo para la atencion por vencerse</span>
                    </div>
                </div>
            </form>
            
            <br>
            <br>
            <c:if test="${(ticket.estadoId.idEstado ne 4)}">
                <div class="form-group">
                    <div class="col-xs-4" >
                        <a class="btn btn-primary" href="#">
                            Base de conocimiento
                        </a>
                    </div>
                    <div class="col-xs-4">
                        <a class="btn btn-primary" href="registroSolucion?idTicket=${ticket.idTicket}">
                            Registrar solución
                        </a>
                    </div>
                    <div class="col-xs-4">
                        <a class="btn btn-primary" href="registrarProblema?idTicket=${ticket.idTicket}">
                           Asignar a módulo de problemas
                        </a>
                    </div>
                </div>
            </c:if>
            <c:if test="${ticket.estadoId.idEstado eq 4}">
                <lengend>Solución</lengend>
                <div class="form-group">
                    <label class="control-label col-xs-2">Título</label>
                    <div class="col-xs-10">
                        <input type="text" class="form-control" readonly value="${null}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-xs-2">Descripción</label>
                    <div class="col-xs-10">
                        <input type="text" class="form-control" readonly value="${null}">
                    </div>
                </div>
            </c:if>
                
            
        </div>
    </jsp:body>
</t:plantillaIncidentes>