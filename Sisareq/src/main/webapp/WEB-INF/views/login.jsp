<%-- 
    Document   : login
    Created on : 16/09/2016, 05:56:47 PM
    Author     : ULLOA
--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Log in</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/ionicons.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/AdminLTE.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/blue.css"/>">
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    </head>

    <body class="hold-transition red login-page">
        <s:url value="/login" var="loginForm"></s:url>

            <div class="login-box">
                <div class="login-logo">
                    <a href="#" style=""><b>Acceso al sistema</b></a>
                </div>
            <c:if test="${'fail' eq param.auth}">
                <div class="alert alert-danger">
                    <strong>Error</strong>
                    <h5>Usuario y/o contraseña incorrecta</h5>
                </div>
            </c:if>
            <div class="login-box-body">
                <form name="loginForm" action="${loginForm}" method="POST" >
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" placeholder="Usuario" name="user" id="usuario" required="true">
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" placeholder="Password" name="pasw" id="pass" required="true">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <input type="hidden"                        6
                                   name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </div>
                        <div class="col-md-12">
                            <input  type="submit" class="btn btn-primary btn-block btn-flat" value="Iniciar sesión" />
                            <!--  <a href="#" class="btn btn-primary btn-block btn-flat" id="validacion">Acceder</a> -->
                        </div>
                    </div>
                </form>
            </div>
        </div>
                        
        <script src="<c:url value="/resources/js/jQuery-2.1.4.min.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/js/icheck.min.js"/>"></script>
        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
            });
        </script>
    </body>
</html>