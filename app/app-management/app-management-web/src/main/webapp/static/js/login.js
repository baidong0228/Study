requirejs([config],function(){
		requirejs(['jquery','utils'],function($,utils){
			/* utils.test1(); */
			$("#login").click(function(){
				var  username=$("#username").val();
				var  password=$("#password").val();
				var	 returnInfo =$("#returnInfo");
				if(username==null||""==username){
					returnInfo.show();
					returnInfo.html("请输入用户名！");
				}
				//密码校验
				if(password==null||""==password){
					returnInfo.show();
					returnInfo.html("请输入密码！");
				}
				$("#loginForm").submit();
			});
		});
	});