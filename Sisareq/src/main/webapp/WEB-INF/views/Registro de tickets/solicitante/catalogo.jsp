<%-- 
    Document   : catalogo
    Created on : 28/10/2016, 06:05:02 AM
    Author     : ULLOA
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../plantillas/solicitante/header.jsp"/>

<jsp:include page="../plantillas/solicitante/menu.jsp"/>

<style>
    .nivel {
        display: none;
    }
</style>


<div class="content-wrapper">
    <section class="content-header">
        <h1>
            Servicios
            <small></small>
        </h1>
        <!--
  <ol class="breadcrumb">
    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
    <li class="active">Intranet</li>
  </ol>
        -->
    </section>
    <section class="content">
        <!-- AQUI EMPIEZA LA MODIFICACION-->
        <div class="row">
            <!-- left column -->
            <div class="col-md-4 col-xs-12">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title">Nivel 1</h3> </div>
                    <!-- form start -->
                    <form role="form" class="form_hijos_niveles">
                        <div class="box-body">
                            <c:forEach items="${lsServicios}" var="servicio">
                                <div class="col-lg-12 col-xs-12">
                                    <!-- small box -->
                                    <div idServicio="${servicio.id}" class="small-box bg-aqua item_orden" tipoNivel="1">
                                        <div class="inner">
                                            <h3>1</h3>
                                            <p>${servicio.nombre}</p>
                                        </div>
                                        <div class="icon"> <i class="ion ion-bag"></i> </div> <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a> </div>
                                </div>
                            </c:forEach>
                        </div>

                        <!-- /.box-body -->
                        <!--
      <div class="box-footer">
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
                        -->
                    </form>
                </div>
            </div>
            <!--/.col (left) -->
            <!-- right column -->
            <div class="col-md-4 col-xs-12 nivel_2 nivel">
                <c:forEach items="${lsServicios}" var="servicio">
                    <c:if test="${fn:length(servicio.lsSubServicios) gt 0}">
                        <!-- Horizontal Form -->
                        <div  id="${servicio.id}" class="box box-primary serv_2">
                            <div class="box-header with-border">
                                <h3 class="box-title">Nivel 2</h3> </div>
                            <!-- /.box-header -->
                            <!-- form start -->
                            <form role="form">                               

                                <div class="box-body">
                                    <c:forEach items="${servicio.lsSubServicios}" var = "subServicioNivel2">
                                        <div class="col-lg-12 col-xs-12">
                                            <!-- small box -->
                                            <div idServicio="${subServicioNivel2.id}" class="small-box bg-green item_orden" tipoNivel="2">
                                                <div class="inner">
                                                    <h3>2<sup style="font-size: 20px">%</sup></h3>
                                                    <p>${subServicioNivel2.nombre}</p>
                                                </div>
                                                <div class="icon"> <i class="ion ion-stats-bars"></i> </div> <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a> </div>
                                        </div>
                                    </c:forEach>

                                    <!-- agregar mas si deseas -->
                                </div>
                                <!-- /.box-body -->
                                <!--
              <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
              </div>
                                -->
                            </form>
                        </div>
                    </c:if>
                </c:forEach>
            </div>


            <!--/.col (right) -->
            <div class="col-md-4 col-xs-12 nivel_3 nivel">
                <!-- Horizontal Form -->
                <c:forEach items="${lsServicios}" var="servicio">
                    <c:if test="${fn:length(servicio.lsSubServicios) gt 0}">
                        <c:forEach items="${servicio.lsSubServicios}" var="subServicioNivel2">
                            <c:if test="${fn:length(subServicioNivel2.lsSubServicios) gt 0}">

                                <div id="${subServicioNivel2.id}" class="box box-primary serv_3">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Nivel 3</h3> </div>
                                    <!-- /.box-header -->
                                    <!-- form start -->
                                    <form role="form">
                                        <div class="box-body">
                                            <c:forEach items="${subServicioNivel2.lsSubServicios}" var="subServicioNivel3">
                                                <div class="col-lg-12 col-xs-12">
                                                    <!-- small box -->
                                                    <div idServicio="${subServicioNivel3.id}" class="small-box bg-yellow item_orden" tipoNivel="3">
                                                        <div class="inner">
                                                            <h3>3</h3>
                                                            <p>${subServicioNivel3.nombre}</p>
                                                        </div>
                                                        <div class="icon"> <i class="ion ion-person-add"></i> </div> <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a> </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <!-- /.box-body -->
                                        <!--
                      <div class="box-footer">
                        <button type="submit" class="btn btn-primary">Submit</button>
                      </div>
                                        -->
                                    </form>
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <!-- /.row -->
    </section>
</div>
<!-- fin del conten wraper -->

<script src="<c:url value="/resources/js/jQuery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>

<script>

    document.getElementById("tree1").className = "treeview active";
    document.getElementById("item11").className = "active";

    /*
     $(".item1").click(function () {
     var valor = $(this).html();
     var text = $(this).parent().val();
     $("#servicio2").val(valor);
     $("#servicioSelected").val(text);
     });
     */
    var estadoNivel2 = false;
    var estadoNivel3 = false;
    /*Cuando le damos click a los item que tenga por clase "item_orden me va a ejecutar la funcion"*/
    $(".item_orden").click(function () {
        /*cada item tiene un atributo especial llamado tipoNivel, capturamos su valor con el .attr*/
        var nivel = $(this).attr("tipoNivel");

        var idServicioSelected = $(this).attr("idServicio");

        /*validamos que valor nos trae ese tipo nivel*/
        if (nivel == 1) {
            /*con las variables globales validamos si ya le han dado click, ya que al darle click 
             cambia la variable de true a false, por lo tanto la segunda vez entraria al else y luego la cambiamos
             de nuevo para que entre al if*/
            if (estadoNivel2 == false) {
                
                var array = document.getElementsByClassName("serv_2");
                var i = 0;
                for (i = 0; i < array.length; i++) {
                    var id = $(array[i]).attr("id");
                    if (id == idServicioSelected) {
                        array[i].style.display = "block";
                    } else {
                        array[i].style.display = "none";
                    }
                }
                /*fadeIn =  le asignamos por css: display:block con animacion*/
                /*fadeOut =  le asignamos por css: display:none con animacion*/

                $(".nivel_2").fadeIn();
                $(".nivel_3").fadeOut();
                estadoNivel2 = true;
            }
            else {
                $(".nivel_2").fadeOut();
                $(".nivel_3").fadeOut();
                estadoNivel2 = false;
            }
        }
        else if (nivel == 2) {
            if (estadoNivel3 == false) {

                var array = document.getElementsByClassName("serv_3");
                var i = 0;
                for (i = 0; i < array.length; i++) {
                    var id = $(array[i]).attr("id");
                    if (id == idServicioSelected) {
                        array[i].style.display = "block";
                    } else {
                        array[i].style.display = "none";
                    }
                }

                $(".nivel_3").fadeIn();
                estadoNivel3 = true;
            } else {
                $(".nivel_3").fadeOut();
                estadoNivel3 = false;
            }
        }
    });



</script>

<jsp:include page="../plantillas/solicitante/footer.jsp"/>
