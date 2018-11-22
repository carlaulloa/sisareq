<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="pageTitle" scope="request" value="Éxito"/>

<t:plantillaIncidentes>
    <jsp:body>
        <script>
            window.setTimeout(function(){
                window.location.href = "operador";
            }, 3000);
        </script>
        <legend>Registro exitoso</legend>
            <div class="container-fluid">
                <p>Será redireccionado en unos segundos</p>
            </div>
    </jsp:body>
</t:plantillaIncidentes>