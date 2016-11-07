requirejs([config],function(){
		requirejs(['jquery','utils'],function($,utils){
			$("#kimoji").click(function(){
				$.ajax({
					method: "POST",
					url: path+"/controller/user/kimoji",
					data: {
						"pageIndex" : 1,
						"pageSize" : 3,
					},
					success:function(data,status,jqXHR){
						var info ;
						var avstars =data.rows;
						for(var i=0;i<avstars.length;i++){
							info =info+ "<tr><td>"+avstars[i].id+"</td><td>"+avstars[i].chinesename+"</td><td>"+avstars[i].englishname+"</td><td>"+avstars.birthday+"</td><td>"+avstars[i].height+"</td><td>"+avstars[i].measurements+"</td><td>"+avstars[i].cup+"</td><td>"+avstars[i].mosaic+"</td></tr>";
						}
						$("#returnInfo").html(info);
					}
				}); // end ajax
			});
		});
	});