<%@ page language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/static";
%>
<html>
<head>
</head>
<body>
<script type="text/javascript">
    //auth
    var path = "<%=path%>";
    //http://127.0.0.1:8080/auth/static
    var basePath = "<%=basePath%>";
    var config = path + "/static/js/requirejs/config.js";
</script>
</body>
</html>
