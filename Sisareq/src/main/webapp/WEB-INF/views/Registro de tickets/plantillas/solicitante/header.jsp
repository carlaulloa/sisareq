<%-- 
    Document   : header
    Created on : 24/10/2016, 12:18:52 AM
    Author     : ULLOA
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Reg Tickets | Solicitante</title>
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
        <c:url value="/solicitante" var = "viewSolicitante"/>
        <c:url value="/logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>        
        <div class="wrapper">
            <header class="main-header">
                <a href="${viewSolicitante}" class="logo">
                    <span class="logo-mini"><b>T</b>CK</span>
                    <span style="font-family:sans-serif" class="logo-lg"><b>Modulo&nbsp;&nbsp;Tickets</b></span>
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
                                    <span style="font-family:sans-serif" class="hidden-xs">${user.nombre} ${user.apellidoPaterno} ${user.apellidoMaterno}</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="user-header">
                                        <img src="<c:url value="/resources/img/user.png"/>" class="img-circle" alt="User Image">
                                        <p>
                                            Grupo 2 - Modulo de Tickets
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