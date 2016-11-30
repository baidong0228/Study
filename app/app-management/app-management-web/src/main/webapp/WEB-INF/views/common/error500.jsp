<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="base.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>错误页面</title>
    <!-- Bootstrap -->
    <link href="<%=basePath%>/dist/css/bootstrap.min.css" rel="stylesheet">
    <!--你自己的样式文件 -->
    <!-- <link href="<%=basePath%>/css/your-style.css" rel="stylesheet">    -->
    <!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="<%=basePath%>/css/welcome.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right" role="tablist">
            <li role="presentation" class="active"><a href="#">Home</a></li>
        </ul>
        <h3 class="text-muted">Auth</h3>
    </div>

    <div class="jumbotron">
        <h2>ERROR500，系统出错啦，程序猿正在抢修！</h2>
    </div>

    <div class="footer">
        <p>&copy; 2016</p>
    </div>

</div> <!-- /container -->
</body>
</html>
