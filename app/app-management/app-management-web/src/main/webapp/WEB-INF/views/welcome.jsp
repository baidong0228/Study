<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="common/base.jsp"%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>欢迎页面</title>
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
          <li role="presentation" class="active"><a href="<%=path%>/repasswd.jsp">修改密码</a></li>
          <li role="presentation" class="active"><a href="<%=path%>/controller/login/logOut">登出</a></li>
        </ul>
        <h3 class="text-muted">Auth</h3>
      </div>

      <div class="jumbotron">
        <h1>Welcome</h1>
      </div>

      <div class="row marketing">
        <div class="col-lg-6">
          <h4>登录名</h4>
          <p>${userVO.username}</p>

          <h4>姓名</h4>
          <p>${userVO.fullname}</p>

          <h4>登录时间</h4>
          <p>${userVO.loginDate}</p>
          
          <h4>组织机构编码</h4>
          <p>${userVO.groupCode}</p>
        </div>

        <div class="col-lg-6">
          <h4>组织机构名称</h4>
          <p>${userVO.groupName}</p>

          <h4>组织机构编码路径</h4>
          <p>${userVO.groupCodePath}</p>

          <h4>组织机构名称路径</h4>
          <p>${userVO.groupNamePath}</p>
        </div>
      </div>
      <button id="kimoji" class="btn btn-lg btn-primary btn-block" type="button">Kimoji</button>
      <div>
      	<table class="table">
      		<caption>avstar</caption>
      		<thead>
      			<tr>
      				<th>序号</th>
      				<th>中文名</th>
      				<th>英文名</th>
      				<th>出生日期</th>
      				<th>身高</th>
      				<th>三围</th>
      				<th>罩杯</th>
      				<th>马赛克</th>
      			</tr>
      		</thead>
      		<tbody id="returnInfo">
      		</tbody>
      	</table>
      </div>

      <div class="footer">
        <p>&copy; 2016</p>
      </div>

    </div> <!-- /container -->
    <script src="<%=basePath%>/js/requirejs/require.js" data-main="<%=basePath%>/js/welcome"></script>
</body>
</html>
