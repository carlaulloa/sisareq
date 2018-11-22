<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Configuración | Administrador</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
       <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="<c:url value="/resources/css/AdminLTE.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/_all-skins.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/blue.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/morris.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/jquery-jvectormap-1.2.2.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/datepicker3.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/daterangepicker-bs3.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap3-wysihtml5.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/segundabootstrap4.css"/>">
    </head>
    <body class="hold-transition skin-green sidebar-mini">
        
        <c:url value="/logout" var="logoutUrl" />
        <c:url value="/admin_config" var = "viewAdministrador"/>

        
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>
        
        
         <div class="wrapper">
            <header class="main-header">
                <a href="${viewAdministrador}" class="logo">
                    <span class="logo-mini"><b>C</b>NF</span>
                    <span style="font-family:sans-serif" class="logo-lg"><b>Modulo&nbsp;&nbsp;Configuración</b></span>
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
                                    <span style="font-family:sans-serif" class="hidden-xs">Administrador</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="user-header">
                                        <img src="<c:url value="/resources/img/user.png"/>" class="img-circle" alt="User Image">
                                        <p>
                                            Grupo 1 - Modulo de Configuración
                                            <small>Ingeniería de Software - 2016 II </small>
                                        </p>
                                    </li>
                                    <!--
                                    <li class="user-footer">
                                      <div class="pull-right">
                                        <a href="login.html" class="btn btn-default btn-flat">Cerrar Sesión</a>
                                      </div>
                                    </li>
                                    -->
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>