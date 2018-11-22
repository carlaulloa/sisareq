
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin_config/gestion_usuarios" var="gestionUsuario"/>
<c:url value="/admin_config/gestion_servicios" var="gestionServicios"/>
<c:url value="/admin_config/gestion_slas" var="gestionSlas"/>

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
            <li id="tree11" class="treeview">
                <a href="#">
                    <i class="fa fa-ticket" aria-hidden="true" ></i>
                    <span>Usuarios</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li id="item111"><a href="${gestionUsuario}"><i class="fa fa-circle-o"></i> Gestión de usuarios</a></li>
                </ul>
            </li>
            <li id="tree12" class="treeview">
                <a href="#">
                    <i class="fa fa-search"></i>
                    <span>SLA </span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li id="item121"><a href="${gestionSlas}"><i class="fa fa-circle-o"></i> Gestión de SLAs </a></li>
                </ul>
            </li>
            <li id="tree13" class="treeview">
                <a href="#">
                    <i class="fa fa-search"></i>
                    <span>Servicios </span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li id="item131"><a href="${gestionServicios}"><i class="fa fa-circle-o"></i> Gestión de servicios </a></li>
                </ul>
            </li>

            <li class="treeview">
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