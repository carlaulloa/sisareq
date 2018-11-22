<%-- 
    Document   : index
    Created on : 16/09/2016, 05:55:52 PM
    Author     : ULLOA
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <title>UNMSM | Sistema de Atencion de requerimientos </title>
        <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" />
        <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet" />
        <link href="<c:url value="/resources/css/animate.min.css"/>" rel="stylesheet" />
        <link href="<c:url value="/resources/css/style.min.css"/>" rel="stylesheet" />
        <link href="<c:url value="/resources/css/style-responsive.min.css"/>" rel="stylesheet" />
        <link href="<c:url value="/resources/css/default.css"/>" id="theme" rel="stylesheet" />
        <script src="<c:url value="/resources/js/pace.min.js"/>"></script>
    </head>
    <body data-spy="scroll" data-target="#header-navbar" data-offset="51">
        <c:url value="/login"  var="login"> </c:url>
        <c:url value="/" var="index"></c:url>
        <c:url value="/info" var="about"></c:url>
            <div id="page-container" class="fade">
                <div id="header" class="header navbar navbar-transparent navbar-fixed-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a href="${index}" class="navbar-brand">
                            <span class="brand-logo"></span>
                            <span class="brand-text">
                                <span class="text-theme">Facultad de Ingeniería de Sistemas e Informática </span> UNMSM
                            </span>
                        </a>
                    </div>
                    <div class="collapse navbar-collapse" id="header-navbar">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#" data-click="scroll-to-target">La Decana de America</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="home" class="content has-bg home">
                <div class="content-bg">
                    <img src="<c:url value="/resources/img/fisi.png"/>" alt="Home" />
                </div>
                <div class="container home-content">
                    <h1>Bienvenido al Sistema de Atención a Requerimientos</h1>
                    <h3>Control de requerimientos 2016</h3>
                    <a href="${login}" class="btn btn-theme">Iniciar sesión</a> <a href="${about}" class="btn btn-outline">Contáctenos</a><br />
                    <br />
                </div>
            </div>
        </div>
        <script src="<c:url value="/resources/js/jQuery-2.1.4.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery-migrate-1.1.0.min.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery.cookie.js"/>"></script>
        <script src="<c:url value="/resources/js/scrollMonitor.js"/>"></script>
        <script src="<c:url value="/resources/js/apps.min.js"/>"></script>
        <script>
            $(document).ready(function() {
	        App.init();
	    });            
        </script>
    </body>
</html>
