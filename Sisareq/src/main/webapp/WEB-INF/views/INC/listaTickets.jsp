<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="pageTitle" scope="request" value="Tickets Disponibles"/>

<t:plantillaIncidentes>
    <jsp:body>
        <legend>Lista de Tickets</legend>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <th class="col-md-1">N°</th>
                    <th class="col-md-2">Asunto</th>
                    <th class="col-md-1">Fecha</th>
                    <th class="col-md-1">Estado</th>
                    <th class="col-md-2">Usuario</th>
                    <th class="col-md-1">Prioridad</th>
                    <th class="col-md-4">Opciones</th>
                </thead>
                <tbody>
                    <c:if test="${not empty tickets}">
                        <c:forEach var="ticket" items="${tickets}" varStatus="status">
                            <tr>
                                <td>
                                    ${status.count}
                                </td>
                                <td>${ticket.asunto}</td>
                                <td>
                                    <fmt:formatDate
                                        value="${ticket.fechaGen}"
                                        pattern="dd/MM/yyyy"/>
                                </td>
                                <td>${ticket.estadoId.nombreEstado}</td>
                                <td>${ticket.usuarioId.nombre} ${ticket.usuarioId.apellidoPat} ${ticket.usuarioId.apellidoMat}</td>
                                <td>${ticket.prioridadId.nombrePrioridad}</td>
                                <td>
                                    <a class="btn btn-default" href="verDetalleTicket?idTicket=${ticket.idTicket}">
                                        Ver detalle
                                    </a>
                                    <c:if test="${(ticket.estadoId.idEstado ne 4)}">
                                        <a class="btn btn-default" href="registroSolucion?idTicket=${ticket.idTicket}">
                                            Registrar solución
                                        </a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </div>
    </jsp:body>
</t:plantillaIncidentes>