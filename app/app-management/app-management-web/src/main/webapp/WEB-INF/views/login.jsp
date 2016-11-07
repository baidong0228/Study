<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="common/base.jsp"%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>登录页面</title>
	<!-- Bootstrap -->
	<link href="<%=basePath%>/dist/css/bootstrap.min.css" rel="stylesheet">
	<!--你自己的样式文件 -->
	<!-- <link href="<%=basePath%>/css/your-style.css" rel="stylesheet">    -->
	<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
	<!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	        <![endif]-->
	<link href="<%=basePath%>/css/login.css" rel="stylesheet">
</head>
<body>
	<div class="container">

      <form id="loginForm" class="form-signin" role="form" action="<%=path%>/controller/login/login" method="post">
        <h2 class="form-signin-heading">登录</h2>
        用户名:<input id="username" name="username" type="text" class="form-control" value="">
        密码: <input id="password" name="password" type="password" class="form-control" value="">
        <button id="login" class="btn btn-lg btn-primary btn-block" type="button">登录</button>
      </form>

		<div id="returnInfo" style="color:red;text-align:center">${loginInfo}</div>
	</div>
	<script src="<%=basePath%>/js/requirejs/require.js" data-main="<%=basePath%>/js/login"></script>
</body>
</html>
