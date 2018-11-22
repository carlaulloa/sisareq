<%@tag description="Plantilla para Módulo Atención de Incidentes" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${param.title}</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/AdminLTE.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/_all-skins.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/blue.css"/>">
        
    </head>
    <body class="hold-transition skin-green sidebar-mini">
        <div class="wrapper">
            <header class="main-header">
                <a href="ticketsLista" class="logo">
                    <span class="logo-mini"><b>I</b>NC</span>
                    <span style="font-family:sans-serif" class="logo-lg"><b>Módulo&nbsp;Incidentes</b></span>
                </a>
                <nav class="navbar navbar-static-top" role="navigation">
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="<c:url value="/resources/img/user.png"/>" class="user-image" alt="User Image">
                                    <span style="font-family:sans-serif" class="hidden-xs">${pageContext.request.userPrincipal.name}</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="user-header">
                                        <img src="<c:url value="/resources/img/user.png"/>" class="img-circle" alt="User Image">
                                        <p>
                                            Grupo 1 - Módulo de Incidentes
                                            <small>Ingeniería de Software - 2016 II </small>
                                        </p>
                                    </li>
                                    
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
                    
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
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-search"></i>
                                <span>Consultar Tickets </span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="operador"><i class="fa fa-circle-o"></i> Tickets Generados </a></li>
                            </ul>
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-sign-out" aria-hidden="true"></i> <span>Salir del sistema</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li>  <a href="javascript:formSubmit()"> <i class="fa fa-circle-o"></i> Cerrar sesión </a></li>
                            </ul>
                        </li>
                    </ul>
                </section>
            </aside>
            
            <div class="content-wrapper">
                <jsp:doBody/>
            </div>
            
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Versión</b> 1.0.0
                </div>
                <strong>Copyright &copy; 2016 <a href="#">UNMSM-FISI "Ingeniería de Software Módulo Atención de Incidentes y Requerimientos"</a>.</strong> All rights reserved.
            </footer>
            <div class="control-sidebar-bg"></div>
        </div>
        <script src="<c:url value="/resources/js/jQuery-2.1.4.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/js/fastclick.min.js"/>"></script>
        <script src="<c:url value="/resources/js/app.min.js"/>"></script>
        
        <script src="<c:url value="/resources/js/demo.js"/>"></script>
        <script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>
    </body>
</html>