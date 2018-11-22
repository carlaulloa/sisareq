<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="pageTitle" scope="request" value="Registrar Solución"/>

<t:plantillaIncidentes>
    <jsp:body>
        <legend>Atención de Ticket Nº ${ticket.idTicket}</legend>
            <div class="container-fluid">
                <form class="form-horizontal" action="registrarSolucion" method="post">
                    <div class="form-group">
                        <label for="inputAsunto" class="control-label col-xs-2">Asunto:</label>
                        <div class="col-xs-10">
                            <input type="text" class="form-control" name="asuntoTicket" readonly value="${ticket.asunto}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputDescripcion" class="control-label col-xs-2">Descripción:</label>
                        <div class="col-xs-10">
                            <textarea class="form-control" rows="5" id="comment" readonly name="descTicket"> ${ticket.descripcion}</textarea>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="control-label col-xs-2">Solución:</label>
                        <div class="col-xs-10">
                            <textarea class="form-control" name="descripcion" rows="5" placeholder="Ingrese descripción" required="true"></textarea>
                        </div>
                    </div>
                    
                    <input type="hidden" name="userName" value="${pageContext.request.userPrincipal.name}">
                    <br>
                    <div class="form-group">
                        <label class="control-label col-xs-2"></label>
                        <div class="col-xs-5">
                            <button type="submit" class="btn btn-primary">Guardar solución</button>
                        </div>
                    </div>
                    <input type="hidden" name="idTicketRelacionado" value="${ticket.idTicket}"/>
                </form>
                
                <hr>
                
                <form class="form-horizontal" action="registrarProblema" method="post">
                    <div class="form-group">
                        <label class="control-label col-xs-2">Tratamiento:</label>
                        <div class="col-xs-10">
                            <textarea class="form-control" name="tratamiento" rows="5" placeholder="Descripción " required="true"></textarea>
                        </div>
                    </div>
                    
                    <input type="hidden" name="userName" value="${pageContext.request.userPrincipal.name}">
                    <br>
                    <div class="form-group">
                        <label class="control-label col-xs-2"></label>
                        <div class="col-xs-5">
                            <button type="submit" class="btn btn-primary">Derivar como problema</button>
                        </div>
                    </div>
                    <input type="hidden" name="idTicketRelacionado" value="${ticket.idTicket}"/>
                    <input type="hidden" name="descTicket" value="${ticket.descripcion}"/>
                    <input type="hidden" name="asuntoTicket" value="${ticket.asunto}"/>
                </form>
                
                
            </div>
            
            <a class="btn btn-default" href="verDetalleTicket?idTicket=${ticket.idTicket}">
                Ir a detalle
            </a>
    </jsp:body>
</t:plantillaIncidentes>