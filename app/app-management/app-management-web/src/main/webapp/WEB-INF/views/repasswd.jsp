<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="common/base.jsp"%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>密码修改页面</title>
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

      <div class="form-signin" role="form">
        <h2 class="form-signin-heading">密码修改</h2>
        用户名:<input id="username" type="text" class="form-control" placeholder="用户名" required autofocus value="">
        
        老密码:<input id="password1" type="password" class="form-control" placeholder="老密码" required value="">
        新密码:<input id="password2" type="password" class="form-control" placeholder="新密码" required value="">
        <button id="repasswd" class="btn btn-lg btn-primary btn-block" type="submit">修改</button>
      </div>
	
		<div id="returnInfo" style="color:red;text-align:center"></div>
    </div>
	<script src="<%=basePath%>/js/requirejs/require.js" data-main="<%=basePath%>/js/repasswd"></script>
</body>
</html>
