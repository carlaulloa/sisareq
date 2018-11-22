<%-- 
    Document   : menuSolicitante
    Created on : 24/10/2016, 12:19:13 AM
    Author     : ULLOA
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/solicitante" var = "viewSolicitante"/>
<c:url value="/solicitante/generar_ticket" var="generarTicket"/>
<c:url value="/solicitante/catalogo" var="catalogo"/>
<c:url value="/solicitante/tickets_generados" var="ticketsGenerados"/>


<aside class="main-sidebar">
    <section class="sidebar">
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<c:url value="/resources/img/user.png"/>" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">

                <p style="font-family:sans-serif;font-size:180%;color:white;">Bienvenido</p> 

                <a href="#"><i class="fa fa-circle text-success"></i> En línea </a>
            </div>
        </div>
        <ul class="sidebar-menu">
            <li class="header">MENU DE NAVEGACION</li>
            <li id="tree1" class="treeview">
                <a href="#">
                    <i class="fa fa-ticket" aria-hidden="true" ></i>
                    <span>Registrar Ticket</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li id="item11"><a href="${catalogo}"><i class="fa fa-circle-o"></i> Consultar Servicios </a></li>
                    <li id="item12"><a href="${generarTicket}"><i class="fa fa-circle-o"></i> Generar Ticket</a></li>
                </ul>
            </li>
            <li id="tree2" class="treeview">
                <a href="#">
                    <i class="fa fa-search"></i>
                    <span>Consultar Tickets </span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li id="item21"><a href="${ticketsGenerados}"><i class="fa fa-circle-o"></i> Tickets Generados </a></li>
                </ul>
            </li>

            <li id="tree3" class="treeview">
                <a href="#">
                    <i class="fa fa-sign-out" aria-hidden="true"></i> <span>Salir Del Sistema</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li>  <a href="javascript:formSubmit()"> <i class="fa fa-circle-o"></i> Cerrar Sesion </a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>