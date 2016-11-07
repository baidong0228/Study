requirejs([config],function(){
	requirejs(['jquery'],function($,bootstrap){
		//密码校验
		$("#repasswd").click(function(){
			var  username=$("#username").val();
			var  passwordOld=$("#password1").val();
			var  passwordNew=$("#password2").val();
			if(username==null||""==username){
				$("#returnInfo").show();
				$("#returnInfo").html("请输入用户名！");
				return;
			}
			if(passwordOld==null||""==passwordOld){
				$("#returnInfo").show();
				$("#returnInfo").html("请输入旧密码！");
				return;
			}
			if(passwordNew==null||""==passwordNew){
				$("#returnInfo").show();
				$("#returnInfo").html("请输入新密码！");
				return;
			}
			
			$.ajax({
				method: "POST",
				url: path+"/LoginController/repasswd",
				data: {
					"username" : username,
					"passwordOld" : passwordOld,
					"passwordNew" : passwordNew
				},
				success:function(data,status,jqXHR){
					$("#returnInfo").show();
					$("#returnInfo").html(data.returnInfo);
				}
			}); // end ajax
		});
	}); 
});