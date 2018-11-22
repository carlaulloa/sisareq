<%-- 
    Document   : nodo
    Created on : 14/10/2016, 05:26:08 AM
    Author     : ULLOA
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
    <c:when test="${fn:length(nodo.lsSubServicios) eq 0}">       
        <li value="${nodo.id}"><a id="${nodo.id}"  class="item1" href="#"> ${nodo.nombre} </a> </li>
    </c:when>
    <c:otherwise>        
        <li class="dropdown-submenu"><a href="#">${nodo.nombre}</a> 
            <c:if test="${nodo.lsSubServicios!=null}">
                <ul class="dropdown-menu">
                    <c:forEach var="subServicio" items="${nodo.lsSubServicios}">
                        <c:set var="nodo" value="${subServicio}" scope="request"/>
                        <jsp:include page="nodoMenu.jsp" />
                    </c:forEach>
                </ul>
            </c:if> 
        </li>
    </c:otherwise>
</c:choose>

