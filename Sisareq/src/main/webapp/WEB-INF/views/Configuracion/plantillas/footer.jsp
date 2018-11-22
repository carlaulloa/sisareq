<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                <footer class="main-footer">
                    <div class="pull-right hidden-xs">
                        <b>Version</b> 1.1.0
                    </div>
                    <strong>Copyright &copy; 2016 <a href="#">UNSMS-FISI "Ingeniería de Software Modulo de Configuración"</a>.</strong> All rights reserved.
                </footer>
                <div class="control-sidebar-bg"></div>
            </div>        
        <script src="<c:url value="/resources/js/jQuery-2.1.4.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>
        <script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/js/raphael-min.js"/>"></script>
        <script src="<c:url value="/resources/js/morris.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery.sparkline.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery-jvectormap-1.2.2.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery-jvectormap-world-mill-en.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery.knob.js"/>"></script>
        <script src="<c:url value="/resources/js/moment.min.js"/>"></script>
        <script src="<c:url value="/resources/js/daterangepicker.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap-datepicker.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap3-wysihtml5.all.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery.slimscroll.min.js"/>"></script>
        <script src="<c:url value="/resources/js/fastclick.min.js"/>"></script>
        <script src="<c:url value="/resources/js/app.min.js"/>"></script>
        <script src="<c:url value="/resources/js/dashboard.js"/>"></script>
        <script src="<c:url value="/resources/js/demo.js"/>"></script>
    </body>
</html>

